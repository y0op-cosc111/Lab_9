// this class is responsible for taking winners from each arena and
// having them compete in subsequent battles in order to get a final winner
public class Tournament
{
    // variables for each round in the tournament
    private final int TOUR_SIZE = 8;
    private Arena quarter1;
    private Arena quarter2;
    private Arena quarter3;
    private Arena quarter4;
    private Arena semi1;
    private Arena semi2;
    private Arena finalRound;
    private Animal[] competitors;

    // constructor
    public Tournament( Animal[] animalList )
    {
        // make sure the number of competitors are correct
        if( animalList.length == TOUR_SIZE )
        {
            competitors = animalList;
            quarter1    = new Arena( competitors[0], competitors[1], "QuarterFinal 1" );
            quarter2    = new Arena( competitors[2], competitors[3], "QuarterFinal 2" );
            quarter3    = new Arena( competitors[4], competitors[5], "QuarterFinal 3" );
            quarter4    = new Arena( competitors[6], competitors[7], "QuarterFinal 4" );
            semi1 = new Arena(quarter1.getWinner(), quarter2.getWinner(), "SemiFinal 1");
            semi2 = new Arena(quarter3.getWinner(), quarter4.getWinner(), "SemiFinal 2");
            finalRound = new Arena(semi1.getWinner(), semi2.getWinner(), "FinalRound");
            printResults();
        }
        else
            System.out.println( "Cannot start tournament -- too many/few competitors" );
    }

    private void printResults() {
        sortResults();
        for (Animal competitor : competitors) {
            System.out.println(competitor.toString());
        }
    }

    /*
     * Sort the array of competitors by score, from highest to lowest
     * If there's a tie, sort by strength
     */
    private void sortResults()
    {
        for( int i=1; i<competitors.length; i++ )
        {
            Animal temp = competitors[i];
            int j;
            for( j=(i-1); j>=0 && temp.getScore() < competitors[j].getScore(); j-- )
                competitors[j+1] = competitors[j];
            competitors[j+1] = temp;
        }

    }
}
