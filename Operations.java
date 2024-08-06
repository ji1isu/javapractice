class Operations{
    private int count;

    public Operations(){
        count = 0;
    }

    private boolean contains(int[] a, int element){
        for(int i = 0; i < a.length; i ++){
            if(a[i] == element){
                return true;
            }
        }
        return false;
    }

    private int count(int[] a, int element){
        for(int i = 0; i < a.length; i ++){
            if(a[i] == element){
                count ++;
            }
        }
        return count;        
    }

    public static void main(String[] args){
        Operations op = new Operations();
        int[] array = {1, 1, 5, 6, 5, 3, 8, 1, 9, 2, 8};
        int result = op.count(array, 1);
        System.out.println(result);
    }
}

