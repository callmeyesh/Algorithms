package com.algorithms.leetcode.tree.easy;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
 * the two subtrees of every node never differ by more than 1.
 *
 *
 * @author yvenkatesh
 *
 */
public class SortedArrayToBst {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(2);
    findMode(root);

  }

  public static int[] findMode(TreeNode root) {
    inorder(root);
    modes = new int[modeCount];
    modeCount = 0;
    currCount = 0;
    inorder(root);
    return modes;
  }

  private static int currVal;
  private static int currCount = 0;
  private static int maxCount = 0;
  private static int modeCount = 0;

  private static int[] modes;

  private static void handleValue(int val) {
    if (val != currVal) {
      currVal = val;
      currCount = 0;
    }
    currCount++;
    if (currCount > maxCount) {
      maxCount = currCount;
      modeCount = 1;
    } else if (currCount == maxCount) {
      if (modes != null)
        modes[modeCount] = currVal;
      modeCount++;
    }
  }

  private static void inorder(TreeNode root) {
    if (root == null)
      return;
    inorder(root.left);
    handleValue(root.val);
    inorder(root.right);
  }
}
