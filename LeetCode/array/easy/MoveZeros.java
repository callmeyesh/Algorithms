package array.easy;

/*-
 * Problem #283
 * 
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note:
 *		You must do this in-place without making a copy of the array.
 * Minimize the total number of operations. 
 * @author Yeshwanth
 *
 */
public class MoveZeros {

	public static void main(String[] args) {
		MoveZeros mz = new MoveZeros();
		int[] nums = { 0, 1, 0, 3, 12 };
		mz.optimalSolution(nums);

	}

	public void optimalSolution(int[] nums) {
		if (nums.length == 0)
			return;
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				j++;
			}
		}

	}

}
