/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
 */

// @lc code=start
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        // 空树
        if (root == null) {
            return 0;
        }

        // 非空树，宽度至少是1
        int maxLength = 1;

        // 层序遍历同时记录节点和索引值
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        Deque<Integer> indexQueue = new ArrayDeque<>();
        nodeQueue.add(root);
        indexQueue.add(1);

        while (!nodeQueue.isEmpty()) {
            // 计算本层的宽度（左右两端的索引）并更新
            int left = indexQueue.peekFirst();
            int right = indexQueue.peekLast();
            maxLength = Math.max(maxLength, right - left + 1);

            // 层序遍历
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.poll();
                int index = indexQueue.poll();

                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    indexQueue.offer(index * 2);
                }

                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    indexQueue.offer(index * 2 + 1);
                }
            }
        }

        return maxLength;
    }
}
// @lc code=end

