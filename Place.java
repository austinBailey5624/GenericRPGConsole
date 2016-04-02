/**
 * @author : Will Teeple
 * @version : 0.1
 * @since 04/02/2016
 * Description : Place interface. Common elements between World and Town
 */

import java.util.Scanner;

public interface Place
{
  //dimension and coordinate constants
  public static final int areaXDim = 7; //max x-axis length
  public static final int areaYDim = 7; //max y-axis length

  //constant variables for easier code reading
  public static final char path = 'P'; //character for path
  public static final char player = '@'; //chacter for the player

  //direction constants
  public static final char up = 'w';
  public static final char down = 's';
  public static final char left = 'a';
  public static final char right = 'd';

  public boolean inArea();

  public void displayArea();

  public void resetArea();

  public boolean isNumeric(String str);

  public boolean menuInputCheck(String str);

  public boolean validMoveCheck(int sel);

  public void menuInteraction();

  public boolean characterMove(int sel);
}
