import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameOver extends Actor
{
    /**
     * Act - do whatever the gameOver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage gameover = new GreenfootImage("gameover.png");
    public void act() 
    {
      World3 w2 = (World3)getWorld();
      w2.backgroundMusic.stop();
      w2.backgroundMusic=new GreenfootSound("gameover.mp3");
      w2.backgroundMusic.play();
      gameover.scale(1000,600);
      setImage(gameover);
      
      Greenfoot.delay(1700);
      w2.backgroundMusic.stop();
      Greenfoot.setWorld(new World2());
        
    }    
}
