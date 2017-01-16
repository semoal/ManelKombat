import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class personajesMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class personajesMenu extends menuSeleccion {
    int numAndar = 1;
    int i = 1;
    int iBara = 1;
    int iScorp = 1;
    GreenfootImage ryu = new GreenfootImage(35, 71);
    GreenfootImage scorp = new GreenfootImage(42, 85);
    GreenfootImage ken = new GreenfootImage(35, 71);
    GreenfootImage barak = new GreenfootImage(42, 85);
    public personajesMenu() {
        setImage(scorp);
    }

    /**
     * Act - do whatever the personajesMenu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        segunXPongoJugador();
    }

    public void segunXPongoJugador() {
        if (aDondeMiro() == 82) {
            andarRyu();
            setLocation(82, 500);
        }
        if (aDondeMiro() == 186) {
            andarScorpio();
            setLocation(186, 500);
        }
        if (aDondeMiro() == 290) {
            andarKen();
            setLocation(290, 500);
        }
        if (aDondeMiro() == 394) {
            andarBaraka();
            setLocation(394, 500);
        }
    }

    public void andarScorpio() {
        GreenfootImage scorp = new GreenfootImage("Sprite Scorpion/ScorpionAndar" + iScorp + ".png");
        scorp.scale(90, 100);
        setImage(scorp);
        Greenfoot.delay(15);
        iScorp += 1;
        if (iScorp == 9) {
            iScorp = 1;
        }
    }

    public void andarRyu() {
        GreenfootImage ryu = new GreenfootImage("ryuMundoSprite/frame-" + i + ".gif");
        setImage(ryu);
        Greenfoot.delay(10);
        i += 1;
        if (i == 11) {
            i = 1;
        }
    }

    public void andarKen() {
        GreenfootImage ken = new GreenfootImage("kenMundoSprite/frame-" + i + ".gif");
        setImage(ken);
        Greenfoot.delay(10);
        i += 1;
        if (i == 11) {
            i = 1;
        }
    }

    public void andarBaraka() {
        GreenfootImage barak = new GreenfootImage("Sprite Baraka/BarakaPie" + iBara + ".png");
        barak.scale(90, 100);
        setImage(barak);
        Greenfoot.delay(15);
        iBara += 1;
        if (iBara == 4) {
            iBara = 1;
        }

    }

    public int aDondeMiro() {
        int posicion = getWorld().getObjects(dedoSelector.class).get(0).aQuienMiro();
        return posicion;
    }
}