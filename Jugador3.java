import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ken here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador3 extends Personaje {
 GreenfootImage ken = new GreenfootImage("Sprite Ken/ken-static.png");
 String sken = "right";
 int speed = 20;
 int jump = 0;
 boolean punch = true;
 boolean pruebaPunch = true;
 boolean kick = true;
 boolean pruebaKick = true;
 boolean special = true;
 boolean pruebaSpecial = true;
 int numSpecial = 1;
 String state = "stand";
 Actor enemy;
 Actor me = this;
 boolean hadoukenTouch = false;
 boolean fuegoTouch = false;
 //Numero de jugador y teclas 
 String player;
 String tleft = checkLeft(player);
 String tright = checkRight(player);
 String tjump = checkJump(player);
 String tcrouch = checkCrouch(player);
 String tpunch = checkPunch(player);
 String tkick = checkKick(player);
 String tspecial = checkSpecial(player);

 public void act() {
  tleft = checkLeft(player);
  tright = checkRight(player);
  tjump = checkJump(player);
  tcrouch = checkCrouch(player);
  tpunch = checkPunch(player);
  tkick = checkKick(player);
  tspecial = checkSpecial(player);
  enemy = checkactor(me);
  pruebaPunch = true;
  pruebaKick = true;
  pruebaSpecial = true;
  //System.out.println(enemy);
  if (enemy != null) {
   if (enemy.getX() < getX()) {
    sken = "left";
   } else {
    sken = "right";
   }
   state = "stand";
   movement(speed);
   if (!isTouching(suelo.class)) {
    position("Sprite Ken/ken-salto-left.png", "Sprite Ken/ken-salto.png");

    gravity();
   } else {
    jump = 0;
   }
   if (state.indexOf("punch") > -1) {
    ken.scale(200, 200);
   } else {
    if (state.indexOf("kick") > -1) {
     ken.scale(200, 200);
    } else {
     if (state.indexOf("special") > -1) {
      ken.scale(180, 200);
     } else {
      ken.scale(130, 200);
     }
    }
   }


   impacto();



   setImage(ken);
  }
 }

 public void impacto() {
  if (isTouching(Hadouken.class)) {
   hadoukenTouch = true;
   getWorld().removeObject(getWorld().getObjects(Hadouken.class).get(0));
   getWorld().getObjects(vidaJugador3.class).get(0).vidaInicial -= 50;
  } else {
   hadoukenTouch = false;
  }
  if (isTouching(BolonFuego.class)) {
   fuegoTouch = true;
   getWorld().removeObject(getWorld().getObjects(BolonFuego.class).get(0));
   getWorld().getObjects(vidaJugador3.class).get(0).vidaInicial -= 50;
  } else {
   fuegoTouch = false;
  }

 }
 public void movement(int speed) {
  if (Greenfoot.isKeyDown(tleft)) {
   setLocation(getX() - speed, getY());
   state = "move";
  }
  if (Greenfoot.isKeyDown(tright)) {
   setLocation(getX() + speed, getY());
   state = "move";
  }
  if (Greenfoot.isKeyDown(tjump) && jump != 8) {
   setLocation(getX(), getY() - 50);
   if (!isTouching(suelo.class)) {
    jump++;
   }
  }
  if (Greenfoot.isKeyDown(tcrouch) && state == "stand") {
   state = "clutch";
  }
  if (Greenfoot.isKeyDown(tpunch) && state == "stand") {
   state += "-punch";
   if (punch) {
    punch = false;
    pruebaPunch = false;
   }
  } else {
   punch = true;
  }
  if (Greenfoot.isKeyDown(tkick) && state == "stand") {
   state += "-kick";
   if (kick) {
    kick = false;
    pruebaKick = false;
   }
  } else {
   kick = true;
  }
  if (Greenfoot.isKeyDown(tspecial) && state == "stand" && numSpecial > 0) {
   state += "-special";
   if (special) {
    special = false;
    pruebaSpecial = false;
   }
  } else {

  }
  switch (state) {
   case "stand":
    position("Sprite Ken/ken-static-left.png", "Sprite ken/ken-static.png");
    break;
   case "clutch":
    position("Sprite Ken/ken-agacha-left.png", "Sprite ken/ken-agacha.png");
    break;
   case "stand-punch":
    position("Sprite Ken/ken-puñetazo-left.png", "Sprite ken/ken-puñetazo.png");
    break;
   case "move":
    position("Sprite Ken/ken-static-left.png", "Sprite ken/ken-static.png");
    break;
   case "moving-punch":
    position("Sprite Ken/ken-static-left.png", "Sprite ken/ken-static.png");
    break;
   case "stand-kick":
    position("Sprite Ken/ken-patada-left.png", "Sprite ken/ken-patada.png");
    break;
   case "stand-special":
    switch (sken) {
     case "left":
      mirrorHorizontally();
      break;
     case "right":
      Special();
      break;
    }
    break;

  }

 }
 public void Special() {

  switch (numSpecial) {
   case 1:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-1.png");
    numSpecial = 2;
    break;
   case 2:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-2.png");
    numSpecial = 3;
    break;
   case 3:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-3.png");
    numSpecial = 4;
    break;
   case 4:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-4.png");
    numSpecial = 5;
    break;
   case 5:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-5.png");
    numSpecial = 6;
    break;
   case 6:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-6.png");
    numSpecial = 7;
    break;
   case 7:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-7.png");
    numSpecial = 8;
    break;
   case 8:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-8.png");
    numSpecial = 9;
    break;
   case 9:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-9.png");
    numSpecial = 10;
    break;
   case 10:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-10.png");
    numSpecial = 0;
    break;
   case 11:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-11.png");
    numSpecial = 12;
    break;
   case 12:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-12.png");
    numSpecial = 13;
    break;
   case 13:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-13.png");
    numSpecial = 14;
    break;
   case 14:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-14.png");
    numSpecial = 15;
    break;
   case 15:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-15.png");
    numSpecial = 16;
    break;
   case 16:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-16.png");
    numSpecial = 17;
    break;
   case 17:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-17.png");
    numSpecial = 18;
    break;
   case 18:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-18.png");
    numSpecial = 19;
    break;
   case 19:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-19.png");
    numSpecial = 20;
    break;
   case 20:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-20.png");
    numSpecial = 21;
    break;
   case 21:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-21.png");
    numSpecial = 22;
    break;
   case 22:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-22.png");
    numSpecial = 23;
    break;
   case 23:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-23.png");
    numSpecial = 24;
    break;
   case 24:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-24.png");
    numSpecial = 25;
    break;
   case 25:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-25.png");
    numSpecial = 26;
    break;
   case 26:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-26.png");
    numSpecial = 27;
    break;
   case 27:
    ken = new GreenfootImage("Sprite Ken/KenSpecial/ken-special-27.png");
    numSpecial = 1;
    break;
  }
 }
 public void mirrorHorizontally() {


  Special();
  ken.mirrorHorizontally();
 }
 public void position(String left, String right) {
  switch (sken) {
   case "right":
    ken = new GreenfootImage(right);

    break;
   case "left":
    ken = new GreenfootImage(left);

    break;
  }
 }

}