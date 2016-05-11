import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.lang.StringBuilder;

/**
 * Write a description of class Party here.
 * 
 * @author Austin Bailey
 * @version 5/6/2016
 */
public class Party extends Actor
{
    /**
     * Act - do whatever the Party wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    

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
        m_inventory = new int[Item.getNumTypesOfItem()+Item.getNumTypesOfWeapon()];
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
        else if(type==5)
        {
            System.out.println("Currently have: " + selected.getEquippedGauntlets().getName() + " Equipped, with Attack Bonus: " + selected.getEquippedGauntlets().getBonusAtk() + " And Defense Bonus: " + selected.getEquippedGauntlets().getBonusDef());
            System.out.println("Which Gauntlets do you want to equip?");
        }
        else if(type==6)
        {
            System.out.println("Currently have: " + selected.getEquippedBoots().getName() + " Equipped, with Attack Bonus: " + selected.getEquippedBoots().getBonusAtk() + " And Defense Bonus: " + selected.getEquippedBoots().getBonusDef());
            System.out.println("Which Boots do you want to equip?");
        }

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
            else if(type==5)
            {
                if(m_inventory[indexRepresentedByChoice[select]]<1)
                {
                    System.out.println("You dont have a " + items[indexRepresentedByChoice[select]]+ " to equip!");
                }
                else
                {
                    if(selected.getEquippedGauntlets().getId()!=12)
                    {
                        m_inventory[selected.getEquippedGauntlets().getId()]++;
                    }
                    selected.equipGauntlets(items[indexRepresentedByChoice[select]]);
                    m_inventory[indexRepresentedByChoice[select]]--;
                }
            }
            else if(type==6)
            {
                if(m_inventory[indexRepresentedByChoice[select]]<1)
                {
                    System.out.println("You dont have a " + items[indexRepresentedByChoice[select]]+ " to equip!");
                }
                else
                {
                    if(selected.getEquippedBoots().getId()!=13)
                    {
                        m_inventory[selected.getEquippedBoots().getId()]++;
                    }
                    selected.equipBoots(items[indexRepresentedByChoice[select]]);
                    m_inventory[indexRepresentedByChoice[select]]--;
                }
            }
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
     * @precondition -  PlayerActor Object exists
     * @post -          Does not change member variables
     * @return -        void 
     */
    public void viewCharacterStatus(PlayerActor selected)
    {
        StringBuilder text = new StringBuilder();
        
        text.append("Name:               " + selected.getName() + "\n");
        System.out.println("Name:               " + selected.getName());
        text.append("Current Level:      " + selected.getLevel() + "\n");
        System.out.println("Current Level:      " + selected.getLevel());
        text.append("Current Experience: " + selected.getExp() + "\n");
        System.out.println("Current Experience: " + selected.getExp());
        text.append("Exp to next Level:  " + (selected.getLevel()*100-selected.getExp()) + "\n");
        System.out.println("Exp to next Level:  " + (selected.getLevel()*100-selected.getExp()));
        text.append("Maximum Health:     " + selected.getMaxHp() + "\n");
        System.out.println("Maximum Health:     " + selected.getMaxHp());
        text.append("Current Health:     " + selected.getCurHp() + "\n");
        System.out.println("Current Health:     " + selected.getCurHp());//TODO: make output uniform
        if (selected.getEquippedSword() != null)
        {
            text.append("Equipped Sword:     " + selected.getEquippedSword().getName() + " bonus Attack: " + selected.getEquippedSword().getBonusAtk() + " bonus Defense: " + selected.getEquippedSword().getBonusDef() + "\n   ");
            System.out.println("Equipped Sword:     " + selected.getEquippedSword().getName() + " bonus Attack: " + selected.getEquippedSword().getBonusAtk() + " bonus Defense: " + selected.getEquippedSword().getBonusDef());
        }
        if (selected.getEquippedShield() != null)
        {
            text.append("Equipped Shield:    " + selected.getEquippedShield().getName() + " bonus Atack: " + selected.getEquippedShield().getBonusAtk() + " bonus Defense: " + selected.getEquippedShield().getBonusDef() + "\n");
            System.out.println("Equipped Shield:    " + selected.getEquippedShield().getName() + " bonus Atack: " + selected.getEquippedShield().getBonusAtk() + " bonus Defense: " + selected.getEquippedShield().getBonusDef());
        }
        if (selected.getEquippedArmor() != null)
        {
            text.append("Equipped Armor:     " + selected.getEquippedArmor().getName() + " bonus Attack: " + selected.getEquippedArmor().getBonusAtk() + " bonus Defense: " + selected.getEquippedArmor().getBonusDef() + "\n");
            System.out.println("Equipped Armor:     " + selected.getEquippedArmor().getName() + " bonus Attack: " + selected.getEquippedArmor().getBonusAtk() + " bonus Defense: " + selected.getEquippedArmor().getBonusDef());
        }        
        if (selected.getEquippedHelmet() != null)
        {
             text.append("Equipped Helmet:    " + selected.getEquippedHelmet().getName() + " bonus Attack: " + selected.getEquippedHelmet().getBonusAtk() + " bonus Defense: " +  selected.getEquippedHelmet().getBonusDef() + "\n");
             System.out.println("Equipped Helmet:    " + selected.getEquippedHelmet().getName() + " bonus Attack: " + selected.getEquippedHelmet().getBonusAtk() + " bonus Defense: " +  selected.getEquippedHelmet().getBonusDef());
        }       
        if (selected.getEquippedGauntlets() != null)
        {
            text.append("Equipped Gauntlets: " + selected.getEquippedGauntlets().getName() + " bonus Atack: " + selected.getEquippedGauntlets().getBonusAtk()+ " bonus Defense: " +selected.getEquippedGauntlets().getBonusDef() + "\n");
            System.out.println("Equipped Gauntlets: " + selected.getEquippedGauntlets().getName() + " bonus Atack: " + selected.getEquippedGauntlets().getBonusAtk()+ " bonus Defense: " +selected.getEquippedGauntlets().getBonusDef());   
        }        
        if (selected.getEquippedBoots() != null)
        {
            text.append("Equipped Boots:     " + selected.getEquippedBoots().getName() + " bonus Attack " + selected.getEquippedBoots().getBonusAtk() + " bonus Defense: " + selected.getEquippedBoots().getBonusDef() + "\n");
            System.out.println("Equipped Boots:     " + selected.getEquippedBoots().getName() + " bonus Attack " + selected.getEquippedBoots().getBonusAtk() + " bonus Defense: " + selected.getEquippedBoots().getBonusDef());
        }        
        if (true)
        {
            text.append("Natural Attack:     " + selected.getAtk() + "\n");
            System.out.println("Natural Attack:     " + selected.getAtk());
        }        
        //TODO find appropriate conditions
        if (false)
        {
            text.append("Bonus Attack:       " + (selected.getEquippedSword().getBonusAtk()+selected.getEquippedShield().getBonusAtk()+selected.getEquippedArmor().getBonusAtk()+selected.getEquippedHelmet().getBonusAtk()+selected.getEquippedGauntlets().getBonusAtk()+selected.getEquippedBoots().getBonusAtk()) + "\n");
            System.out.println("Bonus Attack:       " + (selected.getEquippedSword().getBonusAtk()+selected.getEquippedShield().getBonusAtk()+selected.getEquippedArmor().getBonusAtk()+selected.getEquippedHelmet().getBonusAtk()+selected.getEquippedGauntlets().getBonusAtk()+selected.getEquippedBoots().getBonusAtk()));
        }        
        if (false)
        {
            text.append("Effective Attack:   " + selected.getAttackFighter() + "\n");
            System.out.println("Effective Attack:   " + selected.getAttackFighter());
        }        
        if (false)
        {
            text.append("Natural Defese:     " + selected.getDef() + "\n");
            System.out.println("Natural Defese:     " + selected.getDef());
        }        
        if (false)
        {
            text.append("Bonus Defense:      " + (selected.getEquippedSword().getBonusDef()+selected.getEquippedShield().getBonusDef()+selected.getEquippedArmor().getBonusDef()+selected.getEquippedHelmet().getBonusDef()+selected.getEquippedGauntlets().getBonusDef()+selected.getEquippedBoots().getBonusDef()) + "\n");
            System.out.println("Bonus Defense:      " + (selected.getEquippedSword().getBonusDef()+selected.getEquippedShield().getBonusDef()+selected.getEquippedArmor().getBonusDef()+selected.getEquippedHelmet().getBonusDef()+selected.getEquippedGauntlets().getBonusDef()+selected.getEquippedBoots().getBonusDef()));
        }        
        if (false)
        {
            text.append("Effective Defense:  " + selected.getDefenseFighter() + "\n");
            System.out.println("Effective Defense:  " + selected.getDefenseFighter());
        }        
        JOptionPane.showMessageDialog(null, text.toString());
    }

