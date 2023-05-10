package main.java.model.entity;

import main.java.model.objects.Consumable;
import main.java.model.objects.IDogeCoin;
import main.java.model.objects.Item;

public class Hallway {
    private int x,y;

    private Consumable consumable;

    private Item item;

    public Hallway() {
        this.x = 0;
        this.y = 0;
    }

    public int getRandomX(){
        return (int)(Math.random()*400+150);
    }
    public int getRandomY(){
        return (int)(Math.random()*400+150);
    }


}
