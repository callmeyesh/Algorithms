package com.algorithms.leetcode.math;

/**
 * P# 415
 * 
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and
 * num2.
 * 
 * @author yvenkatesh
 *
 */
public class AddStrings {

  public static void main(String[] args) {
    System.out.println(addStrings("999", "1111"));
  }

  public static String addStrings(String num1, String num2) {
    StringBuilder sb = new StringBuilder();
    int i = num1.length() - 1;
    int j = num2.length() - 1;
    int carry = 0;

    while (i >= 0 || j >= 0) {
      int n1 = (i < 0) ? 0 : Character.getNumericValue(num1.charAt(i--));
      int n2 = (j < 0) ? 0 : Character.getNumericValue(num2.charAt(j--));
      int total = (n1 + n2 + carry);
      sb.insert(0, total % 10);
      carry = total / 10;
    }

    if (carry > 0)
      sb.insert(0, carry);

    return sb.toString();
  }

}
