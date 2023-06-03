package model.entity;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class WindowButton implements UIButton{

    int xpos;
    int ypos;
    int width;
    int height;
    JButton button;

    public WindowButton(int xpos, int ypos, int width, int height) {
        this.xpos=xpos;
        this.ypos=ypos;
        this.width=width;
        this.height=height;
        button=new JButton();
    }

    @Override
    public void configureButton() {

    }

    @Override
    public void configureButton(ArrayList<UIRoom> roomsPanels, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom) {

        button.setVisible(true);
        button.setBounds(xpos,ypos,width,height);
        button.setFocusable(false);
        button.setText(buttonText);

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                roomsPanels.get(roomID).setVisible(false);
                roomsPanels.get(destinyRoom).setVisible(true);
                roomsPanels.get(destinyRoom).add(uiStudent.getDataPanel());
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
        roomsPanels.get(roomID).add(button);
    }

    @Override
    public void configureButton(ArrayList<String> questions, ArrayList<ArrayList<String>> options, ArrayList<String> correctOpt, ArrayList<UIRoom> rooms, JTextArea textArea, int roomID, UIStudent uistudent, UIClassroom uiclassroom) {}

    @Override
    public void configureButton(ArrayList<UIRoom> roomsPanels, int roomID,ArrayList<String>questions,JButton [] buttons,
                                UIStudent uistudent,JTextArea textArea,UIClassroom uiclassroom){}
}
