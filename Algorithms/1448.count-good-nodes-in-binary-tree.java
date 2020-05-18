/*
 * @lc app=leetcode.cn id=1448 lang=java
 *
 * [1448] 统计二叉树中好节点的数目
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int count;

    public int goodNodes(TreeNode root) {
        count = 0;
        goodNodes(root, Integer.MIN_VALUE);
        return count;
    }

    private void goodNodes(TreeNode root, int max) {
        if (root == null) {
            return;
        }

        if (root.val >= max) {
            count++;
            max = root.val;
        }

        goodNodes(root.left, max);
        goodNodes(root.right, max);
    }
}
// @lc code=end

