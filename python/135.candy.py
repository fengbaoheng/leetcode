#
# @lc app=leetcode.cn id=135 lang=python3
#
# [135] 分发糖果
#
import unittest
from typing import List


class Solution:
    def candy(self, ratings: List[int]) -> int:
        length = len(ratings)

        if length == 0:
            return 0

        count = 0
        candy = [0 for i in range(length)]

        # 分数排序
        sorted_ratings = [(i, ratings[i]) for i in range(length)]
        sorted_ratings.sort(key=lambda x: x[1], reverse=True)

        while sorted_ratings:
            i = sorted_ratings.pop()[0]
            rate = ratings[i]

            left_rate = ratings[i - 1] if i != 0 else ratings[0]
            left_candy = candy[i - 1] if i != 0 else 0
            right_rate = ratings[i + 1] if i != length - 1 else ratings[length - 1]
            right_candy = candy[i + 1] if i != length - 1 else 0

            if left_rate >= rate <= right_rate:
                candy[i] = 1
            elif left_rate <= rate <= right_rate:
                candy[i] = left_candy + 1
            elif left_rate >= rate >= right_rate:
                candy[i] = right_candy + 1
            elif left_rate <= rate and rate >= right_rate:
                candy[i] = max(left_candy, right_candy) + 1

            count += candy[i]

        return count


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.data = []
        self.solution = Solution()

    def test_default(self):
        self.data = [([1, 0, 2], 5), ([1, 2, 2], 4)]

    def test_empty(self):
        self.data = [([], 0)]

    def test_one(self):
        self.data = [([0], 1), ([2], 1)]

    def test_same_rate(self):
        self.data = [([2, 2, 2, 2], 4), ([1, 1, 1], 3)]

    def test_increase(self):
        self.data = [
            ([1, 2, 3, 4], 10),
            ([0, 1, 2], 6),
            ([-1, 0, 1, 2], 10),
            ([1, 2, 3, 4, 4], 11),
            ([1, 2, 3, 4, 4, 4, 4], 13),
            ([0, 1, 1, 1, 1, 1], 7),
            ([0, 0, 0, 1, 2, 3, 3, 3], 14),
        ]

    def test_reduce(self):
        self.data = [
            ([3, 2, 1], 6),
            ([3, 2, 1, 1, 1], 8),
            ([4, 3, 3, 3, 2, 1, 1, 1], 12),
        ]

    def test_increase_reduce(self):
        self.data = [
            ([1, 2, 3, 3, 3, 2, 1], 13),
            ([3, 3, 3, 2, 2, 1, 1, 1, 2, 2, 3, 3, 2, 3, 3, 3, 2, 1, 1], 28),
        ]

    def tearDown(self):
        for ratings, result in self.data:
            self.assertEqual(result, self.solution.candy(ratings))


if __name__ == "__main__":
    unittest.main()
