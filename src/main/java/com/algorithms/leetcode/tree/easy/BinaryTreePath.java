package com.algorithms.leetcode.tree.easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a binary tree, return all root-to-leaf paths. For example, given the following binary tree:
 *
 * 1 / \ 2 3 \ 5 All root-to-leaf paths are:
 *
 * ["1->2->5", "1->3"]
 *
 * @author yvenkatesh
 *
 */
public class BinaryTreePath {

  public static void main(String[] args) {
    TreeNode root = new TreeNode().setUp();
    ArrayList<String> output = binaryTreePaths(root);
    System.out.println(Arrays.toString(output.toArray()));
  }

  public static ArrayList<String> binaryTreePaths(TreeNode root) {
    ArrayList<String> arr = new ArrayList<>();
    return binaryTreePathsHelper(root, arr, "");
  }

  public static ArrayList<String> binaryTreePathsHelper(TreeNode root, ArrayList<String> arr,
      String s) {
    if (root == null)
      return arr;

    if (root.left == null && root.right == null)
      arr.add(s + root.val);

    s += root.val;
    s += "->";
    binaryTreePathsHelper(root.left, arr, s);
    binaryTreePathsHelper(root.right, arr, s);
    return arr;

  }

}
