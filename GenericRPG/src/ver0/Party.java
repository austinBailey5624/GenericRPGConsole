package ver0;

public class Party 
{
	//TODO: make buildings static members? I mean if were going to pass around a party it should carry everything right?
	//TODO: make quests static member variables as well
	protected PlayerActor[] m_content;
	private int m_gold;
	private int[] m_inventory;
	
	//constructor
	public Party()
	{
		m_content = new PlayerActor[4];
		m_gold=0;
		m_inventory = new int[Item.getNumTypesOfItem()];//makes an inventory of length the number of items
		for(int i=0; i<m_inventory.length;i++)
		{
			m_inventory[i]=0;//for each part of the inventory, sets the number owned to zero
		}
	}
	
	//getters and setters
	
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
		m_gold+=gold;
	}
	public int[] getInventory()
	{
		return m_inventory;
	}
	public void setInventory(int[] inventory)
	{
		m_inventory=inventory;
	}
	public PlayerActor[] getContent()
	{
		return m_content;
	}
	public void setContent(PlayerActor[] content)
	{
		if(content.length!=4)
		{
			System.out.println("ERROR- passing an array of Actors of size other than five");
			return;
		}
		m_content=content;
	}
}
