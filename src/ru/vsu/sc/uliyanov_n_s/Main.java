package ru.vsu.sc.uliyanov_n_s;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = readLength("Input n: ");
        char[] charBox = new char[2 * n];
        printParenthesis(charBox, 0, n, 0, 0);
    }

    static void printParenthesis(char[] str, int pos, int n, int open, int close) {
        if (close == n) {
            for (char c : str) {
                System.out.print(c);
            }
            System.out.println();
        } else {
            if (open > close) {
                str[pos] = ')';
                printParenthesis(str, pos + 1, n, open, close + 1);
            }
            if (open < n) {
                str[pos] = '(';
                printParenthesis(str, pos + 1, n, open + 1, close);
            }
        }
    }

    static int readLength(String text) {
        System.out.print(text);
        Scanner scanner = new Scanner(System.in);
        int n;

        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
            if (n < 1) {
                System.out.println("Invalid value! Number can't be even adn less than two. Try again.");
                return readLength(text);
            }
        } else {
            System.out.println("Invalid value! You need to enter a INTEGER NUMBER. Try again.");
            return readLength(text);
        }

        return n;
    }
}