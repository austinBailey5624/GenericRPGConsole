package ver0;

/**
 * This is a class for the items in the game.
 *
 * @author Michael Wang
 * Created by Michael on 3/26/2016.
 */


public class Item{
    protected int m_type;
    protected int m_limit;
    protected int m_id;
    protected int m_bonusDef;
    protected int m_bonusAtk;
    protected int m_bonusMDef;
    protected int m_bonusMAtk;
    protected int m_bonusHp;
    protected int m_value;
    protected int m_counter;
    
    private static int m_numTypesOfItem = 9;
    private static int m_numTypesOfWeapon = 11;
    
    protected String m_name;
    protected boolean m_used;
    
    /**
     * This function returns an array of all the items.
     * pre - none
     * post - creates an array of all the items
     * @return itemArray
     */
    public static Item[] getAllItems()
    {

    	//Item[] itemArray = new Item[m_numTypesOfItem];
    	
    	Item[] itemArray = new Item[m_numTypesOfItem + m_numTypesOfWeapon];


    	for(int i=0; i<m_numTypesOfItem; i++)//Hey, I thought this would ease the process for adding new items, should do it automatically
    	{
    		itemArray[i]=new Item(i);
    	}
    	for(int i=m_numTypesOfItem; i<(m_numTypesOfItem + m_numTypesOfWeapon); i++)
    	{
    		itemArray[i]=new Weapon(i-m_numTypesOfItem);
    	}
    	return itemArray;
    }

    /**
     * This function is the default constructor for the different items
     * pre - none
     * post - none
     * Returns - none
     */
    public Item()
    {
    	
    }
    
    /**
     * This function is the constructor for the different items
     * pre - needs the parameters down below
     * post - creates a item
     * Returns - an item based off of the integer given.
     * @param typeOfItem takes in an int in order to create the item
     */
    public Item(int typeOfItem)
    {
        m_limit = 0;
        m_id = 0;
        m_bonusDef = 0;
        m_bonusAtk = 0;
        m_bonusMDef = 0;
        m_bonusMAtk = 0;
        m_bonusHp = 0;
        m_value = 0;
        m_counter = 0;
        
        m_name = "";
        m_used = false;
        
        if(typeOfItem == 0)
        {
        	m_type = 0;
            m_name = "basic potion";
            m_limit = 10;
            m_bonusDef = 0;
            m_bonusAtk = 0;
            m_bonusMDef = 0;
            m_bonusMAtk = 0;
            m_bonusHp = 50;
            m_value = 10;
            m_counter = 1;
        }
        else if(typeOfItem == 1)
        {
            m_type = 0;
            m_name = "advanced potion";
            m_limit = 5;
            m_bonusDef = 0;
            m_bonusAtk = 0;
            m_bonusMDef = 0;
            m_bonusMAtk = 0;
            m_bonusHp = 100;
            m_value = 50;
            m_counter = 1;
        }
        else if(typeOfItem == 2)
        {
            m_type = 0;
            m_name = "master potion";
            m_limit = 1;
            m_bonusDef = 0;
            m_bonusAtk = 0;
            m_bonusMDef = 0;
            m_bonusMAtk = 0;
            m_bonusHp = 500;
            m_value = 100;
            m_counter = 1;
        }
        else if(typeOfItem == 3)
        {
            m_type = 0;
            m_name = "poison potion";
            m_limit = 5;
            m_bonusDef = 0;
            m_bonusAtk = 0;
            m_bonusMDef = 0;
            m_bonusMAtk = 0;
            m_bonusHp = 0;
            m_value = 10;
            m_counter = 5;
        }
        else if(typeOfItem == 4)
        {
            m_type = 0;
            m_name = "stun potion";
            m_limit = 5;
            m_bonusDef = 0;
            m_bonusAtk = 0;
            m_bonusMDef = 0;
            m_bonusMAtk = 0;
            m_bonusHp = 0;
            m_value = 10;
            m_counter = 5;
        }
        else if(typeOfItem == 5)
        {
            m_type = 0;
            m_name = "defense potion";
            m_limit = 5;
            m_bonusDef = 50;
            m_bonusAtk = 0;
            m_bonusMDef = 0;
            m_bonusMAtk = 0;
            m_bonusHp = 0;
            m_value = 10;
            m_counter = 1;
        }
        else if(typeOfItem == 6)
        {
            m_type = 0;
            m_name = "attack potion";
            m_limit = 5;
            m_bonusDef = 0;
            m_bonusAtk = 50;
            m_bonusMDef = 0;
            m_bonusMAtk = 0;
            m_bonusHp = 0;
            m_value = 10;
            m_counter = 1;
        }
        else if(typeOfItem == 7)
        {
            m_type = 3;
            m_name = "basic armor";
            m_limit = 5;
            m_bonusDef = 50;
            m_bonusAtk = 0;
            m_bonusMDef = 0;
            m_bonusMAtk = 0;
            m_bonusHp = 0;
            m_value = 10;
            m_counter = 0;
        }
        else if(typeOfItem == 8)
        {
            m_type = 4;
            m_name = "basic helmet";
            m_limit = 5;
            m_bonusDef = 100;
            m_bonusAtk = 0;
            m_bonusMDef = 0;
            m_bonusMAtk = 0;
            m_bonusHp = 0;
            m_value = 10;
            m_counter = 0;
        }
        m_id = typeOfItem;

    }

