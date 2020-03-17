/**
 * 
 */
package org.codejam.sit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author juanjo
 *
 */
public class SpeakingInTongues {

  public static String newline = System.getProperty("line.separator");
    
  public static Map<Character,Character> initMap() {
    Map<Character, Character> map = new HashMap<Character, Character>();
    map.put('a','y');
    map.put('b','h');
    map.put('c','e');
    map.put('d','s');
    map.put('e','o');
    map.put('f','c');
    map.put('g','v');
    map.put('h','x');
    map.put('i','d');
    map.put('j','u');
    map.put('k','i');
    map.put('l','g');
    map.put('m','l');
    map.put('n','b');
    map.put('o','k');
    map.put('p','r');
    map.put('q','z');
    map.put('r','t');
    map.put('s','n');
    map.put('t','w');
    map.put('u','j');
    map.put('v','p');
    map.put('w','f');
    map.put('x','m');
    map.put('y','a');
    map.put('z','q');
    map.put(' ',' ');
    return map;
  }
  
  public static String translate(Map<Character, Character> map, String googlerese) {
    String s = "";
    for (int i = 0; i < googlerese.length(); i++) {
      s = s + map.get(googlerese.charAt(i));
    }
    return s;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    long time = System.currentTimeMillis();
    if (args.length != 2) {
      System.out.println("Usage: java " + SpeakingInTongues.class  + " inputFile outputFile");
      System.exit(0);
    }

    int count = 0;
    BufferedReader in = null;
    FileWriter out = null;
    String line = null;
    int testCasesTotal = 0;
    int testCasesCount = 0;
    String result;
    
    Map<Character, Character> charMap = initMap();

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
          result = translate(charMap, line);
          testCasesCount++;
          result = "Case #" + testCasesCount + ": " + result;
          System.out.println(result + " -- Line: " + testCasesCount + ": " + line);
          out.write(result + newline);
        }
      }
      if (out != null) {
        out.close();
      }
    } //try
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      System.out.println("Execution time ms.: " + (System.currentTimeMillis() - time) );
    }
  } // Main


}
