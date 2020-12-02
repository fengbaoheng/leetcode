/*
 * @lc app=leetcode.cn id=889 lang=java
 *
 * [889] 根据前序和后序遍历构造二叉树
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    // 递归创建树
    // 前序遍历头结点在首位
    // 后序遍历头结点在末位
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int len = pre.length;
        if (len == 0) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);

        if (len == 1) {
            return root;
        }

        // 依据头结点位置
        // 找到左右子树元素的切分位置
        // leftHead = pre[1]
        int index = indexOf(post, pre[1]);

        // 左子树的前序和后序遍历数组
        int[] leftPre = Arrays.copyOfRange(pre, 1, 2 + index);
        int[] leftPost = Arrays.copyOfRange(post, 0, index + 1);
        
        // 右子树的前序和后序遍历数组
        int[] rightPre = Arrays.copyOfRange(pre, 2 + index, pre.length);
        int[] rightPost = Arrays.copyOfRange(post, index + 1, post.length-1);

        // 递归创建子树
        root.left = constructFromPrePost(leftPre, leftPost);
        root.right = constructFromPrePost(rightPre, rightPost);

        return root;
    }

    // 查找元素位置
    private int indexOf(int[] post, int val) {
        for (int i = 0; i < post.length; i++) {
            if (post[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

