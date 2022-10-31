/**
 * Denne klassen representer en gjenstand spilleren kan kjøpe
 * Created by Robin on 23.09.2016.
 */
public class Item {
    private String name, description, action;
    private int value, weight;

    /**
     * Konstruktør for Item
     * @param name navnet på gjenstanden
     * @param description beskrivelse av gjenstanden
     * @param action hva skjer når spilleren bruker gjenstanden
     * @param value verdien på gjenstanden i gull
     * @param weight vekten på gjenstanden
     */
    public Item(String name, String description, String action, int value, int weight) {
        this.name = name;
        this.description = description;
        this.action = action;
        setValue(value);
        setWeight(weight);

    }
	
 	/**
     * Returnerer String representasjon av objektet
     */
	@Override 
	public String toString () {
		return"Name: " + this.name +
        " - Description: " + this.description +
        " - Action: " + this.action +
        " - Value: " + this.value +
        " - Weight: " + this.weight ;
	   }

    /**
     * Metode for å printe informasjon om gjenstanden.
     */
    public void print() {
        System.out.println(this.toString());
    }

    /**
     * Returnerer navnet på gjenstanden
     * @return Returnerer navnet på gjenstanden
     */
    public String getName() {
        return name;
    }

    /**
     * Setter navnet på gjenstanden
     * @param name Det nye navnet på gjenstanden
     */
    public void setName(String name) {
        this.name = Utilities.checkString(name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = Utilities.checkString(description);
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = Utilities.checkString(action);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = Utilities.cleanNegative(value);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = Utilities.cleanNegative(weight);
    }
}
