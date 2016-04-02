
package ver0;
import java.util.Random;
import java.util.Scanner;
public class Battle 
{
	
	Random r;
	Scanner myScanner;
	int order;
	
	public static void main (String[] args)
	{
		Actor a1=new Actor();
		Actor a2=new Actor();
		actorBattle(a1,a2);
	}
	public Battle()
	{
		
	}
	public static void actorBattle(Actor a1, Actor a2)
	{
		
		while(!isBattleOver(a1,a2))
		{
			printBattleMenu();
		}
	}
	private static boolean isBattleOver(Actor a1, Actor a2)
	{
		if (a1.getCurHp()==0 || a2.getCurHp()==0)
		{
			return true;
		}
		return false;
	}
	private void attack(Actor attacker, Actor defender, boolean useItem)
	{
		
	}
	//returns number inclusively between min and max
	private int randomNumber(int min, int max)
	{
		return r.nextInt(max-min+1)+min;
	}
	private static void printBattleMenu()
	{
		System.out.println("It is your turn, choose one of the following to do:");
		System.out.println("1) Attack");
		System.out.println("2) Use Skill");
		System.out.println("3) Use Item");
		System.out.println("4) Run Run Run!");
	}
}
