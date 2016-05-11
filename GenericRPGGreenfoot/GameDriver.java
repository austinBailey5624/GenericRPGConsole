import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;


/**
 * Write a description of class GameDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameDriver extends Actor
{
    Party m_party;

    //file names
    String worldMapFile = "worldLayout.txt";
    String villagevilleFile = "villageville.txt";
    String awesometownFile = "awesometown.txt";
    String dungeon1File = "dungeon1.txt";

    //create area arrays
    char[][] worldMap = populateArea(worldMapFile);
    char[][] villageville = populateArea(villagevilleFile);
    char[][] awesometown = populateArea(awesometownFile);
    char[][] dungeon1 = populateArea(dungeon1File);

    //create area objects
    RPGWorld world;
    Town villagevilleTown;
    Town awesometownTown;
    Dungeon dungeon1D = new Dungeon(6, 1, dungeon1, m_party, "Dungeon1");
    
    GameWorld worldstart;

    //town array coordinates (x,y)
    int[] vvCoor = {6, 0};
    int[] atCoor = {6, 5};
    int[] dun1Coor = {0, 6};

    boolean inWorld = true;
    boolean inDungeon = false;
    boolean inArea = false;
    boolean keyPressed = false;
    boolean transition = false;
    
    String area = "world";
    
    World w;
    
    private final int TILE_DIM = 100;

    public GameDriver()
    {
        m_party =  new Party();
        worldstart = (GameWorld) getWorld();
      
        world = new RPGWorld(0, 0, worldMap,m_party);
        villagevilleTown = new Town(0, 3, villageville,m_party, "VillageVille");
        awesometownTown = new Town(0, 3, awesometown, m_party, "AwesomeTown");
    }

    /**
     * Act - do whatever the GameDriver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {        
        if(!Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("d"))
        {
            keyPressed = false;
        }
        
        if (inWorld)
        {           
            if(transition)
            {
                area = "world";
                transition = false;
                world.setCurrentToPrevious();
                Greenfoot.setWorld(new GameWorld(m_party, world, this));
                world.displayArea(world.getArea());
            }            
            w = (GameWorld) getWorld();
            
            if(w.getObjects(menuButton.class).get(0).getPressed() == true)
            {
                m_party.menu();
                w.getObjects(menuButton.class).get(0).resetPressed();
            }
            if(w.getObjects(testButton.class).get(0).getPressed() == true)
            {
                w.getObjects(testButton.class).get(0).resetPressed();
                Test test = new Test();
                test.runTests();
            }
            
            w.getObjects(PlayerToken.class).get(0).updateLocation(world.getCurrentLoc()[0], world.getCurrentLoc()[1]);
            if(!keyPressed)
            {
                if(Greenfoot.isKeyDown("w") && world.validMoveCheck(1))
                {
                    inWorld = world.characterMove(1);
                    world.displayArea(world.getArea());
                    w.getObjects(PlayerToken.class).get(0).updateLocation(world.getCurrentLoc()[0], world.getCurrentLoc()[1]);
                    if (!inWorld)
                    {
                        if (world.getCurrentLoc()[0] == vvCoor[0] && world.getCurrentLoc()[1] == vvCoor[1])
                        {
                            area = "vv";
                            TownWorld tw = new TownWorld(m_party, villagevilleTown, this);
                            Greenfoot.setWorld(tw);
                            villagevilleTown.displayArea(villagevilleTown.getArea());
                        }
                        else if (world.getCurrentLoc()[0] == atCoor[0] && world.getCurrentLoc()[1] == atCoor[1])
                        {
                            area = "at";
                            TownWorld tw = new TownWorld(m_party, awesometownTown, this);
                            Greenfoot.setWorld(tw);
                            awesometownTown.displayArea(awesometownTown.getArea());
                        }
                        else if (world.getCurrentLoc()[0] == dun1Coor[0] && world.getCurrentLoc()[1] == dun1Coor[1])
                        {
                            area = "dungeon1";
                            DungeonWorld dw = new DungeonWorld(m_party, dungeon1D, this);
                            Greenfoot.setWorld(dw);
                            dungeon1D.displayArea(dungeon1D.getArea());
                            inDungeon = true;
                        }
                    }
                    keyPressed = true;
                }
                else if(Greenfoot.isKeyDown("a") && world.validMoveCheck(3))
                {
                    inWorld = world.characterMove(3);
                    world.displayArea(world.getArea());
                    w.getObjects(PlayerToken.class).get(0).updateLocation(world.getCurrentLoc()[0], world.getCurrentLoc()[1]);
                    if (!inWorld)
                    {
                        if (world.getCurrentLoc()[0] == vvCoor[0] && world.getCurrentLoc()[1] == vvCoor[1])
                        {
                            area = "vv";
                            TownWorld tw = new TownWorld(m_party, villagevilleTown, this);
                            Greenfoot.setWorld(tw);
                            villagevilleTown.displayArea(villagevilleTown.getArea());
                        }
                        else if (world.getCurrentLoc()[0] == atCoor[0] && world.getCurrentLoc()[1] == atCoor[1])
                        {
                            area = "at";
                            TownWorld tw = new TownWorld(m_party, awesometownTown, this);
                            Greenfoot.setWorld(tw);
                            awesometownTown.displayArea(awesometownTown.getArea());
                        }
                        else if (world.getCurrentLoc()[0] == dun1Coor[0] && world.getCurrentLoc()[1] == dun1Coor[1])
                        {
                            area = "dungeon1";
                            DungeonWorld dw = new DungeonWorld(m_party, dungeon1D, this);
                            Greenfoot.setWorld(dw);
                            dungeon1D.displayArea(dungeon1D.getArea());
                            inDungeon = true;
                        }
                    }
                    keyPressed = true;
                }
                else if(Greenfoot.isKeyDown("s") && world.validMoveCheck(2))
                {
                    inWorld = world.characterMove(2);
                    world.displayArea(world.getArea());
                    w.getObjects(PlayerToken.class).get(0).updateLocation(world.getCurrentLoc()[0], world.getCurrentLoc()[1]);
                    if (!inWorld)
                    {
                        if (world.getCurrentLoc()[0] == vvCoor[0] && world.getCurrentLoc()[1] == vvCoor[1])
                        {
                            area = "vv";
                            TownWorld tw = new TownWorld(m_party, villagevilleTown, this);
                            Greenfoot.setWorld(tw);
                            villagevilleTown.displayArea(villagevilleTown.getArea());
                        }
                        else if (world.getCurrentLoc()[0] == atCoor[0] && world.getCurrentLoc()[1] == atCoor[1])
                        {
                            area = "at";
                            TownWorld tw = new TownWorld(m_party, awesometownTown, this);
                            Greenfoot.setWorld(tw);
                            awesometownTown.displayArea(awesometownTown.getArea());
                        }
                        else if (world.getCurrentLoc()[0] == dun1Coor[0] && world.getCurrentLoc()[1] == dun1Coor[1])
                        {
                            area = "dungeon1";
                            DungeonWorld dw = new DungeonWorld(m_party, dungeon1D, this);
                            Greenfoot.setWorld(dw);
                            dungeon1D.displayArea(dungeon1D.getArea());
                            inDungeon = true;
                        }
                    }
                    keyPressed = true;
                }
                else if(Greenfoot.isKeyDown("d") && world.validMoveCheck(4))
                {
                    inWorld = world.characterMove(4);
                    world.displayArea(world.getArea());
                    w.getObjects(PlayerToken.class).get(0).updateLocation(world.getCurrentLoc()[0], world.getCurrentLoc()[1]);
                    if (!inWorld)
                    {
                        if (world.getCurrentLoc()[0] == vvCoor[0] && world.getCurrentLoc()[1] == vvCoor[1])
                        {
                            area = "vv";
                            TownWorld tw = new TownWorld(m_party, villagevilleTown, this);
                            Greenfoot.setWorld(tw);
                            villagevilleTown.displayArea(villagevilleTown.getArea());
                        }
                        else if (world.getCurrentLoc()[0] == atCoor[0] && world.getCurrentLoc()[1] == atCoor[1])
                        {
                            area = "at";
                            TownWorld tw = new TownWorld(m_party, awesometownTown, this);
                            Greenfoot.setWorld(tw);
                            awesometownTown.displayArea(awesometownTown.getArea());
                        }
                        else if (world.getCurrentLoc()[0] == dun1Coor[0] && world.getCurrentLoc()[1] == dun1Coor[1])
                        {
                            area = "dungeon1";
                            DungeonWorld dw = new DungeonWorld(m_party, dungeon1D, this);
                            Greenfoot.setWorld(dw);
                            dungeon1D.displayArea(dungeon1D.getArea());
                            inDungeon = true;
                        }
                    }
                    keyPressed = true;
                }
            }
        }
        else
        {
            if(!inDungeon)
            {
                w = (TownWorld) getWorld();
                          
                if(w.getObjects(menuButton.class).get(0).getPressed() == true)
                {
                    m_party.menu();
                    w.getObjects(menuButton.class).get(0).resetPressed();
                }
                if(w.getObjects(testButton.class).get(0).getPressed() == true)
                {
                    Test test = new Test();
                    test.runTests();
                }
            
                if(area == "vv")
                {
                    w.getObjects(PlayerToken.class).get(0).updateLocation(villagevilleTown.getCurrentLoc()[0], villagevilleTown.getCurrentLoc()[1]);
                    if(!keyPressed)
                    {
                        if(Greenfoot.isKeyDown("w") && villagevilleTown.validMoveCheck(1))
                        {
                            inArea = villagevilleTown.characterMove(1);
                            villagevilleTown.displayArea(villagevilleTown.getArea());
                            w.getObjects(PlayerToken.class).get(0).updateLocation(villagevilleTown.getCurrentLoc()[0], villagevilleTown.getCurrentLoc()[1]);
                            if (!inArea && villagevilleTown.getBase()[villagevilleTown.getCurrentLoc()[1]][ villagevilleTown.getCurrentLoc()[0]] != 'E')
                            {                            
                                do
                                {
                                    inArea = villagevilleTown.townInteraction(villagevilleTown.getBase()[villagevilleTown.getCurrentLoc()[1]][ villagevilleTown.getCurrentLoc()[0]]);
                                } while (inArea);
                                inArea = true;                            
                            }
                            else if (!inArea)
                            {
                                inWorld = true;
                                transition = true;
                            }
                            
                            keyPressed = true;
                        }
                        else if(Greenfoot.isKeyDown("a") && villagevilleTown.validMoveCheck(3))
                        {
                            inArea = villagevilleTown.characterMove(3);
                            villagevilleTown.displayArea(villagevilleTown.getArea());
                            w.getObjects(PlayerToken.class).get(0).updateLocation(villagevilleTown.getCurrentLoc()[0], villagevilleTown.getCurrentLoc()[1]);
                             if (!inArea && villagevilleTown.getBase()[villagevilleTown.getCurrentLoc()[1]][ villagevilleTown.getCurrentLoc()[0]] != 'E')
                            {
                                do
                                {
                                    inArea = villagevilleTown.townInteraction(villagevilleTown.getBase()[villagevilleTown.getCurrentLoc()[1]][ villagevilleTown.getCurrentLoc()[0]]);
                                } while (inArea);
                                inArea = true; 
                            }
                            else if (!inArea)
                            {
                                inWorld = true;
                                transition = true;
                            }
                            
                            keyPressed = true;
                        }
                        else if(Greenfoot.isKeyDown("s") && villagevilleTown.validMoveCheck(2))
                        {
                            inArea = villagevilleTown.characterMove(2);
                            villagevilleTown.displayArea(villagevilleTown.getArea());
                            w.getObjects(PlayerToken.class).get(0).updateLocation(villagevilleTown.getCurrentLoc()[0], villagevilleTown.getCurrentLoc()[1]);
                             if (!inArea && villagevilleTown.getBase()[villagevilleTown.getCurrentLoc()[1]][ villagevilleTown.getCurrentLoc()[0]] != 'E')
                            {
                                do
                                {
                                    inArea = villagevilleTown.townInteraction(villagevilleTown.getBase()[villagevilleTown.getCurrentLoc()[1]][ villagevilleTown.getCurrentLoc()[0]]);
                                } while (inArea);
                                inArea = true; 
                            }
                            else if (!inArea)
                            {
                                inWorld = true;
                                transition = true;
                            }
                            keyPressed = true;
                        }
                        else if(Greenfoot.isKeyDown("d") && villagevilleTown.validMoveCheck(4))
                        {
                            inArea = villagevilleTown.characterMove(4);
                            villagevilleTown.displayArea(villagevilleTown.getArea());
                            w.getObjects(PlayerToken.class).get(0).updateLocation(villagevilleTown.getCurrentLoc()[0], villagevilleTown.getCurrentLoc()[1]);
                             if (!inArea && villagevilleTown.getBase()[villagevilleTown.getCurrentLoc()[1]][ villagevilleTown.getCurrentLoc()[0]] != 'E')
                            {
                                do
                                {
                                    inArea = villagevilleTown.townInteraction(villagevilleTown.getBase()[villagevilleTown.getCurrentLoc()[1]][ villagevilleTown.getCurrentLoc()[0]]);
                                } while (inArea);
                                inArea = true; 
                            }
                            else if (!inArea)
                            {
                                inWorld = true;
                                transition = true;
                            }
                            keyPressed = true;
                        }
                    }
                }
                else if(area == "at")
                {
                    w.getObjects(PlayerToken.class).get(0).updateLocation(awesometownTown.getCurrentLoc()[0], awesometownTown.getCurrentLoc()[1]);
                    if(!keyPressed)
                    {
                        if(Greenfoot.isKeyDown("w") && awesometownTown.validMoveCheck(1))
                        {
                            inArea = awesometownTown.characterMove(1);
                            awesometownTown.displayArea(awesometownTown.getArea());
                            w.getObjects(PlayerToken.class).get(0).updateLocation(awesometownTown.getCurrentLoc()[0], awesometownTown.getCurrentLoc()[1]);
                            if (!inArea && awesometownTown.getBase()[awesometownTown.getCurrentLoc()[1]][ awesometownTown.getCurrentLoc()[0]] != 'E')
                            {
                                do
                                {
                                     inArea = awesometownTown.townInteraction(awesometownTown.getBase()[awesometownTown.getCurrentLoc()[1]][ awesometownTown.getCurrentLoc()[0]]);
                                } while (inArea);
                                inArea = true; 
                            }
                            else if (!inArea)
                            {
                                inWorld = true;
                                transition = true;
                            }
                            keyPressed = true;
                        }
                        else if(Greenfoot.isKeyDown("a") && awesometownTown.validMoveCheck(3))
                        {
                            inArea = awesometownTown.characterMove(3);
                            awesometownTown.displayArea(awesometownTown.getArea());
                            w.getObjects(PlayerToken.class).get(0).updateLocation(awesometownTown.getCurrentLoc()[0], awesometownTown.getCurrentLoc()[1]);
                            if (!inArea && awesometownTown.getBase()[awesometownTown.getCurrentLoc()[1]][ awesometownTown.getCurrentLoc()[0]] != 'E')
                            {
                                do
                                {
                                    inArea = awesometownTown.townInteraction(awesometownTown.getBase()[awesometownTown.getCurrentLoc()[1]][ awesometownTown.getCurrentLoc()[0]]);
                                } while (inArea);
                                inArea = true; 
                            }
                            else if (!inArea)
                            {
                                inWorld = true;
                                transition = true;
                            }
                            keyPressed = true;
                        }
                        else if(Greenfoot.isKeyDown("s") && awesometownTown.validMoveCheck(2))
                        {
                            inArea = awesometownTown.characterMove(2);
                            awesometownTown.displayArea(awesometownTown.getArea());
                            w.getObjects(PlayerToken.class).get(0).updateLocation(awesometownTown.getCurrentLoc()[0], awesometownTown.getCurrentLoc()[1]);
                            if (!inArea && awesometownTown.getBase()[awesometownTown.getCurrentLoc()[1]][ awesometownTown.getCurrentLoc()[0]] != 'E')
                            {
                                do
                                {
                                     inArea = awesometownTown.townInteraction(awesometownTown.getBase()[awesometownTown.getCurrentLoc()[1]][ awesometownTown.getCurrentLoc()[0]]);
                                } while (inArea);
                                inArea = true; 
                            }
                            else if (!inArea)
                            {
                                inWorld = true;
                                transition = true;
                            }
                            keyPressed = true;
                        }
                        else if(Greenfoot.isKeyDown("d") && awesometownTown.validMoveCheck(4))
                        {
                            inArea = awesometownTown.characterMove(4);
                            awesometownTown.displayArea(awesometownTown.getArea());
                            w.getObjects(PlayerToken.class).get(0).updateLocation(awesometownTown.getCurrentLoc()[0], awesometownTown.getCurrentLoc()[1]);
                            if (!inArea && awesometownTown.getBase()[awesometownTown.getCurrentLoc()[1]][ awesometownTown.getCurrentLoc()[0]] != 'E')
                            {
                                do
                                {
                                     inArea = awesometownTown.townInteraction(awesometownTown.getBase()[awesometownTown.getCurrentLoc()[1]][ awesometownTown.getCurrentLoc()[0]]);
                                } while (inArea);
                                inArea = true; 
                            }
                            else if (!inArea)
                            {
                                inWorld = true;
                                transition = true;
                            }
                            keyPressed = true;
                        }
                    }
                }
            }
            else
            {
                w = (DungeonWorld) getWorld();
                      
                if(w.getObjects(menuButton.class).get(0).getPressed() == true)
                {
                    m_party.menu();
                    w.getObjects(menuButton.class).get(0).resetPressed();
                }
                if(w.getObjects(testButton.class).get(0).getPressed() == true)
                {
                    Test test = new Test();
                    test.runTests();
                }
                
                if(area == "dungeon1")
                {
                    w.getObjects(PlayerToken.class).get(0).updateLocation(dungeon1D.getCurrentLoc()[0], dungeon1D.getCurrentLoc()[1]);
                    if(!keyPressed)
                    {
                        if(Greenfoot.isKeyDown("w") && dungeon1D.validMoveCheck(1))
                        {
                            inArea = dungeon1D.characterMove(1);
                            dungeon1D.displayArea(dungeon1D.getArea());
                            w.getObjects(PlayerToken.class).get(0).updateLocation(dungeon1D.getCurrentLoc()[0], dungeon1D.getCurrentLoc()[1]);
                            
                            if (!inArea)
                            {
                                inWorld = true;
                                transition = true;
                                inDungeon = false;
                            }
                            
                            keyPressed = true;
                        }
                        else if(Greenfoot.isKeyDown("a") && dungeon1D.validMoveCheck(3))
                        {
                            inArea = dungeon1D.characterMove(3);
                            dungeon1D.displayArea(dungeon1D.getArea());
                            w.getObjects(PlayerToken.class).get(0).updateLocation(dungeon1D.getCurrentLoc()[0], dungeon1D.getCurrentLoc()[1]);

                            if (!inArea)
                            {
                                inWorld = true;
                                transition = true;
                                inDungeon = false;
                            }
                            
                            keyPressed = true;
                        }
                        else if(Greenfoot.isKeyDown("s") && dungeon1D.validMoveCheck(2))
                        {
                            inArea = dungeon1D.characterMove(2);
                            dungeon1D.displayArea(dungeon1D.getArea());
                            w.getObjects(PlayerToken.class).get(0).updateLocation(dungeon1D.getCurrentLoc()[0], dungeon1D.getCurrentLoc()[1]);
                            if (!inArea)
                            {
                                inWorld = true;
                                transition = true;
                                inDungeon = false;
                            }
                            keyPressed = true;
                        }
                        else if(Greenfoot.isKeyDown("d") && dungeon1D.validMoveCheck(4))
                        {
                            inArea = dungeon1D.characterMove(4);
                            dungeon1D.displayArea(dungeon1D.getArea());
                            w.getObjects(PlayerToken.class).get(0).updateLocation(dungeon1D.getCurrentLoc()[0], dungeon1D.getCurrentLoc()[1]);
                            if (!inArea)
                            {
                                inWorld = true;
                                transition = true;
                                inDungeon = false;
                            }
                            keyPressed = true;
                        }
                    }                
                }
            }
        }

        
       
        
        /*
        //visit VillageVille
        if (world.getCurrentLoc()[0] == vvCoor[0] && world.getCurrentLoc()[1] == vvCoor[1])
        {
            do
            {
                villagevilleTown.displayArea(villagevilleTown.getArea());
                villagevilleTown.menuInteraction();
            } while (villagevilleTown.inArea());
        }
        //visit AwesomeTown
        else if (world.getCurrentLoc()[0] == atCoor[0] && world.getCurrentLoc()[1] == atCoor[1])
        {
            do
            {
                awesometownTown.displayArea(awesometownTown.getArea());
                awesometownTown.menuInteraction();
            } while (awesometownTown.inArea());
        }
        //visit dungeon1
        else if (world.getCurrentLoc()[0] == dun1Coor[0] && world.getCurrentLoc()[1] == dun1Coor[1])
        {
            do
            {
                dungeon1D.displayArea(dungeon1D.getArea());
                dungeon1D.menuInteraction();
            } while (dungeon1D.inArea());
        }

        //return to world, return to previous coordinates
        world.setCurrentToPrevious();
        */
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
                                b = (char) inbr.read(); //skip bad character
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
