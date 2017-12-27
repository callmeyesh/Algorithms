package array.easy;

import java.util.Collections;
import java.util.HashMap;

public class DegreeOfAnArray {

  public static void main(String[] args) {
    DegreeOfAnArray deg = new DegreeOfAnArray();
    int[] nums = {1, 2, 2, 3, 1};
    int result = deg.findShortestSubArray(nums);
    System.out.println(result);
  }

  public int findShortestSubArray(int[] nums) {
    HashMap<Integer, Integer> counts = new HashMap(), left = new HashMap(), right = new HashMap();
    int result = nums.length;

    for (int i = 0; i < nums.length; i++) {
      int x = nums[i];
      if (!left.containsKey(x))
        left.put(x, i);
      right.put(x, i);
      counts.put(x, counts.getOrDefault(x, 0) + 1);
    }

    int degree = Collections.max(counts.values());
    for (Integer x : counts.keySet()) {
      if (degree == counts.get(x)) {
        result = Math.min(result, right.get(x) - left.get(x) + 1);
      }
    }
    return result;
  }
}
