/*
 * @lc app=leetcode.cn id=1110 lang=java
 *
 * [1110] 删点成林
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;


class Solution {
    private Set<Integer> toDelete;
    private List<TreeNode> nodes;


    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        nodes = new LinkedList<>();
        toDelete = new HashSet<>(to_delete.length);
        for (int num : to_delete) {
            toDelete.add(num);
        }

        delete(root);
        return nodes;
    }

    private void delete(TreeNode root) {
        if (root == null) {
            return;
        }

        // 根节点需要删除
        // 即跳过根节点，尝试删除子树
        if (toDelete.contains(root.val)) {
            delete(root.left);
            delete(root.right);
            return;
        }

        // 保留本树
        nodes.add(root);

        // 在root上删除
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode left = node.left;
            if (left != null) {
                if (toDelete.contains(left.val)) {
                    node.left = null;
                    delete(left);
                } else {
                    queue.offer(left);
                }
            }

            TreeNode right = node.right;
            if (right != null) {
                if (toDelete.contains(right.val)) {
                    node.right = null;
                    delete(right);
                } else {
                    queue.offer(right);
                }
            }
        }
    }
}
// @lc code=end

