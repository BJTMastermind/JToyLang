package me.bjtmastermind.toylang.enums;

public enum TokenType {
    // Single-character tokens
    OPEN_PAREN,        // (
    CLOSE_PAREN,       // )
    OPEN_BRACE,        // {
    CLOSE_BRACE,       // }
    COMMA,             // ,
    DOT,               // .
    MINUS,             // -
    PLUS,              // +
    SEMICOLON,         // ;
    SLASH,             // /
    STAR,              // *

    // One or two character tokens
    BANG,              // !
    BANG_EQUAL,        // !=
    EQUAL,             // =
    EQUAL_EQUAL,       // ==
    GREATER,           // >
    GREATER_EQUAL,     // >=
    LESS,              // <
    LESS_EQUAL,        // <=

    // Literals
    IDENTIFIER,
    STRING,
    NUMBER,

    // Keywords
    AND,               // &&
    CLASS,             // class
    ELSE,              // else
    FALSE,             // false
    FUNC,              // func
    FOR,               // for
    IF,                // if
    NULL,              // null
    OR,                // ||
    PRINT,             // print
    RETURN,            // return
    SUPER,             // super
    SELF,              // self
    TRUE,              // true
    LET,               // let
    WHILE,             // while

    EOF                // end of file
}
