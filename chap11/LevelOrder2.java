package chap11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import utils.TreeNode;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
//两个队列的方法实现BFS
public class LevelOrder2 {
  /**
   * @param root: A Tree
   * @return: Level order a list of lists of integer
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    // write your code here
    List<List<Integer>> results = new ArrayList<>();
    if (root == null) return results;
    List<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<TreeNode> nextQueue = new LinkedList<>();
      results.add(queue2IntegerList(queue));
      for (TreeNode node : queue) {
        if (node.left != null) {
          nextQueue.add(node.left);
        }
        if (node.right != null) {
          nextQueue.add(node.right);
        }
      }
      queue = nextQueue;
    }
    return results;
  }
  public List<Integer> queue2IntegerList(List<TreeNode> queue) {
    List<Integer> result = new ArrayList<>();
    for (TreeNode node : queue) {
      result.add(node.val);
    }
    return result;
  }
}
