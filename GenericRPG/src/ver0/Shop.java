package ver0;
import java.util.Scanner;
public class Shop 
{
	
    public static Shop[] getAllShops()
    {

    	//Item[] itemArray = new Item[m_numTypesOfItem];

    	Shop[] ShopArray = new Shop[2];


    	for(int i=0; i<ShopArray.length; i++)//Hey, I thought this would ease the process for adding new items, should do it automatically
    	{
    		ShopArray[i]=new Shop(i+1);
    	}
    	return ShopArray;
    }
	static Scanner myScanner = new Scanner(System.in);
	//TODO figure out what to do if the shop is sold out
	static int select;
	int[] m_inventory=new int[Item.getNumTypesOfItem()];
	
	/**
	 * This constructor initializes a shop from one of the premade shops, based on its parameter int whichShop
	 * @precondition - 	None
	 * @post - 			Creates a shop based on the parameter given
	 * @returns - 		a Shop object
	 */
	public Shop(int whichShop)//used in case we make more than one shop
	{
		for(int i=0;i<Item.getNumTypesOfItem();i++)
		{
			m_inventory[i]=0;
		}
		if(whichShop==1)
		{
			for(int i=1;i<=6;i++)
			{
				m_inventory[i]=1;
			}
			m_inventory[7]=10;
		}
		else if(whichShop==2)
		{
			for(int i=1;i<=6;i++)
			{
				m_inventory[i]=3;
			}
			m_inventory[7]=10;
			for(int i=14;i<=20;i++)//skipps 'empty' items
			{
				m_inventory[i]=1;
			}
			m_inventory[20]=5;
		}
	}
	
	/**
	 * This function displays a menu for the character to select from
	 * @precondition - 	an instance of the Shop class
	 * @post - 			methods within the function may alter the PlayerActor object passed
	 * @return - 		void
	 */
	public void displayMenu(Party party)
	{
		Item[] itemSet = Item.getAllItems();
		boolean exit=false;
		while(!exit)
		{
			System.out.println("Welcome to our shop! feel free to buy stuff! We'd like that!\n1) Buy\n2) Sell\n3) Leave");
			select=myScanner.nextInt();
			if(select==1)
			{
				displayBuyMenu(party);
			}
			else if(select==2)
			{
				displaySellMenu(party);
			}
			else if(select==3)
			{
				System.out.println("Thank you for your custom, please come again!");
				return;
			}
			else
			{
				System.out.println("Sorry we didn't understand your input, please enter a 1 a 2 or a 3");
			}
		}	
	}
	
	/**
	 * This function displays the menu that the character can buy from
	 * @precondition - 	an instance of the Shop Class
	 * @post - 			alters a PlayerActors member variables based on what he buys and how much it costs
	 * @return - 		void
	 */
	public void displayBuyMenu(Party party)
	{
		Item[] itemSet = Item.getAllItems();
		boolean exit=false;
		while(!exit)
		{
			System.out.println("You currently have " + party.getGold() +" Gold avaliable to buy stuff with");
			System.out.println("Please select what you would like to buy");
			int[] indexRepresentedByChoice= new int[itemSet.length];
			for(int i=0;i<itemSet.length;i++)
			{
				indexRepresentedByChoice[i]=-1;//the value -1 represents not having that as a possible choice
			}
			int choice=1;//this is the choice incrementer, that gets incremented each time we show a new option to the customer
			for(int i=0;i<Item.getNumTypesOfItem();i++)
			{
				if(m_inventory[i]>0)
				{
					System.out.print(choice + ") " + itemSet[i].getName());
					for(int j=0; j< 20-itemSet[i].getName().length();j++)//this loop makes the display uniform
					{
						System.out.print(" ");// + " costs: " + itemSet[i].getValue() + " quantity avaliable: " + this.m_inventory[i]);
					}
					System.out.print(" costs: " + itemSet[i].getValue());
					if(itemSet[i].getValue()<1000)//this if block makes the display uniform
					{
						System.out.print(" ");
					}
					if(itemSet[i].getValue()<100)
					{
						System.out.print(" ");
					}
					if(itemSet[i].getValue()<10)
					{
						System.out.print(" ");
					}
					indexRepresentedByChoice[choice]=i;
					choice++;
					System.out.println();
				}
				if(i==7)//Skips empty items
				{
					i=13;
				}
			}
			System.out.println((choice)+ ") Leave");
			select=myScanner.nextInt();
			if(select==choice)
			{
				return;
			}
			else if(select<1||select>choice)
			{
				System.out.println("Sorry we cant understand you input, please enter one of the numbers provided");
			}
			else if(indexRepresentedByChoice[select]!=-1)
			{
				if(m_inventory[indexRepresentedByChoice[select]]<1)
				{
					System.out.println("Sorry, we don't have any of those in stock");
				}
				else if(m_inventory[indexRepresentedByChoice[select]]==1)
				{
					purchase(indexRepresentedByChoice[select],party);
				}
				else if(m_inventory[indexRepresentedByChoice[select]]>1)
				{
					System.out.println("How many " + itemSet[indexRepresentedByChoice[select]].getName() +" would you like to buy?");
					int quantity=myScanner.nextInt();
					{
						if(quantity<0)
						{
							System.out.println("Sorry, we cant give you a negative number, you can sell to us though!");
						}
						else if(quantity==1)
						{
							purchase(indexRepresentedByChoice[select],party);
						}
						else if(quantity>m_inventory[indexRepresentedByChoice[select]])
						{
							System.out.println("Sorry, we don't have that many!");
						}
						else if(quantity<=m_inventory[indexRepresentedByChoice[select]])
						{
							purchaseMultiple(indexRepresentedByChoice[select],quantity,party);
						}
						else
						{
							System.out.println("Sorry we don't undersand your input, please try again!");
						}
					}
				}
			}

		}
	}
	/**
	 * This function attempts the purchase of an item defined by the index and by the PlayerActor character
	 * @precondition: 	instance of Shop Class
	 * @post:			Alters member variables in character based on if it could buy an item and how much that item costs
	 * @return:			void
	 */
	public void purchase(int index,Party character)
	{
		Item[] itemSet = Item.getAllItems();
		if(character.canBuyItem(itemSet[index].getValue()))//puchase is successful
		{
			if(character.buyItem(index))
			{
				System.out.println("Puchase successful! You have bought one " + itemSet[index].getName());
				this.m_inventory[index]--;
			}
			else
			{
				System.out.println("ERROR purchase not successful, please try again");
			}
		}
		else
		{
			System.out.println("Sorry, you don't have enough money!");
		}
	}
	
