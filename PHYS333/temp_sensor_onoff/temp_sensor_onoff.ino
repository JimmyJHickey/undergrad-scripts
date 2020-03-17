int LEDPin = 6;

void setup() {
  Serial.begin(9600);
  pinMode(LEDPin, INPUT);
}

void loop() {
  float temp_input = analogRead(A5);
  float temp_in_millivolts = temp_input * (3.3/1024.0);
  float temp_in_C = (temp_in_millivolts-.5)*10 ; // Convert from voltage to degrees C
  float temp_in_F = (temp_in_C *1.8) + 32;

 

  // Turn LED off if the temp is higher than 100 degrees
  if (temp_in_F >=70){
    digitalWrite(LEDPin, LOW);
    Serial.println("Hotter than 70");
  }
  // Turn LED on if the temp is higher than 98 degrees 
  else if (temp_in_F >= 40){
    digitalWrite(LEDPin, HIGH);
     Serial.println("Temp in C: ");
  Serial.print(temp_in_C);
  }
  

}
