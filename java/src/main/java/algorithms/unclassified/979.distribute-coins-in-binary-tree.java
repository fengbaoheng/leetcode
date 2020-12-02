/*
 * @lc app=leetcode.cn id=979 lang=java
 *
 * [979] 在二叉树中分配硬币
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
    private int count;

    public int distributeCoins(TreeNode root) {
        count = 0;

        distribute(root);

        return count;
    }

    private int distribute(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = distribute(root.left);
        int right = distribute(root.right);

        count += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}
// @lc code=end

