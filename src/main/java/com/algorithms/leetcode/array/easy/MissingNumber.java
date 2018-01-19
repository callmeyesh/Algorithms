package com.algorithms.leetcode.array.easy;

/*-
 * Problem: #268
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n.
 * Find the one that is missing from the array.
 *
 * Example 1
 *      Input: [3,0,1]
 *      Output: 2
 *
 * Example 2
 *      Input: [9,6,4,2,3,5,7,0,1]
 *      Output: 8
 *
 * @author yvenkatesh
 */
public class MissingNumber {

  public static void main(String[] args) {
    int[] nums = {3, 0, 1};
    System.out.println(missingNumber(nums));
    System.out.println(usingXOR(nums));
  }

  /**
   * Using Gauss formula which is: Total sum of number from 0 to 1 = (n * (n+1))/2. We can calculate
   * what the actual total sum would be and then subtract it with the real sum.
   */
  public static int missingNumber(int[] nums) {
    int length = nums.length;
    int actualSum = length * (length + 1) / 2;
    int sum = 0;
    for (int n : nums)
      sum += n;

    return actualSum - sum;
  }

  /*-
   * We are missing one number in the range of [0..n-1] and there are
   * n numbers.
   *
   * Since we know that n is definitely replacing the missing number.
   * Therefore initializing a variable to n and XORing all the index
   * and value, we will be left with the missing number.
   *
   * Example:
   *    Array: [0,1,3]
   *    Index: [0,1,2]
   *
   *    => 3 ^ (0 ^ 0) ^ (1 ^ 1) ^ (2 ^ 3)
   *    => (0 ^ 0) ^ (1 ^ 1) ^ (3 ^ 3) ^ 2
   *    => 2
   */
  public static int usingXOR(int[] nums) {
    int missing = nums.length;
    for (int i = 0; i < nums.length; i++)
      missing ^= nums[i] ^ i;

    return missing;
  }

}
