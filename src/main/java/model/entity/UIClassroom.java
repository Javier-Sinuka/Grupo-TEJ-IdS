package model.entity;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UIClassroom extends UIRoom {

    UIStudent uistudent;
    Classroom classroom;
    WindowButton exitButton;
    ExamStartButton examStartButton ;

    ExamButtons examButtons;

    JTextArea textArea;
    ImageIcon img;


    public UIClassroom(ImageIcon img,UIStudent uistudent,String subjectName,int roomID){
        super();
        this.img = img;
        this.setSize(GameWindow.WIDTH,GameWindow.HEIGHT);
        this.setVisible(false);
        this.setLayout(null);
        this.setOpaque(true);

        try{
            classroom = new Classroom(subjectName,roomID,uistudent.getStudent());
        }
        catch(Exception e){ System.out.println("something went wrong");}

        this.uistudent=uistudent;

        examStartButton=new ExamStartButton();
        exitButton=new WindowButton(50,100,150,50);
        examButtons=new ExamButtons();
    }

public void setTextArea(JTextArea textArea,String initialText){
    textArea.setVisible(true);
    textArea.setBounds(61,540,520,150);
    textArea.setBackground(Color.BLACK);
    textArea.setForeground(Color.white);
    textArea.setOpaque(true);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setFont(new Font("Book Antiqua",Font.PLAIN,18));
    textArea.setText(initialText);
    this.textArea=textArea;
    this.add(textArea);
}
    public Classroom getClassroom(){ return classroom;}

    public ExamButtons getExamButtons() { return examButtons;}

    @Override
    public void setButton(WindowButton windowBt, ArrayList<UIRoom> rooms, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom) {

        windowBt.configureButton(rooms,uiStudent,buttonText,roomID,destinyRoom);
    }


    @Override
    public void setButton(ExamStartButton examBt,ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea){
        examBt.configureButton(rooms, roomID, uistudent, textArea, this);
    }

    @Override
    public void setButton(ExamButtons examBts, ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea) {
        examBts.configureButton(rooms,roomID,uistudent,textArea,this);
    }

    public void addExamButton(JButton button){
       examButtons.addButton(button);
    }

    public void addExamStartButton(ExamStartButton examStartButton){ this.examStartButton=examStartButton;}
    public ExamStartButton getExamStartButton() { return examStartButton;}

    public void addProfessorImage(int xpos,int ypos,int width,int height,String imagePath){

        JLabel professorLabel=new JLabel();
        professorLabel.setBounds(xpos,ypos,width,height);

        ImageIcon img = new ImageIcon(imagePath);

        professorLabel.setIcon(new ImageIcon(img.getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH)));

        this.add(professorLabel);

        /*
        // pixabay
        // gameicons
        // ondoku----->voices
        // bensound y pixabay-----> music
        // convertio----> convert mp3 to WAV
         */

    }

    public void paintComponent(Graphics g){
        g.drawImage(img.getImage(),0,0,getWidth(),getHeight(), this);
    }
}
