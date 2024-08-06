public class Operations2 {
    private int[] list_num;

    public Operations2() {
        list_num = new int[0];
    }

    private boolean notInArray(int[] a, int element) {
        for (int item : a) {
            if (item == element) {
                return false;
            }
        }
        return true;
    }

    private void addToListNum(int[] a) {
        for (int num : a) {
            if (notInArray(list_num, num)) {
                list_num = addToArray(list_num, num);
            }
        }
    }

    private int[] addToArray(int[] array, int value) {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = value;
        return newArray;
    }

    static int countDuplicates(int[] a, int[] list_num) {
        int count = 0;
        for (int num : list_num) {
            int num_count = 0;
            for (int element : a) {
                if (num == element) {
                    num_count++;
                }
            }
            if (num_count > 1) {
                count += (num_count);
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] dups = {1, 1, 5, 6, 5, 3, 8, 1, 9, 2, 8};
        Operations2 op = new Operations2();
        op.addToListNum(dups);
        int count = op.countDuplicates(dups, op.list_num);
        System.out.println("Total duplicates: " + count);
    }
}
