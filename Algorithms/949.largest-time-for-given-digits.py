#
# @lc app=leetcode.cn id=949 lang=python3
#
# [949] 给定数字能组成的最大时间
#
import unittest
from typing import List


class Solution:
    # 回溯 将数字看成一棵树
    def largestTimeFromDigits(self, A: List[int]) -> str:
        # 设时间的4个数字为 h1 h2 : m1 m2
        # 取出当前最大的数作为时间第1位:h1
        h1_A = sorted(A)
        while len(h1_A) > 0:
            h1 = h1_A.pop()
            # 第一位只可能是0,1,2 如果超过了则回溯尝试下个数
            if h1 > 2:
                continue

            # 在除了h1的数中搜索h2
            h2_A = sorted(A)
            h2_A.remove(h1)
            while len(h2_A) > 0:
                h2 = h2_A.pop()
                # h1为2时 则h2只能为 0,1,2,3
                if h1 == 2 and h2 > 3:
                    continue

                # 剩下的两个数就是 m1 m2,只需m1<6即可
                res = sorted(A)
                res.remove(h1)
                res.remove(h2)
                minM, maxM = res

                # 不存在合法的情况
                if minM >= 6:
                    continue
                elif maxM >= 6:
                    return "{}{}:{}{}".format(h1,h2,minM, maxM)
                else:
                    return "{}{}:{}{}".format(h1,h2,maxM, minM)

        return ""


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.data = []

    def tearDown(self):
        solution = Solution()
        for A,result in self.data:
            self.assertEqual(result, solution.largestTimeFromDigits(A))

    def test_default(self):
        self.data = [([1, 2, 3, 4], "23:41"), ([5, 5, 5, 5], "")]

    def test_same(self):
        self.data = [
            ([0, 0, 0, 0], "00:00"),
            ([1, 1, 1, 1], "11:11"),
            ([2, 2, 2, 2], "22:22"),
            ([3, 3, 3, 3], ""),
            ([9, 9, 9, 9], ""),
        ]

    def test_conflict(self):
        self.data = [
            ([1, 2, 2, 4], "22:41"),
            ([1, 2, 3, 4], "23:41"),
            ([0, 2, 6, 6], "06:26"),
        ]

    def test_zero(self):
        self.data = [([0, 0, 0, 1], "10:00")]


if __name__ == "__main__":
    unittest.main()
