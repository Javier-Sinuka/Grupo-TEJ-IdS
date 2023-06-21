package model.entity;

import model.objects.Item;
import model.objects.Usable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
        usableTest = new Item("Tabla Periodica","Descripcion");

    }
    @Test
    void actualizarTest(){
        usableTest.setPrice(100);
        storeButtonTest.actualizar(usableTest, uiStudent,new JLabel(), new JPanel());

        Boolean cond1 = false;
        Boolean cond2 = false;
        Boolean cond3 = false;

        for(Usable us : uiStudent.getStudent().getBackpack()){
            if(us.getName() == "Tabla Periodica"){
                cond1 = true;
            }
        }

        if(uiStudent.getStudent().getDogeCoinInWallet() == 500){
            cond2 = true;
        }

        if(usableTest.getIsTaken()){
            cond3 = true;
        }

        assertTrue(cond1, "No se agrego correctamente un Usable a la mochila");
        assertTrue(cond2, "No se resto correctamente los Dogecoin al estudiante");
        assertTrue(cond3, "El usable esta con taken en false");

    }
}