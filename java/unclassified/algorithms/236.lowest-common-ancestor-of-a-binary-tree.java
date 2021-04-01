/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归结束
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        // 在左侧查找
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // 在右侧查找
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 在左右均查找到
        if (left != null && right != null) {
            return root;
        }

        // 只有一侧查找到
        return left == null ? right : left;
    }
}
// @lc code=end

