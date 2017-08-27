package com.kalita_ivan.gb.lesson4;

public class Application {
    public static void main(String[] args) {
        task1();
    }

    private static void task1() {
        LetterPrinter printer = new LetterPrinter();
        OrderedLetterThread printerA = new OrderedLetterThread('A', 'C', 5, printer);
        OrderedLetterThread printerB = new OrderedLetterThread('B', 'A', 5, printer);
        OrderedLetterThread printerC = new OrderedLetterThread('C', 'B', 5, printer);
        printerA.start();
        printerB.start();
        printerC.start();
    }
}
