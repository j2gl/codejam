package com.codejam.qr2016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class CountingSheep {

    public static String newline = System.getProperty("line.separator");


    private static void storeDigits(boolean digitsFound[], String number) {
        int digit;
        for (int i=0; i < number.length(); i++) {
            digit = number.charAt(i) - 48;
            digitsFound[digit] = true;
        }
    }

    private static boolean seenAllDigits(boolean digitsFound[]) {
        for (boolean b : digitsFound) {
            if (b == false) {
                return false;
            }
        }
        return true;
    }

    private static String lastNumberBleatrix(String number) {
        if (number.trim().equals("0")) {
            return "INSOMNIA";
        }

        boolean keepGoing = true;
        int i = 1;
        int n = Integer.parseInt(number);
        int last;
        boolean[] digitsFound = new boolean[10];
        while (keepGoing) {
            last = n * i++;
            storeDigits(digitsFound, String.valueOf(last));
            if (seenAllDigits(digitsFound)) {
                return String.valueOf(last);
            }
        }
        return null;
    }


    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        if (args.length != 2) {
            System.out.println("Usage: java " + CountingSheep.class + " inputFile outputFile");
            System.exit(0);
        }

        BufferedReader in;
        FileWriter out;
        String line;
        int totalTestCases;
        int count = 0;
        int testCasesCounter = 0;
        String result;

        try {
            in = new BufferedReader(new FileReader(args[0]));
            out = new FileWriter(args[1]);
            while ( (line = in.readLine()) != null) {
                count++;
                if (count == 1) {
                    totalTestCases = Integer.valueOf(line);
                    System.out.println("In file number of test cases: "	+ totalTestCases + ".");
                } //if
                else {
                    testCasesCounter++;
                    result = lastNumberBleatrix(line);
                    result = "Case #" + testCasesCounter + ": " + result;
                    System.out.println(result + " -- Line: " + testCasesCounter + ": " + line);
                    out.write(result + newline);
                }
            }
            if (out != null) {
                out.close();
            }
            if (out != null) {
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Execution time ms.: " + (System.currentTimeMillis() - time));
        }
    } // Main

}
