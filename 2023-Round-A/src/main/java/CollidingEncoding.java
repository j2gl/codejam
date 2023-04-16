import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CollidingEncoding {

    public static void main(String[] args) {
        doSolution(System.in);
        // doSolution(CollidingEncoding.class.getClassLoader().getResourceAsStream("SampleInput.txt"));
    }

    private static void doSolution(InputStream in) {
        final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));

        // Take the number of cases
        final int totalCases = Integer.parseInt(scanner.nextLine());

        int currentCase = 1;
        for (int i = 0; i < totalCases; i++) {
            // letters
            String line = scanner.nextLine();

            // fill encodingMap
            String[] decimalDigits = line.split(" ");
            Map<Character, Character> encodingMap = new HashMap<>();
            int c = 0;
            for (char letter = 'A'; letter <= 'Z'; letter++) {
                encodingMap.put(letter, decimalDigits[c++].charAt(0));
            }

            boolean collision = false;
            // System.out.println("encodingMap = " + encodingMap);
            Set<String> words = new HashSet<>();
            int numberOfWords = Integer.parseInt(scanner.nextLine());
            for (int j = 0; j < numberOfWords; j++) {
                String word = scanner.nextLine();
                if (collision) {
                    continue;
                }
                // System.out.println("word " + j + " = " + word);
                StringBuilder encodedWordSB = new StringBuilder();
                for (int k = 0; k < word.length(); k++) {
                    encodedWordSB.append(encodingMap.get(word.charAt(k)));
                }
                String encodedWord = encodedWordSB.toString();
                if (words.contains(encodedWord)) {
                    collision = true;
                }
                words.add(encodedWord);
                // System.out.println("encodedWord = " + encodedWord);
            }
            System.out.println("Case #" + (currentCase++) + ": " + (collision ? "YES" : "NO"));
        }

        scanner.close();
    }

}