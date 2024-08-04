import java.util.Arrays;

public class CountNumbers2 {
    private int[] number_arr;

    private int[] strToIntArray(String[] args){
        number_arr = new int[args.length];

        for(int i = 0; i < args.length; i ++){
            number_arr[i] = Integer.parseInt(args[i]);
        }

        return number_arr;
    }

    public static void main(String[] args){
        CountNumbers2 cn = new CountNumbers2();

        System.out.println(Arrays.toString(cn.strToIntArray(args)));
    }
}
