#
# @lc app=leetcode.cn id=1094 lang=python3
#
# [1094] 拼车
#
import unittest
from typing import List


class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:

        dict = {}
        for trip in trips:
            passenger, start, end = trip
            if start not in dict:
                dict[start] = 0
            if end not in dict:
                dict[end] = 0

            dict[start] += passenger
            dict[end] -= passenger

        locations = list(dict.keys())
        locations.sort()
        count = 0

        for location in locations:
            passenger = dict[location]
            count += passenger
            if count > capacity:
                return False 

        return True


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()
        self.testData = []

    def tearDown(self):
        for trips, capacity, result in self.testData:
            self.assertEqual(result, self.solution.carPooling(trips, capacity))

    def test_default_case(self):
        self.testData = [
            ([[2, 1, 5], [3, 3, 7]], 4, False),
            ([[2, 1, 5], [3, 3, 7]], 5, True),
            ([[2, 1, 5], [3, 5, 7]], 3, True),
            ([[3, 2, 7], [3, 7, 9], [8, 3, 9]], 11, True),
        ]

    def test_unsort(self):
        self.testData = [
            ([[10, 5, 10], [10, 0, 5]], 10, True),
            ([[10, 5, 10], [10, 0, 5]], 9, False),
        ]

    def test_repeat(self):
        self.testData = [
            ([[10, 0, 10], [10, 0, 10]], 20, True),
            ([[10, 0, 10], [10, 0, 10]], 19, False),
        ]


if __name__ == "__main__":
    unittest.main()

