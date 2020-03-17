
const int OutputPin=13;
void setup() {
  pinMode(OutputPin,OUTPUT);
 

}

void sawtooth(long period){
  for(long i=0;i<=period/2;i++){
      digitalWrite(OutputPin, HIGH);
      delayMicroseconds (i);
      digitalWrite(OutputPin,LOW);
      delayMicroseconds(period/2-i);
  }
  for(long i=period/2;i>=0;i--){
      digitalWrite(OutputPin, HIGH);
      delayMicroseconds(period/2-i);
      digitalWrite(OutputPin,LOW);
      delayMicroseconds(i);
  }
  
}

void loop() {
   sawtooth(2000);

}
