package main.java.controller;

import main.java.model.entity.Hallway;
import main.java.model.entity.Store;
import main.java.model.objects.Consumable;
import main.java.model.objects.Item;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        GameManager gm=new GameManager();
//        gm.getWindow().revalidate();
//        gm.getWindow().repaint();
        Consumable mate = new Consumable("Mate", "Genera cafeina de manera eficiente");
        Consumable cafe = new Consumable("Cafe", "Genera cafeina");
        Store barFacu = new Store("Bar de la Facu");
        barFacu.addUsableToList(mate,10);
        barFacu.addUsableToList(cafe, 15);
        System.out.println("Elementos a la venta: \n");
        System.out.println(barFacu.getListUsable().get(0).getName() + " con precio de "+
                barFacu.getListUsable().get(0).getPrice());
        System.out.println(barFacu.getListUsable().get(1).getName() + " con precio de "+
                barFacu.getListUsable().get(1).getPrice());
    }
}