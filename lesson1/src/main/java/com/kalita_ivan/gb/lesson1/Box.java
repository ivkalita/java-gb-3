package com.kalita_ivan.gb.lesson1;

import java.util.ArrayList;

class Box <T extends Fruit> {
    private ArrayList<T> fruits;

    double getWeight() {
        return fruits.stream().mapToDouble((a) -> a.getWeight()).sum();
    }

    Box() {
        this.fruits = new ArrayList<>();
    }

    void add(T fruit) {
        this.fruits.add(fruit);
    }

    boolean compare(Box<? extends Fruit> box) {
        double delta = 1e-5;
        return Math.abs(this.getWeight() - box.getWeight()) < delta;
    }

    void moveTo(Box<T> box) {
        box.fruits.addAll(this.fruits);
        this.fruits.clear();
    }
}
