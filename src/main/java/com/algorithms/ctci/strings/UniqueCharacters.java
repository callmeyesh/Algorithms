package com.algorithms.ctci.strings;


import java.util.Arrays;

/**
 * Determine if a string has all unique characters.
 *
 * @author yvenkatesh
 */
public class UniqueCharacters {

  public static void main(String[] args) {
    String str = "Hello";
    System.out.println(usingSorting(str));
    System.out.println(usingBooleanFlag(str));
    System.out.println(usingBitVector(str));
  }

  /*-
   * Sort all the characters in the array and check if the adjacent ones are similar.
   * Complexity: O(N)
   * Space: O(N)
   */
  public static boolean usingSorting(String str) {
    char[] charArray = str.toCharArray();
    Arrays.sort(charArray);

    for (int i = 0; i < str.length() - 1; i++) {
      if (charArray[i] == charArray[i + 1])
        return false;
    }

    return true;
  }

  /*-
   * Assuming the input string is ASCII we use a boolean array of length 128 to keep track
   * of the characters in the string.
   * Complexity: O(N)
   * Space: O(1)
   */

  public static boolean usingBooleanFlag(String str) {
    if (str.length() > 128)
      return false;

    boolean[] charSet = new boolean[128];
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i);
      if (charSet[val])
        return false;
      charSet[val] = true;
    }

    return true;
  }

  /*-
   * We are assuming that input string has only lower case alphabets. Since INT has 32 bits and
   * there are 26 characters we can use each bit as a boolean flag.
   *
   * We get the character value relative to lower case `a`. We create a mask by taking 1 and
   * shifting 1 to the left by (character value) spots. By doing a AND with the INT and mask we can
   * check if the mask was set. If it was not set then we set it by doing an OR.
   *
   * Example:
   *    a = 0
   *    checker = 0
   *    mask = 1 (0001 => (1 << 0))
   *    checker & mask => 0
   *    checker | mask => checker = 1
   *
   *    b = 1
   *    checker = 1
   *    mask = 2 (0010 => (1 << 1))
   *    checker & mask => 0001 & 0010 = 0
   *    checker | mask => checker = 3 (0011)
   *
   *    b = 1   { b AGAIN}
   *    checker = 3
   *    mask = 2 (0010 => (1 << 1))
   *    checker & mask => 0011 & 0010 = 0010 {> 0 so duplicate}
   *
   * Complexity: O(N) For loop would only run 26 times.
   * Space: O(1)
   */
  public static boolean usingBitVector(String str) {
    if (str.length() > 26)
      return false;

    int checker = 0;

    for (int i = 0; i < str.length(); i++) {
      int charValue = str.charAt(i) - 'a';

      int mask = 1 << charValue;
      if ((checker & mask) > 0)
        return false;

      checker = checker | mask;
    }

    return true;

  }
}