    /**
     * This function returns the value of m_type
     * pre - none
     * post - none
     * @return m_type
     */
    public int getType()
    {
        return m_type;
    }

    /**
     * This function returns the value of m_limit
     * pre - none
     * post - none
     * @return m_limit
     */
    public int getLimit()
    {
        return m_limit;
    }
    
    /**
     * This function returns the value of m_id
     * pre - none
     * post - none
     * @return m_id
     */
    public int getId()
    {
        return m_id;
    }
    
    /**
     *This function returns the value of m_name
     * pre - none
     * post - none
     * @return m_name
     */
    public String getName()
    {
        return m_name;
    }


    /**
     *This function returns the value of m_used
     * pre - none
     * post - none
     * @return m_used
     */
    public boolean getUsed()
    {
        return m_used;
    }

    /**
     *This function sets the valus of m_used with a given value
     * pre - needs the parameters down below
     * post - sets m_used to the isUsed boolean given
     * return - none
     * @param isUsed - boolean that tells if the item is used or not
     */
    public void setUsed(boolean isUsed)
    {
        m_used = isUsed;
    }

    /**
     *This function returns the value of m_bonusDef
     * pre - none
     * post - none
     * @return m_bonusDef
     */
    public int getBonusDef()
    {
    	return m_bonusDef;
    }

    /**
     *This function returns the value of m_bonusAtk
     * pre - none
     * post - none
     * @return m_bonusAtk
     */
    public int getBonusAtk()
    {
    	return m_bonusAtk;
    }
    
    /**
     *This function returns the value of m_bonusMDef
     * pre - none
     * post - none
     * @return m_bonusMDef
     */
    public int getBonusMDef()
    {
    	return m_bonusMDef;
    }

    /**
     *This function returns the value of m_bonusMAtk
     * pre - none
     * post - none
     * @return m_bonusMAtk
     */
    public int getBonusMAtk()
    {
    	return m_bonusMAtk;
    }
    
    /**
     *This function returns the value of m_bonusHp
     * pre - none
     * post - none
     * @return m_bonusHp
     */
    
    /**
     *This function returns the value of m_bonusHp
     * pre - none
     * post - none
     * @return m_bonusHp
     */
    
    public int getBonusHp()
    {
    	return m_bonusHp;
    }
    
    /**
     *This function returns the value of m_counter
     * pre - none
     * post - none
     * @return m_counter
     */
    public int getCounter()
    {
    	return m_counter;
    }

    /**
     *This function returns the value of m_numTypesOfItem
     * pre - none
     * post - none
     * @return m_numTypesOfItem
     */
    public static int getNumTypesOfItem()
    {
    	return m_numTypesOfItem;
    }
    
    /**
     *This function sets the valus of m_used with a given value
     * pre - needs the parameters down below
     * post - sets m_used to the isUsed boolean given
     * return - none
     * @param isUsed - boolean that tells if the item is used or not
     */
    public void setNumTypesOfItem(int numTypesItem)
    {
    	m_numTypesOfItem = numTypesItem;
    }
    
    /**
     *This function returns the value of m_numTypesOfWeapon
     * pre - none
     * post - none
     * @return m_numTypesOfWeapon
     */
    public static int getNumTypesOfWeapon()
    {
    	return m_numTypesOfWeapon;
    }
    
    /**
     *This function returns the value of m_value
     * pre - none
     * post - none
     * @return m_value
     */
    public int getValue()
    {
    	return m_value;
    }
    
    
    
    //These are the test functions to see if certain functions work
        
    /**
     *This function returns true if the item array length is equal to the sum of the number of types of items and the number of types of weapons
     * pre - none
     * post - none
     * @return true if the item array length is not equal to the sum of the total number of items and weapons and false otherwise
     */
    public boolean itemTest1()
    {
    	int itemArray = Item.getAllItems().length;
    	if(itemArray != (getNumTypesOfItem() + getNumTypesOfWeapon()))
    	{
    		return false;
    	}
    	return true;
    }
    
    /**
     *This function returns true if the item0 is a basic potion by comparing the stats of the item
     * pre - none
     * post - none
     * @return true if the item is a basic potion and false otherwise
     */
    public boolean itemTest2()
    {
    	Item item0 = new Item(0);
    	if((m_type == 0)&&(m_name == "basic potion")&&(m_limit == 10)&&(m_bonusDef == 0)&&(m_bonusAtk == 0)&&(m_bonusMDef == 0)&&(m_bonusMAtk == 0)&&(m_bonusHp == 50)&&(m_value == 10)&&(m_counter == 1)&&(m_id == 0))
    	{
    		return true;
    	}
    	return false;
    }
        
