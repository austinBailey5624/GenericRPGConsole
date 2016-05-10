import java.util.Scanner;
import javax.swing.JOptionPane;
import java.lang.StringBuilder;

/**
 * Write a description of class Inn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inn  
{
    int m_charge;
    String m_name;
    int select;
    //Scanner myScanner = new Scanner(System.in);

    /**
     * Generates an inn based on the input provided in parameter whichInn
     * @precondition: 	none
     * @post:			generates an Inn	
     * @return:			instance of Inn
     */
    public Inn(int whichInn)
    {
        if(whichInn==1)
        {
            m_name = "VillageVille inn";
            m_charge=10;
        }
        else if(whichInn==2)
        {
            m_name = "AwesomeTown inn";
            m_charge=25;
        }
    }

    /**
     * Handles the player's interaction with the inn
     * @precondition: 	instance of Inn, instance of PlayerActor to pass to inn
     * @post:			can heal user and decrement gold
     * @return:			void
     */
    public void menu(Party party)
    {
        System.out.println("Welcome to " + this.m_name + " How can we help you?");
        boolean exit=false;
        String in;
        while(!exit)
        {
            StringBuilder text = new StringBuilder();
            text.append("Welcome to " + this.m_name + " How can we help you?\n");
            
            text.append("What would you like to do?\n");
            System.out.println("What would you like to do?");
            text.append("1) rest and heal hp, cost:" + m_charge + "\n");
            System.out.println("1) rest and heal hp, cost:" + m_charge);
            text.append("2) Talk to bartender (to get quests)\n");
            System.out.println("2) Talk to bartender (to get quests)");
            text.append("3) Leave\n");
            System.out.println("3) Leave");

            in=JOptionPane.showInputDialog(text.toString());
            if(verifyInt(in))
            {
                select=Integer.parseInt(in);
            }
            else
            {
                select=0;
            }
            if(select==1)
            {
                if(party.getGold()<m_charge)
                {
                    JOptionPane.showMessageDialog(null, "Sorry laddie, you can't afford a bed");
                    System.out.println("Sorry laddie, you can't afford a bed");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Have a nice nap boy");
                    System.out.println("Have a nice nap boy"); //TODO make inn take gold from the party based on number of people sleeping
                    for(int i=0; i<4;i++)
                    {
                        if(party.getContent()[i]!=null)
                        {						
                            party.getContent()[i].setCurHp(party.getContent()[i].getMaxHp());
                        }	
                    }
                    JOptionPane.showMessageDialog(null, "You wake up feeling refreshed!");
                    System.out.println("You wake up feeling refreshed!");
                }
            }
            else if(select==2)
            {
                JOptionPane.showMessageDialog(null, "Sorry laddie, no quests around here right now,\n but you could always try the arena");
                System.out.println("Sorry laddie, no quests around here right now,\n but you could always try the arena");
            }
            else if(select==3)
            {
                JOptionPane.showMessageDialog(null, "Thanks for dropping in Laddie!");
                System.out.println("Thanks for dropping in Laddie!");
                return;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Sorry, we didn't understand your input, please try again");
                System.out.println("Sorry, we didn't understand your input, please try again");
            }
        }
    }

    private boolean verifyInt(String s)
    {
        try
        {
            int x=Integer.parseInt(s);
            return true;
        }
        catch(Exception e)
        {

            return false;
        }
    }
}
