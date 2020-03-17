/**
 * 
 */
package org.codejam.snapperchain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author Juanjo
 *
 */
public class SnapperChainMain {
  
  public static String newline = System.getProperty("line.separator");
  
  public static boolean isSnapperON(Long n, Long k) {
    Long power = Math.round(Math.pow(2, n));
    return (k+1) % power == 0 ? true : false ;
  }

  /**
   * 
   */
  public SnapperChainMain() {
    super();
  }

  
  /**
   * 
   * @param args
   */
  public static void main(String[] args) {
    
    if (args.length != 2) {
      System.out.println("Usage: java " + SnapperChainMain.class  + " inputFile outputFile");
      System.exit(0);
    }
    
    BufferedReader in = null;
    FileWriter out = null;
    String line = null;
    
    int count = 0;    
    int testCasesCount = 0;
    int testCase = 1;
    
    Long N = null;
    Long K = null;
    
    try {
      in = new BufferedReader(new FileReader(args[0]));
      out = new FileWriter(args[1]);
      
      while ( (line = in.readLine()) != null) {
        count++;
        if (count == 1) {
          testCasesCount = Integer.valueOf(line);
        }
        else if ( (count > 1) && (count <= (testCasesCount + 1))) {
          out.write("Case #" + testCase++ + ": ");
          
          String s[] = line.split(" ");
          N = Long.valueOf(s[0]);
          K = Long.valueOf(s[1]);
          
          if ( isSnapperON(N, K) ) 
            out.write("ON" + newline);          
          else 
            out.write("OFF" + newline);
          
         
        }
      } //while
      in.close();
      out.close();
    } 
    catch (Exception e) {
      e.printStackTrace();
    }

  }
}
