/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Test  
{
    private RPGActor a;
    private Party p;
    private Item item;
   
    public Test()
    {
        a=new RPGActor();
        p=new Party();
        item=new Item();
    }
    
    public void println(String s)
    {
        System.out.println(s);
    }
    
    public void runTests()
    {
        println("Running all tests:\n");
        println("\nActor Tests:\n");
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
        println("16) Test that member method getCurHp() works correctly: " + a.RPGActorTest16());
        println("17) Test that member method setCurHp() works correctly: " + a.RPGActorTest17());
        println("18) Test that member method getAtk() returns m_atk: " + a.RPGActorTest18());
        println("19) Test that member method setAtk() changes m_atk to correct value: " + a.RPGActorTest19());
        println("20) Test that member method getAtkModifier returns m_atkModifier: " + a.RPGActorTest20());
        println("21) Test if value passed to setAtkModifier is > 5, m_atkModifier is set to 5: " + a.RPGActorTest21());
        println("22) Test if value passed to setAtkModifier is in range, it is set: " + a.RPGActorTest22());
        println("23) Test if value passed to setAtkModifer is below range, it is set to 0: " + a.RPGActorTest23());
        println("24) Test that member method getDef() returns correct value: " + a.RPGActorTest24());
        println("25) Test that member method setDef() correctly sets m_def: " + a.RPGActorTest25());
        println("26) Test that getDefModifier returns correct value: " + a.RPGActorTest26());
        println("27) Test that if value passed to setDefModifier() is > 5, that m_defModifier is set to 5: " + a.RPGActorTest27());
        println("28) Test that if value passed to setDefModifier() is within range, that m_defModifier is set to that value: " + a.RPGActorTest28());
        println("29) Test that if value passed to setDefModifier() is < 0, that m_defModifier is set to 0: " + a.RPGActorTest29());
        println("30) Test that getEquippedSword() returns correct item: " + a.RPGActorTest30());
        println("31) Test that equipSword() equips an item in the case where the item is the correct type: " + a.RPGActorTest31());
        println("32) Test that equipSword() does not equip an item that is of the wrong type: " + a.RPGActorTest32());
        println("33) Test that getEquippedShield() returns the correct item: " + a.RPGActorTest33());
        println("34) Test that equipShield() equips the item if it is the correct type: " + a.RPGActorTest34());
        println("35) Test that equipShield() does not equip the item if it is not the correct type: " + a.RPGActorTest35());
        println("36) Test that getEquippedArmor() returns the correct item: " + a.RPGActorTest36());
        println("37) Test that equipArmor() equips the item if it is the correct type: " + a.RPGActorTest37());
        println("38) Test that equipArmor() does not equip the item if it is not the correct type: " + a.RPGActorTest38());
        println("39) Test that getEquippedHelmet() returns the correct value: " + a.RPGActorTest39());
        println("40) Test that equipHelmet() equips an item if it is the correct type: " + a.RPGActorTest40());
        println("41) Test that equipHelmet() does not equip an item if it is the wrong type: " + a.RPGActorTest41());
        println("42) Test that getDescription() returns m_description: " + a.RPGActorTest42());
        println("43) Test that setDescription() sets m_description correctly: " + a.RPGActorTest43());
        println("44) Test that getEquippedGauntlets() returns the correct value: " + a.RPGActorTest44());
        println("45) Test that equipGauntlet() equips the item if it is the correct type: " + a.RPGActorTest45());
        println("46) Test that equipGauntlet() does not equip item if it is not the correct type: " + a.RPGActorTest46());
        println("47) Test that getEquippedBoots() returns the correct value: " + a.RPGActorTest47());
        println("48) Test that equipBoots() equips the item if it is of the correct type: " + a.RPGActorTest48());
        println("49) Test that equipBoots() does not equip the item if it is not the correct type: " + a.RPGActorTest49());
        println("50) Test that reduceHp() works properly if the actor does not die: " + a.RPGActorTest50());
        println("51) Test that reduceHp() works properly if the actore dies: " + a.RPGActorTest51());
        println("52) Test that basicAttack() returns false if oppenent lives: " + a.RPGActorTest52());
        println("53) Test that basicAttack() returns true if the opponent dies: " + a.RPGActorTest53());
        println("54) Test that getAttackFighter() returns correct value: " + a.RPGActorTest54());
        println("55) Test that getDefenseFighter() returns correct value: " + a.RPGActorTest55());
        
        println("\nParty Tests: \n");
        println("1) Test that party constructor works properly: " + p.PartyTest1());
        println("2) Test that onlyOne() returns true when it should: " + p.PartyTest2());
        println("3) Test that onlyOne() returns false when it should: " + p.PartyTest3());
        println("4) Test that getGold() returns the correct value: " + p.PartyTest4());
        println("5) Test that setGold() sets m_gold to correct value: " + p.PartyTest5());
        println("6) Test that addGold() works correctly: " + p.PartyTest6());
        println("7) Test that getInventory() works correctly: " + p.PartyTest7());
        println("8) Test that setInventory() works correctly: " + p.PartyTest8());
        println("9) Test that getContent() works correctly: " + p.PartyTest9());
        println("10) Test that setContent() works correctly: " + p.PartyTest10());
        
        println("\nItem Tests: \n");
        println("Verify attributes are correct for item type 1 - basic sword: " + item.testItem1());
        println("Verify attributes are correct for item type 2 - basic shield: " + item.testItem2());
        println("Verify attributes are correct for item type 3 - basic armor: " + item.testItem3());
        println("Verify attributes are correct for item type 4 - basic helmet: " + item.testItem4());
        println("Verify attributes are correct for item type 5 - basic gauntlet: " + item.testItem5());
        println("Verify attributes are correct for item type 6 - basic boots: " + item.testItem6());
        println("Verify attributes are correct for item type 7 - basic health potion: " + item.testItem7());
        println("Verify attributes are correct for item type 8 - no sword: " + item.testItem8());
        println("Verify attributes are correct for item type 9 - no shield: " + item.testItem9());
        println("Verify attributes are correct for item type 10 - no armor: " + item.testItem10());
        println("Verify attributes are correct for item type 11 - no helmet: " + item.testItem11());
        println("Verify attributes are correct for item type 12 - bare hands: " + item.testItem12());
        println("Verify attributes are correct for item type 13 - bare feet: " + item.testItem13());
        println("Verify attributes are correct for item type 14 - iron sword: " + item.testItem14());
        println("Verify attributes are correct for item type 15 - iron shield: " + item.testItem15());
        println("Verify attributes are correct for item type 16 - iron armor: " + item.testItem16());
        println("Verify attributes are correct for item type 17 - iron helmet: " + item.testItem17());
        println("Verify attributes are correct for item type 18 - iron gauntlet: " + item.testItem18());
        println("Verify attributes are correct for item type 19 - iron boots: " + item.testItem19());
        println("Verify attributes are correct for item type 20 - advanced health potion: " + item.testItem20());
        println("Verify attributes are correct for item type 21 - steel sword: " + item.testItem21());
        println("Verify attributes are correct for item type 22 - steel shield: " + item.testItem22());
        println("Verify attributes are correct for item type 23 - steel armor: " + item.testItem23());
        println("Verify attributes are correct for item type 24 - steel helmet: " + item.testItem24());
        println("Verify attributes are correct for item type 25 - steel gauntlet: " + item.testItem25());
        println("Verify attributes are correct for item type 26 - steel boots: " + item.testItem26());
        println("Verify attributes are correct for item type 27 - expert health potion: " + item.testItem27());
        
        
        
        
        
        
    }
    
  
}