package model.entity;

import model.objects.Item;
import model.objects.Usable;

import java.util.ArrayList;

/**
 * Clase que genera al Estudiante.
 *
 * Puede generarse vacio o con nombre asociado, o sin nombre asociado.
 *
 * Es necesario especificar:
 *          - Barra de vida (Siendo este el maximo especificado y el minimo "0")
 *          - Barra de cafeina (Siendo este el maximo especificado y el minimo "0")
 *          - Monto a poseer inicialmente en la billetera en DogeCoin (es un entero)
 *          - Maximo a caminar antes de decrementar la cafeina en 1 (Ej: 10, si se mueve 10 veces entre
 *          paneles, se le descuenta 1 de la barra de cafeina).
 */
public class Student {
    private String nameStudent;
    private int lifeAmount, coffeeAmount, walking,
            walkingB, credits, dogeCoin;
    private ArrayList<Usable> backpack;

    public Student(String nameStudent, int lifeAmount, int CoffeeAmount, int amountToWalk, int amountOfDogeCoin) {
        this.nameStudent = nameStudent;
        this.lifeAmount = lifeAmount;
        this.coffeeAmount = CoffeeAmount;
        this.walking = amountToWalk;
        this.walkingB = amountToWalk;
        this.credits = 0;
        this.dogeCoin = amountOfDogeCoin;
        this.backpack = new ArrayList<>();
    }

    public Student(int amountLifeBar, int amountCoffeBar, int amountToWalk, int amountOfDogeCoin) {
        this.nameStudent = "";
        this.lifeAmount = amountLifeBar;
        this.coffeeAmount = coffeeAmount;
        this.walking = amountToWalk;
        this.walkingB = amountToWalk;
        this.credits = 0;
        this.dogeCoin = amountOfDogeCoin;
        this.backpack = new ArrayList<>();
    }

    public Student() {
        this.backpack = new ArrayList<>();
        dogeCoin = 1000;
        //Test values
        backpack.add(new Item("Calculadora","Mas valiosa que la biblia"));
        credits=4;
    }

    //*************************** GETTERS *********************************
    public String getNameStudent() {
        return this.nameStudent;
    }

    public int getLifeAmount() {
        return this.lifeAmount;
    }

    public int getCaffeineAmount() {
        return this.coffeeAmount;
    }

    public int getDogeCoinInWallet() {
        return this.dogeCoin;
    }

    public int getCredits() {
        return this.credits;
    }

    public ArrayList<Usable> getBackpack() {
        return this.backpack;
    }

    //*************************** SETTERS *********************************
    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public void increseLifeBar(int lifeBar) {
        this.lifeAmount += lifeBar;
    }

    /**
     * Decrementa uno de vida.
     **/
    public void decreaseLifeBar() {
        lifeAmount--;
    }

    /**
     * Decrementa un valor especifico de vida
     **/
    public void decreaseLifeBar(int DecrementValue) {
        this.lifeAmount -= DecrementValue;
    }

    public void addDogeCoin(int dogeCoin) {
        this.dogeCoin += dogeCoin;
    }

    public void decreaseDogeCoin(int decreaseAmount) {
        this.dogeCoin -= decreaseAmount;
    }

    public void setDogeCoin(int dogeCoin) {
        this.dogeCoin = dogeCoin;
    }

    /**
     * Decrementa uno de cafe.
     **/
    public void decreaseCaffeine() {
        coffeeAmount -= 5;
    }

    public void incrementCaffeine(int amountCafein) {
        coffeeAmount += amountCafein;
    }

    public void addCredits(int credits) {
        this.credits += credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void addUsableInBackpack(Usable usable) {
        this.backpack.add(usable);
    }

    /**
     * Metodo que elimina un objeto de la mochila.
     * El objeto debe de tener el mismo nombre que el que se desea eliminar.
     *
     * @param usable
     */
    public void deleteUsableInBackpack(Usable usable) {
        for (int i = 0; i < backpack.size(); i++) {
            if (usable.getName().toLowerCase().equals(backpack.get(i).getName().toLowerCase())) {
                this.backpack.remove(i);
                break;
            }
        }
    }

    public void deleteAllItemBackpack(){
        this.backpack.clear();
    }

    public void setCoffeeAmount (int coffeeAmount){
        this.coffeeAmount = coffeeAmount;
    }

    //*************************** METODOS PROPIOS *********************************

    /**
<<<<<<< HEAD
     * Corrobora los pasos hechos y va decrementando a medida que transciende entre paneles.
     * Cuando llega a 0, se le resta uno de cafeina.
=======
     Corrobora los pasos hechos y va decrementando a medida que transciende entre paneles.
     Cuando llega a 0, se le resta uno de cafeina.
>>>>>>> feature/UIButton-UIclassroom
     **/
    public void modifyWalkCaffeine() {
        walking--;
        if (walking == 0) {
            decreaseCaffeine();
            walking = walkingB;
        }
    }

    public void printBP() {
        for (Usable us : backpack) {
            System.out.println(us.getName());
        }
    }

    public void setLifeAmount(int i) {
        this.lifeAmount=i;
    }
}




