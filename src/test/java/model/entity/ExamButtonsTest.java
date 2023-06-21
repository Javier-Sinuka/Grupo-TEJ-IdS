package model.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ExamButtonsTest {

    private UIStudent uistudentTest;

    private ImageIcon img;

    private ArrayList<UIRoom> testRooms;

    private UIClassroom uiclassroomTest;

    private UIHallway uihallwayTest;

    private JTextArea textAreaTest;

    LinkedList<String> questionsTest;
    ArrayList<ArrayList<String>> optionsTest;
    ArrayList<String> correctOptTest;


    @BeforeEach
    public void initialization() {

        uistudentTest = new UIStudent();
        img = new ImageIcon("src/main/assets/img/background-image-u/EntradaFacultad.png");

        testRooms = new ArrayList<>();
        uiclassroomTest = new UIClassroom(img, uistudentTest, "Introduccion a la Matematica", 2);
        uihallwayTest = new UIHallway();
        testRooms.add(uihallwayTest);
        testRooms.add(uiclassroomTest);

        textAreaTest = new JTextArea();

        questionsTest = new LinkedList<>();
        optionsTest = new ArrayList<>();
        correctOptTest = new ArrayList<>();

        questionsTest.add("question1");
        optionsTest.add(new ArrayList<>());
        optionsTest.get(0).add("OptionA");
        optionsTest.get(0).add("OptionB");
        optionsTest.get(0).add("OptionC");
        correctOptTest.add("OptionB");

        questionsTest.add("question2");
        optionsTest.add(new ArrayList<>());
        optionsTest.get(1).add("OptionD");
        optionsTest.get(1).add("OptionE");
        optionsTest.get(1).add("OptionF");
        correctOptTest.add("OptionE");


    }

    @Test
    void configureButtonTest(){

        int roomID=1;

        ExamButtons EBTest =new ExamButtons();
        EBTest.configureButton(testRooms,1,uistudentTest,textAreaTest,uiclassroomTest);

        JButton examButtons[]= EBTest.getButtons();

        MouseEvent ME1= new MouseEvent(examButtons[2],MouseEvent.MOUSE_PRESSED,
                System.currentTimeMillis(), 0, 0, 0, 1, false);

        MouseEvent ME2= new MouseEvent(examButtons[1],MouseEvent.MOUSE_RELEASED,
                System.currentTimeMillis(), 0, 0, 0, 1, false);

        MouseEvent ME3= new MouseEvent(examButtons[2],MouseEvent.MOUSE_PRESSED,
                System.currentTimeMillis(), 0, 0, 0, 1, false);


        for(MouseListener ML: examButtons[2].getMouseListeners()){ ML.mousePressed(ME1); }
        assertEquals("Correct!!",textAreaTest.getText());

        for(MouseListener ML: examButtons[1].getMouseListeners()){ ML.mouseReleased(ME2); }
        assertEquals(1,EBTest.getQuestionsCounter());

        for(MouseListener ML: examButtons[2].getMouseListeners()){ ML.mousePressed(ME3); }
        assertEquals("Incorrect!!",textAreaTest.getText());
        //ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea, UIClassroom uiclassroom
    }


    @Test
    void setNewQuestionTest(){

        ExamButtons EBTest=new ExamButtons();
        EBTest.configureButton(testRooms,1,uistudentTest,textAreaTest,uiclassroomTest);

        JButton [] testButtons= EBTest.getButtons();
        EBTest.setNewQuestion(testButtons,questionsTest,optionsTest,textAreaTest);

        assertEquals("question2",textAreaTest.getText());
        assertEquals("OptionD",testButtons[0].getText());
        assertEquals("OptionE",testButtons[1].getText());
        assertEquals("OptionF",testButtons[2].getText());

    }




}