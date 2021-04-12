package week02.dfs;

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法
// 👍 550 👎 0

import java.util.ArrayList;
import java.util.List;


public class Combinations{
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> results = new ArrayList<>();
        int n;
        public List<List<Integer>> combine(int n, int k) {
            this.n = n;
            dfs(1,k,new ArrayList<>());
            return results;
        }
        public void dfs(int begin, int k, List<Integer> path){
            if(path.size()==k){
                //注意要new一个新的，否则结果为空
                results.add(new ArrayList<>(path));
                return;
            }
            for(int i=begin;i<=this.n;i++){
                //这里是剪枝 pathsize+可以选择的最多的数的个数<k
                if(path.size()+n-i+1<k) break;
                path.add(i);
                //注意下一个dfs起点是i+1,而不是begin+1
                dfs(i+1,k,path);
                path.remove(path.size()-1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
