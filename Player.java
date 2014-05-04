import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends transport implements turnObj,valueObj_XorP2
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int count=0;
    public void act() 
    {
        checkKeypress();
        add_enemymissile();
        count++;
    }    
    
    public void add_enemymissile(){
        
        int rotation=getRotation();
        if(Greenfoot.isKeyDown("L")){
            if((count) % 8==0){
                if(rotation==0)getWorld().addObject( new enemymissile(rotation),getX()+30,getY());
                else if(rotation==90)getWorld().addObject( new enemymissile(rotation),getX(),getY()+30);
                else if(rotation==180)getWorld().addObject( new enemymissile(rotation),getX()-30,getY());
                else if(rotation==270)getWorld().addObject( new enemymissile(rotation),getX(),getY()-30);
            };
            
        }
    }
    
    public void checkKeypress(){
       
        if(Greenfoot.isKeyDown("D")){
            if(this.getRotation()==0)
            move(dist);
            else if(this.getRotation()==90){
            turn(-90);move(dist);
            }
            else if(this.getRotation()==180){
            turn(-180);move(dist);
            }
            else if(this.getRotation()==270){
            turn(-270);move(dist);
            }
          
        }
        else if(Greenfoot.isKeyDown("W")){
            if(this.getRotation()==0){
            turn(-90);move(dist);
            }
            else if(this.getRotation()==90){
            turn(-180);move(dist);
            }
            else if(this.getRotation()==180){
            turn(90);move(dist);
            }
            else if(this.getRotation()==270){
            move(dist);
            }
          
        }
        else if(Greenfoot.isKeyDown("A")){
            if(this.getRotation()==0){
            turn(-180);move(dist);
            }
            else if(this.getRotation()==90){
            turn(90);move(dist);
            }
            else if(this.getRotation()==180){
            move(dist);
            }
            else if(this.getRotation()==270){
            turn(90);move(dist);
            }
          
        }
        else if(Greenfoot.isKeyDown("S")){
            if(this.getRotation()==0){
            turn(90);move(dist);
            }
            else if(this.getRotation()==90){
            move(dist);
            }
            else if(this.getRotation()==180){
            turn(-90);move(dist);
            }
            else if(this.getRotation()==270){
            turn(-180);move(dist);
            }
          
        }
        bang cb=(bang)this.getOneIntersectingObject(bang.class);
        if(cb!=null){
            //setImage("blast8.gif");
             //Greenfoot.playSound("blast.wav");
            getWorld().removeObject(this);
        }
    }
}
