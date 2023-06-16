package model.entity;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Set;

public interface UIButton {


    public void configureButton();
    public void configureButton(JPanel inventoryPanel);
    public void configureButton(JPanel dataPanel, UIInventoryPanel inventoryPanel);
    /** Window Buttons **/
    public void configureButton(ArrayList<UIRoom> rooms, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom) ;


    /** Exam Start Button and Exam Buttons**/
    public void configureButton(ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea,
                                UIClassroom uiclassroom);

}

