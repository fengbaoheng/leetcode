#
# @lc app=leetcode.cn id=566 lang=python3
#
# [566] 重塑矩阵
#
import unittest
from typing import List


class Solution:
    def matrixReshape(self, nums: List[List[int]], r: int, c: int) -> List[List[int]]:
        if r == 0 or c == 0:
            return nums

        rows = len(nums)
        if rows == 0:
            return nums

        cols = len(nums[0])
        if cols == 0:
            return nums

        if rows * cols != r * c:
            return nums

        stack = []
        m = []
        for ri in range(rows):
            for ci in range(cols):
                stack.append(nums[ri][ci])
                if len(stack) == c:
                    m.append(stack)
                    stack = []

        return m


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_empty(self):
        nums = []
        result = self.solution.matrixReshape(nums, 0, 0)
        self.assertListEqual(result, [])

    def test_22(self):
        nums = [[1, 2], [3, 4]]
        result = self.solution.matrixReshape(nums, 1, 4)
        self.assertListEqual(result, [[1, 2, 3, 4]])

        result = self.solution.matrixReshape(nums, 4, 1)
        self.assertListEqual(result, [[1], [2], [3], [4]])

        result = self.solution.matrixReshape(nums, 4, 2)
        self.assertListEqual(result, nums)


if __name__ == "__main__":
    unittest.main()
