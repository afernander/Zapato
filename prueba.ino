
#include <SimpleTimer.h>
#include <BlynkSimpleEsp8266.h>
#include <Ticker.h>
Ticker flipper;
int d=0;
void setup() {
  // put your setup code here, to run once:
  Serial.begin(115200);
  flipper.attach(60,Sendata);

}
void Sendata(){
  Serial.println(d);
  d=0;
  }

void loop() {
  // put your main code here, to run repeatedly:
  int sensorValeu=analogRead(A0);

  if(sensorValeu>800){
    d=d+1;
    while(sensorValeu>800){
      sensorValeu=analogRead(A0);
      }
    }
    delay(1);

}