	/**
	 * This function attempts the purchase of items defined by the index, the quantity and the PlayerActor character
	 * @precondition: 	instance of Shop Class
	 * @post:			Alters member variables in character based on if it could buy an item, how may it bought and how much the purchase was
	 * @return:			void
	 */
	public void purchaseMultiple(int index, int quantity, Party character)
	{
		Item[] itemSet = Item.getAllItems();
		if(character.canBuyItems(index, quantity))//purchase is successful
		{
			if(character.buyItems(index,quantity))
			{
				System.out.println("Purchase successful! You have bought" + quantity + " " +itemSet[index].getName());
				this.m_inventory[index]-=quantity;
			}
//			this.m_inventory[index]-=quantity;
		}
		else
		{
			System.out.println("Sorry, you don't have enough money!");
			
		}
	}
	
	public void displaySellMenu(Party party)
	{
		Item[] itemSet = Item.getAllItems();//so we can access items information
		boolean exit=false;
		boolean isEmpty=true;
		int[] tempInventory=party.getInventory();
		while(!exit)
		{
			for(int i=0;i<itemSet.length;i++)//loop checks to see if the characters inventory is empty
			{
				if(tempInventory[i]>0)
				{
					isEmpty=false;
				}
				if(i==6)//skips empty items
				{
					i=13;
				}
			}
			
			if(isEmpty)//handles the case where the user has nothing to sell
			{
				System.out.println("Sorry, you don't have anything to sell...");
				return;
			}
			System.out.println("You currently have: " + party.getGold() + " gold");
			System.out.println("What would you like to sell?");
			int choice=1;
			int[] indexRepresentedByChoice= new int[itemSet.length];
			for(int i=0;i<=27; i++)//displays possible sell options
			{
				if(party.getInventory()[i]>0)
				{
					System.out.println(choice + ") sell " + itemSet[i].getName() + " for " + ((int)itemSet[i].getValue()*.8));
					indexRepresentedByChoice[choice]=i;
					choice++;
				}
				if(i==7)//skips empty items
				{
					i=13;
				}
			}
			System.out.println((choice) + ") Leave");
			select = myScanner.nextInt();
			if(select<1||select>choice)
			{
				System.out.println("Sorry, we didn't understand your input");
			}
			else if(select>0&&select<choice)
			{
				if(party.getInventory()[indexRepresentedByChoice[select]]==1)
				{
					sell(indexRepresentedByChoice[select],party);
				}
				if(party.getInventory()[indexRepresentedByChoice[select]]>1)
				{
					sellMultiple(indexRepresentedByChoice[select],party);
				}
			}
			else if(select==choice)
			{
				System.out.println("Thank you for shopping with us");
				return;
			}
			else
			{
				System.out.println("Sorry, we didn't understand your input");
			}
		}
	}
	
	public void sell(int index, Party character)
	{
		Item[] itemSet = Item.getAllItems();//so we can access items information
		int[] tempInventory = character.getInventory();
		character.addGold((int)(itemSet[index].getValue()*.8));
		tempInventory[index]--;	//removes one from the inventory
		this.m_inventory[index]++;//adds one to the inventory of the shop
		character.setInventory(tempInventory);
		System.out.println("Successfully sold one " + itemSet[index].getName() + " for " + (int)(itemSet[index].getValue()*.8) + " gold.");
	}
	public void sellMultiple(int index, Party character)
	{
		Item[] itemSet = Item.getAllItems();//so we can access items information
		int[] tempInventory = character.getInventory();
		boolean exit=false;
		while(!exit)
		{
			System.out.println("How many " + itemSet[index].getName() + "Would you like to sell?\n(if you would like to go back, sell 0)");
			select = myScanner.nextInt();
			if(select==0)
			{
				return;
			}
			else if(select<1)
			{
				System.out.println("Sorry you have to sell at least one item");
			}
			else if(select>tempInventory[index])
			{
				System.out.println("Sorry you dont have that many");
			}
			else if(select<=tempInventory[index])
			{
				tempInventory[index]-=select;
				this.m_inventory[index]+=select;
				character.setInventory(tempInventory);
				character.addGold((int)(itemSet[index].getValue()*.8*select));
				System.out.println("Successfully sold " + select + " " + itemSet[index].getName() + " for " + ((int)(itemSet[index].getValue()*.8*select)) + " gold");
			} 
		}
	}
}
