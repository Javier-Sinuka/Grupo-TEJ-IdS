package main.java.model.entity;

import main.java.model.objects.IDogeCoin;

public class Student {
    private String nameStudent;
    private int lifeBar, coffeBar, walking, walkingB, credits;

    IDogeCoin iDogueCoins[];

    public Student(String nameStudent, int lifeBar, int coffeBar, int walking, int amountOfDogueCoin) {
        this.nameStudent = nameStudent;
        this.lifeBar = lifeBar;
        this.coffeBar = coffeBar;
        this.walking = walking;
        this.walkingB = walking;
        this.credits = 0;
        this.iDogueCoins = new IDogeCoin[amountOfDogueCoin];
    }

    public Student() {
    }

    //*************************** GETTERS *********************************
    public String getNameStudent() {
        return nameStudent;
    }

    public int getLifeBar() {
        return lifeBar;
    }

    public int getAmountDogueCoinInWallet(){
        return iDogueCoins.length;
    }

    //*************************** SETTERS *********************************
    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }
    public void increseLifeBar(int lifeBar){
        this.lifeBar += lifeBar;
    }

    /*
    Decrementa uno de vida.
     */
    public void decreaseLifeBar(){
        lifeBar--;
    }

    /*
    Decrementa un valor especifico de vida
    */
    public void decreaseLifeBar(int valueDerement){
        this.lifeBar -= valueDerement;
    }

    /*
    Corrobora los pasos hechos y va decrementando a medida que transciende entre paneles.
    Cuando llega a 0, se le resta uno de cafeina.
     */
    public void modifedWalkCafein(){

        walking--;
        if (walking == 0){
            decreaseCafein();
            walking = walkingB;
        }
    }
    public void decreaseCafein(){
        coffeBar--;
    }
    public void incrementCafein(int i){
        coffeBar+= i;
    }
}
