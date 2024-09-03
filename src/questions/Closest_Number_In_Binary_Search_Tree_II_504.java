import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*

 */
public class Closest_Number_In_Binary_Search_Tree_II_504 {
    public int[] closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> q = new LinkedList<>();
        findClosestNodesHelper(root, target, k, q);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = q.poll();
        }
        return res;
    }

    private void findClosestNodesHelper(TreeNode node, double target, int k, Queue<Integer> q) {
        if (node == null) {
            return;
        }
        // in order traversal for the BST
        findClosestNodesHelper(node.left, target, k, q);

        if (q.size() < k) {
            q.offer(node.val);
        } else {
            if (Math.abs(node.val - target) < Math.abs(q.peek() - target)) {
                q.poll();
                q.offer(node.val);
            } else {
                return;
            }
        }
        findClosestNodesHelper(node.right, target, k, q);
    }
}
