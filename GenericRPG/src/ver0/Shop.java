package ver0;
import java.util.Scanner;
public class Shop 
{
	static Scanner myScanner = new Scanner(System.in);
	static int select;
	int[] m_inventory=new int[Item.getNumTypesOfItem()];
	
	
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
	}
	public void displayMenu(PlayerActor character)
	{
		Item[] itemSet = Item.getAllItems();
		System.out.println("Welcome to our shop! feel free to buy stuff! We'd like that!");
		int choice=1;
		for(int i=0;i<Item.getNumTypesOfItem();i++)
		{
			if(m_inventory[i]>0)
			{
				System.out.println(choice + ") " + itemSet[i].getName() + " costs: " + itemSet[i].getValue());
				choice++;
			}
		}
		System.out.println((choice+1) + ") Leave");
		select=myScanner.nextInt();
		if(select>0&&select<(choice+1))
		{
			displayMenuItemOptions(select,character);
		}
	}
	public void displayMenuItemOptions(int select,PlayerActor character)
	{
		Item[] itemSet = Item.getAllItems();
		int choice=1;
		int index=0;
		for(int i=0; i<Item.getNumTypesOfItem();i++)
		{
			if(m_inventory[i]>0)
			{
				choice++;
			}
			if(select==choice)
			{
				selectedItem=itemSet[i];
				index=i;
			}
		}
		if(m_inventory[index]==1)
		{
			System.out.println("Would you like to buy one " + itemSet[index].getName() + "?\n1) Yes\n2)No");
			select=myScanner.nextInt();
			if(select==1)
			{
				purchase(index,character);
			}
			else
			{
				return;
			}
		}
		else if(m_inventory[index]>1)
		{
			System.out.println("You can buy up to " + m_inventory[index] + "Of these, how many do you want?");
			int select2=myScanner.nextInt();
			if(select2>m_inventory[index])
			{
				System.out.println("Sorry, we don't have that many " + itemSet[index].getName() + "s");
			}
			else if(select2<0)
			{
				System.out.println("Sorry, we cant give you a negative number of something, but you can sell it to us!");
			}
			else if(select2==0)
			{
				System.out.println("Sorry, would you like to buy something else?");
			}
			else
			{
				purchaseMultiple(index,select2,character);
			}
		}
	}
	public void purchase(int index,PlayerActor character)
	{
		Item[] itemSet = Item.getAllItems();
		if(character.buyItem(itemSet[index].getValue()))
		{
			character.getInventory()[index]++;
			this.m_inventory[index]--;
		}
		else
		{
			System.out.println("Sorry, you don't have enough money!");
		}
	}
	public void purchaseMultiple(int index, int quantity, PlayerActor character)
	{
		Item[] itemSet = Item.getAllItems();
		if(character.buyItems(index, quantity))
		{
			character.getInventory()[index]+=quantity;
			this.m_inventory[index]-=quantity;
		}
		else
		{
			System.out.println("Sorry, you don't have enough money!");
			
		}
	}
}
