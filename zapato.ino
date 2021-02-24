#include "UbidotsMicroESP8266.h"

#define ID  "5cec0e481d84722e97f10ca6"  // Aquí ponemos el ID de nuestra variable al que le vamos a mandar los datos (Se consulta en Ubidots)
#define TOKEN  "BBFF-eoZT1k7qtXhftJV7Eet6yJaeHqgS2U"  // Aquí ponemos el TOKEN de nuestra cuenta de Ubidots.


#define WIFISSID "Iphone de Alejandro" // Nombre de la red a la cual se van a conectar
#define PASSWORD "2345678910" // Contraseña de la red a la cual se van a conectar
Ubidots client(TOKEN);
const int vibrator=D5;
const int ledPIN = D2;
const int ledPIN2= D3;
const int ledPIN3= D4;
int cont2=0;
int pulso;
double peso=0;
void setup(){
    Serial.begin(9600);
    client.wifiConnection(WIFISSID, PASSWORD);
    //client.setDebug(true); // Uncomment this line to set DEBUG on
    pinMode(ledPIN , OUTPUT);  //definir pin como salida
  pinMode(ledPIN2, OUTPUT);
     pinMode(ledPIN3, OUTPUT);
     pinMode(vibrator,OUTPUT);
}

void loop() {



int pasos=botton();
if (pasos>=10){
  digitalWrite(ledPIN3 , HIGH);

  }
  int ritmo = pulsoR();
  if (ritmo>120){
    digitalWrite(ledPIN2 , HIGH);
    }
    if(ritmo<60){
        digitalWrite(vibrator,HIGH);
      }else{
         digitalWrite(vibrator,LOW);
        }
peso= 72,45;
 // Mandamos los datos a ubidots.
  client.add("Ritmo cardiaco",pulso);
   client.add("pasos",pasos);
   client.add("peso", peso);
   client.sendAll(true);
   //delay(1000);

}
int botton(){
  
  // put your main code here, to run repeatedly:
int cont = digitalRead(D1);

 
if(cont==1){
digitalWrite(ledPIN , HIGH);   // poner el Pin en HIGH
Serial.println("entro");
cont2++;
  delay(1000); 
  // esperar un segundo
  digitalWrite(ledPIN , LOW);    // poner el Pin en LOW
 // delay(1000);   
}
Serial.println(cont2);
return cont2;
  }

  int pulsoR() {
  // put your main code here, to run repeatedly:
 pulso= analogRead(A0);
 pulso = pulso/10;
 
  Serial.println(pulso);
  delay(500);
  return pulso;
}
