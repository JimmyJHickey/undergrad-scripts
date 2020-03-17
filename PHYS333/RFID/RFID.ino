/*
 * Jimmy Hickey
 * Store up to 4 RFID IDs
 * When another is read, check it against the pre-approved list of stored IDs
 * If the read ID is in the list access will be granted, otherwise it will be denied.
 * 3 switches control the change of stored IDS.
 * Swtich 1: bit 1 of the list of IDS
 * Switch 2: bit 0 of the list of IDS
 * Switch 3: saftey switch. If on an ID can be changed, otherwise (regardless of the other two switches) the IDs will stay the same.
 */


#include <Wire.h>
#include <SPI.h>
#include <Adafruit_PN532.h>
#include "rgb_lcd.h"

// Create LCD
rgb_lcd lcd;

// If using the breakout or shield with I2C, define just the pins connected
// to the IRQ and reset lines.  Use the values below (2, 3) for the shield!
#define PN532_IRQ   (2)
#define PN532_RESET (3)  // Not connected by default on the NFC Shield

// Array that will hold the four accepted IDs
uint32_t acceptedIDs[4] = {0, 0, 0, 0};

// Or use this line for a breakout or shield with an I2C connection:
Adafruit_PN532 nfc(PN532_IRQ, PN532_RESET);

// If high, the user will be able to change the accepted IDs
int change_switch_pin = 5;

// Two switches to choose which ID to change
// 00 = 0, 01 = 1, 10 = 2, 11 = 3
int switch1_pin = 6;
int switch2_pin = 7;

void setup() {
  Serial.begin(9600);
  nfc.begin();

  // set up the LCD's number of columns and rows:
  lcd.begin(16, 2);
  lcd.setRGB(255,255,255);

  pinMode(change_switch_pin, INPUT);
  pinMode(switch1_pin, INPUT);
  pinMode(switch2_pin, INPUT);
  
  // configure board to read RFID tags
  nfc.SAMConfig();

}

unsigned digit = 0;

void loop() {
  
 lcd.setRGB(255,255,255);
 lcd.clear();
 lcd.print("Waiting for card");
 
 int change = digitalRead(change_switch_pin);
 int sw1 = digitalRead(switch1_pin);
 int sw2 = digitalRead(switch2_pin);
 Serial.print(change); 
 Serial.print(" ");
 Serial.print(sw1); 
 Serial.print(" ");
 Serial.println(sw2);

 // Assign an ID to slot 0
 if (change && !sw1 && !sw2){
    acceptedIDs[0] = findCard();
 }

  // Assign an ID to slot 1
 if (change && sw1 && !sw2){
    acceptedIDs[1] = findCard();
 }

  // Assign an ID to slot 2
 if (change && !sw1 && sw2){
    acceptedIDs[2] = findCard();
 }

  // Assign an ID to slot 3
 if (change && sw1 && sw2){
    acceptedIDs[3] = findCard();
 }

 // Store the ID of the card being read
 uint32_t inputID = findCard();

 boolean allowedCard = false;
 
 // Check if the ID is in the list
 for (int i = 0; i <= 3; i++){
  Serial.print("Array position "); Serial.print(i); Serial.print(" "); Serial.print(acceptedIDs[i]); Serial.print("\n");
  
  if (acceptedIDs[i] == inputID){
    allowedCard = true;
  }
 }

 // If card ID is in the list of allowed cards
 if (allowedCard){
  lcd.setRGB(0,0,255);
  lcd.clear();
  lcd.print("Access Granted");
  delay(2000);
 }
 else{
  lcd.setRGB(255,0,0);
  lcd.clear();
  lcd.print("Access Denied");
  delay(2000);
 }

}

uint32_t findCard(){
  uint8_t success;                          // Flag to check if there was an error with the PN532
  uint8_t uid[] = { 0, 0, 0, 0, 0, 0, 0 };  // Buffer to store the returned UID
  uint8_t uidLength;                        // Length of the UID (4 or 7 bytes depending on ISO14443A card type)

  uint32_t cardidentifier = 0;

 // Looks for ISO1443A cards
 // Populated uid with their ID
 // Marks their uid Length of either 4 bytes or 7 bytes
  success = nfc.readPassiveTargetID(PN532_MIFARE_ISO14443A, uid, &uidLength);

  if(success){
    // Serial.print("Card detected with ID: ");
    
    // turn the four byte UID of a mifare classic into a single variable #
    cardidentifier = uid[3];
    cardidentifier <<= 8; cardidentifier |= uid[2];
    cardidentifier <<= 8; cardidentifier |= uid[1];
    cardidentifier <<= 8; cardidentifier |= uid[0];
   
    // Serial.println(cardidentifier);
    return(cardidentifier);
  }
}

