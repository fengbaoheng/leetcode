/*
 * @lc app=leetcode.cn id=919 lang=java
 *
 * [919] 完全二叉树插入器
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

class CBTInserter {
    private final TreeNode root;
    
    // 倒数第2层，一定是满的，其子节点未满
    private List<TreeNode> layer;
    
    // 索引
    private int index;

    public CBTInserter(TreeNode root) {
        this.root = root;
        findLastFullLayer();
    }

    public int insert(int v) {
        TreeNode newNode = new TreeNode(v);

        TreeNode parent = layer.get(index);

        if (parent.left == null) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
            expand();
        }

        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }

    private void expand() {
        index++;
        if (index < layer.size()) {
            return;
        }

        index = 0;
        List<TreeNode> nextLayer = new ArrayList<>(layer.size() * 2);
        for (TreeNode node : layer) {
            nextLayer.add(node.left);
            nextLayer.add(node.right);
        }

        this.layer = nextLayer;
    }


    // 找到最后一行满节点层
    private void findLastFullLayer() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<TreeNode> fullLayer = new LinkedList<>();
        boolean isFull = true;
        while (isFull) {
            int size = queue.size();
            fullLayer.clear();
            for (int i = 0; i < size; i++) {
                final TreeNode node = queue.poll();
                fullLayer.add(node);

                if (node.left != null) {
                    queue.add(node.left);
                } else {
                    isFull = false;
                }

                if (node.right != null) {
                    queue.add(node.right);
                } else {
                    isFull = false;
                }
            }
        }

        this.layer = new ArrayList<>(fullLayer);
        for (int i = 0; i < this.layer.size(); i++) {
            TreeNode node = this.layer.get(i);
            if (node.left == null || node.right == null) {
                this.index = i;
                break;
            }
        }
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */
// @lc code=end

