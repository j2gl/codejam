package com.codejam.practice2018;

import java.io.PrintWriter;
import java.util.Scanner;

public class NumberGuessing {
    
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
