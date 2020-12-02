/*
 * @lc app=leetcode.cn id=1305 lang=java
 *
 * [1305] 两棵二叉搜索树中的所有元素
 */

// @lc code=start
import java.util.*;

class Solution {
    // 中序遍历并合并
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = toList(root1);
        List<Integer> list2 = toList(root2);
        List<Integer> results = new LinkedList<>();

        int i = 0, j = 0;
        for (; i < list1.size(); i++) {
            int v1 = list1.get(i);

            for (; j < list2.size(); j++) {
                int v2 = list2.get(j);
                if (v1 <= v2) {
                    break;
                }
                results.add(v2);
            }

            results.add(v1);
        }

        for (; j < list2.size(); j++) {
            results.add(list2.get(j));
        }

        return results;
    }

    private List<Integer> toList(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    // 中序遍历
    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traversal(root.left, list);
        list.add(root.val);
        traversal(root.right, list);
    }
}
// @lc code=end

