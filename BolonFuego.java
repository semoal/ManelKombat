import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BolonFuego here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BolonFuego extends Personaje {
 int speed = 10;
 boolean check = true;
 GreenfootImage fuego = new GreenfootImage("Sprite Scorpion/BOLONDEFUEGO.png");
 String dir;
 /**
  * Act - do whatever the BolonFuego wants to do. This method is called whenever
  * the 'Act' or 'Run' button gets pressed in the environment.
  */
 public void act() {

  if (check) {
   switch (getWorld().getObjects(Jugador1.class).get(0).mirar) {
    case "izquierda":
     fuego = new GreenfootImage("Sprite Scorpion/BOLONDEFUEGOR.png");
     dir = "izquierda";
     break;
    case "derecha":
     fuego = new GreenfootImage("Sprite Scorpion/BOLONDEFUEGO.png");
     dir = "derecha";
     break;
   }
  }
  fuego.scale(100, 100);
  setImage(fuego);
  switch (dir) {
   case "izquierda":
    setLocation(getX() - 20, getY());
    break;

   case "derecha":
    setLocation(getX() + 20, getY());
    break;
  }

  check = false;
  if (isAtEdge()) {
   getWorld().removeObject(this);
  }
 }
}