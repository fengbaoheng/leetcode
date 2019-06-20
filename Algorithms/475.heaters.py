#
# @lc app=leetcode.cn id=475 lang=python3
#
# [475] 供暖器
#
import unittest
from typing import List


class Solution:
    def findRadius(self, houses: List[int], heaters: List[int]) -> int:
        if len(houses) == 0:
            return 0

        if len(heaters) == 0:
            raise Exception()

        houses.sort()

        # 供暖器加入两个极限值 +-inf
        inf = float("inf")
        heaters.append(inf)
        heaters.append(-inf)
        heaters.sort(reverse=True)

        last_heater = heaters.pop()
        next_heater = heaters.pop()

        max_radious = 0
        for house in houses:
            # 下一个供暖器要在房屋右边
            while next_heater < house:
                last_heater = next_heater
                next_heater = heaters.pop()

            last_distance = house - last_heater
            next_distance = next_heater - house

            radious = min(last_distance, next_distance)
            if radious > max_radious:
                max_radious = radious

        return max_radious


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_1(self):
        houses = [1, 2, 3]
        heaters = [2]

        result = self.solution.findRadius(houses, heaters)
        self.assertEqual(result, 1)

        heaters = [1, 4]
        result = self.solution.findRadius(houses, heaters)
        self.assertEqual(result, 1)

    def test_empty(self):
        houses = [1]
        heaters = [1]

        result = self.solution.findRadius(houses, heaters)
        self.assertEqual(result, 0)

    def test_2(self):
        houses = [1, 2, 3, 4, 5, 6]
        heaters = [5]

        result = self.solution.findRadius(houses, heaters)
        self.assertEqual(result, 4)

    def test_3(self):
        houses = [1, 5]
        heaters = [2]

        result = self.solution.findRadius(houses, heaters)
        self.assertEqual(result, 3)

    def test_dispersed(self):
        houses = [100000000]
        heaters = [1]

        result = self.solution.findRadius(houses, heaters)
        self.assertEqual(result, 99999999)


if __name__ == "__main__":
    unittest.main()

