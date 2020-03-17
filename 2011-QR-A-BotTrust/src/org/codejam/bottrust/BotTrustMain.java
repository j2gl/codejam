/**
 * 
 */
package org.codejam.bottrust;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Queue;


/**
 * @author Juanjo
 *
 */
public class BotTrustMain {
  
  public static String newline = System.getProperty("line.separator");

  /**
   * Costructor
   */
  public BotTrustMain() {
    super();
  }
  
  
  /**
   * Calculates time that takes to move to one position.
   * 
   * @param actualPosition old position
   * @param target the new position 
   * @return the time that takes.
   */
  private static int calculateTime(int actualPosition, String target) {
    int targetPosition = 0;
    int time = 0;
    if (target != null) {
      targetPosition = Integer.valueOf(target.substring(1, target.length()));
      time = Math.abs(actualPosition - targetPosition);
    }
    return time;

    
  }

  
  
  /**
   * Calculates the new position.
   * @param position
   * @return
   */
  private static int calculateNewPosition(int actualPosition, String targetPositionStr, int delta) {
    
    int targetPosition = 0;
    int newPos = 0;
    if (targetPositionStr != null)
      targetPosition =  Integer.valueOf(targetPositionStr.substring(1, targetPositionStr.length()));
    else 
      newPos = actualPosition;
    
    if (actualPosition == targetPosition ) {
      newPos = actualPosition;
    }
    else if (actualPosition < targetPosition) {
      if (Math.abs(actualPosition - targetPosition) > delta) {
        newPos = actualPosition + delta;
      }
      else {
        newPos = targetPosition;
      }
    }
    else if (actualPosition > targetPosition) {
      if (Math.abs(actualPosition - targetPosition) > delta) {
        newPos = actualPosition - delta;
      }
      else {
        newPos = targetPosition;
      }
    }
    return newPos;
  }


  private static int pushButtons(String line) {
    
    Queue<String> blueStack = new LinkedList<String>();
    Queue<String> orangeStack = new LinkedList<String>();
    Queue<String> buttonsStack = new LinkedList<String>();
    
    boolean isWorking = true;
    int totalButtons = 0;
    String s = null;
    String split[] = null;
    
    String primaryRobotTarget = null;
    String secondaryRobotTarget = null;
    
      
    // Time Variable
    int time = 0;    
    int orangePos = 1;
    int bluePos = 1;
    int delta = 0;
    

    
    
    split = line.split(" ");
    totalButtons = Integer.valueOf(split[0]);
    for (int i = 0; i < totalButtons; i++) {
      s = split[ 2*i+1 ].toUpperCase() + split[ 2*i+2 ];

      buttonsStack.add(s);
      if ( s.startsWith("O") ) {
        orangeStack.add(s);
      }        
      else { 
        blueStack.add(s);
      }
    }
    
    
    time = 0;    
    while (isWorking) {
      
      if (buttonsStack.isEmpty()) {
        isWorking = false;
      }
      else {
        //Take target next button
        primaryRobotTarget = buttonsStack.poll();
        if (primaryRobotTarget.startsWith("O")) { // if starts with Orange
          secondaryRobotTarget = blueStack.peek();
          orangeStack.poll();
          
          delta = calculateTime(orangePos, primaryRobotTarget);
          orangePos = calculateNewPosition(orangePos, primaryRobotTarget, delta);
          
          delta++;
          time = time + delta;          
          bluePos = calculateNewPosition(bluePos, secondaryRobotTarget, delta);
        }
        else { // if starts with Blue
          secondaryRobotTarget = orangeStack.peek();
          blueStack.poll();
          
          delta = calculateTime(bluePos, primaryRobotTarget);          
          bluePos = calculateNewPosition(bluePos, primaryRobotTarget, delta);
          
          delta++;
          time = time + delta;
          orangePos = calculateNewPosition(orangePos, secondaryRobotTarget, delta);
        }
      }
    }
    
    return time;
    
  }
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    
    if (args.length != 2) {
      System.out.println("Usage: java " + BotTrustMain.class  + " inputFile outputFile");
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
          System.out.println("File # of test cases: " + testCasesTotal + ".");
        } //if
        else {
          testCasesCount++;
          result = "Case #" + testCasesCount + ": " + pushButtons(line);
          System.out.println(result + " -- Line: " + testCasesCount + ": " + line);
          out.write(result + newline);
        }
      }
      in.close();
      out.close();
      System.out.println("Finished " + testCasesCount + ".");

    } //try
    catch (Exception e) {
      e.printStackTrace();
    }

  }

}
