package array.easy;

import java.util.ArrayList;

public class PascalsTriangle {

  public static void main(String[] args) {
    int numRows = 5;
    System.out.println(generate(5));

  }

  public static ArrayList<ArrayList<Integer>> generate(int numRows) {
    ArrayList<ArrayList<Integer>> allrows = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> row = new ArrayList<Integer>();
    for (int i = 0; i < numRows; i++) {
      row.add(0, 1);
      for (int j = 1; j < row.size() - 1; j++)
        row.set(j, row.get(j) + row.get(j + 1));
      allrows.add(new ArrayList<Integer>(row));
    }
    return allrows;

  }
}
