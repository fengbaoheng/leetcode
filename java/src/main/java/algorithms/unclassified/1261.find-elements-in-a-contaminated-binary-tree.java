/*
 * @lc app=leetcode.cn id=1261 lang=java
 *
 * [1261] 在受污染的二叉树中查找元素
 */

// @lc code=start
import java.util.*;


class FindElements {
    private TreeNode root;
    private Set<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        this.root = root;
        recover(root, 0);
    }

    public boolean find(int target) {
        return set.contains(target);
    }

    // 递归恢复树
    private void recover(TreeNode root, int val) {
        if (root == null) {
            return;
        }

        set.add(val);
        root.val = val;

        int doubleVal = val << 1;
        recover(root.left, doubleVal + 1);
        recover(root.right, doubleVal + 2);
    }
}
// @lc code=end

