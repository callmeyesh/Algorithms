package com.algorithms;

/**
 * https://www.geeksforgeeks.org/sieve-of-eratosthenes/
 * @author yvenkatesh
 *
 */
public class SieveOfEratosthenes {

  public static void main(String[] args) {
    System.out.println(countPrimes(8));
  }


  /**
   * Returns the count of prime numbers less than n
   * 
   * @param n is input integer
   * @return Count of primes less than n
   */
  public static int countPrimes(int n) {
    int count = 0;
    boolean primes[] = new boolean[n];
    for (int p = 0; p < n; p++)
      primes[p] = true;

    for (int i = 2; i * i <= n; i++) {
      if (primes[i] == true) {
        for (int j = 2 * i; j < n; j += i)
          primes[j] = false;
      }
    }

    for (int i = 2; i < n; i++) {
      if (primes[i] == true)
        count++;
    }

    return count;

  }
}
