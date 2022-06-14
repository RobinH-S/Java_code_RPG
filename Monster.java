import java.util.HashMap;
/**
 * Monster er subklassen til Character
 * Klassen representerer monster i et RPG-spillet
 * @author Robin Hextall - Schjelderup 
 * @version (22.10.2016)
 */
public class Monster extends Characters 
{
    private String name, type;
    private int health, gold, minAttack, maxAttack;
    /**
     * Konstruktør for spilleren. Denne konstruktøren setter helsen til 100, gullbeholdningen til 1000 og vekten spilleren kan bære til 50kg.
     * @param name Navnet på spilleren
     * @param type Spillerens type. Spilleren kan bare være en av følgende [Mage, Warrior, Rogue, Ranger]. Hvis annet er spesifisert blir typen satt til unspecified.
     */
    public Monster(String name, int gold, int health,  int maxAttack) {
		setName(name);
        setType("Monster");
        setHealth(health);
        setGold(gold);

        
        setMinAttack(20);
        setMaxAttack (maxAttack);

    } 

 
    
   

}
