/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
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
import java.util.*;

class Solution {
    private Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (map.containsKey(root)) {
            return map.get(root);
        }

        // 根节点 + 4个子树的子节点
        int robSubLeft = root.left == null ? 0 : rob(root.left.left) + rob(root.left.right);
        int robSubRight = root.right == null ? 0 : rob(root.right.left) + rob(root.right.right);
        int result1 = root.val + robSubLeft + robSubRight;

        // 两个子树
        int result2 = rob(root.left) + rob(root.right);

        int result = Math.max(result1, result2);
        map.put(root, result);

        return result;
    }
}

