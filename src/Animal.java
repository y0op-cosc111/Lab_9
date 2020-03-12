import java.util.concurrent.ThreadLocalRandom;

public class Animal {

    private static final int MAX_STRENGTH = 10;
    private static final int MAX_HEALTH = 10;

    private String name;
    private int score;
    private int health;
    private int strength;
    private boolean isAlive;

    public Animal(String name) {
        this.name = name;
        this.score = 0;
        this.health = MAX_HEALTH;
        this.strength = ThreadLocalRandom.current().nextInt(MAX_STRENGTH);
        this.isAlive = true;
    }

    @Override
    public String toString() {
        return name + "(Strength: " + this.strength + ", Health: " + this.health + ", Score: " + this.score + ")";
    }

    public void injure(int damage) {
        this.health -= damage;
        this.isAlive = this.health > 0;
    }

    public void attack(Animal opponent) {
        int attackStrength = ThreadLocalRandom.current().nextInt(this.strength);
        opponent.injure(attackStrength);
        this.score += attackStrength;

        System.out.println(this.name + " hits " + opponent.getName() + " for " + attackStrength + " damage");
        if (!opponent.isAlive()) {
            System.out.println(opponent.getName() + " fainted");
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getScore() {
        return score;
    }

    public int getStrength() {
        return strength;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
