import java.util.Scanner;

public class GoldenRatioMod {
    private double a;
    private double b;
    private static final double GOLDEN_RATIO = 1.618;
    private Scanner scanner;

    public GoldenRatioMod(){
        a = 0.0;
        b = 0.0;
        scanner = new Scanner(System.in);
    }

    private void print(){
        System.out.println(a);
        System.out.println(b);
    }

    private int input_get()
    {
        System.out.print("Enter two numbers: ");
        try{
            String numbers_str = scanner.nextLine();
            String[] numbers_arr = numbers_str.split(" ");
            a = Double.parseDouble(numbers_arr[0]);
            b = Double.parseDouble(numbers_arr[1]);
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    private double gr_1(){
        return (a + b) / a;
    }

    private double gr_2(){
        return a / b;
    }

    private boolean is_golden_ratio(double left_ratio, double right_ratio){
        double diff = Math.abs(left_ratio - right_ratio);
        if (diff < 0.0005){
            return true;
        }
        return false;
    }

    private void print(boolean is_gr)
    {
        if (is_gr)
        {
            System.out.println("Golden ratio!");
        }
        else
        {
            System.out.println("Maybe next time.");
        }
    }

    public static void main(String[] args) {
        GoldenRatioMod gr;
        double left_ratio;
        double right_ratio;
        boolean is_gr;

        gr = new GoldenRatioMod();

        if (gr.input_get() == -1)
        {
            System.out.println("Invalid input.");
            return;
        }

        left_ratio = gr.gr_1();
        right_ratio = gr.gr_2();
        is_gr = gr.is_golden_ratio(left_ratio, right_ratio);
        gr.print(is_gr);
    }
}
