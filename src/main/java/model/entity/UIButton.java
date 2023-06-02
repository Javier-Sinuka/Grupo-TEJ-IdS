package model.entity;

import javax.swing.*;
import java.util.ArrayList;

public interface UIButton {


    /** Window Buttons **/
    public void configureButton(ArrayList<UIRoom> roomsPanels, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom) ;


    /** Exam buttons **/
    public void configureButton(ArrayList<String> questions, ArrayList<ArrayList<String>> options, ArrayList<String> correctOpt,
                                ArrayList<UIRoom> roomsPanels, JTextArea textArea, int roomID, UIStudent uistudent, UIClassroom uiclassroom);


    /** Exam Start Button **/
    public void configureButton(ArrayList<UIRoom> rooms, int roomID,ArrayList<String>questions,JButton [] buttons,
                                UIStudent uistudent,JTextArea textArea,UIClassroom uiclassroom);

}

