import java.util.Scanner

public class VoteDifference{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String votes = scanner.nextLine();
        String[] votes_indiv = input.split(" ");
        try {
        int vote1 = votes_indiv[0];
        int vote2 = votes_indiv[1];
        } catch {
System.out.println("Bad input" );
} finally {
        if (vote1 > vote2){
            int votingdiff = vote1-vote2;
            System.out.println("The poll is won by " + votingdiff + " votes" );
        } else if (vote1 < vote 2){
            int votingdiff = vote2-vote1;
            System.out.println("The poll is won by " + votingdiff + " votes" );
        } else{
            System.out.prinln("The poll is a tie");
        }
    }
}

