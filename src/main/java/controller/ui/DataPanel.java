package main.java.controller.ui;

import main.java.model.entity.Student;

import javax.swing.*;
import java.awt.*;

public class DataPanel {
    Window window;
    Student student;
    JPanel dataPanel;
    public DataPanel(Window window,Student student){
        this.window = window;
        this.student = student;
    }
    public void setDataPanel(){
        dataPanel = new JPanel();
        dataPanel.setSize(window.getWIDTH(),400);
        dataPanel.setBackground(Color.gray);
        dataPanel.setOpaque(false);
        dataPanel.setVisible(true);
        dataPanel.setLayout(null);
        setPlayerNameLabel();
        setDogecoinLabel();
        setLifeBarLabel();
    }
    public void setPlayerNameLabel(){
        String playerName = student.getNameStudent();
        JLabel nameLabel = new JLabel(playerName);
        nameLabel.setBounds(350,270,200,200);
        nameLabel.setFont(new Font("Arial Black", Font.BOLD,50)); //(tipo de letra, estilo, tamaño)
        dataPanel.add(nameLabel);
    }
    public void setDogecoinLabel(){
        ImageIcon dogecoin = new ImageIcon(getClass().getClassLoader().getResource("main/assets/img/dogecoin.png"));
        String coin = Integer.toString(student.getDogecoin());
        JLabel dogecoinLabel = new JLabel(coin,dogecoin,0);
        dogecoinLabel.setBounds(700,10,200,60);
        dogecoinLabel.setFont(new Font("Arial Black",Font.BOLD,50));
        dataPanel.add(dogecoinLabel);
    }
    public void setLifeBarLabel(){
        JProgressBar lifeBar = new JProgressBar(0,5);
        lifeBar.setBounds(20,20,200,20);
        dataPanel.add(lifeBar);
    }
    public JPanel getDataPanel(){
        return dataPanel;
    }
}
