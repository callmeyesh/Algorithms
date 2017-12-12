package array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:448
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and
 * others appear once. Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does
 * not count as extra space.
 *
 * Example: Input: [4,3,2,7,8,2,3,1] Output: [5,6]
 *
 *
 * @author yvenkatesh
 *
 */
public class FindDisappearedNumbers {

  public static void main(String[] args) {
    int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

    FindDisappearedNumbers fdn = new FindDisappearedNumbers();
    System.out.println(fdn.optimalSolution(nums));
  }

  public List<Integer> optimalSolution(int[] nums) {

    List<Integer> missing = new ArrayList<Integer>();

    for (int i = 0; i < nums.length; i++) {
      int val = Math.abs(nums[i]) - 1;
      if (nums[val] > 0) {
        nums[val] = -nums[val];
      }
    }

    for (int j = 0; j < nums.length; j++) {
      if (nums[j] > 0) {
        missing.add(j + 1);
      }
    }
    return missing;
  }

  public List<Integer> myImplementation(int[] nums) {

    int index = 0;
    while (index < nums.length) {
      int currentElement = nums[index];
      if (currentElement == index + 1 || currentElement == -1) {
        index++;
        continue;
      }

      int temp = nums[currentElement - 1];
      if (temp == currentElement) {
        nums[index] = -1;
        index++;
      } else {
        nums[currentElement - 1] = currentElement;
        nums[index] = temp;
      }

    }

    List<Integer> missingNumbers = new ArrayList<Integer>();

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == -1) {
        missingNumbers.add(i + 1);
      }
    }
    return missingNumbers;
  }

}
