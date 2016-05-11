import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.lang.StringBuilder;

/**
 * Write a description of class Battle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Battle  
{
   //member variables
    private Random r;
    //private Scanner myScanner;
    private int order;
    private int skillChoice; 
    public PlayerActor curPlayer;
    private boolean ranAway;
    private boolean playerMistake;
    private Skill[] m_skillSet;
    int potionchoice;
    
    /**
     * @pre none--constructor
     * @post a new instance of Battle is created and initialized
     * @return none
     */
    public Battle()
    { 
        //myScanner=new Scanner(System.in);
        r=new Random();
        ranAway=false;
        order=0;
        skillChoice=0;
        m_skillSet=Skill.getSkills();
    }
    
    /**
     * @param
     * @pre Battle instance exists
     * @post players hitpoints, gold, current exp, and potion quantity might be changed. Many, many messages will be printed to the console
     * @return True if player survives the battle, false if the player dies
     */
    public boolean actorBattle(Party party, PlayerActor player, EnemyActor npc)//TODO add more output to user when using skills
    //TODO make return int depending on ending of battle conditions 0--player won, 1--player dies --2 player ran away 
    {
        String in;
        int choice=0;
        ranAway=false;
        curPlayer=player;
        order=randomNumber(0,1);
        
        Shop[] shops=Shop.getAllShops();
        Arena[] arenas=Arena.getAllArenas();
        
        System.out.println("Starting battle between "+player.getName()+" and "+npc.getName());
        
        if (order==0)
        {
            JOptionPane.showMessageDialog(null, "Starting battle between "+player.getName()+" and "+npc.getName() + "\nBy random selection, "+player.getName()+" will go first\n\n");
            System.out.println("By random selection, "+player.getName()+" will go first\n");
            
            do
            {
                StringBuilder text = new StringBuilder();
                
                text.append("Current HP-> "+player.getName()+": "+player.getCurHp()+", "+npc.getName()+": "+npc.getCurHp() + "\n");
                System.out.println("Current HP-> "+player.getName()+": "+player.getCurHp()+", "+npc.getName()+": "+npc.getCurHp());
                text.append(printBattleMenu());//TODO mark for reuse
                in= JOptionPane.showInputDialog(text.toString());
                if(verifyInt(in))
                {
                    choice=Integer.parseInt(in);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "You gave invalid input! please try again\n");
                    System.out.println("You gave invalid input! please try again\n");
                    continue;
                }
                if (choice==1)
                {
                    int temphp1=npc.getCurHp();
                    m_skillSet[0].Execute(player, npc);
                    int temphp2=npc.getCurHp();
                    int difference=temphp1-temphp2;
                    if(player.getEquippedSword() != null)
                    {
                    JOptionPane.showMessageDialog(null, player.getName()+" attacks "+npc.getName()+" with a "+player.getEquippedSword().getName()+", dealing "+difference+" damage!\n");
                    System.out.println(player.getName()+" attacks "+npc.getName()+" with a "+player.getEquippedSword().getName()+", dealing "+difference+" damage!\n");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, player.getName()+" attacks "+npc.getName()+" with a no sword, dealing "+difference+" damage!\n");
                    System.out.println(player.getName()+" attacks "+npc.getName()+" with a no sword, dealing "+difference+" damage!\n");
                    }
                }
                else if (choice==2) //TODO handle when skill does not target enemy, adjust effects for single battle
                {
                    StringBuilder a = new StringBuilder();
                    a.append(printSkillsAvailable(player));
                    a.append("Input the corresponding number to use the skill");
                    System.out.println("Input the corresponding number to use the skill");
                    in=JOptionPane.showInputDialog(a.toString());
                    if (verifyInt(in))
                    {
                        skillChoice=Integer.parseInt(in);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "You didnt input a number, please try again \n");
                        System.out.println("You didnt input a number, please try again \n");
                        continue;
                    }
                    if (skillChoice<8)
                    {
                        if (player.getSkillset()[skillChoice]==true)
                        {
                                m_skillSet[skillChoice].Execute(player, npc);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "You did not choose a skill you have! Please try again\n");
                            System.out.println("You did not choose a skill you have! Please try again\n");
                            continue;
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "You entered a number too high!\n");
                        System.out.println("You entered a number too high!\n");
                        continue;
                    }
                }
                else if (choice==3)
                {
                    StringBuilder b = new StringBuilder();
                    
                    int[] pinv=party.getInventory();
                    b.append(printPotionsAvailable(party));
                    if (potionsAvailable(party))
                    {
                        b.append("Input the corresponding number to use the potion\n");
                        System.out.println("Input the corresponding number to use the potion");
                        
                        in=JOptionPane.showInputDialog(b.toString());
                        if (verifyInt(in))
                        {
                            potionchoice=Integer.parseInt(in);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "You did not enter a number!\n");
                            System.out.println("You did not enter a number!\n");
                            continue;
                        }
                        if (potionchoice==1)
                        {
                            if (pinv[7]>0)
                            {
                                usePotion(1);
                                pinv[7]--;
                            }
                        }
                        else if (potionchoice==2)
                        {
                            if (pinv[20]>0)
                            {
                                usePotion(2);
                                pinv[20]--;
                            }
                        }
                        else if (potionchoice==3)
                        {
                            if (pinv[27]>0)
                            {
                                usePotion(3);
                                pinv[27]--;
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Invalid input given, please try again\n");
                            System.out.println("Invalid input given, please try again\n");
                            continue;
                        }
                    }
                    else
                    {
                        continue;
                    }
                }
                else if (choice==4)
                {
                    if (randomNumber(0,1)==0)
                    {
                        ranAway=true;
                        break;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "You were unable to run away, coward!\n");
                        System.out.println("You were unable to run away, coward!\n");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid input given, please try again\n");
                    System.out.println("Invalid input given, please try again\n");
                    continue;
                }
                JOptionPane.showMessageDialog(null, "It is now "+npc.getName()+"'s turn");
                System.out.println("It is now "+npc.getName()+"'s turn");
                npcTurn(npc);
                
            }while(!isBattleOver(player,npc));
        }
        
        else
        {
            JOptionPane.showMessageDialog(null, "Starting battle between "+player.getName()+" and "+npc.getName() + "By random selection, "+npc.getName()+" will go first\n\n");
            System.out.println("By random selection, "+npc.getName()+" will go first\n");
            do
            {
                StringBuilder text = new StringBuilder();
                if (!playerMistake)
                {
                    text.append("\nIt is now "+npc.getName()+"'s turn\n");
                    System.out.println("\nIt is now "+npc.getName()+"'s turn");
                    npcTurn(npc);
                }
                text.append("Current HP-> "+player.getName()+": "+player.getCurHp()+", "+npc.getName()+": "+npc.getCurHp() + "\n");
                System.out.println("Current HP-> "+player.getName()+": "+player.getCurHp()+", "+npc.getName()+": "+npc.getCurHp());
                text.append(printBattleMenu());
                in=JOptionPane.showInputDialog(text.toString());
                if (verifyInt(in))
                {
                    choice=Integer.parseInt(in);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "You did not input a number!\n");
                    System.out.println("You did not input a number!\n");
                    playerMistake=true;
                }
                    
                if (choice==1)
                {
                    int temphp1=npc.getCurHp();
                    m_skillSet[0].Execute(player, npc);
                    int temphp2=npc.getCurHp();
                    int difference=temphp1-temphp2;
                    JOptionPane.showMessageDialog(null, player.getName()+" attacks "+npc.getName()+" with a "+player.getEquippedSword().getName()+", dealing "+difference+" damage!\n");
                    System.out.println(player.getName()+" attacks "+npc.getName()+" with a "+player.getEquippedSword().getName()+", dealing "+difference+" damage!\n");
                    playerMistake=false;
                }
                else if (choice==2)
                {
                    StringBuilder a = new StringBuilder();
                    a.append(printSkillsAvailable(player));
                    a.append("Input the corresponding number to use the skill\n");
                    System.out.println("Input the corresponding number to use the skill");
                    in=JOptionPane.showInputDialog(a.toString());
                    if (verifyInt(in))
                    {
                        skillChoice=Integer.parseInt(in);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "You didnt input a number");
                        System.out.println("You didnt input a number");
                        playerMistake=true;
                        continue;
                    }
                    
                    if (skillChoice<8)
                    {
                        if (player.getSkillset()[skillChoice]==true)
                        {
                                m_skillSet[skillChoice].Execute(player, npc);
                                playerMistake=false;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "You did not choose a skill you have! Please try again\n");
                            System.out.println("You did not choose a skill you have! Please try again\n");
                            playerMistake=true;
                            continue;
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "You entered a number too high!\n");
                        System.out.println("You entered a number too high!\n");
                        playerMistake=true;
                        continue;
                    }
                }
                else if (choice==3)
                {
                    StringBuilder b = new StringBuilder();
                    int[] pinv=party.getInventory();
                    b.append(printPotionsAvailable(party));
                    if (potionsAvailable(party))
                    {
                        b.append("Input the corresponding number to use the potion\n");
                        System.out.println("Input the corresponding number to use the potion");         
                        
                            in=JOptionPane.showInputDialog(b.toString());
                            if (verifyInt(in))
                            {
                                potionchoice=Integer.parseInt(in);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "You did not enter a number!");
                                System.out.println("You did not enter a number!");
                                playerMistake=true;
                                continue;
                            }
                            
                        if (potionchoice==1)
                        {
                            if (pinv[7]>0)
                            {
                                usePotion(1);
                                pinv[7]--;
                                playerMistake=false;
                            }
                        }
                        else if (potionchoice==2)
                        {
                            if (pinv[20]>0)
                            {
                                usePotion(2);
                                pinv[20]--;
                                playerMistake=false;
                            }
                        }
                        else if (potionchoice==3)
                        {
                            if (pinv[27]>0)
                            {
                                usePotion(3);
                                pinv[27]--;
                                playerMistake=false;
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Invalid input given, please try again\n");
                            System.out.println("Invalid input given, please try again\n");
                            playerMistake=true;
                            continue;
                        }
                    }
                    else
                    {
                        playerMistake=true;
                        continue;
                    }
                }
                else if (choice==4)
                {
                    if (randomNumber(0,1)==0)
                    {
                        ranAway=true;
                        break;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "You were unable to run away, coward!\n");
                        System.out.println("You were unable to run away, coward!\n");
                    }
                }
            }while(!isBattleOver(player,npc));
        }
        
        if (ranAway)
        {
            JOptionPane.showMessageDialog(null, "You successfully ran away!");
            System.out.println("You successfully ran away!");
            return true;
        }
        if(determineVictor(player,npc)==player)
        {
            player.addGold(npc.getDefeatGold());
            player.addExp(npc.getDefeatExp());
            player.setCurHp(player.getMaxHp());
            npc.setCurHp(npc.getMaxHp());
            JOptionPane.showMessageDialog(null, "\nCongrats on the victory! You recieved "+npc.getDefeatGold()+"gold, and "+npc.getDefeatExp()+" experience");
            System.out.println("\nCongrats on the victory! You recieved "+npc.getDefeatGold()+"gold, and "+npc.getDefeatExp()+" experience");
            return true;
        }
        else
        {
            player.setCurHp(player.getMaxHp());
            npc.setCurHp(npc.getMaxHp());
            return false;
        }
    }
    
    /**
     * @param npc
     * @pre an instance of Battle exists 
     * @post Player's hit points will be altered, message printed to console
     * @return None
     */
    public void npcTurn(RPGActor npc)//TODO implement randomness into the npc turn
    {
        int curHp=curPlayer.getCurHp();
        if(curPlayer == null || npc == null)
        {
            JOptionPane.showMessageDialog(null, "null");
        }
        m_skillSet[0].Execute(npc,curPlayer);
        int newHp=curPlayer.getCurHp();
        int damage=curHp-newHp;
        if(npc.getEquippedSword() != null)
        {
            JOptionPane.showMessageDialog(null, npc.getName()+" attacks "+curPlayer.getName()+" with a "+npc.getEquippedSword().getName()+", dealing "+damage+" damage!\n");
        System.out.println(npc.getName()+" attacks "+curPlayer.getName()+" with a "+npc.getEquippedSword().getName()+", dealing "+damage+" damage!\n");
        }
        else
        {
            JOptionPane.showMessageDialog(null, npc.getName()+" attacks "+curPlayer.getName()+" with a no sword, dealing "+damage+" damage!\n");
        System.out.println(npc.getName()+" attacks "+curPlayer.getName()+" with a no sword, dealing "+damage+" damage!\n");
        }
    }
    
    /**
     * @param s
     * @pre instance of Battle exists
     * @post none
     * @return True if s is an int, otherwise false
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
     * @param a1
     * @param a2
     * @pre instance of Battle exists
     * @post none
     * @return true if either RPGActor passed in have 0 hitpoints left. otherwise false
     */
    private boolean isBattleOver(RPGActor a1, RPGActor a2)
    {
        if (a1.getCurHp()<=0 || a2.getCurHp()<=0)
        {
            return true;
        }
        return false;
    }
    
    /**
     * @param min
     * @param max
     * @pre instance of Battle exists
     * @post none
     * @return Int that has value inclusively between min and max
     */
    private int randomNumber(int min, int max)
    {
        return r.nextInt(max-min+1)+min;
    }
    
    /**
     * @pre instance of Battle exists
     * @post menu will be printed to the console containing options
     * @return none 
     */
    private String printBattleMenu()
    {
        StringBuilder text = new StringBuilder();
        text.append("It is your turn, input a number to choose one of the following to do:\n");
        System.out.println("It is your turn, input a number to choose one of the following to do:");
        text.append("1) Basic Attack (using sword)\n");
        System.out.println("1) Basic Attack (using sword)");
        text.append("2) Use Skill\n");
        System.out.println("2) Use Skill");
        text.append("3) Use Potion\n");
        System.out.println("3) Use Potion");
        text.append("4) Run Run Run!\n");
        System.out.println("4) Run Run Run!");
        
        return text.toString();
    }
    
    /**
     * @param a1
     * @pre instance of Battle exists
     * @post the names and descriptions of all skills a1 has unlocked will be printed to the console
     * @return none
     */
    public String printSkillsAvailable(PlayerActor a1)
    {
        StringBuilder text = new StringBuilder();
        
        text.append("Skills available to you:\n\n");
        System.out.println("Skills available to you:\n");
        boolean[] skills=a1.getSkillset();
        
        for (int i=0; i<skills.length; i++)
        {
            if (skills[i]==true)
            {
                text.append(i+") "+m_skillSet[i].getName()+"- "+m_skillSet[i].getDescription() + "\n");
                System.out.println(i+") "+m_skillSet[i].getName()+"- "+m_skillSet[i].getDescription());
            }
        }
        System.out.print("\n");
        
        return text.toString();
    }
    
    /**
     * @param
     * @pre instance of Battle exists
     * @post none
     * @return True if player has 1 single potion in either of their three inventory slots, otherwise false
     */
    private boolean potionsAvailable(Party p1)
    {
        int[] playerInventory=p1.getInventory();
        if (playerInventory[7]>0 || playerInventory[20]>0 || playerInventory[27]>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * @param a1
     * @pre instance of Battle exists
     * @post all potions available, as well as descriptions and quantity in players inventory will be printed to console
     * @return none
     */
    private String printPotionsAvailable(Party a1)
    {
        StringBuilder text = new StringBuilder();
        
        text.append("Potions available to you:\n");
        System.out.println("Potions available to you:");
        int[] playerInventory=a1.getInventory();
        
        if (playerInventory[7]>0)
        {
            text.append("1) Name: Basic Health Potion, Effect: Restore 50 HP, Quantity: "+playerInventory[7] + "\n");
            System.out.println("1) Name: Basic Health Potion, Effect: Restore 50 HP, Quantity: "+playerInventory[7]);
        }
        if (playerInventory[20]>0)
        {
            text.append("2) Name: Advanced Health Potion, Effect: Restore 100 HP, Quantity: "+playerInventory[20] + "\n");
            System.out.println("2) Name: Advanced Health Potion, Effect: Restore 100 HP, Quantity: "+playerInventory[20]);
        }
        if (playerInventory[27]>0)
        {
            text.append("3) Name: Expert Health Potion, Effect: Restore 150 HP, Quantity: "+playerInventory[27] + "\n");
            System.out.println("3) Name: Expert Health Potion, Effect: Restore 150 HP, Quantity: "+playerInventory[27]);
        }
        if (!(potionsAvailable(a1)))
        {
            text.append("You currently don't have any potions\n");
            System.out.println("You currently don't have any potions\n");
        }
        
        return text.toString();
    }
    
    /**
     * @param
     * @pre instance of Battle exists
     * @post players HP will be increased depending on choice, current potion quantititys in player inventory
     *       will be decremented accordingly. Messages printed to console
     * @return none
     */
    private void usePotion(int choice)
    {
        if (choice==1)
        {
            if (curPlayer.getCurHp()+50>curPlayer.getMaxHp())
            {
                curPlayer.setCurHp(curPlayer.getMaxHp());
            }
            else
            {
                curPlayer.setCurHp(curPlayer.getCurHp()+50);
            }
            JOptionPane.showMessageDialog(null, "You used a basic health potion, recovering 50 HP!\n");
            System.out.println("You used a basic health potion, recovering 50 HP!\n");
        }
        else if (choice==2)
        {
            if (curPlayer.getCurHp()+100>curPlayer.getMaxHp())
            {
                curPlayer.setCurHp(curPlayer.getMaxHp());
            }
            else
            {
                curPlayer.setCurHp(curPlayer.getCurHp()+100);
            }
            JOptionPane.showMessageDialog(null, "You used an advanced health potion, recovering 100 HP!\n");
            System.out.println("You used an advanced health potion, recovering 100 HP!\n");
        }
        else if (choice==3)
        {
            if (curPlayer.getCurHp()+150>curPlayer.getMaxHp())
            {
                curPlayer.setCurHp(curPlayer.getMaxHp());
            }
            else
            {
                curPlayer.setCurHp(curPlayer.getCurHp()+150);
            }
            JOptionPane.showMessageDialog(null, "You used an expert health potion, recovering 150 HP!\n");
            System.out.println("You used an expert health potion, recovering 150 HP!\n");
        }
    }
    
    /**
     * @param a1
     * @param a2
     * @pre instance of Battle exists
     * @post none
     * @return RPGActor who's HP is not currently 0
     */
    private RPGActor determineVictor(RPGActor a1, RPGActor a2)
    {
        if (a1.getCurHp()<=0)
        {
            return a2;
        }
        else
        {
            return a1;
        }
    }
    
    /**
     * @pre instance of Battle exists
     * @post none
     * @return true if verifyInt returns true if the input string is an int
     */
    public boolean battleTest1() // if string passed in is an int, verigyInt returns true
    {
        return verifyInt("5");
    }
    
    /**
     * @pre instance of Battle exists
     * @post none
     * @return true if verifyInt returns false if the input string is not an int
     */
    public boolean battleTest2() // if string passed in is not an int, it returns false
    {
        return !(verifyInt("T"));
    }
    
    /**
     * @pre instance of Battle exists
     * @post none
     * @return true if isBattleOver returns true if one of the actors has no health, otherwise false
     */
    public boolean battleTest3() // if one of the actors has no health, it returns true
    {
        RPGActor a1=new RPGActor();
        RPGActor a2=new RPGActor();
        a1.setCurHp(0);
        return isBattleOver(a1,a2);
    }
    
    /**
     * @pre instance of Battle exists
     * @post none 
     * @return true if isBattleOver returns true if both actors have no health, otherwise false
     */
    public boolean battleTest4() // if both actors have no health, it returns true
    {
        RPGActor a1=new RPGActor();
        RPGActor a2=new RPGActor();
        a1.setCurHp(0);
        a2.setCurHp(0);
        return isBattleOver(a1,a2);
    }
    
    /**
     * @pre instance of Battle exists
     * @post none
     * @return true if isBattleOver returns false if both actors have HP left, otherwise false
     */
    public boolean battleTest5() // if both actors have health, it will return false
    {   
        RPGActor a1=new RPGActor();
        RPGActor a2=new RPGActor();
        a1.setCurHp(a1.getMaxHp());
        a2.setCurHp(a2.getMaxHp());
        
        return !(isBattleOver(a1,a2));
        
    }
    
    /**
     * @pre instance of Battle exists
     * @post none
     * @return true if potionsAvilable returns false if the player has no potions in their inventory, otherwise false
     */
    public boolean battleTest6() // if the player has not potions available, then it returns false
    {
        Party a1 = new Party();
        return !(potionsAvailable(a1));
    }
    
    /**
     * @pre instance of Battle exists
     * @post none
     * @return true if potionsAvailable returns true when the player has potions in their inventory
     */
    public boolean battleTest7() // if the player has potions, it returns true
    {
        Party a1=new Party();
        a1.getInventory()[7]=1;
        a1.getInventory()[20]=1;
        a1.getInventory()[27]=1;
        return (potionsAvailable(a1));
    }
    
    /**
     * @pre instance of Battle exists
     * @post none
     * @return true if determineVictor returns the actor with health remaining after a battle, otherwise false
     */
    public boolean battleTest8() //returns true if the actor with health remaining is returned
    {
        RPGActor a1=new RPGActor();
        RPGActor a2=new RPGActor();
        a1.setCurHp(0);
        if (determineVictor(a1,a2)==a2)
        {
            return true;
        }
        return false;
    }
    
    /**
     * @pre instance of Battle exists
     * @post none
     * @return true if determineVictor does not return the actor with no health 
     */
    public boolean battleTest9()
    {
        RPGActor a1=new RPGActor();
        RPGActor a2=new RPGActor();
        a1.setCurHp(0);
        if (determineVictor(a1,a2)!=a1)
        {
            return true;
        }
        return false;
    }
    
    /**
     * @pre instance of Battle exists
     * @post none
     * @return true if usePotion sets curHp to max if player has lost less than 50, when using basic health potion, otherwise false
     */
    public boolean battleTest10()
    {
       PlayerActor a1=new PlayerActor();
        
        a1.setCurHp(75);
        Battle myBattle = new Battle();
        myBattle.curPlayer=a1;
        myBattle.usePotion(1);
        return (a1.getCurHp() == a1.getMaxHp());
        
        
    }
    
    /**
     * @pre instance of Battle exists
     * @post none
     * @return true if usePotion adds 50 to players health when player has lost more than 50 hp, using basic health potion
     */
    public boolean battleTest11()
    {
        PlayerActor a1=new PlayerActor();
        a1.setCurHp(25);
        Battle myBattle=new Battle();
        myBattle.curPlayer=a1;
        myBattle.usePotion(1);
        return (a1.getCurHp()==75);
    }
    
    /**
     * @pre instance of Battle exists
     * @post none
     * @return true if usePotion sets curHp to max if player has lost fewer than 100 hp when using advanced health potion
     */
    public boolean battleTest12()
    {
        PlayerActor a1=new PlayerActor();
        a1.setMaxHp(200);
        a1.setCurHp(150);
        Battle b=new Battle();
        b.curPlayer=a1;
        b.usePotion(2);
        return (a1.getCurHp()==200);
    }
    
    /**
     * @pre instance of Battle exists
     * @post none
     * @return true if usePotion adds 100 to hp if player has lost more than 100 hp
     */
    public boolean battleTest13() // adds 100 to health if youve lost over 100 using potion 2
    {
        PlayerActor a1=new PlayerActor();
        a1.setMaxHp(200);
        a1.setCurHp(25);
        Battle b=new Battle();
        b.curPlayer=a1;
        b.usePotion(2);
        return (a1.getCurHp()==125);
    }
    
    /**
     * @pre instance of battle exists
     * @post none
     * @return true if usePotion sets curHp to max if player has lost fewer than 150 hp when using expert health potion
     */
    public boolean battleTest14() // makes health max if youve lost fewer than 150
    {
        PlayerActor a1=new PlayerActor();
        a1.setMaxHp(200);
        a1.setCurHp(100);
        Battle b=new Battle();
        b.curPlayer=a1;
        b.usePotion(3);
        return (a1.getCurHp()==200);
    }
    
    /**
     * @pre instance of Battle exists
     * @post none
     * @return true if usePotion adds 150 to curHp if player has lost more than 150 hp, when using expert health potion
     */
    public boolean battleTest15() // adds 150 to health if youve lost over 150
    {
        PlayerActor a1=new PlayerActor();
        a1.setMaxHp(200);
        a1.setCurHp(25);
        Battle b=new Battle();
        b.curPlayer=a1;
        b.usePotion(3);
        return (a1.getCurHp()==175);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
