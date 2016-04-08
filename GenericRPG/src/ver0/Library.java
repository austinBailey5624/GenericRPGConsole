package ver0;
import java.util.Scanner;
public class Library 
{
	int select;
	Scanner myScanner = new Scanner(System.in);
	Skill[] skillSet = Skill.getSkills();
	boolean[] canTeach;
	
	
	/**
	 * This function generates a library based on the input whichLibrary
	 * @precondition:	none
	 * @post:			generates an instance of Library
	 * @return:			instance of Library
	 */
	public Library(int whichLibrary)
	{
		canTeach=new boolean[Skill.getNumOfSkillsTotal()];
		for(int i=0; i<Skill.getNumOfSkillsTotal();i++)//initializes all of can teach to false
		{
			canTeach[i]=false;
		}
		if(whichLibrary==1)
		{
			for(int i=0; i<=5;i++)//lets this library teach  first five skills
			{
				canTeach[i]=true;
			}
		}
		else if(whichLibrary==2)//lets this library teach all skills
		{
			for(int i=0; i<Skill.getNumOfSkillsTotal();i++)
			{
				canTeach[i]=true;
			}				
		}
	}
	
	/**
	 * This function handles the characters interaction with the Library
	 * @precondition:	none
	 * @post:			may manipulate character's member variables by changing booleans to add skills
	 * @return:			void 
	 */
	public void menu(PlayerActor character)
	{
		System.out.println("Welcome to the Library");
		boolean exit=false;
		while(!exit)
		{
			System.out.println("1)Learn Skills");
			System.out.println("2)Leave");
			select=myScanner.nextInt(); //TODO format input like done in will and tim's classes, handles bad input better
			if(select==1)//Structured in an else if block to improve modularity-adding additional functionality later
			{
				learnSkills(character);
			}
			else if(select==2)//TODO implement functionality where you can look at the enemies youv'e defeated, their information, etc
			{
				exit=true;
				return;
			}
			else
			{
				System.out.println("Sorry we didn't understand your input, please enter a number");
			}
		}
		return;
	}
	
	/**
	 * This function handles the menu interface surrounding learning skills
	 * @precondition:	instance of Library
	 * @postcondition:	character may have parts of his skillset set to true
	 * @return:			void
	 * @param character represents the character learning the skill
	 */
	public void learnSkills(PlayerActor character)
	{
		boolean knowAll=true;//handles the case where the character already knows all of his skills
		
		//System.out.println("These are the skills you don't already");
		boolean exit=false;
		int[] indexRepresentedByChoice= new int[skillSet.length];
		while(!exit)
		{
			for(int i=0; i<canTeach.length;i++)
			{
				if(canTeach[i]&&!(character.m_skillSet[i]))
				{
					knowAll=false;
				}
			}
			if(knowAll)
			{
				System.out.println("Sorry, you already know all that we can teach you!");
			}
			else
			{

				System.out.println("You currently have: " + character.getGold() + " gold to spend on skills.");
				System.out.println("These are the skills we can teach you");
				int choice=1;
				for(int i=1; i<Skill.getNumOfSkillsTotal();i++)//TODO: change i's starting value back to 0 and fix this mess
				{
					if(canTeach[i])//&&!(character.m_skillSet[i]))//TODO: fix this hotfix that displays all possible skills to be taught
					{
						System.out.print(choice + ") Learn skill " + skillSet[i].getName());
						for(int j=0; j<20-skillSet[i].getName().length();j++)
						{
							System.out.print(" ");
						}
						System.out.println(" costs: " + skillSet[i].getValue() + " gold");
	//					indexRepresentedByChoice[choice]=i;
	//					System.out.println(indexRepresentedByChoice[choice]);
						choice++;
					}
				}
				System.out.println((choice) + ") Exit");
				select=myScanner.nextInt();
				if(select==choice)
				{
					exit=true;
					return;
				}
				else if(select<1||select>(choice-1))
				{
					System.out.println("Sorry, we didn't understand your input, please try again");
				}
				else if(select<=choice)
				{
//					System.out.println(indexRepresentedByChoice[choice]);
					learn(select,character);
				}
			}
		}
	}
	/**
	 * This function determines if the character can learn the skill
	 * and if so teaches it
	 * @precondition:	traversal through encapsulating method that determines which skill will be learned
	 * @postconditon:	alters users member variables if they are successful in learning the skills
	 * @return:			void
	 */
	public void learn(int skillIndex,PlayerActor character)
	{
//		System.out.println("Skill index:\""+skillIndex+"\"");
		if(!canTeach[skillIndex])
		{
			System.out.println("Sorry, we don't teach that skill");
		}
		else if(character.getGold()<skillSet[skillIndex].getValue())
		{
			System.out.println("You can't afford to learn that Skill!");
			return;
		}
		else if(character.m_skillSet[skillIndex]==true)
		{
			System.out.println("You alreay know that skill!");
		}
		else
		{
			character.setGold(character.getGold()-skillSet[skillIndex].getValue());
			character.m_skillSet[skillIndex]=true;
			System.out.println("You have successfully learned the skill " + skillSet[skillIndex].getName());
		}
	}
}
