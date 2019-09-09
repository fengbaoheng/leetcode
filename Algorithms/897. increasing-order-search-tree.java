
/*
 * @lc app=leetcode.cn id=897 lang=java
 *
 * [897] 递增顺序查找树
 */
import java.util.*;

class Solution {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 使用栈进行中序遍历
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        TreeNode tmp = new TreeNode(-1);
        TreeNode tail = tmp;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.left == null && node.right == null) {
                tail.right = node;
                tail = tail.right;
            } else {
                TreeNode leftNode = node.left;
                node.left = null;

                TreeNode rightNode = node.right;
                node.right = null;

                if (rightNode != null) {
                    stack.push(rightNode);
                }

                stack.push(node);

                if (leftNode != null) {
                    stack.push(leftNode);
                }
            }
        }

        return tmp.right;
    }
}