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

        for (int i = 0; i < c.length(); i++) {
            if (c.charAt(i) != '?' && j.charAt(i) != '?') {
                cResult += c.charAt(i);
                jResult += j.charAt(i);
            }
            if (c.charAt(i) == '?' && j.charAt(i) == '?') {
                if (i == 0) {
                    cResult += "0";
                    jResult += "0";
                } else  if (i > 0) {
                    int ci = Integer.parseInt(cResult);
                    int ji = Integer.parseInt(jResult);
                    if ( ci == ji) {
                        cResult += "0";
                        jResult += "0";
                    } else if (ci - ji < 0) {
                        cResult += "9";
                        jResult += "0";
                    } else {
                        cResult += "0";
                        jResult += "9";
                    }
                }
            } else if (c.charAt(i) != '?' && j.charAt(i) == '?') {
                cResult += c.charAt(i);
                jResult += c.charAt(i);
            } else if (c.charAt(i) == '?' && j.charAt(i) != '?') {
                cResult += j.charAt(i);
                jResult += j.charAt(i);
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
