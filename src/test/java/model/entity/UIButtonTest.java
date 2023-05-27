package model.entity;

import model.objects.Usable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UIButtonTest {

    private UIStudent uistudentTest;

    private ImageIcon img;

    private ArrayList<JPanel> testPanels;

    private UIClassroom uiclassroomTest;

    private UIHallway uihallwayTest;

    private JTextArea textAreaTest;

    ArrayList<String> questionsTest;
    ArrayList<ArrayList<String>> optionsTest;
    ArrayList<String> correctOptTest;


    @BeforeEach
    public void initialization(){

        uistudentTest=new UIStudent();
        img=new ImageIcon("src/main/assets/img/Facultad.png");

        testPanels=new ArrayList<>();
        uiclassroomTest=new UIClassroom(img,uistudentTest);
        uihallwayTest=new UIHallway("testing hallway", Color.BLACK);
        testPanels.add(uihallwayTest);
        testPanels.add(uiclassroomTest);

        textAreaTest=new JTextArea();

        questionsTest=new ArrayList<>();
        optionsTest=new ArrayList<>();
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

  /**
   Testeo de la función setAswindowButton(), se evalua primero que el botón seteado posea las características especificadas
   y luego la funcionalidad del mismo. Se considera un funcionamiento correcto cuando luego de un click
   (simulado mediante la creación de un MouseEvent ficticio) la visibilidad del room de origen (roomID) sea false
   y la del room de llegada (destinyRoom) sea true
   **/
   @Test
    public void setAsWindowButtonTest(){

        UIButton uibutton=new UIButton(50,100,150,50);
        ArrayList<JPanel> testPanels= new ArrayList<>();
        uihallwayTest.setVisible(true);
        testPanels.add(uihallwayTest);
        testPanels.add(uiclassroomTest);
        int roomID=0;
        int destinyRoom=1;

        uibutton.setAsWindowButton(testPanels,uistudentTest,"Aula 100",roomID,destinyRoom);

        assertEquals("Aula 100",uibutton.getButton().getText());
        assertEquals(true,uibutton.getButton().isVisible());
        // add another characteristic to be evaluated

        MouseEvent ME= new MouseEvent(uibutton.getButton(),MouseEvent.MOUSE_CLICKED,
                System.currentTimeMillis(), 0, 0, 0, 1, false);

        for(MouseListener ML: uibutton.getButton().getMouseListeners()){ ML.mouseClicked(ME); }

        assertEquals(false,testPanels.get(0).isVisible());
        assertEquals(true,testPanels.get(1).isVisible());

    }

    /** Testeo de la función setNewQuestions(). El funcionamiento es correcto si luego de ejecutar dicha función se
        se pasa a la siguiente pregunta, es decir, se modifica el texto de textAreatest y de los botones de opción
        de examen
     **/
    @Test
    public void setNewQuestionTest(){

       UIButton testUIButton=new UIButton(500,500,500,500);

       int roomID=1;

       JButton [] testButtons=new JButton[3];
       int xpos=500;
       int ypos=500;

       for(int i = 0; i<3; i++) {
            testButtons[i] = new JButton(optionsTest.get(0).get(i));
            testButtons[i].setBounds(xpos,ypos,500, 50);
            testButtons[i].setVisible(false);
            testButtons[i].setFocusable(false);
            testButtons[i].setVerticalTextPosition(JButton.TOP);
            testPanels.get(roomID).add(testButtons[i]);
            ypos+=50;
       }

       testUIButton.setNewQuestion(testButtons,questionsTest,optionsTest,textAreaTest);

       assertEquals("question2",textAreaTest.getText());
       assertEquals("OptionD",testButtons[0].getText());
       assertEquals("OptionE",testButtons[1].getText());
       assertEquals("OptionF",testButtons[2].getText());

    }


    @Test
    public void setAsExamButtonsTest(){

        int roomID=1;

        UIButton uiButton=new UIButton(500,500,500,500);
        uiButton.setAsExamButtons(questionsTest,optionsTest,correctOptTest, testPanels,textAreaTest,roomID,
                uistudentTest,uiclassroomTest);

        JButton examButtons[]= uiButton.getExamButtons();

        MouseEvent ME1= new MouseEvent(examButtons[1],MouseEvent.MOUSE_PRESSED,
                System.currentTimeMillis(), 0, 0, 0, 1, false);

        MouseEvent ME2= new MouseEvent(examButtons[1],MouseEvent.MOUSE_RELEASED,
                System.currentTimeMillis(), 0, 0, 0, 1, false);

       MouseEvent ME3= new MouseEvent(examButtons[0],MouseEvent.MOUSE_PRESSED,
                System.currentTimeMillis(), 0, 0, 0, 1, false);



        for(MouseListener ML: examButtons[1].getMouseListeners()){ ML.mousePressed(ME1); }
        assertEquals("Correct!!",textAreaTest.getText());

        for(MouseListener ML: examButtons[1].getMouseListeners()){ ML.mouseReleased(ME2); }
        assertEquals(1,uiButton.getQuestionsCounter());


        for(MouseListener ML: examButtons[0].getMouseListeners()){ ML.mousePressed(ME3); }
        assertEquals("Incorrect!!",textAreaTest.getText());

    }

/**
  Testeo de la funcion hasCredits() ,Dicha funcion debe retornar true cuando el estudiante
  tiene una cantidad igual o superior a la cantidad de creditos necesarios para rendir la materia
  retorna false en caso contrario
 **/
    @Test
    public void CreditsVerification(){

        UIButton uibutton=new UIButton(300,100,200,50);

        uistudentTest.getStudent().setCredits(4);
        uiclassroomTest.getClassroom().getProfessor().setSubjectCreditsNeeded(3);
        assertTrue(uibutton.hasCredits(uistudentTest,uiclassroomTest));

        uistudentTest.getStudent().setCredits(4);
        uiclassroomTest.getClassroom().getProfessor().setSubjectCreditsNeeded(5);
        assertFalse(uibutton.hasCredits(uistudentTest,uiclassroomTest));

        uistudentTest.getStudent().setCredits(5);
        uiclassroomTest.getClassroom().getProfessor().setSubjectCreditsNeeded(5);
        assertTrue(uibutton.hasCredits(uistudentTest,uiclassroomTest));

    }

    /**
     Testeo de la funcion hasObject(), Dicha funcion debe retornar true
     cuando el estudiante tiene el objecto necesario para rendir la materia
     retorna false en caso contrario
     **/
    @Test
    public void ObjectVerification(){

        uiclassroomTest.getClassroom().getProfessor().createExam("Introduccion a la Matematica");
        uistudentTest.getStudent().deleteUsableInBackpack(new Usable("Calculadora","la companera fiel del estudiante"));
        UIButton uibutton=new UIButton(300,100,200,50);

        assertFalse(uibutton.hasObject(uistudentTest,uiclassroomTest));

        uistudentTest.getStudent().addUsableInBackpack(new Usable("Calculadora","la companera fiel del estudiante"));
        assertTrue(uibutton.hasObject(uistudentTest,uiclassroomTest));
    }

}