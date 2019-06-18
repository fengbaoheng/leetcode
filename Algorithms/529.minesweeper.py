#
# @lc app=leetcode.cn id=529 lang=python3
#
# [529] 扫雷游戏
#
import unittest
from typing import List


class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        def neighbors(r, c):
            loc = [
                [r - 1, c - 1],
                [r - 1, c],
                [r - 1, c + 1],
                [r, c - 1],
                [r, c + 1],
                [r + 1, c - 1],
                [r + 1, c],
                [r + 1, c + 1],
            ]

            n = []
            for l in loc:
                if valid(l[0], l[1]):
                    n.append(l)
            return n

        def valid(r, c):
            return r >= 0 and r <= rows - 1 and c >= 0 and c <= cols - 1

        rows = len(board)
        cols = len(board[0])

        count = [[0 for c in range(cols)] for r in range(rows)]
        for r in range(rows):
            for c in range(cols):
                if (board[r][c]) == "M":
                    count[r][c] = -1
                    for rr, cc in neighbors(r, c):
                        count[rr][cc] += 1

        stack = [click]
        while stack:
            r, c = stack.pop()
            if board[r][c] == "M":
                board[r][c] = "X"
                break
            elif board[r][c] == "E":
                if count[r][c] == 0:
                    board[r][c] = "B"
                    stack.extend(neighbors(r, c))
                else:
                    board[r][c] = str(count[r][c])

        return board


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_click_blank(self):
        board = [
            ["E", "E", "E", "E", "E"],
            ["E", "E", "M", "E", "E"],
            ["E", "E", "E", "E", "E"],
            ["E", "E", "E", "E", "E"],
        ]

        result = [
            ["B", "1", "E", "1", "B"],
            ["B", "1", "M", "1", "B"],
            ["B", "1", "1", "1", "B"],
            ["B", "B", "B", "B", "B"],
        ]

        self.assertListEqual(result, self.solution.updateBoard(board, [3, 0]))

    def test_click_mine(self):
        board = [
            ["B", "1", "E", "1", "B"],
            ["B", "1", "M", "1", "B"],
            ["B", "1", "1", "1", "B"],
            ["B", "B", "B", "B", "B"],
        ]

        result = [
            ["B", "1", "E", "1", "B"],
            ["B", "1", "X", "1", "B"],
            ["B", "1", "1", "1", "B"],
            ["B", "B", "B", "B", "B"],
        ]

        self.assertListEqual(result, self.solution.updateBoard(board, [1, 2]))


if __name__ == "__main__":
    unittest.main()
