package week02.tree;

//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组
// 👍 987 👎 0

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        int[] preorder;
        int[] inorder;
        int preidx = 0;
        Map<Integer, Integer> idxMap;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;
            // 注意因为树中没有重复的数字
            idxMap = new HashMap<>();
            for(int i=0;i<inorder.length;i++){
                idxMap.put(inorder[i],i);
            }
            return helper(0,preorder.length-1);
        }

        //已知根节点index，根据中序遍历构建 中序left到right的树
        public TreeNode helper(int left, int right){
            if(left>right) return null;
            int rootval = this.preorder[this.preidx];
            TreeNode root = new TreeNode(rootval);
            int rootidx = this.idxMap.get(rootval);
            this.preidx ++;
            root.left = helper(left,rootidx-1);
            root.right = helper(rootidx+1,right);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
