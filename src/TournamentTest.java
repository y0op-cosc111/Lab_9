/**
 * Author: Cameron Janssen
 * Acknowledgements: None
 * Purpose: Play animal tournament
 */
public class TournamentTest {

    public static void main(String[] args) {
        new Tournament(new Animal[]{
                new Animal("Turtle"),
                new Animal("Bluejay"),
                new Animal("Bear"),
                new Animal("Seal"),
                new Animal("Cheetah"),
                new Animal("Parrot"),
                new Animal("Giraffe"),
                new Animal("Tiger"),
        });
    }
}