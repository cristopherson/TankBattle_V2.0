import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemymissileP2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemymissileP2 extends transport implements enemymissile_O
{
    /**
     * Act - do whatever the enemymissileP2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
        /**
     * Act - do whatever the enemymissile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int counts=0;
    int rot=0;
    public  enemymissileP2(int rotation){
        //super(15,15,"Images/enemymissile.gif",1);
        rot=rotation;
       
        // if(rot==0){move(3);}
        //if(rot==90){turn(90);move(3);}
    }
    public void act() 
    {
      //turn(rot);
      counts++;
      if(rot==0){move_LR(-3);fangxiang();}
      else if(rot==90){move_UD(-3);fangxiang();}
      else if(rot==180){move_LR(3);fangxiang();}
      else if(rot==270){move_UD(3);fangxiang();}
     
     
      valueObj_P1 b=(valueObj_P1)this.getOneIntersectingObject(valueObj_P1.class);//遇到玩家或者P2方
       CannotObj c=(CannotObj)this.getOneIntersectingObject(CannotObj.class);
       enemymissileP1 d=(enemymissileP1)this.getOneIntersectingObject(enemymissileP1.class);
      //steel d=(steel)this.getOneIntersectingObject(steel.class);
       if(b!=null){
            World airWorld1=getWorld();
             airWorld1.addObject( new bangP2(),getX(),getY());  
             getWorld().removeObject(this);
        } else
       if(atWorldEdge()>0||c!=null||counts>=150||d!=null){
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
