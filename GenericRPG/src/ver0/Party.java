package ver0;
import java.util.Scanner;
public class Party 
{
	//TODO: make buildings static members? I mean if were going to pass around a party it should carry everything right?
	//TODO: make quests static member variables as well
	protected PlayerActor[] m_content;
	private int m_gold;
	private int[] m_inventory;
	static int select;
	static Scanner myScanner = new Scanner(System.in);
	//constructor
	public Party()
	{
		m_content = new PlayerActor[4];
		m_content[0]=new PlayerActor();
		m_content[1]=null;
		m_content[2]=null;
		m_content[3]=null;
		m_gold=100;
		m_inventory = new int[Item.getAllItems().length];
		for(int i=0; i<m_inventory.length;i++)
		{
			m_inventory[i]=0;
		}
	}

	public boolean onlyOne()
	{
		return((m_content[1]==null)&&(m_content[2]==null)&&(m_content[3]==null));
	}
	public PlayerActor chooseActor()
	{
		if(onlyOne())
		{
			return m_content[0];
		}
		int choice;
		int[] indexRepresentingChoice;
		while(true)
		{
			choice=1;
			indexRepresentingChoice=new int[4];
			for(int i=0; i<4;i++)
			{
				if(m_content[i]!=null)
				{
					System.out.println(choice + ") " + m_content[i].getName());
					indexRepresentingChoice[choice]=i;
					choice++;
				}
			}
			select=myScanner.nextInt();
			if(select>0&&select<choice-1)
			{
				return m_content[indexRepresentingChoice[select]];
			}
			else
			{
				System.out.println("Sorry, incorrect input");
			}
		}
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
	
//menu methods	
	public void equipMenu(int type, PlayerActor selected)
	{
		Item[] items = Item.getAllItems();
		
		if(type==1)
		{
			System.out.println("Currently have: " + selected.getEquippedSword().getName() +" Equipped, with Attack Bonus: " + selected.getEquippedSword().getBonusAtk() + " And Defense Bonus: " + selected.getEquippedSword().getBonusDef());
			System.out.println("Which Sword do you want to equip?");
		}
		else if(type==2)
		{
			System.out.println("Currently have: " + selected.getEquippedShield().getName() +" Equipped, with Attack Bonus: " + selected.getEquippedShield().getBonusAtk() + " And Defense Bonus: " + selected.getEquippedShield().getBonusDef());
			System.out.println("Which Shield do you want to equip?");
		}
		else if(type==3)
		{
			System.out.println("Currently have: " + selected.getEquippedArmor().getName() + " Equipped, with Attack Bonus: " + selected.getEquippedArmor().getBonusAtk() + " And Defense Bonus: " + selected.getEquippedArmor().getBonusDef());
			System.out.println("Which Armor set do you want to equip?");
		}
		else if(type==4)
		{
			System.out.println("Currently have: " + selected.getEquippedHelmet().getName() + " Equipped, with Attack Bonus: " + selected.getEquippedHelmet().getBonusAtk() + " And Defense Bonus: " + selected.getEquippedHelmet().getBonusDef());
			System.out.println("Which Helmet do you want to equip?");
		}
//		else if(type==5)
//		{
//			System.out.println("Currently have: " + selected.getEquippedGauntlets().getName() + " Equipped, with Attack Bonus: " + selected.getEquippedGauntlets().getBonusAtk() + " And Defense Bonus: " + selected.getEquippedGauntlets().getBonusDef());
//			System.out.println("Which Gauntlets do you want to equip?");
//		}
//		else if(type==6)
//		{
//			System.out.println("Currently have: " + selected.getEquippedBoots().getName() + " Equipped, with Attack Bonus: " + selected.getEquippedBoots().getBonusAtk() + " And Defense Bonus: " + selected.getEquippedBoots().getBonusDef());
//			System.out.println("Which Boots do you want to equip?");
//		}
		
		int[] indexRepresentedByChoice= new int[items.length];
		for(int i=0;i<items.length;i++)
		{
			indexRepresentedByChoice[i]=-1;
		}
		
		
		int choices=1;
		for(int i=1; i<items.length;i++)
		{
			if(m_inventory[i]>0&&items[i].getType()==type)
			{
				System.out.println((choices) + ") " + items[i].getName() + " Attack Bonus: "+ items[i].getBonusAtk() + " Defense bonus: " + items[i].getBonusDef());
				indexRepresentedByChoice[choices]=i;
				choices++;
			}
		}
		System.out.println((choices) + ") Leave");
		
		boolean inputVerified=false;
		while(!inputVerified)
		{
			String in=myScanner.next();
		
		
			if(verifyInt(in))
			{
				select=Integer.parseInt(in);
				inputVerified=true;
			}
			else
			{
				System.out.println("You gave invalid input! please try again\n");
			}
		}
		if(select<1||select>choices)
		{
			System.out.println("Sorry, we didn't understand your input");
		}
		else if((select>=1)&&(select<(choices)))
		{
			if(type==1)
			{
				if(m_inventory[indexRepresentedByChoice[select]]<1)
				{
					System.out.println("You dont have a " + items[indexRepresentedByChoice[select]]+ " to equip!");
				}
				else
				{
					if(selected.getEquippedSword().getId()!=8)
					{
						m_inventory[selected.getEquippedSword().getId()]++;
					}
					selected.equipSword(items[indexRepresentedByChoice[select]]);
					m_inventory[indexRepresentedByChoice[select]]--;
				}
			}
			else if(type==2)
			{
				if(m_inventory[indexRepresentedByChoice[select]]<1)
				{
					System.out.println("You dont have a " + items[indexRepresentedByChoice[select]]+ " to equip!");
				}
				else
				{
					if(selected.getEquippedShield().getId()!=9)
					{
						m_inventory[selected.getEquippedShield().getId()]++;
					}
					selected.equipShield(items[indexRepresentedByChoice[select]]);
					m_inventory[indexRepresentedByChoice[select]]--;
				}
			}
			else if(type==3)
			{
				if(m_inventory[indexRepresentedByChoice[select]]<1)
				{
					System.out.println("You dont have a " + items[indexRepresentedByChoice[select]]+ " to equip!");
				}
				else
				{
					if(selected.getEquippedArmor().getId()!=10)
					{
						m_inventory[selected.getEquippedArmor().getId()]++;
					}
					selected.equipArmor(items[indexRepresentedByChoice[select]]);
					m_inventory[indexRepresentedByChoice[select]]--;
				}
			}
			else if(type==4)
			{
				if(m_inventory[indexRepresentedByChoice[select]]<1)
				{
					System.out.println("You dont have a " + items[indexRepresentedByChoice[select]]+ " to equip!");
				}
				else
				{
					if(selected.getEquippedHelmet().getId()!=11)
					{
						m_inventory[selected.getEquippedHelmet().getId()]++;
					}
					selected.equipHelmet(items[indexRepresentedByChoice[select]]);
					m_inventory[indexRepresentedByChoice[select]]--;
				}
			}
//			else if(type==5)
//			{
//				if(m_inventory[indexRepresentedByChoice[select]]<1)
//				{
//					System.out.println("You dont have a " + items[indexRepresentedByChoice[select]]+ " to equip!");
//				}
//				else
//				{
//					if(selected.getEquippedGauntlets().getId()!=12)
//					{
//						m_inventory[selected.getEquippedGauntlets().getId()]++;
//					}
//					selected.equipGauntlets(items[indexRepresentedByChoice[select]]);
//					m_inventory[indexRepresentedByChoice[select]]--;
//				}
//			}
//			else if(type==6)
//			{
//				if(m_inventory[indexRepresentedByChoice[select]]<1)
//				{
//					System.out.println("You dont have a " + items[indexRepresentedByChoice[select]]+ " to equip!");
//				}
//				else
//				{
//					if(selected.getEquippedBoots().getId()!=13)
//					{
//						m_inventory[selected.getEquippedBoots().getId()]++;
//					}
//					selected.equipBoots(items[indexRepresentedByChoice[select]]);
//					m_inventory[indexRepresentedByChoice[select]]--;
//				}
//			}
		}
		else if(select==(choices))
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
	 * @post - 			Does not change member variables
	 * @return - 		void 
	 */
	public void viewCharacterStatus(PlayerActor selected)
	{
		System.out.println("Name:               " + selected.getName());
		System.out.println("Current Level:      " + selected.getLevel());
		System.out.println("Current Experience: " + selected.getExp());
		System.out.println("Exp to next Level:  " + (selected.getLevel()*100-selected.getExp()));
		System.out.println("Maximum Health:     " + selected.getMaxHp());
		System.out.println("Current Health:     " + selected.getCurHp());//TODO: make output uniform
		System.out.println("Equipped Sword:     " + selected.getEquippedSword().getName() + " bonus Attack: " + selected.getEquippedSword().getBonusAtk() + " bonus Defense: " + selected.getEquippedSword().getBonusDef());
		System.out.println("Equipped Shield:    " + selected.getEquippedShield().getName() + " bonus Atack: " + selected.getEquippedShield().getBonusAtk() + " bonus Defense: " + selected.getEquippedShield().getBonusDef());
		System.out.println("Equipped Armor:     " + selected.getEquippedArmor().getName() + " bonus Attack: " + selected.getEquippedArmor().getBonusAtk() + " bonus Defense: " + selected.getEquippedArmor().getBonusDef());
		System.out.println("Equipped Helmet:    " + selected.getEquippedHelmet().getName() + " bonus Attack: " + selected.getEquippedHelmet().getBonusAtk() + " bonus Defense: " +  selected.getEquippedHelmet().getBonusDef());
//		System.out.println("Equipped Gauntlets: " + selected.getEquippedGauntlets().getName() + " bonus Atack: " + selected.getEquippedGauntlets().getBonusAtk()+ " bonus Defense: " +selected.getEquippedGauntlets().getBonusDef());		
//		System.out.println("Equipped Boots:     " + selected.getEquippedBoots().getName() + " bonus Attack " + selected.getEquippedBoots().getBonusAtk() + " bonus Defense: " + selected.getEquippedBoots().getBonusDef());
		System.out.println("Natural Attack:     " + selected.getAtk());
//		System.out.println("Bonus Attack:       " + (selected.getEquippedSword().getBonusAtk()+selected.getEquippedShield().getBonusAtk()+selected.getEquippedArmor().getBonusAtk()+selected.getEquippedHelmet().getBonusAtk()+selected.getEquippedGauntlets().getBonusAtk()+selected.getEquippedBoots().getBonusAtk()));
		System.out.println("Effective Attack:   " + selected.getAttackFighter());
		System.out.println("Natural Defese:     " + selected.getDef());
//		System.out.println("Bonus Defense:      " + (selected.getEquippedSword().getBonusDef()+selected.getEquippedShield().getBonusDef()+selected.getEquippedArmor().getBonusDef()+selected.getEquippedHelmet().getBonusDef()+selected.getEquippedGauntlets().getBonusDef()+selected.getEquippedBoots().getBonusDef()));
		System.out.println("Effective Defense:  " + selected.getDefenseFighter());
	}

	/**
	 * This function displays what skills the user has learned
	 * @precondition - 	PlayerActor Object Exists
	 * @post - 			Does not change member variables
	 * @return - 		void
	 */
	public void viewCharacterSkills(PlayerActor selected)
	{
		Skill[] skillSet = Skill.getSkills();
		for(int i=0; i<Skill.getNumOfSkillsTotal(); i++)
		{
			//TODO: only show known skills
			System.out.print(skillSet[i].getName());
			for(int j=0; j<(20-skillSet[i].getName().length());j++)
			{
				System.out.print(" ");
			}
			if(selected.m_skillSet[i])
			{
				System.out.print(" LEARNED - ");
			}
			else
			{
				System.out.print(" UNKNOWN - ");
			}
			System.out.println(skillSet[i].getDescription());
		}
	}
	/**
	 * This function handles the menu the user interacts with when the option is selected while the person is in world
	 * @precondition - 	PlayerActor Object exists
	 * @post - 			none 
	 * @return - 		void
	 */
	public void menu()
	{
		boolean exit=false;
		while(!exit)
		{
			System.out.println("1) Access Inventory\n2) Character Status\n3) View Skills\n4) exit");
			String in=myScanner.next();
			if(verifyInt(in))
			{
				select=Integer.parseInt(in);
			}
			if(select==1)
			{
				System.out.println("Which Character's inventory would you like to view?");
				accessInventory(chooseActor());
			}
			else if(select==2)
			{
				System.out.println("Which Character's status do you want to view?");
				viewCharacterStatus(chooseActor());
			}
			else if(select==3)
			{
				viewCharacterSkills(chooseActor());
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
	}
	
	/**
	 * This function handles the user accessing the playerCharacters inventory
	 * @precondition - 	PlayerActor Object exists
	 * @post - 			none 
	 * @return - 		void
	 */
	public void accessInventory(PlayerActor selected)//TODO implement unequip methods
	{
		Item[] items = Item.getAllItems();
		System.out.println("Here's the stuff in your inventory");
		boolean quit=false;
		while(!quit)
		{
			if(selected.getEquippedSword() != null)
			{
				System.out.println("Equipped Sword:  " + selected.getEquippedSword().getName());
			}
			else
			{
				System.out.println("Equipped Sword:  no sword");
			}
			if(selected.getEquippedShield() != null)
			{
				System.out.println("Equipped Shield: " + selected.getEquippedShield().getName());
			}
			else
			{
				System.out.println("Equipped Shield: no shield");
			}
			if(selected.getEquippedArmor() != null)
			{
				System.out.println("Equipped Armor: " + selected.getEquippedArmor().getName());
			}
			else
			{
				System.out.println("Equipped Armor: no armor");
			}
			if(selected.getEquippedHelmet() != null)
			{
				System.out.println("Equipped Helmet: " +  selected.getEquippedHelmet().getName());
			}
			else
			{
				System.out.println("Equipped Helmet: no helmet");
			}
			
			
//			System.out.println("Equipped Gauntlets: " + selected.getEquippedGauntlets().getName());
//			System.out.println("Equipped Boots: "+ selected.getEquippedBoots().getName());
			System.out.println("1) Equip a Sword");
			System.out.println("2) Equip a Shield");
			System.out.println("3) Equip Armor");
			System.out.println("4) Equip Helmet");
//			System.out.println("5) Equip Gauntlets");
//			System.out.println("6) Equip Boots");
			System.out.println("5) Look at inventory");
			System.out.println("6) Return");
			String in=myScanner.next();
			if(verifyInt(in))
			{
				select=Integer.parseInt(in);
			}
			else
			{
				//System.out.println("You gave invalid input! please try again\n");
				select=7;
			}
			if(select>=0&&select<4)
			{
				equipMenu(select,selected);
			}
			else if(select==5)
			{
				displayInventory();
			}
			else if(select==6)
			{
				return;
			}
			else
			{
				System.out.println("Sorry, we didn't understand your input");
			}
		}
	}
	
	/**
	 * This function attempts to buy an item from the items given index
	 * @precondition - 	PlayerActor Object existsw with initialized m_inventory
	 * @post - 			If buy is successful, adds one to the index of the inventory that stands for that item, else returns false
	 * @return - 		true if buy is successful, false else
	 */
	public boolean buyItem(int index)//return true if buy is possible
	{
		Item[] itemSet=Item.getAllItems();
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
	 * @post - 			none 
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
		Item[] itemSet=Item.getAllItems();
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
	 * @post - 			none 
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
	 * This function displays the inventory
	 * @precondition - 	PlayerActor Object exists
	 * @post -			none /
	 * @return - 		void			
	 */
	public void displayInventory()
	{
		Item[] itemSet = Item.getAllItems();
		boolean isEmpty=true;
		for(int i=0; i<itemSet.length;i++)
		{
			if(this.getInventory()[i]>0)
			{
				System.out.println("You have " + getInventory()[i] +" " + itemSet[i].getName() + " In your inventory");
				isEmpty=false;
			}
			if(i==8)//skips empty items
			{
				i=13;
			}
		}
		if(isEmpty)
		{
			System.out.println("You don't have anything in your inventory!");
		}
	}
	private boolean verifyInt(String s)
	{
		try
		{
			int x=Integer.parseInt(s);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}
	
	/**
	 * @precondition - 	
	 * @post -			
	 * @return - 			
	 */
	public void openChest(Chest chest)
	{
		m_inventory[chest.getItemInChest()] += 1;
		Item newItem = new Item(chest.getItemInChest());
		
		System.out.println("\n\nYou have found a " + newItem.getName() + "! It has been added to your inventory.\n");
	}
}
