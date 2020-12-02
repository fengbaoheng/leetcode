#
# @lc app=leetcode.cn id=134 lang=python3
#
# [134] 加油站
#
import unittest
from typing import List


class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        length = len(gas)

        # 整体上有 sum(gas) >= sum(cost)
        sum_gas = 0
        sum_cost = 0

        index = 0  # 开始站
        remain = 0  # 剩余油量

        for i in range(length):
            gas_i, cost_i, remain_i = gas[i], cost[i], gas[i] - cost[i]
            sum_gas += gas_i
            sum_cost += cost_i
            remain += remain_i

            # 从上个index到当前i的累积油量都为负数的话
            # 则从[index,i]中的任一点开始,到当前站的累积和也都是负数
            # 因此只能尝试从下个站重新开始
            if remain < 0:
                remain = 0
                index = i + 1

        return -1 if sum_cost > sum_gas else index


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()
        self.testData = []

    def tearDown(self):
        for gas, cost, result in self.testData:
            self.assertEqual(result, self.solution.canCompleteCircuit(gas, cost))

    def test_default_case(self):
        self.testData = [
            ([1, 2, 3, 4, 5], [3, 4, 5, 1, 2], 3),
            ([2, 3, 4], [3, 4, 3], -1),
        ]

    def test_single(self):
        self.testData = [([1], [1], 0), ([1], [2], -1)]

    def test_1(self):
        self.testData = [([0, 10], [5, 5], 1)]


if __name__ == "__main__":
    unittest.main()

