import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class spider here.
 * 
 * @author Edwin Chavez Loloy 
 * @version 2.0 2019-09-26
 */
public class spider extends Bug
{
    /**
     * Procedimiento donde se inician los eventos o acciones a tomar dentro del actor araña
     */
    public void act() 
    {
        //move(2);
        //turnAtEdge();
        BeeMyWorld mundo = (BeeMyWorld)getWorld(); // obtener el mundo en que se encuentra la mosca
        Bee b = mundo.getBeeInBeeWorld(); // Obtener la abeja del mundo donde se encuentra la mosca
        
        
        turnTowards(b.getX(), b.getY()); // hacer que la araña siga a la mosca
        traspasarBordes(); // permitir que la araña al momento de colicionar con un borde termine apareciendo en el borde contrario
        moveRandom(); // Procedimiento que pertenece a la clase insecto para generar un movimiento aleatorio
    }    
}
