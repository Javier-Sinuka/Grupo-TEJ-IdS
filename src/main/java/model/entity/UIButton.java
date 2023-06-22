package model.entity;

import model.objects.Usable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Set;

public interface UIButton {

    public void configureButton();
    /** Store Buttons **/
    public void configureButton(Usable usable, int ypos, UIStudent uiStudent, JLabel messageLabel, JPanel storeRoom, Boolean bar);
    /** Inventory Panel Hide Button **/
    public void configureButton(JPanel inventoryPanel);
    /** Inventory Panel Show Button **/
    public void configureButton(UIStudent uiStudent, JPanel dataPanel, UIInventoryPanel inventoryPanel);
    /** Window Buttons **/
    public void configureButton(ArrayList<UIRoom> rooms, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom,boolean start);

    /** Exam Start Button and Exam Buttons**/
    public void configureButton(ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea,
                                UIClassroom uiclassroom);


    public void configureButton(ArrayList<UIRoom>rooms);

}

