package week01.stack;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 0 <= n <= 3 * 104
// 0 <= height[i] <= 105
//
// Related Topics 栈 数组 双指针 动态规划
// 👍 2201 👎 0

import java.util.Stack;

public class TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            Stack<Integer> stack = new Stack<>();
            //单调递减栈
            int res = 0;
            for(int i=0;i<height.length;i++){
                //  找到更高的柱子时，可以进行面积计算
                while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                    int topidx = stack.pop();
                    //没有找到左边界
                    if(stack.isEmpty()) break;
                    //新的栈顶
                    int left = stack.peek(); //向左找第一个比他高的位置
                    int right = i; //向右找第一个比他高的位置
                    int h = Math.min(height[right], height[left]) - height[topidx];
                    res += h * (right-left-1);
                }
                stack.push(i);
            }
            return res;
        }

        public int trap2(int[] height) {
            int[] maxLeft = new int[height.length];
            int[] maxRight = new int[height.length];
            // i左边最高的高度
            for(int i=1;i<height.length;i++){
                maxLeft[i] = Math.max(height[i-1], maxLeft[i-1]);
            }
            // i右边最高的高度
            for(int i=height.length-2;i>=0;i--){
                maxRight[i] = Math.max(height[i+1],maxRight[i+1]);
            }
            int res = 0;
            for(int i=0;i<height.length;i++){
                if(maxLeft[i]>height[i]&&maxRight[i]>height[i]){
                    res += Math.min(maxLeft[i],maxRight[i])-height[i];
                }
            }
            return res;
        }

        public int trap3(int[] height) {
            //双指针
            if(height.length<=2) return 0;
            int res = 0;
            int left = 1;
            int right = height.length-2;
            int maxLeft = height[0]; //记录左指针左边的最大值
            int maxRight = height[height.length-1]; //记录右指针右边的最大值
            while(left<=right){
                if(maxLeft<maxRight){
                    res += Math.max(maxLeft-height[left],0);
                    maxLeft = Math.max(maxLeft, height[left]);
                    left++;
                }else{
                    res += Math.max(maxRight-height[right],0);
                    maxRight = Math.max(maxRight, height[right]);
                    right--;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
