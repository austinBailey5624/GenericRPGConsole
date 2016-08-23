import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TownWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TownWorld extends World
{    
    protected final int XDIM = 7;
    protected final int YDIM = 7;
    protected final int OFFSET = 50;
    protected final int TILE_DIM = 100;
    
    public TownWorld()
    {
        super(1000, 700, 1);
        
    }
    /**
     * Constructor for objects of class TownWorld.
     * 
     */
    public TownWorld(Party party, Town town, GameDriver gd)
    {       
        super(1000, 700, 1);
        
        setBackground("background.png");
        addObject(gd , 0, 0);
        
        for (int i = 0; i < YDIM; i++)
        {
            for (int j = 0; j < XDIM; j++)
            {
                addObject(new Grid(town.getBase()[i][j]), j*100 + OFFSET, i*100 + OFFSET);
            }
        }
        
        addObject(new menuButton(), 850, 200);
        addObject(new testButton(), 850, 500);
        addObject(new PlayerToken(), town.getStartLoc()[0]*TILE_DIM + OFFSET, town.getStartLoc()[0]*TILE_DIM + OFFSET); 
    }
}
