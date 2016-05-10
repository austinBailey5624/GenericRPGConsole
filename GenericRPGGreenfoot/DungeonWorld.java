import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DungeonWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DungeonWorld extends World
{
    protected final int XDIM = 7;
    protected final int YDIM = 7;
    protected final int OFFSET = 50;
    protected final int TILE_DIM = 100;
    
    public DungeonWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
    }
    /**
     * Constructor for objects of class TownWorld.
     * 
     */
    public DungeonWorld(Party party, Dungeon dungeon, GameDriver gd)
    {       
        super(1000, 700, 1);
        
        setBackground("background.png");
        addObject(gd , 0, 0);
        
        for (int i = 0; i < YDIM; i++)
        {
            for (int j = 0; j < XDIM; j++)
            {
                addObject(new Grid(dungeon.getBase()[i][j]), j*100 + OFFSET, i*100 + OFFSET);
            }
        }
        
        addObject(new PlayerToken(), dungeon.getStartLoc()[0]*TILE_DIM + OFFSET, dungeon.getStartLoc()[0]*TILE_DIM + OFFSET); 
    }
}
