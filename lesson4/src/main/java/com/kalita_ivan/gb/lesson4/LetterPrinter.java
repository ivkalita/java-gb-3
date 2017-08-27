package com.kalita_ivan.gb.lesson4;

class LetterPrinter {
    private Character lastPrintedLetter = null;

    void print(Character letter) {
        System.out.print(letter);
        lastPrintedLetter = letter;
    }

    boolean somethingPrinted() {
        return this.lastPrintedLetter != null;
    }

    boolean lastLetterIs(Character letter) {
        return somethingPrinted() && lastPrintedLetter == letter;
    }
}
