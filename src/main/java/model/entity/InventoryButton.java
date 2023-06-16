package model.entity;

import model.objects.Usable;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Set;

public class InventoryButton implements UIButton{

    public InventoryButton(){

    }
    @Override
    public void configureButton() {}

    @Override
    public void configureButton(Usable usable, int ypos, UIStudent uiStudent, JLabel messageLabel, JPanel storeRoom) {

    }

    @Override
    public void configureButton(JPanel inventoryPanel) {}
    @Override
    public void configureButton(JPanel dataPanel, UIInventoryPanel inventoryPanel) {
        JButton inventoryButton = new JButton("-");
        inventoryButton.setBounds(170,15,50,20);
        dataPanel.add(inventoryButton);
        inventoryButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                inventoryPanel.setVisible(true);
                inventoryPanel.revalidate();
                inventoryPanel.repaint();
                inventoryPanel.getGridPanel().revalidate();
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
    }
    @Override
    public void configureButton(ArrayList<UIRoom> roomsPanels, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom) {}
    @Override
    public void configureButton(ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea, UIClassroom uiclassroom) {}

}
