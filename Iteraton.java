public class Iteration{
    public static final String[] words = {
        "one",
        "two",
        "three",
        "four"
    };
    public static final int words_length = 4;

    public void forLoopVCU(){
        //for (variable; condition; update) here!
        for(int i = 0; i < words_length; i ++){
            System.out.println(words[i]);
        }
    }

    public static void forLoopIterator(){
        //for (binding : collection) here!
        String s = "for loop";
        for(char c: s.toCharArray()){
            System.out.println(c);
        }
    }

    public static void main(String[] args){
        forLoopVCU();
        forLoopIterator();
    }
}
