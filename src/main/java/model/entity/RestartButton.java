package model.entity;

import controller.GameManager;
import model.objects.Usable;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class RestartButton implements UIButton{

    int xpos;
    int ypos;
    int width;
    int height;

    JButton restartButton;

    GameManager gm;


    public RestartButton(GameManager gm){

        restartButton=new JButton();
        this.gm=gm;
    }


    @Override
    public void configureButton() {}

    @Override
    public void configureButton(Usable usable, int ypos, UIStudent uiStudent, JLabel messageLabel, JPanel storeRoom, Boolean bar) {}

    @Override
    public void configureButton(JPanel inventoryPanel) {}

    @Override
    public void configureButton(UIStudent uiStudent, JPanel dataPanel, UIInventoryPanel inventoryPanel) {}

    @Override
    public void configureButton(ArrayList<UIRoom> rooms, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom,boolean start) {}

    @Override
    public void configureButton(ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea, UIClassroom uiclassroom) {}

    @Override
    public void configureButton(ArrayList<UIRoom> rooms) {

        xpos=470;
        ypos=350;
        width=300;
        height=50;

        restartButton.setBounds(xpos,ypos,width,height);
        restartButton.setFocusable(false);
        restartButton.setVisible(true);
        restartButton.setText("REESTART");

        restartButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                gm.notifyObservers();
                rooms.get(rooms.size()-1).setVisible(false);
                rooms.get(0).setVisible(true);
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

        rooms.get(rooms.size()-1).add(restartButton);
    }

}
