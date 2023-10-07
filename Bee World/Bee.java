import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.awt.Color;
//import java.awt.Font;

/**
 * Write a description of class bee here.
 * 
 * @author Edwin D. Chavez Loloy
 * @version 2.0
 */
public class Bee extends Bug
{
    /**
     * Atributos de la clase
     */
    private int leavesEaten;
    private GreenfootImage image1;
    private GreenfootImage image2;
    
    /**
     * constructor de la clase abeja
     */
    public Bee()
    {
        leavesEaten = 0;
        image1 = new GreenfootImage("bee1.png");
        image2 = new GreenfootImage("bee2.png");
        
        setImage(image1);
        
    }
    /**
     * Procedimiento donde se inician los eventos o acciones a tomar dentro del actor abeja
     */
    public void act()
    {
        inputAndShowJugador(); // ingreso de datos del jugador y mostrado de información en el juego
        IniciarJuego();// iniciar juego
    }
    /**
     * Dar un efecto de cambio de imagen a la abeja
     */
    private void animateImage(){
        if(getImage()==image1){
            setImage(image2);
        }else{
            setImage(image1);
        }
    }
    /**
     * Pedir nombre del jugador y mostrarlo el nombre del jugador
     * asi como tambien las vidas que tiene hasta el momento
     */
    public void inputAndShowJugador(){
        while(BeeMyWorld.count < 1){
           String name = Greenfoot.ask("Ingrese Jugador:");
           getWorld().showText("JUGADOR : " + name,100,25);
           getWorld().showText("VIDAS: " + Integer.toString(Score()), 100, 50);
           BeeMyWorld.count++;
        }
    }
    /**
     * Disminuir en 1 las vidas de la abeja
     */
    private void updateScore(){
        BeeMyWorld mundo = (BeeMyWorld)getWorld();
        mundo.updateScore();
    }
    
    /**
     * Recuperar las vidas que tiene la abeja hasta el momento 
     */
    private int Score(){
        BeeMyWorld mundo = (BeeMyWorld)getWorld();
        return mundo.getScore();
    }
 
    
    /**
     * Verificar si esque la araña coliciono con la abeja y si es el caso disminmuir las vidas
     */
    private void catchSpider(){

        if(isTouching(spider.class)){
            updateScore();

            getWorld().showText("score: " + Integer.toString(Score()), 100, 50);
            setLocation(Greenfoot.getRandomNumber(720), Greenfoot.getRandomNumber(600));
            if(Score()==0){
                getWorld().addObject(new GameOver(), 350, 300);
                Greenfoot.stop();
                //getWorld().showText("....:::::::::: PEDIDO ::::::::........", 400, 400);
            }
        }
    }
    
    /**
     * Detectar pulsaciones de las teclas izquierda y derecha del teclado para realizar un giro de 5° o -5 según corresponda
     */
    private void HadlesButtonsLeftRight(){
        if(Greenfoot.isKeyDown("left")){
                turn(5);
        }
        if(Greenfoot.isKeyDown("right")){
            turn(-5);
        }
    }
    /**
     * Procedimiento donde se da inicio al juego
     */
    private void IniciarJuego(){
        animateImage(); // dar efecto de mover las alitas a la abeja
        catchSpider(); // revisar si la abeja coliciona con la araña
        HadlesButtonsLeftRight(); // para detectar si se preciono las teclas derecha e izquierda para mover la aveja
        traspasarBordes(); // permitir que la aveja al momento de colicionar con un borde termine apareciendo en el borde contrario

        // verificar si la aveja coliciono con una aveja
        if (colisionFly()) {
            eatFly(); // Desaparecer la mosca la cual coliciono con la abeja
        }
        else {
            move(3); // continuar moviendose la abeja con velocidad de 3
        }
    }
       
    /**
     * Verifica si exite una mosca al pasar una aveja
     */
    public boolean colisionFly()
    {
        Actor leaf = getOneObjectAtOffset(0, 0, fly.class);
        return leaf != null;
    }
    
    /**
     * borrar la mosca de la posicion donde esta pasando la abeja
     */
    public void eatFly()
    {
        Actor actor = getOneObjectAtOffset(0, 0, fly.class); // obtener la mosca la cual esta en la misma posición de la abeja
        if (actor != null) {
            // Si existe una mosca en la misma posicion de la abeja quitarla del mundo
            getWorld().removeObject(actor);
            leavesEaten = leavesEaten + 1;
            Greenfoot.playSound("slurp.wav");
            if(((List<fly>)getWorld().getObjects(fly.class)).size() == 0){
                Greenfoot.playSound("au.wav");
                Greenfoot.stop();
                getWorld().showText("...:::: USTED A GANADO ::: ......", 400, 400);
            }
        }
    }
}
