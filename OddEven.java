import java.util.Scanner;

public class OddEven {
    private int a;
    private Scanner scanner;

    public OddEven() { 
        a = 0;
        scanner = new Scanner(System.in);
    }   

    public int iseven() {
        if (a % 2 == 0) {
            return 1;
        } else { 
            return -1;
        }
    }

    public static void main(String[] args) {
        OddEven oe = new OddEven(); 
        System.out.print("Enter an integer: ");
        oe.a = oe.scanner.nextInt();  

        if (oe.iseven() == 1) {
            System.out.println("The number " + oe.a + " is even.");
        } else if (oe.iseven() == -1) {  
            System.out.println("The number " + oe.a + " is odd.");
        }
    }
}
