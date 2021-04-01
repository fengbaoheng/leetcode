/*
 * @lc app=leetcode.cn id=1372 lang=java
 *
 * [1372] 二叉树中的最长交错路径
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
class Solution {
    private int longest;

    public int longestZigZag(TreeNode root) {
        this.longest = 0;

        path(root);

        return longest;
    }

    private int[] path(TreeNode root) {
        if (root == null) {
            return new int[]{-1, -1};
        }

        int left = path(root.left)[1] + 1;
        int right = path(root.right)[0] + 1;

        longest = Math.max(longest, Math.max(left, right));

        return new int[]{left, right};
    }
}
// @lc code=end

