package com.algorithms.leetcode.strings.easy;

/**
 * P#125
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and
 * ignoring cases.
 *
 * For example:
 *
 * "A man, a plan, a canal: Panama" is a palindrome.
 *
 * "race a car" is not a palindrome.
 *
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 * @author yvenkatesh
 *
 */
public class IsPalindrome {

  public static void main(String[] args) {
    String s = "A man, a plan, a canal: Panama";
    System.out.println(isPalindrome(s));

  }

  public static boolean isPalindrome(String s) {
    int start = 0;
    int end = s.length() - 1;

    if (end <= start)
      return true;

    s = s.toLowerCase();

    while (start < end) {
      int first = Character.getNumericValue(s.charAt(start));
      int second = Character.getNumericValue(s.charAt(end));
      if (first == -1 || second == -1) {
        if (first == -1)
          start++;
        if (second == -1)
          end--;
      } else if (first != second) {
        return false;
      } else {
        start++;
        end--;
      }
    }

    return true;

  }

}
