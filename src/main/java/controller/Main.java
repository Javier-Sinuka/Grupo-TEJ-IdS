package controller;

import model.entity.Hallway;
import model.entity.Store;
import model.entity.Student;
import model.objects.Consumable;
import model.objects.Item;
import model.objects.Usable;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        GameManager gm=new GameManager();
        gm.getWindow().revalidate();
        gm.getWindow().repaint();
    }
}