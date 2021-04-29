package chap11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import utils.TreeNode;

public class LevelOrder3 {
  /**
   * @param root: A Tree
   * @return: Level order a list of lists of integer
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    // write your code here
    List<List<Integer>> results = new ArrayList<>();
    if (root == null) return results;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    queue.offer(null);
    List<Integer> level = new ArrayList<>();
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node == null) {
        if (level.isEmpty()) {
          break;
        }
        results.add(level);
        level = new ArrayList<>();
        queue.offer(null); // add a new dummy node
        continue;
      }
      level.add(node.val);
      if (node.left != null) {
        queue.offer(node.left);
      }
      if (node.right != null) {
        queue.offer(node.right);
      }
    }
    return results;
  }
}
