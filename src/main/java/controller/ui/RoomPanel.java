package main.java.controller.ui;

import main.java.model.entity.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RoomPanel {
    Window window;
    Student student;
    JPanel roomPanel;
    int roomNumber;
    int leftRoom;
    int rightRoom;

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
        roomPanel.setBackground(Color.RED);
    }

    public void leftRoomButton(){
        //Etiqueta del boton a room2
        JButton buttonRoom2 = new JButton("Room 2");
        buttonRoom2.setBounds(100,300,150,50);

        //Logica click del boton
        buttonRoom2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Going to Room 2");
                roomsPanels[0].setVisible(false);
                roomsPanels[1].setVisible(true);
                roomsPanels[1].add(dataPanel.getDataPanel());
                window.add(roomsPanels[1]);
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }
}
