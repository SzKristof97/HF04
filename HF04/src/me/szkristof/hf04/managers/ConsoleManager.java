package me.szkristof.hf04.managers;

import me.szkristof.hf04.classes.boxes.Box;
import me.szkristof.hf04.classes.equipments.Gloves;
import me.szkristof.hf04.classes.equipments.Mask;
import me.szkristof.hf04.classes.products.Notebook;
import me.szkristof.hf04.classes.products.Pencil;
import me.szkristof.hf04.main.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleManager {

    private Scanner sc = new Scanner(System.in);

    public ConsoleManager() {}

    public void Start(){
        MainMenu();
    }

    private void MainMenu(){
        do {
            ClearScreen();
            System.out.println("============[Main Menu]============");
            System.out.println("1) List");
            System.out.println("2) Search");
            System.out.println("3) Set stored amount / Remove");
            System.out.println("4) Add new item");
            System.out.println("5) Exit");
            System.out.print("Option: ");

            switch (sc.nextLine()) {
                default: {continue;}
                case "1": {ListingMenu();continue;}
                case "2": {SearchMenu();continue;}
                case "3": {SetMenu();continue;}
                case "4": {AddItemMenu();continue;}
                case "5": {return;}
            }
        }while (true);
    }

    private void AddItemMenu(){
        do {
            ClearScreen();
            System.out.println("============[Add New Item Menu]============");
            System.out.println("1) Automatic ID Generation");
            System.out.println("2) Give ID Manually");
            System.out.println("3) Back to Main Menu");
            System.out.print("Option: ");

            switch (sc.nextLine()) {
                default: {continue;}
                case "1": {AddItemMenu(true);return;}
                case "2": {AddItemMenu(false);return;}
                case "3": {return;}
            }
        }while (true);
    }

    private void AddItemMenu(boolean isAI){
        do {
            ClearScreen();
            System.out.println("============[Add New Item Menu]============");
            System.out.println("1) Pencil");
            System.out.println("2) Gloves");
            System.out.println("3) Notebook");
            System.out.println("4) Mask");
            System.out.println("5) Back to Main Menu");
            System.out.print("Option: ");

            switch (sc.nextLine()) {
                default: {continue;}
                case "1": {AddItemMenu(isAI, "Pencil");return;}
                case "2": {AddItemMenu(isAI, "Gloves");return;}
                case "3": {AddItemMenu(isAI, "Notebook");return;}
                case "4": {AddItemMenu(isAI, "Mask");return;}
                case "5": {return;}
            }
        }while (true);
    }

    private void AddItemMenu(boolean isAI, String type){
        ClearScreen();
        switch (type){
            case "Pencil": {
                System.out.print("Please enter the price of the Pencil: ");
                int price;
                try {
                    price = Integer.parseInt(sc.nextLine());
                }catch (Exception ex){
                    ClearScreen();
                    System.out.println("Wrong number!\nPress ENTER to continue...");
                    sc.nextLine();
                    return;
                }

                System.out.print("Please enter the color of the Pencil: ");
                String color = sc.nextLine();

                System.out.print("Please enter the stored amount: ");
                int amount;
                try {
                    amount = Integer.parseInt(sc.nextLine());
                }catch (Exception ex){
                    ClearScreen();
                    System.out.println("Wrong number!\nPress ENTER to continue...");
                    sc.nextLine();
                    return;
                }

                System.out.print("Please enter the date (format: yyyyMMdd): ");
                int date;
                try {
                    date = Integer.parseInt(sc.nextLine());
                }catch (Exception ex){
                    ClearScreen();
                    System.out.println("Wrong number!\nPress ENTER to continue...");
                    sc.nextLine();
                    return;
                }

                int ID = 1;
                if(!isAI){
                    System.out.print("Please enter the box ID: ");
                    try {
                        ID = Integer.parseInt(sc.nextLine());
                    }catch (Exception ex){
                        ClearScreen();
                        System.out.println("Wrong number!\nPress ENTER to continue...");
                        sc.nextLine();
                        return;
                    }
                }

                try {
                    Main.getShelfManager().addBox(new Pencil(price, color), amount, date, isAI, ID);
                }catch (Exception ex){
                    ClearScreen();
                    System.out.printf("%s\nPress ENTER to continue...", ex.getLocalizedMessage());
                    sc.nextLine();
                    return;
                }
                System.out.print("The item was successfully added to the store!\nPress ENTER to continue...");
                sc.nextLine();
                return;
            }
            case "Gloves": {
                System.out.print("Please enter the security level of the Gloves: ");
                int securtyLevel;
                try {
                    securtyLevel = Integer.parseInt(sc.nextLine());
                }catch (Exception ex){
                    ClearScreen();
                    System.out.println("Wrong number!\nPress ENTER to continue...");
                    sc.nextLine();
                    return;
                }

                System.out.print("Please enter the size of the Gloves: ");
                int size;
                try {
                    size = Integer.parseInt(sc.nextLine());
                }catch (Exception ex){
                    ClearScreen();
                    System.out.println("Wrong number!\nPress ENTER to continue...");
                    sc.nextLine();
                    return;
                }

                System.out.print("Please enter the stored amount: ");
                int amount;
                try {
                    amount = Integer.parseInt(sc.nextLine());
                }catch (Exception ex){
                    ClearScreen();
                    System.out.println("Wrong number!\nPress ENTER to continue...");
                    sc.nextLine();
                    return;
                }

                System.out.print("Please enter the date (format: yyyyMMdd): ");
                int date;
                try {
                    date = Integer.parseInt(sc.nextLine());
                }catch (Exception ex){
                    ClearScreen();
                    System.out.println("Wrong number!\nPress ENTER to continue...");
                    sc.nextLine();
                    return;
                }

                int ID = 1;
                if(!isAI){
                    System.out.print("Please enter the box ID: ");
                    try {
                        ID = Integer.parseInt(sc.nextLine());
                    }catch (Exception ex){
                        ClearScreen();
                        System.out.println("Wrong number!\nPress ENTER to continue...");
                        sc.nextLine();
                        return;
                    }
                }

                try {
                    Main.getShelfManager().addBox(new Gloves(securtyLevel, size), amount, date, isAI, ID);
                }catch (Exception ex){
                    ClearScreen();
                    System.out.printf("%s\nPress ENTER to continue...", ex.getLocalizedMessage());
                    sc.nextLine();
                    return;
                }
            }
            System.out.print("The item was successfully added to the store!\nPress ENTER to continue...");
            sc.nextLine();
            return;
            case "Notebook": {
                System.out.print("Please enter the price of the Notebook: ");
                int price;
                try {
                    price = Integer.parseInt(sc.nextLine());
                }catch (Exception ex){
                    ClearScreen();
                    System.out.println("Wrong number!\nPress ENTER to continue...");
                    sc.nextLine();
                    return;
                }

                System.out.print("Please enter the number of pages: ");
                int pageNumber;
                try {
                    pageNumber = Integer.parseInt(sc.nextLine());
                }catch (Exception ex){
                    ClearScreen();
                    System.out.println("Wrong number!\nPress ENTER to continue...");
                    sc.nextLine();
                    return;
                }

                System.out.print("Please enter the stored amount: ");
                int amount;
                try {
                    amount = Integer.parseInt(sc.nextLine());
                }catch (Exception ex){
                    ClearScreen();
                    System.out.println("Wrong number!\nPress ENTER to continue...");
                    sc.nextLine();
                    return;
                }

                System.out.print("Please enter the date (format: yyyyMMdd): ");
                int date;
                try {
                    date = Integer.parseInt(sc.nextLine());
                }catch (Exception ex){
                    ClearScreen();
                    System.out.println("Wrong number!\nPress ENTER to continue...");
                    sc.nextLine();
                    return;
                }

                int ID = 1;
                if(!isAI){
                    System.out.print("Please enter the box ID: ");
                    try {
                        ID = Integer.parseInt(sc.nextLine());
                    }catch (Exception ex){
                        ClearScreen();
                        System.out.println("Wrong number!\nPress ENTER to continue...");
                        sc.nextLine();
                        return;
                    }
                }

                try {
                    Main.getShelfManager().addBox(new Notebook(price, pageNumber), amount, date, isAI, ID);
                }catch (Exception ex){
                    ClearScreen();
                    System.out.printf("%s\nPress ENTER to continue...", ex.getLocalizedMessage());
                    sc.nextLine();
                    return;
                }
            }
            System.out.print("The item was successfully added to the store!\nPress ENTER to continue...");
            sc.nextLine();
            return;
            case "Mask": {
                System.out.print("Please enter the security level of the Mask: ");
                int securityLevel;
                try {
                    securityLevel = Integer.parseInt(sc.nextLine());
                }catch (Exception ex){
                    ClearScreen();
                    System.out.println("Wrong number!\nPress ENTER to continue...");
                    sc.nextLine();
                    return;
                }

                System.out.print("Please enter the fixation type of the Mask: ");
                String fixationType = sc.nextLine();

                System.out.print("Please enter the stored amount: ");
                int amount;
                try {
                    amount = Integer.parseInt(sc.nextLine());
                }catch (Exception ex){
                    ClearScreen();
                    System.out.println("Wrong number!\nPress ENTER to continue...");
                    sc.nextLine();
                    return;
                }

                System.out.print("Please enter the date (format: yyyyMMdd): ");
                int date;
                try {
                    date = Integer.parseInt(sc.nextLine());
                }catch (Exception ex){
                    ClearScreen();
                    System.out.println("Wrong number!\nPress ENTER to continue...");
                    sc.nextLine();
                    return;
                }

                int ID = 1;
                if(!isAI){
                    System.out.print("Please enter the box ID: ");
                    try {
                        ID = Integer.parseInt(sc.nextLine());
                    }catch (Exception ex){
                        ClearScreen();
                        System.out.println("Wrong number!\nPress ENTER to continue...");
                        sc.nextLine();
                        return;
                    }
                }

                try {
                    Main.getShelfManager().addBox(new Mask(securityLevel, fixationType), amount, date, isAI, ID);
                }catch (Exception ex){
                    ClearScreen();
                    System.out.printf("%s\nPress ENTER to continue...", ex.getLocalizedMessage());
                    sc.nextLine();
                    return;
                }
                System.out.print("The item was successfully added to the store!\nPress ENTER to continue...");
                sc.nextLine();
                return;
            }
            default: {break;}
        }
    }

    private void SetMenu(){
        ClearScreen();
        System.out.print("Please enter the box ID: ");
        int ID;
        try {
            ID = Integer.parseInt(sc.nextLine());
        }catch (Exception ex){
            ClearScreen();
            System.out.println("Wrong number!\nPress ENTER to continue...");
            sc.nextLine();
            return;
        }

        System.out.print("Please enter the new amount (0 or less then 0 is remove it): ");
        int amount;
        try {
            amount = Integer.parseInt(sc.nextLine());
        }catch (Exception ex){
            ClearScreen();
            System.out.println("Wrong number!\nPress ENTER to continue...");
            sc.nextLine();
            return;
        }

        try{
            Main.getShelfManager().setAmountById(ID,amount);
            ClearScreen();
            if(amount > 0){
                System.out.printf("Successfully changed the stored amount to %d\nPress ENTER to continue...", amount);
            }else{
                System.out.print("Successfully removed it!\nPress ENTER to continue...");
            }
            sc.nextLine();
        }catch (NumberFormatException ex){
            ClearScreen();
            System.out.printf("%s\nPress ENTER to continue...", ex.getLocalizedMessage());
            sc.nextLine();
        }
    }

    private void SearchMenu(){
        ClearScreen();
        System.out.print("Please enter a box type (example Gloves or G): ");
        String type = sc.nextLine();
        System.out.print("Please enter the needed amount: ");
        int amount;
        try {
            amount = Integer.parseInt(sc.nextLine());
        }catch (Exception ex){
            ClearScreen();
            System.out.println("Wrong number!\nPress ENTER to continue...");
            sc.nextLine();
            return;
        }

        ClearScreen();
        System.out.printf("%s\nPress ENTER to continue...", Main.getShelfManager().search(type,amount));
        sc.nextLine();
    }

    private void ListingMenu(){
        do{
            ClearScreen();
            System.out.println("============[List Menu]============");
            System.out.println("1) Order by Type");
            System.out.println("2) Order by ID ");
            System.out.println("3) All");
            System.out.println("4) Back to main menu");
            System.out.print("Option: ");

            switch (sc.nextLine()) {
                default: {continue;}
                case "1": {
                    ClearScreen();

                    ArrayList<Box> list = Main.getShelfManager().OrderByType();
                    for (Box b:list) {
                        System.out.printf("%s\n", b.toString());
                    }
                    System.out.println("Press the ENTER to continue...");
                    sc.nextLine();

                    continue;}
                case "2": {
                    ClearScreen();

                    ArrayList<Box> list = Main.getShelfManager().OrderByID();
                    for (Box b:list) {
                        System.out.printf("%s\n", b.toString());
                    }
                    System.out.println("Press the ENTER to continue...");
                    sc.nextLine();

                    continue;}
                case "3": {
                    ClearScreen();
                    System.out.printf("%s\nPress the ENTER to continue...", Main.getShelfManager().toString());
                    sc.nextLine();
                    continue;}
                case "4": {return;}
            }
        }while(true);
    }


    private void ClearScreen(){
        try {
            if(System.getProperty("os.name").toLowerCase().contains("windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }else{
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            System.out.printf("An error has occured! The error code is \n%s\nPress the enter button to continue...", e.getLocalizedMessage());
            sc.nextLine();
        }
    }
}