    /**
     * This function displays what skills the user has learned
     * @precondition -  PlayerActor Object Exists
     * @post -          Does not change member variables
     * @return -        void
     */
    public void viewCharacterSkills(PlayerActor selected)
    {
        StringBuilder text = new StringBuilder();
        
        Skill[] skillSet = Skill.getSkills();
        for(int i=0; i<Skill.getNumOfSkillsTotal(); i++)
        {
            //TODO: only show known skills
            text.append(skillSet[i].getName());
            System.out.print(skillSet[i].getName());
            for(int j=0; j<(20-skillSet[i].getName().length());j++)
            {
                text.append(" ");
                System.out.print(" ");
            }
            if(selected.m_skillSet[i])
            {
                text.append(" LEARNED - ");
                System.out.print(" LEARNED - ");
            }
            else
            {
                text.append(" UNKNOWN - ");
                System.out.print(" UNKNOWN - ");
            }
            text.append(skillSet[i].getDescription() + "\n");
            System.out.println(skillSet[i].getDescription());
        }
        JOptionPane.showMessageDialog(null, text.toString());
    }

    /**
     * This function handles the menu the user interacts with when the option is selected while the person is in world
     * @precondition -  PlayerActor Object exists
     * @post -          none 
     * @return -        void
     */
    public void menu()
    {
        boolean exit=false;
        while(!exit)
        {
            System.out.println("1) Access Inventory\n2) Character Status\n3) View Skills\n4) Exit");
            String in=JOptionPane.showInputDialog("1) Access Inventory\n2) Character Status\n3) View Skills\n4) Exit");
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
                JOptionPane.showMessageDialog(null, "Sorry, we didn't understand your input");
                System.out.println("Sorry, we didn't understand your input");
            }
        }
    }

    /**
     * This function handles the user accessing the playerCharacters inventory
     * @precondition -  PlayerActor Object exists
     * @post -          none 
     * @return -        void
     */
    public void accessInventory(PlayerActor selected)//TODO implement unequip methods
    {
        Item[] items = Item.getAllItems();
        System.out.println("Here's the stuff in your inventory");
        boolean quit=false;
        while(!quit)
        {
            StringBuilder text = new StringBuilder();
            
            /*
            text.append("Equipped Sword:  " + selected.getEquippedSword().getName() + "\n");
            System.out.println("Equipped Sword:  " + selected.getEquippedSword().getName());
            text.append("Equipped Shield: " + selected.getEquippedShield().getName() + "\n");
            System.out.println("Equipped Shield: " + selected.getEquippedShield().getName());
            text.append("Equipped Armor: " + selected.getEquippedArmor().getName() + "\n");
            System.out.println("Equipped Armor: " + selected.getEquippedArmor().getName());
            text.append("Equipped Helmet: " +  selected.getEquippedHelmet().getName() + "\n");
            System.out.println("Equipped Helmet: " +  selected.getEquippedHelmet().getName());
            text.append("Equipped Gauntlets: " + selected.getEquippedGauntlets().getName() + "\n");
            System.out.println("Equipped Gauntlets: " + selected.getEquippedGauntlets().getName());
            text.append("Equipped Boots: "+ selected.getEquippedBoots().getName() + "\n");
            System.out.println("Equipped Boots: "+ selected.getEquippedBoots().getName());
            */
            text.append("1) Equip a Sword" + "\n");
            System.out.println("1) Equip a Sword");
            text.append("2) Equip a Shield" + "\n");
            System.out.println("2) Equip a Shield");
            text.append("3) Equip Armor" + "\n");
            System.out.println("3) Equip Armor");
            text.append("4) Equip Helmet" + "\n");
            System.out.println("4) Equip Helmet");
            text.append("5) Equip Gauntlets" + "\n");
            System.out.println("5) Equip Gauntlets");
            text.append("6) Equip Boots" + "\n");
            System.out.println("6) Equip Boots");
            text.append("7) Look at inventory" + "\n");
            System.out.println("7) Look at inventory");
            text.append("8) Return" + "\n");
            System.out.println("8) Return");
            
            String in=JOptionPane.showInputDialog(text.toString());
            if(verifyInt(in))
            {
                select=Integer.parseInt(in);
            }
            else
            {
                //System.out.println("You gave invalid input! please try again\n");
                select=9;
            }
            if(select>=0&&select<7)
            {
                equipMenu(select,selected);
            }
            else if(select==7)
            {
                displayInventory();
            }
            else if(select==8)
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
     * @precondition -  PlayerActor Object existsw with initialized m_inventory
     * @post -          If buy is successful, adds one to the index of the inventory that stands for that item, else returns false
     * @return -        true if buy is successful, false else
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
     * @precondition -  PlayerActor Object exists
     * @post -          none 
     * @return -        true if the item can be bought, false else
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
     * @precondition -  PlayerActor Object existsw with initialized m_inventory
     * @post -          If buy is successful, adds parameter int quantity to the index of the inventory that stands for that item, else returns false
     * @return -        true if buy is successful, false else
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
     * @precondition -  PlayerActor Object exists
     * @post -          none 
     * @return -        true if the item can be bought, false else
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
     * @precondition -  PlayerActor Object exists
     * @post -          none /
     * @return -        void            
     */
    public void displayInventory()
    {
        StringBuilder text = new StringBuilder();
        
        Item[] itemSet = Item.getAllItems();
        boolean isEmpty=true;
        for(int i=0; i<itemSet.length;i++)
        {
            if(this.getInventory()[i]>0)
            {
                text.append("You have " + getInventory()[i] +" " + itemSet[i].getName() + " In your inventory\n"); 
                System.out.println("You have " + getInventory()[i] +" " + itemSet[i].getName() + " In your inventory");
                isEmpty=false;
            }
            if(i==8)//skips empty items
            {
                i=13;
            }
        }
        JOptionPane.showMessageDialog(null, text.toString());
        if(isEmpty)
        {
            JOptionPane.showMessageDialog(null, "You don't have anything in your inventory!");
            System.out.println("You don't have anything in your inventory!");
        }
    }

    /**
    * This function verifies that the string passed to it is an int
    * @precondition:    String is passed as parameter
    * @postcondition:   none
    * @return:          true if int, false else
    */
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
     * This function adds the item within the chest to the inventory
     * @precondition:   Chest exists and is passed  
     * @postcondition:  increments the inventory whose index is represented in the chest
     * @return:         void            
     */
    public void openChest(Chest chest)
    {
        m_inventory[chest.getItemInChest()] += 1;
        Item newItem = new Item(chest.getItemInChest());

        System.out.println("\n\nYou have found a " + newItem.getName() + "! It has been added to your inventory.\n");
    }
    
    /**
    * This function tests the party constructor
    * @precondition:    none
    * @postcondition:   none
    * @return:          true if passed false else
    */
    public boolean PartyTest1()
    {
        try
        {
            Party p = new Party();
            PlayerActor pa = new PlayerActor();
            int[] testInventory = new int[Item.getNumTypesOfItem()];
            for(int i=0; i<m_inventory.length;i++)
            {
                m_inventory[i]=0;
            }
            return((p.m_content[0]==pa)&&(p.m_content[1]==null)&&(p.m_content[2]==null)&&(p.m_content[3]==null)&&(p.m_gold==100)&&(p.m_inventory==testInventory));
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    /**
    * This function ensures that onlyOne returns true when it is supposed to 
    * @precondition:    none
    * @postcondition:   none
    * @return:          true if passed false else
    */
    public boolean PartyTest2()
    {
        try
        {
            Party p = new Party();
            return(p.onlyOne());
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    /**
    * This function ensures that function onlyOne returns false when it is supposed to
    * @precondition:    none
    * @postcondition:   none
    * #return:          true if passed false else
    */
    public boolean PartyTest3()
    {
        try
        {
            Party p = new Party();
            PlayerActor pa = new PlayerActor();
            p.m_content[2]=pa;
            return(!p.onlyOne());
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    /**
     * This function ensures that function getGold returns the correct value
     * @precondition:   none
     * @postcondition:  none
     * @return:         true if passed false else
     */
    public boolean PartyTest4()
    {
        try
        {
            Party p = new Party();
            p.m_gold=123;
            return(p.getGold()==123);
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    /**
     * This function ensures that the function setGold sets m_gold to the correct value
     * @precondition:   none
     * @postcondition:  none
     * @return:         true if passed false else
     */
    public boolean PartyTest5()
    {
        try
        {
            Party p = new Party();
            p.setGold(123);
            return(p.m_gold==123);
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    /**
     * This function ensures that the function addGold works properly
     * @precondition:   none
     * @postcondition:  none
     * @return:         true if passed false else
     */
    public boolean PartyTest6()
    {
        try
        {
            Party p = new Party();
            p.m_gold=123;
            p.addGold(123);
            return(p.m_gold==246);
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    /**
     * This function ensures that the function getInventory works
     * @precondition:   none
     * @postcondition:  none
     * @return:         true if passed false else
     */
    public boolean PartyTest7()
    {
        try
        {
            Party p = new Party();
            int[] inventory = new int[Item.getNumTypesOfItem()];
            inventory[1]=123;
            inventory[2]=456;
            p.m_inventory[1]=123;
            p.m_inventory[2]=456;
            return(p.m_inventory==inventory);
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    /** 
     * This function ensures that the function setInventory works properly
     * @precondition:   none
     * @postcondition:  none
     * @return:         true if passed false else
     */
    public boolean PartyTest8()
    {
        try
        {
            Party p = new Party();
            int[] inventory = new int[Item.getNumTypesOfItem()];
            inventory[5]=123;
            inventory[8]=90;
            p.setInventory(inventory);
            return(p.m_inventory[5]==123&&p.m_inventory[8]==90);
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    /** 
     * This function ensures that the function getContent works properly
     * @precondition:   none
     * @postcondition:  none
     * @return:         true if passed false else
     */
    public boolean PartyTest9()
    {
        try
        {
            Party p = new Party();
            return(p.m_content==p.getContent());
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    /** 
     * This function ensures that the function setContent works properly
     * @precondition:   none
     * @postcondition:  none
     * @return:         true if passed false else
     */
    public boolean PartyTest10()
    {
        try
        {
            Party p = new Party();
            PlayerActor[] content = new PlayerActor[4];
            content[2]=new PlayerActor();
            p.setContent(content);
            return(p.m_content==content);
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
