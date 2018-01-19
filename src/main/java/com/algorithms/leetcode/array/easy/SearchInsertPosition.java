package com.algorithms.leetcode.array.easy;

/*-
 * Problem: #35
 *
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *      Input: [1,3,5,6], 5
 *      Output: 2
 *
 * Example 2:
 *      Input: [1,3,5,6], 2
 *      Output: 1
 *
 * Example 3:
 *      Input: [1,3,5,6], 7
 *      Output: 4
 *
 * Example 1:
 *      Input: [1,3,5,6], 0
 *      Output: 0
 *
 * @author yvenkatesh
 *
 */
public class SearchInsertPosition {

  public static void main(String[] args) {
    int[] nums = {1, 3, 5, 6};
    int target = 7;
    System.out.println(binarySearch(nums, target));

  }

  /**
   * Complexity: Time: O(N) Space: O(1)
   */
  public static int searchInsert(int[] nums, int target) {
    int index = 0;
    for (int num : nums) {
      if (num >= target)
        return index;
      index++;
    }
    return index;
  }

  /**
   * Complexity: Time: O(LogN) Space: O(1)
   */
  public static int binarySearch(int[] nums, int target) {
    int low = 0;
    int high = nums.length;

    while (low < high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target)
        return mid;
      if (nums[mid] >= target) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }

    return low;

  }
}
