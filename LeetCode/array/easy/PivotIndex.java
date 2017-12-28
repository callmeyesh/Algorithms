package array.easy;

/*-
 *
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 * We define the pivot index as the index where the sum of the numbers to the left of the index
 * is equal to the sum of the numbers to the right of the index.
 *
 * If no such index exists, we should return -1. If there are multiple pivot indexes,
 * you should return the left-most pivot index.
 *
 * Input: nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 *
 * Explanation:
 *  The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 *  Also, 3 is the first index where this occurs.
 *
 * @author yvenkatesh
 */
public class PivotIndex {

  public static void main(String[] args) {
    int nums[] = {1, 7, 3, 6, 5, 6};
    int nums2[] = {-1, -1, 0, 1, 1, 1};
    System.out.println(pivotIndex(nums));
    System.out.println(pivotIndex(nums2));
  }

  /**
   * At the pivot index the left sum and the right sum will be same. We calculate the total sum of
   * the array first.
   *
   * We keep a running count of left sum and for each index we calculate the right sum. Where right
   * sum = total - left - current_element.
   *
   * If right and left sum are identical we return.
   *
   * Complexity: Time = O(N) Space = O(1)
   */
  public static int pivotIndex(int[] nums) {
    int result = -1;

    if (nums.length <= 2)
      return result;

    int total, left;
    total = left = 0;

    for (int num : nums)
      total += num;

    for (int i = 0; i < nums.length; i++) {
      int right = total - left - nums[i];
      if (left == right)
        return i;

      left += nums[i];
    }

    return result;
  }

}
