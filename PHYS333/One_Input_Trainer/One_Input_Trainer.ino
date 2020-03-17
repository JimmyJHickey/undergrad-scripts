/*
 * Jimmy Hickey
 * Use a switch on the trainer as an input to the arduino.
 * Use this input to power an LED.
 */

// the setup routine runs once when you press reset:
void setup() {
 pinMode(5, INPUT); //Trainer switch pin
 pinMode(4, OUTPUT); //LED Pin
  Serial.begin(9600);
}

// the loop routine runs over and over again forever:
void loop() {
  if(digitalRead(5)){
    digitalWrite(4,HIGH);
  }
  else{
    digitalWrite(4,LOW);
  }
}
