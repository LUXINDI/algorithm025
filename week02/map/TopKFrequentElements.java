package week02.map;

//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
//
//
// 示例 1:
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//
//
// 示例 2:
//
// 输入: nums = [1], k = 1
//输出: [1]
//
//
//
// 提示：
//
//
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
// 你可以按任意顺序返回答案。
//
// Related Topics 堆 哈希表
// 👍 713 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements{
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            //首先对于nums中数字计数
            Map<Integer, Integer> freq = getFreq(nums);
            //注意List数组的构造
            int n = nums.length;
            //数字出现的最大的次数<=n
            List<Integer>[] counter = new List[n+1];
            for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
                int num = entry.getKey();
                int cnt = entry.getValue();
                if(counter[cnt]==null){
                    counter[cnt] = new ArrayList<>();
                }
                counter[cnt].add(num);
            }
            int j = 0;
            int[] res = new int[k];
            for(int i=n;i>=1&&j<k;i--){
                if(counter[i]!=null){
                    for(int num : counter[i]){
                        res[j++] = num;
                    }
                }
            }
            return res;
        }
        public Map<Integer, Integer> getFreq(int[] nums){
            Map<Integer, Integer> map = new HashMap<>();
            for(int num : nums){
                map.put(num, map.getOrDefault(num,0)+1);
            }
            return map;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
