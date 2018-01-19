package com.algorithms.ctci.array;

import java.util.Arrays;

/*-
 *
 * clockwise rotate
 * first reverse up to down, then swap the symmetry
 *
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
 *
 * Complexity: If it is an N*N Matrix then the complexity is
 * O(N^2) since we have to visit all the elements.
 *
 * @author yvenkatesh
 *
 */
public class RotateArray {

  public static void main(String[] args) {
    int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    rotate(m);
    System.out.println(Arrays.deepToString(m));
    swapSymmetry(m);
    System.out.println(Arrays.deepToString(m));
  }

  public static void rotate(int[][] m) {
    int i = 0;
    int j = m.length - 1;
    while (i < j) {
      int[] temp = m[i];
      m[i] = m[j];
      m[j] = temp;
      i++;
      j--;
    }
  }

  public static void swapSymmetry(int[][] m) {
    for (int i = 0; i < m.length; i++) {
      for (int j = i + 1; j < m.length; j++) {
        int temp = m[i][j];
        m[i][j] = m[j][i];
        m[j][i] = temp;
      }
    }
  }

}
