/*
 * Jimmy Hickey
 * Read in a variable voltage to find the cutoff for "HIGH".
 */

void setup() {
  pinMode(10, INPUT);
  Serial.begin(9600);

}

void loop() {
  if(digitalRead(10)){
    Serial.println("High");
  }
  else{
    Serial.println("Low");
  }
  delay(500);
}
