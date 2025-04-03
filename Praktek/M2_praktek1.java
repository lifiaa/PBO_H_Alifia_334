package Praktek;
import java.util.Date;


class Plant {
    private String name;

    public String getName(){
        return name;
    }

    public String setName(String name){
        return name;
    }

    public Plant(String name){
        this.name = name;
    }
}

class Farmer{
    private String name;
    private String favourite;
    public String getFavourite(){
        return favourite;
    }
    public String setFavourite(String favourite){
        return favourite;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public Farmer(String name, String favourite){
        this.name = name;
        this.favourite = favourite;
    }

    public void talk(){
        System.out.println("\n=================================");
        System.out.println("Hello, World!");
        System.out.println("My name is " + name + ".");
        System.out.println("My favourite plant is " + favourite + ".");
        System.out.println("Current date and time: " + new Date());
        System.out.println("=================================\n");
    }

}

public class M2_praktek1 {
    public static void main(String[] args) {
        Plant plant1 = new Plant("Sunflower");
        Plant plant2 = new Plant("Mushroom");
        Farmer farmer1 = new Farmer("Crazy Dave", plant1.getName());
        Farmer farmer2 = new Farmer("Sober Dave", plant2.getName());

        farmer1.talk();
        farmer2.talk();
    }
}