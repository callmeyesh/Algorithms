package com.algorithms.leetcode.strings.easy;

/**
 * P#345
 *
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1: Given s = "hello", return "holle".
 *
 * Example 2: Given s = "leetcode", return "leotcede".
 *
 * Note: The vowels does not include the letter "y".
 *
 * @author yvenkatesh
 *
 */
public class ReverseVowels {

  public static void main(String[] args) {
    String s = "hello";
    System.out.println(reverseVowels(s));
  }

  public static String reverseVowels(String s) {

    if (s.length() == 0)
      return s;

    char[] charSet = s.toCharArray();
    int start = 0;
    int end = charSet.length - 1;

    while (start < end) {
      char first = charSet[start];
      char second = charSet[end];

      if (isVowel(first) && isVowel(second)) {
        swapCharacters(charSet, start, end);
        start++;
        end--;
      } else if (isVowel(first)) {
        end--;
      } else if (isVowel(second)) {
        start++;
      } else {
        start++;
        end--;
      }
    }

    return new String(charSet);

  }

  public static boolean isVowel(char c) {
    switch (c) {
      case 'a':
      case 'e':
      case 'i':
      case 'o':
      case 'u':
      case 'A':
      case 'E':
      case 'I':
      case 'O':
      case 'U':
        return true;
    }
    return false;
  }

  public static void swapCharacters(char[] charSet, int start, int end) {
    char temp = charSet[start];
    charSet[start] = charSet[end];
    charSet[end] = temp;
  }

}
