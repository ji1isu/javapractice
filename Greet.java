import java.util.Scanner;

public class Greet {
    public static void main(String[] args){
    Scanner namestr = new Scanner(System.in);
    System.out.print("Enter your name: ");
    String name = namestr.nextLine();
    System.out.println("Hello, " + name + "!");
    }
}