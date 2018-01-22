package com.algorithms.leetcode.strings.easy;

/*-
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this
 * robot makes a circle, which means it moves back to the original place.
 *
 * The move sequence is represented by a string. And each move is represent by a character. The
 * valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or
 * false representing whether the robot makes a circle.
 *
 * Example 1:
 *  Input: "UD"
 *  Output: true
 *
 * Example 2:
 *  Input: "LL"
 *  Output: false
 *
 * @author yvenkatesh
 */
public class JudgeCircle {

  public static void main(String[] args) {
    String moves = "UD";
    System.out.println(judgeCircle(moves));
  }

  public static boolean judgeCircle(String moves) {
    int x = 0;
    int y = 0;
    for (char m : moves.toCharArray()) {
      if (m == 'U')
        y++;
      if (m == 'D')
        y--;
      if (m == 'R')
        x++;
      if (m == 'L')
        x--;
    }

    return x == 0 && y == 0;
  }

}
