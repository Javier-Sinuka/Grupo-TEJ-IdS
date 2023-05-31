package main.java.model.objects;

public class Item implements Usable {
    private String name, description;
    boolean isTaken;
    private int price;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.isTaken = false;
        this.price = 0;
    }

    public Item() {
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean getIsTaken() {
        return this.isTaken;
    }

    @Override
    public void setTaken(boolean isTaken) {
        this.isTaken = isTaken;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }
}
