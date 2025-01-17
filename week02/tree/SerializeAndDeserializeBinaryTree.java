package week02.tree;

//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
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
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 树中结点数在范围 [0, 104] 内
// -1000 <= Node.val <= 1000
//
// Related Topics 树 设计
// 👍 537 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree{
    public static void main(String[] args) {
        }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null) return "{}";
            List<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            //把所有的节点按照层次遍历塞到队列里
            for(int i=0;i<queue.size();i++){
                TreeNode node = queue.get(i);
                if(node==null) continue;
                queue.add(node.left);
                queue.add(node.right);
            }
            //去掉队尾的空节点
            while(!queue.isEmpty()&&queue.get(queue.size()-1)==null){
                queue.remove(queue.size()-1);
            }
            StringBuilder sb = new StringBuilder();
            //开始序列化，空节点用#
            for(int i=0;i<queue.size();i++){
                TreeNode node = queue.get(i);
                if(node==null){
                    sb.append("#");
                }else{
                    sb.append(String.valueOf(node.val));
                }
                sb.append(",");
            }
            return sb.toString().substring(0,sb.length()-1);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.equals("{}")) return null;
            String[] info = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(info[0]));
            List<TreeNode> queue = new ArrayList<>();
            queue.add(root);
            boolean left = true;
            int index = 0;
            for(int i=1;i<info.length;i++){
                if(!info[i].equals("#")){
                    TreeNode node = new TreeNode(Integer.parseInt(info[i]));
                    if(left) queue.get(index).left = node;
                    else queue.get(index).right = node;
                    queue.add(node);
                }
                if(!left) index++;
                left = !left;
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}
