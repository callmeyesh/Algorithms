package com.algorithms.ctci.strings;

import java.util.Arrays;

/**
 * Check if the two strings are permutation of each other.
 *
 * @author yvenkatesh
 *
 */
public class IsPermutation {

  public static void main(String[] args) {
    String s = "god";
    String t = "dog";
    System.out.println(usingCharFrequency(s, t));
    System.out.println(usingSorting(s, t));

  }

  /*-
   * If the two strings are not equal they cannot be permutations of each other. Sort the strings
   * and check if they are equal.
   *
   * Complexity: O(sLogs + tLogt)
   */
  public static boolean usingSorting(String s, String t) {
    if (s.length() != t.length())
      return false;

    return sort(s).equals(sort(t));
  }

  public static String sort(String s) {
    char[] c = s.toCharArray();
    Arrays.sort(c);
    return new String(c);
  }

  /*-
   *
   * We are using array as a HashMap to keep track of the character frequency. We then subtract the
   * frequency by looping over the second string. If the count goes below zero we have encountered
   * an extra character.
   *
   * Complexity: O(s + t)
   * Space: O(1)
   */
  public static boolean usingCharFrequency(String s, String t) {
    if (s.length() != t.length())
      return false;

    // Assuming the character set is ASCII
    int[] charFreq = new int[128];

    for (int i = 0; i < s.length(); i++)
      charFreq[s.charAt(i)]++;

    for (int j = 0; j < t.length(); j++) {
      charFreq[t.charAt(j)]--;
      if (charFreq[t.charAt(j)] < 0)
        return false;
    }

    return true;
  }

}
