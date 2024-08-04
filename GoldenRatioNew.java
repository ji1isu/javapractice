import java.util.Scanner;

public class GoldenRatioNew{
    private double a;
    private double b;
    private Scanner scanner;

    public GoldenRatioNew() {
        a = 0;
        b = 0;
        scanner = new Scanner(System.in);
    }   

    private void read_inputs(){
        try{
            String string_doubles = scanner.nextLine();
            String[] string_arr = string_doubles.split(" ");
            a = Double.parseDouble(string_arr[0]);
            b = Double.parseDouble(string_arr[1]);
        } catch (Exception e){
            System.out.println("Invalid input.");
        }
    }    

    private double golden_ratio_function1(){
        return (a + b)/a;
    }

    private double golden_ratio_function2(){
        return a / b;
    }

    private boolean is_golden_ratio(double golden_ratio1, double golden_ratio2){
        double diff = Math.abs(golden_ratio1 - golden_ratio2);
        if (diff < 0.0005){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        double gr_1;
        double gr_2;
        boolean is_golden_ratio;
        GoldenRatioNew gr = new GoldenRatioNew();

        System.out.print("Enter two numbers: ");
        gr.read_inputs();
        gr_1 = gr.golden_ratio_function1();
        gr_2 = gr.golden_ratio_function2();
        is_golden_ratio = gr.is_golden_ratio(gr_1, gr_2);

        if (is_golden_ratio){
            System.out.println("")
            System.out.println("Golden ratio!");
            return;
        }
        System.out.println("")
        System.out.println("Maybe next time.");
    }
}

