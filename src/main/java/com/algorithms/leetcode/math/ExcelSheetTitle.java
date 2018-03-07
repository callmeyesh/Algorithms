package com.algorithms.leetcode.math;

/**
 * P #171 Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * P #168 Given a positive integer, return its corresponding column title as appear in an Excel
 * sheet.
 * 
 * @author yvenkatesh
 */
public class ExcelSheetTitle {

  public static void main(String[] args) {
    System.out.println(convertToTitle(26));
    System.out.println(titleToNumber("A"));
  }

  public static String convertToTitle(int num) {
    StringBuilder sb = new StringBuilder();
    while (num > 0) {
      num--;
      sb.append(getAlphabet(num % 26));
      num /= 26;
    }
    sb.reverse();
    return sb.toString();
  }

  public static char getAlphabet(int value) {
    return (char) (value + 'A');
  }

  public static int titleToNumber(String s) {
    int result = 0;
    for (char c : s.toCharArray()) {
      result = result * 26 + ((int) c - 'A' + 1);
    }
    return result;
  }

}
