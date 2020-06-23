/*
 * @lc app=leetcode.cn id=427 lang=java
 *
 * [427] 建立四叉树
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

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        if (n == 1) {
            return new Node(grid[0][0] == 1, true);
        }

        Node[][] G = new Node[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                G[r][c] = new Node(grid[r][c] == 1, true);
            }
        }

        return construct(G);
    }

    private Node construct(Node[][] grid) {
        int n = grid.length;

        // 只剩1个根节点
        if (n == 1) {
            return grid[0][0];
        }

        // 合并
        int m = n / 2;
        Node[][] G = new Node[m][m];

        for (int r = 0; r < n; r += 2) {
            for (int c = 0; c < n; c += 2) {
                Node topLeft = grid[r][c];
                Node topRight = grid[r][c + 1];
                Node bottomLeft = grid[r + 1][c];
                Node bottomRight = grid[r + 1][c + 1];

                int i = r / 2;
                int j = c / 2;
                G[i][j] = combine(topLeft, topRight, bottomLeft, bottomRight);
            }
        }


        return construct(G);
    }

    private Node combine(Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
            if (topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
                return new Node(topLeft.val, true);
            }
        }

        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
// @lc code=end

