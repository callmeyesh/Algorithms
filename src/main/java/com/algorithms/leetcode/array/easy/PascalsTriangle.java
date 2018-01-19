package com.algorithms.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;
/*-
 *
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5
 * Return
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 *  ]
 * @author yvenkatesh
 *
 */
public class PascalsTriangle {

  public static void main(String[] args) {
    System.out.println(generate(5));
    System.out.println(getRow(3));
  }

  public static ArrayList<ArrayList<Integer>> generate(int numRows) {
    ArrayList<ArrayList<Integer>> allrows = new ArrayList<>();
    ArrayList<Integer> row = new ArrayList<Integer>();
    for (int i = 0; i < numRows; i++) {
      row.add(0, 1);
      for (int j = 1; j < row.size() - 1; j++)
        row.set(j, row.get(j) + row.get(j + 1));
      allrows.add(new ArrayList<Integer>(row));
    }
    return allrows;

  }

  /*-
   * Given an index k, return the k'th row of the Pascal's triangle.
   *
   *    For example, given k = 3,
   *    Return [1,3,3,1].
   *
   * Note:
   *    Could you optimize your algorithm to use only O(k) extra space?
   */
  public static List<Integer> getRow(int rowIndex) {
    List<Integer> row = new ArrayList<Integer>();
    for (int i = 0; i <= rowIndex; i++) {
      row.add(0, 1);
      for (int j = 1; j < row.size() - 1; j++) {
        row.set(j, row.get(j + 1) + row.get(j));
      }
    }

    return row;

  }
}
