/*
 * Author: Derin Ergul
 * Date: 10/10/23
 * CSC1351 Lauren Pace
 * Description: Outputs with iterative and recursive methods.
 */

import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scan.next(); // string
        int n = scan.nextInt(); // integer

        long recursiveStart = System.nanoTime();
        String recursiveResult = recursiveStringAppend(input, n);
        long recursiveEnd = System.nanoTime();

        System.out.println("Recursive output: " + recursiveResult);
        System.out.println("Recursive time: " + (recursiveEnd - recursiveStart) + " nanoseconds");

        long iterativeStart = System.nanoTime();
        String iterativeResult = iterativeStringAppend(input, n);
        long iterativeEnd = System.nanoTime();

        System.out.println("Iterative output: " + iterativeResult);
        System.out.println("Iterative time: " + (iterativeEnd - iterativeStart) + " nanoseconds");
    }

    public static String recursiveStringAppend(String s, int n) {
        if (n == 0) {
            return s;
        } else {
            return s + recursiveStringAppend(s, n - 1);
        }
    }

    public static String iterativeStringAppend(String s, int n) {
        StringBuilder result = new StringBuilder(s.length() * n);
        for (int i = 0; i < n; i++) {
            result.append(s);
        }
        return result.toString() + s;
    }
}