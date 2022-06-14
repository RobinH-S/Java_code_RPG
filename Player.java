import java.util.HashMap;
import java.util.Random;


/**
 * Player er subklassen til Character
 * Klassen representerer en spiller i et RPG-spill
 * Created by Robin Hextall-Schjelderup on 23.09.2016.
 */
public class Player extends Characters {
    
    Random tilfeldig = new Random(); 
    private HashMap <String, Item> items;
    private int carryWeight;
    /**
     * Konstruktør for spilleren. Denne konstruktøren setter helsen til 100, gullbeholdningen til 1000 og vekten spilleren kan bære til 50kg.
     * @param name Navnet på spilleren
     * @param type Spillerens type. Spilleren kan bare være en av følgende [Mage, Warrior, Rogue, Ranger]. Hvis annet er spesifisert blir typen satt til unspecified.
     */
    public Player(String name, String type) {
        setName(name);
        setType(type);
        setHealth(100);
        setGold(1000);
        setCarryWeight(50);

        setMinAttack(30);
        setMaxAttack (70);

        this.tilfeldig = new Random();
        this.items = new HashMap <>();
    }

   

    /**
     * Konstruktør for spilleren. Denne konstruktøren lar deg selv definere hvor mye gull spilleren har og hvor mange kg spilleren kan bære
     * @param name Navnet på spilleren
     * @param type Spillerens type. Spilleren kan bare være en av følgende [Mage, Warrior, Rogue, Ranger]. Hvis annet er spesifisert blir typen satt til unspecified.
     * @param weight Antall kg spilleren kan bære
     * @param gold Antall gull spilleren har
     **/
    public Player(String name, String type, int weight, int gold, int minAttack, int maxAttack) {
        setName(name);
        setType(type);
        setHealth(100);
        setCarryWeight(weight);
        setGold(gold);
        setMinAttack(minAttack);
        setMaxAttack (maxAttack);

        this.items = new HashMap<>();
    }

    /**
     * Metode for å kjøpe en gjenstand.
     * @param item gjenstanden som spilleren vil kjøpe
     * @return true hvis spilleren får kjøpt gjenstanden, false hvis ikke
     */
    public void buyItem(Item item) {
        // Vi sjekker om spilleren kan bære gjenstanden og at han har nok gull til å kjøpe gjenstanden
        if(canCarryWeight(item) && hasEnoughMoney(item)) {
            // Legg så til gjenstanden i listen
            this.items.put(item.getName(), item);
            // Og trekk fra kostnaden for gjenstanden
            super.setGold (super.getGold() - item.getValue());

        }
    }

    /**
     * Metode for å finne en gjenstand som spilleren har kjøpt
     * @param search Navnet på gjenstanden du ønsker å finne
     * @return gjenstanden hvis den blir funnet, null hvis ikke
     */
    public Item findItem(String search) {
        return items.get(search);
    }

    /**
     * Metode for å selge en gjenstand
     * @param item gjenstanden som vil bli solgt
     */
    public boolean sellItem(Item item) {
        Item itemToSell = findItem(item.getName());
        if (itemToSell == null) {
            return false; }
        this.items.remove(itemToSell);
        super.setGold (super.getGold ()+ itemToSell.getValue());

        return true;
    } 

    @Override
    public String toString(){
        System.out.println("-----------------------------");
        System.out.println("Navn: " + super.getName());
        System.out.println("Type: " + super.getType());
        System.out.println("Helse: " + super.getHealth() + "/100");
        System.out.println("Gullbeholdning: " + super.getGold () + " gullstykker");
        System.out.println(super.getName () + " kan bære " + getCarryWeight () + " kg. Han bærer foreløpig " + totalWeight());
        System.out.println();
        if(this.items.size() > 0) {
            printItems();
        }
        System.out.println("------------------------------");
        return null;
    }

    /**
     * Metode for å printe alle gjenstandene til spilleren
     */
    private void printItems() {
        System.out.println("Printer " + super.getName ()+ " sine gjenstander");
        for(Item name: this.items.values())
            name.print();

    }

    public boolean useItem (Item item) {
        if (findItem(item.getName()) == null) {
            return false; }
        System.out.println (super.getName () + item.getAction() + item.getName());
        return true;
    }

    /**
     * Hjelpemetode for å sjekke om spilleren kan bære en gjenstand.
     * @param item gjenstanden vi sjekker mot
     * @return true hvis spilleren har kapasitet til å bære gjenstanden, false hvis ikke
     */
    public boolean canCarryWeight(Item item) {
        return (totalWeight() + item.getWeight()) <= getCarryWeight ();
    }

    /**
     * Hjelpemetode for å sjekke om spilleren har nok penger til å kjøpe gjenstanden
     * @param item gjenstanden spilleren ønsker å kjøpe
     * @return true hvis spilleren har nok penger, false hvis ikke
     */
    public boolean hasEnoughMoney(Item item) {
        return super.getGold ()> item.getValue();
    }

    /**
     * Metode for å returnere totalvekten spilleren bærer på det. Dvs. alle gjenstandene til spilleren.
     * @return
     */
    public int totalWeight() {
        int weight = 0;
        for(Item name: this.items.values()) {
            weight += name.getWeight();
        }
        return weight;
    }

    /**
     * Metode for å sjekke at riktig type blir satt på spilleren.
     * @param type Spillerens type. Spilleren kan bare være en av følgende [Mage, Warrior, Rogue, Ranger]. Hvis annet er spesifisert blir typen satt til unspecified.
     * @return typen til spilleren. Hvis feil type blir sendt som parameter, da blir typen returnert som unspecified.
     */
    public String checkType(String type) {
        type =type.trim();

        if(type.equalsIgnoreCase("Warrior")) {
            return type;
        } else if(type.equalsIgnoreCase("Rogue")) {
            return type;
        } else if(type.equalsIgnoreCase("Mage")) {
            return type;
        } else if (type.equalsIgnoreCase("Ranger")) {
            return type;
        } else {
            return "Unspecified";
        }
    }

    @Override 
    public void setType(String type) {
        super.setType( checkType(type));
    }

    public int getCarryWeight() {
        return carryWeight;
    }

    public void setCarryWeight(int carryWeight) {
        this.carryWeight = carryWeight;
    }

    public HashMap <String, Item> getItems() {
        return this.items;
    }

    public void setItems (HashMap <String, Item> items) {
        this.items = items;
    }
    /**
    public void runAway (int runAwayFee){
    r
    player.changeGold(-runAwayFee)
    }
     **/

}
