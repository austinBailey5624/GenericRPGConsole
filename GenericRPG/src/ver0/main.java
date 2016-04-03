package ver0;
import java.util.Scanner;
public class main 
{
	static Scanner myScanner = new Scanner(System.in);
	static int select;
	public static void main(String[] args)
	{
		//gets all skills and prepares them for use in main
		Skill[] skillSet = Skill.getSkills();
		
		//gets all items and prepares them for use in main
		Item[] itemSet = Item.getAllItems();


		//gets all enemies and prepares them for use in main
		EnemyActor[] enemySet = EnemyActor.getEnemies();
		boolean exit = false;
		while(!exit)
		{
			System.out.println("Welcome To GenericRPG! What would you like to do?\n1) developer options 2)exit");
			select=myScanner.nextInt();
			if(select==1)
			{
				System.out.println("1) determine number of items, skills and enemies\n2) Attempt Equip Item methods");
				select=myScanner.nextInt();
				if(select==1)
				{
					System.out.println("Number of Items: " + Item.getNumTypesOfItem());
					System.out.println("Number of Skills: " + Skill.getNumOfSkillsTotal());
					System.out.println("Number of Enemies: " + EnemyActor.m_numOfEnemies);
				}
				else if(select==2)
				{
					PlayerActor myPlayerActor = new PlayerActor();
					int[] testInventory = new int[itemSet.length];
					for(int i=0; i<itemSet.length; i++)
					{
						testInventory[i]=3;
					}
					myPlayerActor.setInventory(testInventory);
					myPlayerActor.menu();
				}
			}
			else if(select==2)
			{
				System.out.println("Thank you for playing!");
				return;
			}
			else
			{
				System.out.println("Sorry, we didn't undersand your input");
			}
		}
	}
}