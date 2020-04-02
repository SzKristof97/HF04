package me.szkristof.hf04.classes.products;

public class Product {
    //Változók
    private int price;

    //Konstruktor
    public Product(int price) {
        this.price = price;
    }

    /**
     * Ezzel a függvénnyel lehet lekérdezni a tárolt árat
     */
    public int getPrice() {
        return price;
    }

    /**
     * Ezzel az eljárással lehet az árat átírni a megadott értékre.
     * Az ár nem lehet kissebb mint 0 (price >= 0)
     *
     * @param price Egésszám típusú változó, amely az új ár értékét tárolja
     */
    public void setPrice(int price) throws NumberFormatException{
        if(price < 0) throw new NumberFormatException("Price cannot be less then 0");
        this.price = price;
    }

    /**
     * Vissza adja a tárolt adatokat szöveges formában
     */
    @Override
    public String toString() {
        return "price='" + price + '\'';
    }
}
