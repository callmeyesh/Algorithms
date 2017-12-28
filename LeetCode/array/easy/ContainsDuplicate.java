package array.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an array of integers, find if the array contains any duplicates. Your function should
 * return true if any value appears at least twice in the array, and it should return false if every
 * element is distinct.
 *
 * @author yvenkatesh
 *
 */
public class ContainsDuplicate {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5};
    System.out.println(sorting(nums));
    System.out.println(hashing(nums));

  }

  public static boolean sorting(int[] nums) {
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 1; ++i) {
      if (nums[i] == nums[i + 1])
        return true;
    }

    return false;
  }

  public static boolean hashing(int[] nums) {
    HashSet<Integer> numsSet = new HashSet<>(nums.length);

    for (int i = 0; i < nums.length; ++i) {
      if (numsSet.contains(nums[i]))
        return true;
      numsSet.add(nums[i]);
    }

    return false;
  }

}
