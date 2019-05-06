#
# @lc app=leetcode.cn id=79 lang=python3
#
# [79] 单词搜索
#
from typing import List, Set, Tuple


class Solution:
    # 深度搜索
    # 记录走过的路径
    def exist(self, board: List[List[str]], word: str) -> bool:
        try:
            rows = len(board)
            cols = len(board[0])

            for r in range(rows):
                for c in range(cols):
                    # 对每个网格点都尝试搜索, 此时无禁忌位置
                    if self.search(board, word, r, c, set([])):
                        return True

            return False
        except Exception as e:
            raise e

    def search(self, board: List[List[str]], word: str, r: int, c: int, tabu: Set[Tuple[int]]) -> bool:
        # 排除禁忌位置
        if (r, c) in tabu:
            return False

        # 空字符串匹配,永远为True
        length = len(word)
        if length == 0:
            return True

        # 首字母就匹配失败即返回False
        if word[0] != board[r][c]:
            return False
        elif length == 1:
            return True

        # 首字母匹配成功
        # 生成新的禁忌位置和新的子串
        tabu = tabu.copy()
        tabu.add((r, c))
        word = word[1:]

        # 搜索四周的单元格
        if c > 0 and self.search(board, word, r, c-1, tabu):
            return True

        if r > 0 and self.search(board, word, r-1, c, tabu):
            return True

        if c < len(board[0]) - 1 and self.search(board, word, r, c+1, tabu):
            return True

        if r < len(board) - 1 and self.search(board, word, r+1, c, tabu):
            return True

        return False


if __name__ == "__main__":
    board = [
        ['A', 'B', 'C', 'E'],
        ['S', 'F', 'C', 'S'],
        ['A', 'D', 'E', 'E']
    ]
    s = Solution()
    print("{}:{}".format("ABCCED", s.exist(board, "ABCCED")))
    print("{}:{}".format("SEE", s.exist(board, "SEE")))
    print("{}:{}".format("ABCB", s.exist(board, "ABCB")))
