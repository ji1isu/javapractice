import java.util.*;

public class Arr {
    public static void main(String[] args){
        //init array here
        int[] arr = new int[10];
        //print array here
        System.out.println(Arrays.toString(arr));
        //init array of 5 with null
        String[] arr_of_5 = new String[5];
        System.out.println(Arrays.toString(arr_of_5));
        //set the second element of array to "two" and tjhe fourth to fourth
        arr_of_5[1] = "two";
        arr_of_5[3] = "four";
        System.out.println(Arrays.toString(arr_of_5));

        
    }
}