import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ryu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador2 extends Personaje {
 GreenfootImage ryu = new GreenfootImage("Sprite Ryu/ryu-static.gif");
 String sryu = "right";
 int speed = 20;
 int jump = 0;
 boolean punch = true;
 boolean pruebaPunch = false;
 boolean kick = true;
 boolean pruebaKick = false;
 boolean special = true;
 String state = "stand";
 Actor enemy;
 Actor me = this;
 boolean hadoukenTouch = false;
 boolean fuegoTouch = false;
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

  if (enemy != null) {
   pruebaPunch = true;
   pruebaKick = true;
   if (enemy.getX() < getX()) {
    sryu = "left";
   } else {
    sryu = "right";
   }
   state = "stand";
   movement(speed);
   if (!isTouching(suelo.class)) {
    position("Sprite Ryu/ryu-air-left.gif", "Sprite Ryu/ryu-air.gif");
    state = "jump";
    gravity();
   } else {
    jump = 0;
   }
   if (state.indexOf("punch") > -1) {
    ryu.scale(180, 200);
   } else if (state.indexOf("kick") > -1) {
    ryu.scale(180, 200);
   } else {
    ryu.scale(130, 200);
   }

   impacto();
   setImage(ryu);
  }
 }

 public void impacto() {
  if (isTouching(Hadouken.class)) {
   hadoukenTouch = true;
   getWorld().removeObject(getWorld().getObjects(Hadouken.class).get(0));
   getWorld().getObjects(vidaJugador2.class).get(0).vidaInicial -= 50;
  } else {
   hadoukenTouch = false;
  }
  if (isTouching(BolonFuego.class)) {
   fuegoTouch = true;
   getWorld().removeObject(getWorld().getObjects(BolonFuego.class).get(0));
   getWorld().getObjects(vidaJugador2.class).get(0).vidaInicial -= 50;
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
  if (Greenfoot.isKeyDown(tspecial) && state == "stand") {

   if (getWorld().getObjects(Hadouken.class).size() < 1 && special == true) {
    switch (sryu) {
     case "left":
      getWorld().addObject(new Hadouken(), getX() - 101, getY());
      break;
     case "right":
      getWorld().addObject(new Hadouken(), getX() + 101, getY());
      break;
    }
   }

   state += "-hadouken";
   special = false;
  }

  switch (state) {
   case "stand":
    position("Sprite Ryu/ryu-static-left.gif", "Sprite Ryu/ryu-static.gif");
    break;
   case "stand-hadouken":
    position("Sprite Ryu/ryu-hadouken-left.gif", "Sprite Ryu/ryu-hadouken.gif");
    break;
   case "clutch":
    position("Sprite Ryu/ryu-clutch-left.gif", "Sprite Ryu/ryu-clutch.gif");
    break;
   case "stand-punch":
    position("Sprite Ryu/ryu-punch-left.gif", "Sprite Ryu/ryu-punch.gif");
    break;
   case "stand-kick":
    position("Sprite Ryu/ryu-kick-left.gif", "Sprite Ryu/ryu-kick.gif");
    break;
   case "move":
    position("Sprite Ryu/ryu-static-left.gif", "Sprite Ryu/ryu-static.gif");
    break;
   case "moving-punch":
    position("Sprite Ryu/ryu-static-left.gif", "Sprite Ryu/ryu-static.gif");
    break;
  }

 }
 
 public void position(String left, String right) {
  switch (sryu) {
   case "right":
    ryu = new GreenfootImage(right);

    break;
   case "left":
    ryu = new GreenfootImage(left);

    break;
  }
 }
}