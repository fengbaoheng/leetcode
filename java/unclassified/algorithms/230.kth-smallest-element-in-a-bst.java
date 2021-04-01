/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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
    
    // 记录查找结果
    int k;
    int result;
    int searched = 0;
    boolean finished = false;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        this.searched = 0;

        kthSmallest(root);

        return result;
    }


    // 递归查找
    private void kthSmallest(TreeNode root) {
        // 判断是否继续
        if (finished || root == null) {
            return;
        }

        kthSmallest(root.left);

        // 在左子树中找到
        if(finished){
            return;
        }

        // 判断是否为根节点
        searched++;
        if(searched == k){
            finished = true;
            result = root.val;
            return;
        }

        // 继续在右子树查找
        kthSmallest(root.right);
    }
}
// @lc code=end

