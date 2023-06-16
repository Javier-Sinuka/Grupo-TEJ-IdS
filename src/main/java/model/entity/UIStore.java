
package model.entity;
import model.objects.Consumable;
import model.objects.Item;
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
    private StoreButton storeButton;
    public UIStore(UIStudent uiStudent, Boolean bar){
        super();
        this.bar = bar;
        this.uiStudent = uiStudent;
        this.messageLabel = new JLabel();
        this.storeButton = new StoreButton();

        propertiesStore();
        messageLabel();

    }
    public void propertiesStore(){
        this.setSize(GameWindow.WIDTH,GameWindow.HEIGHT);
        this.setVisible(false);
        this.setLayout(null);
        this.setBackground(Color.yellow);

        if (bar) {
            Usable cafe = new Consumable("Cafe","El cafe te aunmentara la cafeina");
            cafe.setPrice(40);
            Usable mate = new Consumable("Mate","El mate te despertara");
            mate.setPrice(20);

            buttons(cafe,100,bar);
            buttons(mate,200,bar);
        }else{
            Usable calculadora = new Item("Calculadora","La calculadora te servira para rendir Fisica");
            calculadora.setPrice(40);
            Usable kitElectronica = new Consumable("Kit de componenetes electronicos","Este kit te ayudara para rendir Taller y Laboratorio");
            kitElectronica.setPrice(20);

            buttons(calculadora,100,bar);
            buttons(kitElectronica,200,bar);
        }
    }
    public void buttons(Usable usable, int ypos, Boolean bar) {
        storeButton.configureButton(usable,ypos,uiStudent,messageLabel,this,bar);
    }
    public void messageLabel(){
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
