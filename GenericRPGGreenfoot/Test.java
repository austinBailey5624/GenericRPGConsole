/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test  
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Test
     */
    public Test()
    {
    }
    
    public void println(String s)
    {
        System.out.println(s);
    }
    
    public void runTests()
    {
        RPGActor a=new RPGActor();
        println("Running all tests:\n");
        println("Actor Tests:\n");
        println("1) Actor member variables are correctly set in the constructor: "+ a.RPGActorTest1() );
        println("2) Correct sword is equipped in actor constructor: "+ a.RPGActorTest2());
        println("3) Correct shield is equipped in the actor constructor: " + a.RPGActorTest3());
        println("4) Correct armor is equipped in the actor constructor: " + a.RPGActorTest4());
    }
    
  
}
