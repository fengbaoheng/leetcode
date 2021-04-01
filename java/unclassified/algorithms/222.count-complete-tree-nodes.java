/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 两子树层数
        int leftHeight = countHeight(root.left);
        int rightHeight = countHeight(root.right);

        int count = 0;
        if (leftHeight == rightHeight) {
            // 左子树满树, 左子树节点数可确定
            count = 1 + countNodes(leftHeight) + countNodes(root.right);

        } else {
            // 左子树不满, 右子树节点数可确定
            count = 1 + countNodes(root.left) + countNodes(rightHeight);
        }

        return count;
    }

    // 计算树的高度
    // 根据完全二叉树性质, 一直计算最左子树即可
    private int countHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.left;
            height++;
        }
        return height;
    }

    // 依据层数计算完全二叉树满树节点数
    private int countNodes(int height) {
        return (int) Math.pow(2, height) - 1;
    }
}

