/*
 simple_pwm_example
 Nathan Moore
 2016 Jan 19

 From the documentation, delayMicroseconds() will work for long values
 in the range 3 - ~16k.  This means I can use this to create a very smooth
 analog output function.

 Human vision is frequency limited to signals slower than 100Hz (it varies considerably, 
 see https://en.wikipedia.org/wiki/Flicker_fusion_threshold ), so I'm going to take the 
 timeperiod associated with 100Hz (1/100 sec, 10ms) and break it up into an non-symmetric
 square wave.  The wave will look like:
  High for t in [0,p]
  Low for t in [p,10ms]
 p is a time (integer?) - lets break it into a fidelity of 512 intervals, eg p_i in [0,511],
 and then scale it to 10ms, via the relation:
  p = 10ms*(p_i/511)

  Another way to think of it is to say that we have a signal of frequency 100Hz (Period = 10ms), 
  and the signal has a variable duty-cycle, where duty variaes from 0 to 511 (or 0% to 100%)

  This approach to emulating analog signals is called "pulse-width modulation".  
  The Arduino implements something like this in the AnalogWrite() command
  
  Check:  If the Arduino is a 5v system, pin 13 should output an "analog" seeming
  value of 5v*(duty/511), so
    duty=120 should give 1.17v
    duty=400 should give 3.91v, etc
  */

int printed;

void setup() {
  // initialize digital pin 12 as an output.
  pinMode(12, OUTPUT);
  Serial.begin(9600);
  printed=0;  // need to print an informational message the first time
}

void loop() {

  // cycle period
  int cycle_T = 10000; // 10k us or 10ms

  // cycle duty, [0,511]
  int duty = 120;
  
  // compute the number of us that the signal should be on.
  //int p=(cycle_T*duty)/511; // this doesn't work
  //
  //int p=cycle_T*(duty/511); // this doesn't work either
  //
  //long p=(cycle_T*duty)/511;  // this doesn't work
  //
  //long p=(cycle_T*duty*1L)/511;  // this doesn't work
  //
  long p=(1L*cycle_T*duty)/511;  // this does work
  //
  //int p=cycle_T*(duty/511.);   // this would also work

  
  digitalWrite(13, HIGH);
  delayMicroseconds(p);
  digitalWrite(13, LOW); 
  delayMicroseconds(cycle_T-p);           

  if(printed==0) {
    Serial.print("cycle_T (us) = ");
    Serial.println(cycle_T);
    Serial.print("p (us) = ");
    Serial.println(p);
    Serial.print("duty (x/511) =  ");
    Serial.println(duty);
    Serial.print("This corresponds to  voltage level of ");
    Serial.print((float)p*5.0/cycle_T);
    Serial.println(" (volts) on pin 13\n");
    printed=1;
  }
  
}
