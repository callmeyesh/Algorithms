package com.algorithms.leetcode.tree.easy;

import java.util.ArrayDeque;

/**
 * P #104 Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the
 * farthest leaf node.
 *
 * @author yvenkatesh
 *
 */
public class MaxDepth {

  public static void main(String[] args) {
    TreeNode root = new TreeNode().setUp();
    System.out.println(recursive(root));
    System.out.println(dfs(root));

  }

  /**
   * Recursive approach to find max depth of a tree.
   *
   * @param root
   * @return max depth
   */
  static int recursive(TreeNode root) {
    if (root == null)
      return 0;

    return 1 + Math.max(recursive(root.left), recursive(root.right));
  }

  /**
   * Depth First Search implementation using two stacks
   *
   * @param root
   * @return max depth
   */
  static int dfs(TreeNode root) {
    if (root == null)
      return 0;

    int max = 0;
    ArrayDeque<TreeNode> stack = new ArrayDeque<>();
    ArrayDeque<Integer> value = new ArrayDeque<>();
    stack.push(root);
    value.push(1);

    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      int val = value.pop();
      max = Math.max(max, val);
      if (node.left != null) {
        stack.push(node.left);
        value.push(val + 1);
      }

      if (node.right != null) {
        stack.push(node.right);
        value.push(val + 1);
      }
    }

    return max;

  }

}
