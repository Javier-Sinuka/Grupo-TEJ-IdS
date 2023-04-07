package main.java.controller.ui;
import javax.swing.*;
public class Window extends JFrame{
    private int WIDTH = 900;
    private int HEIGHT = 600;
    public Window (){
        this.setTitle("La Facultad");
        this.setSize(WIDTH,(HEIGHT));//ancho,largo
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);//ventana en el centro
        this.setVisible(true);
        this.setLayout(null);
    }
     public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
}
/*
    ImageIcon fondo = new ImageIcon(getClass().getClassLoader().getResource("res/fondo.jpg"));

     label.setIcon(fondo);

 */