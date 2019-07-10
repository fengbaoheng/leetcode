#
# @lc app=leetcode.cn id=645 lang=python3
#
# [645] 错误的集合
#
import unittest
from typing import List


class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        length = len(nums)
        total = set(range(1, length + 1))

        cur = set([])
        repeated = -1
        for num in nums:
            if num in cur:
                repeated = num
            
            cur.add(num)
            
        missed = total.difference(cur).pop()

        return [repeated, missed]

class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()
        self.nums = []
        self.result = []

    def tearDown(self):
        self.assertListEqual(self.result, self.solution.findErrorNums(self.nums))

    def test_default(self):
        self.nums = [1, 2, 2, 4]
        self.result = [2, 3]

    def test_single(self):
        self.nums = [1, 1]
        self.result = [1, 2]

    def test_max(self):
        self.nums = [1, 2, 3, 4, 4]
        self.result = [4, 5]

    def test_min(self):
        self.nums = [4, 2, 3, 4, 5]
        self.result = [4, 1]


if __name__ == "__main__":
    unittest.main()

