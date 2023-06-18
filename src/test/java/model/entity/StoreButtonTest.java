package model.entity;

import model.objects.Consumable;
import model.objects.Usable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StoreButtonTest {
    private StoreButton storeButtonTest;
    private int dogecoinTest;
    private UIStudent uiStudent;
    private Usable usableTest;

    @BeforeEach
    void initialization(){
        storeButtonTest = new StoreButton();
        dogecoinTest = 100;
        uiStudent = new UIStudent();
        usableTest = new Consumable("Cafe","Descripcion");

    }

    @Test
    void actualizarTest(){
        usableTest.setPrice(100);
        storeButtonTest.actualizar(usableTest, uiStudent,new JLabel(), new JPanel());

        Boolean cond1 = false;
        Boolean cond2 = false;

        for(Usable us : uiStudent.getStudent().getBackpack()){
            if(us.getName() == "Cafe"){
                cond1 = true;
            }
        }

        if(uiStudent.getStudent().getDogeCoinInWallet() == 400){
            cond2 = true;
        }

        assertTrue(cond1, "No se agrego correctamente un Usable a la mochila");
        assertTrue(cond2, "No se resto correctamente los Dogecoin al estudiante");

    }
}