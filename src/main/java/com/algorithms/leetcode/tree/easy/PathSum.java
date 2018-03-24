package com.algorithms.leetcode.tree.easy;

/*-
 * P# 112
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up
 * all the values along the path equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1

 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * @author yvenkatesh
 *
 */
public class PathSum {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(11);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);
    System.out.println(recursiveDFS(root, 22));
  }

  public static boolean recursiveDFS(TreeNode root, int sum) {
    if (root == null)
      return false;

    if (root.left == null && root.right == null && root.val == sum)
      return true;

    return recursiveDFS(root.left, sum - root.val) || recursiveDFS(root.right, sum - root.val);
  }
}
