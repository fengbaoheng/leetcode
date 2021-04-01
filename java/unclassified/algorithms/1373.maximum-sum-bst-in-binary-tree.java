/*
 * @lc app=leetcode.cn id=1373 lang=java
 *
 * [1373] 二叉搜索子树的最大键值和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxSumBST(TreeNode root) {
        Tree.MAX_SUM = 0;

        search(root);

        return Tree.MAX_SUM;
    }

    private Tree search(TreeNode root) {
        if (root == null) {
            return new Tree();
        }

        // 尝试组合一颗新树
        return Tree.of(search(root.left), root.val, search(root.right));
    }

    private static class Tree {
        private static int MAX_SUM;

        private boolean isSearchTree = true;
        private int min, max, sum;

        public Tree() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }

        // 叶子节点只有单一的值
        public Tree(int val) {
            min = val;
            max = val;
            sum = val;

            MAX_SUM = Math.max(MAX_SUM, val);
        }

        private static boolean isSearchTree(Tree left, int root, Tree right) {
            return left.isSearchTree && right.isSearchTree && root > left.max && root < right.min;
        }

        public static Tree of(Tree left, int root, Tree right) {
            if (isSearchTree(left, root, right)) {
                // 构造新的搜索树
                left.min = Math.min(root, Math.min(left.min, right.min));
                left.max = Math.max(root, Math.max(left.max, right.max));
                left.sum = left.sum + root + right.sum;

                MAX_SUM = Math.max(MAX_SUM, left.sum);
            } else {
                // 无法组成新的搜索树
                left.isSearchTree = false;
            }

            return left;
        }
    }
}

// @lc code=end

