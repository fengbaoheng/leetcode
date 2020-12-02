/*
 * @lc app=leetcode.cn id=1028 lang=java
 *
 * [1028] 从先序遍历还原二叉树
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
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public TreeNode recoverFromPreorder(String S) {
        Queue<Node> nodes = getNodes(S);

        if (nodes.isEmpty()) {
            return null;
        }

        Node root = nodes.poll();
        recoverTree(root, nodes);

        return root.treeNode;
    }

    // 依据字符串生成节点
    private Queue<Node> getNodes(String S) {
        char[] arr = S.toCharArray();
        Queue<Node> queue = new LinkedList<>();

        int p = 0;
        while (p < arr.length) {
            int depth = 0;
            while (p < arr.length && arr[p] == '-') {
                depth++;
                p++;
            }

            int val = 0;
            while (p < arr.length && arr[p] != '-') {
                int num = arr[p] - '0';
                val = val * 10 + num;
                p++;
            }
            
            queue.offer(new Node(depth, val));
        }

        return queue;
    }

    // 依据节点恢复树
    private void recoverTree(Node root, Queue<Node> nodes) {
        if (nodes.isEmpty() || nodes.element().depth <= root.depth) {
            return;
        }

        Node left = nodes.poll();
        recoverTree(left, nodes);
        root.treeNode.left = left.treeNode;

        if (nodes.isEmpty() || nodes.element().depth <= root.depth) {
            return;
        }

        Node right = nodes.poll();
        recoverTree(right, nodes);
        root.treeNode.right = right.treeNode;
    }
}

class Node {
    public final int depth;
    public final TreeNode treeNode;

    public Node(int depth, int val) {
        this.depth = depth;
        this.treeNode = new TreeNode(val);
    }
}
// @lc code=end

