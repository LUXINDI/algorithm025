package week02.dfs;

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//
//
// 示例 2：
//
//
//输入：nums = [0]
//输出：[[],[0]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// nums 中的所有元素 互不相同
//
// Related Topics 位运算 数组 回溯算法
// 👍 1137 👎 0

import sun.jvm.hotspot.runtime.aarch64.AARCH64CurrentFrameGuess;

import java.util.ArrayList;
import java.util.List;

public class Subsets{
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> results = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
            dfs(nums,0,new ArrayList<>());
            return results;
        }

        public void dfs(int[] nums, int begin, List<Integer> path){
            if(begin==nums.length){
                results.add(new ArrayList<>(path));
                return;
            }
            //每个元素都有加或者不加两种选择
            dfs(nums,begin+1,path);

            path.add(nums[begin]);
            dfs(nums,begin+1,path);
            path.remove(path.size()-1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
class Solution2 {
    List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0,new ArrayList<>());
        return results;
    }

    public void dfs(int[] nums, int begin, List<Integer> path){
        //不选择这个元素，直接加到results里
        results.add(new ArrayList<>(path));
        //选择这个元素，接下来dfs
        for(int i=begin;i<nums.length;i++){
            path.add(nums[i]);
            //注意是i+1
            dfs(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }
}

}
