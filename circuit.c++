// C++ code
//
#include <Servo.h>
Servo myservo;  
int pos1 = 0; 

Servo myservo;  
int pos2 = 0; 

boolean A, B, C, D, E, F, G;
const int PIN_A = 11;
const int PIN_B = 12;
const int PIN_C = 10;
const int PIN_D = 9;
const int PIN_E = 8;
const int PIN_F = 7;
const int PIN_G = 6;
int counter = 0;
boolean buttonPressed = false;

void setup()
{
  pinMode(2, INPUT);
  pinMode(PIN_A, OUTPUT);
  pinMode(PIN_B, OUTPUT);
  pinMode(PIN_C, OUTPUT);
  pinMode(PIN_D, OUTPUT);
  pinMode(PIN_E, OUTPUT);
  pinMode(PIN_F, OUTPUT);
  pinMode(PIN_G, OUTPUT);
  myservo.attach(5);
  myservo.attach(4);
  Serial.begin(9600);
  attachInterrupt(digitalPinToInterrupt(2), onButtonPress, FALLING);
}

void displayNumber(int counter) {
  switch (counter){
    case 0: A=1; B=1; C=1; D=1; E=1; F=1; G=0; break;  // "0"
    case 1: A=0; B=1; C=1; D=0; E=0; F=0; G=0; break;  // "1"
    case 2: A=1; B=1; C=0; D=1; E=1; F=0; G=1; break;  // "2"
    case 3: A=1; B=1; C=1; D=1; E=0; F=0; G=1; break;  // "3"
    case 4: A=0; B=1; C=1; D=0; E=0; F=1; G=1; break;  // "4"
    case 5: A=1; B=0; C=1; D=1; E=0; F=1; G=1; break;  // "5"
    case 6: A=1; B=0; C=1; D=1; E=1; F=1; G=1; break;  // "6"
    case 7: A=1; B=1; C=1; D=0; E=0; F=0; G=0; break;  // "7"
    case 8: A=1; B=1; C=1; D=1; E=1; F=1; G=1; break;  // "8"
    case 9: A=1; B=1; C=1; D=1; E=0; F=1; G=1; break; 
    default: A=1; B=1; C=0; D=1; E=1; F=0; G=1; break;
  }
  digitalWrite(PIN_A, A);
  digitalWrite(PIN_B, B);
  digitalWrite(PIN_C, C);
  digitalWrite(PIN_D, D);
  digitalWrite(PIN_E, E);
  digitalWrite(PIN_F, F);
  digitalWrite(PIN_G, G);
}

void onButtonPress() {
  buttonPressed = true; 
  Serial.println(counter);
}

void rotate1() {
  for (pos1 = 0; pos1 <= 150; pos1 += 30) {
    myservo.write(pos1);        
    delay(1000);              
  }

  for (pos1 = 150; pos1 >= 0; pos1 -= 30) {
    myservo.write(pos1);        
    delay(1000);           
  }
}

void rotate2(){
  for (pos2 = 0; pos2 <= 150; pos2 += 30) {
    myservo.write(pos2);        
    delay(1000);              
  }

  for (pos2 = 150; pos2 >= 0; pos2 -= 30) {
    myservo.write(pos2);        
    delay(1000);           
  }    
}

void loop() {
  if (buttonPressed) {
    counter = (counter + 1) % 10;  
    displayNumber(counter-1);
    buttonPressed = false; 
  }
}
