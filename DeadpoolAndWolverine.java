import java.util.Scanner;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.Map;  

public class DeadpoolAndWolverine {
    String[] m_char_rev_ls;
    int m_target;
    boolean m_exit;
    int[] m_sorted_revenue_list;
    TreeMap<String, Integer> m_char_rev_map;
    String[] m_selected_chars;
    int m_expected_revenue;

    public DeadpoolAndWolverine(int target){
        m_target = target;
        m_char_rev_ls = new String[0];
        m_sorted_revenue_list = new int[0];
        m_char_rev_map = new TreeMap<>();
        m_selected_chars = new String[0];
        m_expected_revenue = 0;
    }

    private String[] AddToArray(String[] array, String element){
        String[] tmp = new String[array.length + 1];
        System.arraycopy(array, 0, tmp, 0, array.length);
        tmp[array.length] = element;
        return tmp;
    }

    private int[] AddDoubleToArray(int[] array, int element){;
        int[] tmp = new int[array.length + 1];
        System.arraycopy(array, 0, tmp, 0, array.length);
        tmp[array.length] = element;
        return tmp;
    }

    private void update_m_exit(){
        m_exit = true;
    }

    private void update_target(String[] args){
        String target = args[0];
        m_target = Integer.parseInt(target);
    }

    private boolean is_valid_rev(String rev)
    {
        try{
            int revenue = Integer.parseInt(rev);
            if(revenue < 0) {
                return false;
            }
        } catch(Exception e){
            return false;
        }
        return true;
    }

    private boolean input_isvalid(String[] split_ls){
        if(split_ls.length % 2 != 0){
            System.out.println("Input "+"'" + String.join(" ", split_ls)+ "'" +" is not valid. Make sure your input is valid.");
            return false;
        }
        for (int i = 1; i < split_ls.length; i+=2){
            if (is_valid_rev(split_ls[i]) != true) {
                System.out.println("Input "+"'" + String.join(" ", split_ls)+"'" +" is not valid. Make sure your input is valid.");
                return false;
            }
        }
        return true;

    }

    private boolean line_process(Scanner scanner){
        String line = scanner.nextLine();
        if ("EOF".equals(line)) {
            return false;
        }

        String[] split_ls = line.split(" ");
        if (input_isvalid(split_ls)){
            for (int i = 0; i < split_ls.length; i++){
                m_char_rev_ls = AddToArray(m_char_rev_ls, split_ls[i]);
            }
        }
        return true;
    }

    private void input_process(){
        boolean keep_input;
        Scanner scanner = new Scanner(System.in);

        keep_input = true;
        while(keep_input){
            keep_input = line_process(scanner);
        }
    }

    private void sorted_name_revenue(){
        for(int i = 0; i < m_char_rev_ls.length; i+=2){
            String name = m_char_rev_ls[i];
            int revenue = Integer.parseInt(m_char_rev_ls[i+1]);
            m_char_rev_map.put(name, revenue);
        }
    }

    private void sorted_revenue(){
        for(int i = 1; i < m_char_rev_ls.length; i+=2){
            int revenue = Integer.parseInt(m_char_rev_ls[i]);
            m_sorted_revenue_list = AddDoubleToArray(m_sorted_revenue_list, revenue);
            Arrays.sort(m_sorted_revenue_list);
        }
    }

    private String select_by_revenue(){
        int tally_revenue = 0;
        int index = find_minimum_revenue();
        String[] selected_characters = new String[0];
        if(index==-1){
            return "No characters selected.";
        }
        for(int i = 0; i < index+1; i++){
            String name = find_name_by_revenue(m_sorted_revenue_list[i]);
            m_selected_chars = AddToArray(m_selected_chars, name);
        }
        Arrays.sort(m_selected_chars);
        return "Selected characters: " + Arrays.toString(m_selected_chars);

    }
    //tested, works

    private String find_name_by_revenue(int revenue) {
        for (Map.Entry<String, Integer> entry : m_char_rev_map.entrySet()) {
            if (entry.getValue().equals(revenue)) {
                return entry.getKey(); 
            }
        }
        return null; 
    }


    private int find_minimum_revenue(){
        int sum_revenue = 0;
        int index = 0;
        if(m_char_rev_ls.length == 0){
            return -1;
        }        
        else if(m_sorted_revenue_list[0] > m_target){
            return -1;
        }
        for (int i = 0; i < m_sorted_revenue_list.length; i++)
        {
            sum_revenue += m_sorted_revenue_list[i];
            if (sum_revenue > m_target){
                return index;
            }
            index = i;
        }
        return m_sorted_revenue_list.length - 1;
    }

    private String calculate_expected_revenue(){
        int index = find_minimum_revenue();
        int sum_revenue = 0;
        for (int i = 0; i < index + 1; i++){
            sum_revenue += m_sorted_revenue_list[i];
        }
        return "Total expected revenue: " + sum_revenue + " million dollars";
    }

    private static int target_from_args(String[] args) throws Exception
    {
        int target;

        if (args.length != 1)
        {
            throw new Exception("Invalid target");
        }

        try{
            target = Integer.parseInt(args[0]);
        } catch(Exception e){
            throw new Exception("Invalid target");
        }

        return target;
    }

    public static void main(String[] args) {
        int target;

        try {
            target = target_from_args(args);
        } catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }

        DeadpoolAndWolverine dw = new DeadpoolAndWolverine(target);
        dw.input_process();
        dw.sorted_revenue();
        dw.sorted_name_revenue();
        String selection_by_revenue = dw.select_by_revenue();
        System.out.println(selection_by_revenue);
        if(selection_by_revenue.equals("No characters selected.")){
            return;
        }
        System.out.println(dw.calculate_expected_revenue());
    }
}
