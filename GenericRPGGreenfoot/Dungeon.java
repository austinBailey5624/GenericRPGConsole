import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;

/**
 * Write a description of class Dungeon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dungeon extends Actor
{
    String m_name;
    Party m_party;
    
    //   PlayerActor m_user;
    Shop[] shops=Shop.getAllShops();
    Arena[] arenas=Arena.getAllArenas();
    
    //dimension and coordinate max constants
    public static final int areaXDim = 7; //max x-axis length
    public static final int areaYDim = 7; //max y-axis length

    //dimension and coordinate constants
    private int startLocX; //x-coordinate start location
    private int startLocY; //y-coordinate start location
    private int exitLocX; //x-coordinate exit location
    private int exitLocY; //y-coordinate exit location

    //constant variables for easier code reading
    private final char path = 'P'; //character for path
    private final char player = '@'; //character for the player
    private final char chest = 'C'; //character for chest
    private final char boss = 'B'; //character for boss
    private final char wall = 'W'; //character for wall
    private final char dungeonEntrance = 'E'; //dungeon entrance for entry/exit

    //current location variable set
    private int curPosX = 0;
    private int curPosY = 0;
    private int prevPosX = 0;
    private int prevPosY = 0;
    private boolean stillInArea = true;

    //current map with player token
    private char[][] areaArrBase = new char[areaYDim][areaXDim];
    private char[][] curAreaArr = new char[areaYDim][areaXDim];

    //found chest/item variable
    private boolean chestFound = false;

    //constructors

    /**
     * @param : (pre) None
     * @param : (post) Creates a new object of type Town with set parameters
     * @return : None
     */
    public Dungeon(int x, int y, char[][] dungeonBase,Party party, String name)
    {
        //     m_user=user;
        m_party=party;
        m_name = name;
        startLocX = x;
        startLocY = y;
        curPosX = startLocX;
        curPosY = startLocY;

        areaArrBase = setBaseArea(dungeonBase);
        curAreaArr = resetArea(curAreaArr, areaArrBase);
        curAreaArr[curPosY][curPosX] = player;
    }   
    
    /**
     * Act - do whatever the Dungeon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 

    //get/set methods

    /**
     * @param : (pre) curAreaArr is initialized
     * @param : (post) None
     * @return : Returns the 2d array containing the current area
     */
    public char[][] getArea()
    {
        return curAreaArr;
    }

    /**
     * @param : (pre) curPosX and curPosY declared
     * @param : (post) Sets the previous coordinates to our current coordinates
     * @return : None
     */
    public void setCurrentToPrevious()
    {
        curPosX = prevPosX;
        curPosY = prevPosY;
    }

    //checking methods

    /**
     * @param : (pre) None
     * @param : (post) None
     * @return : Returns true if player is still in the area, false otherwise
     */
    public boolean inArea()
    {
        return stillInArea;
    }   

    /**
     * @param : (pre) Exit coordinates set
     * @param : (post) Checks to see if player is at the exit coordinates
     * @return : Returns if player is at the exit coordinates, false otherwise
     */
    public boolean atExit(int x, int y)
    {
        if(x == exitLocX && y == exitLocY)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /*
    public void displayArea()//Dummy method to satisfy interface
    {

    }
    public void resetArea()//Dummy method to satisfy interface
    {

    }   
    public boolean menuInputCheck(String str)//Dummy method to satisfy interface
    {
    return false;
    }
     */

    /**
     * @param : (pre) Move flag set for extra valid move check
     * @param : (post) Checks to see if the parameter str is valid
     * @return : Returns true if the input and move are valid, false otherwise
     */
    public boolean menuInputCheck(String str, int min, int max, boolean moveFlag)
    {
        double selDouble; //convert input safely
        int sel; //convert double to int
        if(isNumeric(str)) //check if input was a number
        {
            selDouble = Double.parseDouble(str); //parse to double safely
            sel = (int) selDouble;
            if(sel < min || sel > max) //if outside the menu range, false
            {
                return false;
            }
            else
            {
                if (moveFlag)
                {
                    return validMoveCheck(sel);
                }
                else
                {
                    return true;
                }
            }
        }
        else
        {
            return false;
        }
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
        }
        if(tempY < 0 || tempY > (areaYDim - 1))
        {
            return false;
        }
        else if(tempX < 0 || tempX > (areaXDim - 1))
        {
            return false;
        }
        else
        {
            if(curAreaArr[tempY][tempX] == path ||
            curAreaArr[tempY][tempX] == dungeonEntrance ||
            curAreaArr[tempY][tempX] == boss)
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
     * @param : (pre) Existing Dungeon object
     * @param : (post) Handles all menu interaction and display for traversing through the town
     * @return : None
     */
    public void menuInteraction()
    {
        final String menu = "\n\nYou are currently at the coordinate (" + curPosX + ", " + curPosY + "). Which direction would you like to move?\n" +
            "   1. Up\n" +
            "   2. Down\n" +
            "   3. Left\n" +
            "   4. Right\n" +
            "   5. Menu\n" +
                //                           "   6. Exit\n" +
            "   Your Choice: ";//TODO implement looking at character menu
        String input; //input as string
        double selDouble; //menu selection as double
        int selection; //menu selection as integer
        Scanner in = new Scanner(System.in); //input scanner
        System.out.print(menu); //display menu options
        input = in.next(); //get user input

        if(!((input.equals("w"))||(input.equals("a"))||(input.equals("s"))||(input.equals("d"))))
        {
            while(!menuInputCheck(input, 1, 6, true)) //check if entry is valid, repeat input if not
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
        else
        {
            System.out.println("Sorry, we didn't understand your input");
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

        curAreaArr = resetArea(curAreaArr, areaArrBase);
        curAreaArr[tempY][tempX] = player;
        if (areaArrBase[tempY][tempX] == dungeonEntrance)
        {
            return false;
        }
        else
        {
            if (areaArrBase[tempY][tempX] == chest)
            {
                areaArrBase[tempY][tempX] = path;
            }
            curAreaArr = resetArea(curAreaArr, areaArrBase);
            curAreaArr[tempY][tempX] = player;
            return true;
        }
    }

    /**
     * @param : (pre) Known building at coordinate
     * @param : (post) Pulls up different building interaction menus
     * @return : Returns true of the player is still in a building, false otherwise
     */

    public void bossEncounter()
    {

    }

    public void foundChest()
    {
        int chestID = 1; //placeholder
        Chest newChest = new Chest(chestID); //placeholder
        m_party.openChest(newChest);
        chestFound = false;     
    }

    //shared static methods

    /**
     * @param : (pre) None
     * @param : (post) Checks to see if the passed argument is numeric
     * @return : Returns true if the string argument is numeric, false otherwise
     */
    public boolean isNumeric(String str) //assisted code from StackOverflow, ---->
    //url: http://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
    {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    /**
     * @param : (pre) None
     * @param : (post) Clears the screen and resets to top position
     * @return : None
     */
    public void clearScreen() //assisted code from StackOverflow, ---->
    //url: http://stackoverflow.com/questions/4888362/commands-in-java-to-clear-the-screen
    {
        final String ANSI_CLS = "\u001b[2J";
        final String ANSI_HOME = "\u001b[H";
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
    }   

    /**
     * @param : (pre) Existing class object that implements Place
     * @param : (post) Displays the current area map with player token
     * @return : None
     */
    public void displayArea(char[][] area)
    {
        boolean isArena=false;  //at the end of the method, the meaning behind each char will be printed
        boolean isForest=false;
        boolean isInn=false;
        boolean isLibrary=false;
        boolean isMountain=false;
        boolean isPath=false;
        boolean isShop=false;
        boolean isTown=false;
        for (int i = 0; i < areaYDim; i++)
        {   
            System.out.print("\n");
            for (int j = 0; j < areaXDim; j++)//In this for loop the char is printed, and the types of terrain used are determined by setting the cooresponding booleans to true
            {   
                System.out.print(area[i][j] + " ");
                if(area[i][j]=='A')
                {
                    isArena=true;
                }
                else if(area[i][j]=='F')
                {
                    isForest=true;
                }
                else if(area[i][j]=='I')
                {
                    isInn=true;
                }
                else if(area[i][j]=='L')
                {
                    isLibrary=true;
                }
                else if(area[i][j]=='M')
                {
                    isMountain=true;
                }
                else if(area[i][j]=='P')
                {
                    isPath=true;
                }   
                else if(area[i][j]=='S')
                {
                    isShop=true;
                }
                else if(area[i][j]=='T')
                {
                    isTown=true;
                }   
            }
        }
        System.out.print("\n");

        if(isArena)
        {
            System.out.println("A: Arena");
        }
        if(isForest)
        {
            System.out.println("F: Forest");
        }   
        if(isInn)
        {
            System.out.println("I: Inn");
        }
        if(isLibrary)
        {
            System.out.println("L: Library");
        }
        if(isMountain)
        {
            System.out.println("M: Mountain");
        }
        if(isPath)
        {
            System.out.println("P: Path");
        }   
        if(isShop)
        {
            System.out.println("S: Shop");
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
}
