package com.kalita_ivan.gb.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        runSwapExample();
        runArrayListExample();
        runFruitsExample();
    }

    private static void runSwapExample() {
        System.out.println("1. Swapping two array items");
        String[] array = {"first", "second", "third"};
        System.out.println(Arrays.toString(array));
        swap(array, 0, 1);
        System.out.println(Arrays.toString(array));
    }

    private static <T> void swap(T[] arr, int first, int second) {
        T temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static void runArrayListExample() {
        System.out.println("2. Array to ArrayList conversion");
        String[] array = {"first", "second", "third"};
        System.out.println(Arrays.toString(array));
        System.out.println(asArrayList(array));
    }

    private static <T> ArrayList<T> asArrayList(T[] arr) {
        ArrayList<T> list = new ArrayList<>();
        for (T item: arr) {
            list.add(item);
        }

        return list;
    }

    private static void runFruitsExample() {
        System.out.println("3. Fruits example");
        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        System.out.println(String.format("orange box weight = %f", orangeBox.getWeight()));
        System.out.println(String.format("apple box weight = %f", appleBox.getWeight()));
        System.out.println(String.format("weight the same (1) = %s", orangeBox.compare(appleBox)));
        System.out.println(String.format("weight the same (2) = %s", appleBox.compare(orangeBox)));
        Box<Orange> newOrangeBox = new Box<>();
        orangeBox.moveTo(newOrangeBox);
        System.out.println(String.format("old orange box weight = %f", orangeBox.getWeight()));
        System.out.println(String.format("new orange box weight = %f", newOrangeBox.getWeight()));
    }
}
