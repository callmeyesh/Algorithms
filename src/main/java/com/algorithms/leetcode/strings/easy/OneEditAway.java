package com.algorithms.leetcode.strings.easy;

/**
 * Problem: #161
 *
 * Given two strings S and T, determine if they are both one edit distance apart.
 *
 * @author yvenkatesh
 */
public class OneEditAway {

  public static void main(String[] args) {
    String s = "ple";
    String t = "pale";
    System.out.println(oneEdit(s, t));
  }

  /**
   * Complexity: O(N)
   */
  static boolean oneEdit(String s, String t) {
    if (Math.abs(s.length() - t.length()) > 1)
      return false;

    if (s.length() == t.length()) {
      return oneEditReplace(s, t);
    } else if (s.length() < t.length()) {
      return insertOrReplace(s, t);
    } else {
      return insertOrReplace(t, s);
    }
  }

  static boolean oneEditReplace(String s, String t) {
    boolean foundReplacement = false;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != t.charAt(i)) {
        if (foundReplacement)
          return false;
        foundReplacement = true;
      }
    }

    return foundReplacement;
  }

  static boolean insertOrReplace(String small, String big) {
    int index1 = 0, index2 = 0, count = 0;

    while (index1 < small.length() && index2 < big.length()) {
      if (small.charAt(index1) != big.charAt(index2)) {
        count++;
        if (count > 1)
          return false;
        index2++;
      } else {
        index1++;
        index2++;
      }
    }

    while (index2 < big.length()) {
      count++;
      index2++;
    }

    return count <= 1;
  }

}
