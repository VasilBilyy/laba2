package org.example;
import java.util.Collections;
import java.util.ArrayList;

public class QuickSorter implements Sorter {

    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        if (input == null || input.size() <= 1) {
            return new ArrayList<>(input);
        }

        ArrayList<Integer> sortedArray = new ArrayList<>(input);
        quickSort(sortedArray, 0, sortedArray.size() - 1);
        return sortedArray;
    }

    private void quickSort(ArrayList<Integer> input, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(input, low, high);

            quickSort(input, low, partitionIndex - 1);
            quickSort(input, partitionIndex + 1, high);
        }
    }

    private int partition(ArrayList<Integer> input, int low, int high) {
        int pivot = input.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (input.get(j) < pivot) {
                i++;


                Collections.swap(input, i, j);
            }
        }

        Collections.swap(input, i + 1, high);

        return i + 1;
    }
}