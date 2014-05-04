import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List; 
/**
 * Write a description of class tank_P2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tank_P2 extends transport implements turnObj,valueObj_XorP2
{
    /**
     * Act - do whatever the tank_P1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public tank_P2(int rot){
    int rotP2=rot;
    turn(rotP2);
    }
    private int count=0;
    
    
    //private int counter=0;
    public void act() 
    {
        count++;
       
        
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
              
        //遇到物体，转向
        //turnObj b=(turnObj)this.getOneIntersectingObject(turnObj.class);
        //if(b!=null){turn(90);}
        if(isTurn()){turn(90);move(-dist);}
        else{
             if(atWorldEdge()==0){
                 if(Greenfoot.getRandomNumber(600)<0.01){
                     turn(90);
                 }
                 move(-dist);
             }
        if(atWorldEdge()==1){setLocation(getX(),getY()+d_gety+1);turn(90);}
        if(atWorldEdge()==12){setLocation(getX()-d_getx-1,getY()+d_gety+1);turn(90);}
        if(atWorldEdge()==2){setLocation(getX()-d_getx-1,getY());turn(90);}
        if(atWorldEdge()==23){setLocation(getX()-d_getx-1,getY()-d_gety-1);turn(90);}
        if(atWorldEdge()==3){setLocation(getX(),getY()-d_gety-1);turn(90);}
        if(atWorldEdge()==34){setLocation(getX()+d_getx+1,getY()-d_gety-1);turn(90);}
        if(atWorldEdge()==4){setLocation(getX()+d_getx+1,getY());turn(90);}
        if(atWorldEdge()==41){setLocation(getX()+d_getx+1,getY()+d_gety+1);turn(90);}
        
            //遇到炮弹 闪避
            shanbiX();
            // 遇到玩家 开炮
            kaipaoX();
           
        }
        //遇到炸弹，消失
       xiaoshi();
       
    }
    
    //遇到炸弹，消失
    public void xiaoshi(){
        bang cb=(bang)this.getOneIntersectingObject(bang.class);
        if(cb!=null){
            //setImage("blast8.gif");
             Greenfoot.playSound("blast.wav");
            getWorld().removeObject(this);
        }
    }
    /*发现目标，开炮 valueObj_XorP2  Player tank_Boss*/
    public void kaipaoX(){
        
        List<tank_P1> u=getObjectsInRange(500, tank_P1.class);
        int x;int y;
        int dx;int dy;
       if(!u.isEmpty()){
       //     for(int i=0;i<=(u.size());i++){
            tank_P1 obj = u.get(0);     
            x=obj.getX();
            y=obj.getY();
            dx=x-getX();
            dy=y-getY();
            int rotation0=getRotation();
            /*敌方在本方左边*/
            if(dx<0 && -30<=dy && dy<=30){
                turn(0-rotation0);int rotation=getRotation();
                if(count%50==0){Greenfoot.playSound("fire.wav");getWorld().addObject( new enemymissileP2(rotation),getX()-30,getY());}
            }
            /*敌方在本方右边*/
            if(dx>0 && -30<=dy && dy<=30){
                turn(180-rotation0);int rotation=getRotation();
                if(count%50==0){Greenfoot.playSound("fire.wav");getWorld().addObject( new enemymissileP2(rotation),getX()+30,getY());}
            }
            /*敌方在本方上边*/
            if(dy<0 && -30<=dx && dx<=30){
                turn(90-rotation0);int rotation=getRotation();
                if(count%50==0){Greenfoot.playSound("fire.wav");getWorld().addObject( new enemymissileP2(rotation),getX(),getY()-30);}
            }
            /*敌方在本方下边*/
            if(dy>0 && -30<=dx && dx<=30){
                turn(270-rotation0);int rotation=getRotation();
                if(count%50==0){Greenfoot.playSound("fire.wav");getWorld().addObject( new enemymissileP2(rotation),getX(),getY()+30);}
            }
       }
    } 
    
    //闪避
    public void shanbiX(){
    
        List<enemymissileP1> u=getObjectsInRange(200, enemymissileP1.class);
        int x;int y;
        int dx;int dy;
       if(!u.isEmpty()){
       //     for(int i=0;i<=(u.size());i++){
            enemymissileP1 obj = u.get(0);
            
            x=obj.getX();
            y=obj.getY();
            dx=x-getX();
            dy=y-getY();
            //int fangxiang=obj.fangxiang;
            int rotation0=getRotation();
            //if(fangxiang==0) turn(90);
            
            //敌方在本方左边
            if(dx<0 && -20<=dy && dy<=20 ){
                if(rotation0==0||rotation0==180)turn(90);
            }
            //敌方在本方右边
            if(dx>0 && -20<=dy && dy<=20){
                if(rotation0==0||rotation0==180)turn(90);
            }
            //敌方在本方上边
            if(dy<0 && -20<=dx && dx<=20){
                if(rotation0==90||rotation0==270)turn(90);
            }
            //敌方在本方下边
            if(dy>0 && -20<=dx && dx<=20){
                if(rotation0==90||rotation0==270)turn(90);
            }
            
                       
        }
    } 
    //遇到物体，是否转向
    public boolean isTurn(){
    List<turnObj> u=getObjectsInRange(29, turnObj.class);
    if(!u.isEmpty()) return true;
    else return false;
    }
}
