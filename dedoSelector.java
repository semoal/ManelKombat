import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class dedoSelector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class dedoSelector extends menuSeleccion {
    GreenfootImage dedoImagen;
    private boolean dParar; //lo utilizaremos para que no se mueva tan rapida la mano selectora
    private boolean aParar;
    int pos = 1;
    GreenfootSound ryuSonido = new GreenfootSound("sonidosJugadoresMenu/RYU.mp3");
    GreenfootSound kenSonido = new GreenfootSound("sonidosJugadoresMenu/KEN.mp3");
    GreenfootSound sCoSonido = new GreenfootSound("sonidosJugadoresMenu/SCORPION.mp3");
    GreenfootSound barSonido = new GreenfootSound("sonidosJugadoresMenu/BARAKA.mp3");
    GreenfootSound luchaSonido = new GreenfootSound("sonidosJugadoresMenu/LUCHAD.mp3");
    public dedoSelector() {
            dedoImagen = new GreenfootImage("dedoSeleccion.png");
            dedoImagen.scale(30, 50);
            setImage(dedoImagen);

        }
        /**
         * Act - do whatever the dedoSelector wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
    public void act() {
        movimiento(); // Add your action code here.
    }
    public void movimiento() {
        if (!dParar && Greenfoot.isKeyDown("d")) {
            dParar = true; //ponemos dParar a true para saber que esta apretada

            setLocation(this.getX() + 104, this.getY());
            sonidoJugadorMenu(); //aquí lanzamos el sonido según su posicion
            if (aQuienMiro() > 394) {
                setLocation(394, 387);
            }
            if (aQuienMiro() > 394 && aQuienMiro() < 621) {
                setLocation(621, 387);
            }
        }
        if (dParar && !Greenfoot.isKeyDown("d")) {
            dParar = false; //en cuando sabe que esta apretada, pone dParar de nuevo a false para poder volver a entrar en el primer if de movimiento
        }
        if (!aParar && Greenfoot.isKeyDown("a")) {
            aParar = true;
            setLocation(this.getX() - 104, this.getY());
            sonidoJugadorMenu(); //aquí lanzamos el sonido según su posicion
            if (aQuienMiro() < 82) {
                setLocation(82, 387);

            }
            if (aQuienMiro() < 621 && aQuienMiro() > 394) {
                setLocation(394, 387);
            }
        }
        if (aParar && !Greenfoot.isKeyDown("a")) {
            aParar = false;
        }


        if (Greenfoot.isKeyDown("w") && getWorld().getObjects(dedoSelector2.class).get(0).pos != pos) {
            int posicion2 = getWorld().getObjects(dedoSelector2.class).get(0).aQuienMiro2();
            World2 w2 = (World2) getWorld();
            w2.backgroundMusic.stop();
            luchaSonido.play();
            Greenfoot.setWorld(new World3(aQuienMiro(), posicion2));

        }

    }
    public void sonidoJugadorMenu() {
        if (aQuienMiro() == 82) {
            ryuSonido.play();
            pos = 1;
        }
        if (aQuienMiro() == 186) {
            sCoSonido.play();
            pos = 2;
        }
        if (aQuienMiro() == 290) {
            kenSonido.play();
            pos = 3;
        }
        if (aQuienMiro() == 394) {
            barSonido.play();
            pos = 4;
        }
    }
    public int aQuienMiro() {
        return getX(); 
    }
}