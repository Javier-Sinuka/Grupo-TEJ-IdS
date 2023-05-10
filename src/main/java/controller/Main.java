package main.java.controller;

import main.java.model.entity.Hallway;

public class Main {
    public static void main(String[] args) {
//        GameManager gm=new GameManager();
//        gm.getWindow().revalidate();
//        gm.getWindow().repaint();
        Hallway hallway = new Hallway();
        System.out.println(hallway.iItemStore());
    }
}