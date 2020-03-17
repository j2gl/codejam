/**
 * 
 */
package org.codejam.freecell;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;


/**
 * @author Juanjo
 *
 */
public class FreeCellMain {

  public static String newline = System.getProperty("line.separator");
  public static final String POSSIBLE = "Possible";
  public static final String BROKEN = "Broken";
  
  /**
   * Constructor
   */
  public FreeCellMain() {
    super();
  }
  
  
  
  
  private static boolean testCase(BigInteger N, Integer Pd, Integer Pg) {
    boolean flag = false;
    
    long r = 0;
    for (long i = 1; i <= N.longValue(); i++) {
      r = (i * 100) % Pd;
      if (r == 0) {
        flag = true;
        break;
      }
    }
    
    return flag;
  }
  
  
  private static String isPosible(String line) {
    String s[] = null;
    
    s = line.split(" ");
    
    BigInteger N = new BigInteger(s[0]);
    Integer Pd = Integer.valueOf(s[1]);
    Integer Pg = Integer.valueOf(s[2]);
    
    if ((Pg.intValue() == 0) && (Pd.intValue() == 0) )
      return POSSIBLE;
    
    if ((Pg.intValue() == 0) )
    
    if ((Pg.intValue() == 100) && (Pd < 100)) 
      return BROKEN;
    
    if (testCase(N, Pd, Pg) == true)
      return POSSIBLE;
    else   
      return BROKEN;
             
  }
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage: java " + FreeCellMain.class  + " inputFile outputFile");
      System.exit(0);
    }

    int count = 0;
    BufferedReader in = null;
    FileWriter out = null;
    String line = null;
    int testCasesTotal = 0;
    int testCasesCount = 0;
    String result;
    

    try {
      in = new BufferedReader(new FileReader(args[0]));
      out = new FileWriter(args[1]);
      
      while ( (line = in.readLine()) != null) {
        count++;
        if (count == 1) {
          testCasesTotal = Integer.valueOf(line);
          System.out.println("In file number of test cases: " + testCasesTotal + ".");
        } //if
        else {
          testCasesCount++;
          result = isPosible(line);
          
          result = "Case #" + testCasesCount + ": " + result;
          System.out.println(result + " -- Line: " + testCasesCount + ": " + line);
          out.write(result + newline);
        }
      }
      out.close();
    } //try
    catch (Exception e) {
      e.printStackTrace();
    }
  } // Main

}
