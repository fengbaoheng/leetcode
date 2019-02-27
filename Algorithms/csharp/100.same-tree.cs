/*
 * @lc app=leetcode.cn id=100 lang=csharp
 *
 * [100] 相同的树
 *
 * https://leetcode-cn.com/problems/same-tree/description/
 *
 * algorithms
 * Easy (50.45%)
 * Total Accepted:    14.5K
 * Total Submissions: 28.4K
 * Testcase Example:  '[1,2,3]\n[1,2,3]'
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 
 * 示例 1:
 * 
 * 输入:     1         1
 * ⁠         / \       / \
 * ⁠        2   3     2   3
 * 
 * ⁠       [1,2,3],   [1,2,3]
 * 
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入:      1          1
 * ⁠         /           \
 * ⁠        2             2
 * 
 * ⁠       [1,2],     [1,null,2]
 * 
 * 输出: false
 * 
 * 
 * 示例 3:
 * 
 * 输入:     1         1
 * ⁠         / \       / \
 * ⁠        2   1     1   2
 * 
 * ⁠       [1,2,1],   [1,1,2]
 * 
 * 输出: false
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
    public bool IsSameTree(TreeNode p, TreeNode q)
    {
        // 存在空树
        if (p == null || q == null)
        {
            return p == null && q == null ? true : false;
        }

        // 两颗树都不为空
        var pQueue = new Queue<TreeNode>();
        var qQueue = new Queue<TreeNode>();

        pQueue.Enqueue(p);
        qQueue.Enqueue(q);

        while (pQueue.Count != 0 && qQueue.Count != 0)
        {
            var pTop = pQueue.Dequeue();
            var qTop = qQueue.Dequeue();

            if (pTop == null && qTop == null)
            {
                continue;
            }
            else if (pTop == null || qTop == null)
            {
                return false;
            }
            else if (pTop.val != qTop.val)
            {
                return false;
            }
            else
            {
                pQueue.Enqueue(pTop.left);
                pQueue.Enqueue(pTop.right);
                qQueue.Enqueue(qTop.left);
                qQueue.Enqueue(qTop.right);
            }
        }

        return true;
    }
}

