package org.codejam.qr2019a;

import java.io.InputStream;
import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        doForegoneSolution(Solution.class.getClassLoader().getResourceAsStream("example.txt"));
    }

    static void doForegoneSolution(InputStream in) {
        final Scanner scanner = new Scanner(in);

        // Take the number of cases
        final int totalCases = Integer.parseInt(scanner.nextLine());
        int currentCase = 1;

        String answer;
        for (int i = 0; i < totalCases; i++) {
            String line = scanner.nextLine();

            long number = Long.parseLong(line);

            answer = findNumbersWithout4(number, 0);
            System.out.println("Case #"+ (currentCase++) + ": " + answer );

        }
        scanner.close();
    }

    private static String doIt(int currentCase, long number) {
        String n = Long.toString(number);
        return findNumbersWithout4(number, 0);
    }

    private static String findNumbersWithout4(long n1, long n2) {
        if (hasNotAFour(n1) && (hasNotAFour(n2))) {
            return n1 + " " + n2;
        }
        return findNumbersWithout4(n1 -1, n2 + 1);
    }

    static void find4(String n) {
        int index = n.indexOf('4');
        System.out.println("index = " + index + ", n = " + n);

    }

    private static boolean hasNotAFour(long n) {
        return !String.valueOf(n).contains("4");
    }

    private static boolean hasAFour(String s) {
        return s.contains("4");
    }

}