package ver0;

public class main 
{
	public static void main(String[] args)
	{
		//gets all skills and sets them for use in main
		Skill[] skillSet = Skill.getSkills();
		
		//gets all items and prepares them for use in main
		Item[] itemSet = Item.getAllItems();
		
		//gets all enemies and prepares them for use in main
		EnemyActor[] enemySet = EnemyActor.getEnemies();
	}
}
