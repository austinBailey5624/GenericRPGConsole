package ver0;

/**
 /**
 * @author : Will Teeple
 * @version : 0.3
 * @since 03/30/2016
 * Description : Driver file to test the World Class
 */

import java.io.*;

public class WorldDriver
{
	Party m_party;
	
    /**
    * @param : (pre) None
    * @param : (post) Default WorldDriver constructor
    * @return : None
    */
	public WorldDriver()
	{
		
	}
	
	/**
     * @param : (pre) None
     * @param : (post) Instantiates a WorldDriver object with the indicated PlayerActor
     * @return : None
     */
	public WorldDriver(Party party)
	{
		m_party=party;
	}
	
  /**
   * @param : (pre) Existing WorldDriver and appropriate .txt files
   * @param : (post) Runs the game by running methods within the world
   * @return : None
   */
	public void runWorld() 
	{
		//file names
		String worldMapFile = "worldLayout.txt";
		String villagevilleFile = "villageville.txt";
		String awesometownFile = "awesometown.txt";
		String dungeon1File = "dungeon1.txt";

		//create area arrays
		char[][] worldMap = populateArea(worldMapFile);
		char[][] villageville = populateArea(villagevilleFile);
		char[][] awesometown = populateArea2(awesometownFile);
		char[][] dungeon1 = populateArea(dungeon1File);
		
		//create area objects
		World world = new World(0, 3, worldMap,m_party);
		Town villagevilleTown = new Town(0, 3, villageville,m_party, "VillageVille");
		Town awesometownTown = new Town(0, 3, awesometown, m_party, "AwesomeTown");
		Dungeon dungeon1D = new Dungeon(6, 1, dungeon1, m_party, "Dungeon1");
		
		
		//town array coordinates (x,y)
		int[] vvCoor = {6, 1};
		int[] atCoor = {6, 5};
		int[] dun1Coor = {1, 6};

		boolean gameIsActive = true;

		//begin game Welcome
		//    System.out.println("Welcome to Generic RPG!\n");//took care of earlier, now duplicate

		while(gameIsActive)
		{
			//begin game with clear terminal screen
			//clearScreen();

			//run world
			do
			{
				world.displayArea(world.getArea());
				world.menuInteraction();
				gameIsActive = !world.getGameExit();
			} while(world.inArea() && gameIsActive);

			//visit VillageVille
			if (world.getCurrentLoc()[0] == vvCoor[0] && world.getCurrentLoc()[1] == vvCoor[1])
			{
				do
				{
					villagevilleTown.displayArea(villagevilleTown.getArea());
					villagevilleTown.menuInteraction();
				} while (villagevilleTown.inArea());
			}
			//visit AwesomeTown
			else if (world.getCurrentLoc()[0] == atCoor[0] && world.getCurrentLoc()[1] == atCoor[1])
			{
				do
				{
					awesometownTown.displayArea(awesometownTown.getArea());
					awesometownTown.menuInteraction();
				} while (awesometownTown.inArea());
			}
			//visit dungeon1
			else if (world.getCurrentLoc()[0] == dun1Coor[0] && world.getCurrentLoc()[1] == dun1Coor[1])
			{
				do
				{
					dungeon1D.displayArea(dungeon1D.getArea());
					dungeon1D.menuInteraction();
				} while (dungeon1D.inArea());
			}

			//return to world, return to previous coordinates
			world.setCurrentToPrevious();
		}

		System.out.println("\n\nYou have exited the game. Have a good day!");
	}

	/**
	 * @param : (pre) .txt file for indicated area and filename associated with file
	 * @param : (post) Populates the area using a 2d array 
	 * @return : Returns a 2d array containing the populated area
	 */
	public char[][] populateArea(String fileName)
	{
		//file i/o
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
  
	//temporary fix
	/**
	 * @param : (pre) .txt file for indicated area and filename associated with file
	 * @param : (post) Populates the area using a 2d array 
	 * @return : Returns a 2d array containing the populated area
	 */
	public char[][] populateArea2(String fileName)
	{
		//file i/o
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
						if (b != '\n') // '\r' will be followed by '\n'
						{
							tempWorld[i][j] = b;
						}
						else
						{
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

	/**
	 * @param : (pre) None
	 * @param : (post) Clears the screen and resets the position (terminal run only)
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
}
