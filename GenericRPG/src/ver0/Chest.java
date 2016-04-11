package ver0;

/**
 * @author : Will Teeple
 * @version : 0.1
 * @since 04/11/2016
 * Description : 
 */

public class Chest {
	
	private int m_itemInChestIndex;	
	
	public Chest(int itemID)
	{
		m_itemInChestIndex = itemID;
	}
	
	public int getItemInChest() 
	{
		return m_itemInChestIndex;
	}
	
	public void setItemInChest(int index)
	{
		m_itemInChestIndex = index;
	}
}
