package com.algorithms.leetcode.array.easy;

/*-
 * Problem: #717
 *
 * We have two special characters. The first character can be represented by one bit 0.
 * The second character can be represented by two bits (10 or 11).
 * Now given a string represented by several bits.
 * Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
 *
 * Example 1:
 * 		Input: bits = [1, 0, 0]
 * 		Output: True
 * Explanation: The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
 *
 * Example 2:
 * 		Input: bits = [1, 1, 1, 0]
 * 		Output: False
 * Explanation: The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
 *
 * @author Yeshwanth
 */
public class IsOneBitCharacter {

	public static void main(String[] args) {
		int[] bits = { 1, 1, 0, 0 };
		IsOneBitCharacter iob = new IsOneBitCharacter();
		boolean result = iob.optimalSolution(bits);
		System.out.println(result);

	}

	public boolean optimalSolution(int[] bits) {
		int length = bits.length, i = 0;
		while (i < length - 1) {
			if (bits[i] == 0)
				i++;
			else
				i = i + 2;
		}
		return i == length - 1;
	}

}
