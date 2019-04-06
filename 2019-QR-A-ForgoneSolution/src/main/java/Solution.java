import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        doForegoneSolution(System.in);
        // doForegoneSolution(Solution.class.getClassLoader().getResourceAsStream("example.txt"));
    }

    static void doForegoneSolution(InputStream in) {
        final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));

        // Take the number of cases
        final int totalCases = Integer.parseInt(scanner.nextLine());

        int currentCase = 1;
        for (int i = 0; i < totalCases; i++) {
            String line = scanner.nextLine();
            final long number = Long.parseLong(line);
            final String answer = findNumbersWithout4(number, 0);
            System.out.println("Case #" + (currentCase++) + ": " + answer);
        }

        scanner.close();
    }

    private static String findNumbersWithout4(long n1, long n2) {
        if (hasNotAFour(n1) && (hasNotAFour(n2))) {
            return n1 + " " + n2;
        }
        return findNumbersWithout4(n1 - 1, n2 + 1);
    }

    private static boolean hasNotAFour(long n) {
        return !String.valueOf(n).contains("4");
    }

}