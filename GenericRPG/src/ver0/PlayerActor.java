package ver0;
import java.util.Scanner;
public class PlayerActor extends Actor
{
	static Scanner myScanner = new Scanner(System.in);
	static int select;

	//private member variables
	private int m_exp;
	private int m_gold;
	
	//Constructor
    /**
     * This function creates a playerActor and sets its member variables to their most basic sets
     * @precondition - 	None
     * @post - 			Creates an instance of PlayerActor with default values
     * @return 			An instance of PlayerActor
     */
	public PlayerActor()
	{

		Item[] itemSet = Item.getAllItems();
		Skill[] skillSet = Skill.getSkills();this.setLevel(1);
		m_gold=0;
		m_exp=0;
		equipSword(itemSet[8]);
		equipShield(itemSet[9]);
		equipArmor(itemSet[10]);
		equipHelmet(itemSet[11]);
		equipBoots(itemSet[13]);
		equipGauntlets(itemSet[12]);
		System.out.println("Welcome to Generic RPG!\n What is your name?");
		setName(myScanner.next());
		System.out.println("You awake in the middle of a dark forest, bruised and alone\n");
		System.out.println("A bag of gold, covered in blood, sits not far away");
		System.out.println("You pick it up +100 gold");
		addGold(100);
	}
	
	/**
	 * This function creates a special PlayerActor for testing purposes
	 * @precondition - 	constructor
	 * @post - 			creates an instance of PlayerActor
	 * @return -		constructor
	 */
	public PlayerActor(int id)
	{
		if(id==0)
		{
			this.setName(null);
			return;
		}
		Item[] itemSet = Item.getAllItems();
		Skill[] skillSet = Skill.getSkills();
		this.setName("Juan");
		this.setAtk(5);
		this.setDef(5);
		this.setLevel(0);
		this.addGold(500);
		for(int i=0; i<skillSet.length; i++)
		{
			if(i%2==0)
			{
				m_skillSet[i]=true;
			}
			else
			{
				m_skillSet[i]=false;
			}
		}
		equipSword(itemSet[14]);
		equipShield(itemSet[22]);
		equipArmor(itemSet[3]);
		equipHelmet(itemSet[11]);
		equipBoots(itemSet[13]);
		equipGauntlets(itemSet[12]);
	}
	
	/**
 
    * This function returns the value of m_exp
     * @precondition - 	PlayerActor Object exists
     * @post - 			none
     * @return 			m_ext
     */
	public int getExp()
	{
		return m_exp;
	}
	
    /**
     * This function sets the value of m_exp
     * @precondition - 	PlayerActor Object exists
     * @post - 			sets m_exp to parameter int exp
     * @return 	-		void
     */
	public void setExp(int exp)
	{
		m_exp=exp;
	}
	
    /**
     * This function returns the value of m_gold
     * @precondition -	PlayerActor Object exists
     * @post - 			none
     * @return 			m_gold
     */
	public int getGold()
	{
		return m_gold;
	}
	
    /**
     * This function sets the value of m_gold
     * @precondition - 	PlayerActor Object exists
     * @post - 			sets m_gold to parameter int gold
     * @return 	-		void
     */
	public void setGold(int gold)
	{
		m_gold=gold;
	}
	
	/**
	 * This function adds the value in the parameter to the variable m_gold
	 * @precondition - 	PlayerActor Object exists
	 * @post - 			sets m_gold to itself plus parameter gold
	 * @return - 		void
	 */
	public void addGold(int gold)
	{
		m_gold=m_gold+gold;
	}
	

	
	//Methods
	/**
	 * This function adds exp to a playerCharacter after an enemy is defeated
	 * @precondiion - 	PlayerActor Object exists
	 * @post - 			adds to m_exp and checks if the character should level up
	 * @return - 		void
	 */
	public void addExp(int addedExp)
	{
		m_exp+=addedExp;
		while(m_exp>=100*this.getLevel())
		{
			levelUp(m_exp-100*this.getLevel());
		}
	}
	
	/**
	 * This function is responsible for levelling up the PlayerCharacter
	 * @precondition - 	PlayerActor Object exists
	 * @post - 			increments member variables to progress character
	 * @return - 		void
	 */
	public void levelUp(int exp)
	{
		m_exp-=100*this.getLevel();
		setLevel(getLevel()+1);
		setMaxHp(getMaxHp()+10);
		setAtk(getAtk()+1);
		setDef(getDef()+1);
		//TODO implement choice for additional level up reward
	}
}

