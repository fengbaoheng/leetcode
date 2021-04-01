/*
 * @lc app=leetcode.cn id=987 lang=java
 *
 * [987] 二叉树的垂序遍历
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
import java.util.stream.Collectors;


class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Node>> map = new TreeMap<>();
        search(0, 0, root, map);

        List<List<Integer>> results = new LinkedList<>();

        // 同一列的节点排序，层高再前，同层则值大在前
        map.forEach((col, nodes) -> {
            List<Integer> values = nodes.stream()
                    .sorted(Comparator.comparingInt(Node::getRow).thenComparing(Node::getValue))
                    .map(Node::getValue)
                    .collect(Collectors.toList());

            results.add(values);
        });
        return results;
    }

    // 递归搜索树
    private void search(int row, int col, TreeNode node, Map<Integer, List<Node>> map) {
        if (node == null) {
            return;
        }
        map.computeIfAbsent(col, key -> new LinkedList<>()).add(new Node(node.val, row));
        search(row + 1, col - 1, node.left, map);
        search(row + 1, col + 1, node.right, map);
    }

    private static class Node {
        final int value, row;

        public Node(int value, int row) {
            this.value = value;
            this.row = row;
        }

        public int getValue() {
            return value;
        }

        public int getRow() {
            return row;
        }
    }
}
// @lc code=end

