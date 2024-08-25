import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Whalesong {
    HashMap<String, String> whalesToSong;
    String whaleAction;
    String whaleName;
    Scanner scan; 

    public Whalesong(){
        whalesToSong = new HashMap<>();
        whaleAction = null;
        whaleName = null;
        scan = new Scanner(System.in);
    }
    
    private boolean whaleHasSong(String whale, String song) {
        String whaleSong = whalesToSong.get(whale);

        return whaleSong != null && whaleSong.equals(song);
    }

    private void commandParser(){
        String commStr = scan.nextLine();

        String[] comms = commStr.split("\\s+");
        whaleAction = comms[0];
        whaleName = comms[1];
    }

    private void add(){
        if(whalesToSong.containsKey(whaleName)){
            System.out.println("printError: Whale already has a song.");
        }

        else{
            String song = scan.nextLine();
            whalesToSong.put(whaleName, song);
            System.out.println(song + " added for " + whaleName);
        }
    }

    private void play(){
        if (!whalesToSong.containsKey(whaleName)) {
            System.out.println("Error: No song found for this whale.");
        }
        else{
            String song = whalesToSong.get(whaleName);
            System.out.println(song);
        }
    }

    private void hear(){
        if (!whalesToSong.containsKey(whaleName)) {
            System.out.println("Error: No song found for this whale.");
        }
        else{
            String song = whalesToSong.get(whaleName);
            System.out.println("Song for "+ whaleName+ ": " + song);
        }
    }

    private void augment(){
        if (!whalesToSong.containsKey(whaleName)){
            System.out.println("Error: No song to augment.");
        }
        else{
            String song = whalesToSong.get(whaleName);
            song = song + song;
            whalesToSong.put(whaleName, song);
            System.out.println("Augmented song: " + song);
        }
    }

    private void clarify(){
        if (!whalesToSong.containsKey(whaleName)){
            System.out.println("Error: No song to clarify.");
        }
        else{
            String song = whalesToSong.get(whaleName);
            song = song.replaceAll("a", "A")
           .replaceAll("e", "E")
           .replaceAll("i", "I")
           .replaceAll("o", "O")
           .replaceAll("u", "U");
            whalesToSong.put(whaleName, song);
            System.out.println("Clarified song: " + song);
        }        
    }

    private void normalise(){
        if (!whalesToSong.containsKey(whaleName)){
            System.out.println("Error: No song to normalise.");
        }
        else{
            String song = whalesToSong.get(whaleName);
            song = song.toLowerCase();
            whalesToSong.put(whaleName, song);
            System.out.println("Normalised song: " + song);
        }
    }

    private void reverse(){
        if (!whalesToSong.containsKey(whaleName)){
            System.out.println("Error: No song to normalise.");
        }
        else{
            String song = whalesToSong.get(whaleName);
            String reversedSong = new StringBuilder(song).reverse().toString();
            whalesToSong.put(whaleName, reversedSong);
            System.out.println("Reversed song: " + reversedSong);            
        }
    }

    private void mirror(){
        if (!whalesToSong.containsKey(whaleName)){
            System.out.println("Error: No song to mirror.");
        }
        else{
            String song = whalesToSong.get(whaleName);
            String reversedSong = new StringBuilder(song).reverse().toString();
            String mirroredSong = song + reversedSong;
            whalesToSong.put(whaleName, mirroredSong);
            System.out.println("Reversed song: " + mirroredSong);     
        }
    }

    private void uppercase(){
        if (!whalesToSong.containsKey(whaleName)){
            System.out.println("Error: No song to uppercase.");
        }
        else{
            String song = whalesToSong.get(whaleName);
            song = song.toUpperCase();
            whalesToSong.put(whaleName, song);
            System.out.println("Uppercase song: " + song);
        }
    }   

    private void pattern(){
        if (!whalesToSong.containsKey(whaleName)){
            System.out.println("Error: No song to uppercase.");
        }
        else{
            String song = whalesToSong.get(whaleName);
            String newSong = "";
            for(int i = 0; i < song.length(); i++){
                newSong += song.charAt(i) + "*";
            }
            whalesToSong.put(whaleName, newSong);
            System.out.println("Patterned song: " + newSong);
        }
    }

    private void echo(){
        if (!whalesToSong.containsKey(whaleName)){
            System.out.println("Error: No song to echo.");
        }
        else{
            String song = whalesToSong.get(whaleName);
            String newSong = song;
            int index = song.length() - 3;
            for(int i = 0; i < 5; i++){
                if (index >= 0 && index < song.length()){
                    newSong += song.charAt(index);
                    newSong += song.charAt(index+1);
                    newSong += song.charAt(index+2);
                }
            }
            whalesToSong.put(whaleName, newSong);
            System.out.println("Echoed song: " + newSong);
        }
    }

    private void compress(){
        if (!whalesToSong.containsKey(whaleName)){
            System.out.println("Error: No song to compress.");
        }
        else{
            String song = whalesToSong.get(whaleName);
            song = song.replaceAll("a", "")
           .replaceAll("e", "")
           .replaceAll("i", "")
           .replaceAll("o", "")
           .replaceAll("u", "")
            .replaceAll("A", "")
           .replaceAll("E", "")
           .replaceAll("I", "")
           .replaceAll("O", "")
           .replaceAll("U", "")
           ;
            whalesToSong.put(whaleName, song);
            System.out.println("Compressed song: " + song);
        }
    }
    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private String doubleCons(String ogString){
        String result = "";
        for (int i = 0; i < ogString.length(); i++) {
            char c = ogString.charAt(i);

            if (Character.isLetter(c) && !isVowel(c)) {
                result += c; 
                result += c; 
            } else {
                result += c;
            }
        }
        return result;
    }

    private void expand(){
        if (!whalesToSong.containsKey(whaleName)){
            System.out.println("Error: No song to expand.");
        }
        else{
            String song = whalesToSong.get(whaleName);
            song = doubleCons(song);
            whalesToSong.put(whaleName, song);
            System.out.println("Expanded song: " + song);
        }
    }

    private String invertString(String ogString){
        String result = "";

        for (int i = 0; i < ogString.length(); i++) {
            char c = ogString.charAt(i);
            if (Character.isUpperCase(c)) {
                result += Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
                result += Character.toUpperCase(c);
            } else {
                result += c;
            }
        }

        return result;
    }

    private void invert(){
        if (!whalesToSong.containsKey(whaleName)){
            System.out.println("Error: No song to invert.");
        }
        else{
            String song = whalesToSong.get(whaleName);
            song = invertString(song);
            whalesToSong.put(whaleName, song);
            System.out.println("Inverted song: " + song);
        }
    }

    private void exit(){
        exit();
    }

    public static void main(String[] args) {

        Whalesong ws = new Whalesong();
        while(true){
            ws.commandParser();
            if (ws.whaleAction.equals("add")){
                ws.add();
            }
            else if (ws.whaleAction.equals("play")){
                ws.play();
            }
            else if (ws.whaleAction.equals("hear")){
                ws.hear();
            }
            else if (ws.whaleAction.equals("augment")){
                ws.augment();
            }
            else if (ws.whaleAction.equals("clarify")){
                ws.clarify();
            }
            else if (ws.whaleAction.equals("normalise")){
                ws.normalise();
            }
            else if (ws.whaleAction.equals("reverse")){
                ws.reverse();
            }
            else if (ws.whaleAction.equals("mirror")){
                ws.mirror();
            }
            else if (ws.whaleAction.equals("uppercase")){
                ws.uppercase();
            }
            else if (ws.whaleAction.equals("pattern")){
                ws.pattern();
            }
            else if (ws.whaleAction.equals("echo")){
                ws.echo();
            }
            else if (ws.whaleAction.equals("compress")){
                ws.compress();
            }
            else if (ws.whaleAction.equals("expand")){
                ws.expand();
            }
            else if (ws.whaleAction.equals("invert")){
                ws.invert();
            }
            else if (ws.whaleAction.equals("exit")){
                ws.exit();
            }
        }

    }

}