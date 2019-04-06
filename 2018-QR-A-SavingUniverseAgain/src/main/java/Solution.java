import java.io.InputStream;
import java.util.Scanner;

public final class Solution {

    public static void main(final String[] args) {
        doSaveUniverse(System.in);
    }

    public static void doSaveUniverse(final InputStream in) {
        final Scanner scanner = new Scanner(in);
        final int totalCases = Integer.parseInt(scanner.nextLine());
        int currentCase = 1;
        for (int i = 0; i < totalCases; i++) {
            final String line = scanner.nextLine();
            final String[] data = line.split(" ");
            final long maxDamage = Long.parseLong(data[0]);
            final String program = data[1];
            final String answer = saveUniverse(program, maxDamage);
            System.out.println("Case #" + (currentCase++) + ": " + answer);
        }
        scanner.close();
    }

    static String saveUniverse(final String program, final long maxDamage) {
        long totalDamage = calculateDamage(program);
        boolean possible = true;
        int numberHacks = 0;
        String newProgram = program;
        while (totalDamage > maxDamage && possible) {
            if (program.contains("CS")) {
                newProgram = hack(newProgram);
                numberHacks++;
            } else {
                possible = false;
            }
            totalDamage = calculateDamage(newProgram);
        }
        return (possible ? String.valueOf(numberHacks) : "IMPOSSIBLE");
    }

    private static String hack(final String program) {
        String newProgram = program;
        for (int i = program.length() - 2; i >= 0; i--) {
            if (newProgram.substring(i, i+2).equals("CS")) {
                final char[] chars = newProgram.toCharArray();
                chars[i] = 'S';
                chars[i+1] = 'C';
                newProgram = String.valueOf(chars);
                break;
            }
        }
        return newProgram;
    }

    private static long calculateDamage(final String s) {
        int strength = 1;
        int damage = 0;
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (c == 'C') {
                strength *= 2;

            } else if (c == 'S') {
                damage += strength;
            }
        }
        return damage;
    }

}
