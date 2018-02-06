package com.algorithms.leetcode.hashTable;

import java.util.Arrays;
import java.util.HashMap;

/**
 * P #760
 *
 * Given two lists A and B, and B is an anagram of A. B is an anagram of A means B is made by
 * randomizing the order of the elements in A.
 *
 * We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A
 * appears in B at index j.
 *
 * These lists A and B may contain duplicates. If there are multiple answers, output any of them.
 *
 * For example, given
 *
 * A = [12, 28, 46, 32, 50] B = [50, 12, 32, 46, 28] We should return [1, 4, 3, 2, 0]
 *
 * @author yvenkatesh
 *
 */
public class AnagramMappings {

  public static void main(String[] args) {
    int[] A = {12, 28, 46, 32, 50};
    int[] B = {50, 12, 32, 46, 28};
    int[] result = anagramMappings(A, B);
    System.out.println(Arrays.toString(result));

  }

  public static int[] anagramMappings(int[] A, int[] B) {
    HashMap<Integer, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < B.length; i++)
      indexMap.put(B[i], i);

    int[] result = new int[A.length];
    for (int j = 0; j < A.length; j++)
      result[j] = indexMap.get(A[j]);

    return result;
  }

}
