import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class insecto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bug extends Actor
{
    /**
     * Act - do whatever the insecto wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }   
    /**
     * gira si esque el bug coliciona con los bordes de juego
     */
    public void turnAtEdge(){
        if(isAtEdge()){
            this.turn(180);
        }
    }
    public void moveRandom(){
        move(1);
        if(Greenfoot.getRandomNumber(100)<10){
            turn(Greenfoot.getRandomNumber(100)-45);
        }
    }
    public void aumMoveCuadrante1(){
        if((getX()<getWorld().getWidth()/2) && (getY()>getWorld().getHeight()/2)){
            move(2);
        }
    }
    public void aumMoveCuadrante2(){
        if((getX()>getWorld().getWidth()/2) && (getY()>getWorld().getHeight()/2)){
            move(2);
        }
    }
    public void aumMoveCuadrante3(){
        if(!(getX()>getWorld().getWidth()/2) && (getY()<getWorld().getHeight()/2)){
            move(2);
        }
    }
    public void aumMoveCuadrante4(){
        if(!(getX()<getWorld().getWidth()/2) || !(getY()<getWorld().getHeight()/2)){
            move(2);
        }
    }
    /*
     * comprobar si se toca el borde inferior
     */
    private boolean atBottmEdge(){
        if(getY()>getWorld().getHeight()-20){
            return true;
        } else{
            return false;
        }
    }
    /*
     * comprobar si se toca el borde superior
     */
    private boolean atTopEdge(){
        if(getY() < 6){
            return true;
        } else{
            return false;
        }
    }
    private boolean atRightEdge(){
        if(getX()>getWorld().getWidth()-20){
            return true;
        } else{
            return false;
        }
    }
    /*
     * comprobar si se toca el borde superior
     */
    private boolean atLeftEdge(){
        if(getX() < 6){
            return true;
        } else{
            return false;
        }
    }
    public void traspasarBordes(){
        if(atBottmEdge()){
            setLocation(getX(), 6);
        }
        
        if(atTopEdge()){
            setLocation(getX(), getWorld().getHeight()-20);
        }
        
        if(atRightEdge()){
            setLocation(6, getY());
        }
        
        if(atLeftEdge()){
            setLocation(getWorld().getWidth()-20,getY());
        }
    }
}
