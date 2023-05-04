package main.java.model.entity;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class UIButton {

    private int xpos;
    private int ypos;
    private int width;
    private int height;

    public UIButton(int xpos,int ypos,int width,int height){
        this.xpos=xpos;
        this.ypos=ypos;
        this.width=width;
        this.height=height;
    }

    public void setAsWindowButton(ArrayList<JPanel> roomsPanels, UIStudent student, String buttonText, int roomID, int destinyRoom){

        JButton newButton = new JButton(buttonText);
        newButton.setBounds(xpos,ypos,width,height);
        newButton.setFocusable(false);

        //Logica click del boton
        newButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                roomsPanels.get(roomID).setVisible(false);
                roomsPanels.get(destinyRoom).setVisible(true);
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
        roomsPanels.get(roomID).add(newButton);
    }

    public void setAsOptionMenu(ArrayList<String> options, String correctOpt, JPanel roomPanel, JTextArea textLabel ){

        JButton buttons[]=new JButton[3];
        int xpos=500;
        int ypos=500;

        for(int i = 0; i<3; i++) {
            buttons[i] = new JButton(options.get(i));
            buttons[i].setBounds(xpos,ypos,500, 50);
            buttons[i].setVisible(true);
            buttons[i].setFocusable(false);
            buttons[i].setVerticalTextPosition(JButton.TOP);
            roomPanel.add(buttons[i]);
            ypos+=50;
        }
/*
        JButton newButton = new JButton(buttonText);

        newButton.setBounds(xpos,ypos,width,height);
        newButton.setFocusable(false);

        //Logica click del boton
        newButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(correct){ textLabel.setText("Correct!!"); }
                else { textLabel.setText("Incorrect!");}
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
        roomPanel.add(newButton);
*/
    }




}
