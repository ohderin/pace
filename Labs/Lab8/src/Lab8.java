/*
 * Author: Derin Ergul
 * Date: 10/24/23
 * CSC1351 Lauren Pace
 * Description: Implementing different search and sorting algorithms for strings
 */

import java.util.Arrays;
import java.util.Scanner;

public class Lab8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a list of strings, separated by a comma:");
        String inputLine = scan.nextLine();
        String[] stringArray = inputLine.split(",");

        System.out.println("Enter the word to search for:");
        String searchWord = scan.nextLine();

        exchangeSort(stringArray);

        System.out.println("Sorted Array:");
        for (String str : stringArray) {
            System.out.print(str + " ");
        }
        System.out.println();

        // https://www.geeksforgeeks.org/returning-multiple-values-in-java/#
        int[] binarySearchResult = binarySearch(stringArray, searchWord);
        int[] linearSearchResult = linearSearch(stringArray, searchWord);

        System.out.println("Binary search - Target: " + searchWord + " found at index " + binarySearchResult[0] + " with " + (binarySearchResult[1] + 1) + " steps");
        System.out.println("Linear search - Target: " + searchWord + " found at index " + linearSearchResult[0] + " with " + (linearSearchResult[1]) + " steps");

    }

    public static void exchangeSort(String[] arr) {
        // https://github.com/Laurenpace/CSC1351_Fall2023/blob/main/Sorting/ExchangeSortCode.java
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    // https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#compareTo-java.lang.String-
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static int[] binarySearch(String[] arr, String target) {
        int min = 0;
        int max = arr.length - 1;
        int count = 0;

        while (min <= max) {
            int mid = (min + max) / 2;
            int compareResult = target.compareTo(arr[mid]);

            if (compareResult == 0) {
                return new int[]{Arrays.asList(arr).indexOf(arr[mid]), count};
            } else if (compareResult < 0) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
            count++;
        }

        return new int[]{-1, count};
    }

    public static int[] linearSearch(String[] arr, String target) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            count++;
            if (arr[i].equals(target)) {
                return new int[]{i, count};
            }
        }

        return new int[]{-1, count};
    }

}
