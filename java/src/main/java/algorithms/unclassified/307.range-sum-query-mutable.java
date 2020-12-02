/*
 * @lc app=leetcode.cn id=307 lang=java
 *
 * [307] 区域和检索 - 数组可修改
 */

// @lc code=start
public class NumArray {
    private final Node tree;

    public NumArray(int[] nums) {
        if (nums.length == 0) {
            tree = new Node(0, 0, 0);
        } else {
            tree = buildTree(nums, 0, nums.length - 1);
        }
    }

    public void update(int i, int val) {
        tree.update(i, val);
    }

    public int sumRange(int i, int j) {
        return tree.sumRange(i, j);
    }

    private Node buildTree(int[] nums, int start, int end) {
        // 叶子节点
        if (start == end) {
            return new Node(start, end, nums[start]);
        }

        // 递归构造左右子树
        int mid = (start + end) / 2;
        Node left = buildTree(nums, start, mid);
        Node right = buildTree(nums, mid + 1, end);

        return new Node(left, right);
    }
}


class Node {
    private final int L, R, M;
    private Node left, right;

    private int sum;

    public Node(int L, int R, int sum) {
        this.L = L;
        this.R = R;
        this.M = (L + R) / 2;
        this.sum = sum;
    }

    public Node(Node left, Node right) {
        this(left.L, right.R, left.sum + right.sum);
        this.left = left;
        this.right = right;
    }

    public int sumRange(int i, int j) {
        if (i == L && j == R) {
            return sum;
        }

        // 全在左侧
        if (j <= M) {
            return left.sumRange(i, j);
        }

        // 全在右侧
        if (i > M) {
            return right.sumRange(i, j);
        }

        // 拆分为左右两个子区间
        return left.sumRange(i, left.R) + right.sumRange(right.L, j);
    }


    // 从根节点开始递归向下更新
    public int update(int i, int val) {
        int diff = 0;
        if (i == L && i == R) {
            diff = val - sum;
        } else {
            Node sub = i <= M ? left : right;
            diff = sub.update(i, val);
        }

        sum += diff;

        return diff;
    }

}
// @lc code=end

