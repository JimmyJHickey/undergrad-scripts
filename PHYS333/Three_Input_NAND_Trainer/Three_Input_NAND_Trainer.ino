/*
 * Jimmy Hickey
 * Use three switches on the trainer as inputs.
 * NAND them to light an LED.
 */

// the setup routine runs once when you press reset:
void setup() {
 pinMode(7, INPUT); //Trainer switch pin 1
 pinMode(6, INPUT); //Trainer switch pin 2
 pinMode(5, INPUT); //Trainer switch pin 3
 pinMode(12, OUTPUT); //LED Pin
}

// the loop routine runs over and over again forever:
void loop() {
  if(!(digitalRead(7)&&digitalRead(6)&&digitalRead(5))){
    digitalWrite(12,HIGH);
  }
  else{
    digitalWrite(12,LOW);
  }
}
