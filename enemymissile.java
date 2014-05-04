import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemymissile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemymissile extends transport implements enemymissile_XorP2
{
    /**
     * Act - do whatever the enemymissile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int rot=0;
    public int fangxiang=0;
    public  enemymissile(int rotation){
        //super(15,15,"Images/enemymissile.gif",1);
        rot=rotation;
       //fangxiang();
       
       if(rot==0){ fangxiang= 4;}
        else if(rot==90){  fangxiang= 1;}
        else if(rot==180){  fangxiang= 2;}
        else if(rot==270){  fangxiang= 3;}
        
        // if(rot==0){move(3);}
        //if(rot==90){turn(90);move(3);}
    }
    public void act() 
    {
      //turn(rot);
      if(rot==0){move_LR(4);}
      else if(rot==90){move_UD(4);}
      else if(rot==180){move_LR(-4);}
      else if(rot==270){move_UD(-4);}
     
      valueObj_P1 b=(valueObj_P1)this.getOneIntersectingObject(valueObj_P1.class);
      CannotObj c=(CannotObj)this.getOneIntersectingObject(CannotObj.class);
      //steel d=(steel)this.getOneIntersectingObject(steel.class);
      
        if(b!=null){
            World airWorld1=getWorld();
             airWorld1.addObject( new bang(),getX(),getY());  
             getWorld().removeObject(this);
        } else
       if(atWorldEdge()>0|| c!=null){
           getWorld().removeObject(this);
        }
    }
    //返回一个方向值
    public int fangxiang(){
        int rot1=rot;
        if(rot1==0){ return 4;}
        else if(rot1==90){  return 1;}
        else if(rot1==180){  return 2;}
        else if(rot1==270){  return 3;}
        else return 0;
    }
       
}
