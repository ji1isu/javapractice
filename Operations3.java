class Operations3{
    private int[] m_number_array;
    private int[] m_uniq_number_array;
    private int m_num_duplicated;

    public Operations3(){
        m_num_duplicated = 0;
        m_uniq_number_array = new int[0];
    }

    private int[]  AddValue(int[] numbers, int value){
        int[] tmp = new int[numbers.length+1];
        System.arraycopy(numbers, 0, tmp, 0, numbers.length);
        tmp[numbers.length] = value;
        return tmp;
    }

    private boolean elementinArray(int[] numbers, int element){
        for (int i = 0; i < numbers.length; i++){
            if(numbers[i] == element){
                return true;
            }
        }
        return false;
    }


    private void add_to_uniq_number_array(int[] numbers){
        for (int i = 0; i < numbers.length; i++){
            if(!elementinArray(m_uniq_number_array, numbers[i])){
                m_uniq_number_array = AddValue(m_uniq_number_array, numbers[i]);
            }
        }
    }


    private int countDuplicates_inner(int[] numbers){
            int count_dup = 0;
            for(int i = 0; i < m_uniq_number_array.length; i++){
                int count = 0;
                for (int j = 0; j < numbers.length; j++){
                    if(numbers[j] == m_uniq_number_array[i]){
                        count++;
                        if (count > 1){
                            m_num_duplicated++;
                            break;
                        }
                    }
                }

        }
        return m_num_duplicated;

    }

    static int countDuplicates(int[] list_num){
        Operations3 op = new Operations3();
        op.add_to_uniq_number_array(list_num);
        return op.countDuplicates_inner(list_num);
    }

    public static void main(String[] args){
        int[] list_num = {1, 1, 5, 6, 5, 3, 8, 1, 9, 2, 8};
        int result = countDuplicates(list_num);
        System.out.println(result);
    }
}
