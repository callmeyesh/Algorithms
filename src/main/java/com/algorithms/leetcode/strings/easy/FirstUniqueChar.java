package com.algorithms.leetcode.strings.easy;

/**
 * P#387
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't
 * exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode" return 0.
 *
 * s = "loveleetcode", return 2.
 *
 * Note: You may assume the string contain only lowercase letters.
 *
 * @author yvenkatesh
 *
 */
public class FirstUniqueChar {

  public static void main(String[] args) {
    String s = "leetcode";
    String s1 = "loveleetcode";
    System.out.println(firstUniqChar(s));
    System.out.println(firstUniqChar(s1));
  }

  public static int firstUniqChar(String s) {
    if (s.length() == 0)
      return -1;
    int[] charSet = new int[26];
    getCharCount(s, charSet);

    for (int i = 0; i < s.length(); i++) {
      if (charSet[s.charAt(i) - 'a'] == 1)
        return i;
    }

    return -1;
  }

  public static void getCharCount(String s, int[] charSet) {
    for (char c : s.toCharArray())
      charSet[c - 'a']++;
  }

}
