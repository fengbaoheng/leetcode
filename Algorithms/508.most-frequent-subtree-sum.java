/*
 * @lc app=leetcode.cn id=508 lang=java
 *
 * [508] 出现次数最多的子树元素和
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
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> count = new HashMap<>();
        findFrequentTreeSum(root, count);

        int maxValue = count.values()
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);

        return count.keySet()
                .stream()
                .filter(key -> count.get(key).equals(maxValue))
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int findFrequentTreeSum(TreeNode root, Map<Integer, Integer> count) {
        if (root == null) {
            return 0;
        }

        int left = findFrequentTreeSum(root.left, count);
        int right = findFrequentTreeSum(root.right, count);

        int value = root.val + left + right;
        count.merge(value, 1, Integer::sum);

        return value;
    }
}
// @lc code=end

