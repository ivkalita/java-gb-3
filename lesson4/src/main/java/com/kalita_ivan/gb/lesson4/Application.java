package com.kalita_ivan.gb.lesson4;

import java.io.IOException;
import java.io.PrintWriter;

public class Application {
    public static void main(String[] args) {
        task1();
        task2();
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

    private static void task2() {
        PrintWriter writer;
        try {
            writer = new PrintWriter("l4t2.log", "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        LogThread threadA = new LogThread("A", writer);
        LogThread threadB = new LogThread("B", writer);
        LogThread threadC = new LogThread("C", writer);
        threadA.start();
        threadB.start();
        threadC.start();
        try {
            threadA.join();
            threadB.join();
            threadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
