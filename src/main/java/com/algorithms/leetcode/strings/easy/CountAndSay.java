package com.algorithms.leetcode.strings.easy;

/*-
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * @author yvenkatesh
 *
 */
public class CountAndSay {

  public static void main(String[] args) {
    System.out.println(countAndSay(5));
  }

  public static String countAndSay(int n) {
    String output = "1";
    for (int i = 2; i <= n; i++) {
      int count = 0;
      char prev = 'x';
      StringBuilder sb = new StringBuilder();

      for (char c : output.toCharArray()) {
        if (prev == 'x') {
          prev = c;
          count++;
        } else if (prev != c) {
          sb.append(count);
          sb.append(prev);
          prev = c;
          count = 1;
        } else {
          count++;
        }
      }
      sb.append(count);
      sb.append(prev);
      output = sb.toString();
    }
    return output;
  }


}
