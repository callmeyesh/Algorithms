package com.algorithms.ctci.strings;

/**
 * Implement a method to perform basic string compression using counts of repeating characters.
 * String "aabccccaaa" would become "a2b1c4a3". If the compressed string is the same return the
 * original length.
 *
 * @author yvenkatesh
 */
public class StringCompression {

  public static void main(String[] args) {
    String s = "aabccccaaa";
    System.out.println(stringCompress(s));
  }

  /**
   * Single pass to keep track of the count. Append to string builder when the next character is
   * different.
   *
   * Complexity: O(N)
   */
  static String stringCompress(String s) {
    StringBuilder sb = new StringBuilder();
    int count = 0;

    for (int i = 0; i < s.length(); i++) {
      count++;
      if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
        sb.append(s.charAt(i));
        sb.append(count);
        count = 0;
      }
    }

    return (sb.length() < s.length()) ? sb.toString() : s;
  }

}
