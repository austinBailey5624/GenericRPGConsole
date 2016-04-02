package ver0;

public class Skill 
{
	//Member Variables
	private String m_name;
	private String m_description;
	private boolean m_targetsEnemy;
	private int m_id;
	private int m_damage;
	private int m_healthBonus;
	private double m_attackModifier;
	private double m_defenseModifier;
	private double m_accuracy;
	static int m_numOfSkills=0;
	static int m_numOfSkillsTotal=8;
	
	public static int getNumOfSkillsTotal()
	{
		return m_numOfSkillsTotal;
	}
	//Item creator
	public static Skill[] getSkills()
	{
		Skill[] skillSet = new Skill[m_numOfSkillsTotal];
		for(int i=0; i<8; i++)
		{
			skillSet[i]=new Skill();
		}
		return skillSet;
	}

	//Constructor
//	public Skill(Actor User,Actor Target)
	public Skill()
	{
		m_damage=0;
		m_healthBonus=0;
		m_attackModifier=0;
		m_defenseModifier=0;
		m_accuracy=.8;
		if(m_numOfSkills==0)
		{
			m_name="Basic Attack";
			m_description="A basic attack";
			m_targetsEnemy=true;
//			if((User.getAttackFighter()-(.5*Target.getDefenseFighter())>0))
//			{
//				m_damage=(int) (User.getAttackFighter()-(.5*Target.getDefenseFighter()));
//			}
//			else
//			{
//				m_damage=1;
//			}
		}
		else if(m_numOfSkills==1)
		{
			m_name="Power Attack";
			m_description="A very strong attack that is not very accurate";
			m_targetsEnemy=true;
//			if((1.5)*User.getAttackFighter()-.5*Target.getDefenseFighter()>0)
//			{
//				m_damage=(int)((1.5)*User.getAttackFighter()-.5*Target.getDefenseFighter());
//			}
//			else
//			{
//				m_damage=1;
//			}
			m_accuracy=.7;
		}
		else if(m_numOfSkills==2)
		{
			m_name="Threading Needle";
			m_description="A very accurate attack whose attack power is reduced";
			m_targetsEnemy=true;
//			if(.8*User.getAttackFighter()-.5*Target.getDefenseFighter()>0)
//			{
//				m_damage=(int)(.8*User.getAttackFighter()-.5*Target.getDefenseFighter());
//			}
//			else
//			{
//				m_damage=1;
//			}
		}
		else if(m_numOfSkills==3)
		{
			m_name="Shell";
			m_description="Increase defense or the remainder of the battle";
			m_targetsEnemy=false;
			m_attackModifier=1;
			m_defenseModifier=1.2;
			m_accuracy=1;
		}
		else if(m_numOfSkills==4)
		{
			m_name="Heal";
			m_description="Heals the caster for half their attack value";
			m_targetsEnemy=false;
//			m_healthBonus=(int) .5*User.getAttackFighter();
		}
		else if(m_numOfSkills==5)
		{
			m_name="Strengthen";
			m_description="Increases the user's attack power for the duration of the battle";
			m_targetsEnemy=false;
			m_attackModifier=1.2;
		}
		else if(m_numOfSkills==6)
		{
			m_name="Penetrating Strike";
			m_description="Deals a reduced amount of damage but ignores a targets armor";
			m_targetsEnemy=true;
	//		m_damage=(int) .5*User.getAttackFighter();
		}
		else if(m_numOfSkills==7)
		{
			m_name="Blood Ritual";
			m_description="Attack yourself for an increase in attack damage";
			m_targetsEnemy=false;
//			m_damage=(int) .5*User.getAttackFighter();
			m_attackModifier=1.35;
		}
		else if(m_numOfSkills==8)
		{
			m_name="Berserker Rage";
			m_description="When you are below half health, increase your attack power. Does nothing if above half health";
			m_targetsEnemy=false;
//			if((.5)*User.getCurHp()<=User.getMaxHp())
//			{
//				m_attackModifier=1.3;
//			}
		}
		m_id=m_numOfSkills;
		m_numOfSkills++;
	}
	
	
	
	//Getters and Setters
	public String getName()
	{
		return m_name;
	}
	public void setName(String name)
	{
		m_name=name;
	}
	public String getDescription()
	{
		return m_description;
	}
	public void setDescription(String description)
	{
		m_description=description;
	}
	public boolean getTargetsEnemy()
	{
		return m_targetsEnemy;
	}
	public void setTargetsEnemy(boolean targetsEnemy)
	{
		m_targetsEnemy=targetsEnemy;
	}
	public int getId()
	{
		return m_id;
	}
	public void setId(int id)
	{
		m_id=id;
	}
	public int getDamage()
	{
		return m_damage;
	}
	public void setDamage(int damage)
	{
		m_damage=damage;
	}
	public int getHealthBonus()
	{
		return m_healthBonus;
	}
	public void setHealthBonus(int healthBonus)
	{
		m_healthBonus=healthBonus;
	}
	public double getAttackModifier()
	{
		return m_attackModifier;
	}
	public void setAttackModifier(double attackModifier)
	{
		m_attackModifier=attackModifier;
	}
	public double getAccuracy()
	{
		return m_accuracy;
	}
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
