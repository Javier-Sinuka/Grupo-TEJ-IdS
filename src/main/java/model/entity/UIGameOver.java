package model.entity;

import controller.GameManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UIGameOver extends UIRoom {

    private RestartButton restartButton;
    private JTextArea textArea;

    public UIGameOver(ImageIcon img, GameManager gm,JTextArea textArea){
        super();
        backgroundImage = img;
        this.setSize(GameWindow.WIDTH,GameWindow.HEIGHT);
        this.setVisible(false);
        this.setLayout(null);
        this.setOpaque(true);
        this.setBackground(Color.BLACK);

        restartButton=new RestartButton(gm);

        this.textArea=textArea;
        setTextArea();
        this.add(textArea);

    }

    private void setTextArea() {
        textArea.setText("No pudiste soportar el estres de ser un Semi Dios y moriste en el intento... " +
                "Probá en Abogacia o Filosofia.");
        textArea.setBounds(390,520,520,150);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.white);
        textArea.setOpaque(true);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Book Antiqua",Font.PLAIN,18));
    }


    @Override
    public void setButton(WindowButton windowBt, ArrayList<UIRoom> rooms, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom,boolean start) {}

    @Override
    public void setButton(ExamStartButton startBt, ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea) {}

    @Override
    public void setButton(ExamButtons examBts, ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea) {}

    @Override
    public void setButton(RestartButton restartBt, ArrayList<UIRoom> rooms) {
        restartBt.configureButton(rooms);
    }


    public void paintComponent(Graphics g){
        g.drawImage(backgroundImage.getImage(),0,0,getWidth(),getHeight(), this);
    }


}
