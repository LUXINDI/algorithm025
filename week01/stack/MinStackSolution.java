package week01.stack;

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//
// push(x) —— 将元素 x 推入栈中。
// pop() —— 删除栈顶的元素。
// top() —— 获取栈顶元素。
// getMin() —— 检索栈中的最小元素。
//
//
//
//
// 示例:
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
//
//
//
//
// 提示：
//
//
// pop、top 和 getMin 操作总是在 非空栈 上调用。
//
// Related Topics 栈 设计
// 👍 857 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//辅助栈 min_stack: 用于存储栈中的最小值
//保持栈顶
public class MinStackSolution{
    public static void main(String[] args) {

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> min_stack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            min_stack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if(min_stack.isEmpty() || val<=min_stack.peek()){
                min_stack.push(val);
            }
        }

        public void pop() {
            int e = stack.pop();
            if(!min_stack.isEmpty()&&min_stack.peek()==e){
                min_stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min_stack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
