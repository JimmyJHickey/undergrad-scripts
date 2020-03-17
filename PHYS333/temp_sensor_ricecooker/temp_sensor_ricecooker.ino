int LEDPin = 6;
int LEDPin2 = 7;

void setup() {
  pinMode(LEDPin, INPUT);
  pinMode(LEDPin2, INPUT);
}


void loop() {
  float temp_input = analogRead(A5);
  float temp_in_millivolts = temp_input * (3.3/1024.0);
  float temp_in_C = (temp_in_millivolts-.5)*10 ; // Convert from voltage to degrees C
  float temp_in_F = (temp_in_C *1.8) + 32;

  // Turn LED on if the temp is higher than 98 degrees 
  if (temp_in_F <= 98 && temp_if_F <100)
    digitalWrite(LEDPin, HIGH);
  // Turn LED off if the temp is higher than 100 degrees
  else if (temp_in_F >=100)
    digitalWrite(LEDPin2, HIGH);
  

}
