package model.entity;

import model.objects.Consumable;
import model.objects.Usable;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class StoreButton implements UIButton{
    private JButton itemButton;

    public StoreButton (){
        this.itemButton = new JButton();
    }
    @Override
    public void configureButton() {}

    @Override
    public void configureButton(Usable usable, int ypos, UIStudent uiStudent, JLabel messageLabel, JPanel storeRoom, Boolean bar){

        itemButton.setText("COMPRAR " + usable.getName() + " " + usable.getPrice() + "$");
        itemButton.setBounds(100, ypos, 500, 70);

        storeRoom.add(itemButton);

        itemButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(uiStudent.getDogeCoin() <= 0){
                    messageLabel.setVisible(true);
                    messageLabel.setText("No tenes plata pobre :(");
                }else if(usable.getIsTaken() == false || bar) {
                    actualizar(usable, uiStudent, messageLabel, storeRoom);
                    }else {
                    messageLabel.setVisible(true);
                    messageLabel.setText("No podes comprar mas " + usable.getName() + " goloso :0");
                }

                if(usable.getIsTaken() == true && !bar){
                    itemButton.setEnabled(false);
                }

                uiStudent.getInventoryPanel().setVisible(true);
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
        usable.setTaken(true);

        uiStudent.getStudent().decreaseDogeCoin(usable.getPrice());
        uiStudent.getStudent().addUsableInBackpack(usable);

        messageLabel.setText("Compraste " + usable.getName() + ":)");
        messageLabel.setVisible(true);

        uiStudent.getInventoryPanel().removeAll();
        uiStudent.getInventoryPanel().getConsumablePanel().removeAll();
        uiStudent.getInventoryPanel().getObjectPanel().removeAll();
        uiStudent.setInventoryPanel();
        uiStudent.getInventoryPanel().parameterInventoryPanel();

        storeRoom.updateUI();


    }

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

    }

    public JButton getItemButton() {
        return itemButton;
    }
}
