import java.util.Scanner;

class MeetAndGreet{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Hi, What's your name? ");
        String name = scan.nextLine();
        System.out.println("Hello " + name + "!");
    }
}