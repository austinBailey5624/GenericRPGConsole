package ver0;

public class Actor 
{
	private String m_name;
	private int m_level;
	private int m_maxHp;//max Hit Points
	private int m_curHp;//current Hit Points
	private int m_atk;
	private int m_def;
	private Item m_equippedSword;
	private Item m_equippedShield;
	private Item m_equippedArmor;
	private Item m_equippedHelmet;
	private Item m_equippedBoots;
	private Item m_equippedGauntlets;
	private boolean[] m_skillSet;
	//Constructors
	public Actor()//default constructor
	{
		m_level=1;
		m_maxHp=100;
		m_curHp=100;
		m_atk=10;
		m_def=10;
		m_equippedSword=null;
		m_equippedShield=null;
		m_equippedHelmet=null;
		m_equippedBoots=null;
		m_equippedGauntlets=null;
		m_skillSet=new boolean[Skill.getNumOfSkillsTotal()];
		for(int i=0; i<Skill.getNumOfSkillsTotal();i++)
		{
			m_skillSet[i]=false;
		}
		m_skillSet[0]=true;//sets the basic attack skill to true to ensure that it is avaliable to all
	}
	
	
	//Setters and Getters
	public String getName()
	{
		return m_name;
	}
	public void setName(String name)
	{
		m_name=name;
	}
	public int getLevel()
	{
		return m_level;
	}
	public void setLevel(int level)
	{
		m_level=level;
	}
	public int getMaxHp()
	{
		return m_maxHp;
	}
	public void setMaxHp(int maxHP)
	{
		m_maxHp=maxHP;
	}
	public int getCurHp()
	{
		return m_curHp;
	}
	public void setCurHp(int curHp)
	{
		m_curHp=curHp;
	}
	public int getAtk()
	{
		return m_atk;
	}
	public void setAtk(int Atk)
	{
		m_atk=Atk;
	}
	public int getDef()
	{
		return m_def;
	}
	public void setDef(int Def)
	{
		m_def=Def;
	}
	public Item getEquippedSword()
	{
		return m_equippedSword;
	}
	public void EquipSword(Item sword)
	{
		if(sword.getType()==1)
		{
			m_equippedSword=sword;
		}
		else
		{
			System.out.println("Cannot equip that in the sword slot!");
		}
	}
	public Item getEquippedSheild()
	{
		return m_equippedShield;
	}
	public void EquipSheild(Item shield)
	{
		if(shield.getType()==2)
		{
			m_equippedShield=shield;
		}
		else
		{
			System.out.println("Cannon equip that in the Sheild slot!");
		}
	}
	//TODO write getters and setters for equipped items
	
	//Battle Methods
	public boolean reduceHp(int damage)//returns bool if fatal
	{
		m_curHp=m_curHp-damage;
		if(m_curHp>0)
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
	public boolean basicAttack(Actor opponent)
	{
		return opponent.reduceHp(this.getAtk());
	}
	
	//getters and setters for battle that have the alteration from the items in addition to the basics
	public int getAttackFighter()
	{
//		return getAtk()+m_equippedSword.getBonusAttack()+m_equippedShield.getBonusAttack()+m_equippedHelmet.getBonusAttack()+m_equippedBoots.getBonusAttack() + m_equippedGauntlets.getBonusAttack();		
	return 0;//used because getBonusAttack has yet to be written
	}
	public int getDefenseFighter()
	{
//		return getDef()+m_equippedSword.getBonusDefense()+m_equippedShield.getBonusDefense()+m_equippedHelmet.getBonusDefense()+m_equippedBoots.getBonusDefense()+m_equippedGauntlets.getBonusAttack();
		return 0;//used because getBonusDefense has yet to be written
	}
}
