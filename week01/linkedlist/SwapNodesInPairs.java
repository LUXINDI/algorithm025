package week01.linkedlist;

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
//
//
// 示例 2：
//
//
//输入：head = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100
//
//
//
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
// Related Topics 递归 链表
// 👍 869 👎 0

public class SwapNodesInPairs{
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 递归的方法
        public ListNode swapPairs(ListNode head) {
            //递归的终止条件
            //链表为空，或者链表只有一个节点
            if(head==null||head.next==null) return head;
            // n1 -> n2 -> n3
            // n2 -> n1 -> n3
            // 原始链表的第二个节点变成新的链表的头节点
            ListNode newHead = head.next;
            // 表示将其余节点进行两两交换
            // 交换后的新的头节点为 head 的下一个节点
            head.next = swapPairs(newHead.next);
            // 原始链表的头节点变成新的链表的第二个节点
            newHead.next = head;
            return newHead;
        }

        //迭代的方法
        public ListNode swapPairs2(ListNode head){
            // temp -> n1 -> n2 -> n3
            // temp -> n2 -> n1 -> n3
            ListNode dummy = new ListNode(0, head);
            ListNode temp = dummy;
            while(temp.next!=null && temp.next.next!=null){
                ListNode n1 = temp.next;
                ListNode n2 = n1.next;
                ListNode n3 = n2.next;
                temp.next = n2;
                n2.next = n1;
                n1.next = n3;
                temp = n1;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
