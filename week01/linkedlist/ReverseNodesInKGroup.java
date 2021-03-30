package week01.linkedlist;

//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
// 进阶：
//
//
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
//
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
//
//
// 示例 3：
//
//
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
//
//
// 示例 4：
//
//
//输入：head = [1], k = 1
//输出：[1]
//
//
//
//
//
// 提示：
//
//
// 列表中节点的数量在范围 sz 内
// 1 <= sz <= 5000
// 0 <= Node.val <= 1000
// 1 <= k <= sz
//
// Related Topics 链表
// 👍 1008 👎 0

public class ReverseNodesInKGroup{
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(0, head);
            head = dummy;
            while(head!=null) {
                head = reverse(head, k);
            }
            return dummy.next;
        }

        // head -> n1 -> ... -> nk -> nk+1
        // head -> nk -> ... -> n1 -> nk+1
        private ListNode reverse(ListNode head, int k){
            ListNode nk = head;
            // find kth node
            for(int i=1;i<=k;i++){
                nk = nk.next;
                if(nk==null) return null;
            }
            // get (k+1)th node
            ListNode nkplus = nk.next;

            // reverse n1 -> ... -> nk
            ListNode prev = head;
            ListNode cur = head.next;
            // head <- n1 <- n2 ... <- nk  nk+1
            while(cur!=nkplus){
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
            // reconnect
            // head -> nk ->nk-1 -> ... -> n1 -> nk+1
            ListNode n1 = head.next;
            head.next = prev;
            n1.next = cur;
            return n1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
