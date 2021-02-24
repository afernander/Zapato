#include <TFT.h>

#define LED_BUILTIN 2
#define BUTTON_BUILTIN 0 
#include <WiFi101.h>
#include <UbidotsArduino.h>

#define ID  "5ce96d3a1d847226ee895b0b"  // Put here your Ubidots variable ID
#define TOKEN  "BBFF-eoZT1k7qtXhftJV7Eet6yJaeHqgS2U"  // Put here your Ubidots TOKEN

int status = WL_IDLE_STATUS;
float tempC;
int pinLM35 = 5;
char ssid[] = "Iphone de Alejandro"; //  Nombre de la red al cual se van a conectar
char pass[] = "2345678910";    // Contraseña del WiFi al cual se van a conectar
int keyIndex = 0;            // your network key Index number (needed only for WEP)

Ubidots client(TOKEN);
void setup() { 
  Serial.begin(9600);

  // El LED integrado está conectado al pin 2.
  pinMode(LED_BUILTIN, OUTPUT);
  pinMode(BUTTON_BUILTIN, INPUT);
    while (!Serial) {
    ; // wait for serial port to connect. Needed for native USB port only
  }

  // check for the presence of the shield:
  // attempt to connect to Wifi network:
  while (status != WL_CONNECTED) {
    Serial.print("Attempting to connect to SSID: ");
    Serial.println(ssid);
    // Connect to WPA/WPA2 network. Change this line if using open or WEP network:
    status = WiFi.begin(ssid, pass);

    // wait 10 seconds for connection:
    delay(500);
    
pinMode(ledPIN , OUTPUT);
} 
 
void loop() {
  // Leer el estado del botón. Cuando está pulsado el pin se pone a nivel bajo 
  int estado = digitalRead(BUTTON_BUILTIN); 
  // Configurar el LED de acuerdo al estado del botón 
  digitalWrite(LED_BUILTIN, estado); 
    // Esperamos un tiempo para repetir el loop
  delay(1000);
  int cont = digitalRead(D1);

 
if(cont==1){
digitalWrite(ledPIN , HIGH);   // poner el Pin en HIGH
Serial.println("entro");
cont2++;
  delay(500); 
  // esperar un segundo
  digitalWrite(ledPIN , LOW);    // poner el Pin en LOW
  delay(500);   
}
Serial.println(cont2);
 // Mandamos los datos a ubidots.
   client.add(ID,cont);
   client.sendAll();
   analogRead(A0);
   Serial.print(A0/10);
   
}
