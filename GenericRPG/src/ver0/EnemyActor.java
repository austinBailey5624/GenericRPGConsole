package ver0;

public class EnemyActor extends Actor
{
	//member variables
	private int m_defeatExp;//This is the experience provided to the player character upon defeat
	private int m_defeatGold;//This is the gold provided to the player character upon defeat
	private int m_numDefeated;
	private String m_AIDiscription;
	//static int m_numOfEnemies;//This is the total number of enemies
	boolean[] m_skillSet;

	static int m_numOfEnemies=4;//This is the total number of enemies

    /**
     * This is a static method that returns all enemies for use in whatever file requires them
     * @precondition - none
     * @post - Loads EnemyActors
     * @return an array containing all enemyActors
     */
	public static EnemyActor[] getEnemies()
	{
		EnemyActor[] enemies = new EnemyActor[6];
		for(int i=0; i<6;i++)
		{
			enemies[i]= new EnemyActor(i);
		}
		return enemies;
	}
	
	//Constructor
    /**
     * This is a constructor that equips each enemy with their equipment and sets all necessary member variables 
     * @precondition - none
     * @post - creates an EnemyActor based on the index
     * @return instance of EnemyActor
     */
	public EnemyActor(int index) 
	{
		Item[] itemArray=Item.getAllItems();
		m_skillSet=new boolean[Skill.getNumOfSkillsTotal()];
		for(int i=0; i<Skill.getNumOfSkillsTotal();i++)
		{
			m_skillSet[i]=false;
		}
		m_status=new int[4];
		for(int i=0;i<m_status.length;i++)
		{
			m_status[i]=0;
		}

		setAttackModifier(1);
		setDefenseModifier(1);

		m_numDefeated=0;//Sets the number of enemies defeated to zero
		
		if(index==0)
		{
			setName("Serf");
			setDescription("This poor peasant fell on desperate times and fought in the arena to feed its family.\n Or so you would assume based on its weakness and lack of a weapon.\nSad state of affairs, really");
			setLevel(1);
			setMaxHp(90+getLevel()*10);
			setCurHp(getMaxHp());
			setAtk(8);
			setDef(8);
			m_AIDiscription="Only uses basic attack over and over again";
			m_skillSet[0]=true;
			
			m_defeatGold=10;
		}
		else if(index==1)
		{
			setName("Brute");
			setDescription("This brutal, angry peasant was thrown in jail and sent to the arena to pay off his debt.\n When the rage reaches his eyes, he will attack with brutal swings");
			setLevel(2);
			setMaxHp(105);
			setCurHp(getMaxHp());
			setAtk(12);
			setDef(6);
			m_AIDiscription="Has a 70% chance to use basic attack, 30% chance to use Power attack";
			m_skillSet[0]=true;
//			System.out.println("The length of the skillset is: " +m_skillSet.length);
			m_skillSet[9]=true;
			
			m_defeatGold=15;
		}
		else if(index==2)
		{
			setName("Poor fencer");
			setDescription("The poor fencer learned long ago the value of patience.\n He has been known to wait in his stance for hours, for his enemy to make a mistake, or reveal his stratedy");
			setLevel(3);
			setMaxHp(100);
			setCurHp(getMaxHp());
			setAtk(11);
			setDef(9);
			
			equipSword(itemArray[9]);
			m_skillSet[0]=true;
			m_skillSet[10]=true;
			m_AIDiscription="Has a 70% chance to use basic attack, 30% chance to use Threading Needle";
			m_defeatGold=20;
		}
		else if(index==3)
		{
			setName("Annoying Tank");
			setDescription("This Tank is annoying in many ways.\n Not only does he have a large defense, but he tells dumb jokes that everyone has already heard before, exept he always gets them wrong\nlike: Knock Knock, whose there, orange you glad I didn't say banana.\n A good stratedgy for this enemy is to figure out how to get around his shield");
			setLevel(4);
			setMaxHp(200);
			setCurHp(getMaxHp());
			setAtk(8);
			setDef(14);
			 
			m_skillSet[0]=true;
			//m_skillSet[11]=true;
			m_AIDiscription="begins by using shell, then only uses basic attack";
			equipShield(itemArray[2]);
			
			m_defeatGold=30;
		}
		else if(index==4)
		{
			setName("Glas Canon");
			setDescription("Glas Cannon was mean as a little kid, always beating up other kids, but crying to mommy whenever anyone hits back.\nHe was named Glas Canon after his grandfather, because the developers have no imagination");
			setLevel(5);
			setMaxHp(50);
			setCurHp(getMaxHp());
			setAtk(15);
			setDef(5);
			
			m_skillSet[0]=true;
			m_skillSet[9]=true;
			m_skillSet[16]=true;
			m_AIDiscription="Has a 70% chance to use basic attack, 30% chance to use Power attack. If his health is below 50%, he will use berserker rage, only once";
			m_defeatGold=40;
		}
		else if(index==5)
		{
			setName("Wolf");
			setDescription("An evil wolf looking to steal your sheep!");
			setLevel(1);
			setMaxHp(50);
			setCurHp(getMaxHp());
			setAtk(8);
			setDef(5);
			
			m_skillSet[0]=true;
			m_skillSet[17]=true;
			m_skillSet[18]=true;
			m_skillSet[19]=true;
			
			m_AIDiscription="Has a fifty fifty shot of using either wolf claw or wolf bite, except if under 50% health, then he will use howl before going back to fifty fifty between wolf claw or wolf bite";
			m_defeatGold=5;
		}
		m_defeatExp=getLevel()*15;
	}
	//getters-setters
    /**
     * This function returns the value of m_defeatExp
     * @precondition - EnemyActor Object exists
     * @post - none
     * @return m_defeatExp
     */
	public int getDefeatExp()
	{
		return m_defeatExp;
	}
	
    /**
     * This function sets the value of m_defeatExp
     * @precondition - EnemyActor Object exists
     * @post - sets m_defeatExp to the parameter int defeatExp
     * @return m_defeatExp
     */
	public void setDefeatExp(int defeatExp)
	{
		m_defeatExp=defeatExp;
	}
	
    /**
     * This function returns the value of m_defeatGold
     * @precondition - EnemyActor Object exists
     * @post - none
     * @return m_defeatGold
     */
	public int getDefeatGold()
	{
		return m_defeatGold;
	}
	
	/**
	 * This function returns the number of times that specific enemy has been defeated
	 * @precondtion:	EnemyActor Object exists
	 * @post:			Does not change member variables
	 * @return:			m_numDefeated
	 */
	public int getNumDefeated()
	{
		return m_numDefeated;
	}
	
	
	/**
	 * This function sets the values of BeenDefeated to false after it is defeated
	 * @precondition:	EnemyActor Object exists
	 * @post:			sets m_beenDefeated to true;
	 * @return:			void
	 */
	public void defeated()
	{
		m_numDefeated++;
	}
    /**
     * This function sets the value of m_defeatGold
     * @precondition - EnemyActor Object exists
     * @post - sets m_defeatGold to the parameter int defeatGold
     * @return m_defeatExp
     */
	public void setDefeatGold(int defeatGold)
	{
		m_defeatGold=defeatGold;
	}
}
