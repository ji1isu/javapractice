public class Skibidi {
    public static void main(String[] args) {
        Team skibidi = new Team(args[1]);
        Team alliance = new Team(args[0]);

        skibidi.executeAll();
        double skbdScore = skibidi.score_get();

        alliance.executeAll();
        double alliScore = alliance.score_get();

        if (skbdScore > alliScore){
            System.out.println("Battle result: Skibidi wins");
        } else if (skbdScore < alliScore){
            System.out.println("Battle result: Alliance wins");
        } else{
            System.out.println("Battle result: Draw");
        }
    }
}
