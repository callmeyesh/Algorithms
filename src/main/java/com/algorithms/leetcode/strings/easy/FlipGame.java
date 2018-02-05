package com.algorithms.leetcode.strings.easy;

import java.util.ArrayList;
import java.util.Arrays;


/*-
 * P#293
 *
 * You are playing the following Flip Game with your friend: Given a string that contains only these
 * two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move and therefore the other person will be the
 * winner.
 *
 * Write a function to compute all possible states of the string after one valid move.
 *
 * For example, given s = "++++", after one move, it may become one of the following states:
 *
 * [
 *  "--++",
 *  "+--+",
 *  "++--"
 * ]
 *
 * If there is no valid move, return an empty list [].
 *
 * @author yvenkatesh
 */
public class FlipGame {

  public static void main(String[] args) {
    String s = "++++";
    ArrayList<String> result = generatePossibleNextMoves(s);
    System.out.println(Arrays.toString(result.toArray()));

  }

  public static ArrayList<String> generatePossibleNextMoves(String s) {
    ArrayList<String> results = new ArrayList<>();
    int length = s.length();

    if (length == 0)
      return results;

    for (int i = 1; i < length; i++) {
      if (s.charAt(i) == '+' && s.charAt(i - 1) == '+')
        results.add(s.substring(0, i - 1) + "--" + s.substring(i + 1, length));
    }
    return results;

  }

}
