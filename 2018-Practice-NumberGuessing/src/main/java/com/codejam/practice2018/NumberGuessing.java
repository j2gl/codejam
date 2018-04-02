package com.codejam.practice2018;

import java.io.PrintWriter;
import java.util.Scanner;

public class NumberGuessing {

    private static final String BIG = "TOO_BIG";
    private static final String SMALL = "TOO_SMALL";
    private static final String CORRECT = "CORRECT";
    private static final String WRONG = "WRONG_ANSWER";

    private static void guess(int min, int max) {

    }

    public static void main(final String[] args) {

        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        final int T = Integer.valueOf(scanner.nextLine());
        for (int i = 0 ; i < T; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int N = scanner.nextInt();
            writer.println("A: " + A);
            writer.println("B: " + B);
            writer.println("N: " + N);

            boolean flag = true;
            while (flag) {
                int guess = (A + B) / 2;
                writer.println(guess);
                writer.flush();
                flag = false;
            }
        }

    }

}
