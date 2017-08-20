package com.kalita_ivan.gb.lesson2.command;

class Token {
    private String content;

    Token(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return this.content;
    }
}
