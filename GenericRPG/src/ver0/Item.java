package ver0;

/**
 * This is a class for the items in the game.
 *
 * @author Michael Wang
 * Created by Michael on 3/26/2016.
 */

import java.Actor.java;

public class Item{
	import java.Actor.java;
    private int m_type;
    private int m_limit;
    private int m_id;
    private int m_bonusDef;
    private int m_bonusAtk;
    private int m_bonusHp;
    
    private String m_name;
    private boolean m_used;
    
    private const m_numTypesOfItem = 0;

    /**
     * This function is the constructor for the different items
     * pre - needs the parameters down below
     * post - creates a item
     * Returns - an item based off of the integer given.
     * @param typeOfItem takes in an int in order to create the weapon
     */
    public Item(int typeOfItem)
    {
        m_limit = 0;
        m_id = 0;
        m_bonusDef = 0;
        m_bonusAtk = 0;
        m_bonusHp = 0;
        
        const m_numTypesOfItem = 0;
        
        m_name = "";
        m_used = false;
        
        if(typeOfItem == 0)
        {
            m_type = 0;
            m_name = "rags";
            m_limit = 6;
        }
        else if(typeOfItem == 1)
        {
            m_type = 1;
            m_name = "sword";
            m_limit = 1;
            m_bonusDef = 0;
            m_bonusAtk = 5;
            m_bonusHp = 0;
        }
        else if(typeOfItem == 2)
        {
            m_type = 2;
            m_name = "shield";
            m_limit = 1;
            m_bonusDef = 5;
            m_bonusAtk = 0;
            m_bonusHp = 0;
        }
        else if(typeOfItem == 3)
        {
            m_type = 3;
            m_name = "armor";
            m_limit = 1;
            m_bonusDef = 10;
            m_bonusAtk = 0;
            m_bonusHp = 0;
        }
        else if(typeOfItem == 4)
        {
            m_type = 4;
            m_name = "helmet";
            m_limit = 1;
            m_bonusDef = 7;
            m_bonusAtk = 0;
            m_bonusHp = 0;
        }
        else if(typeOfItem == 5)
        {
            m_type = 5;
            m_name = "gauntlet";
            m_limit = 1;
            m_bonusDef = 3;
            m_bonusAtk = 0;
            m_bonusHp = 0;
        }
        else if(typeOfItem == 6)
        {
            m_type = 6;
            m_name = "boots";
            m_limit = 1;
            m_bonusDef = 3;
            m_bonusAtk = 0;
            m_bonusHp = 0;
        }
        else if(typeOfItem == 7)
        {
            m_type = 7;
            m_name = "hPotion";
            m_limit = 5;
            m_bonusDef = 0;
            m_bonusAtk = 0;
            m_bonusHp = 50;
        }
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
     * This function returns the value of m_type
     * pre - none
     * post - none
     * @return m_limit
     */
    public int getLimit()
    {
        return m_limit;
    }
    
    /**
     * This function returns the value of m_type
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
     *This function returns the value of m_used
     * pre - none
     * post - none
     * @return m_bonusDef
     */
    public int getBonusDef()
    {
    	return m_bonusDef;
    }

    /**
     *This function returns the value of m_used
     * pre - none
     * post - none
     * @return m_bonusAtk
     */
    public int getBonusAtk()
    {
    	return m_bonusDef;
    }
    
    /**
     *This function returns the value of m_used
     * pre - none
     * post - none
     * @return m_bonusHp
     */
    public int getBonusHp()
    {
    	return m_bonusHp;
    }

    /**
     *This function returns the value of m_used
     * pre - none
     * post - none
     * @return m_bonusHp
     */
    public int getNumTypesOfItem()
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
}

