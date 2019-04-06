import java.io.InputStream;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        checkTroubleSort(System.in);
    }

    static void checkTroubleSort(InputStream in) {
        final Scanner scanner = new Scanner(in);
        final int totalCases = Integer.parseInt(scanner.nextLine());
        int currentCase = 1;
        String answer;
        for (int i = 0; i < totalCases; i++) {
            String line = scanner.nextLine();
            int length = Integer.parseInt(line); // max 100_000
            int[] vector = new int[length];
            for (int j = 0; j < length; j++) {
                vector[j] = scanner.nextInt();
            }
            scanner.nextLine(); // To read the \n
            troubleSort(vector);
            int badIndex = checkVector(vector);
            answer = (badIndex == -1 ? "OK" : String.valueOf(badIndex) );
            // System.out.println("Case #"+ (currentCase++) + ": " + answer + " -- " + convertToString(vector));
            System.out.println("Case #"+ (currentCase++) + ": " + answer);
        }
        scanner.close();
    }

    private static int checkVector(int[] vector) {
        int badIndex = -1;

        for (int i = 0; i < vector.length-1; i++) {
            if (vector[i] > vector[i+1]) {
                badIndex = i;
                break;
            }
        }
        return badIndex;
    }

    private static void troubleSort(int[] vector) {
        boolean done = false;
        while (!done) {
            done = true;
            for (int i = 0; i < vector.length - 2; i++) {
                if (vector[i] > vector[i+2]) {
                    done = false;
                    int x = vector[i];
                    vector[i] = vector[i+2];
                    vector[i+2] = x;
                }
            }
        }
    }

    static String convertToString(int[] vector) {
        int size = vector.length;
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < size - 1; i++) {
            stringBuilder.append(vector[i]).append(", ");
        }
        stringBuilder.append(vector[size - 1]);

        return stringBuilder.toString();
    }

}