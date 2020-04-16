/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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
    public int getMinimumDifference(TreeNode root) {
        return getMinimumDifference(root, null, null);
    }

    private int getMinimumDifference(TreeNode root, Integer max, Integer min) {
        int minDiff = Integer.MAX_VALUE;
        if (root == null) {
            return minDiff;
        }

        if (max != null) {
            minDiff = Math.min(minDiff, max - root.val);
        }

        if (min != null) {
            minDiff = Math.min(minDiff, root.val - min);
        }

        minDiff = Math.min(minDiff, getMinimumDifference(root.left, root.val, min));
        minDiff = Math.min(minDiff, getMinimumDifference(root.right, max, root.val));

        return minDiff;
    }
}
// @lc code=end

