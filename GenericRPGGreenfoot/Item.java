/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item  
{
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
    
    private static int m_numTypesOfItem=7;
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
    	for(int i=m_numTypesOfItem; i<m_numTypesOfItem + m_numTypesOfWeapon; i++)//Hey, I thought this would ease the process for adding new items, should do it automatically
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
        	m_type = typeOfItem;
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
            m_type = typeOfItem;
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
            m_type = typeOfItem;
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
            m_type = typeOfItem;
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
            m_type = typeOfItem;
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
            m_type = typeOfItem;
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
            m_type = typeOfItem;
            m_name = "attack potion";
            m_limit = 5;
            m_bonusDef = 50;
            m_bonusAtk = 0;
            m_bonusMDef = 0;
            m_bonusMAtk = 0;
            m_bonusHp = 0;
            m_value = 10;
            m_counter = 1;
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
     *This function returns the value of m_value
     * pre - none
     * post - none
     * @return m_value
     */
    public int getValue()
    {
    	return m_value;
    }
}
