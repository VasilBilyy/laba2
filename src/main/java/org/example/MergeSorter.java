package org.example;

import java.util.ArrayList;

public class MergeSorter implements Sorter {
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        int n = input.size();
        if (n <= 1) {
            return input;
        }

        int mid = n / 2;
        ArrayList<Integer> left = new ArrayList<>(input.subList(0, mid));
        ArrayList<Integer> right = new ArrayList<>(input.subList(mid, n));


        left = sort(left);
        right = sort(right);


        merge(input, left, right);

        return input;
    }

    private void merge(ArrayList<Integer> result, ArrayList<Integer> left, ArrayList<Integer> right) {
        int i = 0, j = 0, k = 0;
        int leftSize = left.size();
        int rightSize = right.size();

        while (i < leftSize && j < rightSize) {
            if (left.get(i) <= right.get(j)) {
                result.set(k++, left.get(i++));
            } else {
                result.set(k++, right.get(j++));
            }
        }

        while (i < leftSize) {
            result.set(k++, left.get(i++));
        }

        while (j < rightSize) {
            result.set(k++, right.get(j++));
        }
    }
}
