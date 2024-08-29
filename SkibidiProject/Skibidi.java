package SkibidiProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class Skibidi{
    HashMap<String, Integer> allianceMap;
    HashMap<String, Integer> skibidiMap;
    String[] abilityList;
    ArrayList<Integer> skibidiScoreKeeper;
    ArrayList<Integer> allianceScoreKeeper;
    int skibidiScore;
    int allianceScore;

    public Skibidi(){
        //constructors
        allianceMap = new HashMap<>();
        skibidiMap = new HashMap<>();
        abilityList = new String[]{"PowerSurge", "BopShield", "ZapTrap", "EnergyBoost", "TitanBoost"};
        skibidiScoreKeeper = new ArrayList<>();
        allianceScoreKeeper = new ArrayList<>(); 
        skibidiScore = 0;
        allianceScore = 0;
    }

    private String[] parseString(String toParse){
        String[] nowParsed = toParse.split(",\\s*|\\s+");
        return nowParsed;
    }

    private void readFile(String fileName, HashMap<String, Integer> map, ArrayList<Integer> scoreKeeper) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Error: File " + fileName + " not found. Please check the path and try again.");
        }
        if (file.length() == 0) {
            System.out.println("Error: No valid data found in " + fileName + ". Battle cannot proceed.");
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                boolean readSuccess = sortReadLines(line, map, scoreKeeper);
                if (!readSuccess){
                    System.out.println("Error: Invalid parameter for '<ability>' in line '<line_content>'. Line skipped.");
                    continue;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File " + fileName + " not found. Please check the path and try again.");
        } catch (IOException e) {
            System.out.println("An I/O error occurred while reading the file.");
        }
    }

    private void appendToScoreKeeper(HashMap<String, Integer> map, String name, ArrayList<Integer> scoreKeeper, int score){
        if(map.containsKey(name) && !isAbility(name)){
            scoreKeeper.add(score);
        }
    }

    private boolean sortReadLines(String line,  HashMap<String, Integer> map, ArrayList<Integer> scoreKeeper){
            String[] lineParsed = parseString(line);
            if (lineParsed.length >= 2) {
                String name = lineParsed[0]; 
                int attackPower;
                try {
                    attackPower = Integer.parseInt(lineParsed[1]);
                } catch (NumberFormatException e) {
                    return false;
                }
                map.put(name, attackPower);
                appendToScoreKeeper(map, name, scoreKeeper, attackPower);
                return true;
            } else {
                return false;
            }
        }
    

    private boolean isAbility(String abilityName){
        for(int i = 0; i< abilityList.length ; i++){
            if(abilityName.equals(abilityList[i])){
                return true;
            }
        }
        return false;
    }

    private void executeAttack(String attackName, HashMap<String, Integer> map, ArrayList<Integer> scoreKeeper){
        switch (attackName) {
            case "PowerSurge":
                PowerSurge(map, scoreKeeper);
                break;
            case "BopShield":
                BopShield(map, scoreKeeper);
                break;
            case "ZapTrap":
                ZapTrap(map, scoreKeeper);
                break;
            case "EnergyBoost":
                EnergyBoost(map, scoreKeeper);
                break;
            case "Titanboost":
                TitanBoost(map, scoreKeeper);
                break;
            default:
                System.out.println("Warning: Unknown ability '<ability>' detected in '<filename>'. Ignored.");
            }
        }

    private void PowerSurge(HashMap<String, Integer> map, ArrayList<Integer> scoreKeeper){
        Integer value = scoreKeeper.get(0);//TODO: change multiplyBy to percentage
        int multiplyBy = map.get("PowerSurge");
        value = value * multiplyBy;
        scoreKeeper.set(0, value);
    }

    private void BopShield(HashMap<String, Integer> map, ArrayList<Integer> scoreKeeper){
        int multiplyBy = map.get("BopShield");//TODO: change multiplyBy to percentage
        for(int i = 0; i < scoreKeeper.size(); i++){
            Integer value = scoreKeeper.get(i);
            value = value * multiplyBy;
            scoreKeeper.set(i, value);
        }
    }

    private void EnergyBoost(HashMap<String, Integer> map, ArrayList<Integer> scoreKeeper){
        int addBy = map.get("EnergyBoost");
        for(int i = 0; i < scoreKeeper.size(); i++){
            Integer value = scoreKeeper.get(i);
            value = value + addBy;
            scoreKeeper.set(i, value);
        }
    }

    private void ZapTrap(HashMap<String, Integer> map, int Score){
        int minusBy = map.get("ZapTrap");
        //if Score name is skibidiScore, minus from allianceScore
        //allianceScore -= minusBy
        //if Score name is allianceScore, minus from skibidiScore
        //skibidiScore -= minusBy

    } 

    private void TitanBoost(HashMap<String, Integer> map, ArrayList<Integer> scoreKeeper){
        Integer value = scoreKeeper.get(scoreKeeper.size() - 1);
        int multiplyBy = map.get("PowerSurge");
        value = value * multiplyBy;
        value = scoreKeeper.set(scoreKeeper.size() - 1, value);
    }

    private void calculateWinner(){
        for (Integer num : skibidiScoreKeeper) {
            skibidiScore += num;
        }
        for (Integer num : allianceScoreKeeper) {
            allianceScore += num;
        }
        if(skibidiScore > allianceScore){
            System.out.println("Battle result: Skibidi wins");
        } else if(skibidiScore < allianceScore){
            System.out.println("Battle result: Alliance wins");
        } else{
            System.out.println("TIE");
        }

    }
    public static void main(String[] args){
        //tests
        Skibidi skbd = new Skibidi();
        skbd.readFile("SkibidiProject/skibidi.txt", skbd.skibidiMap, skbd.skibidiScoreKeeper);
        System.out.println(skbd.skibidiMap);
        System.out.println(skbd.isAbility("BopShield"));
        System.out.println(skbd.isAbility("G-Toilet"));
        System.out.println(skbd.skibidiScoreKeeper);
        //main
        skbd.readFile("SkibidiProject/skibidi.txt", skbd.skibidiMap, skbd.skibidiScoreKeeper);
        skbd.readFile("SkibidiProject/skibidi.txt", skbd.allianceMap, skbd.allianceScoreKeeper);
        for (String key : skbd.skibidiMap.keySet()) {
            if(skbd.isAbility(key)){
                skbd.executeAttack(key, skbd.skibidiMap, skbd.skibidiScoreKeeper);
            }
        }
        for (String key : skbd.allianceMap.keySet()) {
            if(skbd.isAbility(key)){
                skbd.executeAttack(key, skbd.allianceMap, skbd.allianceScoreKeeper);
            }
        }
        skbd.calculateWinner();
    }
}