#
# @lc app=leetcode.cn id=54 lang=python3
#
# [54] 螺旋矩阵
#
# https://leetcode-cn.com/problems/spiral-matrix/description/
#
# algorithms
# Medium (34.56%)
# Total Accepted:    11.5K
# Total Submissions: 33.2K
# Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
#
# 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
#
# 示例 1:
#
# 输入:
# [
# ⁠[ 1, 2, 3 ],
# ⁠[ 4, 5, 6 ],
# ⁠[ 7, 8, 9 ]
# ]
# 输出: [1,2,3,6,9,8,7,4,5]
#
#
# 示例 2:
#
# 输入:
# [
# ⁠ [1, 2, 3, 4],
# ⁠ [5, 6, 7, 8],
# ⁠ [9,10,11,12]
# ]
# 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
#
#
#
from typing import List


class Solution:
    # 一圈一圈向内递归
    # 每一圈分为上下行 左右列进行拼接
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        self.matrix = matrix

        # 矩阵行数
        self.row = len(matrix)
        if self.row == 0:
            return []

        # 矩阵列数
        self.col = len(matrix[0])
        if self.col == 0:
            return []

        # od点
        self.o_row = 0
        self.d_row = self.row - 1
        self.o_col = 0
        self.d_col = self.col - 1

        # 循环获取螺旋
        self.spiral = []
        while self.get_spiral():
            pass

        return self.spiral

    # 获取螺旋
    def get_spiral(self) -> bool:
        if self.o_row > self.d_row or self.o_col > self.d_col:
            return False

        up_row = self.matrix[self.o_row][self.o_col : self.d_col + 1]

        down_row = self.matrix[self.d_row][self.o_col : self.d_col + 1]
        down_row = down_row[::-1]  # 底部顺时针为从右到左

        right_col = [
            self.matrix[row][self.d_col] for row in range(self.o_row + 1, self.d_row)
        ]

        left_col = [
            self.matrix[row][self.o_col] for row in range(self.o_row + 1, self.d_row)
        ]
        left_col = left_col[::-1]

        # 考虑特殊情况
        tmp_sprial = []
        if self.o_row == self.d_row:
            tmp_sprial = up_row
        elif self.o_row + 1 == self.d_row:
            tmp_sprial = up_row + down_row
        elif self.o_col == self.d_col:
            tmp_sprial = up_row + right_col + down_row
        else:
            tmp_sprial = up_row + right_col + down_row + left_col

        self.spiral.extend(tmp_sprial)

        self.o_row += 1
        self.d_row -= 1
        self.o_col += 1
        self.d_col -= 1

        return True


if __name__ == "__main__":
    print(Solution().spiralOrder([[3,2],[4,5]]))

