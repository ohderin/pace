/*
 * Author: Derin Ergul
 * Date: 9/19/23
 * CSC1351 Lauren Pace
 * Description: This program mimics the menu for Panera Bread.
 *
    Had an issue here where Coffee types were not recognized when ordered from
    the menu. Spent a lot of time trying to find the issue using debug but
    unfortunately could not. Likely something wrong with my bulkAdd()
 */

import java.util.*;

class PaneraItem {
    private String name;
    private String size;
    private double price;

    public PaneraItem(String name, String size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }
}

class Food extends PaneraItem {
    private String side;

    public Food(String name, double price, String size, String side) {
        super(name, size, price);
        this.side = side;
    }
}

class Beverage extends PaneraItem {
    private boolean sipClubItem;

    public Beverage(String name, double price, boolean sipClubItem, String size) {
        super(name, size, price);
        this.sipClubItem = sipClubItem;
    }

    public boolean isSipClubItem() {
        return sipClubItem;
    }
}

class Coffee extends Beverage {

/*
    Had an issue here where Coffee types were not recognized when ordered from
    the menu. Spent a lot of time trying to find the issue using debug but
    unfortunately could not. Likely something wrong with my bulkAdd()
 */
    private String milk;

    public Coffee(String name, double price, boolean sipClubItem, String milk, String size) {
        super(name, price, sipClubItem, size);
        this.milk = milk;
    }
}

class PaneraUser {
    private String name;
    private boolean sipClubMember;

