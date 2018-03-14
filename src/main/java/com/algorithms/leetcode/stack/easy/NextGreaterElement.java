package com.algorithms.leetcode.stack.easy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

public class NextGreaterElement {

  public static void main(String[] args) {
    int[] nums1 = {4, 1, 2};
    int[] nums2 = {1, 3, 4, 2};
    int[] r1 = nextGreaterElement(nums1, nums2);
    System.out.println(Arrays.toString(r1));

    int[] r2 = nextGreaterElement2(nums1, nums2);
    System.out.println(Arrays.toString(r2));
  }

  public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int[] result = new int[nums1.length];
    HashMap<Integer, Integer> map = generateReferenceMap(nums2);

    // Now our reference map is complete
    for (int j = 0; j < nums1.length; j++) {
      int ele = nums1[j];
      result[j] = map.get(ele);
    }

    return result;
  }

  /** Generate a map with the next greatest value for each array element **/
  public static HashMap<Integer, Integer> generateReferenceMap(int[] arr) {
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = arr.length - 1; i >= 0; i--) {
      int curr = arr[i];
      while (!stack.isEmpty()) {
        int nextGreatest = stack.peekFirst();
        if (curr < nextGreatest) {
          // Update the map & add the current to the top of stack
          map.put(curr, nextGreatest);
          stack.addFirst(curr);
          break;
        } else {
          stack.removeFirst();
        }
      }

      // If the stack is empty (i.e first try) we initialize it with -1
      if (stack.isEmpty()) {
        map.put(curr, -1);
        stack.addFirst(curr);
      }
    }
    return map;
  }

  // ========================================================================================
  // Alternate solution
  // ========================================================================================
  public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    int[] result = new int[nums1.length];

    for (int i = 0; i < nums2.length; i++) {
      int curr = nums2[i];
      while (!stack.isEmpty() && stack.peekFirst() < curr)
        map.put(stack.removeFirst(), curr);
      stack.addFirst(curr);
    }

    for (int j = 0; j < nums1.length; j++) {
      result[j] = map.getOrDefault(nums1[j], -1);
    }

    return result;
  }
}
