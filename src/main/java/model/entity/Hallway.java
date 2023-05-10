package main.java.model.entity;

import main.java.model.objects.IConsumable;
import main.java.model.objects.IItemStore;

import java.util.Random;

public class Hallway {
    private int x,y;

    private IConsumable iConsumable;

    private IItemStore iItemStore;

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

    public IItemStore iItemStore(){
//        Random random = new Random();
//        int randomNumber = random.nextInt((1 - 0) + 1) + 0;
//        if (randomNumber == 1){
//            return iItemStore;
//        }
        return iItemStore;
    }
}
