import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Grid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grid extends Actor
{

    /**
     * Constructor for objects of class Grid
     */
    public Grid(char type)
    {
        if (type == 'G')
        {
            setImage("grass.png");
        }
        else if (type == 'P')
        {
            setImage("path.png");
        }
        else if (type == 'T')
        {
            setImage("town.png");
        }
        else if (type == 'D')
        {
            setImage("dungeon.png");
        }
        else if (type == 'W')
        {
            setImage("water.png");
        }
    }
}
