/**
 * 
 */
package org.codejam.themepark;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author Juanjo
 *
 */
public class ThemeParkMain {
  
  public static String newline = System.getProperty("line.separator");

  /**
   * Consturctor
   */
  public ThemeParkMain() {
    super();
  }
  
  /**
   * 
   * @param R Run Times
   * @param k Quantity of people hold at once. Seats
   * @param g An array with the quantity of persons for each group.
   * @return
   */
  public static Long caculateEarnings(Long R, Long k, Long[] g) {
    long money = 0;
    int groupPointer = 0;
    int initialGroupPointer = 0;
    long remaingSeats = 0;
    boolean seatsAvailable = true;
    
    for (int i = 0; i < R; i++ ) {
      remaingSeats = k;
      seatsAvailable = true;
      
      initialGroupPointer = groupPointer;
      while ( seatsAvailable ) {
        if ( g[groupPointer] <= remaingSeats) {
          remaingSeats = remaingSeats - g[groupPointer];
          money = money + g[groupPointer];
          
          groupPointer = ( ++groupPointer >= g.length ? 0 : groupPointer);
          
          if (groupPointer == initialGroupPointer) 
            seatsAvailable = false;

        }
        else {
          seatsAvailable = false;
        }
      }
    }
    return money;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    if (args.length != 2) {
      System.out.println("Usage: java " + ThemeParkMain.class  + " inputFile outputFile");
      System.exit(0);
    }
    
    BufferedReader in = null;
    FileWriter out = null;
    String line = null;
    
    int lineNumber = 0;    
    int testCasesCount = 0;
    int testCase = 0;
    
    Long R = 0L;
    Long k = 0L;
    Integer N = 0;
    Long[] g = null;
    Long result = null;
    
    try {
      in = new BufferedReader(new FileReader(args[0]));
      out = new FileWriter(args[1]);
      
      while ( (line = in.readLine()) != null) {
        lineNumber++;
        if (lineNumber == 1) {
          testCasesCount = Integer.valueOf(line);
        }
        else if ( (lineNumber > 1) && ( (lineNumber % 2) == 0) ) { // If it's the line with data
          String s[] = line.split(" ");
          R = Long.valueOf(s[0]);
          k = Long.valueOf(s[1]);
          N = Integer.valueOf(s[2]);
        }
        else {
          out.write("Case #" + ++testCase + ": ");
          String s[] = line.split(" ");
          
          g = new Long[N];
          for (int i = 0; i < N; i++) 
            g[i] = Long.valueOf(s[i]);
          result = caculateEarnings(R, k, g);
          
          out.write(result + newline);
          System.out.println("Case #" + (testCase) + ": " + result);
          
        }
      } //while
      in.close();
      out.close();
      System.out.println("Finished " + testCase + " of " + testCasesCount + ".");
    } 
    catch (Exception e) {
      e.printStackTrace();
    }
  }

}
