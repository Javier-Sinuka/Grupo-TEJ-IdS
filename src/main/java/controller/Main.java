package main.java.controller;

import main.java.model.entity.Student;

public class Main {
    public static void main(String[] args) {

        GameManager gm=new GameManager();
        gm.getWindow().revalidate();
        gm.getWindow().repaint();
    }
}