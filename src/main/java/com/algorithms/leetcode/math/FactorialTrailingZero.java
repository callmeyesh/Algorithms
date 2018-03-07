package com.algorithms.leetcode.math;

/**
 * P #172
 * 
 * Given an integer n, return the number of trailing zeroes in n!. Note: Your solution should be in
 * logarithmic time complexity.
 * 
 * @author yvenkatesh
 */
public class FactorialTrailingZero {

  public static void main(String[] args) {
    System.out.println(trailingZero1(10));
  }

  /**
   * Because all trailing 0 is from factors 5 * 2.
   * 
   * But sometimes one number may have several 5 factors, for example, 25 have two 5 factors, 125
   * have three 5 factors. In the n! operation, factors 2 is always ample. So we just count how many
   * 5 factors in all number from 1 to n.
   * 
   * @param num
   * @return
   */
  public static int trailingZero1(int num) {
    int result = 0;

    while (num > 0) {
      num = num / 5;
      result += num;
    }

    return result;
  }

  /**
   * 10 is the product of 2 and 5. In n!, we need to know how many 2 and 5, and the number of zeros
   * is the minimum of the number of 2 and the number of 5. Since multiple of 2 is more than
   * multiple of 5, the number of zeros is dominant by the number of 5.
   * 
   * return n/5 + n/25 + n/125 + n/625 + n/3125+...;
   * 
   * @param num
   * @return
   */
  public static int trailingZero2(int num) {
    return num == 0 ? 0 : num / 5 + trailingZero2(num / 5);
  }

}
