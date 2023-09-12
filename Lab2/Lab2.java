/*
 * Author: Derin Ergul
 * Date: 9/5/23
 * CSC1351 Lauren Pace
 * Description: Stores user input of pet properties into a sorted list, then outputs sorted properties to console.
 */

import java.util.*;

public class Lab2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = scan.nextInt(); // n*3 lines for properties
        scan.nextLine(); // newline skip

        List<Pet> petList = new ArrayList<>();

        // iterations of new pet properties
        for (int i = 0; i < first; i++) {
            String name = scan.nextLine();
            String type = scan.nextLine();
            double price = Double.parseDouble(scan.nextLine());
            petList.add(new Pet(name, type, price));
        }

        Collections.sort(petList); // sort method from Java.util.Collections

        // Output sorted information
        System.out.println("Pet name      Type    Price");
        for (Pet pet : petList) {
            System.out.printf("%-15s %-7s %.2f%n", pet.getName(), pet.getType() + ":", pet.getPrice());
        }
    }
}
