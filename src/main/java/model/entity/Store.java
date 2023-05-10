package main.java.model.entity;

import main.java.model.objects.Usable;

import java.util.ArrayList;

public class Store {
    String nameStore;
    ArrayList<Usable> listUsable;
    public Store(String nameStore){
        this.nameStore = nameStore;
        this.listUsable = new ArrayList<>();
    }
    public Store(){
        this.listUsable = new ArrayList<>();
    }
    public String getNameStore() {
        return nameStore;
    }
    public ArrayList<Usable> getListUsable() {
        return listUsable;
    }
    public void addUsableToList(Usable usable,int priceUsable){
        usable.setPrice(priceUsable);
        this.listUsable.add(usable);
    }
    public int getPriceUsable(Usable usable){
        return usable.getPrice();
    }
}
