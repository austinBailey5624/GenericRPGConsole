import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RPGActor here.
 *
 * @author Austin Bailey
 * @version 5/5/2016
 */
public class RPGActor extends Actor
{
    Item[] itemSet;
    private String m_name;
    private String m_description;
    private int m_level;
    private int m_maxHp;//max Hit Points
    private int m_curHp;//current Hit Points
    private int m_atk;
    private double m_atkModifier;
    private int m_def;
    private double m_defModifier;
    private Item m_equippedSword;
    private Item m_equippedShield;
    private Item m_equippedArmor;
    private Item m_equippedHelmet;
    private Item m_equippedBoots;
    private Item m_equippedGauntlets;
    protected boolean[] m_skillSet;

    //Constructors
    public RPGActor()//default constructor
    {
        itemSet = Item.getAllItems();
        Item[] itemArray = Item.getAllItems();
        m_level=1;
        m_maxHp=100;
        m_curHp=100;
        m_atk=10;
        m_atkModifier=1;
        m_def=10;
        m_defModifier=1;

        equipSword(itemArray[8]);
        equipShield(itemArray[9]);
        equipArmor(itemArray[10]);
        equipHelmet(itemArray[11]);
        equipGauntlets(itemArray[12]);
        equipBoots(itemArray[13]);
        setAttackModifier(1);
        setDefenseModifier(1);

        m_skillSet=new boolean[Skill.getNumOfSkillsTotal()];
        for(int i=0; i<Skill.getNumOfSkillsTotal();i++)
        {
            m_skillSet[i]=false;
        }
        m_skillSet[0]=true;//sets the basic attack skill to true to ensure that it is avaliable to all
    }


    //Setters and Getters
    /**
     * This function returns the value of m_skillSet
     * pre - RPGActor Object exists
     * post - none
     * @return m_skillSet
     */
    public boolean[] getSkillset()
    {
        return m_skillSet;
    }

    /**
     * This function returns the value of m_name
     * pre - Actor Object exists
     * post - none
     * @return m_name
     */
    public String getName()
    {
        return m_name;
    }

    /**
     * This function sets the value of m_name
     * pre - Actor Object exists
     * post - changes m_name to parameter String name
     * @return void
     */
    public void setName(String name)
    {
        m_name=name;
    }

    /**
     * This function returns the value of m_level
     * pre - Actor Object exists
     * post - none
     * @return m_level
     */
    public int getLevel()
    {
        return m_level;
    }

    /**
     * This function sets the value of m_level
     * pre - Actor Object exists
     * post - sets m_level to parameter int level
     * @return void
     */
    public void setLevel(int level)
    {
        m_level=level;
    }

    /**
     * This function returns the value of m_maxHp
     * pre - Actor Object exists
     * post - none
     * @return m_maxHp
     */
    public int getMaxHp()
    {
        return m_maxHp;
    }

    /**
     * This function sets the value of m_maxHp
     * pre - Actor Object exists
     * post - sets m_maxHp to parameter int maxHP
     * @return void
     */
    public void setMaxHp(int maxHP)
    {
        m_maxHp=maxHP;
    }

    /**
     * This function returns the value of m_CurHp
     * pre - Actor Object exists
     * post - none
     * @return m_curHp
     */
    public int getCurHp()
    {
        return m_curHp;
    }

    /**
     * This function sets the value of m_CurHp
     * pre - Actor Object exists
     * post - sets m_curHp to parameter int curHp
     * @return void
     */
    public void setCurHp(int curHp)
    {
        m_curHp=curHp;
    }

    /**
     * This function returns the value of m_atk
     * pre - Actor Object exists
     * post - none
     * @return m_atk
     */
    public int getAtk()
    {
        return m_atk;
    }

    /**
     * This function sets the value of m_atk
     * pre - Actor Object exists
     * post - sets m_atk to parameter int Atk
     * @return void
     */
    public void setAtk(int Atk)
    {
        m_atk=Atk;
    }

    /**
     * This function returns the value of m_atkModifier
     * pre - Actor Object exists
     * post - none
     * @return m_atkModifier
     */
    public double getAtkModifier()
    {
        return m_atkModifier;
    }

