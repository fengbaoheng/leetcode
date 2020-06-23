/*
 * @lc app=leetcode.cn id=865 lang=java
 *
 * [865] 具有所有最深结点的最小子树
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
    int maxDepth = Integer.MIN_VALUE;
    TreeNode maxTree = null;


    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        getDepthTree(root, 0);
        return maxTree;
    }

    private int getDepthTree(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }

        int left = getDepthTree(root.left, depth + 1);
        int right = getDepthTree(root.right, depth + 1);

        if (left != right) {
            return Math.max(left, right);
        }

        if (left >= maxDepth) {
            maxDepth = left;
            maxTree = root;
        }

        return left;
    }
}
// @lc code=end

