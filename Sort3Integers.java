public class Sort3Integers {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);

        int largest;
        int middle;
        int smallest;
        
        if (x >= y && x >= z) {
            largest = x;
            if (y >= z) {
                middle = y;
                smallest = z;
            } else {
                middle = z;
                smallest = y;
            }
        } else if (y >= x && y >= z) {
            largest = y;
            if (x >= z) {
                middle = x;
                smallest = z;
            } else {
                middle = z;
                smallest = x;
            }
        } else {
            largest = z;
            if (x >= y) {
                middle = x;
                smallest = y;
            } else {
                middle = y;
                smallest = x;
            }
        }

        System.out.println(largest);
        System.out.println(middle);
        System.out.println(smallest);
    }
}
