package ver0;
import java.util.Scanner;
public class PlayerActor extends Actor
{
	static Scanner myScanner = new Scanner(System.in);
	static int select;
	Item[] itemSet = Item.getAllItems();
	//private member variables
	private int m_exp;
	private int m_gold;
	private int[] m_inventory;
	
	//Constructor
	public PlayerActor()
	{
		this.setLevel(1);
		m_exp=0;
		m_inventory=new int[Item.getNumTypesOfItem()];
		for(int i=0; i<Item.getNumTypesOfItem();i++)
		{
			m_inventory[i]=0;
		}
	}
	
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
	public boolean buyItem(int index)//return true if buy is possible
	{
		if(m_gold>=itemSet[index].getValue())
		{
			m_gold=m_gold-itemSet[index].getValue();
			m_inventory[index]++;
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean canBuyItem(int cost)
	{
		if(m_gold>=cost)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean buyItems(int index, int quantity)
	{
		if(m_gold>=itemSet[index].getValue()*quantity)
		{
			m_gold=m_gold-(itemSet[index].getValue()*quantity);
			m_inventory[index]+=quantity;
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean canBuyItems(int cost, int quantity)
	{
		if(m_gold>=cost*quantity)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public int[] getInventory()
	{
		return m_inventory;
	}
	public void setInventory(int[] inventory)
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
	public void menu()
	{
		System.out.println("1) Access Inventory\n2) Return");
		select=myScanner.nextInt();
	}
	public void accessInventory()
	{
		Item[] items = Item.getAllItems();
		System.out.println("Here's the stuff in your inventory");
		for(int i=0; i<Item.getNumTypesOfItem();i++)
		{
			System.out.println("Equipped Sword:  " + this.getEquippedSword().getName());
			System.out.println("Equipped Shield: " + this.getEquippedShield().getName());
			if(m_inventory[i]>0)
			{
				System.out.println("You have " + m_inventory[i] + " " +items[i].getName());
			}
			System.out.println("1) Equip a Sword\n");
			System.out.println("2) Equip a Shield");
			System.out.println("3) Equip Armor");
			System.out.println("4) Equip Helmet");
			System.out.println("5) Equip Gauntlets");
			System.out.println("6) Equip Boots");
			System.out.println("7) Return");
			select=myScanner.nextInt();
			if(select==0)
			{
				equipSwordMenu();
			}
			else if(select==1)
			{
				equipShieldMenu();
			}
		}
	}
	public void equipSwordMenu()
	{
		Item[] items = Item.getAllItems();
		System.out.print("Which Sword do you want to equip?");
		{
			int choices=1;
			for(int i=0; i<items.length;i++)
			{
				if(m_inventory[i]>0&&items[i].getType()==1)
				{
					System.out.println(choices + ") " + items[i].getName() + " Attack Bonus: "+ items[i].getBonusAtk() + " Defense bonus: " + items[i].getBonusDef());
					choices++;
				}
			}
			select=myScanner.nextInt();
//			if(select=choices)
		}
	}
	public void equipShieldMenu()
	{
		
	}
	public void equipArmorMenu()
	{
		
	}
	public void equipHelmetMenu()
	{
		
	}
	public void equipGauntletsMenu()
	{
		
	}
	public void equipBootsMenu()
	{
		
	}
}
