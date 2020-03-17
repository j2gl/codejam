/**
 * 
 */
package org.codejam.fairwarning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;


/**
 * @author Juanjo
 *
 */
public class FairWarningMain {
  
  public static String newline = System.getProperty("line.separator");

  /**
   * Constructro
   */
  public FairWarningMain() {
    super();
  }
  
  public static String removeLeftZeros(String number) {
    String s = number.replaceAll("^0*", ""); 
    return (s.equals("") ? "0" : s);
  }
  
  /**
   * Tells if number1 is greater than number2
   * @param number1 
   * @param number2
   * @return true if number1 is greater
   */
  public static boolean isGreaterThan(String number1, String number2) {
    boolean flag = false;
    if (number1.length() > number2.length() ) 
      flag = true;
    else if (number1.length() == number2.length() ) {
      for (int i = 0; i < number1.length(); i++) {
        if (number1.charAt(i) > number2.charAt(i) ) {
          flag = true;
          break;
        }
        else if (number1.charAt(i) < number2.charAt(i) ) {
          flag = false;
          break;
        }
      } //for      
    } //else
    return flag;
  }
  
  /**
   * Tells if number1 is equal or greater than number2
   * @param number1 
   * @param number2
   * @return true if number1 is equal or greater
   */
  public static boolean isGreaterEqualThan(String number1, String number2) {
    boolean flag = false;
    if (number1.equals(number2))
      flag = true;    
    else if (number1.length() > number2.length() ) 
      flag = true;
    else if (number1.length() == number2.length() ) {
      for (int i = 0; i < number1.length(); i++) {
        if (number1.charAt(i) > number2.charAt(i) ) {
          flag = true;
          break;
        }
        else if (number1.charAt(i) < number2.charAt(i) ) {
          flag = false;
          break;
        }
      } //for      
    } //else
    return flag;
  }
  
  /**
   * Funtion for substract two Integers in String mode.  Only works for natural numbers, 
   * and the result difference will be abosule ( diff > 0)
   *
   * @param minuend Integer in string greater than 0
   * @param subtrahend Integer in string greater than 0
   * @return the abosolute difference 
   */
  public static String substract(String minuend, String subtrahend) {
    String diff = "";
    String m = removeLeftZeros(minuend.trim());
    String s = removeLeftZeros(subtrahend.trim());
    char a, b;
    boolean borrow = false;
    
    
    if (isGreaterThan(s, m) ) {
      m = s;
      s = removeLeftZeros(minuend.trim());
    }
    
    int j = s.length() - 1;
    for (int i = m.length() - 1; i >= 0; i-- ) {
      a = m.charAt(i);
      
      if (borrow) { 
        if (a == '0') 
          a = (char) ((char) a + 9);
        else {
          a = (char) (a - 1);
          borrow = false;
        }
      }
      
      if (j >= 0) {
        b = s.charAt(j);
        if (a < b) {
          a = (char) (a + 10);
          borrow = true;
        }
        diff = (a - b) + diff;
        j--;
      }
      else {
        diff = a + diff;
      }
    }
    return  removeLeftZeros(diff);
  }
  
  /**
   * Sorts teh array.
   * @param stringArray
   */
  public static void sortStringArray(String[] stringArray) {
    int l = stringArray.length;
    boolean flag = false;
    String temp = null;
    do {
      flag = false;
      for (int i = 0;  i < l - 1; i++) {
        if ( isGreaterThan(stringArray[i],  stringArray[i+1]) == true ) {
          temp = stringArray[i];
          stringArray[i] = stringArray[i+1];
          stringArray[i+1] = temp;
          flag = true;
        }
      }
      l--;
    }
    while (flag);
  }
  
  /**
   * Gets the smallest gap from a sorted array.
   * @param stringArray
   * @return 
   */
  public static String getSmallestGap(String[] stringArray) {
    int l = stringArray.length;
    String smallestGap = null;
    String diff = null;
    boolean flag = true;
    for (int i = 0; i < l-1; i++) {
      diff = substract(stringArray[i+1], stringArray[i]);
      if ( diff.equals("0") )
        continue;
      
      if (flag) {
        smallestGap = diff;
        flag = false;
      }
      else {
        if (isGreaterThan(smallestGap, diff)) {
          smallestGap = diff;
        }
      }
    }
    return smallestGap;
    
  }
  
  /**
   * @param gapTime
   * @param lastEventTime
   * @return
   */
  public static String findEvent(String gapTime, String lastEventTime) {
    String prediction = null;
    String diff = substract(lastEventTime, gapTime);
    
    if ( isGreaterEqualThan(gapTime, lastEventTime) ) {
      prediction = diff;
    }
    else {  
      while (isGreaterThan(diff, gapTime)) {
        diff = substract(diff, gapTime);
      }
      prediction = substract(diff, gapTime);
    }
    
    return prediction;
  }
  
  public static String findGreatEvent(String[] events) {
    String prediction = null;
    String smallestGap = null;
    sortStringArray(events);
    smallestGap = getSmallestGap(events);
    
    //System.out.println("Smallest gap: " + smallestGap);
    prediction = findEvent(smallestGap, events[0]);
    return prediction;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    if (args.length != 2) {
      System.out.println("Usage: java " + FairWarningMain.class  + " inputFile outputFile");
      System.exit(0);
    }
    
    BufferedReader in = null;
    FileWriter out = null;
    String line = null;
    String outLine = null;
    String events[] = null;
    int count = 0;
    int testCasesCount = 0;
    int testCase = 1;
    
    try {
      in = new BufferedReader(new FileReader(args[0]));
      out = new FileWriter(args[1]);
      
      while ( (line = in.readLine()) != null) {
        count++;
        if (count == 1) {
          testCasesCount = Integer.valueOf(line);
        }
        else if ( (count > 1) && (count <= (testCasesCount + 1))) {
          outLine = "Case #" + testCase++ + ": ";
          
          String s[] = line.split(" ");          
          events = Arrays.copyOfRange(s, 1, s.length);
          outLine = outLine + findGreatEvent(events) + newline;
                    
          System.out.print(line + " -> " + outLine);
          out.write(outLine);
          
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
