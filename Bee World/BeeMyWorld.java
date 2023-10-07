import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Edwin D. Chavez Loloy
 * @version 2.0
 */
public class BeeMyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Bee aveja;
    public fly[] moscas;
    public spider[] araña;
    private int score;
    static public int count = 5;
    
    public void updateScore(){
        this.score--;
    }
    public int getScore(){
        return score;
    }
    
    public Bee getBeeInBeeWorld(){
        return aveja;
    }
    
    public BeeMyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(720, 600, 1); 
        score=5;
        prepare();
    }
    // and with a method to update it image
    
    private void prepare(){
        count = 0;
        moscas = new fly[50];
        aveja = new Bee();
        araña = new spider[2];
        
        addObject(aveja, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
         for(int i=0;i<araña.length;i++){
            araña[i]= new spider();
            addObject(araña[i], Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
        
        
        for(int i=0;i<moscas.length;i++){
            moscas[i]= new fly(Greenfoot.getRandomNumber(4)+1,Greenfoot.getRandomNumber(180));
            addObject(moscas[i], Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
        
    }
}
