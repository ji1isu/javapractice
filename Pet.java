import java.util.ArrayList;
import java.util.Arrays;
public class Pet{
    private String name;
    private int age;
    private String species;
    private String[] nicknames;
    private boolean isHouseTrained;

    public void addNickname(String newNickname) {
        String[] newNicknames = new String[nicknames.length + 1];
        for (int i = 0; i < nicknames.length; i++) {
            newNicknames[i] = this.nicknames[i];
        }
        newNicknames[this.nicknames.length] = newNickname;
        this.nicknames = newNicknames;
    }

    public Pet(String name, int age, String species){
        this.name = name;
        this.age = age;
        this.species = species;
        this.nicknames = new String[0];
        this.isHouseTrained = false;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public String getSpecies(){
        return this.species;
    }

    public boolean equals(Pet thatPet) {
        return this.name.equals(thatPet.name) && this.age == thatPet.age && this.species.equals(thatPet.species);
    }

    public boolean hasNickname(String nickName){
        for(int i = 0; i < this.nicknames.length; i++){
            if(nickName == this.nicknames[i]){
                return true;
            }
        }return false;
    }

    public static Pet oldestPet(Pet[] pets) {
        if (pets == null || pets.length == 0) {
            return null;
        }

        Pet oldest = pets[0];
        for (int i = 1; i < pets.length; i++) {
            if (pets[i] != null && pets[i].getAge() > oldest.getAge()) {
                oldest = pets[i];
            }
        }
        return oldest;
    }

    public static void main(String[] args){
        Pet pet = new Pet("jig", 12, "nada");
        Pet pet2 = new Pet("jig", 12, "nada");
        Pet pet3 = new Pet("jig", 17, "nada");

        System.out.printf("%s, %d, %s \n", pet.name, pet.age, pet.species);
        pet.addNickname("addednickname");
        System.out.printf("%s \n", pet.equals(pet2));
        System.out.printf("%s \n", pet.equals(pet3));
    }
}