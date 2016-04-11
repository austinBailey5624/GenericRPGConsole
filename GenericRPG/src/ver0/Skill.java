package ver0;

public class Skill 
{
	//Member Variables
	private String m_name;
	private String m_description;
	private boolean m_targetsEnemy;
	private int m_id;
	private double m_accuracy;
	private int m_value;

	static int m_numOfSkills=8;

	//static int m_numOfSkills=9;


	/**
	 * this function returns the total number of skills
	 * @precondition: 	none
	 * @postcondition:	does not change member variables
	 * @return:			m_numOfSkills
	 */
	public static int getNumOfSkillsTotal()
	{
		return m_numOfSkills;
	}
	//Item creator
	/**
	 * this function passes all of the skills to whatever calls it
	 * @precondition:	none
	 * @postcondition:	does not change member variables
	 * @return:			a set containing all skills
	 */
	public static Skill[] getSkills()
	{
		Skill[] skillSet = new Skill[8];
		for(int i=0; i<skillSet.length; i++)
		{
			skillSet[i]=new Skill(i);
		}
		return skillSet;
	}

	//Constructor
	/**
	 * This constructor generates a skill based on the number passed into it
	 * @precondition:	none
	 * @postcondition:	generates a skill
	 * @return:			a skill based on the number passed into the constuctor
	 * @param skillNum determines which skill is generated
	 */
	
	//TODO Skill 0 keep basic attack
	//TODO Skill 1 deal magic damage similar to basic attack except with magic damage
	//TODO Skill 2 deal magic damage with a 33% poison debuff added on
	//TODO Skill 3 deal magic damage with a 33% stun debuff added on
	//TODO Skill 4 heal self by 20 health and remove debuff for 2 turns
	//TODO Skill 5 deal magic damage and physical damage to enemies a combination of skill 0 and 1.
	//TODO Skill 6 deal magic damage to all enemies similar to skill 1 except the damage is 70% as strong
 	//TODO Skill 7 deal magic damage to all enemies similar to skill 1 except the damage is 70% as strong with a 33% poison debuff added on to all enemies
	//TODO Skill 8 deal magic damage to all enemies similar to skill 1 except the damage is 70% as strong with a 33% stun debuff added on to all enemies
	public Skill(int skillNum)
	{
		m_accuracy=.8;
		if(skillNum==0)
		{
			m_name="Basic Attack";
			m_description="A basic attack";
			m_targetsEnemy=true;
			m_id=0;

		}
		else if(skillNum==1)
		{
			m_name="Power Attack";
			m_description="A very strong attack that is not very accurate";
			m_targetsEnemy=true;

			m_accuracy=.7;
		}
		else if(skillNum==2)
		{
			m_name="Threading Needle";
			m_description="A very accurate attack whose attack power is reduced";
			m_targetsEnemy=true;

		}
		else if(skillNum==3)
		{
			m_name="Shell";
			m_description="Increase defense or the remainder of the battle";
			m_targetsEnemy=false;
			m_accuracy=1;
		}
		else if(skillNum==4)
		{
			m_name="Heal";
			m_description="Heals the caster for half their attack value";
			m_targetsEnemy=false;
		}
		else if(skillNum==5)
		{
			m_name="Strengthen";
			m_description="Increases the user's attack power for the duration of the battle";
			m_targetsEnemy=false;
		}
		else if(skillNum==6)
		{
			m_name="Penetrating Strike";
			m_description="Deals a reduced amount of damage but ignores a targets armor";
			m_targetsEnemy=true;
		}
		else if(skillNum==7)
		{
			m_name="Blood Ritual";
			m_description="Attack yourself for an increase in attack damage";
			m_targetsEnemy=false;
		}
		else if(skillNum==8)
		{
			m_name="Berserker Rage";
			m_description="When you are below half health, increase your attack power. Does nothing if above half health";
			m_targetsEnemy=false;

		}
		m_id=skillNum;
		m_value=m_id*10;
	}
	
