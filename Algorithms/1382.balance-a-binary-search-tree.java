/*
 * @lc app=leetcode.cn id=1382 lang=java
 *
 * [1382] 将二叉搜索树变平衡
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
import java.util.ArrayList;
import java.util.List;

class Solution {
    List<TreeNode> nodes;

    public TreeNode balanceBST(TreeNode root) {
        nodes = new ArrayList<>();
        getNodes(root);
        return create(0, nodes.size() - 1);
    }

    private void getNodes(TreeNode root) {
        if (root == null) {
            return;
        }

        getNodes(root.left);
        nodes.add(root);
        getNodes(root.right);
        root.left = null;
        root.right = null;
    }

    private TreeNode create(int start, int end) {
        if (end < start) {
            return null;
        }

        if (start == end) {
            return nodes.get(start);
        }

        int mid = (start + end) / 2;
        TreeNode node = nodes.get(mid);
        node.left = create(start, mid - 1);
        node.right = create(mid + 1, end);
        return node;
    }
}
// @lc code=end

