package main.java.controller.ui;

import main.java.model.entity.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StartPanel {
    Window window;
    Student student;
    JPanel startPanel;
    JTextArea nameText;
    public StartPanel(Window window, Student student){
        this.window = window;
        this.student = student;
        setStartPanel();
        leftLabel();
        titleLabel();
        nameTextLabel();
    }
    public void setStartPanel(){
        startPanel = new JPanel();
        startPanel.setSize(window.getWIDTH(),window.getHEIGHT());
        startPanel.setBackground(new Color(47,97,101));
        startPanel.setVisible(true);
        startPanel.setLayout(null);
    }
    public void leftLabel(){
        //Etiqueta de la imagen izquiera
        ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("main/assets/img/leftImg.jpg"));
        JLabel leftImg = new JLabel();
        leftImg.setBounds(0,0,(window.getWIDTH()/2),window.getHEIGHT());
        ImageIcon img2 = new ImageIcon(img.getImage().getScaledInstance((window.getWIDTH()/2),window.getHEIGHT(),Image.SCALE_SMOOTH));
        leftImg.setIcon(img2);
        startPanel.add(leftImg);
    }
    public void titleLabel(){
        //Etiqueta del titulo
        JLabel title = new JLabel("Game name");
        title.setBounds(500,100,500,100);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial Black", Font.BOLD,50)); //(tipo de letra, estilo, tamaño)
        startPanel.add(title);
    }
    public void nameTextLabel(){
        //Etiqueta del textArea para agregar el nombre del jugador
        nameText = new JTextArea("Name..");
        nameText.setBounds(500,200,200,50);
        startPanel.add(nameText);
    }
    public JPanel getStartPanele(){
        return startPanel;
    }
    public JTextArea getNameText(){
        return nameText;
    }
}
