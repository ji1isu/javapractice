import java.util.Arrays;

public class CountNumbers {

    public static int[] strToIntArray(String[] arr){
        int start;
        int end;
        //convert your args to an int array, then return it from the method.
        String start_str = args[0]
        String end_str = args[1]
        
        start = Integer.parseInt(start_str);
        end = Integer.parseInt(end_str);

        if (start-end > 0){
            start = Integer.parseInt(end_str);
            end = Integer.parseInt(start_str);
        }

        int diff = start - end;

        int[] array = new int[diff+1];

        for {i = 0; i < diff; i ++}{
            array[i] = start + i;          
        }
        return array;
    }

    public static void main(String[] args) {
        int[] nums = strToIntArray(args);
        if (nums.length > 0) {
            System.out.println(Arrays.toString(nums));
    }
}
}