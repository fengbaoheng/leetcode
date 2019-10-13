/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572] 另一个树的子树
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
    // 递归判断
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // 双方均为空 则相等
        // 否则仅有一方为空则不相等
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }

        // 在子树中继续寻找是否匹配
        return isSubtreeFromRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    // 必须从根节点就开始相同
    private boolean isSubtreeFromRoot(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null || s.val != t.val) {
            // 根节点值不同
            return false;
        }

        return isSubtreeFromRoot(s.left, t.left) && isSubtreeFromRoot(s.right, t.right);
    }
}
// @lc code=end

