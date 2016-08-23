import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chest
{
    /**
     * Act - do whatever the Chest wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
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
