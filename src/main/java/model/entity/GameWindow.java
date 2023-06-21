package model.entity;

import javax.swing.*;

public class GameWindow extends JFrame {

    public static final int WIDTH=1280;
    public static final int HEIGHT=720;

    public GameWindow(){

        this.setTitle("FCEFyN MADNESS");
        this.setSize(WIDTH,HEIGHT);//ancho,largo
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);//ventana en el centro
        this.setVisible(true);
        this.setLayout(null);
    }


}
