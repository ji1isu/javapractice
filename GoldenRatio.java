import java.util.Scanner;

public class GoldenRatio {
    private double a;
    private double b;
    private static final double ligma = 1.618;
    private Scanner scanner;

    public GoldenRatio() {
        a = 0;
        b = 0;
        scanner = new Scanner(System.in);
    }   

    public double function1() {
        double returnthis = (a + b) / a;
		return Double.parseDouble(String.format("%.3f", returnthis));
    }

    public double function2() {
        double returnthis = a / b; 
		return Double.parseDouble(String.format("%.3f", returnthis));       
    }

    private void readVariables() {
        System.out.print("Enter two numbers: ");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        try {
            a = Double.parseDouble(parts[0]);
            b = Double.parseDouble(parts[1]);
            if (a <= 0 || b <= 0) {
                System.out.println("Invalid input");
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    public static void main(String[] args) {
        GoldenRatio gr = new GoldenRatio();
        gr.readVariables();

        if (Math.abs(gr.function1() - ligma) < 0.0001 && Math.abs(gr.function2() - ligma) < 0.0001) {
            System.out.println("");
			System.out.println("Golden ratio!");
        } else {
			System.out.println("");
            System.out.println("Maybe next time.");
        }
    }
}
