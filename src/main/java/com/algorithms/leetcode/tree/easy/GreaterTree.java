package com.algorithms.leetcode.tree.easy;

/*-
 * P:538
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of
 * the original BST is changed to the original key plus sum of all keys greater than the
 * original key in BST.
 *
 * Example:
 * Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13
  Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
 * @author yvenkatesh
 */
public class GreaterTree {
  static int right = 0;

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(13);
    greaterTree(root);
  }

  public static void greaterTree(TreeNode root) {
    if (root == null)
      return;

    greaterTree(root.right);
    root.val = root.val + right;
    right = root.val;
    greaterTree(root.left);

  }
}
