package week01.queue;

import java.util.Deque;
import java.util.LinkedList;
//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。
//
// 返回滑动窗口中的最大值。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
// 示例 2：
//
//
//输入：nums = [1], k = 1
//输出：[1]
//
//
// 示例 3：
//
//
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
//
//
// 示例 4：
//
//
//输入：nums = [9,11], k = 2
//输出：[11]
//
//
// 示例 5：
//
//
//输入：nums = [4,-2], k = 2
//输出：[4]
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// 1 <= k <= nums.length
//
// Related Topics 堆 Sliding Window
// 👍 933 👎 0

//reference:https://leetcode-cn.com/problems/sliding-window-maximum/solution/zhe-hui-yi-miao-dong-bu-liao-liao-de-hua-7fy5/
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        //注意res的长度
        int[] res = new int[nums.length-k+1];
        // 初始化一个单调递减栈
        //从队尾依次弹出
        for(int j=0;j<k;j++){
            while(!deque.isEmpty()&& nums[j]>deque.peekLast()){
                deque.pollLast();
            }
            deque.offerLast(nums[j]);
        }
        res[0] = deque.peekFirst();
        // nums.length-k ,nums.length-2 ,nums.length-1
        for(int i=1;i<=nums.length-k;i++){
            //单调递减栈
            if(!deque.isEmpty() && deque.peekFirst()==nums[i-1]){
                deque.pollFirst();
            }
            // nums[i+k-1]
            while(!deque.isEmpty()&&nums[i+k-1]>deque.peekLast()){
                deque.pollLast();
            }
            deque.offerLast(nums[i+k-1]);
            res[i] = deque.peekFirst();
        }
        return res;
    }
}
