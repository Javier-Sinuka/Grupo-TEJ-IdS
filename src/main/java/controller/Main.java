package main.java.controller;
import main.java.controller.gameManager.GameManager;
public class Main {
    public static void main(String[] args) {
        GameManager gm = new GameManager();
        gm.getStudent().setDogecoin(46);
        gm.getWindow().revalidate();
        gm.getWindow().repaint();
    }
}