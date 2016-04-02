/**
 * @author : Will Teeple
 * @version : 1
 * @since 03/30/2016
 * Description : Driver file to test the World Class
 */

import java.io.*;

public class WorldDriver
{
  public static void main(String[] args) {
    String worldMapFile = "worldLayout.txt";
    char[][] worldMap = populateArea(worldMapFile);
    World world = new World(0, 3, worldMap);

    do
    {
      world.displayArea();
      world.menuInteraction();
    } while(world.inArea());
  }

  public static char[][] populateArea(String fileName)
  {
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
            if (b != '\r') // '\r' will be followed by '\n'
            {
              tempWorld[i][j] = b;
            }
            else
            {
              b = (char) inbr.read(); //skip '\r'
              b = (char) inbr.read(); //skip '\n'
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
