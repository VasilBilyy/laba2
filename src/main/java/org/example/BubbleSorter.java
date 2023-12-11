package org.example;

import org.example.Sorter;
import java.util.ArrayList;
import java.util.Collections;

class BubbleSorter implements Sorter {
    public ArrayList<Integer> sort(ArrayList<Integer> input){
        ArrayList<Integer> sortedArray = new ArrayList<>(input);
        int n = sortedArray.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedArray.get(j) > sortedArray.get(j + 1)) {
                    Collections.swap(sortedArray, j, j + 1);
                }
            }

        }

        return sortedArray;
    }
}
