import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    private int points;
    private Font myFont = new Font("Comic Sans MS", true, false, 24);
    
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Score() 
    {
        points = 0;
        GreenfootImage img = new GreenfootImage(150,30);
        img.setFont(myFont);
        img.drawString("Score: " + points, 5, 25);
        setImage(img);
    }    
    
    public void addToScore()
    {
        points++;
        GreenfootImage img = getImage();
        img.clear();
        if(points < 10)
        {
            img.drawString("Score: " + points, 5, 25);
        }
        else
        {
            img.drawString("You Win *multiple exclamation marks*" ,5 , 25);
            Greenfoot.stop();
        }
    }
}
