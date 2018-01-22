package com.algorithms.leetcode.strings.easy;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return
 * the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World" Output: 5
 *
 * @author yvenkatesh
 *
 */
public class LengthOfLastWord {

  public static void main(String[] args) {
    String s = "Hello World";
    System.out.println(lengthOfLastWord(s));
  }

  public static int lengthOfLastWord(String s) {
    int lengthOfLastWord = 0;
    if (s.length() == 0)
      return lengthOfLastWord;

    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != ' ') {
        lengthOfLastWord = ++count;
      } else {
        count = 0;
      }
    }

    return lengthOfLastWord;
  }

}
