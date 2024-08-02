import java.util.Scanner;

public class VoteDifference{
    private int vote_doctor_doom;
    private int vote_iron_man;
    private Scanner scanner;

    public VoteDifference()
    {
        vote_doctor_doom = 0;
        vote_iron_man = 0;
        scanner = new Scanner(System.in);
    }

    private int vote(){
        String votes = scanner.nextLine();
        String[] votes_indiv = votes.split(" ");
        try{
            vote_doctor_doom = Integer.parseInt(votes_indiv[0]);
            vote_iron_man = Integer.parseInt(votes_indiv[1]);
            if (vote_doctor_doom < 0 || vote_iron_man < 0){
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
        return 0;
    }

    private void result(){
        int vote_diff_num = Math.abs(vote_doctor_doom - vote_iron_man);
        if (vote_diff_num > 0){
            System.out.println("The poll is won by " + vote_diff_num + " votes");
        }
        else{
            System.out.println("The poll is a tie");
        }
    }

    public static void main(String[] args){
        VoteDifference vote_difference = new VoteDifference();
        if (vote_difference.vote() == -1)
        {
            System.out.println("Bad input");
            return;
        }
        vote_difference.result();
    }
}
