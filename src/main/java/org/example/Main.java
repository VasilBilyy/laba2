package org.example;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

enum SortingType {
    BUBBLE, SHELL, MERGE, QUICK
}

class SortingFactory {
    public static Sorter getSorter(SortingType type) {
        switch (type) {
            case BUBBLE:
                return new BubbleSorter();
            case SHELL:
                return new ShellSorter();
            case MERGE:
                return new MergeSorter();
            case QUICK:
                return new QuickSorter();
            default:
                throw new IllegalArgumentException("Unsupported sorting type: " + type);
        }
    }
}

public class Main {
    private static Random random = new Random();
    public static void main(String[] args) {
        for (int count : new int[]{10, 1000, 10000, 1000000}) {
            System.out.println("Number of elements: " + count);

            ArrayList<Integer> inputArray = generateRandomArray(count);
            //printArray(inputArray);

            for (SortingType type : SortingType.values()) {
                System.out.println("Sorting type: " + type);

                Sorter sorter = SortingFactory.getSorter(type);
                long startTime = System.currentTimeMillis();
                ArrayList<Integer> sortedArray = sorter.sort(new ArrayList<>(inputArray));
                long endTime = System.currentTimeMillis();

                printArray(sortedArray.subList(0, Math.min(50, count)));
                System.out.println("Time taken: " + (endTime - startTime) + " milliseconds\n");
            }
        }
    }

    private static ArrayList<Integer> generateRandomArray(int count) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            array.add(random.nextInt(count));
        }
        return array;
    }

    private static void printArray(List<Integer> array) {
        System.out.println(Arrays.toString(array.toArray(new Integer[0])));
    }
}