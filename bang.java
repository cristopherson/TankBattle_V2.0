import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bang here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bang extends transport
{
    /**
     * Act - do whatever the bang wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int count_bang=0;
    public void act() 
    {
        /*
       if(count_bang>=5){
        getWorld().removeObject(this);
        count_bang++;
        
        } // Add your action code here.
        */
               setImage("blast.gif");
        //Greenfoot.delay(1);
        getWorld().removeObject(this);
    }    
}
