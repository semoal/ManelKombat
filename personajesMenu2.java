import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class personajesMenu2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class personajesMenu2 extends menuSeleccion {
    int numAndar = 1;
    int i = 1;
    int iBara = 1;
    int iScorp = 1;
    GreenfootImage ryu = new GreenfootImage(35, 71);
    GreenfootImage scorp = new GreenfootImage(42, 85);
    GreenfootImage ken = new GreenfootImage(35, 71);
    GreenfootImage barak = new GreenfootImage(42, 85);
    public personajesMenu2() {
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
        if (aDondeMiro() == 621) {
            andarRyu();
            setLocation(621, 500);
        }
        if (aDondeMiro() == 725) {
            andarScorpio();
            setLocation(725, 500);
        }
        if (aDondeMiro() == 829) {
            andarKen();
            setLocation(829, 500);
        }
        if (aDondeMiro() == 933) {
            andarBaraka();
            setLocation(933, 500);
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
        int posicion = getWorld().getObjects(dedoSelector2.class).get(0).aQuienMiro2();
        return posicion;
    }
}