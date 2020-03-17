void setup() {
 Serial.begin(9600);
 pinMode(7,INPUT);

}

void loop() {
  Serial.print(digitalRead(7));
  delay(500);

}
