/*
 * @lc app=leetcode.cn id=107 lang=csharp
 *
 * [107] 二叉树的层次遍历 II
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (57.96%)
 * Total Accepted:    10K
 * Total Submissions: 17K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其自底向上的层次遍历为：
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
 * 
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
    public IList<IList<int>> LevelOrderBottom(TreeNode root)
    {
        var list = new List<IList<int>>();
        if (root == null) { return list; }

        var nodeQueue = new Queue<TreeNode>();
        var depthQueue = new Queue<int>();
        nodeQueue.Enqueue(root);
        depthQueue.Enqueue(1);

        var depth = 1;
        var valueList = new List<int>();

        while (nodeQueue.Count != 0)
        {
            var node = nodeQueue.Dequeue();
            var nodeDepth = depthQueue.Dequeue();

            if (depth != nodeDepth)
            {
                depth = nodeDepth;
                list.Add(valueList);
                valueList = new List<int>();
            }

            valueList.Add(node.val);

            if (node.left != null)
            {
                depthQueue.Enqueue(depth + 1);
                nodeQueue.Enqueue(node.left);
            }

            if (node.right != null)
            {
                depthQueue.Enqueue(depth + 1);
                nodeQueue.Enqueue(node.right);
            }
        }

        list.Add(valueList);
        list.Reverse();

        return list;
    }
}

