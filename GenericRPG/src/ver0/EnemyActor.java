package ver0;

public class EnemyActor extends Actor
{
	//member variables
	private int m_defeatExp;//This is the experience provided to the player character upon defeat
	
	static int m_numOfEnemies;
	public static EnemyActor[] getEnemies()
	{
		EnemyActor[] enemies = new EnemyActor[m_numOfEnemies];
		for(int i=0; i<m_numOfEnemies;i++)
		{
			enemies[i]= new EnemyActor(i);
		}
		return enemies;
	}
	
	//Constructor
	EnemyActor(int index)
	{
		Item[] itemArray=Item.getAllItems();
		m_skillSet=new boolean[Skill.getNumOfSkillsTotal()];
		for(int i=0; i<Skill.getNumOfSkillsTotal();i++)
		{
			m_skillSet[i]=false;
		}
		EquipSword(itemArray[8]);
		EquipSheild(itemArray[9]);
		EquipArmor(itemArray[10]);
		EquipHelmet(itemArray[11]);
		EquipGauntlets(itemArray[12]);
		EquipBoots(itemArray[13]);
		if(index==0)
		{
			setName("Generic Enemy");
			setLevel(1);
			setMaxHp(90+getLevel()*10);
			setCurHp(getMaxHp());
			setAtk(8);
			setDef(8);

			m_skillSet[0]=true;
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
		}
		m_numOfEnemies++;
	}
	//getters-setters
	public int getDefeatExp()
	{
		return m_defeatExp;
	}
	public void setDefeatExp(int defeatExp)
	{
		m_defeatExp=defeatExp;
	}
}