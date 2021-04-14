package week02.dfs;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
// Related Topics 回溯算法
// 👍 670 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> results = new ArrayList<>();
        public List<List<Integer>> permuteUnique(int[] nums) {
            //排序
            Arrays.sort(nums);
            dfs(nums, new ArrayList<>(), new int[nums.length]);
            return results;
        }
        public void dfs(int[] nums, List<Integer> path, int[] flags){
            if(path.size() == nums.length){
                results.add(new ArrayList<>(path));
                return;
            }
            int i = 0;
            while (i<nums.length){
                //注意这里不要忘了i++
                if(flags[i] == 1)  {
                    i++;
                    continue;
                }
                path.add(nums[i]);
                flags[i] = 1;
                dfs(nums, path, flags);
                flags[i] = 0;
                path.remove(path.size()-1);
                i++;
                while(i<nums.length && nums[i]==nums[i-1]) i++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
