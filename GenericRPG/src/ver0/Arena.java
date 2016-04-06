package ver0;
import java.util.Scanner;
public class Arena 
{
	EnemyActor[] enemySet = EnemyActor.getEnemies();
	int select;
	Scanner myScanner = new Scanner(System.in);
	int currentFightCeiling;
	int maxFight;
	
	public Arena(int whichArena)
	{
		if(whichArena==1)//in this arena you can only fight the first three enemies
		{
			maxFight=3;
		}
		else if(whichArena==2)//in this arena you can fight all the enemies
		{
			maxFight=enemySet.length;
		}
		currentFightCeiling=1;
	}
	
	public void Menu(PlayerActor character)
	{
		System.out.println("Welcome to the Arena");
		boolean exit=false;
		Battle myBattle = new Battle();
		while(!exit)
		{
			int indexRepresentedByChoice[]=new int[enemySet.length];
			int choice=1;
			System.out.println("Who will you fight?");
			for(int i=0; i< currentFightCeiling; i++)
			{
				System.out.println(choice + ") "  + enemySet[i].getName());
				choice++;
				indexRepresentedByChoice[choice]=i;
			}
			select=myScanner.nextInt();
			if(select<1||select>currentFightCeiling)
			{
				if(myBattle.actorBattle(character, enemySet[indexRepresentedByChoice[select]]))
				{
					System.out.println("Congratulations, you won! More difficult enemies come to the arena!");
					currentFightCeiling++;
				}
				else
				{
					//TODO: need to move to inn somehow?
					System.out.println("The guy who beats you took all your gold!\n But he used it to pay the inkeep to nurse you back to health");
				}
			}
		}
	}
}