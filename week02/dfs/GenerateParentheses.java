package week02.dfs;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：["()"]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 8
//
// Related Topics 字符串 回溯算法
// 👍 1703 👎 0

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            dfs(0,0, n ,"",res);
            return res;
        }

        // left:已经用了几个左括号
        // right: 已经用了几个右括号
        public void dfs(int left, int right, int n, String curStr, List<String> res){
            if(left==n&&right==n){
                res.add(curStr);
                return;
            }
            //右括号数比左括号数多，剪枝
            if(left<right) return;
            if(left<n){
                dfs(left+1, right, n,curStr+"(",res);
            }
            if(right<n){
                dfs(left, right+1, n, curStr+")",res);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
