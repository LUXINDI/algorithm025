package week01.stack;

//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
//
//
//
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
//
//
//
//
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
//
//
//
// 示例:
//
// 输入: [2,1,5,6,2,3]
//输出: 10
// Related Topics 栈 数组
// 👍 1283 👎 0

//[84]柱状图中最大的面积
//reference:https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/84-by-ikaruga/
//思路
// 对于每一个高度，得到它向左向右的边界，求该高度下的最大矩形面积
// 单调递增栈：
// 每次出栈时，入栈元素是出栈元素向右第一个比他小的元素；
//出栈后，新的栈顶元素是出栈元素向左第一个比他小的元素
//每次弹出时，计算弹出位置的柱形图面积
import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram{
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        solution.largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            Deque<Integer> stack = new LinkedList<>();
            int[] newH = new int[heights.length+2];
            int res = 0;
            //newH最后一位是0，为了让所有元素都弹出
            //newH第一位也是0
            System.arraycopy(heights, 0, newH,1, heights.length);
            for (int i=0;i<newH.length;i++){
                // deque.peekFirst 与 stack.peek对应
                if(i>=1) System.out.println(newH[stack.peekFirst()]);
                while (!stack.isEmpty() && newH[i] < newH[stack.peekFirst()]) {
                    int top = stack.pollFirst(); // 出栈元素
                    int right = i - 1; // 入栈元素：右边界
                    int left = stack.peekFirst() + 1; //新的栈顶元素，左边界
                    res = Math.max(newH[top] * (right - left + 1), res);
                }
                stack.push(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
