package me.bjtmastermind.toylang;

import me.bjtmastermind.toylang.enums.TokenType;

public class Token {
    final TokenType type;
    final String lexeme;
    final Object literal;
    final int line;

    public Token(TokenType type, String lexeme, Object literal, int line) {
        this.type = type;
        this.lexeme = lexeme;
        this.literal = literal;
        this.line = line;
    }

    @Override
    public String toString() {
        if (literal != null && lexeme != null) {
            return String.format("%s(lit=%s, lex=%s)", type, literal, lexeme);
        }
        if (literal != null && lexeme == null) {
            return String.format("%s(%s)", type, literal);
        }
        if (literal == null && lexeme != null) {
            return String.format("%s(%s)", type, lexeme);
        }
        return String.format("%s", type);
    }
}
