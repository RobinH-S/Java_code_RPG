import java.util.ArrayList; 
import java.util.Random;
/**
 * Main-klasse for spillet. Her oppretter vi en spiller, fire gjenstander, skaper fem monstre og en battleground
 * Spilleren prøver å kjøpe gjenstandene, monstrene blir lagt til i en ArrayList, og starter spillet.
 * Created by Robin Hextall-Schjelderup on 20.10.2016.
 */
public class Game {

    public static void main(String[] args) {
        ArrayList <Monster> monsters = new ArrayList<Monster>();
        Player player = new Player("Sindre", "Warrior");
        Monster monster1 = new Monster ("Dragon", 40, 120, 50);
        Monster monster2= new Monster ("Vampyre", 50, 123, 30);
        Monster monster3 = new Monster ("Zombie", 31, 120, 50);
        Monster monster4 = new Monster ("OP Monster", 300, 200, 100);
        Monster monster5 = new Monster ("Troll", 120, 140, 70);

        monsters.add (monster1);
        monsters.add (monster2);
        monsters.add (monster3);
        monsters.add (monster4);
        monsters.add (monster5);
        Random tilfeldig = new Random();

        Battleground battleground = new Battleground (player, monsters.get(tilfeldig.nextInt(monsters.size()-1)));
        battleground.start ();

        Item knife = new Item("Knife", "Slashes the opponent", "slashes", 567, 1);
        Item potion = new Item("Health potion", "Heals your health", "drinks", 100, 1);
        Item axe = new Item("Axe", "Cuts down trees", "cuts", 250, 3);
        Item car = new Item("Porche", "Drives around", "Drives", 1020, 500);

        player.buyItem(knife);
        player.buyItem(potion);
        player.buyItem(axe);
        player.buyItem(car);

    }
}
