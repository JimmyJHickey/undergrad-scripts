int LEDPin = 6;

void setup() {
  pinMode(LEDPin, INPUT);
}

void loop() {
  float temp_input1 = analogRead(A5);
  float temp_in_millivolts1 = temp_input1 * (3.3/1024.0);
  float temp_in_C1 = (temp_in_millivolts1-.5)*10 ; // Convert from voltage to degrees C
  float temp_in_F1 = (temp_in_C1 *1.8) + 32; // Convert from C to F

  float temp_input2 = analogRead(A4);
  float temp_in_millivolts2 = temp_input2 * (3.3/1024.0);
  float temp_in_C2 = (temp_in_millivolts2-.5)*10 ; // Convert from voltage to degrees C
  float temp_in_F2 = (temp_in_C2 *1.8) + 32; // Convert from C to F

  // Turn LED on if the temp is higher than 98 degrees 
  if (temp_in_F1 <= 98 && temp_in_F2 <= 98 )
    digitalWrite(LEDPin, HIGH);
  // Turn LED off if the temp is higher than 100 degrees
  else if (temp_in_F1 >=100 && temp_in_F2 >=100)
    digitalWrite(LEDPin, LOW);
  

}
