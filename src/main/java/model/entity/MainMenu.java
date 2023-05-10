package main.java.model.entity;

import org.w3c.dom.html.HTMLImageElement;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {
    ImageIcon img;
    public MainMenu(ImageIcon img){
        super();
        this.img = img;
        this.setSize(GameWindow.WIDTH,GameWindow.HEIGHT);
        this.setLayout(null);
        this.setVisible(true);

        setGameNameLabel();
    }
    public void setGameNameLabel(){

        JLabel title = new JLabel("Game name");
        title.setBounds(440,160,400,100);
        title.setFont(new Font("Arial Black", Font.BOLD,50));
        title.setOpaque(true);
        title.setBackground(Color.RED);
        title.setHorizontalAlignment(0);
        this.add(title);
    }

    public void paintComponent(Graphics g){
        g.drawImage(img.getImage(),0,0,getWidth(),getHeight(), this);
    }
}
