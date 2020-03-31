/*
 * @lc app=leetcode.cn id=1379 lang=java
 *
 * [1379] 找出克隆二叉树中的相同节点
 */

// @lc code=start
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        // 递归结束判断
        if (original == null || cloned == null || target == null) {
            return null;
        }

        // 找到目标节点
        if (original == target) {
            return cloned;
        }

        // 递归搜索
        TreeNode findLeft = getTargetCopy(original.left, cloned.left, target);
        if (findLeft != null) {
            return findLeft;
        }

        TreeNode findRight = getTargetCopy(original.right, cloned.right, target);
        if (findRight != null) {
            return findRight;
        }

        return null;
    }
}
// @lc code=end

