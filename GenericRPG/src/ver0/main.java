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
<<<<<<< HEAD
		EnemyActor[] enemySet = EnemyActor.getEnemies();

		//System.out.println("Number of Items: " + Item.getNumTypesOfItem());
		//System.out.println("Number of Skills: " + Skill.getNumOfSkillsTotal());
		//System.out.println("Number of Enemies: " + EnemyActor.m_numOfEnemies);
		
		/*boolean exit = false;
=======
		EnemyActor[] enemySet = EnemyActor.getEnemies();
<<<<<<< HEAD
		boolean exit = false;
>>>>>>> 88f776a07cb9e6ae96f974d3aeea398929d6ffeb
		while(!exit)
		{
			System.out.println("Welcome To GenericRPG! What would you like to do?\n1) developer options 2)exit");
			select=myScanner.nextInt();
			if(select==1)
			{
				System.out.println("1) determine number of items, skills and enemies");
				select=myScanner.nextInt();
				if(select==1)
				{
					System.out.println("Number of Items: " + Item.getNumTypesOfItem());
					System.out.println("Number of Skills: " + Skill.getNumOfSkillsTotal());
					System.out.println("Number of Enemies: " + EnemyActor.m_numOfEnemies);
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
*/
		/*
		 * Battle Testing:
<<<<<<< HEAD
		 */
		PlayerActor a1=new PlayerActor();
		EnemyActor a2=new EnemyActor(1);

=======
		 * 
		Actor a1=new Actor();
		Actor a2=new Actor();
>>>>>>> 88f776a07cb9e6ae96f974d3aeea398929d6ffeb
		Battle battle=new Battle();
		
		Item basicsword=new Item(1);
		a1.equipSword(basicsword);
		
		a1.setName("Jeff");
<<<<<<< HEAD
		//a2.setName("Bob");
		//System.out.println("Jeff:"+a1.getCurHp()+" Bob: "+a2.getCurHp());
		//System.out.println(a2.getDefenseFighter());
				
		battle.actorBattle(a1,a2);
		//System.out.println("Jeff:"+a1.getCurHp()+" Bob: "+a2.getCurHp());
		//battle.printSkillsAvailable(a1);
=======
		a2.setName("Bob");
		battle.actorBattle(a1,a2);
		*/
||||||| merged common ancestors
>>>>>>> 88f776a07cb9e6ae96f974d3aeea398929d6ffeb
		
		
		
		System.out.println("Number of Items: " + Item.getNumTypesOfItem());
		System.out.println("Number of Skills: " + Skill.getNumOfSkillsTotal());
		System.out.println("Number of Enemies: " + EnemyActor.m_numOfEnemies);
		
		/*
		 * Battle Testing:
		 * 
		Actor a1=new Actor();
		Actor a2=new Actor();
		Battle battle=new Battle();
		
		Item basicsword=new Item(1);
		a1.EquipSword(basicsword);
		
		a1.setName("Jeff");
		a2.setName("Bob");
		battle.actorBattle(a1,a2);
		*/
=======
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
>>>>>>> bb02de8984a2a8e3247c4b802444931c30325f24
	}
<<<<<<< HEAD
	
}
||||||| merged common ancestors
	
}
=======
}
>>>>>>> bb02de8984a2a8e3247c4b802444931c30325f24
