 /**
 * Write a description of class Item here.
 *
 * @author Michael Wang
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

    private static int m_numTypesOfItem=28;

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

    	Item[] itemArray = new Item[m_numTypesOfItem];


    	for(int i=0; i<itemArray.length; i++)
    	{
    		itemArray[i]=new Item(i);
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
         m_value = 0;


         m_name = "";
         m_used = false;

         if(typeOfItem == 0)
         {
             m_type = 0;
             m_name = "rags";
             m_limit = 6;
             m_value = 0;
         }
         else if(typeOfItem == 1)
         {
             m_type = 1;
             m_name = "basic sword";
             m_limit = 1;
             m_bonusDef = 0;
             m_bonusAtk = 5;
             m_bonusHp = 0;
             m_value = 10;
         }
         else if(typeOfItem == 2)
         {
             m_type = 2;
             m_name = "basic shield";
             m_limit = 1;
             m_bonusDef = 5;
             m_bonusAtk = 0;
             m_bonusHp = 0;
             m_value = 10;
         }
         else if(typeOfItem == 3)
         {
             m_type = 3;
             m_name = "basic armor";
             m_limit = 1;
             m_bonusDef = 10;
             m_bonusAtk = 0;
             m_bonusHp = 0;
             m_value = 10;
         }
         else if(typeOfItem == 4)
         {
             m_type = 4;
             m_name = "basic helmet";
             m_limit = 1;
             m_bonusDef = 7;
             m_bonusAtk = 0;
             m_bonusHp = 0;
             m_value = 10;
         }
         else if(typeOfItem == 5)
         {
             m_type = 5;
             m_name = "basic gauntlet";
             m_limit = 1;
             m_bonusDef = 3;
             m_bonusAtk = 0;
             m_bonusHp = 0;
             m_value = 10;
         }
         else if(typeOfItem == 6)
         {
             m_type = 6;
             m_name = "basic boots";
             m_limit = 1;
             m_bonusDef = 3;
             m_bonusAtk = 0;
             m_bonusHp = 0;
             m_value = 10;
         }
         else if(typeOfItem == 7)
         {
             m_type = 7;
             m_name = "basic hPotion";
             m_limit = 5;
             m_bonusDef = 0;
             m_bonusAtk = 0;
             m_bonusHp = 50;
             m_value = 10;
         }
         else if(typeOfItem == 8)
         {
         	m_type = 1;
         	m_name = "No Sword";
         	m_bonusDef=0;
         	m_bonusAtk=0;
         	m_bonusHp=0;
         	m_value = 0;
         }
         else if(typeOfItem ==9)
         {
         	m_type = 2;
         	m_name = "No Shield";
         	m_bonusDef=0;
         	m_bonusAtk=0;
         	m_bonusHp=0;
         	m_value = 0;
         }
         else if(typeOfItem == 10)
         {
         	m_type = 3;
         	m_name = "No Armor";
         	m_bonusDef=0;
         	m_bonusAtk=0;
         	m_bonusHp=0;
         	m_value = 0;
         }
         else if(typeOfItem == 11)
         {
         	m_type = 4;
         	m_name = "No Helmet";
         	m_bonusDef=0;
         	m_bonusAtk=0;
         	m_bonusHp=0;
         	m_value = 0;
         }
         else if(typeOfItem == 12)
         {
         	m_type = 5;
         	m_name ="Bare Hands";
         	m_bonusDef=0;
         	m_bonusAtk=0;
         	m_bonusHp=0;
         	m_value = 0;
         }
         else if(typeOfItem==13)
         {
         	m_type=6;
         	m_name="Bare Feet";
         	m_bonusDef=0;
         	m_bonusAtk=0;
         	m_bonusHp=0;
         	m_value = 0;
         }
         else if(typeOfItem == 14)
         {
             m_type = 1;
             m_name = "iron sword";
             m_limit = 1;
             m_bonusDef = 0;
             m_bonusAtk = 10;
             m_bonusHp = 0;
             m_value = 50;
         }
         else if(typeOfItem == 15)
         {
             m_type = 2;
             m_name = "iron shield";
             m_limit = 1;
             m_bonusDef = 10;
             m_bonusAtk = 0;
             m_bonusHp = 0;
             m_value = 50;
         }
         else if(typeOfItem == 16)
         {
             m_type = 3;
             m_name = "iron armor";
             m_limit = 1;
             m_bonusDef = 15;
             m_bonusAtk = 0;
             m_bonusHp = 0;
             m_value = 50;
         }
         else if(typeOfItem == 17)
         {
             m_type = 4;
             m_name = "iron helmet";
             m_limit = 1;
             m_bonusDef = 10;
             m_bonusAtk = 0;
             m_bonusHp = 0;
             m_value = 50;
         }
         else if(typeOfItem == 18)
         {
             m_type = 5;
             m_name = "iron gauntlet";
             m_limit = 1;
             m_bonusDef = 5;
             m_bonusAtk = 0;
             m_bonusHp = 0;
             m_value = 50;
         }
         else if(typeOfItem == 19)
         {
             m_type = 6;
             m_name = "iron boots";
             m_limit = 1;
             m_bonusDef = 5;
             m_bonusAtk = 0;
             m_bonusHp = 0;
             m_value = 50;
         }
         else if(typeOfItem == 20)
         {
             m_type = 7;
             m_name = "advanced hPotion";
             m_limit = 5;
             m_bonusDef = 0;
             m_bonusAtk = 0;
             m_bonusHp = 100;
             m_value = 50;
         }
         else if(typeOfItem == 21)
         {
             m_type = 1;
             m_name = "steel sword";
             m_limit = 1;
             m_bonusDef = 0;
             m_bonusAtk = 20;
             m_bonusHp = 0;
             m_value = 100;
         }
         else if(typeOfItem == 22)
         {
             m_type = 2;
             m_name = "steel shield";
             m_limit = 1;
             m_bonusDef = 20;
             m_bonusAtk = 0;
             m_bonusHp = 0;
             m_value = 100;
         }
         else if(typeOfItem == 23)
         {
             m_type = 3;
             m_name = "steel armor";
             m_limit = 1;
             m_bonusDef = 20;
             m_bonusAtk = 0;
             m_bonusHp = 0;
             m_value = 100;
         }
         else if(typeOfItem == 24)
         {
             m_type = 4;
             m_name = "steel helmet";
             m_limit = 1;
             m_bonusDef = 15;
             m_bonusAtk = 0;
             m_bonusHp = 0;
             m_value = 100;
         }
         else if(typeOfItem == 25)
         {
             m_type = 5;
             m_name = "steel gauntlet";
             m_limit = 1;
             m_bonusDef = 10;
             m_bonusAtk = 0;
             m_bonusHp = 0;
             m_value = 100;
         }
         else if(typeOfItem == 26)
         {
             m_type = 6;
             m_name = "steel boots";
             m_limit = 1;
             m_bonusDef = 10;
             m_bonusAtk = 0;
             m_bonusHp = 0;
             m_value = 100;
         }
         else if(typeOfItem == 27)
         {
             m_type = 7;
             m_name = "expert hPotion";
             m_limit = 5;
             m_bonusDef = 0;
             m_bonusAtk = 0;
             m_bonusHp = 150;
             m_value = 100;
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
    
   /**
     *This function tests the item 0
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem0()
    {
        item item1 = new item(1);
        boolean testPassed = ((item0.getType() == 0)&&(item1.getName == "rags")&&(item0.getLimit() == 6)&&(item0.getValue == 0));
    	return testPassed;
    }
    
    /**
     *This function tests the item 1
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem1()
    {
		item item1 = new item(1);
        boolean testPassed = ((item1.getType() == 1)&&(item1.getName == "basic sword")&&(item1.getLimit() == 1)&&(item1.getBonusDef() == 0)&&(item1.getBonusAtk() == 5)&&(item1.getBonusHP()==0)&&(item1.getValue == 10));
    	return testPassed;
    }
    
    /**
     *This function tests the item 2
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem2()
    {
		item item2 = new item(2);
        boolean testPassed = ((item2.getType() == 2)&&(item2.getName == "basic shield")&&(item2.getLimit() == 1)&&(item2.getBonusDef() == 5)&&(item2.getBonusAtk() == 0)&&(item2.getBonusHP()==0)&&(item2.getValue == 10));
    	return testPassed;
    }
    
    /**
     *This function tests the item 3
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem3()
    {
	item item3 = new item(3);
        boolean testPassed = ((item3.getType() == 3)&&(item3.getName == "basic armor")&&(item3.getLimit() == 1)&&(item3.getBonusDef() == 10)&&(item3.getBonusAtk() == 0)&&(item3.getBonusHP()==0)&&(item3.getValue == 10));
    	return testPassed;
    }
    
    /**
     *This function tests the item 4
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem4()
    {
	item item4 = new item(4);
        boolean testPassed = ((item4.getType() == 4)&&(item4.getName == "basic helmet")&&(item4.getLimit() == 1)&&(item4.getBonusDef() == 7)&&(item4.getBonusAtk() == 0)&&(item4.getBonusHP()==0)&&(item4.getValue == 10));
    	return testPassed;
    }
    
    /**
     *This function tests the item 5
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem5()
    {
	item item5 = new item(5);
        boolean testPassed = ((item5.getType() == 5)&&(item5.getName == "basic gauntlet")&&(item5.getLimit() == 1)&&(item5.getBonusDef() == 3)&&(item5.getBonusAtk() == 0)&&(item5.getBonusHP()==0)&&(item5.getValue == 10));
    	return testPassed;
    }
    
    /**
     *This function tests the item 6
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public bool testItem6()
    {
	item item6 = new item(6);
        boolean testPassed = ((item6.getType() == 6)&&(item6.getName == "basic boots")&&(item6.getLimit() == 1)&&(item6.getBonusDef() == 3)&&(item6.getBonusAtk() == 0)&&(item6.getBonusHP()==0)&&(item6.getValue == 10));
    	return testPassed;
    }
    
    /**
     *This function tests the item 7
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem7()
    {
	item item7 = new item(7);
        boolean testPassed = ((item7.getType() == 7)&&(item7.getName == "basic hPotion")&&(item7.getLimit() == 5)&&(item7.getBonusDef() == 0)&&(item7.getBonusAtk() == 0)&&(item7.getBonusHP()==0)&&(item7.getValue == 10));
    	return testPassed;
    }
    
    /**
     *This function tests the item 8
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem8()
    {
	item item8 = new item(8);
        boolean testPassed = ((item8.getType() == 1)&&(item8.getName == "No Sword")&&(item8.getBonusDef() == 0)&&(item8.getBonusAtk() == 0)&&(item8.getBonusHP()==0)&&(item8.getValue == 0));
    	return testPassed;
    }
    
    /**
     *This function tests the item 9
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem9()
    {
	item item9 = new item(9);
        boolean testPassed = ((item9.getType() == 2)&&(item9.getName == "No Shield")&&(item9.getBonusDef() == 0)&&(item9.getBonusAtk() == 0)&&(item9.getBonusHP()==0)&&(item9.getValue == 0));
    	return testPassed;
    }
    
    /**
     *This function tests the item 10
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem10()
    {
	item item10 = new item(10);
        boolean testPassed = ((item10.getType() == 3)&&(item10.getName == "No Armor")&&(item10.getBonusDef() == 0)&&(item10.getBonusAtk() == 0)&&(item10.getBonusHP()==0)&&(item10.getValue == 0));
    	return testPassed;
    }
    
    /**
     *This function tests the item 11
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwisean
     */
    public boolean testItem11()
    {
	item item11 = new item(11);
        boolean testPassed = ((item11.getType() == 4)&&(item11.getName == "No Helmet")&&(item11.getBonusDef() == 0)&&(item11.getBonusAtk() == 0)&&(item11.getBonusHP()==0)&&(item11.getValue == 0));
    	return testPassed;
    }
    
    /**
     *This function tests the item 12
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem12()
    {
		item item12 = new item(12);
        boolean testPassed = ((item12.getType() == 5)&&(item12.getName == "Bare Hands")&&(item12.getBonusDef() == 0)&&(item12.getBonusAtk() == 0)&&(item12.getBonusHP()==0)&&(item12.getValue == 0));
    	return testPassed;
    }
    
    /**
     *This function tests the item 13
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem13()
    {
		item item13 = new item(13);
        boolean testPassed = ((item13.getType() == 6)&&(item13.getName == "Bare Feet")&&(item13.getBonusDef() == 0)&&(item13.getBonusAtk() == 0)&&(item13.getBonusHP()==0)&&(item13.getValue == 0));
    	return testPassed;
    }
    
    /**
     *This function tests the item 14
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem14()
    {
	item item14 = new item(14);
        boolean testPassed = ((item14.getType() == 1)&&(item14.getName == "iron sword")&&(item14.getLimit() == 1)&&(item14.getBonusDef() == 0)&&(item14.getBonusAtk() == 10)&&(item14.getBonusHP()==0)&&(item14.getValue == 50));
    	return testPassed;
    }
    
    /**
     *This function tests the item 15
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem15()
    {
		item item15 = new item(15);
        boolean testPassed = ((item15.getType() == 2)&&(item15.getName == "iron shield")&&(item15.getLimit() == 1)&&(item15.getBonusDef() == 10)&&(item15.getBonusAtk() == 0)&&(item15.getBonusHP()==0)&&(item15.getValue == 50));
    	return testPassed;
    }
    
    /**
     *This function tests the item 16
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem16()
    {
		item item16 = new item(16);
        boolean testPassed = ((item16.getType() == 3)&&(item16.getName == "iron armor")&&(item16.getLimit() == 1)&&(item16.getBonusDef() == 15)&&(item16.getBonusAtk() == 0)&&(item16.getBonusHP()==0)&&(item16.getValue == 50));
    	return testPassed;
    }
    
    /**
     *This function tests the item 17
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem17()
    {
		item item17 = new item(17);
        boolean testPassed = ((item17.getType() == 4)&&(item17.getName == "iron helmet")&&(item17.getLimit() == 1)&&(item17.getBonusDef() == 10)&&(item17.getBonusAtk() == 0)&&(item17.getBonusHP()==0)&&(item17.getValue == 50));
    	return testPassed;
    }
    
    /**
     *This function tests the item 18
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem18()
    {	
		item item18 = new item(18);
        boolean testPassed = ((item18.getType() == 5)&&(item18.getName == "iron gauntlet")&&(item18.getLimit() == 1)&&(item18.getBonusDef() == 5)&&(item18.getBonusAtk() == 0)&&(item18.getBonusHP()==0)&&(item18.getValue == 50));
    	return testPassed;
    }
    
    /**
     *This function tests the item 19
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem19()
    {
			item item19 = new item(19);
        boolean testPassed = ((item19.getType() == 6)&&(item19.getName == "iron boots")&&(item19.getLimit() == 1)&&(item19.getBonusDef() == 5)&&(item19.getBonusAtk() == 0)&&(item19.getBonusHP()==0)&&(item19.getValue == 50));
    	return testPassed;
    }
    
    /**
     *This function tests the item 20
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem20()
    {
    	item item20 = new item(20);
        boolean testPassed = ((item20.getType() == 7)&&(item20.getName == "advanced hPotion")&&(item20.getLimit() == 5)&&(item20.getBonusDef() == 0)&&(item20.getBonusAtk() == 0)&&(item20.getBonusHP()==100)&&(item20.getValue == 50));
		return testPassed;
    }
    
    /**
     *This function tests the item 21
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem21()
    {
	item item21 = new item(21);
        boolean testPassed = ((item21.getType() == 1)&&(item12.getName == "steel sword")&&(item21.getLimit() == 1)&&(item21.getBonusDef() == 0)&&(item21.getBonusAtk() == 20)&&(item21.getBonusHP()==0)&&(item21.getValue == 100));
    	return testPassed;
    }
    
    /**
     *This function tests the item 22
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem22()
    {
	item item22 = new item(22);
        boolean testPassed = ((item22.getType() == 2)&&(item22.getName == "steel shield")&&(item22.getLimit() == 1)&&(item22.getBonusDef() == 20)&&(item22.getBonusAtk() == 0)&&(item22.getBonusHP()==0)&&(item22.getValue == 100));
    	return testPassed;
    }
    
    /**
     *This function tests the item 23
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem23()
    {
	item item23 = new item(23);
        boolean testPassed = ((item23.getType() == 3)&&(item23.getName == "steel armor")&&(item23.getLimit() == 1)&&(item23.getBonusDef() == 0)&&(item23.getBonusAtk() == 0)&&(item23.getBonusHP()==0)&&(item23.getValue == 100));
    	return testPassed;
    }
    
    /**
     *This function tests the item 24
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem24()
    {
	item item24 = new item(24);
        boolean testPassed = ((item24.getType() == 4)&&(item24.getName == "steel helmet")&&(item24.getLimit() == 1)&&(item24.getBonusDef() == 15)&&(item24.getBonusAtk() == 0)&&(item24.getBonusHP()==0)&&(item24.getValue == 100));
    	return testPassed;
    }
    
    /**
     *This function tests the item 25
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem25()
    {
	item item25 = new item(25);
        boolean testPassed = ((item25.getType() == 5)&&(item25.getName == "steel gauntlet")&&(item25.getLimit() == 1)&&(item25.getBonusDef() == 10)&&(item25.getBonusAtk() == 0)&&(item25.getBonusHP()==0)&&(item25.getValue == 100));
    	return testPassed;
    }
    
    /**
     *This function tests the item 26
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem26()
    {
	item item26 = new item(26);
        boolean testPassed = ((item26.getType() == 6)&&(item26.getName == "steel boots")&&(item26.getLimit() == 1)&&(item26.getBonusDef() == 10)&&(item26.getBonusAtk() == 0)&&(item26.getBonusHP()==0)&&(item26.getValue == 100));
    	return testPassed;
    }
	
	/**
     *This function tests the item 27
     * pre - none
     * post - none
     * @return boolean that is true if the test is passed and false otherwise
     */
    public boolean testItem27()
    {
	item item27 = new item(27);
        boolean testPassed = ((item27.getType() == 7)&&(item27.getName == "expert hPotion")&&(item27.getLimit() == 1)&&(item27.getBonusDef() == 0)&&(item27.getBonusAtk() == 0)&&(item27.getBonusHP()==150)&&(item27.getValue == 100));
    	return testPassed;
    }
}

