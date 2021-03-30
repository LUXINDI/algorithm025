package week01.array;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
//
// Related Topics 数组 双指针
// 👍 3170 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum{
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        solution.threeSum(new int[]{1,-1,-1,0});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            //nums.length-3,nums.length-2,nums.length-1
            for(int i=0;i<=nums.length-3;i++){
                if(i>=1&&nums[i]==nums[i-1]){
                    continue;
                }
                int left = i+1;
                int right = nums.length -1;
                int target = -nums[i];
                while(left<right){
                    int curSum = nums[left] + nums[right];
                    if(curSum == target){
                        List<Integer> cur = new ArrayList<>();
                        cur.add(nums[i]);
                        cur.add(nums[left]);
                        cur.add(nums[right]);
                        res.add(cur);
                        left++;
                        right--;
                        while(left<=nums.length-1&&nums[left]==nums[left-1]){
                            left++;
                        }
                        while(right>=0&&nums[right]==nums[right+1]){
                            right--;
                        }
                    }else if (curSum<target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
