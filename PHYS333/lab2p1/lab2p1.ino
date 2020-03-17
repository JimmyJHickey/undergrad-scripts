/*
 * Lab 2 Problem 1
 * 
 * PWM function
 * 
 * Jimmy Hickey
 * 26/1/16
 * 
 */
const int ledPin=7;
void setup() {
 pinMode(ledPin,OUTPUT);
 Serial.begin(9600);
  PWM(1000, 100); //call the PWM function
  PWM(1000, 1000); //call the PWM function
  PWM(100, 10000); //call the PWM function and get an error
}

void loop() {
  
  PWM(1000, 1000); //call the PWM function
}

void PWM(long cycles, long duty){
 //Case that takes care of the duty being too high
  if(duty>1000){
    Serial.print("Duty too high. Choose a number between 1 and 1000.");
  }
  else{
  long period=10000; //Make the period 10,000 microseconds
  long on=period*duty/1000; //Decide how long the it will be on for
                           //This will be duty/1000 parts of the 
                           //total period
  //Print out out info
  Serial.print("The period is: ");
  Serial.println(period);
  Serial.print("The on time is: ");
  Serial.println(on);
  Serial.print("The duty is: ");
  Serial.print(duty);
  Serial.println("/1000");
  Serial.print("The votlage level is: ");
  Serial.print((float)on*5.0/period);
  Serial.println(" volts on pin ledPin");
  
  for(int i=0; i<=cycles; i++){
    digitalWrite(ledPin,HIGH);
    delayMicroseconds(on);
    digitalWrite(ledPin,LOW);
    delayMicroseconds(period-on);
  }
  }
}


