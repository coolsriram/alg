package com.alg.sedgewick.sorting;

import org.junit.Test;

/**
 * Created by selvarajs on 11/9/15.
 */
public class SelectionSort {

    public static void selectionSort(char[] toSort) {
        if (toSort != null && toSort.length > 0) {
            int length = toSort.length;

            for (int i = 0; i < length; i++) {
                int smallestInx = i;
                for (int j = i + 1; j < length; j++) {
                    if (toSort[j] < toSort[smallestInx]) {
                        smallestInx = j;
                    }
                }

                if (i != smallestInx) {
                    char temp = toSort[i];
                    toSort[i] = toSort[smallestInx];
                    toSort[smallestInx] = temp;
                }
            }

            System.out.println("Printing ...");
            System.out.println(String.valueOf(toSort));
        }
    }


    public static void main(String args[]) {
        String sort = "SORTEXAMPLE";

        selectionSort(sort.toCharArray());
    }
}
