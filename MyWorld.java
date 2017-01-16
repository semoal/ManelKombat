import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
 int i = 1;
 //long tempsInicial,tempsFinal;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    GreenfootSound backgroundMusic = new GreenfootSound("manel kombat.mp3");
    public MyWorld()
    {    
        // Crea un mundo de 1000px por 500px
        super(1000, 600, 1); 
        GreenfootImage back1 = new GreenfootImage("images/wallp.png");
        backgroundMusic.play();
        setBackground(back1);
        //tempsInicial = System.currentTimeMillis();
    }
    public void act() {
        
    if (Greenfoot.isKeyDown("SPACE")) {
        Greenfoot.setWorld(new World2());
        backgroundMusic.stop();
        //tempsFinal = System.currentTimeMillis();
        //if(tempsFinal-tempsInicial>=5000){
            //feu el que vulgueu!!!
          //  tempsInicial=System.currentTimeMillis();
        }
    }
}
