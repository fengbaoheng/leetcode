/*
 * @lc app=leetcode.cn id=993 lang=java
 *
 * [993] 二叉树的堂兄弟节点
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
    private int x, y;
    private int xLevel, yLevel;
    private TreeNode xParent, yParent;

    private Queue<TreeNode> queue = new LinkedList<>();

    // 判断是否为x或y节点
    // 若是则记录其层数和父节点
    private void check(TreeNode node, TreeNode parent, int level) {
        if (node.val == x) {
            xLevel = level;
            xParent = parent;
        }
        if (node.val == y) {
            yLevel = level;
            yParent = parent;
        }
    }


    // 二叉树的层序遍历
    // 判断父节点是否相同
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        // x或y 有一个在根节点 则必不可能是堂兄弟
        if (root.val == x || root.val == y) {
            return false;
        }

        this.x = x;
        this.y = y;

        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            
            // 逐层遍历
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;

                if (left != null) {
                    queue.offer(left);
                    check(left, node, level);
                }

                if (right != null) {
                    queue.offer(right);
                    check(right, node, level);
                }
            }

            // 已经找到x, y
            if (xParent != null && yParent != null) {
                return xLevel == yLevel && xParent != yParent;
            }

            level++;
        }

        // 遍历完未找到x y节点
        return false;
    }

}
