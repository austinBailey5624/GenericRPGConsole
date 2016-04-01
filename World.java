/**
 * @author : Will Teeple
 * @version : 0.2
 * @since 03/30/2016
 * Description : World class. This class stores the current map and contains
 * the methods for manipulating and displaying the players position
 */

import java.util.Scanner;

public class World
{
  //dimension and coordinate constants
  private final int worldXDim = 7; //max x-axis length
  private final int worldYDim = 7; //max y-axis length
  private final int startLocX = 0; //x-coordinate start location
  private final int startLocY = 3; //y-coordinate start location

  //constant variables for easier code reading
  private final char town = 'T'; //character for tree
  private final char mountain = 'M'; //character for mountain
  private final char river = 'R'; //character for river
  private final char path = 'P'; //character for path
  private final char player = '@'; //chacter for the player

  //direction constants
  private final char up = 'w';
  private final char down = 's';
  private final char left = 'a';
  private final char right = 'd';

  //current location variables
  private int curPosX = startLocX;
  private int curPosY = startLocY;
  private int prevPosX = 0;
  private int prevPosY = 0;
  private boolean stillInWorld = true;

  //default map without player token
  private final char[][] worldArrBase =
  {{'F', 'F', 'M', 'M', 'M', 'M', 'M'},
   {'F', 'F', 'M', 'M', 'P', 'P', 'T'},
   {'F', 'F', 'F', 'F', 'P', 'F', 'F'},
   {'P', 'P', 'P', 'P', 'P', 'F', 'F'},
   {'F', 'F', 'F', 'F', 'P', 'F', 'F'},
   {'F', 'F', 'F', 'F', 'P', 'P', 'T'},
   {'F', 'F', 'F', 'F', 'F', 'F', 'F'}};

   //current map with player token
  private char[][] curWorldArr = new char[worldYDim][worldXDim];

  /**
   * @param : (pre) None
   * @param : (post) Creates a new object of type World
   * @return : None
   */
  public World()
  {
    resetWorld();
    curPosX = startLocX;
    curPosY = startLocY;
    curWorldArr[startLocY][startLocX] = player;
  }

  public boolean inWorld()
  {
    return stillInWorld;
  }

  /**
   * @param : (pre) Existing World Object
   * @param : (post) Displays the current world map with player token
   * @return : None
   */
  public void displayWorld()
  {
    for (int i = 0; i < worldYDim; i++)
    {
      System.out.println("\n");
      for (int j = 0; j < worldXDim; j++)
      {
        System.out.print(curWorldArr[i][j] + " ");
      }
    }
  }

  public void resetWorld()
  {
    for (int i = 0; i < worldYDim; i++)
    {
      for (int j = 0; j < worldXDim; j++)
      {
        curWorldArr[i][j] = worldArrBase[i][j];
      }
    }
  }

  public static boolean isNumeric(String str) //assisted code from StackOverflow, ---->
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
    if(tempY < 0 || tempY > (worldYDim - 1))
    {
      return false;
    }
    else if(tempX < 0 || tempX > (worldXDim - 1))
    {
      return false;
    }
    else
    {
      if(curWorldArr[tempY][tempX] == path)
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

    stillInWorld = characterMove(selection); //store if still in world
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

    resetWorld();
    curWorldArr[tempY][tempX] = player;
    if (worldArrBase[tempY][tempX] == town)
    {
      return false;
    }
    else
    {
      return true;
    }
  }
}
