package main.java.controller;

import main.java.model.entity.Store;

public class Main {
    public static void main(String[] args) {

//        GameManager gm=new GameManager();
//        gm.getWindow().revalidate();
//        gm.getWindow().repaint();
        Store store = new Store("Electronica Argentina", "Resistencias", 10);
        store.getContent();
    }
}