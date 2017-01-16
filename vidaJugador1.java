import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Marcador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class vidaJugador1 extends Jugador1 {
 int vidaInicial = 100;
 int dañoPuñetazo = 10;
 int dañoPatada = 15;
 int dañoEspecial = 35;
 boolean fin = false;
 public void act() {
  if (getWorld().getObjects(Jugador1.class).get(0).enemy != null) {
   barraVida(vidaInicial);
   puñetazo();
   if (fin) {
    getWorld().addObject(new gameOver(), 500, 300);
   }
   fin = false;
  }
 }

 public void barraVida(int vidaInicial) {
  if (vidaInicial <= 0) {
   vidaInicial = 1;
   fin = true;
  }
  GreenfootImage image = new GreenfootImage(vidaInicial, 10);
  if (vidaInicial >= 45) {
   image.setColor(java.awt.Color.GREEN);
   image.fill();
   setImage(image); //barra vida
  } else {
   image.setColor(java.awt.Color.RED);
   image.fill();
   setImage(image); //barra vida
  }
  setLocation((getWorld().getObjects(Jugador1.class).get(0).getX()), (getWorld().getObjects(Jugador1.class).get(0).getY() - 100));
 }

 public void puñetazo() {
  String checker = ((getWorld().getObjects(Jugador1.class).get(0).enemy).toString());

  int check = 0;
  int i = 0;
  do {
   i++;
   check = checker.indexOf("Jugador" + i);

  } while (check < 0);

  switch (i) {
   case 1:
    if ((getWorld().getObjects(Jugador1.class).get(0).pruebaPunch == false) && isTouching(Jugador1.class)) {
     vidaInicial = vidaInicial - dañoPuñetazo;
    } else if ((getWorld().getObjects(Jugador1.class).get(0).pruebaKick == false) && isTouching(Jugador1.class)) {
     vidaInicial = vidaInicial - dañoPatada;
    }
    if (isTouching(BolonFuego.class)) {
     vidaInicial = vidaInicial - 50;
     getWorld().removeObject(getWorld().getObjects(BolonFuego.class).get(0));
    }
    break;
   case 2:
    if ((getWorld().getObjects(Jugador2.class).get(0).pruebaPunch == false) && isTouching(Jugador2.class)) {
     vidaInicial = vidaInicial - dañoPuñetazo;
    } else if ((getWorld().getObjects(Jugador2.class).get(0).pruebaKick == false) && isTouching(Jugador2.class)) {
     vidaInicial = vidaInicial - dañoPatada;
    }
    if (isTouching(Hadouken.class)) {
     vidaInicial = vidaInicial - 50;
     getWorld().removeObject(getWorld().getObjects(Hadouken.class).get(0));
    }

    break;
   case 3:
    if ((getWorld().getObjects(Jugador3.class).get(0).pruebaPunch == false) && isTouching(Jugador3.class)) {
     vidaInicial = vidaInicial - dañoPuñetazo;
    } else if ((getWorld().getObjects(Jugador3.class).get(0).pruebaKick == false) && isTouching(Jugador3.class)) {
     vidaInicial = vidaInicial - dañoPatada;
    } else if ((getWorld().getObjects(Jugador3.class).get(0).pruebaSpecial == false) && isTouching(Jugador3.class)) {
     vidaInicial = vidaInicial - 60;
    }
    break;
   case 4:
    if ((getWorld().getObjects(Jugador4.class).get(0).pruebaPunch == false) && isTouching(Jugador4.class)) {
     vidaInicial = vidaInicial - dañoPuñetazo;
    } else if ((getWorld().getObjects(Jugador4.class).get(0).pruebaKick == false) && isTouching(Jugador4.class)) {
     vidaInicial = vidaInicial - dañoPatada;
    }
    break;


  }
 }
}