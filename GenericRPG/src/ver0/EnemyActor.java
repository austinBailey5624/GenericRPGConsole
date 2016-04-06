package ver0;

public class EnemyActor extends Actor
{
	//member variables
	private int m_defeatExp;//This is the experience provided to the player character upon defeat
	private int m_defeatGold;//This is the gold provided to the player character upon defeat

	//static int m_numOfEnemies;//This is the total number of enemies
	

	static int m_numOfEnemies=4;//This is the total number of enemies

    /**
     * This is a static method that returns all enemies for use in whatever file requires them
     * @precondition - none
     * @post - Loads EnemyActors
     * @return an array containing all enemyActors
     */
	public static EnemyActor[] getEnemies()
	{
		EnemyActor[] enemies = new EnemyActor[4];
		for(int i=0; i<4;i++)
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
	public EnemyActor(int index) //TODO add defeat experience to all enemy types
	{
		Item[] itemArray=Item.getAllItems();
		m_skillSet=new boolean[Skill.getNumOfSkillsTotal()];
		for(int i=0; i<Skill.getNumOfSkillsTotal();i++)
		{
			m_skillSet[i]=false;
		}


		equipSword(itemArray[8]);
		equipShield(itemArray[9]);
		equipArmor(itemArray[10]);
		equipHelmet(itemArray[11]);
		equipGauntlets(itemArray[12]);
		equipBoots(itemArray[13]);
		setAttackModifier(1);
		setDefenseModifier(1);


		setAttackModifier(1);
		setDefenseModifier(1);

		equipSword(itemArray[8]);
		equipShield(itemArray[9]);
		equipArmor(itemArray[10]);
		equipHelmet(itemArray[11]);
		equipGauntlets(itemArray[12]);
		equipBoots(itemArray[13]);

		if(index==0)
		{
			setName("Generic Enemy");
			setLevel(1);
			setMaxHp(90+getLevel()*10);
			setCurHp(getMaxHp());
			setAtk(8);
			setDef(8);

			m_skillSet[0]=true;
			
			m_defeatGold=10;
		}
		else if(index==1)
		{
			setName("Brute");
			setLevel(2);
			setMaxHp(105);
			setCurHp(getMaxHp());
			setAtk(12);
			setDef(6);
			
			m_skillSet[0]=true;
			m_skillSet[1]=true;
			
			m_defeatGold=15;
		}
		else if(index==2)
		{
			setName("Cautious Enemy");
			setLevel(3);
			setMaxHp(100);
			setCurHp(getMaxHp());
			setAtk(11);
			setDef(9);
			
			m_skillSet[0]=true;
			m_skillSet[3]=true;
			
			m_defeatGold=20;
		}
		else if(index==3)
		{
			setName("Annoying Tank");
			setLevel(4);
			setMaxHp(200);
			setCurHp(getMaxHp());
			setAtk(8);
			setDef(14);
			 
			m_skillSet[0]=true;
			m_skillSet[3]=true;
			
			m_defeatGold=30;
		}
		else if(index==4)
		{
			setName("Glass Cannon");
			setLevel(5);
			setMaxHp(50);
			setCurHp(getMaxHp());
			setAtk(15);
			setDef(5);
			
			m_skillSet[0]=true;
			m_skillSet[1]=true;
			
			m_defeatGold=40;
		}
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
