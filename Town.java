/**
 * @author : Will Teeple
 * @version : 0.1
 * @since 04/02/2016
 * Description : Town class. This class stores the current town map and contains
 * the methods for manipulating and displaying the players position
 */

 import java.util.Scanner;

 public class Town implements Place
 {
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
   private char[][] townArrBase = new char[areaYDim][areaXDim];
   private char[][] curAreaArr = new char[areaYDim][areaXDim];

   /**
    * @param : (pre) None
    * @param : (post) Creates a new object of type Town with set parameters
    * @return : None
    */
   public Town(int x, int y, char[][] townBase)
   {
     startLocX = x;
     startLocY = y;
     curPosX = startLocX;
     curPosY = startLocY;

     setBaseArea(townBase);
     resetArea();
     curAreaArr[curPosY][curPosX] = player;
   }

   public boolean inArea()
   {
     return stillInArea;
   }

   /**
    * @param : (pre) Existing Town Object
    * @param : (post) Displays the current town map with player token
    * @return : None
    */
   public void displayArea()
   {
     for (int i = 0; i < areaYDim; i++)
     {
       System.out.print("\n");
       for (int j = 0; j < areaXDim; j++)
       {
         System.out.print(curAreaArr[i][j] + " ");
       }
     }
     System.out.print("\n");
   }

   public void setBaseArea(char[][] area)
   {
     for (int i = 0; i < areaYDim; i++)
     {
       for (int j = 0; j < areaXDim; j++)
       {
         townArrBase[i][j] = area[i][j];
         if (townArrBase[i][j] == townBorder)
         {
           exitLocX = j;
           exitLocY = i;
         }
       }
     }
   }

   public void resetArea()
   {
     for (int i = 0; i < areaYDim; i++)
     {
       for (int j = 0; j < areaXDim; j++)
       {
         curAreaArr[i][j] = townArrBase[i][j];
       }
     }
   }

   public boolean isNumeric(String str) //assisted code from StackOverflow, ---->
   //url: http://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
   {
     return str.matches("-?\\d+(\\.\\d+)?");
   }

   public boolean menuInputCheck(String str)
   {
     double selDouble; //convert input safely
     int sel; //convert double to int
     if(isNumeric(str)) //check if input was a number
     {
       selDouble = Double.parseDouble(str); //parse to double safely
       sel = (int) selDouble;
       if(sel < 1 || sel > 4) //if outside the menu range, false
       {
         return false;
       }
       else
       {
         return validMoveCheck(sel);
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

   public void menuInteraction()
   {
     final String menu = "\n\nYou are currently at the coordinate (" + curPosX + ", " + curPosY + "). Which direction would you like to move?\n" +
                            "1. Up\n" +
                            "2. Down\n" +
                            "3. Left\n" +
                            "4. Right\n" +
                            "Your Choice: ";
     String input; //input as string
     double selDouble; //menu selection as double
     int selection; //menu selection as integer
     Scanner in = new Scanner(System.in); //input scanner
     System.out.print(menu); //display menu options
     input = in.next(); //get user input

     while(!menuInputCheck(input)) //check if entry is valid, repeat input if not
     {
       System.out.print("Invalid menu selection, please choose an integer between 1 and 4 and a\ndestination along the path denoted by P.\nYour choice: ");
       input = in.next();
     }

     selDouble = Double.parseDouble(input); //safe parse
     selection = (int) selDouble; //set selection

     stillInArea = characterMove(selection); //store if still in town
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

     resetArea();
     curAreaArr[tempY][tempX] = player;
     if (townArrBase[tempY][tempX] == townBorder)
     {
       return false;
     }
     else
     {
       return true;
     }
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
 }
