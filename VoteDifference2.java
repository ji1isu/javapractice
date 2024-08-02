import java.util.Scanner;

public class VoteDifference2{
    private int vote_doctor_doom;
    private int vote_iron_man;
    private Scanner scanner;

    public VoteDifference(){
        vote_dd = 0;
        vote_im = 0;
        scanner = new Scanner(System.in);
    }

    private int get_votes(){
        String votes = Scanner.nextLine
        String[] votes_indiv = votes.split(" ");
        try{
            vote_dd = Integer.parseInt(votes_indiv[0]);
            vote_im = Integer.parseInt(votes_indiv[1]);
            if (vote_dd < 0 || vote_im < 0){
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
        return 0;        
    }

    private void get_results(){
        int vote_diff_num = Math.abs(vote_dd - vote_im);
        if (vote_diff_num > 0){
            System.out.println("The poll is won by " + vote_diff_num + " votes");
        }
        else{
            System.out.println("The poll is a tie");
        }
    }        
    
    public static void main(String[] args){
        VoteDifference vote_difference = new VoteDifference();
                if (vote_difference.get_votes() == -1)
                {
                    System.out.println("Bad input");
                    return;
                }
                vote_difference.get_results();        
    }


}