/**
 * 
 */
package org.codejam.magicka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Juanjo
 *
 */
public class MagickaMain {

  public static String newline = System.getProperty("line.separator");

  private static List<String> splitCombinedElements(String line) {
    
    String[] split = null;    
    List<String> combinedElements = null;
    int count = 0;
    
    combinedElements = new ArrayList<String>();
    split = line.split(" ");
    
    count = Integer.valueOf(split[0]);
    for (int i = 1; i <= count; i++) {
      combinedElements.add(split[i]);
    }
    return combinedElements;
  }
  
  private static List<String> splitOpposedElements(String line) {
    
    String[] split = null;    
    List<String> opposedElements = null;
    
    int countOpposed = 0;
    int offset = 0;
    
    opposedElements = new ArrayList<String>();
    split = line.split(" ");
    
    offset = Integer.valueOf(split[0]) + 1;
    countOpposed = Integer.valueOf(split[offset]);
    
    for (int i = offset+1; i <= (offset + countOpposed); i++) {
      opposedElements.add(split[i]);
    }
    return opposedElements;
  }
  
  
  private static String getElements(String line) {
    
    String[] split = null;    
    int offset = 0;
    String s = null;

    split = line.split(" ");
    offset = Integer.valueOf(split[0]) + 1;
    offset = offset + Integer.valueOf(split[offset])+1;
    s = split[offset+1];
    return s;
  }
  
  private static String invokeElements(List<String> combinedElements, List<String> opposedElements, String elements) {
    String base1 = null;
    String base2 = null;
    String nonBase = null;
    String current = elements;
    String temp = null;
    boolean foundCombined = false;
    
    for (String combined : combinedElements) {
      base1 = String.valueOf(combined.charAt(0));
      base2 = String.valueOf(combined.charAt(1));
      nonBase = String.valueOf(combined.charAt(2));
      
      if ( current.endsWith(base1 + base2) || current.endsWith(base2 + base1) ) {
        current = current.substring(0, current.length()-2);
        current = current + nonBase;
        foundCombined = true;
        break; // sigo con los otros combined ?
      }
    }
    
    if (foundCombined == false) {
      for (String opposed : opposedElements) {
        base1 = String.valueOf(opposed.charAt(0));
        base2 = String.valueOf(opposed.charAt(1));
        temp = current.substring(0, current.length() - 1);
        
        if ( current.endsWith(base1) ) {
          if (temp.contains(base2)) {
            return "";
          }
        }
        else if ( current.endsWith(base2) ) {
          if (temp.contains(base1)) {
            return "";
          }
        }
      } // for
    } // if
    return current;
  }
  

  
  private static String doMagicka(List<String> combinedElements, List<String> opposedElements, String elements) {
    if (elements == null) { 
      return elements;
    }    
    if (elements.length() < 1) { 
      return elements;
    }
    
    String current = null;
    current = elements.substring(0, 1);
    for (int i = 1; i < elements.length(); i++) {
      current = current + elements.charAt(i);
      current = invokeElements(combinedElements, opposedElements, current);  
    }
    return current;
  }
  
  private static String formatElements(String elements) {
    String s = "[";
    for (int i = 0; i < elements.length(); i++) {
      s += elements.charAt(i);
      if (i < elements.length()-1) {
        s += ", ";
      }
    }
    s += "]";
    return s;
  }
   
  /**
   * @param args
   */
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage: java " + MagickaMain.class  + " inputFile outputFile");
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
          result = formatElements(doMagicka(splitCombinedElements(line), splitOpposedElements(line), getElements(line)));
          result = "Case #" + testCasesCount + ": " + result;
          System.out.println(result + " -- Line: " + testCasesCount + ": " + line);
          out.write(result + newline);
        }
      }
      in.close();
      out.close();
      System.out.println("Finished " + testCasesCount + " test cases.");

    } //try
    catch (Exception e) {
      e.printStackTrace();
    }

  }
}
