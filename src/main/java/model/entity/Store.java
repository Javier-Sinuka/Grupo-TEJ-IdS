package model.entity;

import model.objects.Usable;

import java.util.ArrayList;

/**
 * Clase que genera los Store de Venta.
 * Puede crearse vacia o con nombre.
 *
 * Posterior a crearse, es necesario agregarle los Usables mas un precio
 * asosiado a dicho usable.
 *
 * Dato: Retorna una lista de usables almacenados (para obtener el precio hay que
 * consultarlo al objeto Usable, ya que el mismo lo posee seteado).
 */
public class Store {
    String nameStore;
    ArrayList<Usable> listUsable;
    public Store(String nameStore){
        this.nameStore = nameStore;
        this.listUsable = new ArrayList<>();
    }
    public Store(){
        this.listUsable = new ArrayList<>();
    }
    public String getNameStore() {
        return nameStore;
    }
    public ArrayList<Usable> getListUsable() {
        return listUsable;
    }
    public void addUsableToList(Usable usable,int priceUsable){
        usable.setPrice(priceUsable);
        this.listUsable.add(usable);
    }
    public int getPriceUsable(Usable usable){
        return usable.getPrice();
    }
}
