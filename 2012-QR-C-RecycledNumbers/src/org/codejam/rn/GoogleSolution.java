/**
 * 
 */
package org.codejam.rn;

/**
 * @author google 
 * http://code.google.com/codejam/contest/1460488/dashboard#s=a&a=2
 */
public class GoogleSolution {

  public static int solve(int A, int B) {
    int power = 1, temp = A;
    while (temp >= 10) {
        power *= 10;
        temp /= 10;
    }
    int ret = 0;
    for (int n = A; n <= B; ++n) {
        temp = n;
        while (true) {
            temp = (temp / 10) + ((temp % 10) * power);
            if (temp == n)
                break;
            if (temp > n && temp >= A && temp <= B)
                ret++;
        }
    }
    return ret;
  }
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    long time = System.currentTimeMillis();
    System.out.println("solve: " + solve(1212, 9999));
    System.out.println("solve: " + solve(12345, 99999));
    System.out.println("solve: " + solve(100000, 999999));
    System.out.println("Execution time ms.: " + (System.currentTimeMillis() - time) );
  }
  

}
