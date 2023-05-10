package main.java.model.objects;
/**
 * Clase Padre que especifica elementos de tipo Usable.
 */
public class Usable {
    private String name, description;
    private boolean isTaken;
    private int price;

    public Usable(String name, String description) {
        this.name = name;
        this.description = description;
        this.isTaken = false;
        this.price = 0;
    }

    public Usable() {
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getPrice(){return this.price;}
    public void setName(String name) {
        this.name = name;
    }
    public boolean getIsTaken(){
        return isTaken;
    }
    public void setTaken(boolean isTaken){
        this.isTaken = isTaken;
    }
    public void setPrice(int price){this.price=price;}
}
