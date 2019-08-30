/*
 * @lc app=leetcode.cn id=606 lang=java
 *
 * [606] 根据二叉树创建字符串
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
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();

        tree2str(t, stringBuilder);

        return stringBuilder.toString();
    }


    private void tree2str(TreeNode t, StringBuilder stringBuilder) {
        if (t.left == null && t.right == null) {
            // 左右都为空
            stringBuilder.append(t.val);
        } else if (t.left == null) {
            // 左为空
            stringBuilder.append(t.val);
            stringBuilder.append("()(");
            tree2str(t.right, stringBuilder);
            stringBuilder.append(")");
        } else if (t.right == null) {
            // 右为空
            stringBuilder.append(t.val);
            stringBuilder.append("(");
            tree2str(t.left, stringBuilder);
            stringBuilder.append(")");
        } else {
            // 左右都不为空
            stringBuilder.append(t.val);
            stringBuilder.append("(");
            tree2str(t.left, stringBuilder);
            stringBuilder.append(")(");
            tree2str(t.right, stringBuilder);
            stringBuilder.append(")");
        }
    }
}

