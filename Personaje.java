import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Personaje here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Personaje extends Actor {
 /**
  * Act - do whatever the Personaje wants to do. This method is called whenever
  * the 'Act' or 'Run' button gets pressed in the environment.
  */
 Actor wow;
 int i = 1;
 boolean check = true;
 public void act() {}

 public void gravity() {
  if (!isTouching(Suelos.class)) {
   setLocation(getX(), getY() + 25);
  }

 }
 public Actor checkactor(Actor me) {
 switch (i) {
   case 1:
    if (getWorld().getObjects(Jugador1.class).size() > 1) {
     wow = getWorld().getObjects(Jugador1.class).get(0);
    }
    break;
   case 2:
    if (getWorld().getObjects(Jugador2.class).size() > 1) {
     wow = getWorld().getObjects(Jugador2.class).get(0);
    }
    break;
   case 3:
    if (getWorld().getObjects(Jugador3.class).size() > 1) {
     wow = getWorld().getObjects(Jugador3.class).get(0);
    }
    break;
   case 4:
    if (getWorld().getObjects(Jugador4.class).size() > 1) {
     wow = getWorld().getObjects(Jugador4.class).get(0);
    }
    break;
  }

  if (wow != me && wow != null) {
   return wow;
  }
  i++;
  return null;
 }

 //MIRAMOS QUE JUGADOR HA ELEGIDO AL PERSONAJE Y LE ASIGNAMOS SUS TECLAS
 public String checkLeft(String player) {
  String left;
  if (player == "Jugador 1") {
   left = "LEFT";
  } else {
   left = "a";
  }
  return left;
 }
 public String checkRight(String player) {
  String right;
  if (player == "Jugador 1") {
   right = "RIGHT";
  } else {
   right = "d";
  }
  return right;
 }
 public String checkJump(String player) {
  String jump;
  if (player == "Jugador 1") {
   jump = "UP";
  } else {
   jump = "w";
  }
  return jump;
 }
 public String checkCrouch(String player) {
  String crouch;
  if (player == "Jugador 1") {
   crouch = "DOWN";
  } else {
   crouch = "s";
  }
  return crouch;
 }
 public String checkPunch(String player) {
  String punch;
  if (player == "Jugador 1") {
   punch = "1";
  } else {
   punch = "j";
  }
  return punch;
 }
 public String checkKick(String player) {
  String kick;
  if (player == "Jugador 1") {
   kick = "2";
  } else {
   kick = "k";
  }
  return kick;
 }
 public String checkSpecial(String player) {
  String special;
  if (player == "Jugador 1") {
   special = "3";
  } else {
   special = "l";
  }
  return special;
 }
}