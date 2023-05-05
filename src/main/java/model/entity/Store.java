package main.java.model.entity;

import main.java.model.objects.IConsumable;
import main.java.model.objects.IDogeCoin;
import main.java.model.objects.IItemStore;

public class Store {
    String name;

    IDogeCoin iDogeCoin;
    IConsumable iConsumables[];
    IItemStore iItemStore[];

    String flag, nameProduct;

    public Store(String name, String type, int countStock){
        if(type == "cafe" || type == "mate"){
            this.iConsumables = new IConsumable[countStock];
            this.nameProduct = type;
            this.flag = "consumable";
        }else{
            this.iItemStore = new IItemStore[countStock];
            this.flag = "item";
            this.nameProduct = type;
        }
    }

    public void getContent(){
        if (flag.equals("consumable")){
            System.out.println("El contenido almacenado es: consumibles");
            System.out.println(iConsumables[0]);
        }else {
            System.out.println("El contenido almacenado es: item's");
            System.out.println(iItemStore);
        }
    }
}
