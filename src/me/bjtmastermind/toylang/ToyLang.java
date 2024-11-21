package me.bjtmastermind.toylang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import me.bjtmastermind.toylang.lexer.Lexer;

public class ToyLang {
    static boolean hadError = false;

    public static void main(String[] args) throws IOException{
        if (args.length > 1) {
            System.out.println("Usage: jtoylang [script]");
            System.exit(64);
        } else if (args.length == 1) {
            runFile(args[0]);
        } else {
            runPrompt();
        }
    }

    public static void error(int line, String message) {
        report(line, "", message);
    }

    private static void runFile(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        run(new String(bytes));

        // Indicate an error in the exit code
        if (hadError) {
            System.exit(65);
        }
    }

    private static void runPrompt() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        while (true) {
            System.out.print("> ");
            String line = reader.readLine();

            if (line == null) {
                break;
            }

            run(line);
            hadError = false;
        }
    }

    private static void run(String source) {
        Lexer scanner = new Lexer(source);
        List<Token> tokens = scanner.scanTokens();

        for (Token token : tokens) {
            System.out.println(token);
        }
    }

    private static void report(int line, String where, String message) {
        System.err.println(String.format("[line %d] Error %s: %s", line, where, message));
        hadError = true;
    }
}
