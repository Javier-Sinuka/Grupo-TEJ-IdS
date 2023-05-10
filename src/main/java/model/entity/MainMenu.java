package main.java.model.entity;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {
    public MainMenu(){
        super();
        this.setSize(GameWindow.WIDTH,GameWindow.HEIGHT);
        this.setLayout(null);
        this.setVisible(true);

        setGameNameLabel();
    }
    public void setGameNameLabel(){

        JLabel title = new JLabel("Game name");
        title.setBounds(270,100,500,100);
        title.setFont(new Font("Arial Black", Font.BOLD,50)); //(tipo de letra, estilo, tamaño)
        this.add(title);
    }
}
