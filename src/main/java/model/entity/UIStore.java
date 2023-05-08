package main.java.model.entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class UIStore extends JPanel {
    UIStudent uiStudent;
    Boolean bar;
    public UIStore(UIStudent student, Boolean bar){
        super();
        this.bar = bar;
        this.uiStudent = student;
        propertiesStore();
    }
    public void propertiesStore(){
        this.setSize(GameWindow.WIDTH,GameWindow.HEIGHT);
        this.setVisible(false);
        this.setLayout(null);
        this.setBackground(Color.yellow);
        if (bar) {
            buttons("COMPRAR CAFE $20", 100, 100, 600, 50);
            buttons("COMPRAR MATE $20", 100, 200, 600, 50);
        }else{
            buttons("COMPRAR CALCULADORA $20", 100,100,600,50);
            buttons("COMPRAR KIT DE COMPANENTES ELECTRONICOS $20", 100,200,600,50);
        }
    }
    public void buttons(String text,int x,int y,int width, int height){
        JButton itemButton = new JButton(text);
        itemButton.setBounds(x,y,width,height);
        this.add(itemButton);

        itemButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            uiStudent.removeDogeCoin(20);
            uiStudent.getDataPanel().removeAll();
            uiStudent.setDataPanel();
            actualizar();

            System.out.println(uiStudent.testDoge);

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

    public void actualizar(){
        this.repaint();
        this.revalidate();
        this.updateUI();
    }

}
