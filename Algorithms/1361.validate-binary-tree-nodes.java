/*
 * @lc app=leetcode.cn id=1361 lang=java
 *
 * [1361] 验证二叉树
 */

// @lc code=start
import java.util.*;

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // 记录每个节点的父节点
        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        for (int i = 0; i < n; i++) {
            int[] children = new int[]{leftChild[i], rightChild[i]};
            for (int child : children) {
                if (child != -1) {
                    // 不可能有两个父节点
                    if (parents[child] != -1) {
                        return false;
                    }
                    // 设置父节点
                    parents[child] = i;
                }
            }
        }

        // 寻找根节点
        // 整棵树必须有且仅有1个根节点, 即其没有父节点
        int rootCount = 0;
        for (int i = 0; i < n; i++) {
            if (parents[i] == -1) {
                rootCount++;
            }
        }

        return rootCount == 1;
    }
}
// @lc code=end

