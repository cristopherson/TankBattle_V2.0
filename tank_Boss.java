import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List; 
/**
 * Write a description of class tank_Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tank_Boss extends transport implements turnObj
{
    /**
     * Act - do whatever the tank_Boss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public void act() 
    {
        int d_getx;
        int d_gety;
        if(getX()>super_x/2){
        d_getx=bianchang/2-(super_x-getX());
        }else 
        d_getx=bianchang/2-getX();
        if(getY()>super_y/2){
        d_gety=bianchang/2-(super_y-getY());
        }else 
        d_gety=bianchang/2-getY();
        int rand = Greenfoot.getRandomNumber(3);
               
        if(atWorldEdge()==0){move(-dist);}
        if(atWorldEdge()==1){setLocation(getX(),getY()+d_gety+1);turn(90);}
        if(atWorldEdge()==12){setLocation(getX()-d_getx-1,getY()+d_gety+1);turn(90);}
        if(atWorldEdge()==2){setLocation(getX()-d_getx-1,getY());turn(90);}
        if(atWorldEdge()==23){setLocation(getX()-d_getx-1,getY()-d_gety-1);turn(90);}
        if(atWorldEdge()==3){setLocation(getX(),getY()-d_gety-1);turn(90);}
        if(atWorldEdge()==34){setLocation(getX()+d_getx+1,getY()-d_gety-1);turn(90);}
        if(atWorldEdge()==4){setLocation(getX()+d_getx+1,getY());turn(90);}
        if(atWorldEdge()==41){setLocation(getX()+d_getx+1,getY()+d_gety+1);turn(90);}
        
        //遇到物体，转向
        turnObj b=(turnObj)this.getOneIntersectingObject(turnObj.class);
        if(b!=null){turn(90);}
        
       // 随机转向
        if(Greenfoot.getRandomNumber(100)<0.2){
              turn(90);
        }
        //遇到炸弹，消失
       xiaoshi();
    }
    
    //遇到炸弹，消失
    public void xiaoshi(){
        bang cb=(bang)this.getOneIntersectingObject(bang.class);
        if(cb!=null){
            //setImage("blast8.gif");
             //Greenfoot.playSound("blast.wav");
            getWorld().removeObject(this);
        }
    }
    /*发现目标，开炮*/
    public void kaipao(){
    
    }
    
}
