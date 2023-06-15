package model.entity;

import javax.swing.*;
import java.util.ArrayList;

public abstract class UIRoom extends JPanel {

    ImageIcon backgroundImage;
    public UIRoom(){
        this.setSize(GameWindow.WIDTH,GameWindow.HEIGHT);
        this.setLayout(null);
        this.setVisible(false);
    }

    public abstract void setButton(WindowButton windowBt,ArrayList<UIRoom> rooms, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom);
    public abstract void setButton(ExamStartButton startBt,ArrayList<UIRoom> rooms, int roomID,
                                   UIStudent uistudent, JTextArea textArea);



}
