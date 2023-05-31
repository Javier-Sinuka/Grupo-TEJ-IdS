package main.java.controller;

import main.java.model.entity.Hallway;
import main.java.model.entity.Store;
import main.java.model.entity.Student;
import main.java.model.objects.Consumable;
import main.java.model.objects.Item;
import main.java.model.objects.Usable;

import javax.swing.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        GameManager gm=new GameManager();
        gm.getWindow().revalidate();
        gm.getWindow().repaint();
    }
}

/*
    ImageIcon imageDogecoin = new ImageIcon(getClass().getClassLoader().getResource("main/assets/img/dogecoin.png"));
    String coin = Integer.toString(getDogeCoin());
    JLabel dogecoinLabel = new JLabel(coin,imageDogecoin,0);
        dogecoinLabel.setBounds(915,10,300,60);
 */