package ver0;

public class Weapon extends Item
{
	private int m_skill;
	
	/**
     * This function is the constructor for the different weapons
     * pre - needs the parameters down below
     * post - creates a weapon
     * Returns - an weapon based off of the integer given.
     * @param typeOfWeapon takes in an int in order to create the weapon
     */
	public Weapon(int typeOfWeapon)
	{
		m_limit = 0;
        m_id = 0;
        m_bonusDef = 0;
        m_bonusAtk = 0;
        m_bonusMDef = 0;
        m_bonusMAtk = 0;
        m_bonusHp = 0;
        m_value = 0;
        m_counter = 0;
        m_skill = 0;
        
        m_name = "";
        m_used = false;
        
		if(typeOfWeapon == 9)
        {
        	m_type = typeOfWeapon;
            m_name = "iron sword";
            m_limit = 10;
            m_bonusDef = 0;
            m_bonusAtk = 10;
            m_bonusMDef = 0;
            m_bonusMAtk = 0;
            m_bonusHp = 0;
            m_value = 10;
            m_counter = 0;
            m_skill = 0;
        }
        else if(typeOfWeapon == 10)
        {
            m_type = typeOfWeapon;
            m_name = "steel sword";
            m_limit = 5;
            m_bonusDef = 0;
            m_bonusAtk = 50;
            m_bonusMDef = 0;
            m_bonusMAtk = 0;
            m_bonusHp = 0;
            m_value = 50;
            m_counter = 0;
            m_skill = 0;
        }
        else if(typeOfWeapon == 11)
        {
            m_type = typeOfWeapon;
            m_name = "master sword";
            m_limit = 1;
            m_bonusDef = 0;
            m_bonusAtk = 500;
            m_bonusMDef = 0;
            m_bonusMAtk = 0;
            m_bonusHp = 0;
            m_value = 100;
            m_counter = 0;
            m_skill = 0;
        }
        else if(typeOfWeapon == 12)
        {
            m_type = typeOfWeapon;
            m_name = "birch wand";
            m_limit = 10;
            m_bonusDef = 0;
            m_bonusAtk = 0;
            m_bonusMDef = 0;
            m_bonusMAtk = 50;
            m_bonusHp = 0;
            m_value = 10;
            m_counter = 0;
            m_skill = 1;
        }
        else if(typeOfWeapon == 13)
        {
            m_type = typeOfWeapon;
            m_name = "oak wand";
            m_limit = 5;
            m_bonusDef = 0;
            m_bonusAtk = 0;
            m_bonusMDef = 0;
            m_bonusMAtk = 100;
            m_bonusHp = 0;
            m_value = 50;
            m_counter = 0;
            m_skill = 2;
        }
        else if(typeOfWeapon == 14)
        {
            m_type = typeOfWeapon;
            m_name = "elm wand";
            m_limit = 1;
            m_bonusDef = 0;
            m_bonusAtk = 0;
            m_bonusMDef = 0;
            m_bonusMAtk = 500;
            m_bonusHp = 0;
            m_value = 100;
            m_counter = 0;
            m_skill = 3;
        }
        else if(typeOfWeapon == 15)
        {
            m_type = typeOfWeapon;
            m_name = "sickamore wand";
            m_limit = 3;
            m_bonusDef = 0;
            m_bonusAtk = 0;
            m_bonusMDef = 0;
            m_bonusMAtk = 30;
            m_bonusHp = 0;
            m_value = 50;
            m_counter = 0;
            m_skill = 4;
        }
        else if(typeOfWeapon == 16)
        {
            m_type = typeOfWeapon;
            m_name = "bolted staff";
            m_limit = 10;
            m_bonusDef = 0;
            m_bonusAtk = 20;
            m_bonusMDef = 0;
            m_bonusMAtk = 30;
            m_bonusHp = 0;
            m_value = 5;
            m_counter = 0;
            m_skill = 5;
        }
        else if(typeOfWeapon == 17)
        {
            m_type = typeOfWeapon;
            m_name = "birch staff";
            m_limit = 5;
            m_bonusDef = 0;
            m_bonusAtk = 0;
            m_bonusMDef = 0;
            m_bonusMAtk = 50;
            m_bonusHp = 0;
            m_value = 10;
            m_counter = 0;
            m_skill = 6;
        }
        else if(typeOfWeapon == 18)
        {
            m_type = typeOfWeapon;
            m_name = "oak staff";
            m_limit = 3;
            m_bonusDef = 0;
            m_bonusAtk = 0;
            m_bonusMDef = 0;
            m_bonusMAtk = 100;
            m_bonusHp = 0;
            m_value = 50;
            m_counter = 0;
            m_skill = 7;
        }
        else if(typeOfWeapon == 19)
        {
            m_type = typeOfWeapon;
            m_name = "elm staff";
            m_limit = 1;
            m_bonusDef = 0;
            m_bonusAtk = 0;
            m_bonusMDef = 0;
            m_bonusMAtk = 500;
            m_bonusHp = 0;
            m_value = 100;
            m_counter = 0;
            m_skill = 8;
        }
	}
	
	/**
     *This function returns the value of m_skill
     * pre - none
     * post - none
     * @return m_skill
     */
    public int getSkill()
    {
        return m_skill;
    }
}
