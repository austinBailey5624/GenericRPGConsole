package ver0;

/**
 **
 * @author : Will Teeple
 * @version : 0.3
 * @since 04/02/2016
 * Description : Place interface. Common elements between World and Town
 */

public interface Place
{
  //dimension and coordinate max constants
  public static final int areaXDim = 7; //max x-axis length
  public static final int areaYDim = 7; //max y-axis length

  //constant variables for easier code reading
  public static final char path = 'P'; //character for path
  public static final char player = '@'; //character for the player
  public static final char chest = 'C'; //character for chest
  
  //direction constants
  public static final char up = 'w';
  public static final char down = 's';
  public static final char left = 'a';
  public static final char right = 'd';

  // shared static methods
  /*
  /**
   * @param : (pre) None
   * @param : (post) Checks to see if the passed argument is numeric
   * @return : Returns true if the string argument is numeric, false otherwise
   *
  public default boolean isNumeric(String str) //assisted code from StackOverflow, ---->
  //url: http://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
  {
    return str.matches("-?\\d+(\\.\\d+)?");
  }

  public default void clearScreen() //assisted code from StackOverflow, ---->
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
   *
  public default void displayArea(char[][] area)
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
   *
  public default char[][] setBaseArea(char[][] area)
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
   *
  public default char[][] resetArea(char[][] currentArea, char[][] baseArea)
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
  */
}
