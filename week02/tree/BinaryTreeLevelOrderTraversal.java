package week02.tree;

//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
//二叉树：[3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层序遍历结果：
//
//
//[
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索
// 👍 831 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                List<Integer> cur = new ArrayList<>();
                for(int i=0;i<size;i++){
                    TreeNode node = queue.poll();
                    //注意要判断是否有左右孩子
                    if(node.left!=null) queue.offer(node.left);
                    if(node.right!=null) queue.offer(node.right);
                    cur.add(node.val);
                }
                res.add(cur);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
