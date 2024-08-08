import java.util.*;

public class Union{

    private static boolean isinArray(int[] list_num, int element){
        for(int i = 0; i < list_num.length; i++){
            if(list_num[i] == element){
                return true;
            }
        }
        return false;
    }

    private static int[] addElement(int[] src_ls, int value){
        int[] tmp = new int[src_ls.length+1];
        System.arraycopy(src_ls, 0, tmp, 0, src_ls.length);
        tmp[src_ls.length] = value;
        return tmp;
    }

    static int[] union(int[] x, int[] y){
        int[] union = new int[0];
        union = x;
        for(int i = 0; i < y.length; i++){
            if(!isinArray(union, y[i])){
                union = addElement(union, y[i]);
            }
        }
        return union;
    }

    public static void main(String[] args){
        int[] x = {3, 2, 7, 2};
        int[] y = {3, 8, 9};
        int[] result = union(x, y);
        System.out.println(Arrays.toString(result));//3, 2, 7, 2, 8, 9

    }
}