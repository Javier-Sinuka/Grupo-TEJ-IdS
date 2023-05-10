package main.java.model.entity;

import main.java.model.objects.IDogeCoin;

public class Student {
    private String nameStudent;
    private int lifeBar;
    IDogeCoin iDogueCoins[];

    public Student(String nameStudent, int lifeBar, int amountOfDogueCoin) {
        this.nameStudent = nameStudent;
        this.lifeBar = lifeBar;
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
    public void setLifeBar(int lifeBar) {
        this.lifeBar = lifeBar;
    }

}
