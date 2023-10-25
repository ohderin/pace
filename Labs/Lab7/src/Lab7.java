/*
 * Author: Derin Ergul
 * Date: 10/17/23
 * CSC1351 Lauren Pace
 * Description: comparing different sorting method times
 */

import java.util.Arrays;
import java.util.Scanner;

public class Lab7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an integer n for the size of the array: ");
        int n = scan.nextInt();

        int[] originalArray = new int[n];
        for (int i = 0; i < n; i++) {
            originalArray[i] = (int) (Math.random() * 1000);
        }

        int[] bsscArray = originalArray.clone();
        long startBubbleSort = System.nanoTime();
        BubbleSortShortCircuit(bsscArray);
        long stopBubbleSort = System.nanoTime() - startBubbleSort;
        System.out.println("Bubble Sort Short Circuit time: " + stopBubbleSort);

        int[] selectionArray = originalArray.clone();
        long startSelectionSort = System.nanoTime();
        selectionSort(selectionArray);
        long stopSelectionSort = System.nanoTime() - startSelectionSort;
        System.out.println("Selection Sort time: " + stopSelectionSort);

        int[] mergeArray = originalArray.clone();
        long startMergeSort = System.nanoTime();
        mergeSort(mergeArray);
        long stopMergeSort = System.nanoTime() - startMergeSort;
        System.out.println("Merge Sort time: " + stopMergeSort);

        int[] quickArray = originalArray.clone();
        long startQuickSort = System.nanoTime();
        quicksort(quickArray, 0, quickArray.length - 1);
        long stopQuickSort = System.nanoTime() - startQuickSort;
        System.out.println("Quick Sort time: " + stopQuickSort);

        int[] arrSortArray = originalArray.clone();
        long startArraysSort = System.nanoTime();
        Arrays.sort(arrSortArray);
        long stopArraysSort = System.nanoTime() - startArraysSort;
        System.out.println("Java Arrays.sort time: " + stopArraysSort);

        if (n < 20) {
            System.out.println("Original array " + Arrays.toString(originalArray));

        }
        System.out.println("Sorted arrays");
        printSortedArray("Bubble sort short circuit", bsscArray, n);
        printSortedArray("Selection sort", selectionArray, n);
        printSortedArray("Quick sort", quickArray, n);
        printSortedArray("Merge sort", mergeArray, n);
        printSortedArray("Arrays.sort", arrSortArray, n);
    }

    public static void BubbleSortShortCircuit(int[] array) {
        boolean sorted = false;
        int i = 1;    //loop initialization
        int temp = 0;
        //loop condition
        while (!sorted) {
            if (i == array.length) {
                sorted = true;
            } else {
                sorted = true;
                for (int j = 0; j < array.length - i; j++) {
                    if (array[j] > array[j + 1]) {
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        sorted = false;
                    }

                }
            }
        }
    }

    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]< arr[minIndex]){
                    minIndex = j;
                }
            }

            int smallerNumber = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = smallerNumber;
        }
    }

    public static void merge(int[] array, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                array[k] = l[i];
                i++;
            }
            else {
                array[k] = r[j];
                j++;
            }
            k++;
        }

        while (i < left)
            array[k++] = l[i++];

        while (j < right)
            array[k++] = r[j++];

    }

    public static void mergeSort(int[] array) {

        if (array.length < 2)
            return;

        int mid = array.length / 2;
        int[] l = new int[mid];
        int[] r = new int[array.length - mid];

        for (int i = 0; i < mid; i++)
            l[i] = array[i];

        for (int i = mid; i < array.length; i++)
            r[i - mid] = array[i];

        mergeSort(l);
        mergeSort(r);

        merge(array, l, r, mid, array.length - mid);
    }

    public static void quicksort(int[] arr, int low, int high) {
        if(low >= high || low < 0){// Ensure indices are in correct order
            return;
        }

        int p = partition(arr, low, high); //// Partition array and get the pivot index

        quicksort(arr, low, p - 1);//left side of pivot
        quicksort(arr, p + 1, high);//right side of pivot
    }

    // Divides array into two partitions
    private static int partition(int[] a, int low, int high) {
        int pivot = a[high]; //last element chosen as pivot
        int i = low - 1; //temporary pivot index

        for (int j = low; j <= high - 1; j++) {
            if (a[j] <= pivot) {// If the current element is less than or equal to the pivot
                i++; // Move the temporary pivot index forward
                // Swap the current element with the element at the temporary pivot index
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }

        // Move the pivot element to the correct pivot position (between the smaller and larger elements)
        i++;
        int temp = a[high];
        a[high] = a[i];
        a[i] = temp;
        return i;// the pivot index
    }

    public static void printSortedArray(String sortType, int[] array, int n) {
        if (n < 20) {
            System.out.println(sortType + " " + Arrays.toString(array));
        }
    }
}