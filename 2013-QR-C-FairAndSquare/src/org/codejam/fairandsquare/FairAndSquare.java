/**
 * 
 */
package org.codejam.fairandsquare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * I only managed to solve the small input.  I was busy going to a race 15Km in panajachel Guatemala, 
 * So next day I finished writing the program that could solve the first large input.
 * I now that this solutions is impossible to solve the large input.
 * 
 * Now that I read the solution on google contest analysis: https://code.google.com/codejam/contest/2270488/dashboard#s=a&a=2
 * 
 * Thus, the Fair and Square numbers are exactly the palindromes with no carries inside. In particular, 
 * the middle digit of X is the sum of squares of all the digits of Y, so this sum has to be no larger than nine. 
 * We conclude that only 0, 1, 2, and 3 can appear in Y.
 * 
 * Ex: 2000002 --> It's square is 4000008000004 and the sum 2^2 + 2^2 = 8
 *     1100011 --> It's square is 1210024200121 and the sum 1^2 + 1^2 + 1^2 + 1^2 = 4
 * 
 * it is needed to pre build the numbers from 1 to (1 * 10^50) numbers:
 * 1) that are odd in digits size a
 * 2) That have only digits 0,1,2 and 3
 * 3) That are palindromes
 *     
 * @author jgarcia
 */
public class FairAndSquare {
    
    public static String newline = System.getProperty("line.separator");
    
    //private static int MAX_RANGE = 1000;
    private static long MAX_RANGE = 10000000L;
    
    //private static Map<Long, Long> sqrtMap = new HashMap<Long, Long>(MAX_RANGE);
    private static List<Long> fairSqrNumbers = new ArrayList<Long>(1000);

    
    private static void calculatesqrtList() {
	long result;
	for (long i = 1; i <= MAX_RANGE; i++) {
	    if (isFair(i)) {
		result = i * i;
		if (isFair(result)) {
		    fairSqrNumbers.add(result);
		    System.out.println(i + " - " + result);
		}
	    }
	}
    }
    
    public static boolean isFair(final long n) {
	String s;
	int length;
	StringBuilder sb;
	long result;
	
	s = Long.toString(n);
	length = s.length();
	sb = new StringBuilder();
	for (int i = 0; i < length; i++) {
	    sb.append(s.charAt(length - i - 1));
	}
	result = Long.parseLong(sb.toString());
	return result == n;
    }

    
    private static long fairAndSquareTotal(final long a, final long b) {
	long count;
	
	count = 0;
	for (Long l : fairSqrNumbers) {
	    if (l >= a && l <= b) {
		count++;
	    }
	}	
	return count;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

	if (args.length != 2) {
	    System.out.println("Usage: java " + FairAndSquare.class
		    + " inputFile outputFile");
	    System.exit(0);
	}

	int count = 0;
	BufferedReader in = null;
	FileWriter out = null;
	String line = null;
	int testCasesTotal = 0;
	int testCasesCount = 0;
	String result;
	long millis;
	

	try {
	    millis = System.currentTimeMillis();
	    // calculatesqrtMap();
	    calculatesqrtList();
	    System.out.println("calculatesqrtMap() time: " + (System.currentTimeMillis() - millis) / 1000);
	    in = new BufferedReader(new FileReader(args[0]));
	    out = new FileWriter(args[1]);

	    while ((line = in.readLine()) != null) {
		count++;
		if (count == 1) {
		    testCasesTotal = Integer.valueOf(line);
		    System.out.println("File " + args[0] + " total of test cases: "
			    + testCasesTotal + ".");
		} // if
		else {
		    testCasesCount++;
		    // System.out.print("Line: " + testCasesCount+ ": " + line + " -- ");
		    
		    String s[] = line.split(" ");
		    long a = Long.valueOf(s[0]);
		    long b = Long.valueOf(s[1]);
		    
		    
		    result = "Case #" + testCasesCount + ": " + fairAndSquareTotal(a, b);
		    System.out.println(result);
		    out.write(result + newline);
		}
	    }
	    in.close();
	    out.close();
	    System.out.println("Finished " + testCasesCount + " in " + 
	    (System.currentTimeMillis() - millis) / 1000);

	} // try
	catch (Exception e) {
	    e.printStackTrace();
	}
    }

}
