/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    private int maxPath;

    public int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;

        findPath(root);

        return maxPath;
    }

    private int findPath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftPath = findPath(root.left);
        int rightPath = findPath(root.right);

        // 左右路径连接
        // 不能作为函数返回值
        int fullPath = leftPath + root.val + rightPath;
        maxPath = Math.max(maxPath, fullPath);

        // 找到最大的返回值
        // 1. 路径只包含根节点值
        int path = root.val;

        // 2. 右路径 + 根节点
        path = Math.max(path, rightPath + root.val);

        // 3. 左路径 + 根节点
        path = Math.max(path, leftPath + root.val);

        maxPath = Math.max(maxPath, path);

        return path;
    }
}
// @lc code=end

