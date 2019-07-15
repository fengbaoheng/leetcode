#
# @lc app=leetcode.cn id=292 lang=python3
#
# [292] Nim 游戏
#
import unittest


class Solution:
    # 找规律
    def canWinNim(self, n: int) -> bool:
        return n % 4 != 0

    # 动态规划解法
    def dp(self, n: int) -> bool:
        # n == 0时False
        win = [False, True, True, True]

        for i in range(4, n + 1):
            # 分别判断自己拿走1,2,3个石头后, 对手的胜负
            cases = [win[i - 1], win[i - 2], win[i - 3]]

            # 如果无论自己拿走几个对手都会获胜
            # 则自己必输
            if all(cases):
                win.append(False)
            # 否则自己有胜利的可能
            else:
                win.append(True)

        return win[n]


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()
        self.data = []

    def tearDown(self):
        for result, n in self.data:
            self.assertEqual(result, self.solution.canWinNim(n))

    def test_zero(self):
        self.data = [(False, 0)]

    def test_default(self):
        self.data = [(False, 4)]

    def test_must_win(self):
        self.data = [(True, 1), (True, 2), (True, 3)]

    def test_big(self):
        self.data = [(True, 5), (True, 15), (False, 16), (True, 17), (False, 28)]


if __name__ == "__main__":
    unittest.main()
