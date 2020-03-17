#include <Wire.h>
#include "RTClib.h"

int buttonPin = 7;
RTC_DS1307 RTC;


void setup() {  
  Serial.begin(9600);
  Wire.begin();
  RTC.begin();
  RTC.adjust(DateTime(__DATE__, __TIME__));

  pinMode(buttonPin, INPUT);
}

void loop() {

  if(digitalRead(buttonPin)){
     RTC.adjust(DateTime(2016,4,13,11,50,0));
  }
    DateTime now = RTC.now();

      Serial.println("The time is: ");
     Serial.print(now.hour(), DEC);
     Serial.print(":");
     Serial.print(now.minute(), DEC);
     Serial.print(":");
     Serial.print(now.second(), DEC);
     Serial.print("\n");
     delay(500);

}
