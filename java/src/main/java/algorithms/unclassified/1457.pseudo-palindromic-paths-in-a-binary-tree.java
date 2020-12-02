/*
 * @lc app=leetcode.cn id=1457 lang=java
 *
 * [1457] 二叉树中的伪回文路径
 */

// @lc code=start
class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        return pseudoPalindromicPaths(root, new int[10]);
    }

    // 回溯，记录路径
    private int pseudoPalindromicPaths(TreeNode root, int[] counts) {
        if (root == null) {
            return 0;
        }

        int val = root.val;
        counts[val]++;

        int result = 0;
        if (isLeaf(root)) {
            result = isPalindromicPath(counts) ? 1 : 0;
        } else {
            result += pseudoPalindromicPaths(root.left, counts);
            result += pseudoPalindromicPaths(root.right, counts);
        }

        counts[val]--;

        return result;
    }

    // 判断是否是叶子节点
    private boolean isLeaf(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }

    // 判断路径是否为伪回文路径
    private boolean isPalindromicPath(int[] counts) {
        int oddCount = 0;
        for (int count : counts) {
            if (count % 2 == 1) {
                oddCount++;
                if (oddCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

