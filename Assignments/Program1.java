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


    }
}