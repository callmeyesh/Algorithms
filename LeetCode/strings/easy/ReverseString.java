package strings.easy;

/**
 * P#344
 *
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Example:
 *
 * Given s = "hello", return "olleh".
 *
 * @author yvenkatesh
 *
 */
public class ReverseString {

  public static void main(String[] args) {
    String s = "Hello";
    System.out.println(reverseString(s));
    System.out.println(reverseUsingCharArray(s));
  }

  public static String reverseString(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--)
      sb.append(s.charAt(i));

    return sb.toString();
  }

  // Strings are immutable so use Char array
  public static String reverseUsingCharArray(String s) {
    int start = 0;
    int end = s.length() - 1;
    char[] c = s.toCharArray();

    while (start < end) {
      char temp = c[start];
      c[start++] = c[end];
      c[end--] = temp;
    }

    return String.valueOf(c);
  }


}
