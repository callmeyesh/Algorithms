package com.algorithms.leetcode.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*-
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target. You may assume that each input would have
 * exactly one solution, and you may not use the same element twice.
 *
 * Given nums = [2, 7, 11, 15], target = 9, Because nums[0] + nums[1] = 2 + 7 =
 * 9, return [0, 1].
 *
 * @author Yeshwanth
 *
 */
public class TwoSum {

  public static void main(String[] args) {
    int[] nums = {3, 2, 4};
    int target = 6;
    TwoSum klass = new TwoSum();
    int[] output = klass.twoSum(nums, target);
    System.out.println(Arrays.toString(output));
  }

  public int[] twoSum(int[] nums, int target) {
    int[] output = new int[2];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        output[0] = map.get(target - nums[i]);
        output[1] = i;
        return output;
      }
      map.put(nums[i], i);
    }
    return output;
  }

}
