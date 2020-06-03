/*
 * @lc app=leetcode.cn id=863 lang=java
 *
 * [863] 二叉树中所有距离为 K 的结点
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
    int K;
    TreeNode target;
    List<Integer> results;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        this.target = target;
        this.K = K;
        this.results = new LinkedList<>();

        if (K == 0) {
            results.add(target.val);
        } else {
            findTarget(root);
        }

        return results;
    }

    private int findTarget(TreeNode root) {
        if (root == null) {
            return -1;
        }

        if (root == target) {
            int distance = K - 1;
            findDistance(root.left, distance);
            findDistance(root.right, distance);
            return distance;
        }

        int leftDistance = findTarget(root.left);
        int rightDistance = findTarget(root.right);

        if (leftDistance == 0 || rightDistance == 0) {
            results.add(root.val);
        } else if (leftDistance != -1) {
            findDistance(root.right, leftDistance - 1);
            return leftDistance - 1;
        } else if (rightDistance != -1) {
            findDistance(root.left, rightDistance - 1);
            return rightDistance - 1;
        }

        return -1;
    }

    private void findDistance(TreeNode root, int distance) {
        if (root == null) {
            return;
        }

        if (distance == 0) {
            results.add(root.val);
        } else {
            findDistance(root.left, distance - 1);
            findDistance(root.right, distance - 1);
        }
    }
}
// @lc code=end

