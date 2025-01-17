package week02.recursion;

//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
//
//
//
// 示例 1：
//
//
//输入：x = 2.00000, n = 10
//输出：1024.00000
//
//
// 示例 2：
//
//
//输入：x = 2.10000, n = 3
//输出：9.26100
//
//
// 示例 3：
//
//
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
//
//
//
//
// 提示：
//
//
// -100.0 < x < 100.0
// -231 <= n <= 231-1
// -104 <= xn <= 104
//
// Related Topics 数学 二分查找
// 👍 634 👎 0

public class PowxN{
    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (n>=0) return quickMul(x,n);
            else return 1/quickMul(x,-n);
        }
        //O(n) = O(logn)
        //T(n) = T(n/2) + O(1) = T(n/4)+2T(1)
        public double quickMul(double x, int n){
            if(n==0) return 1;
            double mul = quickMul(x,n/2);
            if(n%2==0){
                return mul * mul;
            }else{
                return mul * mul * x;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
