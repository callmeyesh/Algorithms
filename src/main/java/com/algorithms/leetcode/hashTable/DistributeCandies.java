package com.algorithms.leetcode.hashTable;

import java.util.HashSet;

/**
 * P#575
 * 
 * Given an integer array with even length, where different numbers in this
 * array represent different kinds of candies. Each number means one candy of
 * the corresponding kind. You need to distribute these candies equally in
 * number to brother and sister. Return the maximum number of kinds of candies
 * the sister could gain.
 * 
 * Example 1: Input: candies = [1,1,2,2,3,3] Output: 3
 * 
 * 
 * Explanation: There are three different kinds of candies (1, 2 and 3), and two
 * candies for each kind.
 * 
 * Optimal distribution: The sister has candies [1,2,3] and the brother has
 * candies [1,2,3], too. The sister has three different kinds of candies.
 * 
 * 
 * Example 2: Input: candies = [1,1,2,3] Output: 2
 * 
 * 
 * Explanation: For example, the sister has candies [2,3] and the brother has
 * candies [1,1]. The sister has two different kinds of candies, the brother has
 * only one kind of candies.
 * 
 * @author yvenkatesh
 *
 */
public class DistributeCandies {

	public static void main(String[] args) {
		System.out.println(distributeCandies(new int[] { 1, 2, 3, 4 }));
		System.out.println(Character.getNumericValue('1'));

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
