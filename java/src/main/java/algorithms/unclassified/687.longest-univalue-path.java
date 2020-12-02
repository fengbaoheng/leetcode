/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] 最长同值路径
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
    public int longestUnivaluePath(TreeNode root) {
        int longest = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }

            int left = findPath(node.left, node.val);
            int right = findPath(node.right, node.val);

            longest = Math.max(longest, left + right);

            queue.add(node.left);
            queue.add(node.right);
        }

        return longest;
    }

    private int findPath(TreeNode root, int target) {
        if (root == null || root.val != target) {
            return 0;
        }

        int left = findPath(root.left, target);
        int right = findPath(root.right, target);

        return 1 + Math.max(left, right);
    }
}
// @lc code=end

