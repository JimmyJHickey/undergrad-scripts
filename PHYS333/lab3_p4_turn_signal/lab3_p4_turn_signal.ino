/*
 * Jimmy Hickey
 * 
 * Lab 3 problem 4
 * 
 * Date: 26/2/16
 * 
 * Make a turn signals out of LEDS.
 * When a button is clicked, the LEDS will turn on/off in a "runway" pattern.
 * It will continue this as until the button is pressed again.
 * This will be duplicated, so there will be a right and left set of LEDS working
 * off of two buttons.
 * 
 */

const int left_button = 9; 
const int right_button = 6;   
 
int right_LED_pins[]={5,4,3,2};
int left_LED_pins[]={10,11,12,13};

bool right_pressed = false;
bool left_pressed= false;

void setup() {
  
  // A for loop that sets the LEDs to outputs
  // This will need to be split into two for loops if the arrays are
  //different sizes.
  for (int i=0; i <= 3; i++){
    pinMode(right_LED_pins[i], OUTPUT);
   pinMode(left_LED_pins[i],OUTPUT);
  }
  pinMode(left_button, INPUT);
  pinMode(right_button, INPUT);
}

void loop() {

if(digitalRead(right_button))
  right_pressed = !right_pressed;

if(digitalRead(left_button))
  left_pressed = !left_pressed;
  
  // check if the pushbutton is pressed.
  // if it is, the buttonState is HIGH:
  if (right_pressed) {
    Serial.println("In right button if");
    for(int i=0;i<=3;i++){
      digitalWrite(right_LED_pins[i],HIGH);
      delay(1000);
    }
    
    for(int i=3;i>=0;i--){
      digitalWrite(right_LED_pins[i],LOW);
    }
  }

if (left_pressed){
    for(int i=0;i<=3;i++){
      digitalWrite(left_LED_pins[i],HIGH);
      delay(1000);
    }
    
    for(int i=3;i>=0;i--){
      digitalWrite(left_LED_pins[i],LOW);
    }
  }

  //delay(1000);
}
