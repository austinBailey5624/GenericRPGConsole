package ver0;
import java.util.Scanner;
public class Arena 
{
	boolean lost = false;
	
    public static Arena[] getAllArenas()
    {

    	//Item[] itemArray = new Item[m_numTypesOfItem];

    	Arena[] ArenaArray = new Arena[2];


    	for(int i=0; i<ArenaArray.length; i++)//Hey, I thought this would ease the process for adding new items, should do it automatically
    	{
    		ArenaArray[i]=new Arena(i+1);
    	}
    	return ArenaArray;
    }
	EnemyActor[] enemySet = EnemyActor.getEnemies();
	int select;
	Scanner myScanner = new Scanner(System.in);
	int currentFightCeiling;
	int maxFight;
	
	/**
	 * This funcion generates an arena based on the input
	 * @precondition: 	none
	 * @post: 			constructs Arena
	 * @return:			instance of Arena
	 */
	public Arena(int whichArena)
	{
		if(whichArena==1)//in this arena you can only fight the first three enemies
		{
			maxFight=3;
		}
		else if(whichArena==2)//in this arena you can fight all the enemies
		{
			maxFight=enemySet.length;
		}
		currentFightCeiling=1;
	}
	
	
	/**
	 * this function passes in character and handles battles in the arena
	 * @precondition:	instance of Arena
	 * @post:			can change member variables of character based on preformance, if they are successful allows them to fight harder enemies
	 * @param character
	 */
	public void menu(Party party)//TODO make this return a boolean that controls whether the actor won the battle, if lost, return false
	{
		System.out.println("Welcome to the Arena");
		boolean exit=false;
		lost = false;
		Battle myBattle = new Battle();
		while(!exit)
		{
			int indexRepresentedByChoice[]=new int[enemySet.length];
			int choice=1;
			System.out.println("Who will you fight?");
			for(int i=0; i< currentFightCeiling; i++)
			{
				System.out.println(choice + ") "  + enemySet[i].getName());
				indexRepresentedByChoice[choice]=i;	
				choice++;
//				indexRepresentedByChoice[choice]=i;
			}
			System.out.println(choice + ") Exit");
			String in=myScanner.next();
			if(verifyInt(in))
			{
				select=Integer.parseInt(in);
			}
			else
			{
				System.out.println("You gave invalid input! please try again\n");
				continue;
			}
			if(select>=1 && select<=currentFightCeiling)
			{
				if(myBattle.actorBattle(party,party.getContent()[0], enemySet[indexRepresentedByChoice[select]])) //TODO check if player ran or defeated enemy, adjust response accordingly
				{
					System.out.println("Congratulations, you won! More difficult enemies come to the arena!");
					if(currentFightCeiling<4)
					{
						currentFightCeiling++;
					}
				}
				else
				{
					//TODO: need to move to inn somehow?
					System.out.println("The guy who beats you took all your gold!\n But he used it to pay the inkeep to nurse you back to health");
					exit = true;
					lost = true;
				}
			}
			else if(select==choice)
			{
				return;
			}
		}
	}
	
	public boolean getLostBattle()	
	{
		return lost;
	}
	private boolean verifyInt(String s)
	{
		try
		{
			int x=Integer.parseInt(s);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}
}
