package ver0;
import java.util.Scanner;
public class Library 
{
	int select;
	Scanner myScanner = new Scanner(System.in);
	Skill[] skillSet = Skill.getSkills();
	boolean[] canTeach;
	
	Library(int whichLibrary)
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
	public void menu(PlayerActor character)
	{
		System.out.println("Welcome to the Library");
		boolean exit=false;
		while(!exit)
		{
			System.out.println("1)Learn Skills");
			System.out.println("2)Leave");
			select=myScanner.nextInt();
			if(select==1)//Structured in an else if block to improve modularity-adding additional functionality later
			{
				
			}
			else if(select==2)//TODO implement functiaty where you can look at the enemies youv'e defeated, their information, etc
			{
				return;
			}
			else
			{
				System.out.println("Sorry we didn't understand your input, please enter a number");
			}
		}
	}
	public void learnSkills(PlayerActor character)
	{
		boolean knowAll=true;//handles the case where the character already knows all of his skills
		
		//System.out.println("These are the skills you don't already");
		boolean exit=false;
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
				int[] indexRepresentedByChoice= new int[skillSet.length];
				System.out.println("These are the skills we can teach you");
				int choice=1;
				for(int i=0; i<Skill.getNumOfSkillsTotal();i++)
				{
					if(canTeach[i]&&!(character.m_skillSet[i]))
					{
						System.out.println(choice + ") Learn skill " + skillSet[i].getName() + " for " + skillSet[i].getValue());
						choice++;
						indexRepresentedByChoice[choice]=i;
					}
				}
				System.out.println((choice+1) + ") Exit");
				select=myScanner.nextInt();
				if(select<1||select>(choice+1))
				{
					System.out.println("Sorry, we didn't understand your input, please try again");
				}
				else if(select<=choice)
				{
					learn(indexRepresentedByChoice[choice],character);
				}
			}
		}
	}
	public void learn(int skillIndex,PlayerActor character)
	{
		if(character.getGold()<skillSet[skillIndex].getValue())
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
			System.out.println("You have successfully learned the skill " + skillSet[skillIndex].getValue());
		}
	}
}
