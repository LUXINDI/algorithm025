package week02.tree;

//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征：
//
//
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
//
//
// 示例 2:
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
//
// Related Topics 树 深度优先搜索 递归
// 👍 1003 👎 0

public class ValidateBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        class ResultType{
            //注意是long,否则会溢出
            long minVal;
            long maxVal;
            boolean valid;
            ResultType(long minVal, long maxVal, boolean valid){
                this.minVal = minVal;
                this.maxVal = maxVal;
                this.valid = valid;
            }
        }
        public boolean isValidBST(TreeNode root) {
            ResultType result = helper(root);
            return result.valid;
        }

        public ResultType helper(TreeNode node){
            if(node==null) return new ResultType(Long.MAX_VALUE, Long.MIN_VALUE,true);
            ResultType left = helper(node.left);
            ResultType right = helper(node.right);
            long minVal = Math.min(Math.min(left.minVal,right.minVal),node.val);
            long maxVal = Math.max(Math.max(left.maxVal,right.maxVal),node.val);
            boolean valid = left.valid && right.valid && left.maxVal < node.val && right.minVal > node.val;
            return new ResultType(minVal, maxVal, valid);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
