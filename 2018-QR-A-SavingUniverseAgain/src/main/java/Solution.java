import java.io.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        saveUniverse(System.in);
    }

    static void saveUniverse(InputStream in) {
        final Scanner scanner = new Scanner(in);
        final int totalCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < totalCases; i++) {
            String line = scanner.nextLine();
            String[] data = line.split(" ");
            long damage = Long.parseLong(data[0]);
            String program = data[1];



            System.out.println("Damage: " + damage + ", Program: " + program);
        }
        scanner.close();
    }

}