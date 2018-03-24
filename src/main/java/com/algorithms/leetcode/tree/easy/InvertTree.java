package com.algorithms.leetcode.tree.easy;

import java.util.ArrayDeque;

/**
 * P# 226 Invert a binary tree.
 * 
 * @author yvenkatesh
 *
 */
public class InvertTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode().setUp();
    System.out.println(invert(root));
  }

  static TreeNode invert(TreeNode root) {
    if (root == null)
      return root;

    invert(root.left);
    invert(root.right);

    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;

    return root;
  }

  static TreeNode invertIterative(TreeNode root) {
    if (root == null)
      return root;
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode current = queue.remove();
      TreeNode temp = current.left;
      current.left = current.right;
      current.right = temp;
      if (current.left != null)
        queue.add(current.left);

      if (current.right != null)
        queue.add(current.right);
    }

    return root;
  }
}
