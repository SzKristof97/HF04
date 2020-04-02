package me.szkristof.hf04.managers;

import me.szkristof.hf04.classes.boxes.Box;

import java.util.ArrayList;
import java.util.Collections;

public class ShelfManager {

    private ArrayList<Box> boxes = new ArrayList<>();

    public ShelfManager() {}

    /**
     * Hozzá ad egy dobozt a tárolóhoz
     * @param storedItem A tárolni kívánt tárgy típusa, ez később nem módosítható!
     * @param storedAmount A tárolni kívánt tárgy mennyisége, ez később módosítható!
     * @param AI Autómatikus sorzászomás be/ki kapcsolása
     * @param ID Kézileg beadott azonosító, csak akkor kerül használatra ha az AI hamis értéket kap
     * @throws NumberFormatException Hibát dob vissza ha gond van az ID-vel
     */
    public void addBox(Object storedItem, int storedAmount, int date, boolean AI, int ID) throws NumberFormatException{
        if(ID < 1) throw new NumberFormatException("ID cannot be less then 1\nThis item is not added to the list!");

        if(AI){ //AutoIncrement on
            boxes.add(new Box(generateId(), storedItem, storedAmount, date));
        }else{  //AutoIncrement off
            if(isReserved(ID) != null) throw new NumberFormatException(String.format("This ID is reserved %d", ID));

            boxes.add(new Box(ID, storedItem, storedAmount, date));
        }
    }

    /**
     * Rendezi a listát típus szerint
     * @return vissza adja a típus szerint rendezett listát
     */
    public ArrayList<Box> OrderByType(){
        ArrayList<Box> backList = (ArrayList<Box>)boxes.clone();

        for (int i = 0; i < backList.size(); i++) {
            Box selected = backList.get(i);

            int changeIndex = i + 1;
            for (int j = i + 1; j < backList.size(); j++) {
                if(backList.get(i).getStoredItem().getClass().getSimpleName().equalsIgnoreCase(selected.getStoredItem().getClass().getSimpleName())){
                    Box temp = backList.get(changeIndex);
                    backList.set(changeIndex, backList.get(i));
                    backList.set(i, temp);
                    changeIndex++;
                }
            }
        }

        return backList;
    }

    /**
     * Rendezi a listát ID szerint
     * @return vissza adja az ID szerint rendezett listát
     */
    public ArrayList<Box> OrderByID(){
        ArrayList<Box> backList = (ArrayList<Box>)boxes.clone();

        Collections.sort(backList);

        return backList;
    }

    /**
     * Beállítja a mennyiséget egy ID alapján meghatározott dobozban
     * @param ID A doboz raktárszáma (Egész típus)
     * @param newAmount A dobozban lévő mennyiség (Egész típus), Ha 0 akkor törli a dobozt a raktárból!
     * @throws NumberFormatException Ezt a hibát dobja, ha már létezik ilyen azonosító
     */
    public void setAmountById(int ID, int newAmount) throws NumberFormatException{
        if( isReserved(ID) == null) throw new NumberFormatException(String.format("This ID doesn't exist %d", ID));

        for (int i = 0; i < boxes.size(); i++) {
            if(boxes.get(i).getID() == ID){
                if(newAmount <= 0){
                    boxes.remove(i);
                }else{
                    boxes.get(i).setStoredAmount(newAmount);
                }
                break;
            }
        }
    }

