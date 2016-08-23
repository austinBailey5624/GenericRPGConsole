import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RPGWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RPGWorld extends Actor
{
    //dimension and coordinate max constants
    public static final int areaXDim = 7; //max x-axis length
    public static final int areaYDim = 7; //max y-axis length
    
    //constant variables for easier code reading
    private final char path = 'P'; //character for path
    private final char player = '@'; //character for the player
    private final char chest = 'C'; //character for chest
    private final char town = 'T'; //character for tree
    private final char dungeon = 'D'; //character for dungeon
    
    //A party for the world to work with
    Party m_party;   

    //dimension and coordinate constants
    private int startLocX; //x-coordinate start location
    private int startLocY; //y-coordinate start location

    //current location variable set
    private int curPosX = 0;
    private int curPosY = 0;
    private int prevPosX = 0;
    private int prevPosY = 0;
    private boolean stillInArea;

    //current map with player token
    private char[][] areaArrBase = new char[areaYDim][areaXDim];
    private char[][] curAreaArr = new char[areaYDim][areaXDim];

    //game exit variable
    private boolean gameExit = false;

    //found chest/item variable
    private boolean chestFound = false;

    //constructors

    /**
     * @param : (pre) None
     * @param : (post) Creates a new object of type World with set parameters
     * @return : None
     */
    public RPGWorld(int x, int y, char[][] worldBase,Party party)
    {
        m_party = party;
        startLocX = x;
        startLocY = y;
        curPosX = startLocX;
        curPosY = startLocY;

        areaArrBase = setBaseArea(worldBase);
        curAreaArr = resetArea(curAreaArr, areaArrBase);
        curAreaArr[curPosY][curPosX] = player;
    }
    
    //run 
    
    /**
     * Act - do whatever the RPGWorld wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }  
    //get/set methods
   
    /**
     * @param : (pre) curAreaArr initialized
     * @param : (post) None
     * @return : Return the 2d array for the current area
     */
    public char[][] getArea()
    {
        return curAreaArr;
    }
    
    public char[][] getBase()
    {
        return areaArrBase;
    }

    /**
     * @param : (pre) curPosX and curPosY initialized
     * @param : (post) None
     * @return : Returns a 2-element array containing (x, y) coordinates
     */
    public int[] getCurrentLoc()
    {
        int temp[] = {curPosX, curPosY};
        return temp;
    }   

    /**
     * @param : (pre) None
     * @param : (post) Sets the current position to the previous position
     * @return : None
     */
    public void setCurrentToPrevious()
    {
        curPosX = prevPosX;
        curPosY = prevPosY;
    }   

    /**
     * @param : (pre) Initialized gameExit variable
     * @param : (post) None
     * @return : Returns the value of gameExit
     */
    public boolean getGameExit()
    {
        return gameExit;
    }

    //checking methods

    /**
     * @param : (pre) Initialized variable, stillInArea
     * @param : (post) None
     * @return : Returns true if still in the area, false otherwise
     */
    public boolean inArea()
    {
        return stillInArea;
    }   

    /**
     * @param : (pre) Movement direction chosen (sel)
     * @param : (post) Checks to see if the spot moved to is valid spot
     * @return : Returns true if the move is valid, false otherwise
     */
    public boolean validMoveCheck(int sel)
    {
        int tempX = 0, tempY = 0;

        switch(sel)
        {
            case 1: //up
            tempX = curPosX;
            tempY = curPosY - 1;
            break;
            case 2: //down
            tempX = curPosX;
            tempY = curPosY + 1;
            break;
            case 3: //left
            tempX = curPosX - 1;
            tempY = curPosY;
            break;
            case 4: //right
            tempX = curPosX + 1;
            tempY = curPosY;
            break;
            case 5: //menu, stay in same spot
            tempX = curPosX;
            tempY = curPosY;
            break;
        }
        if (sel == 5)
        {
            return true;
        }
        else if(tempY < 0 || tempY > (areaYDim - 1))
        {
            return false;
        }
        else if(tempX < 0 || tempX > (areaXDim - 1))
        {
            return false;
        }
        else
        {
            if(areaArrBase[tempY][tempX] == path || areaArrBase[tempY][tempX] == town || areaArrBase[tempY][tempX] == dungeon)
            {
                return true;
            }
            else if (areaArrBase[tempY][tempX] == chest)
            {
                chestFound = true;
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    //interaction methods
    
    /**
     * @param : (pre) Existing Twon object
     * @param : (post) Handles all menu interaction and display for traversing through the town
     * @return : None
     *
    public void menuInteraction()
    {
        final String menu = "\n\nYou are currently at the coordinate (" + curPosX + ", " + curPosY + "). Which direction would you like to move?\n" +
            "1. Up\n" +
            "2. Down\n" +
            "3. Left\n" +
            "4. Right\n" +
            "5. Menu\n" +
                //"6. Exit Game\n" +
            "Your Choice: ";
        String input; //input as string
        double selDouble; //menu selection as double
        int selection; //menu selection as integer
        Scanner in = new Scanner(System.in); //input scanner
        System.out.print(menu); //display menu options
        input = in.next(); //get user input
        if(!((input.equals("w"))||(input.equals("a"))||(input.equals("s"))||(input.equals("d"))))
        {
            while(!menuInputCheck(input, 1, 6, true)) //check if entry is valid, repeat input if not//TODO rewrite for wasd implementation
            {
                System.out.print("Invalid menu selection, please choose an integer between 1 and 4 and a\ndestination along the path denoted by P.\nYour choice: ");
                input = in.next();
            }

            selDouble = Double.parseDouble(input); //safe parse
            selection = (int) selDouble; //set selection
        }
        else
        {
            selection=7;//dummy value outside of range
        }

        if(input.equals("w"))
        {
            selection = 1;
        }
        else if (input.equals("a"))
        {
            selection = 3;
        }
        else if (input.equals("s")) 
        {
            selection = 2;
        }
        else if (input.equals("d"))
        {
            selection = 4;
        }

        if(validMoveCheck(selection))
        {
            if (selection < 5)
            {
                stillInArea = characterMove(selection); //store if still in world
                //clearScreen();
            }
            else if(selection==5)
            {
                m_party.menu();
            }
            else if(input.equals("w"))
            {
                stillInArea=characterMove(1);
            }
            else if(input.equals("a"))
            {
                stillInArea=characterMove(3);
            }
            else if(input.equals("s"))
            {
                stillInArea=characterMove(2);
            }
            else if(input.equals("d"))
            {
                stillInArea=characterMove(4);
            }
            else if(selection==6)
            {
                gameExit = true;
            }
            else
            {
                System.out.println("Sorry, we didn't understand your input");
            }
        }
        else
        {
            System.out.println("Invalid move.");
            displayArea(curAreaArr);
            menuInteraction();
        }

        if (chestFound == true)
        {
            foundChest();
        }
    }

    /**
     * @param : (pre) Movement selection has been made
     * @param : (post) Checks to see if player has reached a town border
     * @return : Returns true if player is still in the town, false otherwise
     */
    public boolean characterMove(int sel)
    {
        int tempX = 0, tempY = 0;
        boolean inArea = true;
        
        if(validMoveCheck(sel))
        {
            switch(sel)
            {
                case 1: //up
                tempX = curPosX;
                tempY = curPosY - 1;
                break;
                case 2: //down
                tempX = curPosX;
                tempY = curPosY + 1;
                break;
                case 3: //left
                tempX = curPosX - 1;
                tempY = curPosY;
                break;
                case 4: //right
                tempX = curPosX + 1;
                tempY = curPosY;
                break;
            }
    
            prevPosX = curPosX;
            prevPosY = curPosY;
            curPosX = tempX;
            curPosY = tempY;
    
            if (areaArrBase[tempY][tempX] == town || areaArrBase[tempY][tempX] == dungeon)
            {
                inArea = false;
            }
            else
            {
                if (areaArrBase[tempY][tempX] == chest)
                {
                    areaArrBase[tempY][tempX] = path;
                }
                curAreaArr = resetArea(curAreaArr, areaArrBase);
                curAreaArr[tempY][tempX] = player;
                inArea = true;
            }
        }
        
        return inArea;
    }

    /**
     * @param : (pre) Existing class object that implements Place
     * @param : (post) Displays the current area map with player token
     * @return : None
     */
    public void displayArea(char[][] area)
    {
        boolean isForest=false;
        boolean isMountain=false;
        boolean isPath=false;
        boolean isTown=false;
        for (int i = 0; i < areaYDim; i++)
        {
            System.out.print("\n");
            for (int j = 0; j < areaXDim; j++)
            {
                System.out.print(area[i][j] + " ");
                if(area[i][j]=='F')
                {
                    isForest=true;
                }
                else if(area[i][j]=='M')
                {
                    isMountain=true;
                }
                else if(area[i][j]=='P')
                {
                    isPath=true;
                }
                else if(area[i][j]=='T')
                {
                    isTown=true;
                }
            }
        }
        System.out.print("\n");

        if(isForest)
        {
            System.out.println("F: Forest");
        }
        if(isMountain)
        {
            System.out.println("M: Mountain");
        }   
        if(isPath)
        {
            System.out.println("P: Path");
        }
        if(isTown)
        {
            System.out.println("T: Town");
        }
    }

    /**
     * @param : (pre) Existing class object that implements Place
     * @param : (post) Sets the base area map for the object
     * @return : Returns the array containing the base area
     */
    public char[][] setBaseArea(char[][] area)
    {
        char[][] base = new char[area.length][area[0].length];

        for (int i = 0; i < areaYDim; i++)
        {
            for (int j = 0; j < areaXDim; j++)
            {
                base[i][j] = area[i][j];
            }
        }

        return base;
    }

    /**
     * @param : (pre) Existing class object that implements Place
     * @param : (post) Duplicates the passed base area array, effective reset of the area with no player token
     * @return : Returns the duplicated array
     */
    public char[][] resetArea(char[][] currentArea, char[][] baseArea)
    {
        for (int i = 0; i < areaYDim; i++)
        {
            for (int j = 0; j < areaXDim; j++)
            {
                currentArea[i][j] = baseArea[i][j];
            }
        }

        return currentArea;
    }

    public void foundChest()
    {
        int chestID = 1; //placeholder
        Chest newChest = new Chest(chestID); //placeholder
        m_party.openChest(newChest);
        chestFound = false;     
    }
}
