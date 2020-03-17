/**
 * 
 */
package org.codejam.noname;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


/**
 * @author Juanjo
 *
 */
public class Main {

  public static String newline = System.getProperty("line.separator");
  
  /**
   * Constructor
   */
  public Main() {
    super();
  }
  
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage: java " + Main.class  + " inputFile outputFile");
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
          result = "";
          result = "Case #" + testCasesCount + ": " + result;
          System.out.println(result + " -- Line: " + testCasesCount + ": " + line);
          out.write(result + newline);
        }
      }
    } //try
    catch (Exception e) {
      e.printStackTrace();
    }
  } // Main

}
