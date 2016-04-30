package com.codejam.round1ba;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class GettingDigits {

    public static String newline = System.getProperty("line.separator");

    public static String[] numbers = {"ZERO", "SIX", "FOUR", "TWO", "EIGHT", "THREE", "FIVE", "SEVEN", "ONE", "NINE"};
    public static int[] intNumbers = {0, 6, 4, 2, 8, 3, 5, 7, 1, 9};


    private static boolean contains(String number, String data) {
        for (int i = 0; i < number.length(); i++) {
            if (data.indexOf(number.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }

    private static String removeNumberLetters(String data, String number) {
        String s = data;
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (s.indexOf(c) != -1) {
                s = s.replaceFirst(String.valueOf(c), "");
            }
        }
        return s;
    }

    private static String sortData(String data) {
        char[] array = data.toCharArray();
        Arrays.sort(array);
        return String.valueOf(array);
    }

    public static String getDigits(final String data) {
        String result = "";
        String number;
        String inputString = data;
        for (int i = 0; i < numbers.length; i++) {
            number = numbers[i];
            while (contains(number, inputString)) {
//                System.out.println("InputString    : " + inputString);
//                System.out.println("Contains number: " + number);
                inputString = removeNumberLetters(inputString, number);
                result = result + String.valueOf(intNumbers[i]);
            }
        }
//        System.out.println("inputString final: " + inputString);
        return sortData(result);
    }

    public static void main(String[] args) {
        System.out.println("Getting Digits");
        long time = System.currentTimeMillis();
        if (args.length != 2) {
            System.out.println("Usage: java " + GettingDigits.class + " inputFile outputFile");
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
                } else {
                    testCasesCounter++;
                    result = getDigits(line);
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
    }

}
