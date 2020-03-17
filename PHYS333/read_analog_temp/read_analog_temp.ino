#define input_signal A1
int input_voltage;

void setup() {
  Serial.begin(9600);

}

void loop() {
 
  input_voltage = analogRead(input_signal);
  Serial.print("Input voltage: ");
  Serial.println(input_voltage);

}
