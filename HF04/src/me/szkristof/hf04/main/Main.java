package me.szkristof.hf04.main;

import me.szkristof.hf04.classes.equipments.Gloves;
import me.szkristof.hf04.classes.equipments.Mask;
import me.szkristof.hf04.classes.products.Notebook;
import me.szkristof.hf04.classes.products.Pencil;
import me.szkristof.hf04.managers.ConsoleManager;
import me.szkristof.hf04.managers.ShelfManager;

public class Main {

    private static ShelfManager shelfManager = new ShelfManager();
    private static ConsoleManager consoleManager = new ConsoleManager();

    /**
     * Ez az eljárás fog meghívódni elsőnek, innen indul a program.
     * @param args Szöveges bemeneti paraméter lista (Nincs használatban)
     */
    public static void main(String[] args) {

        //Mielőtt elindítom a konzolt, előtte regisztrálok minden tárgy típusból 3 dobozt a kódba égetve!
        try {
            //Pencil
            shelfManager.addBox(new Pencil(300, "Red"), 12, 20100421,true, 1);
            shelfManager.addBox(new Pencil(250, "Yellow"), 6, 19861009,true, 1);
            shelfManager.addBox(new Pencil(170, "Pink"), 24, 20020712,true, 1);

            //Notebook
            shelfManager.addBox(new Notebook(300, 30), 40, 20200402,true, 1);
            shelfManager.addBox(new Notebook(275, 80), 25, 20090304,true, 1);
            shelfManager.addBox(new Notebook(460, 40), 30, 20160723,true, 1);

            //Mask
            shelfManager.addBox(new Mask(5, "Type-H"), 5, 20141228,true, 1);
            shelfManager.addBox(new Mask(6, "Type-A"), 7, 19980907,true, 1);
            shelfManager.addBox(new Mask(2, "Type-V"), 6, 19861030,true, 1);

            //Gloves
            shelfManager.addBox(new Gloves(4, 5), 50, 20000101,true, 1);
            shelfManager.addBox(new Gloves(6, 4), 20, 20050620,true, 1);
            shelfManager.addBox(new Gloves(9, 7), 45, 20190216,true, 1);
        }catch(NumberFormatException ex){
            System.out.printf("An error has occured!\nError code is \"%s\"\n", ex.getLocalizedMessage());
        }

        consoleManager.Start();
    }

    public static ShelfManager getShelfManager() {
        return shelfManager;
    }
}
