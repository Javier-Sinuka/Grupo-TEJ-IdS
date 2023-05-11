package main.java.model.entity;
import javax.swing.*;
import java.awt.*;

import static java.lang.Math.random;

public class UIHallway extends JPanel {
    private String hallwayName;
    private Color colorDeFondo;
    public UIHallway(String hallwayName, Color colorDeFondo){
        super();
        this.hallwayName = hallwayName;
        this.colorDeFondo = colorDeFondo;

       parametersHallway();
       titleLbael(this.hallwayName);
       randomObject();
    }
    public void parametersHallway(){
        this.setSize(GameWindow.WIDTH,GameWindow.HEIGHT);
        this.setVisible(false);
        this.setLayout(null);
        this.setBackground(colorDeFondo);
    }
    public void randomObject(){
        int x = (int)(Math.random()*400+150);
        int y = (int)(Math.random()*400+150);
        //Funcion valor random x
        //Funcion valor random y
        //Funcion valor random img

        JLabel object = new JLabel();
        object.setBounds(x,y,100,50);
        object.setOpaque(true);
        object.setBackground(Color.BLACK);
        this.add(object);
    }
    public void titleLbael (String hallwayName){
        JLabel title = new JLabel(hallwayName);
        title.setBounds(10,630,100,50);
        this.add(title);
    }
}
