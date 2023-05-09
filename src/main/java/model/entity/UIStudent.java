package main.java.model.entity;

import javax.swing.*;
import java.awt.*;

public class UIStudent {
    private Student student;
    private JPanel dataPanel;
     int testDoge = 100; // DogeCoin para probar las funcionalidades del panel y tienda

    public UIStudent(){
        student=new Student();
        dataPanel = new JPanel();

        setDataPanel();
    }
    public void setDataPanel(){
        dataPanel.setSize(1280,720);
        dataPanel.setOpaque(false);
        dataPanel.setVisible(true);
        dataPanel.setLayout(null);

        JLabel nameLabel = new JLabel("Player Name");
        nameLabel.setBounds(10,10,200,30);
        nameLabel.setFont(new Font("Arial Black", Font.BOLD,20)); //(tipo de letra, estilo, tamaño)
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
        lifeBar.setBounds(10,50,200,20);
        lifeBar.setForeground(Color.red);
        lifeBar.setValue(4);
        dataPanel.add(lifeBar);
    }
    public void removeDogeCoin(int dogeCoin){
        //student.setDogeCoin(dogeCoin);
        testDoge = testDoge - dogeCoin;
    }
    public JPanel getDataPanel(){
        return dataPanel;
    }
    public int getDogeCoin(){
        //student.getDogeCoin();
        return testDoge;
    }
    public void addPurchasedItem(String itemName){
        //Agregar a la mochila del estudiante el item comprado
    }
}
