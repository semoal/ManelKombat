import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jugador4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador4 extends Personaje
{
    int numImatge=1;
    int numAndar=1;
    int numSalto=1;
    int gravity=0;
    int speed=20;
    int jump=0;
    String state = "stand";
    String mirar="derecha";
    int numPuño=1;
    int numAgachar=1;
    int numPatada=1;
    boolean punch=false;
    boolean pruebaKick=true;
    boolean special=true;
     boolean hadoukenTouch=false;
    boolean fuegoTouch=false;
    boolean pruebaPunch=true;
    boolean kick=false;
    Actor enemy;
    Actor me = this;
    GreenfootImage barak=new GreenfootImage("Sprite Baraka/BarakaPie2.png");
   
    String player;
    String tleft=checkLeft(player);
    String tright=checkRight(player);
    String tjump=checkJump(player);
    String tcrouch=checkCrouch(player);
    String tpunch=checkPunch(player);
    String tkick=checkKick(player);
    String tspecial=checkSpecial(player);
    /**
     * Act - do whatever the Scorpion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){ 
     tleft=checkLeft(player);
     tright=checkRight(player);
     tjump=checkJump(player);
     tcrouch=checkCrouch(player);
     tpunch=checkPunch(player);
     tkick=checkKick(player);
     tspecial=checkSpecial(player);
     enemy=checkactor(me);
        
     pruebaPunch=true;
     pruebaKick=true;
        
         if(enemy!=null){
            
        if(state.indexOf("punch")>-1){
                barak.scale(150,200);
            }else if(state.indexOf("kick")>-1){
                barak.scale(150, 200);
            }else{
                barak.scale(100, 200);
            }
        
        setImage(barak);
        if(enemy.getX()<getX()){
                Quieto2();
                mirar="izquierda";
            }else{
                Quieto();
                mirar="derecha";
            }
            state="stand";
        Mover();
       if(!isTouching(suelo.class)){
               gravity();
                   switch(mirar){
                case "derecha": Saltar();
                break;
                case "izquierda": Saltar2();
                break;
            }
            }else {
               jump=0;
            }
            impacto();
       //System.out.println(pruebaKick);
    }
}
    public void impacto(){
        if(isTouching(Hadouken.class)){
            hadoukenTouch=true;
            getWorld().removeObject(getWorld().getObjects(Hadouken.class).get(0));
            getWorld().getObjects(vidaJugador4.class).get(0).vidaInicial-=50;
           }else{
               hadoukenTouch=false;
           }
           if(isTouching(BolonFuego.class)){
               fuegoTouch=true;
               getWorld().removeObject(getWorld().getObjects(BolonFuego.class).get(0));
               getWorld().getObjects(vidaJugador4.class).get(0).vidaInicial-=50;
            }else{
                fuegoTouch=false;
            }
        
        }
    public void Quieto(){
     switch(numImatge){
            case 1: barak=new GreenfootImage("Sprite Baraka/BarakaPie2.png");
                    numImatge=2;
                    break;
            case 2: barak=new GreenfootImage("Sprite Baraka/BarakaPie3.png");
                    numImatge=3;
                    break;
            case 3: barak=new GreenfootImage("Sprite Baraka/BarakaPie4.png");
                    numImatge=4;
                    break;
            case 4: barak=new GreenfootImage("Sprite Baraka/BarakaPie1.png");
                    numImatge=1;
                    break;
        }
        //setImage(barak);
    }
     public void Quieto2(){
     switch(numImatge){
            case 1: barak=new GreenfootImage("Sprite Baraka/BarakaPieR2.png");
                    numImatge=2;
                    break;
            case 2: barak=new GreenfootImage("Sprite Baraka/BarakaPieR3.png");
                    numImatge=3;
                    break;
            case 3: barak=new GreenfootImage("Sprite Baraka/BarakaPieR4.png");
                    numImatge=4;
                    break;
            case 4: barak=new GreenfootImage("Sprite Baraka/BarakaPieR1.png");
                    numImatge=1;
                    break;
        }
       // setImage(scorp);
    }
    public void Andar(){
        switch (numAndar){
            case 1:barak=new GreenfootImage("Sprite Baraka/BarakaAndar2.png");
                   numAndar=2;
                   break;
            case 2:barak=new GreenfootImage("Sprite Baraka/BarakaAndar3.png");
                   numAndar=3;
                   break;
            case 3:barak=new GreenfootImage("Sprite Baraka/BarakaAndar4.png");
                   numAndar=4;
                   break;
            case 4:barak=new GreenfootImage("Sprite Baraka/BarakaAndar5.png");
                   numAndar=5;
                   break;
            case 5:barak=new GreenfootImage("Sprite Baraka/BarakaAndar6.png");
                   numAndar=6;
                   break;
            case 6:barak=new GreenfootImage("Sprite Baraka/BarakaAndar7.png");
                   numAndar=7;
                   break;
            case 7:barak=new GreenfootImage("Sprite Baraka/BarakaAndar8.png");
                   numAndar=8;
                   break;
            case 8:barak=new GreenfootImage("Sprite Baraka/BarakaAndar9.png");
                   numAndar=9;
                   break;
            case 9:barak=new GreenfootImage("Sprite Baraka/BarakaAndar1.png");
                   numAndar=1;
                   break;
        }
          // setImage(barak);     
    }
     public void Andar2(){
       switch (numAndar){
            case 1:barak=new GreenfootImage("Sprite Baraka/BarakaAndarR2.png");
                   numAndar=2;
                   break;
            case 2:barak=new GreenfootImage("Sprite Baraka/BarakaAndarR3.png");
                   numAndar=3;
                   break;
            case 3:barak=new GreenfootImage("Sprite Baraka/BarakaAndarR4.png");
                   numAndar=4;
                   break;
            case 4:barak=new GreenfootImage("Sprite Baraka/BarakaAndarR5.png");
                   numAndar=5;
                   break;
            case 5:barak=new GreenfootImage("Sprite Baraka/BarakaAndarR6.png");
                   numAndar=6;
                   break;
            case 6:barak=new GreenfootImage("Sprite Baraka/BarakaAndarR7.png");
                   numAndar=7;
                   break;
            case 7:barak=new GreenfootImage("Sprite Baraka/BarakaAndarR8.png");
                   numAndar=8;
                   break;
            case 8:barak=new GreenfootImage("Sprite Baraka/BarakaAndarR9.png");
                   numAndar=9;
                   break;
            case 9:barak=new GreenfootImage("Sprite Baraka/BarakaAndarR1.png");
                   numAndar=1;
                   break;
        }
        //setImage(scorp);
    }
    public void Saltar(){
        switch(numSalto){
            case 1:barak=new GreenfootImage("Sprite Baraka/BarakaSalto2.png");
                   numSalto=2;
                   break;
            case 2:barak=new GreenfootImage("Sprite Baraka/BarakaSalto3.png");
                   numSalto=3;
                   break;
            case 3:barak=new GreenfootImage("Sprite Baraka/BarakaSalto4.png");
                   numSalto=4;
                   break;
            case 4:barak=new GreenfootImage("Sprite Baraka/BarakaSalto5.png");
                   numSalto=5;
                   break;
            case 5:barak=new GreenfootImage("Sprite Baraka/BarakaSalto6.png");
                   numSalto=6;
                   break;
            case 6:barak=new GreenfootImage("Sprite Baraka/BarakaSalto7.png");
                   numSalto=7;
                   break;
            case 7:barak=new GreenfootImage("Sprite Baraka/BarakaSalto1.png");
                   numSalto=1;
                   break;
        }
        //setImage(scorp);
    }
    public void Saltar2(){
       switch(numSalto){
            case 1:barak=new GreenfootImage("Sprite Baraka/BarakaSaltoR2.png");
                   numSalto=2;
                   break;
            case 2:barak=new GreenfootImage("Sprite Baraka/BarakaSaltoR3.png");
                   numSalto=3;
                   break;
            case 3:barak=new GreenfootImage("Sprite Baraka/BarakaSaltoR4.png");
                   numSalto=4;
                   break;
            case 4:barak=new GreenfootImage("Sprite Baraka/BarakaSaltoR5.png");
                   numSalto=5;
                   break;
            case 5:barak=new GreenfootImage("Sprite Baraka/BarakaSaltoR6.png");
                   numSalto=6;
                   break;
            case 6:barak=new GreenfootImage("Sprite Baraka/BarakaSaltoR7.png");
                   numSalto=7;
                   break;
            case 7:barak=new GreenfootImage("Sprite Baraka/BarakaSaltoR1.png");
                   numSalto=1;
                   break;
        }
        //setImage(scorp);
    }
    public void Agachar(){
        switch(numAgachar){
            case 1: barak=new GreenfootImage("Sprite Baraka/BarakaAgachado1.png");
            
                    break;
            case 2: barak=new GreenfootImage("Sprite Baraka/BarakaAgachado2.png");
            
                    break;
        }
    }
     public void Agachar2(){
        switch(numAgachar){
            case 1: barak=new GreenfootImage("Sprite Baraka/BarakaAgachadoR1.png");
            
                    break;
            case 2: barak=new GreenfootImage("Sprite Baraka/BarakaAgachadoR2.png");
            
                    break;
        }
    }
    public void Puñetazo(){
        switch(numPuño){
            case 1: barak=new GreenfootImage("Sprite Baraka/BarakaPuño1.png");
                    
                    break;
            case 2: barak=new GreenfootImage("Sprite Baraka/BarakaPuño2.png");
                    
                    break;
            case 3: barak=new GreenfootImage("Sprite Baraka/BarakaPuño3.png");
                    
                    break;
            case 4: barak=new GreenfootImage("Sprite Baraka/BarakaPuño4.png");
                    
                    break;
        }
    }
     public void Puñetazo2(){
        switch(numPuño){
            case 1: barak=new GreenfootImage("Sprite Baraka/BarakaPuñoR1.png");
                    
                    break;
            case 2: barak=new GreenfootImage("Sprite Baraka/BarakaPuñoR2.png");
                    
                    break;
            case 3: barak=new GreenfootImage("Sprite Baraka/BarakaPuñoR3.png");
                    
                    break;
            case 4: barak=new GreenfootImage("Sprite Baraka/BarakaPuñoR4.png");
                    
                    break;
        }
    }
    public void Patada(){
        switch(numPatada){
            case 1: barak=new GreenfootImage("Sprite Baraka/BarakaPatada1.png");
                    break;
            case 2: barak=new GreenfootImage("Sprite Baraka/BarakaPatada2.png");
                    break;
            case 3: barak=new GreenfootImage("Sprite Baraka/BarakaPatada3.png");
                    break;
        }
    }
    public void Patada2(){
        switch(numPatada){
            case 1: barak=new GreenfootImage("Sprite Baraka/BarakaPatadaR1.png");
                    break;
            case 2: barak=new GreenfootImage("Sprite Baraka/BarakaPatadaR2.png");
                    break;
            case 3: barak=new GreenfootImage("Sprite Baraka/BarakaPatadaR3.png");
                    break;
        }
    }
    public void Desliza(){
    
    }
    public void Mover(){
        if(Greenfoot.isKeyDown(tright)==true){
        setLocation(getX()+speed, getY());
         Andar();
         state="move";
        
    }
        if(Greenfoot.isKeyDown(tleft)==true){
         setLocation(getX()-speed, getY());
         Andar2();
         state="move";
         
            }
        if(Greenfoot.isKeyDown(tjump)==true && jump!=8){
            setLocation(getX(), getY()-50);
            if(!isTouching(suelo.class)){
                jump++;
            }
            switch(mirar){
            case "derecha": Saltar();
            break;
            case "izquierda": Saltar2();
            break;
        }
            
    }
    if(Greenfoot.isKeyDown(tcrouch)==true && state=="stand"){
        if(numAgachar!=2){
            numAgachar++;
    }
    Agachar();
}
    else{
    if(numAgachar!=1){
            numAgachar--;
              Agachar();
    }
    }
    if(Greenfoot.isKeyDown(tpunch)==true && state=="stand"){
      if(numPuño!=4){
          numPuño++;
        }
        switch(mirar){
            case "derecha": Puñetazo();
            break;
            case "izquierda": Puñetazo2();
            break;
        }
        state+="punch";
        if(punch) {
            punch=false;
            pruebaPunch=false;
        }
    }
     else{
         if(numPuño!=1){
             numPuño--;
             Puñetazo();
            }
            punch=true;
}
if(Greenfoot.isKeyDown(tkick)==true && state=="stand"){
      if(numPatada!=3){
          numPatada++;
        }
        switch(mirar){
            case "derecha": Patada();
            break;
            case "izquierda": Patada2();
            break;
        }
        state+="kick";
        if(kick){
            kick=false;
            pruebaKick=false;
        }
    }
     else{
         if(numPatada!=1){
             numPatada--;
             Patada();
            }
            kick=true;
}
if(Greenfoot.isKeyDown(tspecial)==true && state=="stand" && special==true){
    
    switch(mirar){
            case "derecha": setLocation(getX()+300,getY());
            break;
            case "izquierda":  setLocation(getX()-300,getY());
            break;
        }
        state+="special";
        special=false;
    }
}
}