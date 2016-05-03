package com.codejam.round1bb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class CloseMatch {

    public static String newline = System.getProperty("line.separator");


    public static String closeMatch(final String data) {
        String[] split = data.split(" ");
        String c = split[0];
        String j = split[1];
        String cResult = "";
        String jResult = "";
        long ci;
        long ji;
        long diff;

        for (int i = 0; i < c.length(); i++) {
            if (c.charAt(i) != '?' && j.charAt(i) != '?') {
                cResult += c.charAt(i);
                jResult += j.charAt(i);
            } else {
                ci = (i == 0 ? 0 : Long.parseLong(cResult));
                ji = (i == 0 ? 0 : Long.parseLong(jResult));
                diff = ci - ji;

                if (diff == 0) {
                    if (c.charAt(i) == '?' && j.charAt(i) == '?') {
                        cResult += "0";
                        jResult += "0";
                    } else if (c.charAt(i) == '?' && j.charAt(i) != '?') { //7?9 750 = 759 750
                        cResult += j.charAt(i);
                        jResult += j.charAt(i);
                    } else if (c.charAt(i) != '?' && j.charAt(i) == '?') { //750 7?9 = 750 750
                        cResult += c.charAt(i);
                        jResult += c.charAt(i);
                    }
                } else if (diff < 0) { // 1? 2? = 19 20
                    if (c.charAt(i) == '?' && j.charAt(i) == '?') {
                        cResult += "9";
                        jResult += "0";
                    } else if (c.charAt(i) == '?' && j.charAt(i) != '?') { // 1? 25 = 19 25
                        cResult += "9";
                        jResult += j.charAt(i);
                    } else if (c.charAt(i) != '?' && j.charAt(i) == '?') { // 19 2? = 19 20
                        cResult += c.charAt(i);
                        jResult += "0";
                    }
                } else if (diff > 0) {
                    if (c.charAt(i) == '?' && j.charAt(i) == '?') { // 2? 1? = 20 29
                        cResult += "0";
                        jResult += "9";
                    } else if (c.charAt(i) == '?' && j.charAt(i) != '?') { // 2? 19 = 20 19
                        cResult += "0";
                        jResult += j.charAt(i);
                    } else if (c.charAt(i) != '?' && j.charAt(i) == '?') { // 27 1? = 27 19
                        cResult += c.charAt(i);
                        jResult += "9";
                    }
                }
            }
        }

        return cResult + " " + jResult;
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        if (args.length != 2) {
            System.out.println("Usage: java " + CloseMatch.class + " inputFile outputFile");
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
                    result = closeMatch(line);
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
