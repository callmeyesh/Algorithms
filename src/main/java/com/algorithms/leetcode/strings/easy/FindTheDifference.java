package com.algorithms.leetcode.strings.easy;

/**
 * Find the extra character in string 2.
 *
 * @author yvenkatesh
 */
public class FindTheDifference {

  public static void main(String[] args) {
    System.out.println(findTheDifference("abcd", "abcde"));
  }

  public static char findTheDifference(String s, String t) {
    int[] charCount = new int[26];

    for (char i : s.toCharArray())
      charCount[i - 'a'] = charCount[i - 'a'] + 1;

    for (char j : t.toCharArray()) {
      if (charCount[j - 'a'] == 0)
        return j;
    }

    return ' ';
  }

}
