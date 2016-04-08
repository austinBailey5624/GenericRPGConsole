package ver0;

/**
 * @author : Will Teeple
 * @version : 0.3
 * @since 04/02/2016
 * Description : Town class. This class stores the current town map and contains
 * the methods for manipulating and displaying the players position
 */

 import java.util.Scanner;

 public class Town implements Place
 {
	 String m_name;
	 PlayerActor m_user;
	 Shop[] shops=Shop.getAllShops();
	 Arena[] arenas=Arena.getAllArenas();
   //dimension and coordinate constants
   private int startLocX; //x-coordinate start location
   private int startLocY; //y-coordinate start location
   private int exitLocX; //x-coordinate exit location
   private int exitLocY; //y-coordinate exit location

   //constant variables for easier code reading
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

   //constructors

   /**
    * @param : (pre) None
    * @param : (post) Creates a new object of type Town with set parameters
    * @return : None
    */
   public Town(int x, int y, char[][] townBase,PlayerActor user, String name)
   {
	   m_user=user;
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

   public char[][] getArea()
   {
     return curAreaArr;
   }

   public void setCurrentToPrevious()
   {
     curPosX = prevPosX;
     curPosY = prevPosY;
   }

   //checking methods

   public boolean inArea()
   {
     return stillInArea;
   }

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

   public void displayArea()//Dummy method to satisfy interface
   {
	   
   }
   public void resetArea()//Duummy method to satisfy interface
   {
	   
   }
   public boolean menuInputCheck(String str)//Dummy method to satisfy interface
   {
	   return false;
   }
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
     	m_user.menu();
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
     if (areaArrBase[tempY][tempX] == townBorder)
     {
       return false;
     }
     else
     {
       return true;
     }
   }

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

   public boolean shopMenu()
   {
	   Shop thisShop;
	   if(m_name=="AwesomeTown")
	   {
		   thisShop = shops[2];//TODO: fix this, shops need to be global and passed in, not constructed on-site
	   }
	   else
	   {
		   thisShop = shops[1];
	   }
	   thisShop.displayMenu(m_user);
//     final String menu = "\nWelcome to the Shop!\n" +
//                            "   1. Buy\n" +
//                            "   2. Sell\n" +
//                            "   3. Leave\n" +
//                            "   Your Choice: ";
//     String input; //input as string
//     double selDouble; //menu selection as double
//     int selection; //menu selection as integer
//     Scanner in = new Scanner(System.in); //input scanner
//     System.out.print(menu); //display menu options
//     input = in.next(); //get user input
//
     boolean inStore = true;
//
//     while(!menuInputCheck(input, 1, 3, false)) //check if entry is valid, repeat input if not
//     {
//       System.out.print("Invalid menu selection, please choose an integer between 1 and 3.\nYour choice: ");
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
//          System.out.println("\n\nInsert interaction here:\n\n");
//          break;
//       case 3:
          inStore = false;
          setCurrentToPrevious();
          curAreaArr = resetArea(curAreaArr, areaArrBase);
          curAreaArr[curPosY][curPosX] = player;
//         break;
//     }

     return inStore;
   }

   public boolean arenaMenu()
   {
	   Arena thisArena;
	   if(m_name=="AwesomeTown")
	   {
		   thisArena = arenas[2];
	   }
	   else
	   {
		   thisArena = arenas[1];
	   }
	   thisArena.Menu(m_user);
	   //     final String menu = "\nWelcome to the Arena!\n" +
//                            "   1. Battle\n" +
//                            "   2. Leave\n" +
//                            "   Your Choice: ";
//     String input; //input as string
//     double selDouble; //menu selection as double
//     int selection; //menu selection as integer
//     Scanner in = new Scanner(System.in); //input scanner
//     System.out.print(menu); //display menu options
//     input = in.next(); //get user input
//
     boolean inArena = true;
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
          inArena = false;
          setCurrentToPrevious();
          curAreaArr = resetArea(curAreaArr, areaArrBase);
          curAreaArr[curPosY][curPosX] = player;
//          break;
//     }

     return inArena;
   }

   private Arena[] getAllArenas() {
	// TODO Auto-generated method stub
	return null;
}

public boolean innMenu()
   {
	   Inn thisInn;
	   if(m_name=="AwesomeTown")
	   {
		   thisInn=new Inn(2);
	   }
	   else
	   {
		   thisInn=new Inn(1);
	   }
	   thisInn.menu(m_user);
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
	   thisLibrary.menu(m_user);
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
//     switch(selection)
//     {
//       case 1:
//          System.out.println("\n\nInsert interaction here:\n\n");
//          break;
//       case 2:
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
	   boolean isArena=false;	//at the end of the method, the meaning behind each char will be printed
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
