package com.kalita_ivan.gb.lesson2.command;

import java.util.Arrays;

class TokenParser {
    Token[] parse(String line) {
        return Arrays.stream(line.split("\\s+"))
            .map(Token::new)
            .toArray(Token[]::new);
    }
}
