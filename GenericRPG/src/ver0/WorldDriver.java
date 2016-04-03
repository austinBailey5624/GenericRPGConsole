package ver0;

/**
 * @author : Will Teeple
 * @version : 0.2
 * @since 03/30/2016
 * Description : Driver file to test the World Class
 */

import java.io.*;

public class WorldDriver
{
  public static void main(String[] args) {
    //file names
    String worldMapFile = "worldLayout.txt";
    String villagevilleFile = "villageville.txt";

    //create area arrays
    char[][] worldMap = populateArea(worldMapFile);
    char[][] villageville = populateArea(villagevilleFile);

    //create area objects
    World world = new World(0, 3, worldMap);
    Town villagevilleTown = new Town(0, 3, villageville);

    //town array coordinates (x,y)
    int[] vvCoor = {6, 1};

    while(true)
    {
      //run world
      do
      {
        world.displayArea();
        world.menuInteraction();
      } while(world.inArea());

      if (world.getCurrentLoc()[0] == vvCoor[0] && world.getCurrentLoc()[1] == vvCoor[1])
      {
        do
        {
          villagevilleTown.displayArea();
          villagevilleTown.menuInteraction();
        } while (villagevilleTown.inArea());
      }

      world.setCurrentToPrevious();
    }
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

  public static void transition()
  {

  }
}
