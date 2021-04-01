/*
 * @lc app=leetcode.cn id=958 lang=java
 *
 * [958] 二叉树的完全性检验
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
import java.util.*;


class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        // 记录第一个子节点为null的索引
        int nullIndex = Integer.MAX_VALUE;
        
        // 层序遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();


                if (node.left != null) {
                    queue.offer(node.left);
                } else {
                    nullIndex = Math.min(nullIndex, 2 * i);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                } else {
                    nullIndex = Math.min(nullIndex, 2 * i + 1);
                }
            }

            // 发现了非完全节点，判断是否为最后一行
            if (nullIndex != Integer.MAX_VALUE) {
                return nullIndex == queue.size() && isEndLayer(queue);
            }
        }

        return true;
    }

    // 判断所有节点都没有子节点，即为最后一行节点
    private boolean isEndLayer(Queue<TreeNode> queue) {
        return queue
                .stream()
                .allMatch(node -> node.left == null && node.right == null);
    }
}
// @lc code=end

