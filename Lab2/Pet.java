/*
 * Author: Derin Ergul
 * Date: 9/5/23
 * CSC1351 Lauren Pace
 * Description: This method assigns properties of pets to an object and uses getter methods to
 *              allow access to these properties outside of the class.
 */

import java.util.*;

// https://www.geeksforgeeks.org/comparable-interface-in-java-with-examples/#
class Pet implements Comparable<Pet> {
    private String name;
    private String type;
    private double price;

    public Pet(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }


    public int compareTo(Pet other) {
        // Animal Type comparison
        int typeComparison = this.type.compareTo(other.type);
        
        if (typeComparison != 0) {
            return typeComparison;
        }
        
        // Compare price if type is the same
        return Double.compare(this.price, other.price);
    }
}
