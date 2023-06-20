package model.entity;

import model.objects.Usable;

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
    public void configureButton(Usable usable, int ypos, UIStudent uiStudent, JLabel messageLabel, JPanel storeRoom, Boolean bar) {

    }
    @Override
    public void configureButton(JPanel inventoryPanel) {

    }

    @Override
    public void configureButton(UIStudent uiStudent, JPanel dataPanel, UIInventoryPanel inventoryPanel) {}


    @Override
    public void configureButton(ArrayList<UIRoom> rooms, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom,boolean start) {

        button.setVisible(true);
        button.setBounds(xpos,ypos,width,height);
        button.setFocusable(false);
        button.setText(buttonText);

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if( uiStudent.getStudent().getCaffeineAmount()>=5){
                    uiStudent.getStudent().decreaseCaffeine();
                }

                if(start){
                    UIMainMenu mainMenu= (UIMainMenu) rooms.get(0);
                    uiStudent.getStudent().setNameStudent(mainMenu.getTextArea().getText());
                    uiStudent.getDataPanel().removeAll();
                    uiStudent.setDataPanel();
                    uiStudent.getInventoryPanel().removeAll();
                    uiStudent.getInventoryPanel().parameterInventoryPanel();
                }

                rooms.get(roomID).setVisible(false);
                rooms.get(destinyRoom).setVisible(true);
                rooms.get(destinyRoom).add(uiStudent.getDataPanel());
                uiStudent.getInventoryPanel().removeAll();
                uiStudent.getInventoryPanel().getConsumablePanel().removeAll();
                uiStudent.getInventoryPanel().getObjectPanel().removeAll();
                uiStudent.getInventoryPanel().parameterInventoryPanel();
                uiStudent.getInventoryPanel().setVisible(false);
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
        rooms.get(roomID).add(button);
    }

    @Override
    public void configureButton(ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea, UIClassroom uiclassroom) {

    }

    @Override
    public void configureButton(ArrayList<UIRoom> rooms) {

    }

    public JButton getButton(){ return button;}


}
