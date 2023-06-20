package model.entity;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



public class UIMainMenu extends UIRoom {


    private JTextArea textArea;

    public UIMainMenu(ImageIcon backgroundImage){
        super();
        this.backgroundImage = backgroundImage;
        this.setVisible(true);

        setGameNameLabel();
        setTexArea();

    }

    private void setTexArea() {

        textArea= new JTextArea("PLAYER NAME");
        textArea.setBounds(440,220,400,100);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.white);
        textArea.setOpaque(true);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Book Antiqua",Font.PLAIN,18));

        this.add(textArea);
    }

    public void setGameNameLabel(){
        JLabel title = new JLabel("FCEFyN - Madness");
        title.setBounds(300,90,700,100);
        title.setFont(new Font("Arial Black", Font.BOLD,50));
        title.setOpaque(true);
        title.setHorizontalAlignment(0);
        this.add(title);
    }

    public void addBackgroundImage(ImageIcon backgroundImage){

        JLabel label=new JLabel();
        label.setBounds(0,0,GameWindow.WIDTH,GameWindow.HEIGHT);
        label.setIcon(backgroundImage);
        label.setVisible(true);
        this.add(label);
    }

   public void paintComponent(Graphics g){
        g.drawImage(backgroundImage.getImage(),0,0,GameWindow.WIDTH,GameWindow.HEIGHT, this);
    }

    @Override
    public void setButton(WindowButton wb, ArrayList<UIRoom> rooms, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom,boolean start) {
        wb.configureButton(rooms,uiStudent,"START GAME",0,1,start);
    }

    @Override
    public void setButton(ExamStartButton startBt, ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea) {
    }

    @Override
    public void setButton(ExamButtons examBts, ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea) {}

    @Override
    public void setButton(RestartButton restartBt, ArrayList<UIRoom> rooms) {}

    public JTextArea getTextArea(){ return textArea;}
}
