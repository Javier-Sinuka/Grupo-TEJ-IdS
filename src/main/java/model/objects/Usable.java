package main.java.model.objects;

public class Usable {
    private String name, description;
    private boolean isTaken;

    public Usable(String name, String description) {
        this.name = name;
        this.description = description;
        this.isTaken = false;
    }

    public Usable() {
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean getIsTaken(){
        return isTaken;
    }
    public void setTaken(boolean isTaken){
        this.isTaken = isTaken;
    }
}
