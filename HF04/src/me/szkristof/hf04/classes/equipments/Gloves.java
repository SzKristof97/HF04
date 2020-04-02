package me.szkristof.hf04.classes.equipments;

import me.szkristof.hf04.classes.products.Pencil;

public class Gloves extends Equipment {

    //változók
    private int size;

    //Konstruktor
    public Gloves(int securityLevel, int size) {
        super(securityLevel);
        this.size = size;
    }

    /**
     * Ezzel a függvénnyel lehet lekérni a kesztyű méretét
     */
    public int getSize() {
        return size;
    }

    /**
     * Vissza adja a tárolt adatokat szöveges formában
     */
    @Override
    public String toString() {
        return "Gloves{" +
                super.toString() + ',' +
                "size='" + size + '\'' +
                '}';
    }

    public Gloves getType(){
        return this;
    }
}
