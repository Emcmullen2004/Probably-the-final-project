
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{    
    private int attackDelay = 0;
    private int Delay = 0;
    public boolean attackInvincibility = false;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        attack();
    }    
    
    private void move()
    {
        if(Greenfoot.isKeyDown("a") == true)
        {
            setLocation(getX()-3, getY());
        }
        
        if(Greenfoot.isKeyDown("d") == true)
        {
            setLocation(getX()+3, getY());
        }
    }
    
    private void attack()
    {
        attackDelay++;
        Delay++;
        if(Greenfoot.isKeyDown("s") == true && attackDelay >= 50)
        {
            attackInvincibility = true;
            Delay = 0;
            attackDelay = 0;
        }
        
        if(attackInvincibility == true)
        {
            if(Delay == 0)
            {
                setImage("ThatGuy attack part 1.png");;
            }
            
            if(isTouching(Enemy.class) == true)
            {
                removeTouching(Enemy.class);
                ( (MyWorld)getWorld() ).update();
            }
            
            if(Delay == 5)
            {
                setImage("ThatGuy attack 2.png");
            }
            
            if(Delay >= 20)
            {
                setImage("ThatGuy.png");
                attackInvincibility = false;
                Delay = 0;
            }
        }
        
        else
        {
            if(isTouching(Enemy.class) && attackInvincibility == false)
            {
                getWorld().removeObject(this);
                Greenfoot.stop();
            }
        }
    }
}
