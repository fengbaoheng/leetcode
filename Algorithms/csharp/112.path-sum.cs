/*
 * @lc app=leetcode.cn id=112 lang=csharp
 *
 * [112] 路径总和
 *
 * https://leetcode-cn.com/problems/path-sum/description/
 *
 * algorithms
 * Easy (43.95%)
 * Total Accepted:    10K
 * Total Submissions: 22.8K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,null,1]\n22'
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \      \
 * ⁠       7    2      1
 * 
 * 
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
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
    public bool HasPathSum(TreeNode root, int sum)
    {
        if(root == null) return false;
        
        var pathSum = new List<int>();
        var dict = new Dictionary<TreeNode, int>();
        var queue = new Queue<TreeNode>();

        dict[root] = root.val;
        queue.Enqueue(root);

        while (queue.Count != 0)
        {
            var node = queue.Dequeue();

            if (node.left != null)
            {
                queue.Enqueue(node.left);
                dict[node.left] = dict[node] + node.left.val;
            }

            if (node.right != null)
            {
                queue.Enqueue(node.right);
                dict[node.right] = dict[node] + node.right.val;
            }

            if (node.left == null && node.right == null)
            {
                pathSum.Add(dict[node]);
            }
        }


        return pathSum.Contains(sum);
    }
}
