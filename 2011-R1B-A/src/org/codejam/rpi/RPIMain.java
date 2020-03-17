/**
 * 
 */
package org.codejam.rpi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


/**
 * @author Juanjo
 *
 */
public class RPIMain {

  public static String newline = System.getProperty("line.separator");
  
  private static double WP[] = null;
  private static double OWP[] = null;
  private static double OOWP[] = null;
  
  
  /**
   * Constructor
   */
  public RPIMain() {
    super();
  }
  
  private static double calculateWP(String line) {
    double wins = 0;
    double played = 0;
    for (int i=0; i < line.length(); i++) {
      if (line.charAt(i) != '.') {
        played++;
      }
      if (line.charAt(i) == '1') {
        wins++;
      }
    }
    return wins/played;
  }
  
  
  
  private static double calculateOWP(String[] games, int row, int N) {
    
    String line = "";
    boolean flag = true;
    int played = 0;
    double OWP = 0;
    
    for (int i = 0; i < N; i++) {
      if  (i != row) {
        line = "";
        flag = true;
        for (int j = 0; j < N; j++) {
          if (games[i].charAt(row) == '.') {
            flag = false;
            continue;
          }
          else {
            if (j != row) {
              line = line + games[i].charAt(j);
            }
          } 
        }
        
        if (flag) {
          played++;
          OWP = OWP + calculateWP(line);
        }
      }
      
    }
    return OWP / played;
  }
  
  private static double calculateOOWP(String line, int row) {
    double d = 0;
    double played = 0;
    
    for (int i=0; i < line.length(); i++) {
      if (line.charAt(i) != '.') {
        played++;
        d = d + OWP[i];
      }
    }
    return d/played;
  }
  
  private static String[] calculateRPI(String[] games) {
    String results[] = null;
    double rpi = 0.0;
    
    int N = games.length;
    results = new String[N];
    
    results = new String[N];
    WP = new double[N];
    OWP = new double[N];
    OOWP = new double[N];
    
    for (int i=0; i < N; i++) {
      WP[i] = calculateWP(games[i]);
      OWP[i] = calculateOWP(games, i, N);
      
      //System.out.println("WP  : " + WP[i]);
      //System.out.println("OWP : " + OWP[i]);
    }
    
    for (int i=0; i < N; i++) {
      OOWP[i] = calculateOOWP(games[i], i);
      //System.out.println("OOWP : " + OOWP[i]);
      rpi = 0.25 * WP[i] + 0.50 * OWP[i] + 0.25 * OOWP[i];
      
      results[i] = Double.toString(rpi); 
    }
    
    return results;
    
    
    
    
  }
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage: java " + RPIMain.class  + " inputFile outputFile");
      System.exit(0);
    }

    int count = 0;
    BufferedReader in = null;
    FileWriter out = null;
    String line = null;
    int testCasesTotal = 0;
    int testCasesCount = 0;
    String result = null;
    String games[] = null;
    String results[] = null;
    
    int N = 0;

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
          N = Integer.valueOf(line);
          //System.out.println("Number of teams: " + N);
          
          result = "Case #" + testCasesCount + ": ";
          System.out.println(result);
          out.write(result + newline);
          
          games = new String[N];
          for (int i=0; i<N; i++) {
            games[i] = in.readLine();
          } //for
          
          results = calculateRPI(games);
          for (int i=0; i<N; i++) {
            System.out.println(results[i]);
            out.write(results[i] + newline);
          } //for
        }
      }
      out.close();
    } //try
    catch (Exception e) {
      e.printStackTrace();
    }
  } // Main

}
