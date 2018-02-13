package com.algorithms.leetcode.hashTable;

import java.util.Arrays;
import java.util.HashSet;

/**
 * P #720
 * Given a list of strings words representing an English Dictionary, find the
 * longest word in words that can be built one character at a time by other
 * words in words. If there is more than one possible answer, return the longest
 * word with the smallest lexicographical order.
 * 
 * If there is no answer, return the empty string.
 * 
 * Example 1:
 * 
 * Input: words = ["w","wo","wor","worl", "world"]
 * 
 * Output: "world"
 * 
 * Explanation: The word "world" can be built one character at a time by "w",
 * "wo", "wor", and "worl".
 * 
 * 
 * Example 2:
 * 
 * Input: words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 
 * Output: "apple"
 * 
 * Explanation: Both "apply" and "apple" can be built from other words in the
 * dictionary. However, "apple" is lexicographical
 * 
 * @author yvenkatesh
 *
 */
public class LongestWord {

	public static void main(String[] args) {
		String[] words = { "yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz",
				"y" };
		System.out.println(longestWord(words));
	}

	public static String longestWord(String[] words) {
		Arrays.sort(words);
		String result = "";
		HashSet<String> dict = new HashSet<>();

		for (String word : words) {
			if (canBeConstructed(word, dict)) {
				if (word.length() > result.length()) {
					result = word;
				} else if (word.length() == result.length()) {
					result = (word.compareTo(result) <= 0) ? word : result;
				}
				dict.add(word);
			} else {
				dict.add(word);
			}
		}

		return result;
	}

	public static boolean canBeConstructed(String word, HashSet<String> dict) {
		for (int i = 1; i < word.length(); i++) {
			String sub = word.substring(0, i);
			if (!dict.contains(sub))
				return false;
		}
		return true;
	}
}
