/*
 * @lc app=leetcode.cn id=1530 lang=java
 *
 * [1530] 好叶子节点对的数量
 */

// @lc code=start
class Solution {
    private int distance, count;

    public int countPairs(TreeNode root, int distance) {
        if (distance <= 1) {
            return 0;
        }

        this.distance = distance;
        this.count = 0;

        search(root);

        return this.count;
    }

    private int[] search(TreeNode root) {
        if (root == null) {
            return new int[distance];
        }

        if (root.left == null && root.right == null) {
            int[] counts = new int[distance];
            counts[1] = 1;
            return counts;
        }

        int[] left = search(root.left);
        int[] right = search(root.right);

        // 统计符合的数量
        for (int i = 1; i < distance; i++) {
            int d1 = left[i];
            for (int j = 1; j <= distance - i; j++) {
                int d2 = right[j];
                count += d1 * d2;
            }
        }

        // 更新距离
        for (int i = distance - 1; i > 0; i--) {
            left[i] = left[i - 1] + right[i - 1];
        }


        return left;
    }
}
// @lc code=end

