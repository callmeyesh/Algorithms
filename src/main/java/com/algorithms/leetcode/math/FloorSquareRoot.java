package com.algorithms.leetcode.math;

/**
 * Find the floor value of square root of n.
 * https://www.geeksforgeeks.org/square-root-of-an-integer/
 * 
 * @author yvenkatesh
 *
 */
public class FloorSquareRoot {

  public static void main(String[] args) {
    System.out.println(floorSqrt(2147395599));
  }

  public static int floorSqrt(int n) {
    if (n == 0 || n == 1)
      return n;

    int start = 0;
    int end = n;
    int ans = 0;

    // We use n/mid instead of mid * mid to deal with integer overflow
    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (mid == n / mid) {
        return mid;
      } else if (mid < n / mid) {
        start = mid + 1;
        ans = mid;
      } else {
        end = mid - 1;
      }
    }

    return ans;
  }

}
