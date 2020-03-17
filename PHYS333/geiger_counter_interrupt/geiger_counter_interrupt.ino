// Not all pins can be used
// for interrupts. It depends on the board.
int geiger_counter_pin = 2;
int timer = 0;
int dt = 0;
volatile int print_state = LOW;

void setup() {
  pinMode(geiger_counter_pin, INPUT);
  Serial.begin(9600);
  attachInterrupt(digitalPinToInterrupt(geiger_counter_pin), blink, CHANGE);
}

void loop() {
 if(print_state){
  Serial.println(dt);
  print_state = LOW;
 }
 
}

void blink(){
  dt = millis() - timer;
  timer = millis();
  print_state = HIGH;
}
