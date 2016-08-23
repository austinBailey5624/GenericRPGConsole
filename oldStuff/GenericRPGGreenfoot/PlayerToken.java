import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerToken here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerToken extends Actor
{    
    /**
     * Act - do whatever the PlayerToken wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        turn(1);
    }    
    
    public PlayerToken()
    {
        setImage("player.png");
    }
    
    public void updateLocation(int x, int y)
    {
        setLocation(x*100 + 50, y*100 + 50);
    }
}
