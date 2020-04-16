/*
 * @lc app=leetcode.cn id=1026 lang=java
 *
 * [1026] 节点与其祖先之间的最大差值
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
    private int diff;

    public int maxAncestorDiff(TreeNode root) {
        this.diff = Integer.MIN_VALUE;
        maxDiff(root);
        return this.diff;
    }

    // 最小值，最大值
    private Integer[] maxDiff(TreeNode root) {
        if (root == null) {
            return new Integer[2];
        }

        int val = root.val;
        Integer[] left = maxDiff(root.left);
        Integer[] right = maxDiff(root.right);

        Integer[] children = {
                left[0], left[1], right[0], right[1]
        };

        int min = val;
        int max = val;

        for (Integer child : children) {
            if (child == null) {
                continue;
            }
            diff = Math.max(diff, Math.abs(val - child));
            min = Math.min(min, child);
            max = Math.max(max, child);
        }

        return new Integer[]{min, max};
    }
}
// @lc code=end

