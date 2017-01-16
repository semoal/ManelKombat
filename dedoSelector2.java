import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class dedoSelector2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class dedoSelector2 extends menuSeleccion {
    GreenfootImage dedoImagen2;
    private boolean dParar; //lo utilizaremos para que no se mueva tan rapida la mano selectora
    private boolean aParar;
    int pos = 4;
    GreenfootSound ryuSonido = new GreenfootSound("sonidosJugadoresMenu/RYU.mp3");
    GreenfootSound kenSonido = new GreenfootSound("sonidosJugadoresMenu/KEN.mp3");
    GreenfootSound sCoSonido = new GreenfootSound("sonidosJugadoresMenu/SCORPION.mp3");
    GreenfootSound barSonido = new GreenfootSound("sonidosJugadoresMenu/BARAKA.mp3");
    public dedoSelector2() {
        dedoImagen2 = new GreenfootImage("dedoSeleccion2.png");
        dedoImagen2.scale(30, 50);
        setImage(dedoImagen2);
        }
    public void act() {
        movimiento(); // Add your action code here.
    }
    public void movimiento() {
        if (!dParar && Greenfoot.isKeyDown("right")) {
            dParar = true; //ponemos dParar a true para saber que esta apretada
            setLocation(this.getX() + 104, this.getY());
            sonidoJugadorMenu(); //aquí lanzamos el sonido según su posicion
            if (aQuienMiro2() > 933) {
                setLocation(933, 387);
            }
            if (aQuienMiro2() > 394 && aQuienMiro2() < 621) {
                setLocation(621, 387);
            }
        }
        if (dParar && !Greenfoot.isKeyDown("right")) {
            dParar = false; //en cuando sabe que esta apretada, pone dParar de nuevo a false para poder volver a entrar en el primer if de movimiento
        }

        if (!aParar && Greenfoot.isKeyDown("left")) {
            aParar = true;
            setLocation(this.getX() - 104, this.getY());
            sonidoJugadorMenu(); //aquí lanzamos el sonido según su posicion
            if (aQuienMiro2() < 621) {
                setLocation(621, 387);
            }
            if (aQuienMiro2() < 621 && aQuienMiro2() > 394) {
                setLocation(394, 387);
            }
        }
        if (aParar && !Greenfoot.isKeyDown("left")) {
            aParar = false;
        }

        if (Greenfoot.isKeyDown("up")) { //al apretar el UP tiene que quedarse elegido el player
            aQuienMiro2();
        }
    }
    public void sonidoJugadorMenu() {
        if (aQuienMiro2() == 621) {
            ryuSonido.play();
            pos = 1;
        }
        if (aQuienMiro2() == 725) {
            sCoSonido.play();
            pos = 2;
        }
        if (aQuienMiro2() == 829) {
            kenSonido.play();
            pos = 3;
        }
        if (aQuienMiro2() == 933) {
            barSonido.play();
            pos = 4;
        }
    }
    public int aQuienMiro2() {
        return getX(); //desde aquí obtenemos la posicion de la flecha,         
        //según el número pondremos un personaje u otro, también lo utilizamos para colocar la flecha en su lugar al llegar a los bordes del mapa o estar en zona de nadie
    }
}