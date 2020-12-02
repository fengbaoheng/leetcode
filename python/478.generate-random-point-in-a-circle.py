#
# @lc app=leetcode.cn id=478 lang=python3
#
# [478] 在圆内随机生成点
#
from typing import List
from random import uniform
import math


class Solution:
    def __init__(self, radius: float, x_center: float, y_center: float):
        self.r = radius
        self.x = x_center
        self.y = y_center
        self.r2 = radius * radius

    def randPoint(self) -> List[float]:
        while True:
            dx = uniform(-self.r, self.r)
            dy = uniform(-self.r, self.r)

            if (dx * dx + dy * dy) <= self.r2:
                return [self.x + dx, self.y + dy]


# Your Solution object will be instantiated and called as such:
# obj = Solution(radius, x_center, y_center)
# param_1 = obj.randPoint()

