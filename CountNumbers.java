import java.util.Arrays;

public class CountNumbers {
    private int m_start;
    private int m_end;
    private int m_direction;
    private int[] m_output;

    public static int[] strToIntArray(String[] args){
        int[] number_arr = new int[args.length];

        for(int i = 0; i < args.length; i ++){
            number_arr[i] = Integer.parseInt(args[i]);
        }

        return number_arr;
    }

    private void argument_process(String[] args){
        m_start = Integer.parseInt(args[0]);
        m_end = Integer.parseInt(args[1]);
        m_direction = 1;

        if (m_start > m_end){
            m_direction = -1;
        }
    }

    private boolean output_set(){
        int count = Math.abs(m_end - m_start) + 1;

        m_output = new int[count];

        for(int i = 0; i < count; i++){
            m_output[i] = m_start + i * m_direction;
        }

        if(m_output.length < 3){
            return false;
        }
        return true;
    }

    private void output_print(){
        for (int i = 0; i < m_output.length; i++){
            System.out.println(m_output[i]);
        }
    }

    private void print(){
        System.out.printf("m_start: %d\n", m_start);
        System.out.printf("m_end: %d\n", m_end);
        System.out.printf("m_direction: %d\n", m_direction);
    }

    public static void main(String[] args) {
        CountNumbers count_numbers = new CountNumbers();
        count_numbers.argument_process(args);
        boolean valid = count_numbers.output_set();
        if (valid){
            count_numbers.output_print();
        }
        else{
            System.out.println("Incorrect argument number");
        }
    }
}
