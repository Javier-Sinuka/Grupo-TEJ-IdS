package main.java.model.entity;

public class Student {
    private String nameStudent;
    private int lifeBar, coffeBar, walking, walkingB, credits;
    private int dogeCoin;

    public Student(String nameStudent, int amountLifeBar, int amountCoffeBar, int amountToWalk, int amountOfDogueCoin) {
        this.nameStudent = nameStudent;
        this.lifeBar = amountLifeBar;
        this.coffeBar = amountCoffeBar;
        this.walking = amountToWalk;
        this.walkingB = amountToWalk;
        this.credits = 0;
        this.dogeCoin = amountOfDogueCoin;
    }
    public Student(int amountLifeBar, int amountCoffeBar, int amountToWalk, int amountOfDogueCoin) {
        this.nameStudent = "";
        this.lifeBar = amountLifeBar;
        this.coffeBar = amountCoffeBar;
        this.walking = amountToWalk;
        this.walkingB = amountToWalk;
        this.credits = 0;
        this.dogeCoin = amountOfDogueCoin;
    }

    public Student() {
    }

    //*************************** GETTERS *********************************
    public String getNameStudent() {
        return this.nameStudent;
    }
    public int getLifeBar() {
        return this.lifeBar;
    }
    public int getCoffeBar(){
        return this.coffeBar;
    }
    public int getDogueCoinInWallet(){
        return this.dogeCoin;
    }
    public int getCredits(){
        return this.credits;
    }

    //*************************** SETTERS *********************************
    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }
    public void increseLifeBar(int lifeBar){
        this.lifeBar += lifeBar;
    }
    /**
     Decrementa uno de vida.
     **/
    public void decreaseLifeBar(){
        lifeBar--;
    }
    /**
     Decrementa un valor especifico de vida
     **/
    public void decreaseLifeBar(int valueDerement){
        this.lifeBar -= valueDerement;
    }
    public void addDogeCoin(int dogeCoin){
        this.dogeCoin += dogeCoin;
    }
    public void decreaseDogeCoin(int amountDecrease){this.dogeCoin -= amountDecrease;}
    public void setDogeCoin(int dogeCoin){this.dogeCoin = dogeCoin;}
    /**
     Decrementa uno de cafe.
     **/
    public void decreaseCafein(){
        coffeBar--;
    }
    public void incrementCafein(int amountCafein){
        coffeBar+= amountCafein;
    }
    public void addCredits(int credits){
        this.credits += credits;
    }
    public void setCredits(int credits){this.credits = credits;}

    //*************************** METODOS PROPIOS *********************************
    /**
        Corrobora los pasos hechos y va decrementando a medida que transciende entre paneles.
        Cuando llega a 0, se le resta uno de cafeina.
     **/
    public void modifedWalkCafein(){
        walking--;
        if (walking == 0){
            decreaseCafein();
            walking = walkingB;
        }
    }
}