    /**
     * This function sets the value of m_atkModifier
     * pre - Actor Object exists
     * post - sets the value of m_atkModifer and ensures it is within acceptable parameters
     * @return void
     */
    public void setAttackModifier(double AttackModifier)
    {
        if(AttackModifier>=5)
        {
            m_atkModifier=5;
        }
        else if(AttackModifier<0)
        {
            m_atkModifier=0;
        }
        else
        {
            m_atkModifier=AttackModifier;
        }
    }

    /**
     * This function returns the value of m_def
     * pre - Actor Object exists
     * post - none
     * @return m_def
     */
    public int getDef()
    {
        return m_def;
    }

    /**
     * This function sets the value of m_def
     * pre - Actor Object exists
     * post - sets the value of m_def to paramter int Def
     * @return void
     */
    public void setDef(int Def)
    {
        m_def=Def;
    }

    /**
     * This function returns the value of m_defModifier
     * pre - Actor Object exists
     * post - none
     * @return m_defModifier
     */
    public double getDefModifier()
    {
        return m_defModifier;
    }

    /**
     * This function sets the value of m_defModifier and ensures it is within an acceptable range
     * pre - Actor Object exists
     * post - m_defModifier is set to parameter double DefenseModifier unless unacceptable, then value approximated
     * @return void
     */
    public void setDefenseModifier(double DefenseModifier)
    {
        if(DefenseModifier>=5)
        {
            m_defModifier=5;
        }
        else if(DefenseModifier<0)
        {
            m_defModifier=0;
        }
        else
        {
            m_defModifier=DefenseModifier;
        }
    }

    /**
     * This function returns the Item m_equippedSword
     * pre - Actor Object exists
     * post - none
     * @return m_equippedSword
     */
    public Item getEquippedSword()
    {
        return m_equippedSword;
    }

    /**
     * This function attempts to set the Item m_equippedSword to the parameter Item sword
     * pre - Actor Object exists
     * post - sets m_equippedSword to parameter Item sword if the item is a sword, else prints message "Cannot equip that in the sword slot!"
     * @return void
     */
    public void equipSword(Item sword)
    {
        if(sword.getType()==1)
        {
            m_equippedSword=sword;
        }
        else
        {
            System.out.println("Cannot equip that in the sword slot!");
        }
    }

    /**
     * This function returns the Item m_equippedShield
     * pre - Actor Object exists
     * post - none
     * @return m_equippedShield
     */
    public Item getEquippedShield()
    {
        return m_equippedShield;
    }

    /**
     * This function attempts to set the Item m_equippedShield to the parameter Item shield
     * pre - Actor Object exists
     * post - sets m_equippedShield to parameter Item shield if the item is a shield, else prints message "Cannot equip that in the shield slot!"
     * @return void
     */
    public void equipShield(Item shield)
    {
        if(shield.getType()==2)
        {
            m_equippedShield=shield;
        }
        else
        {
            System.out.println("Cannot equip that in the Sheild slot!");
        }
    }

    /**
     * This function returns the Item m_equippedArmor
     * pre - Actor Object exists
     * post - none
     * @return m_equippedArmor
     */
    public Item getEquippedArmor()
    {
        return m_equippedArmor;
    }

    /**
     * This function attempts to set the Item m_equippedArmor to the parameter Item armor
     * pre - Actor Object exists
     * post - sets m_equippedArmor to parameter Item armor if the item is a armor, else prints message "Cannot equip that in the armor slot!"
     * @return void
     */
    public void equipArmor(Item armor)
    {
        if(armor.getType()==3)
        {
            m_equippedArmor=armor;
        }
        else
        {
            System.out.println("Cannot equip that in the Armor Slot!");
        }
    }

    /**
     * This function returns the Item m_equippedArmor
     * pre - Actor Object exists
     * post - none
     * @return m_equippedArmor
     */
    public Item getEquippedHelmet()
    {
        return m_equippedHelmet;
    }

