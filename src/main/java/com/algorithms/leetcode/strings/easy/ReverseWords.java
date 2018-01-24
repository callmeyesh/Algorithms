package com.algorithms.leetcode.strings.easy;

import java.util.ArrayList;

/**
 *
 * Given a string, you need to reverse the order of characters in each word within a sentence while
 * still preserving whitespace and initial word order.
 *
 * Example 1: Input: "Let's take LeetCode contest"
 *
 * Output: "s'teL ekat edoCteeL tsetnoc" Note: In
 *
 * the string, each word is separated by single space and there will not be any extra space in the
 * string.
 *
 * @author yvenkatesh
 *
 */
public class ReverseWords {

  public static void main(String[] args) {
    String s = "Let's take LeetCode contest";
    System.out.println(reverseWord(s));
  }

  public static String reverseWord(String s) {
    // Can be replaced by s.split(" ");
    ArrayList<String> words = split(s);
    StringBuilder sb = new StringBuilder();
    for (String word : words) {
      // Reverse can be replaced by new StringBuilder(word).reverse();
      sb.append(reverse(word) + " ");
    }
    return sb.toString().trim();
  }

  public static ArrayList<String> split(String s) {
    ArrayList<String> words = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c == ' ') {
        words.add(sb.toString());
        sb = new StringBuilder();
      } else {
        sb.append(c);
      }
    }
    words.add(sb.toString());
    return words;
  }

  public static String reverse(String word) {
    StringBuilder sb = new StringBuilder();
    for (int i = word.length() - 1; i >= 0; i--)
      sb.append(word.charAt(i));

    return sb.toString();

  }
}
