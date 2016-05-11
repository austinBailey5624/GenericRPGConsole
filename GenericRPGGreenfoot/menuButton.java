import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * Write a description of class menuButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class menuButton extends Actor
{
    boolean pressed;
    /**
     * Act - do whatever the menuButton wants to do. This method is called whenever
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
    
    public menuButton()
    {
        setImage("menuButton.png");
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
