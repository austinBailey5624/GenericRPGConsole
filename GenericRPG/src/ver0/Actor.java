package ver0;

public class Actor 
{
	Item[] itemSet = Item.getAllItems();
	private String m_name;
	private String m_description;
	private int m_level;
	private int m_maxHp;//max Hit Points
	private int m_curHp;//current Hit Points
	private int m_atk;
	private int m_matk;
	private double m_atkModifier;
	private double m_matkModifier;
	private int m_def;
	private int m_mdef;
	private double m_defModifier;
	private double m_mdefModifier;
	private Item m_equippedSword;
	private Item m_equippedShield;
	private Item m_equippedArmor;
	private Item m_equippedHelmet;
	protected int[] m_status;
	protected boolean[] m_skillSet;
	//Constructors
	public Actor()//default constructor
	{
		Item[] itemArray = Item.getAllItems();
		m_level=1;
		m_maxHp=100;
		m_curHp=100;
		m_atk=10;
		m_matk=10;
		m_atkModifier=1;
		m_matkModifier=1;
		m_def=10;
		m_mdef=10;
		m_defModifier=1;
		m_mdefModifier=1;
		m_status=new int[4];
		for(int i=0;i<m_status.length;i++)
		{
			m_status[i]=0;
		}

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
     * @precondition - Actor Object exists
     * @post - none
     * @return m_skillSet
     */
	public boolean[] getSkillset()
	{
		return m_skillSet;
	}
	
    /**
     * This function returns the value of m_name
     * @precondition - Actor Object exists
     * @post - none
     * @return m_name
     */
	public String getName()
	{
		return m_name;
	}
	
    /**
     * This function sets the value of m_name
     * @precondition - Actor Object exists
     * @post - changes m_name to parameter String name
     * @return void
     */
	public void setName(String name)
	{
		m_name=name;
	}
	
    /**
     * This function returns the value of m_level
     * @precondition - Actor Object exists
     * @post - none
     * @return m_level
     */
	public int getLevel()
	{
		return m_level;
	}
	
    /**
     * This function sets the value of m_level
     * @precondition - Actor Object exists
     * @post - sets m_level to parameter int level
     * @return void
     */
	public void setLevel(int level)
	{
		m_level=level;
	}
	
    /**
     * This function returns the value of m_maxHp
     * @precondition - Actor Object exists
     * @post - none
     * @return m_maxHp
     */
	public int getMaxHp()
	{
		return m_maxHp;
	}
	
    /**
     * This function sets the value of m_maxHp
     * @precondition - Actor Object exists
     * @post - sets m_maxHp to parameter int maxHP
     * @return void
     */
	public void setMaxHp(int maxHP)
	{
		m_maxHp=maxHP;
	}
	
    /**
     * This function returns the value of m_CurHp
     * @precondition - Actor Object exists
     * @post - none
     * @return m_curHp
     */
	public int getCurHp()
	{
		return m_curHp;
	}
	
    /**
     * This function sets the value of m_CurHp
     * @precondition - Actor Object exists
     * @post - sets m_curHp to parameter int curHp
     * @return void
     */
	public void setCurHp(int curHp)
	{
		m_curHp=curHp;
	}
	
    /**
     * This function returns the value of m_atk
     * @precondition - Actor Object exists
     * @post - none
     * @return m_atk
     */
	public int getAtk()
	{
		return m_atk;
	}
	
    /**
     * This function sets the value of m_atk
     * @precondition - Actor Object exists
     * @post - sets m_atk to parameter int Atk
     * @return void
     */
	public void setAtk(int Atk)
	{
		m_atk=Atk;
	}
	
	/**
	 * This function gets the value of m_matk
	 * @precondition -	Actor Object Exists with a set value for m_matk
	 * @postcondition - member variables unchanged
	 * @return -		The value of m_matk
	 */
	public int getMatk()
	{
		return m_matk;
	}
	
	/**
	 * This function sets the value of m_matk
	 * @precondition - 	Actor Object Exists
	 * @postcondition - sets m_matk to parameter
	 * @return -		void
	 */
	public void setMatk(int matk)
	{
		m_matk=matk;
	}
	
    /**
     * This function returns the value of m_atkModifier
     * @precondition - Actor Object exists
     * @post - none
     * @return m_atkModifier
     */
	public double getAtkModifier()
	{
		return m_atkModifier;
	}
	
    /**
     * This function sets the value of m_atkModifier
     * @precondition - Actor Object exists
     * @post - sets the value of m_atkModifer and ensures it is within acceptable parameters
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
	 * This function returns the value of m_matkModifier
	 * @precondition - 	Actor object exists with initialized value for m_matkModifier
	 * @postcondition - Does not change member variables
	 * @return -		m_matkModifier
	 */
	public double getMatkModifier()
	{
		return m_matkModifier;
	}
	
	/**
	 * This function sets the value of m_matkModifier
	 * @precondition - 	Actor object exists
	 * @postcondition - Sets m_matkModifier to parameter
	 * @return - 		void
	 */
	public void setMatkModifier(double matkModifier)
	{
		m_matkModifier=matkModifier;
	}
	
    /**
     * This function returns the value of m_def
     * @precondition - Actor Object exists
     * @post - none
     * @return m_def
     */
	public int getDef()
	{
		return m_def;
	}
	
    /**
     * This function sets the value of m_def
     * @precondition - Actor Object exists
     * @post - sets the value of m_def to paramter int Def
     * @return void
     */
	public void setDef(int Def)
	{
		m_def=Def;
	}
	
	/**
	 * This function returns the value of m_mdef
	 * @precondition - 	Actor Object exists with set m_mdef
	 * @postcondition - does not change member variables
	 * @return - 		m_mdef
	 */
	public int getMdef()
	{
		return m_mdef;
	}
	
	/**
	 * This function sets the value of m_mdef
	 * @precondition - 	Actor Object exists
	 * @postcondition - sets m_mdef to parameter mdef
	 * @return -		void
	 */
	public void setMdef(int mdef)
	{
		m_mdef=mdef;
	}
	
    /**
     * This function returns the value of m_defModifier
     * @precondition - Actor Object exists
     * @post - none
     * @return m_defModifier
     */
	public double getDefModifier()
	{
		return m_defModifier;
	}
	
    /**
     * This function sets the value of m_defModifier and ensures it is within an acceptable range
     * @precondition - Actor Object exists
     * @post - m_defModifier is set to parameter double DefenseModifier unless unacceptable, then value approximated
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
	 * This function returns the value of m_mdefModifer
	 * @precondition - 	Actor object exists with set value for m_mdefModifier
	 * @postcondition -	does not change member variables
	 * @return - 		m_mdefModifier
	 */
	public double getMdefModifier()
	{
		return m_mdefModifier;
	}
	
	/**
	 * This function sets the value of m_mdefModifier
	 * @precondition - 	Actor object exists
	 * @postcondition - sets m_mdefModifier to parameter
	 * @return - 		void
	 */
	public void setMdefModifier(double mdefModifier)
	{
		m_mdefModifier=mdefModifier;
	}
	
    /**
     * This function returns the Item m_equippedSword
     * @precondition - Actor Object exists
     * @post - none
     * @return m_equippedSword
     */
	public Item getEquippedSword()
	{
		return m_equippedSword;
	}
	
    /**
     * This function attempts to set the Item m_equippedSword to the parameter Item sword
     * @precondition - Actor Object exists
     * @post - sets m_equippedSword to parameter Item sword if the item is a sword, else prints message "Cannot equip that in the sword slot!"
     * @return void
     */
	public void equipSword(Item weapon)
	{
		if(weapon.getType()==1)
		{
			m_equippedSword=weapon;
		}
		else if(weapon.getType()==5)
		{
			m_equippedSword=weapon;
		}
		if((weapon.getType()==6)&&(m_equippedArmor==null))
		{
			m_equippedSword=weapon;
		}
		else
		{
			System.out.println("Cannot equip that in the weapon slot!");
		}
	}
	
    /**
     * This function returns the Item m_equippedShield
     * @precondition - Actor Object exists
     * @post - none
     * @return m_equippedShield
     */
	public Item getEquippedShield()
	{
		return m_equippedShield;
	}
	
    /**
     * This function attempts to set the Item m_equippedShield to the parameter Item shield
     * @precondition - Actor Object exists
     * @post - sets m_equippedShield to parameter Item shield if the item is a shield, else prints message "Cannot equip that in the shield slot!"
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
     * This function returns the Item m_equippeArmor
     * @precondition - Actor Object exists
     * @post - none
     * @return m_equippedArmor
     */
	public Item getEquippedArmor()
	{
		return m_equippedArmor;
	}
	
    /**
     * This function attempts to set the Item m_equippedArmor to the parameter Item armor
     * @precondition - Actor Object exists
     * @post - sets m_equippedArmor to parameter Item armor if the item is a armor, else prints message "Cannot equip that in the armor slot!"
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
     * @precondition - Actor Object exists
     * @post - none
     * @return m_equippedArmor
     */
	public Item getEquippedHelmet()
	{
		return m_equippedHelmet;
	}
	
    /**
     * This function attempts to set the Item m_equippedHelmet to the parameter Item helmet
     * @precondition - Actor Object exists
     * @post - sets m_equippedHelmet to parameter Item helmet if the item is a helmet, else prints message "Cannot equip that in the Helmet slot!"
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
     * @precondition - Actor Object exists
     * @post - none
     * @return m_equippedGauntlets
     */
//	public Item getEquippedGauntlets()
//	{
//		return m_equippedGauntlets;
//	}
	
    /**
     * This function attempts to set the Item m_equippedGauntlets to the parameter Item gauntlets
     * @precondition - Actor Object exists
     * @post - sets m_equippedGauntlets to parameter Item gauntlets if the item is a gauntlets, else prints message "Cannot equip that in the Gauntlet slot!"
     * @return void
     */
//	public void equipGauntlets(Item gauntlets)
//	{
//		if(gauntlets.getType()==5)
//		{
//			m_equippedGauntlets=gauntlets;
//		}
//		else
//		{
//			System.out.println("Cannot equip that in the Gauntlet slot!");
//		}
//	}
	
	/**
	 * This function returns the value of m_description
	 * @precondition -	Actor Object Exists
	 * @post - 			does not change member variables
	 * @return-			returns the value of m_description
	 */
	public String getDescription()
	{
		return m_description;
	}
	
	/**
	 * This function sets the value of m_description to String given
	 * @precondition - 	Actor Object Exists
	 * @post - 			changes m_description to the string given in the parameter
	 * @return -		void
	 */
	public void setDescription(String given)
	{
		m_description=given;
	}
	
    /**
     * This function returns the Item m_equippedBoots
     * @precondition - Actor Object exists
     * @post - none
     * @return m_equippedBoots
     */
//	public Item getEquippedBoots()
//	{
//		return m_equippedBoots;
//	}
	
    /**
     * This function attempts to set the Item m_equippedBoots to the parameter Item boots
     * @precondition - Actor Object exists
     * @post - sets m_equippedBoots to parameter Item Boots if the items are boots, else prints message "Cannot equip that in the Boots slot!"
     * @return void
     */
//	public void equipBoots(Item boots)
//	{
//		if(boots.getType()==6)
//		{
//			m_equippedBoots=boots;
//		}
//		else
//		{
//			System.out.println("Cannot equip that in the Boots slot!");
//		}
//	}
	
	//Battle Methods
    /**
     * This function reduces the hp of the actor by the parameter int damage
     * @precondition - Actor Object exists
     * @post - reduces m_curHp by damage, if after m_curHp is >0 returns false, else true
     * @return false if actor is alive, true if dead
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
     * @precondition - Actor Object exists
     * @post - reduces m_curHp by damage, if after m_curHp is >0 returns false, else true
     * @return false if actor is alive, true if dead
     */
	public boolean basicAttack(Actor opponent)
	{
		return opponent.reduceHp(this.getAtk());
	}
	
	//getters and setters for battle that have the alteration from the items in addition to the basics
    /**
     * Returns the atk value to be used by battle methods that includes modifiers from all items
     * @precondition - Actor Object exists
     * @post - none
     * @return m_atk plus bonus attack from all equipped items
     */
	public int getAttackFighter()
	{
		if((m_equippedSword != null)&&(m_equippedShield != null)&&(m_equippedHelmet != null)&&(m_equippedArmor != null))
		{
			return ((int)((getAtk()+m_equippedSword.getBonusAtk()+m_equippedShield.getBonusAtk()+m_equippedHelmet.getBonusAtk()+m_equippedArmor.getBonusAtk())*getAtkModifier()));		
		}
		else
		{
			return (getAtk());
		}
	}
	
    /**
     * Returns the def value to be used by the battle methods that includes modifiers from all items
     * @precondition - Actor Object exists
     * @post - none
     * @return m_def plus bonus def from all equipped items
     */
	public int getDefenseFighter()
	{
		if((m_equippedSword != null)&&(m_equippedShield != null)&&(m_equippedHelmet != null)&&(m_equippedArmor != null))
		{
			return ((int)((getDef()+m_equippedSword.getBonusDef()+m_equippedShield.getBonusDef()+m_equippedHelmet.getBonusDef()+m_equippedArmor.getBonusDef())*getDefModifier()));
		}
		else
		{
			return (getDef());
		}
	}
	
	/**
	 * Returns the mAtk value to be used by battle methods that includes modifiers from all items
	 * @precondition -	Actor Object exists
	 * @postcondition -	does not change member variables
	 * @return -		m_matk plus bonus matk from all equipped items
	 */
//	public int getMAttackFighter()//not ready for implementation
//	{
//		if(m_equippedSword == null)
//		{
//			return((int)((getMatk())*getMatkModifier()));
//		}
//		else
//		{
//			return((int)((getMatk()+m_equippedSword.getBonusMAtk()+m_equippedShield.getBonusMAtk()+m_equippedHelmet.getBonusMAtk())*getMatkModifier()));
//		}
//	}
//	
//	/**
//	 * Returns the mDef value to be used by battle methods that includes modifier from all relevant items
//	 * @precondition - 	Actor Object exists
//	 * @postcondition - does not change member variables
//	 * @return - 		m_def plus bonus mdef from all equipped items
//	 */
//	public int getMDefenseFighter()
//	{
//		if(m_equippedSword == null)
//		{
//			return((int)((getMdef())*getMdefModifier()));
//		}
//		else
//		{
//			return((int)((getMdef()+m_equippedSword.getBonusMDef()+m_equippedShield.getBonusDef()+m_equippedHelmet.getBonusMDef())*getMdefModifier()));
//		}
//	}
}
