/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            // 层序遍历, 每一层遍历除了最右侧节点之外的节点
            for (int i = 0; i < size - 1; i++) {
                Node node = queue.poll();

                node.next = queue.peek();

                addChildren(node, queue);
            }

            // 处理最右侧节点
            Node rightNode = queue.poll();
            rightNode.next = null;
            addChildren(rightNode, queue);
        }

        return root;
    }


    private void addChildren(Node root, Queue<Node> queue) {
        Optional.ofNullable(root.left).ifPresent(queue::offer);
        Optional.ofNullable(root.right).ifPresent(queue::offer);
    }
}
// @lc code=end

