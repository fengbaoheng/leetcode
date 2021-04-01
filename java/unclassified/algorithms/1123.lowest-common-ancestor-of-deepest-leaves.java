/*
 * @lc app=leetcode.cn id=1123 lang=java
 *
 * [1123] 最深叶节点的最近公共祖先
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
    // 记录每个节点的深度
    Map<TreeNode, Integer> depthMap = new HashMap<>();

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 比较左右子树的深度
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        // 如果深度相同则返回根节点
        if (leftDepth == rightDepth) {
            return root;
        }

        // 否则递归执行较长子树
        TreeNode longTree = leftDepth > rightDepth ? root.left : root.right;
        return lcaDeepestLeaves(longTree);

    }


    // 获取树深度
    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 已经计算过长度
        if (depthMap.containsKey(node)) {
            return depthMap.get(node);
        }

        int depth = Math.max(getDepth(node.left), getDepth(node.right)) + 1;

        depthMap.put(node, depth);

        return depth;
    }
}

