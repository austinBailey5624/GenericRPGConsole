import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    protected final int XDIM = 7;
    protected final int YDIM = 7;
    protected final int OFFSET = 50;
    protected final int TILE_DIM = 100;
    
    String worldMapFile = "worldLayout.txt";
    char[][] worldMap = populateArea(worldMapFile);
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        
        setBackground("background.png");
        addObject(new GameDriver(), 0, 0);
        
        for (int i = 0; i < YDIM; i++)
        {
            for (int j = 0; j < XDIM; j++)
            {
                addObject(new Grid(worldMap[i][j]), j*100 + OFFSET, i*100 + OFFSET);
            }
        }
        addObject(new menuButton(), 850, 200);
        addObject(new testButton(), 850, 500);
        addObject(new PlayerToken(), OFFSET, OFFSET);
    }
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld(Party party, RPGWorld world, GameDriver gd)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        
        setBackground("background.png");
        addObject(gd, 0, 0);
        
        for (int i = 0; i < YDIM; i++)
        {
            for (int j = 0; j < XDIM; j++)
            {
                addObject(new Grid(worldMap[i][j]), j*100 + OFFSET, i*100 + OFFSET);
            }
        }
        
        addObject(new menuButton(), 850, 200);
        addObject(new testButton(), 850, 500);
        addObject(new PlayerToken(), world.getCurrentLoc()[0]*TILE_DIM + OFFSET, world.getCurrentLoc()[1]*TILE_DIM + OFFSET);
    }
    
    public char[][] populateArea(String fileName)
    {
        //file i/o
        FileReader in;
        BufferedReader inbr;
        char[][] tempWorld = new char[7][7];

        try
        {
            in = new FileReader(fileName);
            inbr = new BufferedReader(in);
            int a = 0;

            for (int i = 0; i < 7; i++)
            {
                for (int j = 0; j < 7; j++)
                {
                    if ((a = inbr.read()) != -1)
                    {
                        char b = (char) a;
                        if (b != '\r' && b != '\n') // '\r' will be followed by '\n'
                        {
                            tempWorld[i][j] = b;
                        }
                        else
                        {
                            b = (char) inbr.read(); //skip bad character
                            if (b == '\r' || b == '\n')
                            {
                                b = (char) inbr.read    (); //skip bad character
                            }
                            tempWorld[i][j] = b; //grab first character on new line
                        }
                    }
                }
            }
            //close reader
            in.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return tempWorld;
    }
}
