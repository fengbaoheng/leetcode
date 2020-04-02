/*
 * @lc app=leetcode.cn id=783 lang=java
 *
 * [783] 二叉搜索树结点最小距离
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
    private Integer pre;
    private int minDiff;

    public int minDiffInBST(TreeNode root) {
        pre = null;
        minDiff = Integer.MAX_VALUE;

        midOrder(root);

        return minDiff;

    }

    private void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        midOrder(root.left);

        if (pre != null) {
            minDiff = Math.min(minDiff, root.val - pre);
        }
        pre = root.val;

        midOrder(root.right);
    }
}
// @lc code=end