    /**
     * This function attempts to set the Item m_equippedHelmet to the parameter Item helmet
     * pre - Actor Object exists
     * post - sets m_equippedHelmet to parameter Item helmet if the item is a helmet, else prints message "Cannot equip that in the Helmet slot!"
     * @return void
     */
    public void equipHelmet(Item helmet)
    {
        if(helmet.getType()==4)
        {
            m_equippedHelmet=helmet;
        }
        else
        {
            System.out.println("Cannot equip that in the Helmet slot!");
        }
    }

    /**
     * This function returns the Item m_equippedGauntlets
     * pre - Actor Object exists
     * post - none
     * @return m_equippedGauntlets
     */
    public Item getEquippedGauntlets()
    {
        return m_equippedGauntlets;
    }

    /**
     * This function attempts to set the Item m_equippedGauntlets to the parameter Item gauntlets
     * pre - Actor Object exists
     * post - sets m_equippedGauntlets to parameter Item gauntlets if the item is a gauntlets, else prints message "Cannot equip that in the Gauntlet slot!"
     * @return void
     */
    public void equipGauntlets(Item gauntlets)
    {
        if(gauntlets.getType()==5)
        {
            m_equippedGauntlets=gauntlets;
        }
        else
        {
            System.out.println("Cannot equip that in the Gauntlet slot!");
        }
    }

    /**
     * This function returns the value of m_description
     * pre -    Actor Object Exists
     * post -           does not change member variables
     * @return-         returns the value of m_description
     */
    public String getDescription()
    {
        return m_description;
    }

    /**
     * This function sets the value of m_description to String given
     * pre -    Actor Object Exists
     * post -           changes m_description to the string given in the parameter
     * @return -        void
     */
    public void setDescription(String given)
    {
        m_description=given;
    }

    /**
     * This function returns the Item m_equippedBoots
     * pre - Actor Object exists
     * post - none
     * @return m_equippedBoots
     */
    public Item getEquippedBoots()
    {
        return m_equippedBoots;
    }

    /**
     * This function attempts to set the Item m_equippedBoots to the parameter Item boots
     * pre - Actor Object exists
     * post - sets m_equippedBoots to parameter Item Boots if the items are boots, else prints message "Cannot equip that in the Boots slot!"
     * @return void
     */
    public void equipBoots(Item boots)
    {
        if(boots.getType()==6)
        {
            m_equippedBoots=boots;
        }
        else
        {
            System.out.println("Cannot equip that in the Boots slot!");
        }
    }

