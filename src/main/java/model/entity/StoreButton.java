package model.entity;

import model.objects.Consumable;
import model.objects.Usable;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class StoreButton implements UIButton{
    public StoreButton (){

    }

    @Override
    public void configureButton() {

    }

    @Override
    public void configureButton(Usable usable, int ypos, UIStudent uiStudent, JLabel messageLabel, JPanel storeRoom){

        JButton itemButton = new JButton("COMPRAR " + usable.getName() + " " + usable.getPrice() + "$");
        itemButton.setBounds(100, ypos, 500, 70);

        storeRoom.add(itemButton);

        itemButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            if(uiStudent.getDogeCoin() <= 0){
                messageLabel.setVisible(true);
                messageLabel.setText("No tenes plata pobre :(");
            }else {
                //Dependiendo del itemName es la cantidad de dogeCoin a restar
                actualizar(usable, uiStudent, messageLabel, storeRoom);
                }
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
    public void actualizar(Usable usable, UIStudent uiStudent, JLabel messageLabel, JPanel storeRoom){

        uiStudent.removeDogeCoin(usable.getPrice());
        uiStudent.addPurchasedItem(usable);

        messageLabel.setText("Compraste " + usable.getName() + ":)");
        messageLabel.setVisible(true);


        uiStudent.getDataPanel().removeAll();
        uiStudent.setDataPanel();

        uiStudent.inventoryPanel.removeAll();
        uiStudent.inventoryPanel.getConsumablePanel().removeAll();
        uiStudent.setInventoryPanel();
        uiStudent.inventoryPanel.parameterInventoryPanel();

        storeRoom.updateUI();
    }

    @Override
    public void configureButton(JPanel inventoryPanel) {}

    @Override
    public void configureButton(JPanel dataPanel, UIInventoryPanel inventoryPanel) {}

    @Override
    public void configureButton(ArrayList<UIRoom> rooms, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom) {}

    @Override
    public void configureButton(ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea, UIClassroom uiclassroom) {}
}
