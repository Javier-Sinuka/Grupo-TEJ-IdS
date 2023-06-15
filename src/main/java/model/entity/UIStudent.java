package model.entity;
import model.objects.Usable;



import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class UIStudent {
    private Student student;
    private JPanel dataPanel;
    private InventoryButton inventoryButton;
    public UIInventoryPanel inventoryPanel;
    int testDoge = 1000; // DogeCoin para probar las funcionalidades del panel y tienda
    public UIStudent(){
        student=new Student();
        dataPanel = new JPanel();
        inventoryButton = new InventoryButton();
        inventoryPanel = new UIInventoryPanel(student);
        setDataPanel();
    }
    public void setDataPanel(){
        dataPanel.setSize(1280,720);
        dataPanel.setOpaque(false);
        dataPanel.setVisible(true);
        dataPanel.setLayout(null);

        playerNameLabel(dataPanel,10,10,200,30);
        dogeCoinLabel();
        lifeBarLabel(dataPanel,10,50,210,20);
        inventoryButton.configureButton(dataPanel,inventoryPanel);
        setInventoryPanel();
    }
    public void playerNameLabel(JPanel panel, int x,int y, int width, int height){
        JLabel nameLabel = new JLabel("Player Name");
        nameLabel.setBounds(x,y,width,height);
        nameLabel.setFont(new Font("Arial Black", Font.BOLD,20)); //(tipo de letra, estilo, tamaño)
        panel.add(nameLabel);
    }
    public void dogeCoinLabel(){
        ImageIcon imageDogecoin = new ImageIcon("src/main/assets/img/dogecoin.png");
        String coin = Integer.toString(getDogeCoin());
        JLabel dogecoinLabel = new JLabel(coin,imageDogecoin,0);
        dogecoinLabel.setBounds(915,10,300,60);
        dogecoinLabel.setFont(new Font("Arial Black",Font.BOLD,50));
        dataPanel.add(dogecoinLabel);
    }
    public void lifeBarLabel(JPanel panel, int x, int y, int width, int height){
        //Metodo con valor max
        //Metodo con valor min
        //Metodo con valor start
        JProgressBar lifeBar = new JProgressBar(0,10);
        lifeBar.setBounds(x,y,width,height);
        lifeBar.setForeground(Color.red);
        lifeBar.setValue(student.getLifeAmount());
        panel.add(lifeBar);


    }
    public void setInventoryPanel(){

        //Name and lifebar label

        inventoryPanel.setBounds(800,100,400,500);
        inventoryPanel.setOpaque(true);
        inventoryPanel.setVisible(false);
        inventoryPanel.setLayout(null);
        inventoryPanel.setBackground(Color.lightGray);

        JButton hideInventoryButton = new JButton("-");
        hideInventoryButton.setBounds(340,470,50,20);
        hideInventoryButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                inventoryPanel.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        ImageIcon imgProfile = new ImageIcon("src/main/assets/img/perfil.png");
        JLabel imgProfileLabel = new JLabel();
        imgProfileLabel.setBounds(10,10,100,100);
        imgProfileLabel.setIcon(new ImageIcon(imgProfile.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)));


        playerNameLabel(inventoryPanel,120,10,200,30);
        lifeBarLabel(inventoryPanel,120,50,210,20);
        dataPanel.add(inventoryPanel);
    }
    public void removeDogeCoin(int dogeCoin){
        //student.setDogeCoin(dogeCoin);
        testDoge = testDoge - dogeCoin;
    }
    public Student getStudent(){return student;}
    public JPanel getDataPanel(){
        //aumentar paso
        student.modifyWalkCaffeine(); //modifica el cafe dependiendo de cuanto se camine
        return dataPanel;
    }
    public int getDogeCoin(){
        //student.getDogeCoin();
        return testDoge;
    }
    public void addPurchasedItem(Usable usable){
        student.addUsableInBackpack(usable);
        student.printBP();
        System.out.println("-");
    }
}

