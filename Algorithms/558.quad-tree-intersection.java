/*
 * @lc app=leetcode.cn id=558 lang=java
 *
 * [558] 四叉树交集
 */

// @lc code=start
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        // 均为叶子节点
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            boolean val = quadTree1.val || quadTree2.val;
            return new Node(val, true, null, null, null, null);
        }

        // 一个叶子节点与一颗树
        if (quadTree1.isLeaf) {
            return intersect(quadTree2, quadTree1.val);
        } else if (quadTree2.isLeaf) {
            return intersect(quadTree1, quadTree2.val);
        }


        // 两个均为树
        Node tree = new Node();
        tree.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        tree.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        tree.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        tree.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

        setLeaf(tree);

        return tree;
    }

    // 一个节点和一个叶子
    private Node intersect(Node quadTree, boolean val) {
        Node node = new Node();

        if (quadTree.isLeaf || val) {
            node.isLeaf = true;
            node.val = quadTree.val || val;
            return node;
        } else {
            return quadTree;
        }
    }

    // 设置是否为叶子节点
    private void setLeaf(Node t) {
        if (t.topLeft.isLeaf && t.topRight.isLeaf && t.bottomLeft.isLeaf && t.bottomRight.isLeaf) {
            t.isLeaf = t.topLeft.val == t.topRight.val
                    && t.topLeft.val == t.bottomLeft.val
                    && t.topLeft.val == t.bottomRight.val;

            if (t.isLeaf) {
                t.val = t.topLeft.val;
            }
        }
    }
}
// @lc code=end

