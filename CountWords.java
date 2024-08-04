public class CountWords{
    static int countVowels(String s){
        //your code here!
        int vowel_count = 0;
        for(char c: s.toCharArray()){
            if(c == 'a' ||c == 'e' ||c == 'i' ||c == 'o' ||c == 'u'){
                vowel_count ++;
            }
        }
        return vowel_count;

    }

    public static void main(String[] args){
        String s = "astronaut";
        int count = countVowels(s);
        System.out.println("Number of count: " + count); //4
    }
}