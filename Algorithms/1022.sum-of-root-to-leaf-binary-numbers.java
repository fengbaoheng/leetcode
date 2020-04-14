/*
 * @lc app=leetcode.cn id=1022 lang=java
 *
 * [1022] 从根到叶的二进制数之和
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
    private static final int M = (int) (1e10 + 7);

    public int sumRootToLeaf(TreeNode root) {
        return (int) sumRootToLeaf(root, 0);
    }

    private long sumRootToLeaf(TreeNode root, long bin) {
        if (root == null) {
            return 0;
        }

        // 到达本节点处的二进制数值
        bin = (bin * 2 + root.val) % M;

        // 叶子节点
        if (root.left == null && root.right == null) {
            return bin;
        }

        // 非叶子节点,递归调用
        long left = sumRootToLeaf(root.left, bin);
        long right = sumRootToLeaf(root.right, bin);

        return (left + right) % M;
    }
}
// @lc code=end

