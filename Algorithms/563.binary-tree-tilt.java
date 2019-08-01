/*
 * @lc app=leetcode.cn id=563 lang=java
 *
 * [563] 二叉树的坡度
 */
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
    public int findTilt(TreeNode root) {

        int[] result = findTiltAndSum(root);
        return result[0];
    }

    private int[] findTiltAndSum(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = findTiltAndSum(root.left);
        int[] right = findTiltAndSum(root.right);

        int treeSum = root.val + left[1] + right[1];

        int rootTilt = Math.abs(left[1] - right[1]);
        int treeTilt = rootTilt + left[0] + right[0];

        return new int[]{treeTilt, treeSum};
    }
}

