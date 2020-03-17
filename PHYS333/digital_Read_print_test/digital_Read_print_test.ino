int i = 0;
void setup() {
  pinMode(7,INPUT);
  Serial.begin(9600);
}

void loop() {

// This works!
  
  if(digitalRead(7)){
    Serial.println(i);
    i++;}
  else{
    i=0;
    Serial.print(digitalRead(7));
    Serial.print("Nope \n");}
delay(10);
}
