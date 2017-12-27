package array.easy;

import java.util.Arrays;

public class TwoSum2 {

  public static void main(String[] args) {
    int[] nums = { 2, 3, 4 };
    int target = 6;
    TwoSum2 klass = new TwoSum2();
    int[] output = klass.twoSum(nums, target);
    System.out.println(Arrays.toString(output));

  }

  public int[] twoSum(int[] numbers, int target) {

    int firstIndex = 0;
    int lastIndex = numbers.length - 1;
    int[] index = {0, 0};
    while (firstIndex >= 0 && lastIndex <= numbers.length - 1 && firstIndex < lastIndex) {

      int current = numbers[firstIndex] + numbers[lastIndex];
      if (current == target) {
        index[0] = firstIndex + 1;
        index[1] = lastIndex + 1;
        break;
      } else if (current > target) {
        lastIndex--;
      } else {
        firstIndex++;
      }
    }

    return index;
  }

}
