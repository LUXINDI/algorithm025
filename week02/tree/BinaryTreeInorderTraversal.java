package week02.tree;

//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[1,3,2]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [1]
//输出：[1]
//
//
// 示例 4：
//
//
//输入：root = [1,2]
//输出：[2,1]
//
//
// 示例 5：
//
//
//输入：root = [1,null,2]
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表
// 👍 905 👎 0


import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            helper(root, res);
            return res;
        }
        public void helper(TreeNode node, List<Integer> path){
            if(node == null) return;
            helper(node.left,path);
            path.add(node.val);
            helper(node.right,path);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
