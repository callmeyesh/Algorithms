package com.algorithms.leetcode.tree.easy;

/*-
 * P# 101
 * Given a binary tree, check whether it is a mirror of itself (i.e, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
        1
       / \
      2   2
     / \ / \
    3  4 4  3
  But the following [1,2,2,null,3,null,3] is not:
        1
       / \
      2   2
       \   \
       3    3
 *
 * @author yvenkatesh
 *
 */
public class IsSymmetric {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    root.left.right = new TreeNode(3);
    root.right.right = new TreeNode(3);
    System.out.println(isSymmetric(root));
  }

  public static boolean isSymmetric(TreeNode root) {
    if (root == null)
      return true;

    if (root.left == null && root.right == null)
      return true;

    return isSymeetricHelper(root.left, root.right);

  }

  static boolean isSymeetricHelper(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null)
      return true;

    if (t1 == null && t2 != null)
      return false;

    if (t2 == null && t1 != null)
      return false;

    return t1.val == t2.val && isSymeetricHelper(t1.left, t2.right)
        && isSymeetricHelper(t1.right, t2.left);

  }
}
