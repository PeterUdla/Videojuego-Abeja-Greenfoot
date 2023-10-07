
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Actor mosca la cual sera la comida de las abejas
 * 
 * @author Edwin Chavez Loloy 
 * @version 2.0 2019-09-26
 */
public class fly extends Bug
{
    /**
     * Atributos de la clase actor mosca
     */
    private GreenfootImage image1;
    private GreenfootImage image2;
    private int velocidad;
    private int rotar;
    
    /**
     * Constructor que recibe 2 parametros donde es velocidad con la cual avanzara y el angulo en grados que debe girar el actor mosca
     */
    public fly(int velocidad,int rotar){
        image1 = new GreenfootImage("fly.png");
        image2 = new GreenfootImage("fly1.png");
        
        this.velocidad=velocidad;
        this.rotar=rotar;
        setImage(image1);
    }
    
    /**
     * Animacion para dar el efecto de que la mosca vuele
     */
    private void animateImage(){
        if(getImage()==image1){
            setImage(image2);
        }else{
            setImage(image1);
        }
    }
    /**
     * procedimiento donde se inician los eventos o acciones a tomar dentro del actor mosca
     */
    public void act() 
    {
        //moveRandom();
        animateImage();
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse !=null){
            if(mouse.getButton()==1){
                setLocation(mouse.getX(),mouse.getY());
            }
        }
        
        turnAtEdge();
        MaxVelocidad();
    }
    
    /**
     * implementación de velocidad maxima tomando como parametros los atributos de la clase mosca
     */
    public void MaxVelocidad(){
        move(velocidad);
        if(Greenfoot.getRandomNumber(100)<10){
            turn(rotar-45);
        }
    }
}
