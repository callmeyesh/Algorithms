package com.algorithms.leetcode.stack.easy;

public class MinStack {
  Node head;

  public static void main(String[] args) {
    MinStack obj = new MinStack();
    obj.push(-2);
    obj.push(0);
    obj.push(-3);
    System.out.println(obj.getMin());
    obj.pop();
    System.out.println(obj.top());
    System.out.println(obj.getMin());
  }

  public void push(int x) {
    if (head == null) {
      head = new Node(x, x, null);
    } else {
      head = new Node(x, Math.min(x, head.min), head);
    }
  }

  public void pop() {
    head = head.next;
  }

  public int top() {
    return head.val;
  }

  public int getMin() {
    return head.min;
  }

  private class Node {
    int val;
    int min;
    Node next;

    public Node(int val, int min, Node next) {
      this.val = val;
      this.min = min;
      this.next = next;
    }
  }

}
