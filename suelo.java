import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class suelo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class suelo extends Suelos
{
    /**
     * Act - do whatever the suelo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        GreenfootImage suelo = new GreenfootImage("suelo.png");
        suelo.scale(1000,1);
        setImage(suelo);
        setLocation(500,594);
    }    
}
