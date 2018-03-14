package com.algorithms;

/**
 * Check if a number is prime or not.
 * 
 * https://en.wikipedia.org/wiki/Primality_test
 * https://www.geeksforgeeks.org/primality-test-set-1-introduction-and-school-method/
 * @author yvenkatesh
 *
 */
public class PrimalityTest {

  public static void main(String[] args) {
    System.out.println(isPrime(81));
  }

  public static boolean isPrime(int n) {
    if (n <= 1)
      return false;

    if (n <= 3)
      return true;

    if (n % 2 == 0 || n % 3 == 0)
      return false;

    // Only test the odd numbers of the form 6k +/- 1 till the square root of n
    int sqrt = (int) Math.sqrt(n);
    for (int i = 5; i <= sqrt; i = i + 6) {
      if (n % i == 0)
        return false;

      if (n % (i + 2) == 0)
        return false;
    }

    return true;
  }

}
