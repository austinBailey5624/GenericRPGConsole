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
    /**
     * This function creates a playerActor and sets its member variables to their most basic sets
     * @precondition - 	None
     * @post - 			Creates an instance of PlayerActor with default values
     * @return 			An instance of PlayerActor
     */
	public PlayerActor()
	{
		this.setLevel(1);
		m_exp=0;
		m_inventory=new int[Item.getNumTypesOfItem()];
		for(int i=0; i<Item.getNumTypesOfItem();i++)
		{
			m_inventory[i]=0;
		}
		equipSword(itemSet[8]);
		equipShield(itemSet[9]);
		equipArmor(itemSet[10]);
		equipHelmet(itemSet[11]);
		equipBoots(itemSet[13]);
		equipGauntlets(itemSet[12]);
	}
	
    /**
     * This function returns the value of m_exp
     * @precondition - 	PlayerActor Object exists
     * @post - 			none
     * @return 			m_ext
     */
	public int getExp()
	{
		return m_exp;
	}
	
    /**
     * This function sets the value of m_exp
     * @precondition - 	PlayerActor Object exists
     * @post - 			sets m_exp to parameter int exp
     * @return 	-		void
     */
	public void setExp(int exp)
	{
		m_exp=exp;
	}
	
    /**
     * This function returns the value of m_gold
     * @precondition -	PlayerActor Object exists
     * @post - 			none
     * @return 			m_gold
     */
	public int getGold()
	{
		return m_gold;
	}
	
    /**
     * This function sets the value of m_gold
     * @precondition - 	PlayerActor Object exists
     * @post - 			sets m_gold to parameter int gold
     * @return 	-		void
     */
	public void setGold(int gold)
	{
		m_gold=gold;
	}
	
	/**
	 * This function adds the value in the parameter to the variable m_gold
	 * @precondition - 	PlayerActor Object exists
	 * @post - 			sets m_gold to itself plus parameter gold
	 * @return - 		void
	 */
	public void addGold(int gold)
	{
		m_gold=m_gold+gold;
	}
	
	/**
	 * This function attempts to buy an item from the items given index
	 * @precondition - 	PlayerActor Object existsw with initialized m_inventory
	 * @post - 			If buy is successful, adds one to the index of the inventory that stands for that item, else returns false
	 * @return - 		true if buy is successful, false else
	 */
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
	
	/**
	 * This function checks to see if an actor can buy an item
	 * @precondition - 	PlayerActor Object exists
	 * @post - 			none //TODO make const on next implementation
	 * @return - 		true if the item can be bought, false else
	 */
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
	
	/**
	 * This function attempts to buy a number of items
	 * @precondition - 	PlayerActor Object existsw with initialized m_inventory
	 * @post - 			If buy is successful, adds parameter int quantity to the index of the inventory that stands for that item, else returns false
	 * @return - 		true if buy is successful, false else
	 */
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
	
	/**
	 * This function checks to see if an actor can buy multiple of an item
	 * @precondition - 	PlayerActor Object exists
	 * @post - 			none //TODO make const on next implementation
	 * @return - 		true if the item can be bought, false else
	 */
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
	
	/**
	 * This function returns m_inventory
	 * @precondition- 	PlayerActor Object exists
	 * @post - 			none //TODO make const
	 * @return - 		m_inventory
	 */
	public int[] getInventory()
	{
		return m_inventory;
	}
	
	/**
	 * This function checks to see if an actor can buy an item
	 * @precondition - 	PlayerActor Object exists
	 * @post - 			none //TODO make const on next implementation
	 * @return - 		true if the item can be bought, false else
	 */
	public void setInventory(int[] inventory)
	{
		m_inventory=inventory;
	}
	
	//Methods
	/**
	 * This function adds exp to a playerCharacter after an enemy is defeated
	 * @precondiion - 	PlayerActor Object exists
	 * @post - 			adds to m_exp and checks if the character should level up
	 * @return - 		void
	 */
	public void addExp(int addedExp)
	{
		m_exp+=addedExp;
		while(m_exp>100*this.getLevel())
		{
			levelUp(m_exp-100*this.getLevel());
		}
	}
	
	/**
	 * This function is responsible for levelling up the PlayerCharacter
	 * @precondition - 	PlayerActor Object exists
	 * @post - 			increments member variables to progress character
	 * @return - 		void
	 */
	public void levelUp(int exp)
	{
		m_exp-=100*this.getLevel();
		setLevel(getLevel()+1);
		setMaxHp(getMaxHp()+10);
		setAtk(getAtk()+1);
		setDef(getDef()+1);
		//TODO implement choice for additional level up reward
	}
	
	/**
	 * This function handles the menu the user interacts with when the option is selected while the person is in world
	 * @precondition - 	PlayerActor Object exists
	 * @post - 			none //TODO make const
	 * @return - 		void
	 */
	public void menu()
	{
		System.out.println("1) Access Inventory\n2) Character Status\n3) View Skills\n4) exit");//TODO add character screen so user can see current attributes
		select=myScanner.nextInt();
		if(select==1)
		{
			accessInventory();
		}
		else if(select==2)
		{
			viewCharacterStatus();
		}
		else if(select==4)
		{
			return;
		}
		else
		{
			System.out.println("Sorry, we didn't understand your input");
		}
	}
	
	/**
	 * This function handles the user accessing the playerCharacters inventory
	 * @precondition - 	PlayerActor Object exists
	 * @post - 			none //TODO make const
	 * @return - 		void
	 */
	public void accessInventory()
	{
		Item[] items = Item.getAllItems();
		System.out.println("Here's the stuff in your inventory");
		boolean quit=false;
		while(!quit)
		{
			System.out.println("Equipped Sword:  " + this.getEquippedSword().getName());
			System.out.println("Equipped Shield: " + this.getEquippedShield().getName());
			System.out.println("Equipped Armor: " + this.getEquippedArmor().getName());
			System.out.println("Equipped Helmet: " +  this.getEquippedHelmet().getName());
			System.out.println("Equipped Gauntlets: " + this.getEquippedGauntlets().getName());
			System.out.println("Equipped Boots: "+ this.getEquippedBoots().getName());
			System.out.println("1) Equip a Sword");
			System.out.println("2) Equip a Shield");
			System.out.println("3) Equip Armor");
			System.out.println("4) Equip Helmet");
			System.out.println("5) Equip Gauntlets");
			System.out.println("6) Equip Boots");
			System.out.println("7) Look at inventory");
			System.out.println("8) Return");
			select=myScanner.nextInt();
			if(select>=0&&select<7)
			{
				equipMenu(select);
			}
			else if(select==7)
			{
				displayInventory();
			}
			else if(select==8)
			{
				return;
			}
		}
	}
	
	/**
	 * This function displays the inventory
	 * @precondition - 	PlayerActor Object exists
	 * @post -			none //TODO make const
	 * @return - 		void			
	 */
	public void displayInventory()
	{
		for(int i=0; i<itemSet.length;i++)
		{
			System.out.println("You have " + getInventory()[i] +" " + itemSet[i].getName() + " In your inventory");
		}
	}
	
	/**
	 * This function allows for the equipping of items in the invetory
	 * @precondition - 	PlayerActor Object exists
	 * @post - 			equips items if appropriate
	 * @return - 		void
	 */
	public void equipMenu(int type)//TODO finish/test equip method
	{
		Item[] items = Item.getAllItems();
		if(type==1)
		{
			System.out.println("Which Sword do you want to equip?");
		}
		else if(type==2)
		{
			System.out.println("Which Shield do you want to equip?");
		}
		else if(type==3)
		{
			System.out.println("Which Armor set do you want to equip?");
		}
		else if(type==4)
		{
			System.out.println("Which Helmet do you want to equip?");
		}
		else if(type==5)
		{
			System.out.println("Which Gauntlets do you want to equip?");
		}
		else if(type==6)
		{
			System.out.println("Which Boots do you want to equip?");
		}
		
		//initializes array to hold choices
		int[] indexRepresentedByChoice= new int[itemSet.length];
		for(int i=0;i<itemSet.length;i++)
		{
			indexRepresentedByChoice[i]=-1;//the value -1 represents not having that as a possible choice
		}
		int choices=0;
		for(int i=0; i<items.length;i++)
		{
			if(m_inventory[i]>0&&items[i].getType()==type)
			{
				System.out.println((choices+1) + ") " + items[i].getName() + " Attack Bonus: "+ items[i].getBonusAtk() + " Defense bonus: " + items[i].getBonusDef());
				indexRepresentedByChoice[choices+1]=i;
				choices++;
			}
		}
		System.out.println((choices+1) + ") Leave");
		
		//get input from user
		select=myScanner.nextInt();
		System.out.println("choices = " + choices);//debugging
		
		//make decision based on input
		if(select<1||select>choices)
		{
			System.out.println("Sorry, we didn't understand your input");
		}
		else if((select>1)&&(select<(choices+1)))
		{
			if(type==1)
			{
				this.equipSword(items[indexRepresentedByChoice[select]]);
				System.out.println("Equipped Sword successfully"); //debugging
			}
			else if(type==2)
			{
				this.equipShield(items[indexRepresentedByChoice[select]]);
			}
			else if(type==3)
			{
				this.equipArmor(items[indexRepresentedByChoice[select]]);
			}
			else if(type==4)
			{
				this.equipHelmet(items[indexRepresentedByChoice[select]]);
			}
			else if(type==5)
			{
				this.equipGauntlets(items[indexRepresentedByChoice[select]]);
			}
			else if(type==6)
			{
				this.equipBoots(items[indexRepresentedByChoice[select]]);
			}
		}
		else if(select==(choices+1))
		{
			return;
		}
		else
		{
			System.out.println("Sorry, we did not understand you input, please try again");
		}
	}
	
	/**
	 * This function displays relevant information about the character
	 * @precondition - 	PlayerActor Object exists
	 * @post - 			Does not change member variables//TODO make const
	 * @return - 		void 
	 */
	public void viewCharacterStatus()
	{
		System.out.println("Current Level:      " + this.getLevel());
		System.out.println("Current Experience: " + this.getExp());
		System.out.println("Exp to next Level:  " + (this.getLevel()*100-this.getExp()));
		System.out.println("Maximum Health:     " + getMaxHp());
		System.out.println("Current Health:     " + getCurHp());
		System.out.println("Equipped Sword:     " + this.getEquippedSword().getName() + " bonus Attack: " + this.getEquippedSword().getBonusAtk() + " bonus Defense: " + this.getEquippedSword().getBonusDef());
		System.out.println("Equipped Shield:    " + this.getEquippedShield().getName() + " bonus Atack: " + this.getEquippedShield().getBonusAtk() + " bonus Defense: " + this.getEquippedShield().getBonusDef());
		System.out.println("Equipped Armor:     " + this.getEquippedArmor().getName() + " bonus Attack: " + this.getEquippedArmor().getBonusAtk() + " bonus Defense: " + this.getEquippedArmor().getBonusDef());
		System.out.println("Equipped Helmet:    " +  this.getEquippedHelmet().getName() + " bonus Attack: " + this.getEquippedHelmet().getBonusAtk() + " bonus Defense: " +  this.getEquippedHelmet().getBonusDef());
		System.out.println("Equipped Gauntlets: " + this.getEquippedGauntlets().getName() + " bonus Atack: " + this.getEquippedGauntlets().getBonusAtk()+ " bonus Defense: " +this.getEquippedGauntlets().getBonusDef());		
		System.out.println("Equipped Boots:     " + this.getEquippedBoots().getName() + " bonus Attack " + this.getEquippedBoots().getBonusAtk() + " bonus Defense: " + this.getEquippedBoots().getBonusDef());
		System.out.println("Natural Attack:     " + this.getAtk());
		System.out.println("Bonus Attack:       " + (this.getEquippedSword().getBonusAtk()+this.getEquippedShield().getBonusAtk()+this.getEquippedArmor().getBonusAtk()+this.getEquippedHelmet().getBonusAtk()+this.getEquippedGauntlets().getBonusAtk()+this.getEquippedBoots().getBonusAtk()));
		System.out.println("Effective Attack:   " + this.getAttackFighter());
		System.out.println("Natural Defese:     " + this.getDef());
		System.out.println("Bonus Defense:      " + (this.getEquippedSword().getBonusDef()+this.getEquippedShield().getBonusDef()+this.getEquippedArmor().getBonusDef()+this.getEquippedHelmet().getBonusDef()+this.getEquippedGauntlets().getBonusDef()+this.getEquippedBoots().getBonusDef()));
		System.out.println("Effective Defense:  " + this.getDefenseFighter());
	}
}

