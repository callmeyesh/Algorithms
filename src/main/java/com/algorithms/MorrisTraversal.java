package com.algorithms;

import com.algorithms.leetcode.tree.easy.TreeNode;

/**
 * Morris inorder/preorder traversals
 *
 * @author yvenkatesh
 *
 */
public class MorrisTraversal {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.right = new TreeNode(6);
    root.right.right = new TreeNode(7);

    inorder(root);
    System.out.println("----");
    preorder(root);
  }

  public static void inorder(TreeNode root) {
    TreeNode current = root;
    while (current != null) {
      if (current.left == null) {
        System.out.println(current.val);
        current = current.right;
      } else {
        TreeNode successor = current.left;
        while (successor.right != null && successor.right != current)
          successor = successor.right;

        if (successor.right == null) {
          successor.right = current;
          current = current.left;
        } else {
          successor.right = null;
          System.out.println(current.val);
          current = current.right;
        }
      }
    }
  }

  public static void preorder(TreeNode root) {
    TreeNode current = root;
    while (current != null) {
      if (current.left == null) {
        System.out.println(current.val);
        current = current.right;
      } else {
        TreeNode successor = current.left;
        while (successor.right != null && successor.right != current)
          successor = successor.right;

        if (successor.right == null) {
          successor.right = current;
          System.out.println(current.val);
          current = current.left;
        } else {
          successor.right = null;
          current = current.right;
        }
      }
    }
  }


}
