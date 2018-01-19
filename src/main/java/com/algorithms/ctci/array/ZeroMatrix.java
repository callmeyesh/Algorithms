package com.algorithms.ctci.array;

import java.util.Arrays;

/**
 * If an element in NxM matrix is 0, it's entire row and column becomes zero.
 *
 * @author yvenkatesh
 */
public class ZeroMatrix {

  public static void main(String[] args) {
    int[][] m = {{1, 2, 3}, {4, 0, 6}, {7, 8, 9}};
    boolean[] rows = new boolean[m.length];
    boolean[] cols = new boolean[m[0].length];
    setBooleanFlags(m, rows, cols);

    for (int r = 0; r < rows.length; r++) {
      if (rows[r])
        nullifyRow(m, r);
    }

    for (int c = 0; c < cols.length; c++) {
      if (cols[c])
        nullifyCols(m, c);
    }

    System.out.println(Arrays.deepToString(m));
  }

  static void setBooleanFlags(int[][] m, boolean[] rows, boolean[] cols) {
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[0].length; j++) {
        if (m[i][j] == 0) {
          rows[i] = true;
          cols[j] = true;
        }
      }
    }
  }

  static void nullifyRow(int[][] m, int row) {
    for (int i = 0; i < m[0].length; i++)
      m[row][i] = 0;
  }

  static void nullifyCols(int[][] m, int cols) {
    for (int i = 0; i < m.length; i++)
      m[i][cols] = 0;
  }

}
