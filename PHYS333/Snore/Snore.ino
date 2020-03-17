/*
 * LED Snore
 * Jimmy Hickey
 * 
 * Make an LED dim and then brighten using a PWM routine.
 */

void setup() {
  // initialize digital pin 13 as an output.
  pinMode(13, OUTPUT);
}

// the loop function runs over and over again forever
void loop() {
  for(int i=100; i>=0; i--){
    digitalWrite(13, HIGH);   // turn the LED on (HIGH is the voltage level)
    delay(10*(i/100));         // wait
    digitalWrite(13, LOW);    // turn the LED off by making the voltage LOW
    delay(10*((100-i)/100));       //wait
  }
  
  for(int i=0; i<=100; i++){
    digitalWrite(13, HIGH);   // turn the LED on (HIGH is the voltage level)
    delay(10*(i/100));         // wait
    digitalWrite(13, LOW);    // turn the LED off by making the voltage LOW
    delay(10*((100-i)/100));       //wait
  }
  
}
