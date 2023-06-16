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

    /**
     * Metodo que agrega una cantidad especificada de elementos Usables a la lista.
     * @param usable
     * @param priceUsable
     * @param amountToAdd
     */
    public void addUsableToList(Usable usable,int priceUsable, int amountToAdd){
        for (int i = 0; i < amountToAdd; i++){
            usable.setPrice(priceUsable);
            this.listUsable.add(usable);
        }
    }

    /**
     * Metodo que retorna el valor del objeto pedido
     * @return Precio del Usable
     */
    public int getPriceUsable(String nameUsable){
        int count = 0;
        for (Usable usable : this.listUsable){
            if (usable.getName().equals(nameUsable)){
                count = usable.getPrice();
            }
        }
        return count;
    }
}
