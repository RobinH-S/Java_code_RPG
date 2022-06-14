import java.util.Random;

/**
 * Character klassen er superklassen for klassene Player og Monster
 * 
 * Created by Robin Hextall-Schjelderup on 23.10.2016.
 * @version (a version number or a date)
 */
public class Characters
{
    // instance variables - replace the example below with your own
    private String name;
    private String type;
    private int health;
    private int gold;
    private int minAttack;
    private int maxAttack;
    
    Random tilfeldig   = new Random();

   
    /**
     * Constructor for objects of class Characters
     */
    public Characters(String name, String type, int gold, int health, int minAttack, int maxAttack)
    {
        name = name;
        type = type;
        gold = gold;
        health = health;
        minAttack = minAttack;
        maxAttack = maxAttack;
        
        

    }

   public Characters () {
       
    }
    
     public int getMaxAttack () {
        return this.maxAttack;
    }
    
     public int getMinAttack () {
        return this.minAttack;
    }
    
    public void setMaxAttack (int maxAttack) {
        this.maxAttack = maxAttack;}
    
    public void setMinAttack (int minAttack) {
        this.minAttack = minAttack;}
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Utilities.checkString(name);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Utilities.cleanNegative(health);
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = Utilities.cleanNegative(gold);
    }
    
    /**
     * Metode for å sjekke om spilleren er død.
     * @return true hvis helsen til spillern er <= 0, false hvis ikke
     */
    public boolean isDead() {
        return getHealth () <= 0;
    }

    /**
     * Metode for å endre helsen til spilleren. Helsen kan bli endret, både med positive og negative heltall
     * @param newHealth den nye helsen til spilleren.
     */
    public void changeHealth(int newHealth) {
        this.health += newHealth;
        if (this.health > 100) {
            this.health = 100;
        } else if(this.health < 0) {
            this.health = 0;
        }
    }
    
    public int tilfeldigVerdi(int min, int max){
     int tilfeldig = (int) Math.random() * max + min;
        return tilfeldig;   
    }
    
    public int attack (Characters character)
    {
        int damage =tilfeldigVerdi(getMinAttack(), getMaxAttack()) ;
        character.takeDamage(damage);
        return damage;
    }
    
    public void takeDamage (int damage) {
        changeHealth(-damage);
    }
}
