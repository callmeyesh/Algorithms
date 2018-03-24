package com.algorithms.leetcode.tree.easy;

import java.util.HashMap;

/**
 * P#437
 *
 * You are given a binary tree in which each node contains an integer value. Find the number of
 * paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling
 * only from parent nodes to child nodes).
 *
 * @author yvenkatesh
 *
 */
public class PathSum3 {
  static int count = 0;

  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(2);
    root.left.left.left = new TreeNode(3);
    root.left.left.right = new TreeNode(-2);
    root.left.right.right = new TreeNode(1);
    root.right = new TreeNode(-3);
    root.right.right = new TreeNode(11);

    System.out.println(pathSum3(root, 8));
  }

  static int pathSum3(TreeNode root, int target) {
    // Hash map acts as a way to track the prefix sum in a branch.
    // from root to the current node. It stores the prefix sum and frequency so far.
    HashMap<Integer, Integer> prefixSum = new HashMap<>();
    return backtracking(root, 0, prefixSum, target);
  }

  static int backtracking(TreeNode root, int currSum, HashMap<Integer, Integer> prefixSum,
      int target) {

    // Base case when root is null return sum as 0
    if (root == null)
      return 0;

    currSum += root.val;
    // If current sum - target is present we return the frequency.
    // e.g:
    // If the current path is 10,5,3 then current sum is 18.
    // 18 - 8 = 10.
    // 10 is already present in our prefix sum map with frequency 1.
    // If the difference is present in the map then there exist a path from middle to the current
    // node.
    count += prefixSum.getOrDefault(currSum - target, 0);

    // Update the map with the current sum and its frequency.
    prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);

    // Get valid paths in the subtrees.
    backtracking(root.left, currSum, prefixSum, target);
    backtracking(root.right, currSum, prefixSum, target);

    // Reset the frequency when the recursion goes back from bottom to top. This will reset the
    // frequency of the children as we come back up.
    prefixSum.put(currSum, prefixSum.get(currSum) - 1);

    return count;
  }

}
