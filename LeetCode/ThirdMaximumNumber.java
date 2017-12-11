import java.util.Set;
import java.util.TreeSet;

/**
 * Given a non-empty array of integers, return the third maximum number in this array. If it does
 * not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1: Input: [3, 2, 1] Output: 1
 *
 * Explanation: The third maximum is 1.
 *
 *
 * Example 2: Input: [1, 2] Output: 2
 *
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 *
 *
 * Example 3: Input: [2, 2, 3, 1] Output: 1
 *
 * Explanation: Note that the third maximum here means the third maximum distinct number. Both
 * numbers with value 2 are both considered as second maximum.
 *
 * @author yvenkatesh
 *
 */
public class ThirdMaximumNumber {

  public static void main(String[] args) {
    ThirdMaximumNumber tmn = new ThirdMaximumNumber();
    int[] nums = {3, 2, 1};
    int thirdMax = tmn.thirdMax(nums);
    System.out.println(thirdMax);
  }

  public int thirdMax(int[] nums) {
    TreeSet<Integer> max = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
      int value = nums[i];
      if (max.size() == 3 && !max.contains(value)) {
        insertIntoArray(max, value);
      } else {
        max.add(value);
      }
    }

    if (max.size() < 3) {
      return max.last();
    } else {
      return max.first();
    }
  }

  public static void insertIntoArray(Set<Integer> max, int value) {
    for (Integer i : max) {
      if (i < value) {
        max.remove(i);
        max.add(value);
        break;
      }
    }
  }

}
