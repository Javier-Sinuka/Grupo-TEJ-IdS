package main.java.model.entity;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class UIStore extends JPanel {
    UIStudent uiStudent;
    Boolean bar;
    JLabel messageLabel;
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
            String cafe = "CAFE";
            String mate = "MATE";
            buttons("COMPRAR " + cafe + "$20", 100, 100, 500, 50, cafe);
            buttons("COMPRAR " + mate + "$20", 100, 200, 500, 50, mate);
        }else{
            String calculadora = "CALCULADORA";
            String kitElectronica = "KIT DE COMPONENTES ELECTRONICOS";
            buttons("COMPRAR " + calculadora + "$20", 100,100,500,50, calculadora);
            buttons("COMPRAR " + kitElectronica + "$20", 100,200,500,50, kitElectronica);
        }
    }
    public void buttons(String text,int x,int y,int width, int height, String itemName){
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
                actualizar(itemName);
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
    public void actualizar(String itemName){
        uiStudent.removeDogeCoin(20);
        uiStudent.getDataPanel().removeAll();
        uiStudent.setDataPanel();

        if(uiStudent.inventoryPanelOpen){
            uiStudent.inventoryPanel.setVisible(true);
        }
        uiStudent.addPurchasedItem(itemName);

        messageLabel.setText("Compraste " + itemName + ":)");
        messageLabel.setVisible(true);

        this.repaint();
        this.revalidate();
        this.updateUI();
    }
    public void messageLabel (){
        messageLabel.setBounds(100,300,600,50);
        messageLabel.setVisible(false);
        this.add(messageLabel);
    }
}
