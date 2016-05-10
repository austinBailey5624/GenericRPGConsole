/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Test  
{
    private RPGActor a;
   
    public Test()
    {
        a=new RPGActor();
    }
    
    public void println(String s)
    {
        System.out.println(s);
    }
    
    public void runTests()
    {
        println("Running all tests:\n");
        println("Actor Tests:\n");
        println("1) Actor member variables are correctly set in the constructor: "+ a.RPGActorTest1() );
        println("2) Correct sword is equipped in actor constructor: "+ a.RPGActorTest2());
        println("3) Correct shield is equipped in the actor constructor: " + a.RPGActorTest3());
        println("4) Correct armor is equipped in the actor constructor: " + a.RPGActorTest4());
        println("5) Correct helmet is equipped in the actor constructor: " + a.RPGActorTest5());
        
        println("6) Correct gauntlets are equipped in the actor constructor" + a.RPGActorTest6());
        println("7) The actors skillset accounts for all skills possible: " + a.RPGActorTest7());
        println("8) Test that actors skillset array contains proper starting values: " + a.RPGActorTest8());
        println("9) Test that member method getSkillset() works correctly : " + a.RPGActorTest9());
        println("10) Test that member method getName() works correctly: " + a.RPGActorTest10());
        println("11) Test that member method setName() works correctly: " + a.RPGActorTest11());
        println("12) Test that member method getLevel() works correctly: " + a.RPGActorTest12());
        println("13) Test that member method setLevel() works correctly: " + a.RPGActorTest13());
        println("14) Test that member method getMaxHp() works correctly: " + a.RPGActorTest14());
        println("15) Test that member method setMaxHp() works correctly: " + a.RPGActorTest15());
        
        
    }
    
  
}
