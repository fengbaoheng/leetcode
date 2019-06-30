#
# @lc app=leetcode.cn id=300 lang=python3
#
# [300] 最长上升子序列
#
import unittest
from typing import List


class Solution:
    # 动态规划
    def lengthOfLIS(self, nums: List[int]) -> int:
        length = len(nums)

        if length <= 1:
            return length

        cache = {}
        max_chache = 0
        for i in range(length):
            num = nums[i]

            max_length = 1
            for (k, v) in cache.items():
                if k < num and v + 1 > max_length:
                    max_length =  v + 1

            if num in cache:
                cache[num] = max(cache[num], max_length)

            cache[num] = max_length

            if max_length > max_chache:
                max_chache = max_length

        return max_chache


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()
        self.testData = []

    def tearDown(self):
        for nums, result in self.testData:
            self.assertEqual(result, self.solution.lengthOfLIS(nums))

    # def test_Default(self):
    #     self.testData = [([10, 9, 2, 5, 3, 7, 101, 18], 4)]

    # def test_myself(self):
    #     self.testData = [
    #         ([10, 9, 2, 5, 3, 7, 101, 18, 19], 5),
    #         ([10, 9, 2, 5, 3, 7, 101, 18, 19, 102, 103], 7),
    #     ]

    def test_repeat(self):
        self.testData = [([3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12], 6)]


if __name__ == "__main__":
    unittest.main()

