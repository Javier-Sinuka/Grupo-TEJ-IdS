package main.java.model.objects;

public class Usable {
    private String name;
    private String description;

    public Usable(String name, String description) {
        this.name = name;
        this.description = description;
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
}
