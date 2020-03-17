/*
 * Jimmy Hickey
 * 
 * Read a morse code input signal.
 * Inputs: Input device clock
 *         Morse code message
 *      
 * Outputs: Print of the decoded message
 * 
 */

int clk_in_pin= 12;
int signal_in_pin=13;
String encrypted_signal;
// Time length d
int d=100;

void setup() {
  
 Serial.begin(19200);

 pinMode(clk_in_pin, INPUT);
 pinMode(signal_in_pin, INPUT);

}

void loop() {
  //encrypted_signal = read_morse_code(clk_in_pin, signal_in_pin, d);
  read_morse_code(clk_in_pin, signal_in_pin, d);
  Serial.println("function completed\n"); 
  //decode_morse_string(encrypted_signal);
}


// Read the dots, dashes, and spaces
void read_morse_code(int clk_in_pin,int signal_in_pin, int d){
  
  // String of dots, dashs, or a space type
  String encrypted_signal = "";

  // Interger to distinguish between dots and dashes
  // Length of 2.5 * d
  int larger_d = 2.5 * d;
  
  // Time of first high, time of second high, and time between them.
  int high1, high2, low, dt = 0;
  
while (true){
  // Read when the clock is rising
  if(digitalRead(clk_in_pin)){

    if(digitalRead(signal_in_pin)){
      
    // If the signal is high and the first high has not been found
        if(high1 == 0){
        high1 = millis();   // Set the first high to the current time
        }
      
      // If the signal is high, the low has been found, and the second high has not been found
      else if((low==1) && (high2 == 0)){
        high2 = millis();   // Set the second high to the current time.
      }        
    }

    // If the signal is low, the first high has been found, and the low has not been found
    if(!digitalRead(signal_in_pin)){
        if((high1 == 0) && (low == 0)){
          low = 1;    // The low has been found
        }
    }
   
  }
 
  
  // If both highs have been found
  if((high1 != 0) && (high2 != 0)){
    dt = high2 - high1; //Set dt to the time in between the highs
  }


  // Debug printing
  if(dt != 0){
    Serial.print("high1 2 = "); // Print for Debugging 
    Serial.println(high1);    // Print for Debugging
    Serial.print("high2  2 = "); // Print for Debugging 
    Serial.println(high2);    // Print for Debugging 
  }
  
  // If the time between highs is longer than 2.5*d it should be a dash
  if(dt >= larger_d){
    encrypted_signal = encrypted_signal + "-"; // append a dash to the character
    high1 = high2 = low = dt = 0; // Reset the timers
    Serial.println("Found a -"); // Print for debugging
    //return '-';
  }

  // if dt is not 0 and is less than 2.5*d it should be a dot
  if(dt != 0 && dt < larger_d){
    encrypted_signal = encrypted_signal + "."; // append a dot the to character
    high1 = high2 = low = dt = 0; // Reset the timers
    Serial.println("Found a ."); // Print for debugging
    //return '.';
  }
        
  }
 }


//Print the characters/spaces
void decode_morse_string(String encrypted_signal){
  if(encrypted_signal == "Message space")
    Serial.println("\n");
  else if(encrypted_signal == "Word Space")
    Serial.print(" ");
  else if(encrypted_signal == ".-")
    Serial.print("a");
}


