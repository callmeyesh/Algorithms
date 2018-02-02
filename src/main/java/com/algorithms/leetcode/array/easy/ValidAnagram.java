package com.algorithms.leetcode.array.easy;

/**
 * P#242
 *
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 *
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car", return false.
 *
 * Note: You may assume the string contains only lowercase alphabets.
 *
 * @author yvenkatesh
 *
 */
public class ValidAnagram {

  public static void main(String[] args) {
    String s = "anagram";
    String t = "nagaram";
    System.out.println(isAnagram(s, t));
  }

  /**
   * Using a character array since only lower case alphabets are allowed.
   *
   * Complexity is O(N)
   */
  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length())
      return false;

    int[] charCount = new int[26];

    for (char inputChar : s.toCharArray())
      charCount[inputChar - 'a']++;

    for (char patternChar : t.toCharArray())
      charCount[patternChar - 'a']--;

    for (int i : charCount) {
      if (i != 0)
        return false;
    }

    return true;
  }
}
