package com.algorithms.leetcode.tree.easy;

/**
 * Helper class to create a Tree
 *
 * @author yvenkatesh
 *
 */
public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int x) {
    val = x;
  }

  TreeNode() {}

  public TreeNode setUp() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.right = new TreeNode(7);
    root.right.left = new TreeNode(15);
    root.right.left.left = new TreeNode(14);
    return root;
  }

}
