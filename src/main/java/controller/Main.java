package controller;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GameManager gm=new GameManager();
        gm.getWindow().revalidate();
        gm.getWindow().repaint();
    }
}