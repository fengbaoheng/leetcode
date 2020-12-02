/*
 * @lc app=leetcode.cn id=653 lang=java
 *
 * [653] 两数之和 IV - 输入 BST
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
    public boolean findTarget(TreeNode root, int k) {
        // 记录搜索过的和期待数字
        Set<Integer> searched = new HashSet<>();
        Set<Integer> expected = new HashSet<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }
            int val = node.val;
            int rest = k - val;

            if (expected.contains(val) || searched.contains(rest)) {
                return true;
            }

            searched.add(val);
            expected.add(rest);

            queue.add(node.left);
            queue.add(node.right);
        }

        return false;
    }
}
// @lc code=end

