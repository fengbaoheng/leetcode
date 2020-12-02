#
# @lc app=leetcode.cn id=289 lang=python3
#
# [289] 生命游戏
#
# https://leetcode-cn.com/problems/game-of-life/description/
#
# algorithms
# Medium (60.47%)
# Total Accepted:    2.1K
# Total Submissions: 3.4K
# Testcase Example:  '[[0,1,0],[0,0,1],[1,1,1],[0,0,0]]'
#
# 根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。
# 
# 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 live（1）即为活细胞， 或
# dead（0）即为死细胞。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
# 
# 
# 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
# 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
# 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
# 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
# 
# 
# 
# 根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
# 
# 示例:
# 
# 输入: 
# [
# [0,1,0],
# [0,0,1],
# [1,1,1],
# [0,0,0]
# ]
# 输出: 
# [
# [0,0,0],
# [1,0,1],
# [0,1,1],
# [0,1,0]
# ]
# 
# 进阶:
# 
# 
# 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
# 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
# 
# 
#
from typing import List


class Solution:
    ROW_NUM = -1
    COL_NUM = -1
    BOARD = []
    VECTOR = ((-1, -1), (0, -1), (1, -1), (-1, 0), (1, 0), (-1, 1), (0, 1), (1, 1))

    def gameOfLife(self, board: List[List[int]]) -> None:
        self.ROW_NUM = len(board)
        if self.ROW_NUM == 0:
            return

        self.COL_NUM = len(board[0])

        self.BOARD = board

        # 第一次遍历,计算哪些细胞状态变化 0-2:死变活 1-3:活变死
        for row in range(self.ROW_NUM):
            for col in range(self.COL_NUM):
                is_live = self.BOARD[row][col] % 2 == 1
                live_num = self.get_live_num(row, col)

                if is_live:
                    # 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
                    # 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
                    # 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
                    if live_num < 2 or live_num > 3:
                        self.BOARD[row][col] = 3
                else:
                    # 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
                    if live_num == 3:
                        self.BOARD[row][col] = 2

        # 第二次遍历更新状态
        for row in range(self.ROW_NUM):
            for col in range(self.COL_NUM):
                if self.BOARD[row][col] == 3:
                    self.BOARD[row][col] = 0
                elif self.BOARD[row][col] == 2:
                    self.BOARD[row][col] = 1

    # 获取周围8个位置的活细胞数, 主要考虑边界情况和是否更新过 (0,1) -> (2, 3)
    def get_live_num(self, row: int, col: int) -> int:
        sum_num = 0
        for v in self.VECTOR:
            sum_num += self.get_board_num(row + v[0], col + v[1]) % 2
        return sum_num

    # 处理边界
    def get_board_num(self, row, col) -> int:
        if 0 <= row < self.ROW_NUM and 0 <= col < self.COL_NUM:
            return self.BOARD[row][col]
        else:
            return 0
