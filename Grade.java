public class Grade{
    public static void main(String[] args){
        float grade = Float.parseFloat(args[0]);

        if (args.length > 85) {
            System.out.println("High Dis");
        } else if (grade >= 75) {
            System.out.println("Distinction");
        } else if (grade >= 65) {
            System.out.println("Credit");
        } else if (grade >= 50) {
            System.out.println("Pass");
        } else{
            System.out.println("Fail");
        }
    }
}


