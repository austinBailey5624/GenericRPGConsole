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

//		boolean exit = false;
//		while(!exit)
//		{
//			Scanner myScanner = new Scanner(System.in);
//			System.out.println("Welcome To GenericRPG! What would you like to do?\n1)developer options \n2)run world\n3)New Game[extraAlpha] \n4)exit");
//
//			select=myScanner.nextInt();
//			
//			if(select==1)
//			{
//				while(!exit)
//				{
//					System.out.println("1) determine number of items, skills and enemies\n2) Attempt Equip Item methods\n3) Attempt to use menu\n4) Attempt to use Shop\n5) exit");
//					select=myScanner.nextInt();
//					if(select==1)
//					{
//						System.out.println("Number of Items: " + Item.getNumTypesOfItem());
//						System.out.println("Number of Skills: " + Skill.getNumOfSkillsTotal());
//						System.out.println("Number of Enemies: " + EnemyActor.m_numOfEnemies);
//					}
//					else if(select==2)
//					{
//						PlayerActor myPlayerActor = new PlayerActor(1);
//						int[] testInventory = new int[itemSet.length];
//						for(int i=0; i<itemSet.length; i++)
//						{
//							testInventory[i]=3;
//						}
//						myPlayerActor.setInventory(testInventory);
//						myPlayerActor.menu();
//					}
//					else if(select==3)
//					{
//						PlayerActor myPlayerActor = new PlayerActor(1);
//						myPlayerActor.menu();
//					}
//					else if(select==4)
//					{
//						Shop thisShop = new Shop(1);
//						PlayerActor p1 = new PlayerActor(1);
//						thisShop.displayBuyMenu(p1);
//					}
//					else if(select==5)
//					{
//						exit=true;
//					}
//				}
//				exit=false;
//			}
//			else if(select==2)
//			{
//				WorldDriver wd = new WorldDriver();
//				wd.runWorld();
//			}
//			else if(select==3)
//			{
				PlayerActor user = new PlayerActor();
				WorldDriver wd = new WorldDriver(user);
				wd.runWorld();
//			}
//			else if(select==4)
//			{
//				System.out.println("Thank you for playing!");
//				return;
//			}
//			else
//			{
//				System.out.println("Sorry, we didn't undersand your input");
//			}
//		}
	}
}



