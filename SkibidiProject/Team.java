import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Team {
    private String[] abilityList = new String[]{"PowerSurge", "BopShield", "EnergyBoost", "TitanBoost", "ZapTrap"};
    private boolean isTrapping;
    private ArrayList<Double> characterScores;
    private HashMap<String, Double> ability;
    private String fileName;
    private boolean mode;

    public Team(String cability_file_path){
        fileName = cability_file_path;
        isTrapping = false;
        characterScores = new ArrayList<Double>();
        ability = new HashMap<String, Double>();
        mode = false;
    }

    private boolean isAbility(String word)
    {
        if (Arrays.asList(abilityList).contains(word))
        {
            return true;
        }
        return false;
    }

    private void apply_ability(String abilityName)
    {
        switch (abilityName) {
            case "PowerSurge":
                PowerSurge();
                break;
            case "BopShield":
                BopShield();
                break;
            case "EnergyBoost":
                EnergyBoost();
                break;
            case "TitanBoost":
                TitanBoost();
                break;
            case "ZapTrap":
                isTrapping = true;
                break;
            default:
                System.out.println("Warning: Unknown ability " + abilityName + " detected in " + fileName +". Ignored.");
            }
    }

    private void PowerSurge(){
        Double value = characterScores.get(0);
        double multiplyBy = ability.get("PowerSurge");
        double multiplyByPercentage = (multiplyBy * 0.01) + 1;
        value = value * multiplyByPercentage;
        characterScores.set(0, value);
    }

    private void BopShield(){
        double multiplyBy = ability.get("BopShield");
        double multiplyByPercentage = (multiplyBy * 0.01) + 1;
        for(int i = 0; i < characterScores.size(); i++){
            double value = characterScores.get(i);
            value = value * multiplyByPercentage;
            characterScores.set(i, value);
        }
    }

    private void EnergyBoost(){
        double addBy = ability.get("EnergyBoost");
        for(int i = 0; i < characterScores.size(); i++){
            double value = characterScores.get(i);
            value = value + addBy;
            characterScores.set(i, value);
        }
    }

    private double ZapTrap(double Score){
        double plusBy = ability.get("ZapTrap");
        Score += plusBy;
        return Score;
    } 

    private void TitanBoost(){
        double value = characterScores.get(characterScores.size() - 1);
        double multiplyBy = ability.get("TitanBoost");
        value = value * multiplyBy;
        value = characterScores.set(characterScores.size() - 1, value);
    }



    private void readFile(String fileName){
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Error: File '" + fileName + "' not found. Please check the path and try again.");
            System.exit(0);
        }
        if (file.length() == 0) {
            System.out.println("Error: No valid data found in '" + fileName + "'. Battle cannot proceed.");
            System.exit(0);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                boolean readSuccess = sortReadLines(line);
                if (!readSuccess){
                    System.out.println("Error: Invalid parameter for '" + parseString(line)[0] + "' in line '" + line + "'. Line skipped.");
                    continue;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File '" + fileName + "' not found. Please check the path and try again.");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("An I/O error occurred while reading the file.");
            System.exit(0);
        }
    }

    private String[] parseString(String toParse){
        String[] nowParsed = toParse.split(",\\s*|\\s+");
        return nowParsed;
    }

    private void appendScore(String name, Double attackPower){
        if(!isAbility(name)){
            characterScores.add(attackPower);
        }
    }

    private boolean sortReadLines(String line){
        String[] lineParsed = parseString(line);
        if (lineParsed.length >= 2) {
            String name = lineParsed[0]; 
            Double attackPower;
            try {
                attackPower = Double.parseDouble(lineParsed[1]);
            } catch (NumberFormatException e) {
                return false;
            }
            checkAbility(name, attackPower);
            return true;
        } else {
            return false;
        }
    }

    private void checkAbility(String name, Double score){
        if (isAbility(name)){
            mode = true;
            ability.put(name, score);
        }
        else
        {
            if(mode==true)
            {
                System.out.println("Warning: Unknown ability " + name + " detected in " + fileName + ". Ignored.");
            }
            else{
                appendScore(name, score);
            }
        }
    }

    public void executeAll(){
        readFile(fileName);
        for(String anAbility : ability.keySet()){
            apply_ability(anAbility);
        }
    }
   
    public double score_get()
    {
        double final_score = 0;
        for (double num : characterScores) {
            final_score += num;
        }
        if(isTrapping){
            final_score = ZapTrap(final_score);
        }
        return final_score;
    }

}
