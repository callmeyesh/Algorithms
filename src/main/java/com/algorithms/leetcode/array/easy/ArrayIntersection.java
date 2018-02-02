package com.algorithms.leetcode.array.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * P#349 Given two arrays, write a function to compute their intersection.
 *
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 *
 * @author yvenkatesh
 *
 */
public class ArrayIntersection {

  public static void main(String[] args) {
    int[] arr1 = {1, 2, 3, 4};
    int[] arr2 = {2, 4};
    System.out.println(Arrays.toString(usingBinarySearch(arr1, arr2)));
  }

  /**
   * Using hash set.
   *
   * Complexity = O (N + M) Space = O(N)
   */
  public static int[] usingHashSet(int[] arr1, int[] arr2) {
    Set<Integer> arr1Set = new HashSet<>();
    Set<Integer> intersection = new HashSet<>();

    for (int i : arr1)
      arr1Set.add(i);

    for (int j : arr2) {
      if (arr1Set.contains(j))
        intersection.add(j);
    }

    int[] result = new int[intersection.size()];
    int index = 0;
    for (Integer i : intersection)
      result[index++] = i;

    return result;
  }

  /**
   * Using binary search. Complexity is O(nLogn + mLogm)
   */
  public static int[] usingBinarySearch(int[] arr1, int[] arr2) {
    Arrays.sort(arr1);
    HashSet<Integer> intersection = new HashSet<>();
    for (int n : arr2) {
      if (binarySearch(arr1, n))
        intersection.add(n);
    }

    int[] result = new int[intersection.size()];
    int index = 0;
    for (Integer i : intersection)
      result[index++] = i;

    return result;
  }

  public static boolean binarySearch(int[] arr, int num) {
    int start = 0;
    int end = arr.length;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] == num) {
        return true;
      } else if (arr[mid] < num) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return false;

  }
}
