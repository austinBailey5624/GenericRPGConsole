package ver0;
import java.util.Random;

public class Skill 
{
	//Member Variables
	private String m_name;
	private String m_description;
	private boolean m_targetsEnemy;
	private boolean m_targetsMultiple;
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
	
	public Skill(int skillNum)
	{
		m_accuracy=.8;
		if(skillNum==0)
		{
			m_name="Basic Attack";
			m_description="A basic attack";
			m_targetsEnemy=true;
			m_targetsMultiple=false;
		}
		else if(skillNum==1)
		{
			m_name="Magic Bolt";
			m_description="A Basic magic bolt. Its blue and glowey, and it really hurts when you touch it";
			m_targetsEnemy=true;
			m_targetsMultiple=false;
		}
		else if(skillNum==2)
		{
			m_name="Poison Bolt";
			m_description="A basic magic bolt corrupted with rotten energy that has a 33% chance to posion for 4 turns";
			m_targetsEnemy=true;
			m_targetsMultiple=false;
		}
		else if(skillNum==3)
		{
			m_name="Stunning Bolt";
			m_description="A magic bolt laced with electric energy that has a 33% chance to stun for 4 turns";
			m_targetsEnemy=true;
			m_targetsMultiple=false;
		}
		else if(skillNum==4)
		{
			m_name="Cleanse";
			m_description="Magically heal yourself or an ally and weaken debuffs on them";
			m_targetsEnemy=false;
			m_targetsMultiple=false;
		}
		else if(skillNum==5)
		{
			m_name="Magic Slash";
			m_description="Deal magical and physical damage";
			m_targetsEnemy=true;
			m_targetsMultiple=false;
		}
		else if(skillNum==6)
		{
			m_name="Wide Burst";
			m_description="Deal magic damage to all enemies";
			m_targetsEnemy=true;
			m_targetsMultiple=true;
		}
		else if(skillNum==7)
		{
			m_name="Poison Burst";
			m_description="Deal magic Damage to all enemies with a chance to add a 3 turn poison debuff";
			m_targetsEnemy=true;
			m_targetsMultiple=true;
		}
		else if(skillNum==8)
		{
			m_name="Electric Burst";
			m_description="Deal magic Damage to all enemies with a chance to add a 3 turn stun debuff";
			m_targetsEnemy=true;
			m_targetsMultiple=true;
		}
		else if(skillNum==9)
		{
			m_name="Power Attack";
			m_description="A very strong attack that is not very accurate";
			m_targetsEnemy=true;
			m_targetsMultiple=false;
			m_accuracy=.7;
		}
		else if(skillNum==10)
		{
			m_name="Threading Needle";
			m_description="A very accurate attack whose attack power is reduced";
			m_targetsEnemy=true;
			m_targetsMultiple=false;
		}
		else if(skillNum==11)
		{
			m_name="Shell";
			m_description="Increase defense or the remainder of the battle";
			m_targetsEnemy=false;
			m_targetsMultiple=false;
			m_accuracy=1;
		}
		else if(skillNum==12)
		{
			m_name="Heal";
			m_description="Heals the caster for half their attack value";
			m_targetsEnemy=false;
			m_targetsMultiple=false;
		}
		else if(skillNum==13)
		{
			m_name="Strengthen";
			m_description="Increases the user's attack power for the duration of the battle";
			m_targetsEnemy=false;
			m_targetsMultiple=false;
		}
		else if(skillNum==14)
		{
			m_name="Penetrating Strike";
			m_description="Deals a reduced amount of damage but ignores a targets armor";
			m_targetsEnemy=true;
			m_targetsMultiple=false;
		}
		else if(skillNum==15)
		{
			m_name="Blood Ritual";
			m_description="Attack yourself for an increase in attack damage";
			m_targetsEnemy=false;
			m_targetsMultiple=false;
		}
		else if(skillNum==16)
		{
			m_name="Berserker Rage";
			m_description="When you are below half health, increase your attack power. Does nothing if above half health";
			m_targetsEnemy=false;
			m_targetsMultiple=false;
		}
		else if(skillNum==17)
		{
			m_name="Wolf Claw";
			m_description="A wolf lunges at you, scratching your face";
			m_targetsEnemy=true;
			m_targetsMultiple=false;
		}
		else if(skillNum==18)
		{
			m_name="Wolf Bite";
			m_description="A wolf bites you tearing the skin. More damage but less accurate";
			m_targetsEnemy=true;
			m_targetsMultiple=false;
		}
		else if(skillNum==19)
		{
			m_name="Wolf Howl";
			m_description="The wolf howls at the moon, increasing its attack";
			m_targetsEnemy=false;
			m_targetsMultiple=false;
		}
		m_id=skillNum;
		m_value=m_id*10;
	}
	
