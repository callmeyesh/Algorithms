package com.algorithms.leetcode.array.easy;

/*-
 * Problem: #169
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * @author yvenkatesh
 *
 */
public class MajorityElement {

  public static void main(String[] args) {
    MajorityElement me = new MajorityElement();
    int[] nums = {1, 3, 3, 3, 2, 2};
    System.out.println(me.majorElement(nums));
  }

  /**
   * O(N) Solution. Since major element always exist, we keep incrementing and decrementing the
   * count. At the end of the loop we will have one major element.
   */
  public int majorElement(int[] nums) {

    int count = 0, major = 0;
    for (int i = 0; i < nums.length; i++) {
      if (count == 0) {
        count++;
        major = nums[i];
      } else if (major == nums[i]) {
        count++;
      } else {
        count--;
      }
    }

    return major;
  }

}
