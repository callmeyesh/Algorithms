package com.algorithms.leetcode.strings.easy;

public class ValidPalindrome {

  public static void main(String[] args) {
    String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
    System.out.println(validPalindrome(s));
  }

  public static boolean validPalindrome(String s) {
    int start = 0;
    int end = s.length() - 1;
    boolean skipped = false;

    while (start < end) {
      if (s.charAt(start) == s.charAt(end)) {
        start++;
        end--;
      } else if (s.charAt(start + 1) == s.charAt(end) && !skipped) {
        start++;
        skipped = true;
      } else if (s.charAt(start) == s.charAt(end - 1) && !skipped) {
        end--;
        skipped = true;
      } else {
        return false;
      }

    }

    return true;
  }
}
