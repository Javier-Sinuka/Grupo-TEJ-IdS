package model.entity;

import model.objects.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ExamStartButtonTest {

    private UIStudent uistudentTest;

    private ImageIcon img;

    private ArrayList<UIRoom> testRooms;

    private UIClassroom uiclassroomTest;

    private UIHallway uihallwayTest;

    private JTextArea textAreaTest;


    @BeforeEach
    public void initialization() {

        uistudentTest = new UIStudent();
        img = new ImageIcon("src/main/assets/img/background-image-u/EntradaFacultad.png");

        testRooms = new ArrayList<>();
        uiclassroomTest = new UIClassroom(img, uistudentTest, "Introduccion a la Matematica", 1);
        uihallwayTest = new UIHallway();
        testRooms.add(uihallwayTest);
        testRooms.add(uiclassroomTest);

        textAreaTest = new JTextArea();
    }

    @Test
    void configureButtonTest(){

        uiclassroomTest.setButton(new ExamButtons(),testRooms,1,uistudentTest,textAreaTest);
        uiclassroomTest.setButton(new ExamStartButton(),testRooms,1,uistudentTest,textAreaTest);
        uistudentTest.getStudent().addUsableInBackpack(new Item("Tabla de Derivadas","Mas valiosa que la biblia"));

        JButton startButton=uiclassroomTest.getExamStartButton().getButton();

        assertEquals("COMENZAR EXAMEN",startButton.getText());

        MouseEvent ME1= new MouseEvent(startButton,MouseEvent.MOUSE_CLICKED,
                System.currentTimeMillis(), 0, 0, 0, 1, false);

        for(MouseListener ML: uiclassroomTest.getExamStartButton().getButton().getMouseListeners()){ ML.mouseClicked(ME1); }

        JButton[] examButtons= uiclassroomTest.getExamButtons().getButtons();

        for (int i=0;i<3;i++){
            assertTrue(examButtons[i].isVisible());
        }
    }
}