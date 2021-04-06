package week02;

//编写一个程序，找出第 n 个丑数。
//
// 丑数就是质因数只包含 2, 3, 5 的正整数。
//
// 示例:
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//
// 说明:
//
//
// 1 是丑数。
// n 不超过1690。
//
// Related Topics 堆 数学 动态规划
// 👍 500 👎 0

//reference: https://leetcode-cn.com/problems/chou-shu-lcof/solution/chou-shu-ii-qing-xi-de-tui-dao-si-lu-by-mrsate/
//相当于合并三个有序数组
// dp[0]*2,dp[1]*2
// dp[0]*3,dp[1]*3
// dp[0]*5,dp[1]*5
public class UglyNumberIi{
    public static void main(String[] args) {
        Solution solution = new UglyNumberIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n];
            dp[0] = 1;
            int a = 0;
            int b = 0;
            int c = 0;
            for(int i=1;i<n;i++){
                int n2 = dp[a] * 2;
                int n3 = dp[b] * 3;
                int n5 = dp[c] * 5;
                dp[i] = Math.min(n2, Math.min(n3,n5));
                // 不是if else，因为会有重复的值
                if(dp[i] == n2) a++;
                if(dp[i] == n3) b++;
                if(dp[i] == n5) c++;
            }
            return dp[n-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
