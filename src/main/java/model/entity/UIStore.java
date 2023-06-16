
package model.entity;
import model.objects.Consumable;
import model.objects.Usable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class UIStore extends UIRoom {
    private UIStudent uiStudent;
    private Boolean bar;
    private JLabel messageLabel;
    public UIStore(UIStudent student, Boolean bar){
        super();
        this.bar = bar;
        this.uiStudent = student;
        this.messageLabel = new JLabel();

        propertiesStore();
        messageLabel();
    }
    public void propertiesStore(){
        this.setSize(GameWindow.WIDTH,GameWindow.HEIGHT);
        this.setVisible(false);
        this.setLayout(null);
        this.setBackground(Color.yellow);

        if (bar) {
            String cafe = "Cafe";
            String mate = "Mate";
            buttons("COMPRAR " + cafe + "$20", 100, 100, 500, 50, cafe,"Cafe rico");
            buttons("COMPRAR " + mate + "$20", 100, 200, 500, 50, mate,"Mate amargo");
        }else{
            String calculadora = "CALCULADORA";
            String kitElectronica = "KIT DE COMPONENTES ELECTRONICOS";
            buttons("COMPRAR " + calculadora + "$20", 100,100,500,50, calculadora,"Calculadora casio");
            buttons("COMPRAR " + kitElectronica + "$20", 100,200,500,50, kitElectronica,"Plaqueta, resistencia y capacitor");
        }
    }
    public void buttons(String text,int x,int y,int width, int height, String itemName, String itemDescription){
        JButton itemButton = new JButton(text);
        itemButton.setBounds(x,y,width,height);
        this.add(itemButton);

        itemButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            if(uiStudent.getDogeCoin() <= 0){
                messageLabel.setVisible(true);
                messageLabel.setText("No tenes plata pobre :(");
            }else {
                //Dependiendo del itemName es la cantidad de dogeCoin a restar
                actualizar(itemName, itemDescription);
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
    public void actualizar(String itemName, String description){
        Consumable usable = new Consumable(itemName,description);
        usable.setPrice(20);
        uiStudent.removeDogeCoin(usable.getPrice());
        uiStudent.addPurchasedItem(usable);

        messageLabel.setText("Compraste " + itemName + ":)");
        messageLabel.setVisible(true);


        uiStudent.getDataPanel().removeAll();
        uiStudent.setDataPanel();

        uiStudent.inventoryPanel.removeAll();
        uiStudent.inventoryPanel.getConsumablePanel().removeAll();
        uiStudent.setInventoryPanel();
        uiStudent.inventoryPanel.parameterInventoryPanel();

        this.updateUI();
    }
    public void messageLabel (){
        messageLabel.setBounds(100,300,600,50);
        messageLabel.setVisible(false);
        this.add(messageLabel);
    }

    @Override
    public void setButton(WindowButton wb, ArrayList<UIRoom> rooms, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom) {
        wb.configureButton(rooms,uiStudent,buttonText,roomID,destinyRoom);
    }

    @Override
    public void setButton(ExamStartButton startBt, ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea) {

    }

    @Override
    public void setButton(ExamButtons examBts, ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea) {

    }
}
