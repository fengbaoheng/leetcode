/*
 * @lc app=leetcode.cn id=623 lang=java
 *
 * [623] 在二叉树中增加一行
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
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> preRow = findRow(root, d - 1);

        for (TreeNode node : preRow) {
            TreeNode left = node.left;
            node.left = new TreeNode(v);
            if (left != null) {
                node.left.left = left;
            }

            TreeNode right = node.right;
            node.right = new TreeNode(v);
            if (right != null) {
                node.right.right = right;
            }
        }

        return root;
    }

    private Queue<TreeNode> findRow(TreeNode root, int d) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int row = 1;

        while (!queue.isEmpty()) {
            if (row == d) {
                return queue;
            }

            row++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return queue;
    }
}
// @lc code=end

