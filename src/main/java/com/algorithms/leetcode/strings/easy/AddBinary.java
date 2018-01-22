package com.algorithms.leetcode.strings.easy;

/*-
 * P#67
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * For example,
 *
 * a = "11"
 * b = "1"
 * Return "100".
 *
 * @author yvenkatesh
 */
public class AddBinary {

  public static void main(String[] args) {
    String a = "11";
    String b = "";
    System.out.println(addBinary(a, b));
  }

  public static String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    int i = a.length() - 1;
    int j = b.length() - 1;
    while (i >= 0 || j >= 0 || carry == 1) {
      carry += (i >= 0) ? Character.getNumericValue(a.charAt(i--)) : 0;
      carry += (j >= 0) ? Character.getNumericValue(b.charAt(j--)) : 0;
      sb.insert(0, carry % 2);
      carry = carry >> 1;
    }

    return sb.toString();
  }

}
