import java.util.ArrayList;
import java.util.Random;

/**
 * Battleground er en arena hvor en spiller kan kjempe mot et tilfeldig monster fra listen
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Battleground
{

    Player player;
    Monster monster;
    InputReader inputReader;

    public Battleground(Player name, Monster monster) {
        this.player = name;
        this. monster = monster;
        inputReader = new InputReader();

    }

    // instance variables - replace the example below with your own
    private InputReader input = new InputReader();

    // Constructor for objects of class Battleground
    public Battleground()
    {
        // initialise instance variables

    }

    public void start()
    {
        System.out.println (player.getName () + " has entered the arena with " + monster.getName ());     
        boolean inBattle = true;
        while (inBattle){

            String input = inputReader.getInput ();
            if (input.trim ().equalsIgnoreCase ("Run")) {
                System.out.println ("Player has run away from battle");
                inBattle=false;

                player.setGold(player.getGold() -50);
            }
            else {

                if (input.trim ().equalsIgnoreCase ("Attack")) {
                    System.out.println (player.getName () + " attacks" + monster.getName ()+ " for " + player.attack (monster) + " damage, "  );
                    if (!monster.isDead ()){
                        System.out.print (monster.getName () + " has " + monster.getHealth () + " health remaining");
                        System.out.println (monster.getName ()+ " attacks" + player.getName () + " for " + monster.attack (player) + " damage, ");
                        if (!player.isDead () )
                            System.out.print ( player.getName()  + " has " + player.getHealth () + " health remaining" );
                        else{
                            System.out.println (player.getName () + " has died ");
                            inBattle= false;
                        }
                    }
                    else{
                        System.out.print (" and kills " + monster.getName());
                        System.out.println (" " + player.getName ()+ " gained " + monster.getGold () + " gold pieces ");
                        player.setGold (player.getGold () + monster.getGold ()); 
                        inBattle =false;
                    }

                }
            }
        }
    }
}