    /**
     *This function returns true if the item1 is an advanced potion by comparing the stats of the item
     * pre - none
     * post - none
     * @return true if the item is an advanced potion and false otherwise
     */
    public boolean itemTest3()
    {
    	Item item0 = new Item(1);
    	if((m_type == 1)&&(m_name == "advanced potion")&&(m_limit == 5)&&(m_bonusDef == 0)&&(m_bonusAtk == 0)&&(m_bonusMDef == 0)&&(m_bonusMAtk == 0)&&(m_bonusHp == 100)&&(m_value == 50)&&(m_counter == 1)&&(m_id == 1))
    	{
    		return true;
    	}
    	return false;
    }
    
    /**
     *This function returns true if the item2 is a master potion by comparing the stats of the item
     * pre - none
     * post - none
     * @return true if the item is a master potion and false otherwise
     */
    public boolean itemTest4()
    {
    	Item item0 = new Item(2);
    	if((m_type == 2)&&(m_name == "master potion")&&(m_limit == 1)&&(m_bonusDef == 0)&&(m_bonusAtk == 0)&&(m_bonusMDef == 0)&&(m_bonusMAtk == 0)&&(m_bonusHp == 500)&&(m_value == 100)&&(m_counter == 1)&&(m_id == 2))
    	{
    		return true;
    	}
    	return false;
    }
    
    /**
     *This function returns true if the item3 is a posion potion by comparing the stats of the item
     * pre - none
     * post - none
     * @return true if the item is a posion potion and false otherwise
     */
    public boolean itemTest5()
    {
    	Item item0 = new Item(3);
    	if((m_type == 3)&&(m_name == "posion potion")&&(m_limit == 5)&&(m_bonusDef == 0)&&(m_bonusAtk == 0)&&(m_bonusMDef == 0)&&(m_bonusMAtk == 0)&&(m_bonusHp == 0)&&(m_value == 10)&&(m_counter == 5)&&(m_id == 3))
    	{
    		return true;
    	}
    	return false;
    }
    
    /**
     *This function returns true if the item4 is a stun potion by comparing the stats of the item
     * pre - none
     * post - none
     * @return true if the item is a stun potion and false otherwise
     */
    public boolean itemTest6()
    {
    	Item item0 = new Item(4);
    	if((m_type == 4)&&(m_name == "stun potion")&&(m_limit == 5)&&(m_bonusDef == 0)&&(m_bonusAtk == 0)&&(m_bonusMDef == 0)&&(m_bonusMAtk == 0)&&(m_bonusHp == 0)&&(m_value == 10)&&(m_counter == 5)&&(m_id == 4))
    	{
    		return true;
    	}
    	return false;
    }
    
    /**
     *This function returns true if the item5 is a defense potion by comparing the stats of the item
     * pre - none
     * post - none
     * @return true if the item is a defense potion and false otherwise
     */
    public boolean itemTest7()
    {
    	Item item0 = new Item(5);
    	if((m_type == 5)&&(m_name == "defense potion")&&(m_limit == 5)&&(m_bonusDef == 50)&&(m_bonusAtk == 0)&&(m_bonusMDef == 0)&&(m_bonusMAtk == 0)&&(m_bonusHp == 0)&&(m_value == 10)&&(m_counter == 1)&&(m_id == 5))
    	{
    		return true;
    	}
    	return false;
    }
    
    /**
     *This function returns true if the item6 is an attack potion by comparing the stats of the item
     * pre - none
     * post - none
     * @return true if the item is an attack potion and false otherwise
     */
    public boolean itemTest8()
    {
    	Item item0 = new Item(6);
    	if((m_type == 6)&&(m_name == "attack potion")&&(m_limit == 5)&&(m_bonusDef == 0)&&(m_bonusAtk == 50)&&(m_bonusMDef == 0)&&(m_bonusMAtk == 0)&&(m_bonusHp == 0)&&(m_value == 10)&&(m_counter == 1)&&(m_id == 6))
    	{
    		return true;
    	}
    	return false;
    }
    
    /**
     *This function returns true if the item7 is a basic armor by comparing the stats of the item
     * pre - none
     * post - none
     * @return true if the item is a basic armor and false otherwise
     */
    public boolean itemTest9()
    {
    	Item item0 = new Item(7);
    	if((m_type == 7)&&(m_name == "basic armor")&&(m_limit == 5)&&(m_bonusDef == 50)&&(m_bonusAtk == 0)&&(m_bonusMDef == 0)&&(m_bonusMAtk == 0)&&(m_bonusHp == 0)&&(m_value == 10)&&(m_counter == 0)&&(m_id == 7))
    	{
    		return true;
    	}
    	return false;
    }
    
    /**
     *This function returns true if the item8 is a basic helmet by comparing the stats of the item
     * pre - none
     * post - none
     * @return true if the item is a basic helmet and false otherwise
     */
    public boolean itemTest10()
    {
    	Item item0 = new Item(8);
    	if((m_type == 8)&&(m_name == "basic helmet")&&(m_limit == 5)&&(m_bonusDef == 100)&&(m_bonusAtk == 0)&&(m_bonusMDef == 0)&&(m_bonusMAtk == 0)&&(m_bonusHp == 0)&&(m_value == 10)&&(m_counter == 0)&&(m_id == 8))
    	{
    		return true;
    	}
    	return false;
    }
}
