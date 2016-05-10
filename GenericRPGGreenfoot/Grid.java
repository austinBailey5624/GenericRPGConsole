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
        else if (type == 'S')
        {
            setImage("shop.png");
        }
        else if (type == 'A')
        {
            setImage("arena.png");
        }
        else if (type == 'I')
        {
            setImage("inn.png");
        }
        else if (type == 'L')
        {
            setImage("library.png");
        }
        else if (type == 'E')
        {
            setImage("exit.png");
        }
        else if (type == 'B')
        {
            setImage("boss.png");
        }
        else if (type == 'C')
        {
            setImage("chest.png");
        }
    }
}
