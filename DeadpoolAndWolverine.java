import java.util.Scanner;
import java.util.TreeMap;
import java.util.Arrays;

public class DeadpoolAndWolverine {
    String[] m_char_rev_ls;
    double m_target;
    boolean m_exit;
    double[] m_sorted_revenue_list;
    TreeMap<String, Double> m_char_rev_map;

    public DeadpoolAndWolverine(double target){
        m_target = target;
        m_char_rev_ls = new String[0];
        m_sorted_revenue_list = new double[0];
        m_char_rev_map = new TreeMap<>();
        //tested, works
    }

    private void print(){
        System.out.println(m_target);
        System.out.println(m_exit);
        System.out.println(m_char_rev_ls);
        System.out.println(m_sorted_revenue_list);
        System.out.println(m_char_rev_map);
    }

    private String[] AddToArray(String[] array, String element){
        String[] tmp = new String[array.length + 1];
        System.arraycopy(array, 0, tmp, 0, array.length);
        tmp[array.length] = element;
        return tmp;
        //tested, works
    }

    private double[] AddDoubleToArray(double[] array, double element){;
        double[] tmp = new double[array.length + 1];
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

    private boolean is_valid_rev(String rev)
    {
        try{
            double revenue = Double.parseDouble(rev);
            if(revenue < 0.0) {
                return false;
            }
        } catch(Exception e){
            return false;
        }
        return true;
    }

    private boolean input_isvalid(String[] split_ls){
        if(split_ls.length % 2 != 0){
            System.out.println("error incorrect input.");
            return false;
        }
        for (int i = 1; i < split_ls.length; i+=2){
            if (is_valid_rev(split_ls[i]) != true) {
                System.out.println("error incorrect input.");
                return false;
            }
        }
        return true;
        //tested, works
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
        else{
            System.out.println("TEST: no output.");
        }
        //tested, works
        return true;
    }

    private void input_process(){
        boolean keep_input;
        Scanner scanner = new Scanner(System.in);

        keep_input = true;
        while(keep_input){
            keep_input = line_process(scanner);
        }
    }// tested, works

    private void sorted_name_revenue(){
        for(int i = 0; i < m_char_rev_ls.length; i+=2){
            String name = m_char_rev_ls[i];
            double revenue = Double.parseDouble(m_char_rev_ls[i+1]);
            m_char_rev_map.put(name, revenue);
        }
    }//tested, works

    private void sorted_revenue(){
        for(int i = 1; i < m_char_rev_ls.length; i+=2){
            double revenue = Double.parseDouble(m_char_rev_ls[i]);
            m_sorted_revenue_list = AddDoubleToArray(m_sorted_revenue_list, revenue);
            Arrays.sort(m_sorted_revenue_list);
        }
        //tested, works
    }

    private void select_by_revenue(){
        double tally_revenue = 0.0;
        String[] selected_characters = new String[0];
        //need to: select by values

    }

    private double find_minimum_revenue() throws Exception {
        double sum_revenue = 0.0;
        for (int i = 0; i < m_revenue_list.length; i++)
        {
            sum_revenue += m_sorted_revenue_list[i];
            if (sum_revenue > m_target)
            {
                if (i == 0)
                {
                    throw new Exception("TODO: ERROR");
                }
                return m_sorted_revenue_list[i-1];
            }
        } // return an index
        return m_sorted_revenue_list[m_revenue_list.length-1];
    }

    //////////////////////////////////////////////////////////

    private static double target_from_args(String[] args) throws Exception
    {
        double target;

        if (args.length != 1)
        {
            throw new Exception("TODO: ERROR");
        }

        try{
            target = Double.parseDouble(args[0]);
        } catch(Exception e){
            throw new Exception("TODO: ERROR2");
        }

        return target;
    }

    public static void main(String[] args) {
        double target;

        try {
            target = target_from_args(args);
        } catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }

        DeadpoolAndWolverine dw = new DeadpoolAndWolverine(target);
        dw.input_process();
        System.out.println(Arrays.toString(dw.m_char_rev_ls));
        dw.sorted_revenue();
        System.out.println(Arrays.toString(dw.m_sorted_revenue_list));
        dw.sorted_name_revenue();
        System.out.println(dw.m_char_rev_map);
    }
}
