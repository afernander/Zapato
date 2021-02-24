const int ledPIN = D2;
int cont2=0;
void setup() {
  // put your setup code here, to run once:
Serial.begin(9600);
pinMode(ledPIN , OUTPUT);
}



void loop() {
  // put your main code here, to run repeatedly:
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
}
