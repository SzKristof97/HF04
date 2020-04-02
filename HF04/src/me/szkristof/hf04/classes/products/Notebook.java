package me.szkristof.hf04.classes.products;

public class Notebook extends Product {
    //Változók
    private int pageNumber;

    //Konstruktor
    public Notebook(int price, int pageNumber) {
        super(price);
        this.pageNumber = pageNumber;
    }

    /**
     * Ezzel a függvénnyel lehet lekérdezni a jegyzetfüzet lapszámát
     */
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * Vissza adja a tárolt adatokat szöveges formában
     */
    @Override
    public String toString() {
        return "Notebook{" +
                super.toString() + ',' +
                "pageNumber='" + pageNumber + '\'' +
                '}';
    }
}
