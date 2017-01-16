import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World3 extends World
{
    int i = 1;
    int numImagen=1;
    int numeroRandom = Greenfoot.getRandomNumber(6);
    boolean check=true;
    /**
     * Constructor for objects of class World3.
     * 
     */
    GreenfootSound backgroundMusic;
    public World3(int posicionX, int posicionX2)
    {    
        super(1000, 600, 1);
          if(check){
            int random = Greenfoot.getRandomNumber(5);
            backgroundMusic=new GreenfootSound("music"+random+".mp3");            
            check=false;
        }
        int miPersonajeCual = posicionX;
        int miPersonajeCual2 = posicionX2;
        if(miPersonajeCual == 82){//dedoSeleccion
            addObject(new Jugador2(), 200,370);
            addObject(new vidaJugador2(),200,370);
            getObjects(Jugador2.class).get(0).player="Jugador 2";
        }
        if(miPersonajeCual == 186){
             
            addObject(new Jugador1(), 200,370);
            addObject(new vidaJugador1(),200,370);    
            getObjects(Jugador1.class).get(0).player="Jugador 2";
        }
        if(miPersonajeCual == 290){
            addObject(new Jugador3(),400,370);
            addObject(new vidaJugador3(),200,370);
            getObjects(Jugador3.class).get(0).player="Jugador 2";
        }
        if(miPersonajeCual == 394){
            addObject(new Jugador4(), 100,370);
            addObject(new vidaJugador4(),200,370); 
            getObjects(Jugador4.class).get(0).player="Jugador 2";
        }//termina dedoSeleccion
        
        if(miPersonajeCual2 == 621){//dedoSeleccion2
            addObject(new Jugador2(), 600,370);
            addObject(new vidaJugador2(),200,370);
            getObjects(Jugador2.class).get(0).player="Jugador 1";
        }
        if(miPersonajeCual2 == 725){
            addObject(new Jugador1(), 600,370);
            addObject(new vidaJugador1(),200,370);
            getObjects(Jugador1.class).get(0).player="Jugador 1";
        }
        if(miPersonajeCual2 == 829){
            addObject(new Jugador3(),600,370);
            addObject(new vidaJugador3(),200,370);
            getObjects(Jugador3.class).get(0).player="Jugador 1";
        }
        if(miPersonajeCual2 == 933){
            addObject(new Jugador4(), 600,370);
            addObject(new vidaJugador4(),200,370);
            getObjects(Jugador4.class).get(0).player="Jugador 1";
        }
        addObject(new suelo(),500,500);
        backgroundMusic.play();
    }
   public void act() {
        randomFondo();
    }

   public int randomFondo(){ //Metodo para poner un fondo aleatorio, que cogemos de la variable de clase numeroRandom
    int aleatorio = numeroRandom;  
    switch(aleatorio){
        case 1:
            fondoAnimado1();
        break;
        case 2: 
            fondoAnimado2();
        break;
        case 3:
            fondoAnimado3();
        break;
        case 4: 
            fondoAnimado4();
        break;
        case 5: 
            fondoAnimado5();
        break;
        case 6:
            fondoAnimado6();
        default:
            fondoAnimado6();
        break;
    }    
    return aleatorio;    
    }
    public void fondoAnimado1(){   
           GreenfootImage background = new GreenfootImage("fondoPrimero/fondoPrimero-"+numImagen+".gif");
           background.scale(getWidth(), getHeight());
           setBackground(background);
           Greenfoot.delay(10);  
           numImagen +=1;
           if(numImagen == 16){
               numImagen = 1;               
            }
        } 
    public void fondoAnimado2(){
          GreenfootImage background = new GreenfootImage("fondoSegundo/fondoSegundo-"+numImagen+".gif");
           background.scale(getWidth(), getHeight());
           setBackground(background);
           Greenfoot.delay(10);  
           numImagen +=1;
           if(numImagen == 8){
               numImagen = 1;               
            } 
    }
    public void fondoAnimado3(){
        GreenfootImage background = new GreenfootImage("fondoTercero/frame-"+numImagen+".gif");
        background.scale(getWidth(), getHeight());
        setBackground(background);
        Greenfoot.delay(10);
        numImagen +=1;
        if(numImagen == 24){
            numImagen = 1;
        }
    }
    public void fondoAnimado4(){
        GreenfootImage background = new GreenfootImage("fondoCuarto/frame-"+numImagen+".gif");
        background.scale(getWidth(), getHeight());
        setBackground(background);
        Greenfoot.delay(10);
        numImagen +=1;
        if(numImagen == 22){
            numImagen = 1;
        }
    }
    public void fondoAnimado5(){
        GreenfootImage background = new GreenfootImage("fondoQuinto/frame-"+numImagen+".gif");
        background.scale(getWidth(), getHeight());
        setBackground(background);
        Greenfoot.delay(10);
        numImagen +=1;
        if(numImagen == 48){
            numImagen = 1;
        }
    }
    public void fondoAnimado6(){
        GreenfootImage background = new GreenfootImage("fondoSexto/frame-"+numImagen+".gif");
        background.scale(getWidth(), getHeight());
        setBackground(background);
        Greenfoot.delay(10);
        numImagen +=1;
        if(numImagen == 16){
            numImagen = 1;
        }
    }
}
