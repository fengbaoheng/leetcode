/*
 * @lc app=leetcode.cn id=872 lang=java
 *
 * [872] 叶子相似的树
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
import java.util.*;

class Solution {
    // 获取叶子节点后比较
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return  getLeaf(root1).equals(getLeaf(root2));
    }

    // 获取叶子节点
    private List<Integer> getLeaf(TreeNode root) {
        List<Integer> leaf = new ArrayList<>();

        if (root == null) {
            return leaf;
        } else if (root.left == null && root.right == null) {
            leaf.add(root.val);
        } else {
            leaf.addAll(getLeaf(root.left));
            leaf.addAll(getLeaf(root.right));
        }

        return leaf;
    }
}
// @lc code=end

