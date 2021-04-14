package week02.dfs;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法
// 👍 1290 👎 0

import java.util.ArrayList;
import java.util.List;

//[46]全排列
public class Permutations{
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> results = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            if(nums==null || nums.length==0) return results;
            int[] flags = new int[nums.length];
            dfs(nums, flags, new ArrayList<>());
            return results;
        }

        //每个位置都是从剩下没有被挑选过的元素中挑选一个，所以用一个flags标记元素是否已经被选择过
        public void dfs(int[] nums, int[] flags, List<Integer> path){
            if(path.size()==nums.length){
                results.add(new ArrayList<>(path));
                return;
            }
            for(int i=0;i<nums.length;i++){
                if(flags[i]==1) continue; // nums[i]已经添加过
                path.add(nums[i]);
                flags[i] = 1; //标记flags[i]
                dfs(nums, flags, path);
                flags[i] = 0;
                path.remove(path.size()-1);
            }
        }
    }

    class Solution2 {
        List<List<Integer>> results = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            dfs(0,nums,new ArrayList<>());
            return results;
        }

        // begin, 在选path第几个位置的数
        public void dfs(int begin, int[] nums, List<Integer> path){
            if(path.size()==nums.length){
                results.add(new ArrayList<>(path));
                return;
            }
            for(int i=begin;i<nums.length;i++){
                path.add(nums[i]);
                //每次都把被选择的放在begin位置
                swap(nums, begin, i);
                dfs(begin+1, nums,path);
                path.remove(path.size()-1);
                swap(nums, begin, i);
            }
        }

        public void swap(int[] nums, int ind1, int ind2){
            int temp = nums[ind1];
            nums[ind1] = nums[ind2];
            nums[ind2] = temp;
        }
    }
}
