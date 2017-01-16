import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scorpion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador1 extends Personaje

{
 int numImatge = 1;
 int jump = 0;
 int numAndar = 1;
 int numSalto = 1;
 int gravity = 0;
 int speed = 20;
 String mirar = "derecha";
 int numPuño = 1;
 int numAgachar = 1;
 int numPatada = 1;
 String state = "stand";
 boolean punch = true;
 boolean pruebaKick = false;
 boolean pruebaPunch = false;
 boolean special = true;
 boolean kick = true;
 Actor enemy;
 Actor me = this;
 GreenfootImage scorp = new GreenfootImage("Sprite Scorpion/ScorpionPie2.png");
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
 /**
  * Act - do whatever the Scorpion wants to do. This method is called whenever
  * the 'Act' or 'Run' button gets pressed in the environment.
  */
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
   if (state.indexOf("punch") > -1) {
    scorp.scale(150, 200);
   } else if (state.indexOf("kick") > -1) {
    scorp.scale(150, 200);
   } else {
    scorp.scale(100, 200);
   }

   setImage(scorp);
   if (enemy.getX() < getX()) {
    Quieto2();
    mirar = "izquierda";
   } else {
    Quieto();
    mirar = "derecha";
   }
   state = "stand";
   Mover();
   if (!isTouching(suelo.class)) {
    gravity();
    switch (mirar) {
     case "derecha":
      Saltar();
      break;
     case "izquierda":
      Saltar2();
      break;
    }
   } else {
    jump = 0;
   }
   impacto();
  }
 }
 public void impacto() {
  if (isTouching(Hadouken.class)) {
   hadoukenTouch = true;
   getWorld().removeObject(getWorld().getObjects(Hadouken.class).get(0));
   getWorld().getObjects(vidaJugador1.class).get(0).vidaInicial -= 50;
  } else {
   hadoukenTouch = false;
  }
  if (isTouching(BolonFuego.class)) {
   fuegoTouch = true;
   getWorld().removeObject(getWorld().getObjects(BolonFuego.class).get(0));
   getWorld().getObjects(vidaJugador1.class).get(0).vidaInicial -= 50;
  } else {
   fuegoTouch = false;
  }

 }
 public void Quieto() {
  switch (numImatge) {
   case 1:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPie2.png");
    numImatge = 2;
    break;
   case 2:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPie3.png");
    numImatge = 3;
    break;
   case 3:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPie4.png");
    numImatge = 4;
    break;
   case 4:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPie5.png");
    numImatge = 5;
    break;
   case 5:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPie6.png");
    numImatge = 6;
    break;
   case 6:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPie7.png");
    numImatge = 7;
    break;
   case 7:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPie8.png");
    numImatge = 8;
    break;
   case 8:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPie1.png");
    numImatge = 1;
    break;
  }
  //setImage(scorp);
 }
 public void Quieto2() {
  switch (numImatge) {
   case 1:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPieR2.png");
    numImatge = 2;
    break;
   case 2:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPieR3.png");
    numImatge = 3;
    break;
   case 3:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPieR4.png");
    numImatge = 4;
    break;
   case 4:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPieR5.png");
    numImatge = 5;
    break;
   case 5:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPieR6.png");
    numImatge = 6;
    break;
   case 6:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPieR7.png");
    numImatge = 7;
    break;
   case 7:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPieR8.png");
    numImatge = 8;
    break;
   case 8:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPieR1.png");
    numImatge = 1;
    break;
  }
  // setImage(scorp);
 }
 public void Andar() {
  switch (numAndar) {
   case 1:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAndar2.png");
    numAndar = 2;
    break;
   case 2:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAndar3.png");
    numAndar = 3;
    break;
   case 3:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAndar4.png");
    numAndar = 4;
    break;
   case 4:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAndar5.png");
    numAndar = 5;
    break;
   case 5:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAndar6.png");
    numAndar = 6;
    break;
   case 6:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAndar7.png");
    numAndar = 7;
    break;
   case 7:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAndar8.png");
    numAndar = 8;
    break;
   case 8:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAndar9.png");
    numAndar = 9;
    break;
   case 9:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAndar1.png");
    numAndar = 1;
    break;
  }
  // setImage(scorp);     
 }
 public void Andar2() {
  switch (numAndar) {
   case 1:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAndarR2.png");
    numAndar = 2;
    break;
   case 2:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAndarR3.png");
    numAndar = 3;
    break;
   case 3:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAndarR4.png");
    numAndar = 4;
    break;
   case 4:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAndarR5.png");
    numAndar = 5;
    break;
   case 5:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAndarR6.png");
    numAndar = 6;
    break;
   case 6:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAndarR7.png");
    numAndar = 7;
    break;
   case 7:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAndarR8.png");
    numAndar = 8;
    break;
   case 8:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAndarR9.png");
    numAndar = 9;
    break;
   case 9:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAndarR1.png");
    numAndar = 1;
    break;
  }
  //setImage(scorp);
 }
 public void Saltar() {
  switch (numSalto) {
   case 1:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionSalto2.png");
    numSalto = 2;
    break;
   case 2:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionSalto2.png");
    numSalto = 3;
    break;
   case 3:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionSalto3.png");
    numSalto = 4;
    break;
   case 4:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionSalto4.png");
    numSalto = 5;
    break;
   case 5:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionSalto5.png");
    numSalto = 6;
    break;
   case 6:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionSalto6.png");
    numSalto = 7;
    break;
   case 7:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionSalto7.png");
    numSalto = 8;
    break;
   case 8:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionSalto8.png");
    numSalto = 1;
    break;
  }
  //setImage(scorp);
 }
 public void Saltar2() {
  switch (numSalto) {
   case 1:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionSaltoR2.png");
    numSalto = 2;
    break;
   case 2:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionSaltoR2.png");
    numSalto = 3;
    break;
   case 3:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionSaltoR3.png");
    numSalto = 4;
    break;
   case 4:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionSaltoR4.png");
    numSalto = 5;
    break;
   case 5:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionSaltoR5.png");
    numSalto = 6;
    break;
   case 6:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionSaltoR6.png");
    numSalto = 7;
    break;
   case 7:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionSaltoR7.png");
    numSalto = 8;
    break;
   case 8:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionSaltoR8.png");
    numSalto = 1;
    break;
  }
  //setImage(scorp);
 }
 public void Agachar() {
  switch (numAgachar) {
   case 1:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAgachar1.png");

    break;
   case 2:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAgachar2.png");

    break;
   case 3:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAgachar3.png");

    break;
  }
 }
 public void Agachar2() {
  switch (numAgachar) {
   case 1:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAgachar1R.png");

    break;
   case 2:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAgachar2R.png");

    break;
   case 3:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionAgachar3R.png");

    break;
  }
 }
 public void Puñetazo() {
  switch (numPuño) {
   case 1:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPuño1.png");

    break;
   case 2:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPuño2.png");

    break;
   case 3:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPuño3.png");

    break;
  }
 }
 public void Puñetazo2() {
  switch (numPuño) {
   case 1:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPuñoR1.png");

    break;
   case 2:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPuñoR2.png");

    break;
   case 3:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPuñoR3.png");

    break;
  }
 }
 public void Patada() {
  switch (numPatada) {
   case 1:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPatada1.png");
    break;
   case 2:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPatada2.png");
    break;
   case 3:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPatada3.png");
    break;
  }
 }
 public void Patada2() {
  switch (numPatada) {
   case 1:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPatadaR1.png");
    break;
   case 2:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPatadaR2.png");
    break;
   case 3:
    scorp = new GreenfootImage("Sprite Scorpion/ScorpionPatadaR3.png");
    break;
  }
 }
 public void BolaFuego() {
  scorp = new GreenfootImage("Sprite Scorpion/EscupeFuego.png");
 }
 public void BolaFuego2() {
  scorp = new GreenfootImage("Sprite Scorpion/EscupeFuego2.png");
 }
 public void Mover() {
  if (Greenfoot.isKeyDown(tright) == true) {
   setLocation(getX() + speed, getY());
   Andar();
   state = "move";
  }
  if (Greenfoot.isKeyDown(tleft) == true) {
   setLocation(getX() - speed, getY());
   Andar2();
   state = "move";
  }
  if (Greenfoot.isKeyDown(tjump) == true && jump != 8) {
   setLocation(getX(), getY() - 50);
   if (!isTouching(suelo.class)) {
    jump++;
   }


  }
  if (Greenfoot.isKeyDown(tcrouch) == true && state == "stand") {
   if (numAgachar != 3) {
    numAgachar++;
   }
   Agachar();
  } else {
   if (numAgachar != 1) {
    numAgachar--;
    Agachar();
   }
  }
  if (Greenfoot.isKeyDown(tpunch) == true && state == "stand") {
   if (numPuño != 3) {
    numPuño++;
   }
   switch (mirar) {
    case "derecha":
     Puñetazo();
     break;
    case "izquierda":
     Puñetazo2();
     break;
   }
   state += "punch";
   if (punch) {
    punch = false;
    pruebaPunch = false;
   }
  } else {
   punch = true;
   if (numPuño != 1) {
    numPuño--;
    Puñetazo();
   }
  }
  if (Greenfoot.isKeyDown(tkick) == true && state == "stand") {
   if (numPatada != 3) {
    numPatada++;
   }
   switch (mirar) {
    case "derecha":
     Patada();
     break;
    case "izquierda":
     Patada2();
     break;
   }
   state += "kick";
   if (kick) {
    kick = false;
    pruebaKick = false;
   }
  } else {
   kick = true;
   if (numPatada != 1) {
    numPatada--;
    Patada();
   }
  }
  if (Greenfoot.isKeyDown(tspecial) == true) {
   switch (mirar) {
    case "izquierda":
     BolaFuego2();
     break;
    case "derecha":
     BolaFuego();
     break;
   }
   if (getWorld().getObjects(BolonFuego.class).size() < 1 && special == true) {

    switch (mirar) {
     case "izquierda":
      getWorld().addObject(new BolonFuego(), getX() - 101, getY());
      break;
     case "derecha":
      getWorld().addObject(new BolonFuego(), getX() + 101, getY());
      break;
    }
   }
   special = false;
  }
 }
}