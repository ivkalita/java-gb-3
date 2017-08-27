package com.kalita_ivan.gb.lesson4;

public class OrderedLetterThread extends Thread {
    /**
     * Letter to print.
     */
    private final char letter;

    /**
     * After this letter, thread's letter will be printed.
     */
    private final char triggerLetter;

    /**
     * Number of iterations.
     */
    private final int repetitionsCount;

    private final LetterPrinter printer;

    OrderedLetterThread(char letter, char triggerLetter, int repetitionsCount, LetterPrinter printer) {
        super();
        this.letter = letter;
        this.triggerLetter = triggerLetter;
        this.repetitionsCount = repetitionsCount;
        this.printer = printer;
    }

    @Override
    public void run() {
        super.run();
        synchronized (printer) {
            try {
                for (int i = 0; i < repetitionsCount; i++) {
                    if (printer.somethingPrinted()) {
                        while (!printer.lastLetterIs(triggerLetter)) {
                            printer.wait();
                        }
                    }
                    printer.print(letter);
                    printer.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
