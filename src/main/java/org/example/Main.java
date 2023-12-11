package org.example;
import java.util.ArrayList;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static Random random = new Random();
    public static void main(String[] args) {

        ShellSorter shellSorter = new ShellSorter();

        ArrayList<Integer> inputList = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            inputList.add(random.nextInt(10));
        }

        System.out.println("Початковий масив: " + inputList);

        ArrayList<Integer> sortedList = shellSorter.sort(inputList);

        System.out.println("Відсортований масив: " + sortedList);
    }
}