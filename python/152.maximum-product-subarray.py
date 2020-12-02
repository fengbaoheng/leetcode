#
# @lc app=leetcode.cn id=152 lang=python3
#
# [152] 乘积最大子序列
#
import unittest
from typing import List


class Solution:
    # 动态规划
    # 记录之前叠加的最大值和最小值(连续负数)
    # max_dp[i] = max(dp[i], max_dp[i-1]*dp[i], min_dp[i-1]*dp[i])
    # min_dp[i] = min(dp[i], max_dp[i-1]*dp[i], min_dp[i-1]*dp[i])
    def maxProduct(self, nums: List[int]) -> int:
        length = len(nums)

        if length == 0:
            return 0
        elif length == 1:
            return nums[0]

        result = nums[0]
        last_max = nums[0]
        last_min = nums[0]

        # 依次叠加计算
        for i in range(1, length):
            num = nums[i]
            res = [num, num * last_max, num * last_min]
            last_max = max(res)
            last_min = min(res)

            if last_max > result:
                result = last_max
        
        return result


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()
        self.testData = []

    def tearDown(self):
        for nums, res in self.testData:
            self.assertEqual(res, self.solution.maxProduct(nums))

    def test_default(self):
        self.testData = [([2, 3, -2, 4], 6), ([-2, 0, -1], 0)]

    def test_empty(self):
        self.testData = [([], 0)]

    def test_zero(self):
        self.testData = [([0], 0), ([0, -1, 2, 0], 2), ([0, -1, 0], 0)]

    def test_negative(self):
        self.testData = [([-1], -1), ([-1, -2, -3], 6), ([-1, -2, 4, -4, 6, -1], 192)]


if __name__ == "__main__":
    unittest.main()

