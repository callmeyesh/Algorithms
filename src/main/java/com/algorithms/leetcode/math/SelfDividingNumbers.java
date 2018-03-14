package com.algorithms.leetcode.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelfDividingNumbers {

  public static void main(String[] args) {
    List<Integer> output = selfDividingNumbers(66, 708);
    System.out.println(Arrays.toString(output.toArray()));
  }

  public static List<Integer> selfDividingNumbers(int lower, int upper) {
    ArrayList<Integer> output = new ArrayList<>();
    for (int i = lower; i <= upper; i++) {
      if (i % 10 == 0)
        continue;

      if (i < 10 || isSelfDividing(i))
        output.add(i);
    }

    return output;
  }

  public static boolean isSelfDividing(int num) {
    int copy = num;

    while (copy > 0) {
      int i = copy % 10;
      if (i == 0 || (num % i) != 0)
        return false;
      copy /= 10;
    }

    return true;
  }

}
