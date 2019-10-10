/*
 * @lc app=leetcode.cn id=836 lang=java
 *
 * [836] 矩形重叠
 */

// @lc code=start
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        Rectangle recA = new Rectangle(rec1);
        Rectangle recB = new Rectangle(rec2);

        if (recA.isValid() || recB.isValid()) {
            return false;
        }

        Rectangle left = Rectangle.getLeft(recA, recB);
        Rectangle right = Rectangle.getRight(recA, recB);

        // 两个矩形水平无交集 必定不相交
        if (left.rightX <= right.leftX) {
            return false;
        }

        // 水平有交集 但垂直无交集
        if (right.bottomY >= left.topY || right.topY <= left.bottomY) {
            return false;
        }

        return true;
    }
}


class Rectangle {
    final int leftX, bottomY, rightX, topY;

    Rectangle(int[] rec) {
        this.leftX = rec[0];
        this.bottomY = rec[1];
        this.rightX = rec[2];
        this.topY = rec[3];
    }

    // 获取两个矩形中左边的矩形
    static Rectangle getLeft(Rectangle r1, Rectangle r2) {
        return r1.leftX < r2.leftX ? r1 : r2;
    }

    // 获取两个矩形中右边的矩形
    static Rectangle getRight(Rectangle r1, Rectangle r2) {
        return r1.leftX < r2.leftX ? r2 : r1;
    }

    // 矩形是否有效
    boolean isValid() {
        return this.rightX <= this.leftX || this.topY <= this.bottomY;
    }
}
// @lc code=end

