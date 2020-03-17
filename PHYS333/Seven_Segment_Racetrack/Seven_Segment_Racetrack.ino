/*
 * Seven Segment Racetrack
 * Jimmy Hickey
 * 
 * Make a non-lit segment of a seven segment display race around the outside ring of segments.
 */

//Make an array of pins to be used for the 6 segments
int seg[]={1,2,4,6,8,10};
void setup() {
  //Set all the pins to output
  pinMode(seg[0], OUTPUT);
  pinMode(seg[1], OUTPUT);
  pinMode(seg[2], OUTPUT);
  pinMode(seg[3], OUTPUT);
  pinMode(seg[4], OUTPUT);
  pinMode(seg[5], OUTPUT);

  //Intialize all the pins to HIGH/On
  digitalWrite(seg[0], HIGH);
  digitalWrite(seg[1], HIGH);
  digitalWrite(seg[2], HIGH);
  digitalWrite(seg[3], HIGH);
  digitalWrite(seg[4], HIGH);
  digitalWrite(seg[5], HIGH);
  
  
}

void loop() {
 //Go through the array
 for(int i=0; i<=5;i++){
   
   //Turn the current pin off
   digitalWrite(seg[i],LOW);
   
   //Turn the previous pin on
   if(i==0){
    digitalWrite(seg[5],HIGH);
   } 
   else{
    digitalWrite(seg[i-1],HIGH);
   }
   //Delay
   delay(200);
 }

}
