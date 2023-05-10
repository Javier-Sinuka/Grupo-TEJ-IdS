package main.java.model.entity;

import main.java.model.objects.Consumable;
import main.java.model.objects.IDogeCoin;
import main.java.model.objects.Item;
import main.java.model.objects.Usable;

import java.util.Random;

public class Hallway {
    private int x,y;
    private Consumable consumable;
    private Item item;

    public Hallway(String type, String nameUsable, String descripcionUsable) {
        this.x = 0;
        this.y = 0;
        if(type == "Consumable" || type == "consumable"){
            this.consumable = new Consumable(nameUsable,descripcionUsable);
        }else if (type == "Item" || type == "item"){
            this.item = new Item(nameUsable, descripcionUsable);
        }else{System.out.println("Tipo no aceptado");}
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
    public void setConsumable(String nameConsumable, String descriptionConsumable){
        this.consumable = new Consumable(nameConsumable,descriptionConsumable);
    }
    public void setItem(String nameItem, String descriptionItem){
        this.item = new Item(nameItem,descriptionItem);
    }
    public Usable getRandomUsable(){
        Usable usable = new Usable();
        try{
            if(this.item.getIsTaken()==false || this.consumable.getIsTaken()==false){
                Random random = new Random();
                int randomNumber = random.nextInt((1 - 0) + 1) +0;
                if(randomNumber==1 && this.item.getIsTaken()==false){
                    this.item.setTaken(true);
                    usable = item;
                }else if (randomNumber==0 && this.consumable.getIsTaken()==false){
                    this.consumable.setTaken(true);
                    usable = consumable;
                }
            }
        }catch (Exception e){
            System.out.println("Error al crear getRandomUsable: " + e);
        }
        return usable;
    }


}
