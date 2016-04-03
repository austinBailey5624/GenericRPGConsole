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
		
		
		
		//System.out.println("Number of Items: " + Item.getNumTypesOfItem());
		//System.out.println("Number of Skills: " + Skill.getNumOfSkillsTotal());
		//System.out.println("Number of Enemies: " + EnemyActor.m_numOfEnemies);
		
		
		 
		
		Actor a1=new PlayerActor();
		Actor a2=new EnemyActor(0);
		Battle battle=new Battle();
		
		Item basicsword=new Item(1);
		a1.EquipSword(basicsword);
		
		a1.setName("Jeff");
		a2.setName("Bob");
		System.out.println("Jeff:"+a1.getCurHp()+" Bob: "+a2.getCurHp());
		System.out.println(a2.getDefenseFighter());
				
		battle.actorBattle(a1,a2);
		System.out.println("Jeff:"+a1.getCurHp()+" Bob: "+a2.getCurHp());
		//battle.printSkillsAvailable(a1);
		
	}
	
}
