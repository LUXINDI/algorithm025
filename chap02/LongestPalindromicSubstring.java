package chap02;

//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
// 示例 3：
//
//
//输入：s = "a"
//输出："a"
//
//
// 示例 4：
//
//
//输入：s = "ac"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成
//
// Related Topics 字符串 动态规划
// 👍 3536 👎 0

public class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        // dp[i][j] = dp[i+1][j-1] && s.charAr[i] == s.charAr[j]
        public String longestPalindrome(String s) {
            int n = s.length();

            // dp[i][j]: s从i到j位置是否是回文
            boolean[][] dp = new boolean[n][n];
            int longest = 1;
            int start = 0;

            // 初始化
            // 两种情况：回文串为奇数长度和偶数长度
            for (int i = 0; i < n; i++) {
                dp[i][i] = true;
            }
            for (int i = 0; i < n - 1; i++) {
                dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
                if (dp[i][i+1]) {
                    longest = 2;
                    start = i;
                }
            }


            for (int i = s.length()-1; i >= 0; i--) {
                for (int j = i + 2; j < s.length(); j++){
                    dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                    if (dp[i][j] && j - i + 1 > longest){
                        longest = j - i + 1;
                        start = i;
                    }
                }
            }

            return s.substring(start, start + longest);
        }
    }


    class Solution_center {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) return s;

            int maxLen = 1;
            int start = 0;
            for (int i = 0; i <= s.length() - 1; i++) {
                int left = i - 1;
                int right = i + 1;
                int curLen = 1;
                while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                    left--;
                    curLen++;
                }
                while (right <= s.length() - 1 && s.charAt(right) == s.charAt(i)) {
                    right++;
                    curLen++;
                }
                while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                    right++;
                    left--;
                    curLen += 2;
                }
                if (curLen > maxLen) {
                    maxLen = curLen;
                    start = left + 1;
                }
            }

            return s.substring(start, start + maxLen);
        }
    }

    class Solution_n3 {
        // O(n^3)
        public String longestPalindrome(String s) {
            // 异常检测：需要对空对象进行特判；
            if (s == null || s.length() == 0 ) return s;

            // 代码块分行
            // 变量命名：尽量不要用单个字符进行命名；
            // 代码美观：在必要的位置需要加上空格；
            for (int len = s.length(); len >= 1; len--) {
                for (int left = 0; left + len -1 < s.length(); left++){
                    int right = left + len - 1;
                    if (isPalindrome(s, left, right)) {
                        return s.substring(left, right+1);
                    }
                }
            }

            return "";
        }

        // 缩进过多：通过用函数包装代码块减少代码的缩进。
        public boolean isPalindrome(String s, int left, int right){
            while (left < right && s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }
            return left >= right;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
