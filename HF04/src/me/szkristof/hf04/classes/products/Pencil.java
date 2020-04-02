package me.szkristof.hf04.classes.products;

public class Pencil extends Product{

    //Változók
    private String color;

    //Konstruktor
    public Pencil(int price, String color) {
        super(price);
        this.color = color;
    }

    /**
     * Ezzel a függvénnyel lehet lekérni a ceruza színét
     */
    public String getColor() {
        return color;
    }

    /**
     * Vissza adja a tárolt adatokat szöveges formában
     */
    @Override
    public String toString() {
        return "Pencil{" +
                super.toString() + ',' +
                "color='" + color + '\'' +
                '}';
    }

    public Pencil getType(){
        return this;
    }
}
