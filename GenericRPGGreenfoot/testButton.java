import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class testButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class testButton extends Actor
{
    boolean pressed;
    /**
     * Act - do whatever the testButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this))
        {
            pressed = true;
        }
    }    
    
    public testButton()
    {
        setImage("testButton.png");
        pressed = false;
    }
    
    public boolean getPressed()
    {
        return pressed;
    }
    
    public void resetPressed()
    {
        pressed = false;
    }
}
