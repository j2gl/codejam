package com.codejam.qr2016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class RevengeOfPancakes {

    public static String newline = System.getProperty("line.separator");

    private static String flipPancakes(String stack) {
        char[] charStack = stack.toCharArray();
        for (int i = 0; i < charStack.length; i++) {
            charStack[i] = charStack[i] == '+' ? '-' : '+';
        }
        return String.valueOf(charStack);
    }

    private static String removeBottomHappyPancakes(String stack) {
        int i = stack.length() - 1;
        while (i >= 0 && stack.charAt(i) == '+') {
            i--;
        }
        return stack.substring(0, i+1);

    }

    private static int getTotalExecutions(String stack) {
        String s = removeBottomHappyPancakes(stack);
        int flips = 0;
        while (s.length() > 0) {
            s = flipPancakes(s);
            s = removeBottomHappyPancakes(s);
            flips++;
        }
        return flips;
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        if (args.length != 2) {
            System.out.println("Usage: java " + RevengeOfPancakes.class + " inputFile outputFile");
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
                    result = String.valueOf(getTotalExecutions(line));
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
