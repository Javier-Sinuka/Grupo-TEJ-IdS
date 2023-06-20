
package model.entity;
import model.objects.Consumable;
import model.objects.Item;
import model.objects.Usable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class UIStore extends UIRoom implements Observer {
    private UIStudent uiStudent;
    private Boolean bar;
    private JLabel messageLabel;
    private StoreButton storeButton1;
    private StoreButton storeButton2;
    private Usable calculadora;
    private Usable kitElectronica;
    private ImageIcon backgroundImage;

    public UIStore(UIStudent uiStudent, Boolean bar, ImageIcon backgroundImage){
        super();
        this.bar = bar;
        this.uiStudent = uiStudent;
        this.messageLabel = new JLabel();
        this.storeButton1 = new StoreButton();
        this.storeButton2 = new StoreButton();
        this.backgroundImage = new ImageIcon(backgroundImage.getImage().getScaledInstance(GameWindow.WIDTH,GameWindow.HEIGHT,Image.SCALE_SMOOTH));
        this.calculadora = new Item("Calculadora Casio FX","La calculadora te servira para rendir Fisica");
        this.kitElectronica = new Item("Kit de Componentes Electronicos","Este kit te ayudara para rendir Taller y Laboratorio");

        propertiesStore();
        messageLabel();

    }
    public void propertiesStore(){
        this.setSize(GameWindow.WIDTH,GameWindow.HEIGHT);
        this.setVisible(false);
        this.setLayout(null);
        this.setBackground(Color.yellow);

        if (bar) {
            Usable cafe = new Consumable("Cafe","El cafe te aumentara la cafeina");
            cafe.setPrice(40);
            Usable mate = new Consumable("Mate","El mate te despertara");
            mate.setPrice(20);

            buttons1(cafe,100,bar);
            buttons2(mate,200,bar);
        }else{
            calculadora.setPrice(40);
            kitElectronica.setPrice(20);

            buttons1(calculadora,100,bar);
            buttons2(kitElectronica,200,bar);
        }
    }
    public void buttons1(Usable usable, int ypos, Boolean bar) {
        storeButton1.configureButton(usable,ypos,uiStudent,messageLabel,this,bar);
    }
    public void buttons2(Usable usable, int ypos, Boolean bar) {
        storeButton2.configureButton(usable,ypos,uiStudent,messageLabel,this,bar);
    }
    public void messageLabel(){

        messageLabel.setBounds(100,180,600,300);
        messageLabel.setFont(new Font("Arial Black", Font.BOLD,15));
        messageLabel.setForeground(Color.white);
        messageLabel.setVisible(false);
        this.add(messageLabel);
    }
    @Override
    public void setButton(WindowButton wb, ArrayList<UIRoom> rooms, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom,boolean start) {

        wb.configureButton(rooms,uiStudent,buttonText,roomID,destinyRoom,start);
    }
    @Override
    public void setButton(ExamStartButton startBt, ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea) {

    }

    @Override
    public void setButton(ExamButtons examBts, ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea) {

    }

    @Override
    public void setButton(RestartButton restartBt, ArrayList<UIRoom> rooms) {

    }
    public void paintComponent(Graphics g){
        g.drawImage(backgroundImage.getImage(),0,0,GameWindow.WIDTH,GameWindow.HEIGHT, this);
    }

    @Override
    public void update() {

        storeButton1.getItemButton().setEnabled(true);
        storeButton2.getItemButton().setEnabled(true);
        calculadora.setTaken(false);
        kitElectronica.setTaken(false);
        propertiesStore();

    }
}
