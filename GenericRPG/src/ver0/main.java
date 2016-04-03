package ver0;

public class main 
{
	public static void main(String[] args)
	{
		Skill[] skillSet = Skill.getSkills();
		
		//gets all items and prepares them for use in main
		Item[] itemSet = Item.getAllItems();

		//System.out.println(itemSet[8].getName());
		//gets all enemies and prepares them for use in main
		EnemyActor[] enemySet = EnemyActor.getEnemies();
		
		
		
		System.out.println("Number of Items: " + Item.getNumTypesOfItem());
		System.out.println("Number of Skills: " + Skill.getNumOfSkillsTotal());
		System.out.println("Number of Enemies: " + EnemyActor.m_numOfEnemies);
		
		/*
		 * Battle Testing:
		 * 
		Actor a1=new Actor();
		Actor a2=new Actor();
		Battle battle=new Battle();
		
		Item basicsword=new Item(1);
		a1.EquipSword(basicsword);
		
		a1.setName("Jeff");
		a2.setName("Bob");
		battle.actorBattle(a1,a2);
		*/
	}
	
}
