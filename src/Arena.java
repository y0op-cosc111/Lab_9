import java.util.concurrent.ThreadLocalRandom;

// this class is responsible for setting up the environment for an individual
// battle between two animals
public class Arena {
    private Animal competitor1;
    private Animal competitor2;
    private String arenaName;

    private Animal winner;
    private Animal loser;

    // constructor
    public Arena(Animal one, Animal two, String name) {
        competitor1 = one;
        competitor2 = two;
        arenaName = name;

        // automatically display info about this arena
        System.out.println(toString());
        startBattle();
    }

    /*
     * Randomly decide which competitor starts first in each round
     * Have the first animal attack the other using its attack() method
     * Then have the second animal fight back once as well
     *
     * After each attack, check if the target of the attack has fainted via isAlilve()
     * Repeat these rounds as long as competitors are both alive.
     * Once one of the two animals has fainted
     *   - End the battle
     *   - Store the winner and loser
     *   - Award winner bonus points for winning and call its healUp()
     *   - Printer battle results
     */
    public void startBattle() {

        // STUDENT COMMENT: The .equals() method was not overwritten by animal so I can't check
        // for the opponent given a fist value so I have to do it like this;

        while (competitor1.isAlive() && competitor2.isAlive()) {
            boolean chosen = ThreadLocalRandom.current().nextBoolean();
            Animal attacker = chosen ? competitor1 : competitor2;
            Animal defender = chosen ? competitor2 : competitor1;

            attacker.attack(defender);
            if (!defender.isAlive()) {
                System.out.println("Winner: " + attacker);
                winner = attacker;
                loser = defender;
                break;
            }

            defender.attack(attacker);
            if (!attacker.isAlive()) {
                winner = defender;
                loser = attacker;
                System.out.println("Winner: " + defender);
            }
        }
    }

    public Animal getWinner() {
        return winner;
    }

    public Animal getLoser() {
        return loser;
    }

    /*
     * Creates a meaningful pre-fight summary of the battle.
     * Remember that toString() method you wrote in the Animal class? Use it here
     * See the sample output for more guidance.
     */
    public String toString() {
        String str = arenaName + " is about to begin!\n";
        str += competitor1.toString() + "\t vs \t";
        str += competitor2.toString() + "\n";
        return str;
    }
}
