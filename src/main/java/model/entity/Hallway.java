package model.entity;

import model.objects.Consumable;
import model.objects.Item;
import model.objects.Usable;

import java.util.Random;

/**
 * Clase que genera los pasillos.
 * Hallway() puede crearse vacia, o con paremetros.
 * Los parametros necesarios son (solo uno por pasillo):
 *                  - Tipo de Usable a contener
 *                  - Nombre del Usable
 *                  - Descripcion del Usable
 * ES RECOMENDABLE CREARLA VACIA Y AGREGAR LOS USABLES POSTERIORMENTE
 * PARA PODER INGRESAR MAS DE UNO Y CON LOS VALORES SETEADOS POR NOSOTROS.
 */
public class Hallway {
    private String nameHallway;
    private int x,y;
    private Consumable consumable;
    private Item item;

    public Hallway(Consumable consumable, Item item) {
        this.x = 0;
        this.y = 0;
        this.consumable = consumable;
        this.item = item;
        this.nameHallway = nameHallway;
    }
    public Hallway() {
        this.x = 0;
        this.y = 0;
    }

    //*************************** METODOS PROPIOS *********************************
    public int getRandomX(){
        return (int)(Math.random()*400+150);
    }
    public int getRandomY(){
        return (int)(Math.random()*400+150);
    }
    public Consumable getConsumable() {
        return consumable;
    }
    public Item getItem() {
        return item;
    }

    public void setConsumable(String nameConsumable, String descriptionConsumable){
        this.consumable = new Consumable(nameConsumable,descriptionConsumable);
    }
    public void setItem(String nameItem, String descriptionItem){
        this.item = new Item(nameItem,descriptionItem);
    }

    /**
     * Metodo que retorna los elementos que tiene el pasillo, mientras estos no hayan
     * sido agarrados con antelacion.
     *
     * @return Usable si tiene tiene objeto, NULL si ya fueron agarrados todos los
     * objetos de dicho pasillo.
     */
    public Usable getRandomUsable(){
        Usable usable = null;
        try{
            if(this.item.getIsTaken()==false || this.consumable.getIsTaken()==false){
                Random random = new Random();
                int randomNumber = random.nextInt((2 - 1) + 2) +1;
                if(randomNumber==2 && this.item.getIsTaken()==false){
                    this.item.setTaken(true);
                    usable = item;
                }else if (randomNumber==1 && this.consumable.getIsTaken()==false){
                    this.consumable.setTaken(true);
                    usable = consumable;
                }else if (randomNumber==0){
                    usable = null;
                }
            } else {
                return null;
            }
        }catch (Exception e){
            System.out.println("Error al crear getRandomUsable: " + e);
        }
        return usable;
    }

    public String getNameHallway() {
        return nameHallway;
    }

    public void setNameHallway(String nameHallway) {
        this.nameHallway = nameHallway;
    }
}
