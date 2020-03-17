/**
 * 
 */
package org.codejam.fairandsquare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jgarcia
 * 
 */
public class FairAndSquare {
    
    public static String newline = System.getProperty("line.separator");
    
    private static int MAX_RANGE = 1000;
    // private static int MAX_RANGE = 10000000;
    
    private static Map<Long, Long> sqrtMap = new HashMap<Long, Long>(MAX_RANGE);
    
    

    public FairAndSquare() {
    }
    
    public static void calculatesqrtMap() {
	long result;
	//for (long i = 0; i <= 10000000L; i++) {
	for (long i = 0; i <= MAX_RANGE; i++) {
	    result = i * i;
	    sqrtMap.put(result, i);
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
    
    public static long fairAndSquareTotal(final long a, final long b) {
	long count;
	Long sqrt;
	
	count = 0;
	for (long i = a; i <= b; i++) {
	    if (isFair(i)) {
		sqrt = sqrtMap.get(i);
		if (sqrt != null && isFair(sqrt)) {
		    count++;
		}
	    }
	}
	return count++;
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
	    calculatesqrtMap();
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
		    
		    String s[] = line.split(" ");
		    long a = Long.valueOf(s[0]);
		    long b = Long.valueOf(s[1]);
		    
		    result = "Case #" + testCasesCount + ": " + fairAndSquareTotal(a, b);
		    System.out.println(result + " -- Line: " + testCasesCount
			    + ": " + line);
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
