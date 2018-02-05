package com.algorithms.leetcode.hashTable;

import java.util.HashMap;
import java.util.Objects;

/*-
 * P#290
 * Given a `pattern` and a string `str`, find if `str` follows the same `pattern`.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a
 * non-empty word in str.
 *
 * EXAMPLES:
 *  pattern = "abba", str = "dog cat cat dog" should return true.
 *  pattern = "abba", str = "dog cat cat fish" should return false.
 *  pattern = "aaaa", str = "dog cat cat dog" should return false.
 *  pattern = "abba", str = "dog dog dog dog" should return false.
 *
 *  Notes: You may assume pattern contains only lowercase letters, and str contains
 *  lowercase letters separated by a single space.
 *
 * @author yvenkatesh
 */
public class WordPattern {

  public static void main(String[] args) {
    String str = "dog dog dog dog";
    String pattern = "aaaa";
    System.out.println(wordPattern(str, pattern));
  }

  public static boolean wordPattern(String str, String pattern) {
    String[] strArr = str.split(" ");
    if (strArr.length != pattern.length())
      return false;

    HashMap<String, Integer> sIndex = new HashMap<>();
    HashMap<Character, Integer> cIndex = new HashMap<>();

    for (int i = 0; i < strArr.length; i++) {
      Integer x = sIndex.put(strArr[i], i);
      Integer y = cIndex.put(pattern.charAt(i), i);
      if (!Objects.equals(x, y))
        return false;
    }

    return true;
  }

}
