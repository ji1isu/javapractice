import java.util.Scanner;
import java.util.TreeMap;
import java.util.Arrays;

public class DeadpoolAndWolverine {
    String[] m_char_rev_ls;
    double m_target = 0.0; 
    boolean m_exit = false;

    public DeadpoolAndWolverine(){
        m_char_rev_ls = new String[0];
        //tested, works
    }

    private String[] AddToArray(String[] array, String element){
        String[] tmp = new String[array.length + 1];
        System.arraycopy(array, 0, tmp, 0, array.length);
        tmp[array.length] = element;
        return tmp;
        //tested, works
    }

    private void update_m_exit(){
        m_exit = true;
        //tested, works
    }

    private void update_target(String[] args){
        String target = args[0];
        m_target = Double.parseDouble(target);
        //tested, works
    }

    private boolean input_isvalid(String[] str_array){
        if(str_array.length % 2 != 0){
            System.out.println("error incorrect input.");
            return false;
        }
        for (int i = 0; i < str_array.length; i++){
            if(i % 2 != 0){
                try{
                    double new_char = Double.parseDouble(str_array[i]);
                }
                catch(NumberFormatException e){
                    System.out.println("error incorrect input.");
                    return false;
                }
            }
        }
        return true;
        //tested, works
    }

    private void get_name_rev_per_line(){
        Scanner name_rev = new Scanner(System.in);
        String name_rev_str = name_rev.nextLine();
        if ("EOF".equals(name_rev_str)) {
            update_m_exit();
            return;
        }
        String[] split_ls = name_rev_str.split(" ");
        if (input_isvalid(split_ls)){
            for (int i = 0; i < split_ls.length; i++){
                m_char_rev_ls = AddToArray(m_char_rev_ls, split_ls[i]);
            }
        }
        else{
            System.out.println("no output.");
        }
        //tested, works
    }

    private void loop_for_input_until_EOF(){
        while(!m_exit){
            get_name_rev_per_line();
        }
    }// tested, works

    
    
    public static void main(String[] args) {
        DeadpoolAndWolverine dw = new DeadpoolAndWolverine();
        System.out.println(Arrays.toString(dw.m_char_rev_ls));
        dw.loop_for_input_until_EOF();
        System.out.println(Arrays.toString(dw.m_char_rev_ls));

    }

}