    //Battle Metho  ds
    /**
     * This function reduces the hp of the RPGActor by the parameter int damage
     * pre - Actor Object exists
     * post - reduces m_curHp by damage, if after m_curHp is >0 returns false, else true
     * @return false if RPGActor is alive, true if dead
     */
    public boolean reduceHp(int damage)//returns bool if fatal
    {
        m_curHp=m_curHp-damage;
        if(m_curHp>0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * This is a container function utilizing the reduceHp function
     * pre - Actor Object exists
     * post - reduces m_curHp by damage, if after m_curHp is >0 returns false, else true
     * @return false if RPGActor is alive, true if dead
     */
    public boolean basicAttack(RPGActor opponent)
    {
        return opponent.reduceHp(this.getAtk());
    }

    //getters and setters for battle that have the alteration from the items in addition to the basics
    /**
     * Returns the atk value to be used by battle methods that includes modifiers from all items
     * pre - Actor Object exists
     * post - none
     * @return m_atk plus bonus attack from all equipped items
     */
    public int getAttackFighter()
    {
        if(m_equippedSword == null)
        {
            return ((int)(getAtk()*getAtkModifier()));
        }
        else
        {
        return ((int)((getAtk()+m_equippedSword.getBonusAtk())*getAtkModifier()));
        }
    }

    /**
     * Returns the def value to be used by the battle methods that includes modifiers from all items
     * pre - Actor Object exists
     * post - none
     * @return m_def plus bonus def from all equipped items
     */
    public int getDefenseFighter()
    {
         if((m_equippedShield != null)&&(m_equippedHelmet != null)&&(m_equippedBoots != null)&&(m_equippedGauntlets != null))
        {
            return ((int)((getDef()+m_equippedShield.getBonusDef()+m_equippedHelmet.getBonusDef()+m_equippedBoots.getBonusDef()+m_equippedGauntlets.getBonusDef())*getDefModifier()));
        }
        else
        {
        return ((int)((getDef())*getDefModifier()));
        }
    }


  /**
  * Tests Actor constructor base values for m_level, m_maxHp, m_curHp, m_atk, m_atkModifier, m-def, and m_defModifier
  * pre - Actor constructor exists
  * post - none
  * @return true if passed false else
  */
  public boolean RPGActorTest1()
  {
    RPGActor a = new RPGActor();
    return((a.m_level==1)&&(a.m_maxHp==100)&&(a.m_curHp==100)&&(a.m_atk==10)&&(a.m_atkModifier==1)&&(a.m_def==10)&&(m_defModifier==1));
  }

  /**
 * Tests Actor constructor and equip Sword
 * pre - Actor constructor and equipSword() works
 * post -       none
 * @return true if passed false else
 */
 public boolean RPGActorTest2()
 {
   Item[] itemArray = Item.getAllItems();
   RPGActor a=new RPGActor();
   return (a.m_equippedSword==itemArray[8]);
 }

 /**
 * Tests Actor constructor and equipShield()
 * pre - Actor constructor and equipSword() works
 * post -         none
 * @return true if passed false else
 */
 public boolean RPGActorTest3()
 {
   Item[] itemArray = Item.getAllItems();
   RPGActor a = new RPGActor();
   return (a.m_equippedShield==itemArray[9]);
 }


 /**
 * Tests Actor constructor and equipArmor()
 * pre - Actor object is functional
 * post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest4()
 {
   Item[] itemArray = Item.getAllItems();
   RPGActor a = new RPGActor();
   return (a.m_equippedShield==itemArray[10]);
 }

 /**
 * Tests Actor constructor and equipHelmet()
 * pre - Actor constructor and equipHelmet() works
 * post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest5()
 {
   Item[] itemArray = Item.getAllItems();
   RPGActor a = new RPGActor();
   return (a.m_equippedHelmet==itemArray[11]);
 }

 /**
 * Tests Actor constructor and equipGauntlets()
 * @precondition - Actor constructor and equipHelmet() works
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest6()
 {
   Item[] itemArray = Item.getAllItems();
   RPGActor a = new RPGActor();
   return (a.m_equippedGauntlets==itemArray[12]);
 }

 /**
 * Tests that RPGActor member array m_skillset is of proper length
 * @precondition - Actor constructor assigns value to m_skillset
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest7()
 {
   RPGActor a = new RPGActor();
   return (a.m_skillSet.length==Skill.getNumOfSkillsTotal());
 }

 /**
 * Tests that RPGActor member array m_skillset has proper starting values
 * @precondition - Actor consturctor assigns m_skillset of proper length
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest8()
 {
   RPGActor a = new RPGActor();
   if(a.m_skillSet.length!=Skill.getNumOfSkillsTotal())
   {
     return false;
   }
   if(a.m_skillSet[0]==false)
   {
     return false;
   }
   for(int i=1; i<Skill.getNumOfSkillsTotal();i++)
   {
     if(m_skillSet[i]==true)
     {
       return false;
     }
   }
   return true;
 }

 /**
 * Tests that member method getSkillset() works
 * @precondition - getSkillset() has method definition and RPGActor constructor works
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest9()
 {
   RPGActor a = new RPGActor();
   return(a.m_skillSet==a.getSkillset());
 }

 /**
 * Tests that member method getName() works
 * @precondition - getName() has method definition and RPGActor consturctor works
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest10()
 {
   RPGActor a = new RPGActor();
   a.m_name = "bob";
   return(a.m_name.equals(a.getName()));
 }

 /**
 * Tests that member method setName() works
 * @precondition - setName() has method definition and RPGActor constructor works
 * @post - none
 * @return ture if passed false else
 */
 public boolean RPGActorTest11()
 {
   RPGActor a = new RPGActor();
   a.m_name="sue";//prevents nullpointer exception in the event setName fails
   a.setName("bob");
   return(a.m_name.equals("bob"));
 }

 /**
 * Tests that member method getLevel() works
 * @precondition - getLevel() has method definition and RPGActor constructor works
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest12()
 {
   RPGActor a = new RPGActor();
   return(a.getLevel()==1);
 }

 /**
 * Tests that memeber method setLevel() works
 * @precondition - setLevel() has method definition and RPGActor constructor works
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest13()
 {
   RPGActor a = new RPGActor();
   a.setLevel(5);
   return(a.m_level==5);
 }

 /**
 * Tests that member method getMaxHp() works
 * @precondition - getMaxHp() has method definition and RPGActor constructor works
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest14()
 {
   RPGActor a = new RPGActor();
   return(a.getMaxHp()==100);
 }

 /**
 * Tests that member method setMaxHp() works
 * @precondition - setMaxHp() has method definition and RPGActor constructor works
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest15()
 {
   RPGActor a = new RPGActor();
   a.setMaxHp(123);
   return(a.m_maxHp==123);
 }

 /**
 * Tests that member method getCurHp() works
 * @precondition - getCurHp() hsa method definition and RPGActor constructor works
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest16()
 {
   RPGActor a = new RPGActor();
   a.m_curHp=123;
   return(a.getCurHp()==123);
 }

 /**
 * Tests that member method setCurHp() works
 * @precondition - setCurHp() has a method definition and RPGActor constructor works
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest17()
 {
   RPGActor a = new RPGActor();
   a.setCurHp(123);
   return(m_curHp==123);
 }

 /**
 * Test that the member method getAtk() returns m_atk
 * @precondition - getAtk() has definition and RPGActor constructor works
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest18()
 {
   RPGActor a = new RPGActor();
   a.m_atk=12;
   return(a.getAtk()==12);
 }

 /**
 * Test that the member method setAtk() sets a value to member variable m_atk
 * @precondition - setAtk() has definition and RPGActor constructor works
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest19()
 {
   RPGActor a = new RPGActor();
   a.setAtk(53);
   return(a.m_atk==53);
 }

 /**
 * Test that the member method getAtkModifier() returns the value m_atkModifier
 * @precondition - getAtkModifier() has definition and RPGActor constructor is functional
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest20()
 {
   RPGActor a = new RPGActor();
   a.m_atkModifier = 2;
   return(a.getAtkModifier()==2);
 }

 /**
 * Test that ensures if the value passed to setAttackModifier is >5 m_attackModifier is set to 5
 * @precondition - setAttackModifier() has definition and RPGActor constructor is functional
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest21()
 {
   RPGActor a = new RPGActor();
   a.setAttackModifier(50);
   return(a.m_atkModifier==(double)5);
 }

 /**
 * Test that ensures if the value passed to setAttackModifier is in range it is set
 * @precondition - setAttackModifier() has definition and RPGActor constructor is functional
 * @post - none;
 * @return true if passed false else
 */
 public boolean RPGActorTest22()
 {
   RPGActor a = new RPGActor();
   a.setAttackModifier(2.5);
   return(a.m_atkModifier==2.5);
 }

 /**
 * Test that ensures if the value passed to setAttackModifier is below range m_attackModifer is set to 0
 * @precondition - setAttackModifier() has definition and RPGActor constructor is functional
 * @post - none;
 * @return true if passed false else
 */
 public boolean RPGActorTest23()
 {
   RPGActor a = new RPGActor();
   a.setAttackModifier(-123);
   return(a.m_atkModifier==0);
 }

 /**
 * Test that ensures getDef() returns correct value
 * @precondition - getDef() has definition and RPGActor constructor is functional
 * @post - none;
 * @return true if passed false else
 */
 public boolean RPGActorTest24()
 {
   RPGActor a = new RPGActor();
   a.m_def=543;
   return(a.getDef()==543);
 }

 /**
 * Test that ensures that setDef() correctly sets m_def
 * @precondition - setDef() has definition and RPGActor constructor is functional
 * @post - none;
 * @return true if passed false else
 */
 public boolean RPGActorTest25()
 {
   RPGActor a = new RPGActor();
   a.setDef(234);
   return(a.m_def==234);
 }

 /**
 * Test that ensures that getDefModifier() returns the correct value
 * @precondition - getDefModifier() has definition and RPGActor constructor is functional
 * @post - none;
 * @return true if passed false else
 */
 public boolean RPGActorTest26()
 {
   RPGActor a = new RPGActor();
   a.m_defModifier=123;
   return(a.getDefModifier()==123);
 }

 /**
 * Test that ensures setDefenseModifier() sets m_defModifier to 5 if given a value above 5
 * @precondition - setDefenseModifier() has definition and RPGActor constructor is functional
 * @post - none;
 * @return true if passed false else
 */
 public boolean RPGActorTest27()
 {
  RPGActor a = new RPGActor();
  a.setDefenseModifier(6);
  return(a.m_defModifier==5);
 }

 /**
 * Test ensures that setDefenseModifier sets m_defModifier appropriately if given a good value
 * @precondition - setDefenseModifier() has definition and RPGActor constructor is functional
 * @post - none;
 * @return true if passed false else
 */
 public boolean RPGActorTest28()
 {
   RPGActor a = new RPGActor();
   a.setDefenseModifier(3);
   return(a.m_defModifier==3);
 }

 /**
 * Test ensures that setDefenseModifier sets m_defModifer to 0 if given a bad value less than zero
 * @precondition - setDefenseModifier() has definition and RPGActor constructor is functional
 * @post - none;
 * @return true if passed false else
 */
 public boolean RGPActorTest29()
 {
   RPGActor a = new RPGActor();
   a.setDefenseModifier(-123);
   return(a.m_defModifier==0);
 }

 /**
 * Test ensures that getEquippedSword() function returns the correct Item
 * @precondition - getEquippedSword() function has definition and can interface with item class
 * @post - none;
 * @return true if passed false else
 */
 public boolean RPGActorTest30()
 {
   RPGActor a = new RPGActor();
   Item[] itemArray = Item.getAllItems();
   a.m_equippedSword=itemArray[8];
   return(a.getEquippedSword()==itemArray[8]);
 }

 /**
 * Test ensures that equipSword() function equips an item in the case that that item is of the correct type
 * @precondition - equipSword has definition and is compatable with item class
 * @post - none;
 * @return true if passed false else
 */
 public boolean RPGActorTest31()
 {
   RPGActor a = new RPGActor();
   Item[] itemArray = Item.getAllItems();
   a.equipSword(itemArray[14]);//good item passed in
   return(a.m_equippedSword==itemArray[14]);
 }

 /**
 * Test ensures that equipSword() function does not equip an item that is not of the right type
 * @precondition - equipSword() has definition and is compatable with item class
 * @post - none;
 * @return true if passed false else
 */
 public boolean RPGActorTest32()
 {
   RPGActor a = new RPGActor();
   Item[] itemArray = Item.getAllItems();
   a.equipSword(itemArray[14]);//good item passed in that should be accepted
   a.equipSword(itemArray[15]);//bad item passed in that should be rejected
   return(a.m_equippedSword==itemArray[14]);//checks that the good item is equipped which means the bad item was ignored
 }

 /**
 * Test ensures that getEquippedShield() function returns correct value
 * @precondition - getEquippedShield() has definition, is compatable with item class, and RPGActor constructor works
 * @post - none;
 * @return true if passed false else
 */
 public boolean RPGActorTest33()
 {
   RPGActor a = new RPGActor();
   Item[] itemArray = Item.getAllItems();
   a.m_equippedShield=itemArray[15];
   return(a.getEquippedShield()==itemArray[15]);
 }

 /**
 * test ensures taht equipShield() method equips an item if it is of the right type
 * @precondition - equipShield() has definiton, is compatable with item class, and RPGActor constructor works
 * @post - none;
 * @ return true if passed false else
 */
 public boolean RPGActorTest34()
 {
   RPGActor a = new RPGActor();
   Item[] itemArray = Item.getAllItems();
   a.equipShield(itemArray[15]);
   return(a.m_equippedShield==itemArray[15]);
 }

 /**
 * test ensures that equipShield() method does not equip an item if it is of the wrong type
 * @precondition - equipShield() has definition, is compatable with item calss and RPGActor constructor works
 * @post - none;
 * @return true if passed false else
 */
 public boolean RPGActorTest35()
 {
   RPGActor a = new RPGActor();
   Item[] itemArray = Item.getAllItems();
   a.equipShield(itemArray[15]);//good item passed that should be accepted
   a.equipShield(itemArray[14]);//bad item passed that shoud be rejected
   return(a.m_equippedShield==itemArray[15]);
 }

 /**
 * test ensures that getEquippedArmor returns the correct value
 * @precondition - getEquippedArmor() has definiton, is compatable with item class, and RPGActor constructor works
 * @post - none;
 * @return true if passed false else
 */
 public boolean RPGActorTest36()
 {
   RPGActor a = new RPGActor();
   Item[] itemArray = Item.getAllItems();
   a.m_equippedArmor = itemArray[16];//sets equipped armor to good value
   return(a.getEquippedArmor()==itemArray[16]);
 }

 /**
 * test ensures that equipArmor() equips an item if it is of the right type
 * @precondition - equipArmor() has definition, is compatable with item class, and RPGActor constructor works
 * @post - none;
 * @return true if passed false else
 */
 public boolean RPGActorTest37()
 {
   RPGActor a = new RPGActor();
   Item[] itemArray = Item.getAllItems();
   a.equipArmor(itemArray[16]);
   return(a.m_equippedArmor==itemArray[16]);
 }

 /**
 * test ensures that equipArmor() equips fails to equip an item if it is of the wrong type
 * @precondition - equipArmor() has definition, is compatable with item class, and RPGActor constructor works
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest38()
 {
   RPGActor a = new RPGActor();
   Item[] itemArray = Item.getAllItems();
   a.equipArmor(itemArray[16]);//good item should be accepted
   a.equipArmor(itemArray[14]);//bad item should be rejected
   return(a.m_equippedArmor==itemArray[16]);
 }

 /**
 * test ensures that getEquippedHelmet returns the correct value
 * @precondition - getEquippedHemlet()  has definition, is compatable with item class, and RPGActor constructor works
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest39()
 {
   RPGActor a = new RPGActor();
   Item[] itemArray = Item.getAllItems();
   a.m_equippedHelmet = itemArray[17];
   return(a.getEquippedHelmet()==itemArray[17]);
 }

 /**
 * test ensures that equipHelmet() equips an item if it is of the right type
 * @precondition - equipHelmet() has definition, is compatable with item class, and RPGActor contructor works
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest40()
 {
   RPGActor a = new RPGActor();
   Item[] itemArray = Item.getAllItems();
   a.equipHelmet(itemArray[17]);
   return(a.m_equippedHelmet==itemArray[17]);
 }

 /**
 * test ensures that equipHelmet() rejects an item of the wrong type
 * @precondition - equipHelmet() has definition, is compatable with item class, and RPGActor constructor works
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest41()
 {
   RPGActor a = new RPGActor();
   Item[] itemArray = Item.getAllItems();
   a.equipHelmet(itemArray[17]);//good item should be accepted
   a.equipHelmet(itemArray[16]);
   return(a.m_equippedHelmet==itemArray[17]);
 }

 /**
 * test ensures that getDescription returns m_description
 * @precondition - getDescritpion() has definition, RPGActor has working constructor
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest42()
 {
   RPGActor a = new RPGActor();
   a.m_description="asdf";
   return(a.getDescription().equals("asdf"));
 }

 /**
 * test ensures that setDescription sets properly
 * @precondition - setDescription() has definition, RPGActor has working constructor
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest43()
 {
   RPGActor a = new RPGActor();
   a.setDescription("asdf");
   return(a.m_description.equals("asdf"));
 }

 /**
 * test ensures that getEquippedGauntlets returns the correct value
 * @precondition - getEquippedGauntlets has definition that is compatable with item class, and RPGActor constructor works
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest44()
 {
   RPGActor a = new RPGActor();
   Item[] itemArray = Item.getAllItems();
   a.m_equippedGauntlets=itemArray[18];
   return(a.getEquippedGauntlets()==itemArray[18]);
 }

 /**
 * test ensures that equipGauntlets() equips items of the right type
 * @precondition - equipGauntlets() has definition that works with item, RPGActor has working constructor
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest45()
 {
   RPGActor a = new RPGActor();
   Item[] itemArray = Item.getAllItems();
   a.equipGauntlets(itemArray[18]);
   return(a.m_equippedGauntlets==itemArray[18]);
 }

 /**
 * test ensures that equipGauntlets() fails to equip items of the wrong type
 * @precondition - equipGauntlets() has definition that works with item, RPGActor has working constructor
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest46()
 {
   RPGActor a = new RPGActor();
   Item[] itemArray = Item.getAllItems();
   a.equipGauntlets(itemArray[18]);
   a.equipGauntlets(itemArray[14]);
   return(a.m_equippedGauntlets==itemArray[18]);
 }

 /**
 * test ensures that getBoots returns the correct value
 * @precondition - getBoots() has working definition and RPGActor has working constructor
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest47()
 {
   RPGActor a = new RPGActor();
   Item[] itemArray = Item.getAllItems();
   a.m_equippedBoots = itemArray[19];
   return(a.getEquippedBoots()==itemArray[19]);
 }

 /**
 * test ensures that equipBoots() properly equipps an item of the right type
 * @precondition - equipBoots() has working definition and RPGActor has woking constructor
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest48()
 {
   RPGActor a = new RPGActor();
   Item[] itemArray = Item.getAllItems();
   a.equipBoots(itemArray[19]);
   return(a.m_equippedBoots==itemArray[19]);
 }

 /**
 * test ensures that equipBoots() rejects item of incorrect type
 * @precondition - equipBoots() has working definition and RPGActor has working constructor
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest49()
 {
   RPGActor a = new RPGActor();
   Item[] itemArray = Item.getAllItems();
   a.equipBoots(itemArray[19]);
   a.equipBoots(itemArray[18]);
   return(a.m_equippedBoots==itemArray[19]);
 }

 /**
 * test ensures that reduceHp works properly if the actor does not die
 * @precondition - instance of RPGActor
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest50()
 {
    RPGActor a = new RPGActor();
    a.m_curHp=100;
    return(!reduceHp(53)&&a.m_curHp==47);
 }

 /**
 * test ensures that reduceHp works properly if the actor dies
 * @precondition - instance of RPGActor
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest51()
 {
   RPGActor a = new RPGActor();
   a.m_curHp=100;
   return(reduceHp(101));
 }

 /**
 * test ensures that basicAttack() returns false if opponent lives
 * @precondition - two instances of RPGActor
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest52()
 {
   RPGActor a = new RPGActor();
   a.m_atk=50;
   RPGActor b = new RPGActor();
   return(!a.basicAttack(b));
 }

 /**
 * test ensures that basicAttack() returns true if opponent dies
 * @precondition - two instances of RPGActor
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest53()
 {
   RPGActor a = new RPGActor();
   a.m_atk=200;
   RPGActor b = new RPGActor();
   return(a.basicAttack(b));
 }

 /**
 * test ensures that getAttackFighter() returns appropriately
 * @precondition - RPGActor constructor is functional
 * @post - none
 * @return true if passed false else
 */
 public boolean RPGActorTest54()
 {
   RPGActor a = new RPGActor();
   return(a.getAttackFighter()==((int)((a.getAtk()+a.m_equippedSword.getBonusAtk()+a.m_equippedShield.getBonusAtk()+a.m_equippedHelmet.getBonusAtk()+a.m_equippedBoots.getBonusAtk() + a.m_equippedGauntlets.getBonusAtk())*a.getAtkModifier())));
 }

 /**
 * test ensures that getDefenseFighter() returns appropriately
 * @precondition - RPGActor constructor is functional
 * @post - none
 * @return trueif passed false else
 */
 public boolean RPGActorTest55()
 {
   RPGActor a = new RPGActor();
   return(a.getDefenseFighter()==((int)((a.getDef()+a.m_equippedSword.getBonusDef()+a.m_equippedShield.getBonusDef()+a.m_equippedHelmet.getBonusDef()+a.m_equippedBoots.getBonusDef()+a.m_equippedGauntlets.getBonusDef())*a.getDefModifier())));
 }
}

