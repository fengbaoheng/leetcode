/*
 * @lc app=leetcode.cn id=101 lang=csharp
 *
 * [101] 对称二叉树
 *
 * https://leetcode-cn.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (44.29%)
 * Total Accepted:    21.6K
 * Total Submissions: 48.2K
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 * 
 * 
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 说明:
 * 
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution
{
    public bool IsSymmetric(TreeNode leftSubTree, TreeNode rightSubTree)
    {
        if (leftSubTree == null && rightSubTree == null)
        {
            return true;
        }
        else if (leftSubTree == null || rightSubTree == null)
        {
            return false;
        }
        else if (leftSubTree.val != rightSubTree.val)
        {
            return false;
        }
        else
        {
            return IsSymmetric(leftSubTree.left, rightSubTree.right) && IsSymmetric(leftSubTree.right, rightSubTree.left);
        }
    }
    public bool IsSymmetric(TreeNode root)
    {
        if (root == null) { return true; }
        return IsSymmetric(root.left, root.right);
    }
}