    public PaneraUser(String name, boolean sipClubMember) {
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
        List<PaneraUser> users = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        printMenuOptions();

        while (!exit) {
            System.out.print("Enter a menu option: ");

            int option = scan.nextInt();
            scan.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    addFood(menu, scan);
                    break;

                case 2:
                    addBeverage(menu, scan);
                    break;

                case 3:
                    addCoffee(menu, scan);
                    break;

                case 4:
                    addUser(users, scan);
                    break;

                case 5:
                    sendOrder(menu, users, scan);
                    break;

                case 6:
                    bulkAdd(menu, scan);
                    break;

                case 7:
                    printMenuOptions();
                    break;

                case 8:
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
        scan.close();
    }

    private static void printMenuOptions() {
        System.out.println("1. Add Food Object to menu");
        System.out.println("2. Add Beverage Object to menu");
        System.out.println("3. Add Coffee Object to menu");
        System.out.println("4. Add Panera User");
        System.out.println("5. Order");
        System.out.println("6. Bulk add menu items");
        System.out.println("7. Print menu options");
        System.out.println("8. Exit");
    }

    private static void addFood(List<PaneraItem> menu, Scanner scan) {
        System.out.print("Enter name for Food item: ");
        String name = scan.nextLine();
        System.out.print("Enter item price: ");
        double price = scan.nextDouble();
        scan.nextLine(); // Consume the newline character
        System.out.print("Enter item size: ");
        String size = scan.nextLine();
        System.out.print("Enter item side: ");
        String side = scan.nextLine();

        Food food = new Food(name, price, size, side);
        menu.add(food);
        System.out.println("Food item added to the menu.");
    }

    private static void addBeverage(List<PaneraItem> menu, Scanner scan) {
        System.out.print("Enter name for Beverage item: ");
        String name = scan.nextLine();
        System.out.print("Enter item price: ");
        double price = scan.nextDouble();
        scan.nextLine(); // Consume the newline character
        System.out.print("Enter item size: ");
        String size = scan.nextLine();
        System.out.print("Is this item a sip club item (yes/no)? ");
        boolean sipClubItem = scan.nextLine().equalsIgnoreCase("yes");

        Beverage beverage = new Beverage(name, price, sipClubItem, size);
        menu.add(beverage);
        System.out.println("Beverage item added to the menu.");
    }

    private static void addCoffee(List<PaneraItem> menu, Scanner scan) {
        System.out.print("Enter name for Coffee item: ");
        String name = scan.nextLine();
        System.out.print("Enter item price: ");
        double price = scan.nextDouble();
        scan.nextLine(); // Consume the newline character
        System.out.print("Enter item size: ");
        String size = scan.nextLine();
        System.out.print("Enter milk type: ");
        String milk = scan.nextLine();
        boolean sipClubItem = scan.nextLine().equalsIgnoreCase("yes");
        Coffee coffee = new Coffee(name, price, sipClubItem, milk, size);
        menu.add(coffee);
        System.out.println("Coffee item added to the menu.");
    }

    private static void addUser(List<PaneraUser> users, Scanner scan) {
        System.out.print("Enter user's name: ");
        String name = scan.nextLine();
        System.out.print("Is this user a sip club member (yes/no)? ");
        boolean sipClubMember = scan.nextLine().equalsIgnoreCase("yes");

        PaneraUser user = new PaneraUser(name, sipClubMember);
        users.add(user);
        System.out.println("Panera User added.");
    }

    private static void sendOrder(List<PaneraItem> menu, List<PaneraUser> users, Scanner scan) {
        System.out.print("How many items in the order? ");
        int itemCount = scan.nextInt();
        scan.nextLine(); // Consume the newline character
        System.out.print("Enter the user's name for this order: ");
        String userName = scan.nextLine();

        // Check if the user is a sip club member
        boolean isSipClubMember = users.stream()
                .filter(user -> user.getName().equalsIgnoreCase(userName))
                .anyMatch(PaneraUser::isSipClubMember);
        double total = 0.0;
        for (int i = 1; i <= itemCount; i++) {
            System.out.print("Enter order " + i + " (format: size item_name): ");
            String orderInput = scan.nextLine();

            // Split the order input into size and item name
            String[] orderParts = orderInput.split(" ", 2);

            if (orderParts.length == 2) {
                String size = orderParts[0].toLowerCase(); // Convert input size to lowercase
                String itemName = orderParts[1];

                // Search for the item in the menu (case-insensitive comparison)
                boolean itemFound = false;
                for (PaneraItem item : menu) {
                    if (item.getName().equalsIgnoreCase(itemName) && item.getSize().toLowerCase().equals(size)) {
                        double itemPrice = item.getPrice();
                        if (item instanceof Beverage beverage && isSipClubMember) {
                            if (beverage.isSipClubItem()) {
                                itemPrice = 0.0;
                            }
                        }
                        total += itemPrice;
                        itemFound = true;
                        break;
                    }
                }

                if (!itemFound) {
                    System.out.println("Item not found");
                    i--; // Retry the same item
                }
            } else {
                System.out.println("Invalid order format");
                i--; // Retry the same item
            }
        }

        System.out.println("Total is: $" + total);
    }


    private static void bulkAdd(List<PaneraItem> menu, Scanner scan) {
        System.out.print("How many items are you importing? ");
        int itemCount = scan.nextInt();
        scan.nextLine(); // Consume the newline character
        System.out.println(" Input bulk added items below");

        for (int i = 0; i < itemCount; i++) {
            String input = scan.nextLine();
            String[] parts = input.split(",");

            if (parts.length >= 5) {
                String type = parts[0];
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                boolean sipClubItem = parts[3].equalsIgnoreCase("true");
                String size = parts[4];

                switch (type) {
                    case "Food":
                        String side = parts.length > 5 ? parts[5] : ""; // Additional details (side) for Food
                        Food food = new Food(name, price, size, side);
                        menu.add(food);
                        break;

                    case "Beverage":
                        Beverage beverage = new Beverage(name, price, sipClubItem, size);
                        menu.add(beverage);
                        break;

                    case "Coffee":
                        String milk = parts.length > 5 ? parts[5] : ""; // Additional details (milk type) for Coffee
                        Coffee coffee = new Coffee(name, price, sipClubItem, milk, size);
                        menu.add(coffee);
                        break;

                    default:
                        System.out.println("Invalid item type");
                        break;
                }
            } else {
                System.out.println("Invalid input format");
            }
        }
        System.out.println("Bulk items added to the menu.");
    }
}