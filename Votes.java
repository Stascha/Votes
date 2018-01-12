/**
 * Created by Stasa on 11.9.16..
 */

import java.util.*;
import java.lang.*;

public class Votes
{
    public static String solution(String[] votes)
    {
        String winner = "";
        int maximum_votes = 0;

        for (int i = 0; i < votes.length; i++) {
            String candidate = votes[i];
            int tempSum = 0;
            int already_counted = 0;

            for (int k = 0; k < i; k++)
                if (votes[k] == votes[i]) {
                    already_counted++;
                    break;
                }

            if (already_counted == 0) {
                for (int j = i; j < votes.length; j++)
                    tempSum = candidate == votes[j] ? tempSum + 1 : tempSum ;

                if (tempSum >= maximum_votes && winner.compareTo(candidate) < 0 ){
                   maximum_votes = tempSum;
                   winner = candidate;

                }
            }    
        }

        return winner;
    }

    public static String solution2(String[] votes)
    {
        String winner = "";
        int maximum_votes = 0;
        Arrays.sort(votes);

        String candidate = votes[0];
        int number_of_votes = 1;

        for (int i = 1; i < votes.length; i++) {
            if (votes[i - 1] == votes[i])
                   number_of_votes++;
            else{
                if(number_of_votes >= maximum_votes ){
                   maximum_votes = number_of_votes;
                   winner = candidate;
                }

                candidate = votes[i];
                number_of_votes = 1;
            }

        }

        return winner;
    }

    static String solution3(String[] votes)
    {
        String winner = null;
        int maximum_votes = 0;
        TreeMap<String, Integer> candidates = new TreeMap<String, Integer>();

        for (int i=0; i<votes.length; i++) {
            String candidate = votes[i];

            Integer number_of_votes = candidates.get(candidate);

            if (number_of_votes == null)
                number_of_votes = 0;

            candidates.put(candidate, number_of_votes + 1);
        }

        for (String candidateName : candidates.keySet()) {
            int numberOfVotes = candidates.get(candidateName);

            if ( numberOfVotes > maximum_votes || (numberOfVotes == maximum_votes && winner.compareTo(candidateName) < 0 )) {
                winner = candidateName;
                maximum_votes = numberOfVotes;
            }
        }

        return winner;

    }

    public static void main(String []args)
    {
        String[] kandidati = { "Hillary", "Martin", "Alexander", "Martin", "Markus", "Donald", "Markus", 
                               "Martin", "Markus", "Donald", "Hillary", "Donald", "Sabrina", "Alexander", "Hillary", 
                               "Sabrina", "Martin", "Sabrina", "Markus", "Donald", "Martin", "Sabrina", "Markus" };

        for( int i = 0; i < kandidati.length;  i++)
            System.out.println(kandidati[i]);

        System.out.println();
        System.out.println("Winner is " + solution(kandidati) );

        System.out.println();
        System.out.println("Winner is " + solution2(kandidati) );

        System.out.println();
        System.out.println("Winner is " + solution3(kandidati));

    }

}

