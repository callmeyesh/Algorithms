package com.algorithms.leetcode.hashTable;

import java.util.HashSet;

public class DistributeCandies {

	public static void main(String[] args) {
		System.out.println(distributeCandies(new int[] { 1, 2, 3, 4 }));

	}

	public static int distributeCandies(int[] candies) {
		HashSet<Integer> set = new HashSet<>();
		int index = 0, count = 0;
		int length = candies.length;

		while (count < length / 2 && index < length) {
			int candy = candies[index++];
			if (!set.contains(candy)) {
				set.add(candy);
				count++;
			}
		}

		return set.size();

	}

}
