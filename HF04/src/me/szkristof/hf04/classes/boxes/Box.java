package me.szkristof.hf04.classes.boxes;

public class Box implements Comparable<Box> {

    private final int ID;
    private final Object storedItem;
    private final int date;

    private int storedAmount;

    public Box(int ID, Object storedItem, int storedAmount, int date) {
        this.ID = ID;
        this.storedItem = storedItem;
        this.storedAmount = storedAmount;
        this.date = date;
    }

    public int getDate() {
        return date;
    }

    public int getID() {
        return ID;
    }

    public Object getStoredItem() {
        return storedItem;
    }

    public int getStoredAmount() {
        return storedAmount;
    }

    public void setStoredAmount(int storedAmount) {
        this.storedAmount = storedAmount;
    }

    @Override
    public String toString() {
        String newString = "";

        newString += "[";

        newString += this.ID + ", ";

        newString += this.storedItem.getClass().getSimpleName() + ", ";

        newString += this.storedAmount + ", ";

        newString += this.date;

        newString += "]";
        return newString;
    }

    @Override
    public int compareTo(Box o) {
        return Integer.compare(this.ID, o.getID());
    }
}
