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
	//member variables
	private Random r;
	private Scanner myScanner;
	private int order;
	private int skillChoice; 
	private Actor victor;
	private int choice;
	private boolean ranAway;
	private Skill[] m_skillSet;
	
	public Battle()
	{
		myScanner=new Scanner(System.in);
		r=new Random();
		ranAway=false;
		order=0;
		skillChoice=0;
		victor=new Actor();
		m_skillSet=Skill.getSkills();
	}
	
	public boolean actorBattle(Actor player, Actor npc)
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
					System.out.println("Input the corresponding number to use the skill");
					try
					{
						skillChoice=myScanner.nextInt();
					}
					catch(Exception ex)
					{
						System.out.println("You didnt input a number");
					}
					if (skillChoice<9)
					{
						if (player.getSkillset()[skillChoice]==true)
						{
							try
							{
								m_skillSet[skillChoice].Execute(player, npc);
							}
							catch(Exception ex)
							{
								System.out.println(ex.getStackTrace());
							}
						}
						else
						{
							System.out.println("You did not choose a skill you have!");
						}
					}
					else
					{
						System.out.println("You entered a number too high!");
					}
				
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
						ranAway=true;
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
		return true;

	}
	
	
	public void npcTurn(Actor npc)
	{
		
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
	public void printSkillsAvailable(Actor a1)
	{
		System.out.println("Skills available to you:\n");
		boolean[] skills=a1.getSkillset();
		
		for (int i=0; i<skills.length; i++)
		{
			if (skills[i]==true)
			{
				System.out.println(i+") "+m_skillSet[i].getName()+"- "+m_skillSet[i].getDescription());
			}
		}
		System.out.print("\n");
	}
	private void printPotionsAvailable(Actor a1)
	{
		
	}
}
