package main.java.model.entity;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UIStore extends JPanel {
    UIStudent student;
    Boolean bar;

    public UIStore(UIStudent student, Boolean bar){
        super();
        this.bar = bar;
        this.student = student;
        propertiesStore();
    }

    public void propertiesStore(){
        this.setSize(GameWindow.WIDTH,GameWindow.HEIGHT);
        this.setVisible(false);
        this.setLayout(null);
        this.setBackground(Color.yellow);
        if (bar) {
            buttons("COMPRAR CAFE", 100, 100, 600, 50);
            buttons("COMPRAR MATE", 100, 200, 600, 50);
        }else{
            buttons("COMPRAR CALCULADORA", 100,100,600,50);
            buttons("COMPRAR KIT DE COMPANENTES ELECTRONICOS", 100,200,600,50);
        }
    }

    public void buttons(String text,int x,int y,int width, int height){
        JButton itemOneButton = new JButton(text);
        itemOneButton.setBounds(x,y,width,height);
        this.add(itemOneButton);
    }

    public void dogeLabel(){
        JLabel dogeLabel = new JLabel();
    }
}
