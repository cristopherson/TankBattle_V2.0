import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List; 
import jade.*;
import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.core.behaviours.CyclicBehaviour;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
/**
 * Write a description of class tank_P1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tank_P1 extends transport implements turnObj,valueObj_P1
{
    /**
     * Act - do whatever the tank_P1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private AgentController agent;
    private String name;
    private int count=0;
    private static int COUNTER=0;
    //private int counter=0;
    
    public tank_P1() {
        count = COUNTER++;
        name = "robocode" + count;
        MainRoboJade myJade = new MainRoboJade();    
        agent = myJade.startMyJade("192.168.96.134", "1099",
                name);
    }
    
    public void act() 
    {
        count++;
        // 随机转向
       
        if(Greenfoot.getRandomNumber(300)<0.01){
              turn(90);
        }
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
        bangP2 cb=(bangP2)this.getOneIntersectingObject(bangP2.class);
        if(cb!=null){
            //setImage("blast8.gif");
            Greenfoot.playSound("blast.wav");
            getWorld().removeObject(this);
        }
    }
    /*发现目标，开炮 valueObj_XorP2  Player tank_Boss*/
    public void kaipaoX(){
        
        List<tank_P2> u=getObjectsInRange(150, tank_P2.class);
        int x;int y;
        int dx;int dy;
       if(!u.isEmpty()){
       //     for(int i=0;i<=(u.size());i++){
            tank_P2 obj = u.get(0);     
            x=obj.getX();
            y=obj.getY();
            dx=x-getX();
            dy=y-getY();
            int rotation0=getRotation();
            
            try {
                if (agent != null) {                    
                    agent.putO2AObject(new RoboInfo(name, obj.getX(), obj.getY()), false);
                } else
                    System.out.println("Agent is null");
                }catch (StaleProxyException e) {
                    // TODO Auto-generated catch block
			     e.printStackTrace();
			 }    
           
            
            /*敌方在本方左边*/
            if(dx<0 && -30<=dy && dy<=30){
                turn(0-rotation0);int rotation=getRotation();
                if(count%20==0){Greenfoot.playSound("fire.wav");getWorld().addObject( new enemymissileP1(rotation),getX()-30,getY());}
            }
            /*敌方在本方右边*/
            if(dx>0 && -30<=dy && dy<=30){
                turn(180-rotation0);int rotation=getRotation();
                if(count%20==0){Greenfoot.playSound("fire.wav");getWorld().addObject( new enemymissileP1(rotation),getX()+30,getY());}
            }
            /*敌方在本方上边*/
            if(dy<0 && -30<=dx && dx<=30){
                turn(90-rotation0);int rotation=getRotation();
                if(count%20==0){Greenfoot.playSound("fire.wav");getWorld().addObject( new enemymissileP1(rotation),getX(),getY()-30);}
            }
            /*敌方在本方下边*/
            if(dy>0 && -30<=dx && dx<=30){
                turn(270-rotation0);int rotation=getRotation();
                if(count%20==0){Greenfoot.playSound("fire.wav");getWorld().addObject( new enemymissileP1(rotation),getX(),getY()+30);}
            }
       }
    } 
    
    //闪避
    public void shanbiX(){
    
        List<enemymissileP2> u=getObjectsInRange(250, enemymissileP2.class);
        int x;int y;
        int dx;int dy;
       if(!u.isEmpty()){
       //     for(int i=0;i<=(u.size());i++){
            enemymissileP2 obj = u.get(0);
            
            x=obj.getX();
            y=obj.getY();
            dx=x-getX();
            dy=y-getY();
            //int fangxiang=obj.fangxiang;
            int rotation0=getRotation();
            //if(fangxiang==0) turn(90);
            
            //敌方在本方左边
            if(dx<0 && -20<=dy && dy<=20 ){
                if(rotation0==0||rotation0==180){
                    if(getY()<100)setRotation(270);
                    else if(getY()>500)setRotation(90);
                    else turn(90);
                }
            }
            //敌方在本方右边
            if(dx>0 && -20<=dy && dy<=20){
                if(rotation0==0||rotation0==180){
                    if(getY()<100)setRotation(270);
                    else if(getY()>500)setRotation(90);
                    else turn(90);
                }
            }
            //敌方在本方上边
            if(dy<0 && -20<=dx && dx<=20){
                if(rotation0==90||rotation0==270){
                    if(getX()<100)setRotation(180);
                    else if(getX()>1000)setRotation(0);
                    else turn(90);
                }
            }
            //敌方在本方下边
            if(dy>0 && -20<=dx && dx<=20){
                if(rotation0==90||rotation0==270){
                    if(getX()<100)setRotation(180);
                    else if(getX()>1000)setRotation(0);
                    else turn(90);
                }
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
