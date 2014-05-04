import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class transport here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class transport extends Actor
{
    /**
     * Act - do whatever the transport wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
        //int rotation=0;
        public  int super_x=1100;
        public int super_y=600;
        public int bianchang=40;
        public int dist=1;
    public int atWorldEdge(){
        
        /*碰到上水平框*/
        if(getY()<=getImage().getHeight()/2){
            return 1;
        }
        /*右上角*/
        if(getY()<=getImage().getHeight()/2 && 
            getX()>=getWorld().getWidth()-getImage().getWidth()/2){
            return 12;
        }
        /*碰到右框*/
        if(getX()>=getWorld().getWidth()-getImage().getWidth()/2){
            return 2;
        }
        /*右下角*/
        if(getX()>=getWorld().getWidth()-getImage().getWidth()/2 && 
            getY()>=getWorld().getHeight()-getImage().getHeight()/2){
            return 23;
        }
        /*下框*/
        if(getY()>=getWorld().getHeight()-getImage().getHeight()/2){
            return 3;
        }
        /*左下角*/
        if(getY()>=getWorld().getHeight()-getImage().getHeight()/2 && 
            getX()<=getImage().getWidth()/2){
            return 34;
        }
        /*左框*/
        if(getX()<=getImage().getWidth()/2){
            return 4;
        }
        /*左上角*/
        if(getX()<=getImage().getWidth()/2 && 
            getY()<=getImage().getHeight()/2){
            return 41;
        }else/*没有碰到任何边界*/
        return 0;
    } 
    /*
    public void move(int distx,int disty)
    {
        setLocation (getX() + distx, getY()+disty);

    }
    */
       public void move_LR(int dist)//水平移动
    {
        setLocation (getX() + dist, getY());

    }
    public void move_UD(int dist)//上下移动
    {
        setLocation (getX() , getY()+ dist);

    }
    
   
    
}
