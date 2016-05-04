import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;

/**
 * Write a description of class Town here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Town extends Actor
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
    private final char shop = 'S'; //character for shop
    private final char arena = 'A'; //character for arena
    private final char inn = 'I'; //character for inn
    private final char library = 'L'; //character for library
    private final char townBorder = 'E'; //town border for entry/exit

    //current location variable set
    private int curPosX = 0;
    private int curPosY = 0;
    private int prevPosX = 0;
    private int prevPosY = 0;
    private boolean stillInArea = true;

    //current map with player token
    private char[][] areaArrBase = new char[areaYDim][areaXDim];
    private char[][] curAreaArr = new char[areaYDim][areaXDim]; 
    
    /**
     * Act - do whatever the Town wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    
    //constructors

    /**
     * @param : (pre) None
     * @param : (post) Creates a new object of type Town with set parameters
     * @return : None
     */
    public Town(int x, int y, char[][] townBase,Party party, String name)
    {
        //     m_user=user;
        m_party=party;
        m_name = name;
        startLocX = x;
        startLocY = y;
        curPosX = startLocX;
        curPosY = startLocY;

        areaArrBase = setBaseArea(townBase);
        curAreaArr = resetArea(curAreaArr, areaArrBase);
        curAreaArr[curPosY][curPosX] = player;
    }   

    //get/set methods
    public int[] getStartLoc()
    {
        int[] temp = {startLocX, startLocY};
        return temp;
    }
    
    public int[] getCurrentLoc()
    {
        int temp[] = {curPosX, curPosY};
        return temp;
    }  
    
    /**
     * @param : (pre) curAreaArr is initialized
     * @param : (post) None
     * @return : Returns the 2d array containing the current area
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
            curAreaArr[tempY][tempX] == townBorder ||
            curAreaArr[tempY][tempX] == shop ||
            curAreaArr[tempY][tempX] == arena ||
            curAreaArr[tempY][tempX] == inn ||
            curAreaArr[tempY][tempX] == library)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    //interaction methods
    /*
    /**
     * @param : (pre) Existing Twon object
     * @param : (post) Handles all menu interaction and display for traversing through the town
     * @return : None
     *
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

        while(townInteraction(areaArrBase[curPosY][curPosX])){}
    }
    */
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
        if (areaArrBase[tempY][tempX] == townBorder ||
            areaArrBase[tempY][tempX] == shop ||
            areaArrBase[tempY][tempX] == arena ||
            areaArrBase[tempY][tempX] == inn ||
            areaArrBase[tempY][tempX] == library)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * @param : (pre) Known building at coordinate
     * @param : (post) Pulls up different building interaction menus
     * @return : Returns true of the player is still in a building, false otherwise
     */
    public boolean townInteraction(char spot)
    {
        boolean inBuilding = false;

        switch(spot)
        {
            case shop:
            inBuilding = shopMenu();
            break;

            case arena:
            inBuilding = arenaMenu();
            break;

            case inn:
            inBuilding = innMenu();
            break;

            case library:
            inBuilding = libraryMenu();
            break;

            default:
            inBuilding = false;
        }

        //clearScreen();
        return inBuilding;
    }

    /**
     * @param : (pre) None
     * @param : (post) Displays and handles menu interaction for the shop
     * @return : Returns true if still in the store, false otherwise
     */
    public boolean shopMenu()
    {
        Shop thisShop;
        if(m_name=="AwesomeTown")
        {
            thisShop = shops[1];
        }
        else
        {
            thisShop = shops[0];
        }
        thisShop.displayMenu(m_party);
        boolean inStore = true;
        inStore = false;
        setCurrentToPrevious();
        curAreaArr = resetArea(curAreaArr, areaArrBase);
        curAreaArr[curPosY][curPosX] = player;
        return inStore;
    }

    /**
     * @param : (pre) None
     * @param : (post) Displays and handles menu interaction for the arena
     * @return : Returns true if still in the arena, false otherwise
     */
    public boolean arenaMenu()
    {
        Arena thisArena;
        if(m_name=="AwesomeTown")
        {
            thisArena = arenas[1];
        }
        else
        {
            thisArena = arenas[0];
        }
        thisArena.menu(m_party);
        boolean inArena = true;
        if (thisArena.getLostBattle())
        {
            if (m_name == "AwesomeTown")
            {
                curPosX = 5;
                curPosY = 0;
                prevPosX = 4;
                prevPosY = 1;
            }
            else
            {
                curPosX = 5;
                curPosY = 5;
                prevPosX = 5;
                prevPosY = 4;
            }
            //TODO handle loss
            for(int i=0; i<4;i++)
            {
                if(m_party.getContent()[i]!=null)
                {
                    m_party.getContent()[i].setCurHp(1);
                }
            }
            //m_party.setCurHp(m_user.getMaxHp());
        }
        resetArea(curAreaArr, areaArrBase);
        setCurrentToPrevious();
        curAreaArr[curPosY][curPosX] = player;

        inArena = false;
        //setCurrentToPrevious();
        //curAreaArr = resetArea(curAreaArr, areaArrBase);
        //curAreaArr[curPosY][curPosX] = player;
        //          break;
        //     }

        return inArena;
    }

    private Arena[] getAllArenas() 
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param : (pre) None
     * @param : (post) Displays and handles menu interaction for the inn
     * @return : Returns true if still in the inn, false otherwise
     */
    public boolean innMenu()
    {
        Inn thisInn;
        if(m_name=="AwesomeTown")
        {
            thisInn=new Inn(1);
        }
        else
        {
            thisInn=new Inn(0);
        }
        thisInn.menu(m_party);
        //     final String menu = "\nWelcome to the Inn!\n" +
        //                            "   1. Rest\n" +
        //                            "   2. Leave\n" +
        //                            "   Your Choice: ";
        //     String input; //input as string
        //     double selDouble; //menu selection as double
        //     int selection; //menu selection as integer
        //     Scanner in = new Scanner(System.in); //input scanner
        //     System.out.print(menu); //display menu options
        //     input = in.next(); //get user input
        //
        boolean inInn = true;
        //
        //     while(!menuInputCheck(input, 1, 2, false)) //check if entry is valid, repeat input if not
        //     {
        //       System.out.print("Invalid menu selection, please choose an integer between 1 and 2.\nYour choice: ");
        //       input = in.next();
        //     }
        //     
        //     selDouble = Double.parseDouble(input); //safe parse
        //     selection = (int) selDouble; //set selection
        //
        //     switch(selection)
        //     {
        //       case 1:
        //          System.out.println("\n\nInsert interaction here:\n\n");
        //          break;
        //       case 2:
        inInn = false;
        setCurrentToPrevious();
        curAreaArr = resetArea(curAreaArr, areaArrBase);
        curAreaArr[curPosY][curPosX] = player;
        //          break;
        //     }

        return inInn;
    }

    /**
     * @param : (pre) None
     * @param : (post) Displays and handles menu interaction for the library
     * @return : Returns true if still in the library, false otherwise
     */
    public boolean libraryMenu()
    {
        Library thisLibrary;
        if(m_name=="AwesomeTown")
        {
            thisLibrary=new Library(2);
        }
        else
        {
            thisLibrary=new Library(1);
        }
        thisLibrary.menu(m_party);
        //     final String menu = "\nWelcome to the Library!\n" +
        //                            "   1. Learn Skill\n" +
        //                            "   2. Leave\n" +
        //                            "   Your Choice: ";
        //     String input; //input as string
        //     double selDouble; //menu selection as double
        //     int selection; //menu selection as integer
        //     Scanner in = new Scanner(System.in); //input scanner
        //     System.out.print(menu); //display menu options
        //     input = in.next(); //get user input
        //
        boolean inLibrary = true;
        //
        //     while(!menuInputCheck(input, 1, 2, false)) //check if entry is valid, repeat input if not
        //     {
        //       System.out.print("Invalid menu selection, please choose an integer between 1 and 2.\nYour choice: ");
        //       input = in.next();
        //     }
        //     
        //     selDouble = Double.parseDouble(input); //safe parse
        //     selection = (int) selDouble; //set selection
        //
        inLibrary = false;
        setCurrentToPrevious();
        curAreaArr = resetArea(curAreaArr, areaArrBase);
        curAreaArr[curPosY][curPosX] = player;
        //          break;
        //     }

        return inLibrary;
    }

    // shared static methods

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
