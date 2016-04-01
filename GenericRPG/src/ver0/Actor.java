package ver0;

public class Actor 
{
	String m_name;
	private int m_maxHp;//max Hit Points
	private int m_curHp;//current Hit Points
	private int m_atk;
	private int m_def;
	private Inventory m_inventory;
	private Item m_equippedSword;
	private Item m_equippedShield;
	private Item m_equippedArmor;
	private Item m_equippedHelmet;
	private Item m_equippedBoots;
	private Item m_equippedGauntlets;
	
	//Constructors
	public Actor()//default constructor
	{
		m_maxHp=100;
		m_curHp=100;
		m_atk=10;
		m_def=10;
	}
	
	
	//Setters and Getters
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
	public Inventory getInventory()
	{
		return m_inventory;
	}
	public void setInventory(Inventory inventory)
	{
		m_inventory=inventory;
	}
	
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
}
