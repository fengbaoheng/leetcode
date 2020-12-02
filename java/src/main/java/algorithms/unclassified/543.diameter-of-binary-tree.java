/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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
// 递归求每个子树的左右子树深度
// 同时记录副产品直径 = 左子树深度 + 右子树深度
class Solution {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }

    // 求左右子树的深度
    private int depth(TreeNode root){
        if(root == null){
            return 0;
        }

        // 分别求左右深度
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        // 更新直径
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
// @lc code=end

