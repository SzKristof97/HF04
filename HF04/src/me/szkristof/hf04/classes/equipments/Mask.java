package me.szkristof.hf04.classes.equipments;

public class Mask extends Equipment{

    //Változók
    private String fixationType;

    //Konstruktor
    public Mask(int securityLevel, String fixationType) {
        super(securityLevel);
        this.fixationType = fixationType;
    }

    /**
     * Ezzel a függvénnyel lehet lekérni a maszk rögzítési típúsát
     */
    public String getFixationType() {
        return fixationType;
    }

    /**
     * Vissza adja a tárolt adatokat szöveges formában
     */
    @Override
    public String toString() {
        return "Mask{" +
                super.toString() + ',' +
                "fixationType='" + fixationType + '\'' +
                '}';
    }
}
