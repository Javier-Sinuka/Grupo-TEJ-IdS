package model.entity;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UIMainMenu extends UIRoom {

    public UIMainMenu(ImageIcon backgroundImage){
        super();
        this.backgroundImage = backgroundImage;
        this.setVisible(true);

        setGameNameLabel();
        //addBackgroundImage(backgroundImage);
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

    public void addBackgroundImage(ImageIcon backgroundImage){
        JLabel label=new JLabel();
        label.setBounds(0,0,GameWindow.WIDTH,GameWindow.HEIGHT);
        label.setIcon(backgroundImage);
        label.setVisible(true);
        this.add(label);
    }

    /*
    public void setStartButton(ArrayList<JPanel> roomsPanels, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom){
        WindowButton startButton=new WindowButton(440,360,400,100);
        startButton.configureButton(roomsPanels,uiStudent,"START GAME",0,1);
        buttons.add(startButton);
    } */



   /*public void paintComponent(Graphics g){
        g.drawImage(backgroundImage.getImage(),0,0,GameWindow.WIDTH,GameWindow.HEIGHT, this);
    }

    */

    @Override
    public void setButton(WindowButton wb, ArrayList<UIRoom> rooms, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom) {

        wb.configureButton(rooms,uiStudent,"START GAME",0,1);
    }

    @Override
    public void setButton(ExamStartButton startBt, ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea) {

    }

    @Override
    public void setButton(ExamButtons examBts, ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea) {

    }
}
