import java.io.InputStream;
import java.util.Scanner;

public class SubmittedSolutionBad {

    public static void main(String[] args) {
        saveUniverse(System.in);
    }

    static void saveUniverse(InputStream in) {
        final Scanner scanner = new Scanner(in);
        final int totalCases = Integer.parseInt(scanner.nextLine());
        int currentCase = 1;
        for (int i = 0; i < totalCases; i++) {
            String line = scanner.nextLine();
            String[] data = line.split(" ");
            long maxDamage = Long.parseLong(data[0]);
            String program = data[1];

            long totalDamage = calculateDamage(program);
            boolean possible = true;
            int numberHacks = 0;
            while (totalDamage > maxDamage && possible) {
                if (program.contains("CS")) {
                    program = hack(program);
                    numberHacks++;
                } else {
                    possible = false;
                }
                totalDamage = calculateDamage(program);
            }

            String answer = (possible ? String.valueOf(numberHacks) : "IMPOSSIBLE");
            System.out.println("Case #"+ (currentCase++) + ": " + answer);
        }
        scanner.close();
    }

    static String hack(String program) {
        String newProgram = program;
        if (newProgram.contains("CS")) {
            newProgram = program.replaceFirst("CS", "SC");
        }
        return newProgram;

    }

    static long calculateDamage(String s) {
        int strength = 1;
        int damage = 0;
        for (int i = 0 ; i < s.length(); i++) {
            final char c = s.charAt(i);
            switch (c) {
                case 'C':
                    strength*=2;
                    break;
                case 'S':
                    damage += strength;
            }
        }
        return damage;
    }

}