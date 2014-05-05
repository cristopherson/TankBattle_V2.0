import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TankBattle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TankBattle extends World
{

    /**
     * Constructor for objects of class TankBattle.
     * 
     */
    
    public TankBattle()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100,600, 1);  
        
        addObject(new tank_P1(),1050,200);
        addObject(new tank_P1(),1050,550);
        addObject(new tank_P1(),1050,350);
        addObject(new tank_P1(),1050,150);
        addObject(new tank_P1(),1050,420);
        addObject(new tank_P1(),1050,50);
        addObject(new tank_P1(),1050,500);
        addObject(new tank_P1(),1050,100);
        addObject(new tank_P1(),1050,270);
        
        addObject(new tank_P2(180),1100-1050,600-200);
        addObject(new tank_P2(180),1100-1050,600-550);
        addObject(new tank_P2(180),1100-1050,600-350);
        addObject(new tank_P2(180),1100-1050,600-150);
        addObject(new tank_P2(180),1100-1050,600-420);
        addObject(new tank_P2(180),1100-1050,600-50);
        addObject(new tank_P2(180),1100-1050,600-500);
        addObject(new tank_P2(180),1100-1050,600-100);
        addObject(new tank_P2(180),1100-1050,600-270);

        
        //addObject(new steel(),350,0);
        //addObject(new steel(),350,30);
        //addObject(new steel(),350,60);
        addObject(new steel(),350,90);
        addObject(new steel(),350,120);
        addObject(new steel(),350,150);
        addObject(new steel(),350,180);
        //addObject(new steel(),380,0);
        //addObject(new steel(),380,30);
        //addObject(new steel(),380,60);
        addObject(new steel(),380,90);
        addObject(new steel(),380,120);
        addObject(new steel(),380,150);
        addObject(new steel(),380,180); 
        
        
        //addObject(new steel(),1100-350,600-0);
        //addObject(new steel(),1100-350,600-30);
        //addObject(new steel(),1100-350,600-60);
        addObject(new steel(),1100-350,600-90);
        addObject(new steel(),1100-350,600-120);
        addObject(new steel(),1100-350,600-150);
        addObject(new steel(),1100-350,600-180);
       // addObject(new steel(),1100-380,600-0);
        //addObject(new steel(),1100-380,600-30);
        //addObject(new steel(),1100-380,600-60);
        addObject(new steel(),1100-380,600-90);
        addObject(new steel(),1100-380,600-120);
        addObject(new steel(),1100-380,600-150);
        addObject(new steel(),1100-380,600-180);
        /*
        addObject(new steel(),550,270);
        addObject(new steel(),550,300);
        addObject(new steel(),550,330);
        */
       /*
        addObject(new steel(),770,230);
        addObject(new steel(),770,200);
        addObject(new steel(),770,170);
        */
       /*
        addObject(new steel(),1100-770,600-230);
        addObject(new steel(),1100-770,600-200);
        addObject(new steel(),1100-770,600-170);
        */
        addObject(new steel(),610,110);
        addObject(new steel(),580,110);
        addObject(new steel(),520,110);
        addObject(new steel(),550,110);
        addObject(new steel(),490,110);
        
        addObject(new steel(),1100-610,600-110);
        addObject(new steel(),1100-580,600-110);
        addObject(new steel(),1100-520,600-110);
        addObject(new steel(),1100-550,600-110);
        addObject(new steel(),1100-490,600-110);
        
        /*
        addObject(new steel(),920,360);
        addObject(new steel(),920,390);
        addObject(new steel(),920,420);
        addObject(new steel(),920,450);
        addObject(new steel(),920,480);
        
        addObject(new steel(),1100-920,600-360);
        addObject(new steel(),1100-920,600-390);
        addObject(new steel(),1100-920,600-420);
        addObject(new steel(),1100-920,600-450);
        addObject(new steel(),1100-920,600-480);
        */
        addObject(new steel(),950,110);
        addObject(new steel(),950,140);
        addObject(new steel(),980,110);
        addObject(new steel(),980,140);
        
        addObject(new steel(),1100-950,600-110);
        addObject(new steel(),1100-950,600-140);
        addObject(new steel(),1100-980,600-110);
        addObject(new steel(),1100-980,600-140);
    }
}
