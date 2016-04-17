package ver0;

public class Test 
{
	
	public void runTests(boolean verbose)
	{
		if (verbose)
		{
			//display the results of every single test performed
		}
		else
		{
			//show a summary of tests that failed
		}
	}
	//ADD TESTS HERE-- THERE WILL BE ALOT make your test return true if functioning correctly, otherwise false
	

	public boolean battletestVerifyInt1() //if string passed in is an int, it return true
	{
		Battle myBattle=new Battle();
		return myBattle.verifyInt("5");
	}
	public boolean battletestVerifyInt2() //if string passed in is not an int, it returns false
	{
		Battle myBattle=new Battle();
		if (!myBattle.verifyInt("T"))
		{
			return true;
		}
		return false;
	}
	public boolean battletestisBattleOver1() //if one of the actors has no health, it returns true
	{
		Actor a1=new Actor();
		Actor a2=new Actor();
		Battle myBattle=new Battle();
		a1.setCurHp(0);
		return myBattle.isBattleOver(a1, a2);
	}
	public boolean battletestisBattleOver2() // if both actors have no health, it returns true
	{
		Actor a1=new Actor();
		Actor a2=new Actor();
		Battle myBattle=new Battle();
		a1.setCurHp(0);
		a2.setCurHp(0);
		return myBattle.isBattleOver(a1, a2);
	}
	public boolean battletestisBattleOver3() // if both players have health, it returns false
	{
		Actor a1=new Actor();
		Actor a2=new Actor();
		a1.setCurHp(a1.getMaxHp());
		a2.setCurHp(a2.getMaxHp());
		Battle myBattle=new Battle();
		return !(myBattle.isBattleOver(a1,a2));
	}
	public boolean battletestpotionsAvailable1() //if player has no potions, it returns false
	{
		Party a1=new Party();
		Battle myBattle=new Battle();
		return !(myBattle.potionsAvailable(a1));
	}
	public boolean battletestpotionsAvailable2() // if player has a potion, it returns true
	{
		Party a1=new Party();
		Battle myBattle=new Battle();
		a1.getInventory()[7]=1;
		a1.getInventory()[20]=1;
		a1.getInventory()[27]=1;
		return myBattle.potionsAvailable(a1);
	}
}
