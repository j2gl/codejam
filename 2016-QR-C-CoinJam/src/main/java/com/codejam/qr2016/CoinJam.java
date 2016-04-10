package com.codejam.qr2016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CoinJam {

    public static String newline = System.getProperty("line.separator");
    public static String PRIME_NUMBERS_FILE = "files/PrimeNumbersBig.txt";

    private static Set<Long> primeNumbers = new HashSet<Long>(20000);

    public static void loadPrimeNumbers(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = in.readLine()) != null) {
            primeNumbers.add(Long.valueOf(line));
        }
        in.close();
    }

    private static String repeatChar(int count, char c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static String incrementCandidate(String oldCandidate, int n) {
        String newCandidate = oldCandidate.substring(1, n - 1);
        int middle = Integer.valueOf(newCandidate, 2);
        middle++;
        String zeroes = repeatChar(n - 2, '0');
        String s = Integer.toString(middle, 2);
        newCandidate = "1" + zeroes.substring(s.length()) + s + "1";
        return newCandidate;
    }

    public static boolean isJamCoin(String candidate) {
        if (candidate == null || !candidate.startsWith("1") || !candidate.endsWith("1")) {
            return false;
        }

        for (int i = 2; i <= 10; i++) {
            if (primeNumbers.contains(Long.valueOf(candidate, i))) {
                return false;
            }
        }
        return true;
    }

    public static long findFirstFactor(long n) {
        for (long i = 2; i * i <= n; i++) {
            if ( n % i == 0 ) {
                return i;
            }
        }
        return -1;
    }


    public static String findNonTrivialDivisiors(String jamCoin) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= 10; i++) {
            long interpretation = Long.valueOf(jamCoin, i);
            sb.append(findFirstFactor(interpretation)).append(" ");
        }
        return sb.toString();
    }


    private static String findJamcoins(int n, int j) {
        final String lastCandidate = repeatChar(n, '1');
        StringBuilder sb = new StringBuilder();
        String candidate = "1" + repeatChar(n - 2, '0') + "1";

        int found = 0;
        boolean flag = true;
        while (flag && found < j) {
            if (isJamCoin(candidate)) {
                String factors = "";
                System.out.print(candidate + " -> ");
                for (int i = 2; i <= 10; i++) {
                    long interpretation = Long.valueOf(candidate, i);
                    System.out.print(interpretation + " ");
                    long firstFactor = findFirstFactor(interpretation);
                    if ( firstFactor == -1) {
                        candidate = incrementCandidate(candidate, n);
                        break;
                    } else {
                        factors += firstFactor + " ";
                    }
                }
                if (factors.split(" ").length < 9) {
                    System.out.println("");
                    continue;
                }

                System.out.println("-> " + factors.trim());
                sb.append(candidate).append(" ").append(factors.trim()).append(newline);
                found++;
            }
            if (lastCandidate.equals(candidate)) {
                flag = false;
            } else {
                candidate = incrementCandidate(candidate, n);
            }
        }
        return sb.toString().trim();
    }


    public static void main(String[] args) {

        long time = System.currentTimeMillis();
        if (args.length != 2) {
            System.out.println("Usage: java " + CoinJam.class + " inputFile outputFile");
            System.exit(0);
        }

        try {
            loadPrimeNumbers(PRIME_NUMBERS_FILE);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
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
            while ((line = in.readLine()) != null) {
                count++;
                if (count == 1) {
                    totalTestCases = Integer.valueOf(line);
                    System.out.println("In file number of test cases: " + totalTestCases + ".");
                } else {
                    testCasesCounter++;
                    out.write("Case #" + testCasesCounter + ": " + newline);
                    String[] values = line.split(" ");
                    int n = Integer.parseInt(values[0]);
                    int j = Integer.parseInt(values[1]);
                    result = findJamcoins(n, j);
                    out.write(result + newline);
                    System.out.println(result);
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
