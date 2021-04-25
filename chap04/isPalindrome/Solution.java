package chap04.isPalindrome;

public class Solution {
  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.isPalindrome("ab");
  }

  /**
   * @param s: A string
   * @return: Whether the string is a valid palindrome
   */
  public boolean isPalindrome(String s) {
    // write your code here
    if (s == null || s.length() == 0) return true;

    int left = 0;
    int right = s.length()-1;
    while(left < right) {
      while (left < right && !isValid(s.charAt(left))) left ++;
      while (left < right && !isValid(s.charAt(right))) right --;
      if (left >= right) return true;
      if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
        return false;
      }
      left ++;
      right --;
    }
    return true;
  }

  public boolean isValid(char c) {
    return Character.isLetter(c) || Character.isDigit(c);
  }
}