	public void Execute(Actor User, Actor Target)
	{
		//TODO incorporate accuracy into calculation using random
		if(this.m_id==0)
		{
			if((User.getAttackFighter()-(.5*Target.getDefenseFighter())>0))
			{
				Target.reduceHp((int) (User.getAttackFighter()-(.5*Target.getDefenseFighter())));
			}
			else
			{
				Target.reduceHp(1);
			}
		}
		else if(this.m_id==1)
		{
			if((1.5)*User.getAttackFighter()-.5*Target.getDefenseFighter()>0)
			{
				Target.reduceHp((int)((1.5)*User.getAttackFighter()-.5*Target.getDefenseFighter()));
			}
			else
			{
				Target.reduceHp(1);
			}
		}
		else if(this.m_id==2)
		{
			if(.8*User.getAttackFighter()-.5*Target.getDefenseFighter()>0)
			{
				Target.reduceHp((int)(.8*User.getAttackFighter()-.5*Target.getDefenseFighter()));
			}
			else
			{
				Target.reduceHp(1);
			}
		}
		else if(this.m_id==3)
		{
			User.setDefenseModifier(1.2);
		}
		else if(this.m_id==4)
		{
			if(User.getCurHp()+(.5)*User.getAttackFighter()>User.getMaxHp())//The case where healing heals more than possible
			{
				User.setCurHp(User.getMaxHp());
			}
			else 
			{
				User.setCurHp((int)(User.getCurHp()+User.getAttackFighter()*.5));
			}
		}
		else if(this.m_id==5)
		{
			User.setAttackModifier(1.2);
		}
		else if(this.m_id==6)
		{
			Target.reduceHp((int)(.5*User.getAttackFighter()));//calculation doesn't regard the defense of the target
		}
		else if(this.m_id==7)
		{
			User.reduceHp((int)(User.getAttackFighter()));//attacking self is intentional, its payment for a boost in attack power
			User.setAttackModifier(1.35);
		}
		else if(this.m_id==8)
		{
			if(User.getCurHp()<=(.5)*User.getMaxHp())
			{
				User.setAttackModifier(1.3);
			}
		}
	}
	
	
	
	//Getters and Setters
	/**
	 * @precondition: 	Skill exists
	 * @postcondition:	values not changed
	 * @return:			the value of the skill
	 */
	public int getValue()
	{
		return m_value;
	}
	
	/**
	 * @precondition: 	Skill exists
	 * @postcondition:	sets the value of m_value to value
	 * @return:			void
	 */
	public void setValue(int value)
	{
		m_value=value;
	}
	
	/**
	 * @precondition: 	Skill exists
	 * @postcondition:	values not changed
	 * @return:			the name of the skill
	 */
	public String getName()
	{
		return m_name;
	}
	
	/**
	 * @precondition: 	Skill exists
	 * @postcondition:	sets the value of m_name to name
	 * @return:			void
	 */
	public void setName(String name)
	{
		m_name=name;
	}
	
	/**
	 * @precondition: 	Skill exists
	 * @postcondition:	values not changed
	 * @return:			the Description of the skill
	 */
	public String getDescription()
	{
		return m_description;
	}
	
	/**
	 * @precondition: 	Skill exists
	 * @postcondition:	sets the value of m_description to description
	 * @return:			void
	 */
	public void setDescription(String description)
	{
		m_description=description;
	}
	
	/**
	 * @precondition: 	Skill exists
	 * @postcondition:	values not changed
	 * @return:			if the skill targets the enemy
	 */
	public boolean getTargetsEnemy()
	{
		return m_targetsEnemy;
	}
	
	/**
	 * @precondition: 	Skill exists
	 * @postcondition:	sets the value of m_targetsEnemy to targetsEnemy
	 * @return:			void
	 */
	public void setTargetsEnemy(boolean targetsEnemy)
	{
		m_targetsEnemy=targetsEnemy;
	}

	/**
	 * @precondition: 	Skill exists
	 * @postcondition:	values not changed
	 * @return:			the id of the skill
	 */
	public int getId()
	{
		return m_id;
	}
	
	/**
	 * @precondition: 	Skill exists
	 * @postcondition:	sets the value of m_id to id
	 * @return:			void
	 */
	public void setId(int id)
	{
		m_id=id;
	}
	
	/**
	 * @precondition: 	Skill exists
	 * @postcondition:	values not changed
	 * @return:			the id of the skill
	 */
	public double getAccuracy()
	{
		return m_accuracy;
	}
	
	/**
	 * @precondition:	Skill exists
	 * @postcondition:	value of m_accuracy set to accuracy, within limitations
	 * @return:			void
	 */
	public void setAccuracy(double accuracy)
	{
		if(accuracy > 1)
		{
			m_accuracy=1;
		}
		else if(accuracy<0)
		{
			m_accuracy=0;
		}
		else
		{
			m_accuracy=accuracy;
		}
	}
}
