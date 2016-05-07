import java.util.Scanner;

/**
 * Write a description of class Library here.
 * 
 * @author Austin Bailey 
 * @version 5/6/2016
 */
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
    public void menu(Party party)
    {
        System.out.println("Welcome to the Library");
        boolean exit=false;
        String in;
        while(!exit)
        {
            System.out.println("1) Learn Skills");
            System.out.println("2) Read Bestiary");
            System.out.println("3) Leave");
            in=myScanner.next();
            if(verifyInt(in))
            {
                select=Integer.parseInt(in);
            }
            else
            {
                select=-1;//sets it to an invalid value to push it out of the else if block later
            }
            if(select==1)//Structured in an else if block to improve modularity-adding additional functionality later
            {
                if(party.onlyOne())
                {
                    learnSkills(party.getContent()[0]);
                }
                else
                {
                    int[] indexFromChoice=new int[4];
                    int choice=1;					
                    exit=false;
                    while(!exit)
                    {	
                        System.out.println("Which character would you like to teach?");
                        for(int i=0; i<4;i++)
                        {
                            if(party.getContent()[i]!=null)
                            {
                                System.out.println(choice+ ") " +party.getContent()[i].getName());
                                indexFromChoice[choice]=i;
                                choice++;
                            }
                        }
                        System.out.println(choice+ ") exit");
                        in=myScanner.next();
                        if(verifyInt(in))
                        {
                            select=Integer.parseInt(in);
                        }
                        else
                        {
                            select=-1;//dummy value to kick out of else if block
                        }
                        if(select>0&&select<choice)
                        {
                            learnSkills(party.getContent()[indexFromChoice[select]]);
                        }
                        else if(select==choice)
                        {
                            exit=true;
                        }
                        else
                        {
                            System.out.println("Sorry, we didn't understand your input, try again");
                        }
                    }
                }
            }
            else if(select==2)
            {
                bestiary();
            }
            else if(select==3)
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
                return;
            }
            else
            {

                System.out.println("You currently have: " + character.getGold() + " gold to spend on skills.");
                System.out.println("These are the skills we can teach you");
                int choice=1;
                for(int i=1; i<Skill.getNumOfSkillsTotal();i++)
                {
                    if((canTeach[i])&&!(character.m_skillSet[i]))
                    {
                        System.out.print(choice + ") Learn skill " + skillSet[i].getName());
                        for(int j=0; j<20-skillSet[i].getName().length();j++)
                        {
                            System.out.print(" ");
                        }
                        System.out.println(" costs: " + skillSet[i].getValue() + " gold");
                        indexRepresentedByChoice[choice]=i;
                        choice++;
                    }
                }
                System.out.println((choice) + ") Exit");
                String in=myScanner.next();
                if(verifyInt(in))
                {
                    select=Integer.parseInt(in);
                }
                else
                {
                    select=-1;//dummy value that kicks out of else if block
                }
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
                    learn(indexRepresentedByChoice[select],character);
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

	/**
	* This function handles the bestiary part of the library, displaying information about defeated enemies
	* @precondition:	none
	* @postcondition:	does not alter member variables
	* @return void*/
    public void bestiary()
    {
        EnemyActor[] enemies=EnemyActor.getEnemies();
        Skill[] skillSet = Skill.getSkills();
        boolean isEmpty=true;
        for(int i=0; i<enemies.length;i++)
        {
            if(enemies[i].getNumDefeated()>0)
            {
                isEmpty=false;
            }
        }
        if(isEmpty)
        {
            System.out.println("Sorry, you haven't defeated any enemies yet!");
        }
        int choice;
        String in;
        int[] indexRepresentedByChoice=new int[enemies.length];
        boolean exit=false;
        EnemyActor thisEnemy;
        while(!exit)
        {
            choice=1;
            System.out.println("Which enemy would you like to know more about?");
            for(int i=0; i<enemies.length;i++)
            {
                if(enemies[i].getNumDefeated()>0)
                {
                    System.out.println(choice+ ") " + enemies[i].getName());
                    choice++;
                    indexRepresentedByChoice[choice]=i;
                }
                System.out.println(choice+ ") Exit");
            }
            in=myScanner.next();
            if(verifyInt(in))
            {
                select=Integer.parseInt(in);
            }
            else
            {
                select=-1;
            }

            if(select<1||select>choice)
            {
                System.out.println("Sorry, we didn't understand your input");
            }
            else if((select>=1)&&(select<=choice))
            {
                thisEnemy=enemies[indexRepresentedByChoice[select]];
                if(enemies[indexRepresentedByChoice[select]].getNumDefeated()>0)
                {
                    System.out.println(enemies[indexRepresentedByChoice[select]].getDescription());
                }
                if(enemies[indexRepresentedByChoice[select]].getNumDefeated()>3)
                {
                    System.out.println("You have defeated " + enemies[indexRepresentedByChoice[select]].getNumDefeated() + " and have learned more about them");
                    System.out.println("Max HP:  " +thisEnemy.getMaxHp());
                    System.out.println("Attack:  " + thisEnemy.getAtk());
                    System.out.println("Defense: " + thisEnemy.getDef());
                }
                if(thisEnemy.getNumDefeated()>5)
                {
                    System.out.println("Equipped Sword: " + thisEnemy.getEquippedSword());
                    System.out.println("Equipped Shield: " + thisEnemy.getEquippedShield());
                }
                if(thisEnemy.getNumDefeated()>7)
                {
                    System.out.println("Equipped Armor: " + thisEnemy.getEquippedArmor());
                }
                if(thisEnemy.getNumDefeated()>10)
                {
                    System.out.println("Equipped Helmet: " + thisEnemy.getEquippedHelmet());
                    System.out.println("Equipped Gauntlets: " + thisEnemy.getEquippedGauntlets());
                    System.out.println("Equipped Boots: " + thisEnemy.getEquippedBoots());
                }
                if(thisEnemy.getNumDefeated()>15)
                {
                    System.out.println(thisEnemy.getName() + " knows these skills");
                    for(int i=0; i<Skill.getNumOfSkillsTotal();i++)
                    {
                        if(thisEnemy.m_skillSet[i]==true)
                        {
                            System.out.print(skillSet[i].getName());
                        }
                    }
                }
            }
            else
            {
                System.out.println("Sorry, we didn't understand your input");
            }
        }
    }

	/**
	* This function is used to verify that the input given by the user is an integer, which prevents errors
	* @precondition: 	none
	* @postcondition: 	none
	* @return:			true if string is an integer, false else
	*/
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
	
	/**
	* This function is used to test the constructor for Library, ensuring that it gives good results if passed a 1; 
	* @precondition:	Working definition of constructor
	* @postcondition:	none
	* @return: 			true if passed false else
	*/
	//public boolean LibraryTest1()
	//{
	//	try
	//	{
	//		Library a = new Library(1);
	//		return((a.canteach[0]==true)&&(a.canteach[1]==true)&&(a.canTeach[2]==true)&&(a.canTeach[3]==true)&&(a.canTeach[4]==true)&&(a.canTeach[5]==true)&&(a.canTeach[6]==false)&&(a.canTeach[7]==false));
	//	}
	//	catch(Exception e)
	//	{
	//		return false;
	//	}
	//}
	
	/**
	* This function is used to test the constructor if passed a 2
	* @precondition:	Working definition of constructor
	* @postcondition:	none
	* @return:			true if passed false else
	*/
	public boolean LibraryTest2()
	{
		try
		{
			Library a = new Library(2);
			return((a.canTeach[0]==true)&&(a.canTeach[1]==true)&&(a.canTeach[2]==true)&&(a.canTeach[3]==true)&&(a.canTeach[4]==true)&&(a.canTeach[5]==true)&&(a.canTeach[6]==true)&&(a.canTeach[7]==true));
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
