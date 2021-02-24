
 int pulso;
 
 void setup() {
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
 pulso= analogRead(A0);
 pulso = pulso/10;
 
  Serial.println(pulso);
  delay(3000);
}
