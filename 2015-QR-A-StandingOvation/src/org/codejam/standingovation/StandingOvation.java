package org.codejam.standingovation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 
 * @author juanjo
 */
public class StandingOvation {
	
	public static String newline = System.getProperty("line.separator");
	
	private static int calculateOvation(String line) {
		String s[] = line.split(" ");
		int sMax = Integer.parseInt(s[0]);
		String people = s[1];
		int n = 0; // Needed
		int c = 0; // Clapping
		int p; // people
		for (int k=0; k <= sMax; k++) {
			if (c >= sMax) {
				break;
			}
			p = people.charAt(k) - 48;
			if (k <= c) { // if there is quorum
				c += p;
			} else {
				if (p > 0) {
					n += (k-c);
					c += p + (k-c);
				}
			}
		}
		return n;		
	}

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		if (args.length != 2) {
			System.out.println("Usage: java " + StandingOvation.class + " inputFile outputFile");
			System.exit(0);
		}

		BufferedReader in = null;
		FileWriter out = null;
		String line = null;
		int count = 0;
	    int totalTestCases = 0;
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
				} //if
				else {
					testCasesCounter++;
					result = String.valueOf(calculateOvation(line));
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
	} // Main
}
