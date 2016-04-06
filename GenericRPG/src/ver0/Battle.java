/*@name: Battle.java
 *@date: 4/2/16
 *@author Tim Elvart
 *@brief: Contains methods for battle events throughout the game
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
	private PlayerActor curPlayer;
	private boolean ranAway;
	private boolean playerMistake;
	private Skill[] m_skillSet;
	int potionchoice;
	
	public Battle()
	{
		myScanner=new Scanner(System.in);
		r=new Random();
		ranAway=false;
		order=0;
		skillChoice=0;
		m_skillSet=Skill.getSkills();
	}
	
	public boolean actorBattle(PlayerActor player, EnemyActor npc)//TODO add more output to user when using skills
	{
		String in;
		int choice=0;
		ranAway=false;
		curPlayer=player;
		order=randomNumber(0,1);
		System.out.println("Starting battle between "+player.getName()+" and "+npc.getName());
		
		if (order==0)
		{
			System.out.println("By random selection, "+player.getName()+" will go first\n");
			
			do
			{
				System.out.println("Current HP-> "+player.getName()+": "+player.getCurHp()+", "+npc.getName()+": "+npc.getCurHp());
				printBattleMenu();
				in=myScanner.next();
				if(verifyInt(in))
				{
					choice=Integer.parseInt(in);
				}
				else
				{
					System.out.println("You gave invalid input! please try again\n");
					continue;
				}
				if (choice==1)
				{
					int temphp1=npc.getCurHp();
					m_skillSet[0].Execute(player, npc);
					int temphp2=npc.getCurHp();
					int difference=temphp1-temphp2;
					System.out.println(player.getName()+" attacks "+npc.getName()+" with a "+player.getEquippedSword().getName()+", dealing "+difference+" damage!\n");
				}
				else if (choice==2)
				{
					printSkillsAvailable(player);
					System.out.println("Input the corresponding number to use the skill");
					in=myScanner.next();
					if (verifyInt(in))
					{
						skillChoice=Integer.parseInt(in);
					}
					else
					{
						System.out.println("You didnt input a number, please try again \n");
						continue;
					}
					if (skillChoice<8)
					{
						if (player.getSkillset()[skillChoice]==true)
						{
								m_skillSet[skillChoice].Execute(player, npc);
						}
						else
						{
							System.out.println("You did not choose a skill you have! Please try again\n");
							continue;
						}
					}
					else
					{
						System.out.println("You entered a number too high!\n");
						continue;
					}
				}
				else if (choice==3)
				{
					int[] pinv=player.getInventory();
					printPotionsAvailable(player);
					if (potionsAvailable())
					{
						System.out.println("Input the corresponding number to use the potion");
						
						in=myScanner.next();
						if (verifyInt(in))
						{
							potionchoice=Integer.parseInt(in);
						}
						else
						{
							System.out.println("You did not enter a number!\n");
							continue;
						}
						if (potionchoice==1)
						{
							if (pinv[7]>0)
							{
								usePotion(1);
								pinv[7]--;
							}
						}
						else if (potionchoice==2)
						{
							if (pinv[20]>0)
							{
								usePotion(2);
								pinv[20]--;
							}
						}
						else if (potionchoice==3)
						{
							if (pinv[27]>0)
							{
								usePotion(3);
								pinv[27]--;
							}
						}
						else
						{
							System.out.println("Invalid input given, please try again\n");
							continue;
						}
					}
					else
					{
						continue;
					}
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
						System.out.println("You were unable to run away, coward!\n");
					}
				}
				else
				{
					System.out.println("Invalid input given, please try again\n");
					continue;
				}
				System.out.println("It is now "+npc.getName()+"'s turn");
				npcTurn(npc);
				
			}while(!isBattleOver(player,npc));
		}
		
		else
		{
			System.out.println("By random selection, "+npc.getName()+" will go first\n");
			do
			{
				if (!playerMistake)
				{
					System.out.println("\nIt is now "+npc.getName()+"'s turn");
					npcTurn(npc);
				}
				
				System.out.println("Current HP-> "+player.getName()+": "+player.getCurHp()+", "+npc.getName()+": "+npc.getCurHp());
				printBattleMenu();
				in=myScanner.next();
				if (verifyInt(in))
				{
					choice=Integer.parseInt(in);
				}
				else
				{
					System.out.println("You did not input a number!\n");
					playerMistake=true;
				}
					
				if (choice==1)
				{
					int temphp1=npc.getCurHp();
					m_skillSet[0].Execute(player, npc);
					int temphp2=npc.getCurHp();
					int difference=temphp1-temphp2;
					System.out.println(player.getName()+" attacks "+npc.getName()+" with a "+player.getEquippedSword().getName()+", dealing "+difference+" damage!\n");
					playerMistake=false;
				}
				else if (choice==2)
				{
					printSkillsAvailable(player);
					System.out.println("Input the corresponding number to use the skill");
					in=myScanner.next();
					if (verifyInt(in))
					{
						skillChoice=Integer.parseInt(in);
					}
					else
					{
						System.out.println("You didnt input a number");
						playerMistake=true;
					}
					
					if (skillChoice<8)
					{
						if (player.getSkillset()[skillChoice]==true)
						{
								m_skillSet[skillChoice].Execute(player, npc);
								playerMistake=false;
						}
						else
						{
							System.out.println("You did not choose a skill you have! Please try again\n");
							playerMistake=true;
							continue;
						}
					}
					else
					{
						System.out.println("You entered a number too high!\n");
						playerMistake=true;
						continue;
					}
				}
				else if (choice==3)
				{
					int[] pinv=player.getInventory();
					printPotionsAvailable(player);
					if (potionsAvailable())
					{
						System.out.println("Input the corresponding number to use the potion");			
						
							in=myScanner.next();
							if (verifyInt(in))
							{
								potionchoice=Integer.parseInt(in);
							}
							else
							{
								System.out.println("You did not enter a number!");
								playerMistake=true;
								continue;
							}
							
						if (potionchoice==1)
						{
							if (pinv[7]>0)
							{
								usePotion(1);
								pinv[7]--;
								playerMistake=false;
							}
						}
						else if (potionchoice==2)
						{
							if (pinv[20]>0)
							{
								usePotion(2);
								pinv[20]--;
								playerMistake=false;
							}
						}
						else if (potionchoice==3)
						{
							if (pinv[27]>0)
							{
								usePotion(3);
								pinv[27]--;
								playerMistake=false;
							}
						}
						else
						{
							System.out.println("Invalid input given, please try again\n");
							playerMistake=true;
							continue;
						}
					}
					else
					{
						playerMistake=true;
						continue;
					}
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
						System.out.println("You were unable to run away, coward!\n");
					}
				}
			}while(!isBattleOver(player,npc));
		}
		
		if (ranAway)
		{
			System.out.println("You successfully ran away!");
			return true;
		}
		if(determineVictor(player,npc)==player)
		{
			player.addGold(npc.getDefeatGold());
			player.addExp(npc.getDefeatExp());
			System.out.println("\nCongrats on the victory! You recieved "+npc.getDefeatGold()+"gold, and "+npc.getDefeatExp()+" experience");
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void npcTurn(Actor npc)//TODO implement randomness into the npc turn
	{
		int curHp=curPlayer.getCurHp();
		m_skillSet[0].Execute(npc,curPlayer);
		int newHp=curPlayer.getCurHp();
		int damage=curHp-newHp;
		System.out.println(npc.getName()+" attacks "+curPlayer.getName()+" with a "+npc.getEquippedSword().getName()+", dealing "+damage+" damage!\n");
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
	
	public void groupBattle(Actor[] goodguys, Actor[] badguys)//TODO complete group battle method
	{
		//will be filled in later
	}
	
	private boolean isBattleOver(Actor a1, Actor a2)
	{
		if (a1.getCurHp()<=0 || a2.getCurHp()<=0)
		{
			return true;
		}
		return false;
	}
	//returns number inclusively between min and max
	private int randomNumber(int min, int max)
	{
		return r.nextInt(max-min+1)+min;
	}
	
	private void printBattleMenu()
	{
		System.out.println("It is your turn, input a number to choose one of the following to do:");
		System.out.println("1) Basic Attack (using sword)");
		System.out.println("2) Use Skill");
		System.out.println("3) Use Potion");
		System.out.println("4) Run Run Run!");
	}
	public void printSkillsAvailable(PlayerActor a1)
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
	private boolean potionsAvailable()
	{
		int[] playerInventory=curPlayer.getInventory();
		if (playerInventory[7]>0 || playerInventory[20]>0 || playerInventory[27]>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	private void printPotionsAvailable(PlayerActor a1)
	{
		System.out.println("Potions available to you:");
		int[] playerInventory=a1.getInventory();
		
		if (playerInventory[7]>0)
		{
			System.out.println("1) Name: Basic Health Potion, Effect: Restore 50 HP, Quantity: "+playerInventory[7]);
		}
		if (playerInventory[20]>0)
		{
			System.out.println("2) Name: Advanced Health Potion, Effect: Restore 100 HP, Quantity: "+playerInventory[20]);
		}
		if (playerInventory[27]>0)
		{
			System.out.println("3) Name: Expert Health Potion, Effect: Restore 150 HP, Quantity: "+playerInventory[27]);
		}
		if (!(playerInventory[7]>0 || playerInventory[20]>0 || playerInventory[27]>0))
		{
			System.out.println("You currently don't have any potions\n");
		}
	}
	private void usePotion(int choice)
	{
		if (choice==1)
		{
			if (curPlayer.getCurHp()+50>curPlayer.getMaxHp())
			{
				curPlayer.setCurHp(curPlayer.getMaxHp());
				
			}
			else
			{
				curPlayer.setCurHp(curPlayer.getCurHp()+50);
			}
			System.out.println("You used a basic health potion, recovering 50 HP!\n");
		}
		else if (choice==2)
		{
			if (curPlayer.getCurHp()+100>curPlayer.getMaxHp())
			{
				curPlayer.setCurHp(curPlayer.getMaxHp());
				
			}
			else
			{
				curPlayer.setCurHp(curPlayer.getCurHp()+100);
			}
			System.out.println("You used an advanced health potion, recovering 100 HP!\n");
		}
		else if (choice==3)
		{
			if (curPlayer.getCurHp()+150>curPlayer.getMaxHp())
			{
				curPlayer.setCurHp(curPlayer.getMaxHp());
				
			}
			else
			{
				curPlayer.setCurHp(curPlayer.getCurHp()+150);
			}
			System.out.println("You used an expert health potion, recovering 150 HP!\n");
		}
	}
	private Actor determineVictor(Actor a1, Actor a2)
	{
		if (a1.getCurHp()==0)
		{
			return a2;
		}
		else
		{
			return a1;
		}
	}
}
