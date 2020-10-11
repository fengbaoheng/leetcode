/*
 * @lc app=leetcode.cn id=1609 lang=java
 *
 * [1609] 奇偶树
 */

// @lc code=start
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        // 层序遍历，抽出每一行节点数值进行验证
        List<Integer> rowValues = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                rowValues.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            if (!isValid(level, rowValues)) {
                return false;
            }

            // 遍历下一行
            level++;
            rowValues.clear();
        }

        return true;
    }

    // 校验一行数字
    private boolean isValid(int level, Collection<Integer> values) {
        if (values.isEmpty()) {
            return true;
        }

        return level % 2 == 0 ? isValidEven(values) : isValidOdd(values);
    }

    // 校验奇数行
    private boolean isValidOdd(Collection<Integer> values) {
        int last = Integer.MAX_VALUE;
        for (int value : values) {
            // 全部偶数
            if (value % 2 == 1) {
                return false;
            }

            // 严格递减
            if (value >= last) {
                return false;
            }

            last = value;
        }

        return true;
    }

    // 校验偶数行
    private boolean isValidEven(Collection<Integer> values) {
        int last = Integer.MIN_VALUE;
        for (int value : values) {
            // 全部奇数
            if (value % 2 == 0) {
                return false;
            }

            // 严格递增
            if (value <= last) {
                return false;
            }

            last = value;
        }

        return true;
    }
}
// @lc code=end

