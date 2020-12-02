#
# @lc app=leetcode.cn id=371 lang=python3
#
# [371] 两整数之和
#
# https://leetcode-cn.com/problems/sum-of-two-integers/description/
#
# algorithms
# Easy (52.80%)
# Total Accepted:    9.2K
# Total Submissions: 17.4K
# Testcase Example:  '1\n2'
#
# 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
#
# 示例 1:
#
# 输入: a = 1, b = 2
# 输出: 3
#
#
# 示例 2:
#
# 输入: a = -2, b = 3
# 输出: 1
#
#
from math import sqrt


class Solution:
    # 可以使用位元算
    # 这里使用了公式（a+b)^2 = a^2 + b^2 + 2ab
    # 即（a+b) = +- sqrt(a^2 + b^2 + 2ab)
    def getSum(self, a: int, b: int) -> int:
        return int(self.get_sign(a, b) * sqrt(a*a + b*b + 2*a*b))

    # 判断求和后的正负号
    def get_sign(self, a: int, b: int) -> int:
        if a >= 0 and b >= 0:
            return 1
        elif a < 0 and b < 0:
            return -1
        elif a >= 0 and b < 0:
            return 1 if a >= abs(b) else -1
        elif a < 0 and b >= 0:
            return 1 if b >= abs(a) else -1
