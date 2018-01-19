package com.algorithms.leetcode.array.easy;

import java.util.Arrays;

/*-
 * Problem: #628
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 *
 * Example 1:
 *  Input: [1,2,3]
 *  Output: 6
 *
 * Example 2:
 *  Input: [1,2,3,4]
 *  Output: 24
 *
 * Note:
 *  The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 *  Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 *
 * @author yvenkatesh
 *
 */
public class MaxProductOfThreeNumbers {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    System.out.println(sorting(nums));
    System.out.println(singleScan(nums));

  }

  public static int sorting(int[] nums) {
    int length = nums.length;
    Arrays.sort(nums);

    return Math.max(nums[0] * nums[1] * nums[length - 1],
        nums[length - 1] * nums[length - 2] * nums[length - 3]);

  }

  public static int singleScan(int[] nums) {
    int min1, min2, max1, max2, max3;
    min1 = min2 = Integer.MAX_VALUE;
    max1 = max2 = max3 = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
      int val = nums[i];

      if (val <= min1) {
        min2 = min1;
        min1 = val;
      } else if (val <= min2) {
        min2 = val;
      }

      if (val >= max1) {
        max3 = max2;
        max2 = max1;
        max1 = val;
      } else if (val >= max2) {
        max3 = max2;
        max2 = val;
      } else if (val >= max3) {
        max3 = val;
      }
    }

    return Math.max(max1 * max2 * max3, max1 * min1 * min2);
  }

}
