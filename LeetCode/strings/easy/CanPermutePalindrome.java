package strings.easy;

/*-
 * Problem #266
 * Given a string, determine if a permutation of the string could form a palindrome.
 *
 * For example,
 *  "code" -> False, "aab" -> True, "carerac" -> True.
 *
 * @author yvenkatesh
 */
public class CanPermutePalindrome {

  public static void main(String[] args) {
    String s1 = "AaAa/y";
    String s2 = "AaAa/";
    System.out.println(canPermutePalindrome(s1));
    System.out.println(canPermutePalindrome(s2));
  }

  public static boolean canPermutePalindrome(String s) {
    // Assuming ASCII character sets.
    int[] charCount = new int[128];
    int oddChars = 0;

    for(int i = 0; i < s.length(); i++) {
        charCount[s.charAt(i)]++;
        if(charCount[s.charAt(i)] % 2 == 1) {
            oddChars++;
        } else {
            oddChars--;
        }
    }

    return oddChars <= 1;
}
}
