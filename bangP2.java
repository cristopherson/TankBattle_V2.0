import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bangP2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bangP2 extends transport
{
    /**
     * Act - do whatever the bangP2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage("blast.gif");
        //Greenfoot.delay(1);
        getWorld().removeObject(this);
    }    
}
