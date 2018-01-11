package strings;

/*-
 * Given a string write a function to check if it is a permutation of a palindrome.
 * Input: 'Tact Coa'
 * Output: true (permutation taco cat is a palindrome)
 *
 * Assumptions: The input will not contain special characters like '/' or '\' This code will not
 * work because getNumericValue for special characters will always be -1 and it will be ignored when
 * constructing character array. Refer to LeetCode Permutation solution in strings for cases to deal
 * with special characters.
 *
 * @author yvenkatesh
 */
public class PalindromePermutation {

  public static void main(String[] args) {
    String s = "Tact Coa";
    System.out.println(canPermutePalindrome(s));
    System.out.println(usingSingleInteger(s));

  }

  /**
   * Get character count and check if there is at most one odd character.
   *
   * Complexity: O(N) Space: O(1)
   */
  public static boolean canPermutePalindrome(String s) {
    int[] charCount = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
    int oddChars = 0;

    for (char c : s.toCharArray()) {
      int value = getCharValue(c);
      if (value != -1) {
        charCount[value]++;
        if (charCount[value] % 2 == 1) {
          oddChars++;
        } else {
          oddChars--;
        }
      }
    }
    return oddChars <= 1;
  }


  public static int getCharValue(char c) {
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int val = Character.getNumericValue(c);

    if (a <= val && val <= z)
      return val - a;

    return -1;
  }

  /**
   * Using an Integer (32 bits) to store the flags of each character.
   *
   * Complexity: O(N) Space: O(1)
   */
  public static boolean usingSingleInteger(String phrase) {
    int bitVector = createBitVector(phrase);
    return bitVector == 0 || checkIfOnlyOneBitIsPresent(bitVector);
  }

  public static int createBitVector(String phrase) {
    int bitVector = 0;
    for (char c : phrase.toCharArray()) {
      int index = getCharValue(c);
      bitVector = toggle(bitVector, index);
    }

    return bitVector;
  }

  /**
   * Set the bit at the index. If the bit is already set then turn it off.
   */
  public static int toggle(int bitVector, int index) {
    if (index < 0)
      return bitVector;

    int mask = 1 << index;
    if ((bitVector & mask) == 0) {
      bitVector |= mask;
    } else {
      bitVector &= ~mask;
    }

    return bitVector;
  }

  /**
   * Check if only one bit is set in the integer.
   */
  public static boolean checkIfOnlyOneBitIsPresent(int bitVector) {
    return (bitVector & bitVector - 1) == 0;
  }

}
