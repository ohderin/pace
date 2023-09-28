/*
 * Author: Derin Ergul
 * Date: 9/19/23
 * CSC1351 Lauren Pace
 * Description: This program mimics the menu for Panera Bread.
*/

import java.util.*;

class PaneraItem {
    private String name, size;
    private double price;

    public PaneraItem(String name, String size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getPrice() {
        return price;
    }
}

class Food extends PaneraItem {
    private String side;

    public Food(String name, double price, String size) {
        super(name, size, price);
        this.side = side;
    }

}

class Beverage extends PaneraItem {
    private boolean sipClubItem;
    private double size;

    public Beverage(String name, double price, boolean sipClubItem, String size) {
        super(name, price);
        this.sipClubItem = sipClubItem;
        this.size = size;
    }

    public boolean isSipClubItem() {
        return sipClubItem;
    }

}

class Coffee extends Beverage {
    private String milk;

    public Coffee(String name, double price, boolean sipClubItem, String size) {
        super(name, price, sipClubItem, size);
        this.milk = milk;

    }
}

class PaneraUser {
    private String name;
    private boolean SipClubMember;

    public PaneraUser(String name, String SipClubMember) {
        this.name = name;
        this.sipClubMember = sipClubMember;
    }

    public String getName() {
        return name;
    }

    public boolean isSipClubMember() {
        return sipClubMember;
    }

}

public class Program1 {

    public static void main(String[] args) {
        List<PaneraItem> menu = new ArrayList<>();
        List<PaneraUser> user = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        System.out.println("1. Add Food Object to menu");
        System.out.println("2. Add Beverage Object to menu");
        System.out.println("3. Add Coffee Object to menu");
        System.out.println("4. Add Panera User");
        System.out.println("5. Order");
        System.out.println("6. Bulk add menu items");
        System.out.println("7. Print menu options");
        System.out.println("8. Exit");

        while (!exit) {
            System.out.println("Enter a menu option: ");

            int option = scan.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1: 
                    addFood();
                    break

                case 2:
                    addBeverage();
                    break
        
                case 3:
                    addCoffee();
                    break

                case 4:
                    addUser();
                    break

                case 5:
                    sendOrder();
                    break

                case 6:
                    bulkAdd();
                    break

                case 7:
                    System.out.println("1. Add Food Object to menu");
                    System.out.println("2. Add Beverage Object to menu");
                    System.out.println("3. Add Coffee Object to menu");
                    System.out.println("4. Add Panera User");
                    System.out.println("5. Order");
                    System.out.println("6. Bulk add menu items");
                    System.out.println("7. Print menu options");
                    System.out.println("8. Exit");
                    break
                case 8:
                    exit = true;
                    System.out.println("Exiting...");
                    break
                default: 
                    System.out.println("Invalid option");
            }
        }

        private static void addFood() {
            System.out.println("Enter name for Food item: ");
            String name = scan.nextLine();
            System.out.println("Enter item price: ");
            double price = scan.nextDouble();
            scan.nextLine();
            System.out.println("Enter item side: ");

        }

        private static void addBeverage() {

        }

        private static void addCoffee() {

        }

        private static void addUser() {
            
        }

        private static void sendOrder() {

        }

        private static void bulkAdd() {

        }


    }
}