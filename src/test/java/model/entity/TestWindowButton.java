package model.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestWindowButton {


    private UIStudent uistudentTest;

    private ImageIcon img;

    private ArrayList<JPanel> testPanels;

    private UIClassroom uiclassroomTest;

    private UIHallway uihallwayTest;

    private JTextArea textAreaTest;




    @BeforeEach
    public void initialization() {

        uistudentTest = new UIStudent();
        img = new ImageIcon("src/main/assets/img/background-image-u/EntradaFacultad.png");

        testPanels = new ArrayList<>();
        uiclassroomTest = new UIClassroom(img,uistudentTest,"Introduccion a la Matematica",2);
        uihallwayTest = new UIHallway();
        testPanels.add(uihallwayTest);
        testPanels.add(uiclassroomTest);

        textAreaTest = new JTextArea();
    }

    @Test
    public void testConfigureButton(){

        WindowButton testWB=new WindowButton(50,100,150,50);

        //ArrayList<UIRoom> roomsPanels, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom

        ArrayList<UIRoom> testPanels= new ArrayList<>();
        uihallwayTest.setVisible(true);
        testPanels.add(uihallwayTest);
        testPanels.add(uiclassroomTest);
        int roomID=0;
        int destinyRoom=1;

        testWB.configureButton(testPanels,uistudentTest,"HALLWAY X",roomID,destinyRoom,false);

        assertEquals("HALLWAY X",testWB.getButton().getText());
        assertEquals(true,testWB.getButton().isVisible());
        // add another characteristic to be evaluated

        MouseEvent ME= new MouseEvent(testWB.getButton(),MouseEvent.MOUSE_CLICKED,
                System.currentTimeMillis(), 0, 0, 0, 1, false);

        for(MouseListener ML: testWB.getButton().getMouseListeners()){ ML.mouseClicked(ME); }

        assertEquals(false,testPanels.get(0).isVisible());
        assertEquals(true,testPanels.get(1).isVisible());
    }
}