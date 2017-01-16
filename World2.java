import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World2 extends World
{
    GreenfootSound backgroundMusic=new GreenfootSound("select character.mp3");
    boolean check = true;
    /**
     * Constructor for objects of class World2.
     * 
     */
    public World2()
    {    
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        
        
        GreenfootImage back2 = new GreenfootImage("images/splash.png");
        GreenfootImage back1 = new GreenfootImage("images/wallp.png");
        backgroundMusic.play();
        setBackground(back2);
        addObject(new dedoSelector(), 82, 387);
        addObject(new dedoSelector2(), 933, 387);
        addObject(new personajesMenu(),82,500);
        addObject(new personajesMenu2(),621,500);
    }
    public void act() {
    //if (Greenfoot.isKeyDown("SPACE")) {
        //int 
        //Greenfoot.setWorld(new World3());
        //backgroundMusic.stop();
    }
    }

