package main.java.controller;
public class Main {
    public static void main(String[] args) {
        GameManager gm=new GameManager();
        gm.getWindow().revalidate();
        gm.getWindow().repaint();
    }
}