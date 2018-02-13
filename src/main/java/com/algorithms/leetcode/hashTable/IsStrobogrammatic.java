package com.algorithms.leetcode.hashTable;

import java.util.HashSet;
import java.util.HashMap;

/**
 * P#246 
 * 
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Write a function to determine if a number is strobogrammatic. The number is
 * represented as a string.
 * 
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 * 
 * @author yvenkatesh
 *
 */
public class IsStrobogrammatic {

	public static void main(String[] args) {
		System.out.println(isStrobogrammatic("101"));
	}

	public static boolean isStrobogrammatic(String num) {
		HashSet<Integer> set = nonStrobogrammaticNumbers();
		HashMap<Integer, Integer> map = strobogrammaticNumbers();
		StringBuilder st = new StringBuilder();
		for (int i = num.length() - 1; i >= 0; i--) {
			int curr = Character.getNumericValue(num.charAt(i));
			if (set.contains(curr))
				return false;

			Integer inverseNum = map.get(curr);
			st.append(inverseNum);
		}

		return num.equals(st.toString());
	}

	public static HashSet<Integer> nonStrobogrammaticNumbers() {
		HashSet<Integer> set = new HashSet<>();
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(7);

		return set;
	}

	public static HashMap<Integer, Integer> strobogrammaticNumbers() {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		map.put(1, 1);
		map.put(6, 9);
		map.put(8, 8);
		map.put(9, 6);

		return map;
	}
}
