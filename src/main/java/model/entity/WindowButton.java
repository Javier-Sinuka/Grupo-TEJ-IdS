package model.entity;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Set;

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
    public void configureButton() {}

    @Override
    public void configureButton(JPanel dataPanel, UIInventoryPanel inventoryPanel) {}


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
    public void configureButton(ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea, UIClassroom uiclassroom) {

    }


}
