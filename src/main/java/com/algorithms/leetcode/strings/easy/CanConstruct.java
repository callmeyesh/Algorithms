package com.algorithms.leetcode.strings.easy;

/**
 * P#383
 *
 * Given an arbitrary ransom note string and another string containing letters from all the
 * magazines, write a function that will return true if the ransom note can be constructed from the
 * magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note: You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 *
 * canConstruct("aa", "ab") -> false
 *
 * canConstruct("aa", "aab") ->true
 *
 * @author yvenkatesh
 *
 */
public class CanConstruct {

  public static void main(String[] args) {
    String ransomNote = "a";
    String magazine = "b";
    System.out.println(canConstruct(ransomNote, magazine));
  }

  public static boolean canConstruct(String ransomNote, String magazine) {
    if (ransomNote.length() == 0)
      return true;

    int[] charSet = new int[26];
    getCharCount(magazine, charSet);

    for (char n : ransomNote.toCharArray()) {
      if (charSet[n - 'a'] == 0) {
        return false;
      } else {
        charSet[n - 'a']--;
      }
    }

    return true;
  }

  public static void getCharCount(String magazine, int[] charSet) {
    for (char m : magazine.toCharArray())
      charSet[m - 'a']++;
  }
}
