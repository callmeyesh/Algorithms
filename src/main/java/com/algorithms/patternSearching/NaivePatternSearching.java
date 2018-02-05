package com.algorithms.patternSearching;

/**
 * Geeks for geek: Naive Pattern Searching
 * https://www.geeksforgeeks.org/searching-for-patterns-set-1-naive-pattern-searching/
 *
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char
 * txt[]) that prints all occurrences of pat[] in txt[]. You may assume that n > m.
 *
 * @author yvenkatesh
 *
 */
public class NaivePatternSearching {

  public static void main(String[] args) {
    String txt = "AABAACAADAABAAABAA";
    String pat = "AABA";
    naivePatternSearch(txt, pat);
  }

  /**
   * The best case occurs when the first character of the pattern is not present in text at all. The
   * number of comparisons in best case is O(n).
   *
   * txt[] = "AABCCAADDEE";
   *
   * pat[] = "FAA";
   *
   *
   * The worst case happens when:
   *
   * 1. All the characters in the string are same.
   *
   * txt[] = "AAAAAAAAAAAAAAAAAA";
   *
   * pat[] = "AAAAA";
   *
   * 2. When only the last character is different
   *
   * txt[] = "AAAAAAAAAAAAAAAAAB";
   *
   * pat[] = "AAAAB";
   *
   *
   * The time complexity is O(M*(N - M - 1)) where M is the length of the pattern and N is the
   * length of the string.
   *
   * @param txt: Input string
   * @param pat: Pattern string
   */
  public static void naivePatternSearch(String txt, String pat) {
    int patLength = pat.length();
    int txtLength = txt.length();

    // Loop from 0 -> [N - M]
    // We do not need to loop all the way till N, because the outer loop is responsible for getting
    // the start index to check for the inner loop.
    for (int i = 0; i < txtLength - patLength; i++) {
      int j;

      // This loop checks if the pattern is present starting from index i
      for (j = 0; j < patLength; j++) {
        if (txt.charAt(i + j) != pat.charAt(j))
          break;
      }

      // If pattern was present starting at index i, j will be length of the pattern string based on
      // the inner loop.
      if (j == patLength)
        System.out.println("Pattern starts at: " + i);
    }
  }

}
