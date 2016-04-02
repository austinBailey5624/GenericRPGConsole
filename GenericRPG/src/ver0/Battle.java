/*@name: Battle.java
 *@date: 4/2/16
 *@brief: Contains methods for battle events throughout the game
 * 
 */
package ver0;
import java.util.Random;
import java.util.Scanner;
public class Battle 
{
	
	private Random r;
	private Scanner myScanner;
	private int order;
	private Actor victor;
	private int choice;
	private boolean ranAway;
	
	public Battle()
	{
		myScanner=new Scanner(System.in);
		r=new Random();
		ranAway=false;
		order=0;
		
	}
	
	public void actorBattle(Actor player, Actor npc)
	{
		int order=0; //randomNumber(0,1);
		
		//for testing purposes, the user will go first until method works correctly
		
		if (order==0)
		{
			System.out.println("By random selection, "+player.getName()+" will go first");
			
			do
			{
				printBattleMenu();
				try
				{
					choice=myScanner.nextInt();
				}
				catch(Exception ex)
				{
					System.out.println("You gave invalid input! please try again");
				}
				
				if (choice==1)
				{
					attack(player,npc);
				}
				else if (choice==2)
				{
					printSkillsAvailable(player);
					//use selected skill in battle
				}
				else if (choice==3)
				{
					printPotionsAvailable(player);
					//use selected potion in battle
				}
				else if (choice==4)
				{
					int run=randomNumber(0,1);
					if (run==0)
					{
						break;
					}
					else
					{
						System.out.println("You were unable to run away, coward!");
					}

					
				}
				break;
			}while(!isBattleOver(player,npc));
		}
		
		else
		{
			System.out.println("By random selection, "+npc.getName()+" will go first");
			while(!isBattleOver(player,npc))
			{
				printBattleMenu();
				break;
			}
		}
		
		if (ranAway)
		{
			System.out.println("You successfully ran away!");
		}
		

	}
	public void groupBattle(Actor[] goodguys, Actor[] badguys)
	{
		//will be filled in later
	}
	
	
	private boolean isBattleOver(Actor a1, Actor a2)
	{
		if (a1.getCurHp()==0 || a2.getCurHp()==0)
		{
			return true;
		}
		return false;
	}
	private void attack(Actor attacker, Actor defender)
	{
		System.out.println(attacker.getName()+" attacks "+defender.getName()+" with a "+attacker.getEquippedSword().getName());
	}
	
	
	//returns number inclusively between min and max
	private int randomNumber(int min, int max)
	{
		return r.nextInt(max-min+1)+min;
	}
	
	
	private void printBattleMenu()
	{
		System.out.println("It is your turn, input a number to choose one of the following to do:");
		System.out.println("1) Attack");
		System.out.println("2) Use Skill");
		System.out.println("3) Use Potion");
		System.out.println("4) Run Run Run!");
	}
	private void printSkillsAvailable(Actor a1)
	{
		
	}
	private void printPotionsAvailable(Actor a1)
	{
		
	}
}
