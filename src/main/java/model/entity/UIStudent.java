package main.java.model.entity;

import javax.swing.*;
import java.awt.*;

public class UIStudent {

    private Student student;
    private JPanel dataPanel;

    public UIStudent(){
        student=new Student();
        dataPanel = new JPanel();
        setDataPanel();
    }

    public int getDogeCoin(){
        //student.getDogeCoin();
        return 100;
    }
    public void setDataPanel(){

        dataPanel.setOpaque(false);
        dataPanel.setVisible(true);
        dataPanel.setLayout(null);

        JLabel nameLabel = new JLabel("Player Name");
        nameLabel.setBounds(350,270,200,200);
        nameLabel.setFont(new Font("Arial Black", Font.BOLD,50)); //(tipo de letra, estilo, tamaño)
        dataPanel.add(nameLabel);

        //Etiqueta de dogecoin
        ImageIcon imageDogecoin = new ImageIcon(getClass().getClassLoader().getResource("main/assets/img/dogecoin.png"));
        String coin = Integer.toString(getDogeCoin());
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

    public JPanel getDataPanel(){
        return dataPanel;
    }
}