	public boolean Execute(Actor User, Actor Target)//Returns true if it hit, false if it didn't
	{
		Random r;
		r=new Random();
		int hit=r.nextInt(100);

		if(this.m_id==0)//Basic Attack
		{
			if(hit<85)
			{
				if((User.getAttackFighter()-(.5*Target.getDefenseFighter())>0))
				{
					Target.reduceHp((int) (User.getAttackFighter()-(.5*Target.getDefenseFighter())));
				}
				else
				{
					Target.reduceHp(1);
				}
				return true;
			}
			else
			{
				System.out.println("Basic attack missed!");
				return false;
			}
		}
		else if(this.m_id==1)//Magic Bolt
		{
			if(hit<85)
			{
				if((User.getMAttackFighter()-(.5*Target.getMDefenseFighter())>0))
				{
					Target.reduceHp((int) (User.getMAttackFighter()-(.5*Target.getMDefenseFighter())));
				}
				else
				{
					Target.reduceHp(1);
				}
				return true;
			}
			else
			{
				System.out.println("Magic Bolt missed!");
				return false;
			}
		}
		else if(this.m_id==2)//Poison Bolt
		{
			if(hit<85)
			{
				if((User.getMAttackFighter()-(.5*Target.getMDefenseFighter())>0))
				{
					Target.reduceHp((int) (User.getMAttackFighter()-(.5*Target.getMDefenseFighter())));
				}
				else
				{
					Target.reduceHp(1);
				}
				Target.m_status[0]+=4;//applies the debuff
				return true;
			}
			else
			{
				System.out.println("Poison Bolt missed!");
				return false;
			}
		}
		else if(this.m_id==3)//stunning bolt
		{
			if(hit<85)
			{
				if((User.getMAttackFighter()-(.5*Target.getMDefenseFighter())>0))
				{
					Target.reduceHp((int) (User.getMAttackFighter()-(.5*Target.getMDefenseFighter())));
				}
				else
				{
					Target.reduceHp(1);
				}
				Target.m_status[3]+=4;//applies the stun debuff
				return true;
			}
			else
			{
				System.out.println("Stunning Bolt missed!");
				return false;
			}
		}
		else if(this.m_id==4)//cleanse
		{
			if(Target.getCurHp()+User.getMAttackFighter()>Target.getMaxHp())//if healing the target would put them over their max hp
			{
				Target.setCurHp(Target.getMaxHp());//set their current hp to their max hp
			}
			else
			{
				Target.setCurHp(User.getMAttackFighter()+Target.getCurHp());
			}
			for(int i=0;i<Target.m_status.length;i++)//decreases all statuses by 2
			{
				if(Target.m_status[i]>2)
				{
					Target.m_status[i]-=2;
				}
				else
				{
					Target.m_status[i]=0;
				}
			}
		}
		else if(this.m_id==5)//magic slash
		{
			if(hit<85)
			{
				if((User.getAttackFighter()-(.5*Target.getDefenseFighter())+(User.getMAttackFighter()-(.5*Target.getMDefenseFighter())))*.6>0)
				{
					Target.reduceHp((int) ((User.getAttackFighter()-(.5*Target.getDefenseFighter())+(User.getMAttackFighter()-(.5*Target.getMDefenseFighter())))*.6));
				}
				else
				{
					Target.reduceHp(1);
				}
				return true;
			}
			else
			{
				System.out.println("Magic Slash missed!");
				return false;
			}
		}
		else if(this.m_id==6)//Wide Burst
		{
			if(hit<85)
			{
				if(((User.getMAttackFighter()-(.5*Target.getMDefenseFighter())*.7)>0))
				{
					Target.reduceHp((int) ((User.getMAttackFighter()-(.5*Target.getMDefenseFighter()))*.7));
				}
				else
				{
					Target.reduceHp(1);
				}
				return true;
			}
			else
			{
				System.out.println("Magic Burst missed!");
				return false;
			}
		}
		else if(this.m_id==7)//poison Burst
		{
			if(hit<85)
			{
				if(((User.getMAttackFighter()-(.5*Target.getMDefenseFighter())*.7)>0))
				{
					Target.reduceHp((int) ((User.getMAttackFighter()-(.5*Target.getMDefenseFighter()))*.7));
				}
				else
				{
					Target.reduceHp(1);
				}
				Target.m_status[0]+=3;
				return true;
			}
			else
			{
				System.out.println("Poison Burst missed!");
				return false;
			}
		}
		else if(this.m_id==8)//Electric Burst
		{
			if(hit<85)
			{
				if(((User.getMAttackFighter()-(.5*Target.getMDefenseFighter())*.7)>0))
				{
					Target.reduceHp((int) ((User.getMAttackFighter()-(.5*Target.getMDefenseFighter()))*.7));
				}
				else
				{
					Target.reduceHp(1);
				}
				Target.m_status[3]+=3;
				return true;
			}
			else
			{
				System.out.println("Electric Burst missed!");
				return false;
			}
		}
		else if(this.m_id==9)//Power Attack
		{
			if(hit<70)
			{
				if((1.5)*User.getAttackFighter()-.5*Target.getDefenseFighter()>0)
				{
					Target.reduceHp((int)((1.5)*User.getAttackFighter()-.5*Target.getDefenseFighter()));
				}
				else
				{
					Target.reduceHp(1);
				}
				return true;
			}
			else
			{
				System.out.println("Power attack missed!");
				return false;
			}
		}
		else if(this.m_id==10)//Threading Needle
		{
			if(.8*User.getAttackFighter()-.5*Target.getDefenseFighter()>0)
			{
				Target.reduceHp((int)(.8*User.getAttackFighter()-.5*Target.getDefenseFighter()));
			}
			else
			{
				Target.reduceHp(1);
			}
			return true;
		}
		else if(this.m_id==11)//shell
		{
			User.setDefenseModifier(1.2);
			return true;
		}
		else if(this.m_id==12)//heal
		{
			if(User.getCurHp()+(.5)*User.getAttackFighter()>User.getMaxHp())//The case where healing heals more than possible
			{
				User.setCurHp(User.getMaxHp());
			}
			else 
			{
				User.setCurHp((int)(User.getCurHp()+User.getAttackFighter()*.5));
			}
			return true;
		}
		else if(this.m_id==13)//strengthen
		{
			User.setAttackModifier(1.2);
			return true;
		}
		else if(this.m_id==14)
		{
			if(hit<=85)
			{
				Target.reduceHp((int)(.5*User.getAttackFighter()));//calculation doesn't regard the defense of the target
				return true;
			}
			else
			{
				System.out.println("Penetrating Strike missed!");
				return false;
			}
		}
		else if(this.m_id==15)
		{
			User.reduceHp((int)(User.getAttackFighter()));//attacking self is intentional, its payment for a boost in attack power
			User.setAttackModifier(1.35);
			return true;
		}
		else if(this.m_id==16)
		{
			if(User.getCurHp()<=(.5)*User.getMaxHp())
			{
				User.setAttackModifier(1.3);
				return true;
			}
			else
			{
				System.out.println("As you are not below half health, berserker rage does nothing");
			}
		}
		else if(this.m_id==17)
		{
			if(hit<=87)
			{
				if((User.getAttackFighter()-(.5*Target.getDefenseFighter())>0))
				{
					Target.reduceHp((int) (User.getAttackFighter()-(.5*Target.getDefenseFighter())));
				}
				else
				{
					Target.reduceHp(1);
				}
				return true;
			}
			else
			{
				System.out.println("Wolf Claw missed!");
				return false;
			}
		}
		else if(this.m_id==18)
		{
			if(hit<=73)
			{
				if((1.5)*User.getAttackFighter()-.5*Target.getDefenseFighter()>0)
				{
					Target.reduceHp((int)((1.5)*User.getAttackFighter()-.5*Target.getDefenseFighter()));
				}
				else
				{
					Target.reduceHp(1);
				}
				return true;
			}
			else
			{
				System.out.println("You successfully dodged Wolf Bite!");
				return false;
			}
		}
		else if(this.m_id==19)
		{
			User.setAttackModifier(1.2);
			System.out.println("The wolf is enraged by its howl and is now more aggressive");
			return true;
		}
		return false;
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
	 * @precondition:	Skill exists
	 * @postcondition:	does not change member variables
	 * @return:			The value of m_targetsMultiple
	 */
	public boolean getTargetsMultiple()
	{
		return m_targetsMultiple;
	}
	
	/**
	 * @precondition:	Skill exists
	 * @postcondition:	sets the value of m_targetsMultiple to targetsMultiple
	 * @return:			void	 
	 */
	public void setTargetsMultiple(boolean targetsMultiple)
	{
		m_targetsMultiple=targetsMultiple;
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
