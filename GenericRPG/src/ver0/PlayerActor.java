package ver0;

public class PlayerActor extends Actor
{
	//private member variables
	private int m_exp;
	private int m_gold;
	private Inventory m_inventory;
	
	//getters and setters TODO write JavaDocs for methods
	public int getExp()
	{
		return m_exp;
	}
	public void setExp(int exp)
	{
		m_exp=exp;
	}
	public int getGold()
	{
		return m_gold;
	}
	public void setGold(int gold)
	{
		m_gold=gold;
	}
	public void addGold(int gold)
	{
		m_gold=m_gold+gold;
	}
	public boolean buyItem(int cost)//return true if buy is possible
	{
		if(m_gold>=cost)
		{
			m_gold=m_gold-cost;
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean buyItems(int cost, int quantity)
	{
		if(m_gold>=cost*quantity)
		{
			m_gold=m_gold-(cost*quantity);
			return true;
		}
		else
		{
			return false;
		}
	}
	public Inventory getInventory()
	{
		return m_inventory;
	}
	public void setInventory(Inventory inventory)
	{
		m_inventory=inventory;
	}
	
	//Methods
	public void addExp(int addedExp)
	{
		m_exp+=addedExp;
		while(m_exp>100*this.getLevel())
		{
			levelUp(m_exp-100*this.getLevel());
		}
	}
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
