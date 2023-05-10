package main.java.model.entity;

import main.java.model.objects.IDogeCoin;

public class Store {
    String name;

    IDogeCoin iDogeCoin;

    String flag, nameProduct;

    public Store(String name, String type){
        if(type == "cafe" || type == "mate"){
            this.nameProduct = type;
            this.flag = "consumable";
        }else{
            this.flag = "item";
            this.nameProduct = type;
        }
    }

    public void getContent(){
        if (flag.equals("consumable")){
            System.out.println("El contenido almacenado es: consumibles");
//            System.out.println("Contenido actual: " + iConsumables.length);
        }else {
            System.out.println("El contenido almacenado es: item's");
//            System.out.println("Contenido actual: " + iItemStore.length);
        }
    }
}
