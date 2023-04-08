package main.java.controller.ui;

import main.java.model.entity.Student;

import javax.swing.*;

public class RoomPanel {
    Window window;
    Student student;
    JPanel roomPanel;

    public RoomPanel(Window window,Student student){
        this.window = window;
        this.student = student;

        setRoomPanel();
    }
    public void setRoomPanel(){
        roomPanel = new JPanel();
        roomPanel.setSize(window.getWIDTH(),400);
        roomPanel.setVisible(false);
        roomPanel.setLayout(null);
    }
}
