// Use 3.3 volts as input to the tmp36

#include <SPI.h>
#include <SD.h>
#include <Wire.h>
#include "RTClib.h"

const int chipSelect = 10;
RTC_DS1307 RTC;
void setup() {
  Wire.begin();
  RTC.begin();
  Serial.begin(9600);
  while (!Serial) {
    ; // wait for serial port to connect. Needed for native USB port only
  }


  Serial.print("Initializing SD card...");

  // see if the card is present and can be initialized:
  if (!SD.begin(chipSelect)) {
    Serial.println("Card failed, or not present");
    // don't do anything more:
    return;
  }
  Serial.println("card initialized.");

    // Write columm headers
 File  dataFile= SD.open("datalog.txt", FILE_WRITE);

     dataFile.println("Temp_C,Hour,Minute,Sec"); // Write to the file
     dataFile.close(); // Close the file
}

void loop() {
  DateTime now = RTC.now();
  // make a string for assembling the data to log:
  String dataString = "";

 // Get data
    float temp_input = analogRead(A5);
    
    // Store time
    int time_hour = now.hour();
    int time_min = now.minute();
    int time_sec = now.second();

    float temp_in_millivolts = temp_input * (3.3/1024.0);
    float temp_in_C = (temp_in_millivolts-.5)*10 ; // Convert from voltage to degrees C

    // Put data in CSV format
    dataString+=temp_in_C;
    dataString+=",";
    dataString+=time_hour;
    dataString+=",";
    dataString+=time_min;
    dataString+=",";
    dataString+=time_sec;
  // open the file. note that only one file can be open at a time,
  // so you have to close this one before opening another.
  File dataFile = SD.open("datalog.txt", FILE_WRITE);

  // if the file is available, write to it:
  if (dataFile) {
    dataFile.println(dataString);
    dataFile.close();
    // print to the serial port too:
    // Serial.println(dataString);
  }
  // if the file isn't open, pop up an error:
  else {
    // Serial.println("error opening datalog.txt");
  }
}