    /**
     * Típus és mennyiség alapján keres és kiszámolja, hogy mi a legkedvezőbb eltávolítási módja
     * a megadott típusnak és mennyiségnek. (Előre veszi a legrégebbi dobozokat)
     * @param type Szöveges paraméter, nem szükséges teljes egyezés, elég a típus részlet beírása
     * @param amount Egész típusú paraméter, az eltávolítani kívánt mennyiséget kell megadni
     * @return Szöveges értékkel tér, vissza a keresési eredménnyel!
     */
    public String search(String type, int amount){
        StringBuilder newString = new StringBuilder();
        StringBuilder endString = new StringBuilder();
        int backupAmount = amount;

        ArrayList<Box> possibles = new ArrayList<>();
        for (Box b : boxes) {
            if(b.getStoredItem().getClass().getSimpleName().toLowerCase().contains(type.toLowerCase())){
                possibles.add(b);
            }
        }

        if(possibles.size() == 0){
            newString.append("Search: ")
                    .append(type)
                    .append(", ")
                    .append(amount)
                    .append(" → ")
                    .append("Result: ")
                    .append("No such type found!");
            return newString.toString();
        }

        //Növekvő sorrendbe rendezi buborékos rendezéssel
        for (int i = 0; i < possibles.size(); i++) {
            for (int j = 0; j < possibles.size()-1; j++) {
                Box b1 = possibles.get(j);
                Box b2 = possibles.get(j + 1);

                if(b1.getDate() > b2.getDate()){
                    possibles.set(j, b2);
                    possibles.set(j + 1, b1);
                }
            }
        }

        newString.append("Search: ")
                .append(type)
                .append(", ")
                .append(amount)
                .append(" → ")
                .append("Result: ");
        //
        for (Box b:possibles) {
            int tempAmount = b.getStoredAmount();
            String id = b.getID() + "";

            amount -= tempAmount;
            if(amount > 0){ // Kevés, újat kell keresni
                newString.append("S").append(id).append(": ").append(tempAmount).append("; ");
                endString.append(tempAmount).append("pcs from S").append(id).append(" and ");
            }else if(amount == 0){ //Egyenlő, nincs maradék, teljesítve van a kérés
                newString.append("S").append(id).append(": ").append(tempAmount).append("; ");
                newString.append(" → ").append(endString).append(tempAmount).append("pcs from S").append(id).append("!");
                break;
            }else{ //Túlteljesít, nincs maradék, teljesítve van a kérés
                newString.append("S").append(id).append(": ").append(tempAmount).append("; ");
                newString.append(" → ").append(endString).append(tempAmount + amount).append("pcs from S").append(id).append("!");
                break;
            }
        }

        if(amount > 0){ //Nem lehet teljesíteni a feltételt, mert nincs elég tárgy a raktárban
            newString = new StringBuilder();

            newString.append("Search: ").append(type).append(", ").append(backupAmount).append(" → ");
            newString.append("Result: Not enough items in the Store");
        }

        return newString.toString();
    }

    /**
     * Generál egy új azonosítót a következő doboznak.
     * Ha egy doboz törlésre került, akkor megkaphatja annak az azonosítóját.
     * @return Vissza adja a következő azonosítót
     */
    private int generateId(){
        int newId = 1;

        if(boxes.size() >= 1){ //Legalább 1 elem van benne
            for (int i = 0; i < boxes.size(); i++) {
                boolean found = false;

                if(isReserved(newId) != null) //Ellenőrzéi hogy az ID már létezik-e
                    found = true; //Ha igen, akkor a találati érték igaz lesz

                if (found) //Ha létezik ilyen id, akkor növeljük az id értékét
                    newId++;
                else //Ha nem akkor kilépünk a ciklusból
                    break;
            }
        }

        return newId;
    }

    /**
     * Ellenőrzi hogy a beadott id már létezik-e a tárolóban
     * @param id Azonosítója a doboznak
     * @return Ha létezik, vissza tér az Objektummal, ha nem akkor NULL
     */
    private Object isReserved(int id){
        for (Box b : boxes)
            if(b.getID() == id)return b;
        return null;
    }

    /**
     * Szöveggé alakítja a listát, minden elemet új sorra tagolva
     * @return Vissza tér egy Szöveg típussal
     */
    @Override
    public String toString() {
        StringBuilder newString = new StringBuilder();

        for (Box b : boxes) {
            newString.append(b.toString()).append("\n");
        }

        return newString.toString();
    }
} //Osztály vége
