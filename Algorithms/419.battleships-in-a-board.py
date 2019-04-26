#
# @lc app=leetcode.cn id=419 lang=python3
#
# [419] 甲板上的战舰
#
from typing import List


class Solution:
    # 判断左侧和上侧是否也是战舰
    # 若是则当前属于左侧的战舰或上侧的战舰
    # 否则则当前为一艘新的战舰，计数+1
    def countBattleships(self, board: List[List[str]]) -> int:
        try:
            row = len(board)
            col = len(board[0])

            count = 0
            for r in range(row):
                for c in range(col):
                    if board[r][c] == "X":
                        if not self.has_neighbor(board, r, c):
                            count += 1

            return count

        except:
            return 0

    # 寻找左侧 上侧 是否有战列舰
    def has_neighbor(self, board: List[List[str]], r: int, c: int) -> bool:
        has_left_neighbor = c != 0 and board[r][c-1] == "X"
        has_up_neighbor = r != 0 and board[r-1][c] == "X"
        return has_left_neighbor or has_up_neighbor


if __name__ == "__main__":
    print(Solution().countBattleships(
        [[".", ".", ".", "X"], [".", "X", ".", "X"], [".", ".", ".", "X"]]))
