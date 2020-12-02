/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int countFromRoot = pathSumFromRoot(root, sum);
        int count = pathSum(root.left, sum) + pathSum(root.right, sum);

        return countFromRoot + count;
    }

    // 路径从根节点开始计算
    private int pathSumFromRoot(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int base = root.val == sum ? 1 : 0;

        int sub = sum - root.val;
        return base + pathSumFromRoot(root.left, sub) + pathSumFromRoot(root.right, sub);
    }
}
// @lc code=end

