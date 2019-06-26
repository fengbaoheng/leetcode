#
# @lc app=leetcode.cn id=1052 lang=python3
#
# [1052] 爱生气的书店老板
#
import unittest
from typing import List


class Solution:
    # 思路 选择压制与不压制情绪, 满意人数相差最大的时间段
    # 即要尽可能挽回不满意的客人
    def maxSatisfied(self, customers: List[int], grumpy: List[int], X: int) -> int:
        length = len(customers)

        if X >= length:
            return sum(customers)

        # 可以被挽回的顾客
        can_rescue = []
        satisfied = 0

        for i in range(length):
            count = customers[i]

            if grumpy[i] == 1:
                # 如不满意,则可挽回customers[i]人
                can_rescue.append(count)
            else:
                # 如果本来就满意,则为0
                can_rescue.append(0)
                satisfied += count

        resuce_count = sum(can_rescue[:X])
        max_rescue = resuce_count
        for i in range(X, length):
            resuce_count = resuce_count + can_rescue[i] - can_rescue[i - X]

            if resuce_count > max_rescue:
                max_rescue = resuce_count

        return satisfied + max_rescue


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.testData = []
        self.solution = Solution()

    def test_default_case(self):
        self.testData = [([1, 0, 1, 2, 1, 1, 7, 5], [0, 1, 0, 1, 0, 1, 0, 1], 3, 16)]

    def test_one(self):
        self.testData = [
            ([1], [1], 1, 1),
            ([0], [1], 1, 0),
            ([0], [1], 1, 0),
            ([0], [0], 1, 0),
        ]

    def test_always_grumpy(self):
        self.testData = [
            ([0, 0, 0, 0, 0, 0], [1, 1, 1, 1, 1, 1], 1, 0),
            ([1, 2, 3, 4, 5, 6], [1, 1, 1, 1, 1, 1], 1, 6),
            ([1, 2, 3, 4, 5, 6], [1, 1, 1, 1, 1, 1], 2, 11),
        ]

    def test_maxX(self):
        self.testData = [
            ([1, 2, 3, 4, 5, 6], [1, 0, 0, 1, 0, 1], 100, 21),
            ([1, 2, 3, 4, 5, 6], [1, 1, 1, 1, 1, 1], 100, 21),
        ]

    def test_choose(self):
        self.testData = [
            ([1, 2, 3, 4, 5, 6], [0, 1, 0, 1, 1, 0], 1, 15),
            ([1, 2, 3, 4, 5, 6], [0, 1, 0, 1, 1, 0], 2, 19),
            ([1, 2, 3, 4, 5, 6], [0, 1, 1, 1, 1, 0], 2, 16),
            ([1, 2, 3, 4, 5, 6], [0, 1, 1, 1, 1, 0], 2, 16),
        ]

    def tearDown(self):
        for customers, grumpy, x, result in self.testData:
            self.assertEqual(result, self.solution.maxSatisfied(customers, grumpy, x))


if __name__ == "__main__":
    unittest.main()

