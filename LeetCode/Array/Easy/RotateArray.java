package Array.Easy;

import java.util.Arrays;

/**
 * Rotate an array of n elements to the right by k steps. For example, with n = 7 and k = 3, the
 * array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 * @author yvenkatesh
 *
 */
public class RotateArray {

  public static void main(String[] args) {
    RotateArray ra = new RotateArray();

    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    int k = 3;
    ra.rotate(nums, k);
    System.out.println(Arrays.toString(nums));
  }

  public void rotate(int[] nums, int k) {

    if (nums == null) {
      throw new IllegalArgumentException("Input array is empty.");
    }

    int[] output = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int value = nums[i];
      output[(i + k) % nums.length] = value;
    }

    for (int j = 0; j < nums.length; j++) {
      nums[j] = output[j];
    }

  }
}
