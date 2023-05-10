package main.java.model.entity;

import main.java.model.objects.Consumable;
import main.java.model.objects.IDogeCoin;
import main.java.model.objects.Item;
import main.java.model.objects.Usable;

public class Hallway {
    private int x,y;
    private Consumable consumable;
    private Item item;

    public Hallway(String type, String nameUsable, String descripcionUsable) {
        this.x = 0;
        this.y = 0;
        if(type == "Consumable" || type == "consumable"){
            this.consumable = new Consumable(nameUsable,descripcionUsable);
        }else if (type == "Item" || type == "item"){
            this.item = new Item(nameUsable, descripcionUsable);
        }else{System.out.println("Tipo no aceptado");}
    }
    public Hallway() {
        this.x = 0;
        this.y = 0;
    }
    //*************************** METODOS PROPIOS *********************************
    public int getRandomX(){
        return (int)(Math.random()*400+150);
    }
    public int getRandomY(){
        return (int)(Math.random()*400+150);
    }
//    public Usable getRandomUsable(){
//
//    }


}
