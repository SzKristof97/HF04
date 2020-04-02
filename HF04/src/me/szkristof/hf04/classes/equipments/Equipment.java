package me.szkristof.hf04.classes.equipments;

public class Equipment {

    //Változók
    private int securityLevel;

    //Konstruktor
    public Equipment(int securityLevel) {
        this.securityLevel = securityLevel;
    }

    /**
     * Ezzel a függvénnyel lehet kikérni a biztonsági szintet
     */
    public int getSecurityLevel() {
        return securityLevel;
    }

    /**
     * Ezzel az eljárással lehet beállítani a biztonsági szintet
     * A legkissebb szint 0, maximum pedig az egész szám típus maximális kapacitása!
     *
     * @param securityLevel Egésszám típusú változó, ezzel fog felül íródni a biztonsági szint
     */
    public void setSecurityLevel(int securityLevel) throws NumberFormatException{
        if(securityLevel < 0) throw new NumberFormatException("Security Level cannot be less then 0");
        this.securityLevel = securityLevel;
    }

    /**
     * Vissza adja a tárolt adatokat szöveges formában
     */
    @Override
    public String toString() {
        return "securityLevel='" + securityLevel + '\'';
    }
}
