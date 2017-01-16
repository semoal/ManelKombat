import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hadouken here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hadouken extends Personaje {
 /**
  * Act - do whatever the Hadouken wants to do. This method is called whenever
  * the 'Act' or 'Run' button gets pressed in the environment.
  */
 private int timer;
 boolean check = true;  //indica si es pot utilitzar
 Actor hadouken;
 Actor enemy;
 String mirar = "izquierda";
 GreenfootImage hado = new GreenfootImage("Sprite Ryu/HadoukenBolt.png");
 public void act() {
   hadouken = getWorld().getObjects(Hadouken.class).get(0);
   if (check) {
    switch (getWorld().getObjects(Jugador2.class).get(0).sryu) {
     case "left":
      mirar = "izquierda";
      break;
     case "right":
      mirar = "derecha";
      break;
    }
    check = false;
   }
   switch (mirar) {
    case "izquierda":
     setLocation(getX() - 20, getY());
     hado = new GreenfootImage("Sprite Ryu/HadoukenBoltLeft.png");
     break;
    case "derecha":
     setLocation(getX() + 20, getY());
     hado = new GreenfootImage("Sprite Ryu/HadoukenBolt.png");
     break;

     }
   hado.scale(100, 100);
   setImage(hado);
   checkBoundaries();
  }

 public void checkBoundaries() {
   if (isAtEdge()) {
    getWorld().removeObject(hadouken);
   }
  }
}