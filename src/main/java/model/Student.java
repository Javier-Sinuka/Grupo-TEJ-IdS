package main.java.model;
import javax.swing.*;
import java.awt.*;

public class Student {

    private String studentName;
    private JPanel dataPanel;
    private int dogecoin;

    public Student(String studentName) {

        this.studentName = studentName;
        dataPanel = new JPanel();
        dataPanel.setSize(1200,400);
        dataPanel.setBackground(Color.white);
        dataPanel.setOpaque(false);
        dataPanel.setVisible(true);
        dataPanel.setLayout(null);
    }

    public Student() {
    }

    public void setDataPanel(){
        JLabel nameLabel = new JLabel(studentName);
        nameLabel.setBounds(350,270,200,200);
        nameLabel.setFont(new Font("Arial Black", Font.BOLD,50)); //(tipo de letra, estilo, tamaño)
        dataPanel.add(nameLabel);

        //Etiqueta de dogecoin
        ImageIcon imageDogecoin = new ImageIcon(getClass().getClassLoader().getResource("main/assets/img/dogecoin.png"));
        String coin = Integer.toString(dogecoin);
        JLabel dogecoinLabel = new JLabel(coin,imageDogecoin,0);
        dogecoinLabel.setBounds(915,10,300,60);
        dogecoinLabel.setFont(new Font("Arial Black",Font.BOLD,50));
        dataPanel.add(dogecoinLabel);

        //Etiqueta life
        JProgressBar lifeBar = new JProgressBar(0,5);
        lifeBar.setBounds(20,20,200,20);
        lifeBar.setForeground(Color.red);
        lifeBar.setValue(4);
        dataPanel.add(lifeBar);

    }

    public String getStudentName() {
        return studentName;
    }
    public JPanel getDataPanel(){return dataPanel;}

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getDogecoin() {
        return dogecoin;
    }

    public void setDogecoin(int dogecoin) {
        this.dogecoin = dogecoin;
    }
}

