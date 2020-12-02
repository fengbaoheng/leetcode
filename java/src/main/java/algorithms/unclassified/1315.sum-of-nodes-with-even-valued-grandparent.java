/*
 * @lc app=leetcode.cn id=1315 lang=java
 *
 * [1315] 祖父节点值为偶数的节点和
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
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return sumEvenGrandparent(root, false);
    }

    /**
     * 求节点和
     *
     * @param node         节点
     * @param parentIsEven 父节点是否为偶数
     * @return 节点和
     */
    private int sumEvenGrandparent(TreeNode node, boolean parentIsEven) {
        // 当前节点是否为偶数
        boolean nodeIsEven = node.val % 2 == 0;
        int sum = 0;
        TreeNode[] children = new TreeNode[]{node.left, node.right};
        for (TreeNode n : children) {
            if (n == null) {
                continue;
            }
            // 依据父节点偶数性质判断子节点值是否累加
            sum += parentIsEven ? n.val : 0;
            // 递归累积和
            sum += sumEvenGrandparent(n, nodeIsEven);
        }

        return sum;
    }
}
// @lc code=end

