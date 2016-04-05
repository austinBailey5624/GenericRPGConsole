package ver0;

/**
 * @author : Will Teeple
 * @version : 0.4
 * @since 03/30/2016
 * Description : World class. This class stores the current world map and contains
 * the methods for manipulating and displaying the players position
 */

import java.util.Scanner;

public class World implements Place
{
  //dimension and coordinate constants
  private int startLocX; //x-coordinate start location
  private int startLocY; //y-coordinate start location

  //constant variables for easier code reading
  private final char town = 'T'; //character for tree
  //private final char mountain = 'M'; //character for mountain
  //private final char river = 'R'; //character for river

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

  //constructors

  /**
   * @param : (pre) None
   * @param : (post) Creates a new object of type World with set parameters
   * @return : None
   */
  public World(int x, int y, char[][] worldBase)
  {
    startLocX = x;
    startLocY = y;
    curPosX = startLocX;
    curPosY = startLocY;

    areaArrBase = setBaseArea(worldBase);
    curAreaArr = resetArea(curAreaArr, areaArrBase);
    curAreaArr[curPosY][curPosX] = player;
  }

  //get/set methods

  public char[][] getArea()
  {
    return curAreaArr;
  }

  public int[] getCurrentLoc()
  {
    int temp[] = {curPosX, curPosY};
    return temp;
  }

  public void setCurrentToPrevious()
  {
    curPosX = prevPosX;
    curPosY = prevPosY;
  }

  public boolean getGameExit()
  {
    return gameExit;
  }

  //checking methods

  public boolean inArea()
  {
    return stillInArea;
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
          if (sel == 5)
          {
            return true;
          }
          else
          {
            return validMoveCheck(sel);
          }
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
      if(areaArrBase[tempY][tempX] == path || areaArrBase[tempY][tempX] == town)
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
                           "1. Up\n" +
                           "2. Down\n" +
                           "3. Left\n" +
                           "4. Right\n" +
                           "5. Exit Game\n" +
                           "Your Choice: ";
    String input; //input as string
    double selDouble; //menu selection as double
    int selection; //menu selection as integer
    Scanner in = new Scanner(System.in); //input scanner
    System.out.print(menu); //display menu options
    input = in.next(); //get user input

    while(!menuInputCheck(input, 1, 5, true)) //check if entry is valid, repeat input if not
    {
      System.out.print("Invalid menu selection, please choose an integer between 1 and 4 and a\ndestination along the path denoted by P.\nYour choice: ");
      input = in.next();
    }

    in.close();
    
    selDouble = Double.parseDouble(input); //safe parse
    selection = (int) selDouble; //set selection

    if (selection != 5)
    {
      stillInArea = characterMove(selection); //store if still in world
      clearScreen();
    }
    else
    {
      gameExit = true;
    }
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

    if (areaArrBase[tempY][tempX] == town)
    {
      return false;
    }
    else
    {
      curAreaArr = resetArea(curAreaArr, areaArrBase);
      curAreaArr[tempY][tempX] = player;
      return true;
    }
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
   for (int i = 0; i < areaYDim; i++)
   {
     System.out.print("\n");
     for (int j = 0; j < areaXDim; j++)
     {
       System.out.print(area[i][j] + " ");
     }
   }
   System.out.print("\n");
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

