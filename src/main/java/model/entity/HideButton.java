package model.entity;

import model.objects.Usable;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Set;

public class HideButton implements UIButton{


    private JButton hideInventoryButton;

    public HideButton(){

    }
    @Override
    public void configureButton() {}

    @Override
    public void configureButton(Usable usable, int ypos, UIStudent uiStudent, JLabel messageLabel, JPanel storeRoom, Boolean bar) {

    }

    @Override
    public void configureButton(JPanel inventoryPanel) {
        hideInventoryButton = new JButton("-");
        hideInventoryButton.setBounds(340,470,50,20);
        hideInventoryButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                inventoryPanel.setVisible(false);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        inventoryPanel.add(hideInventoryButton);

    }

    @Override
    public void configureButton(UIStudent uiStudent, JPanel dataPanel, UIInventoryPanel inventoryPanel) {}

    @Override
    public void configureButton(ArrayList<UIRoom> roomsPanels, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom,boolean start) {}



    @Override
    public void configureButton(ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea, UIClassroom uiclassroom) {}

    @Override
    public void configureButton(ArrayList<UIRoom> rooms) {

    }


    public JButton getButton() {
        return hideInventoryButton;
    }
}
