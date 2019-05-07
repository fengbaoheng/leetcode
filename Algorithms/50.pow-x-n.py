#
# @lc app=leetcode.cn id=50 lang=python3
#
# [50] Pow(x, n)
#
import math


class Solution:
    # 考虑边界 x=0  n <= 0
    # 通过pow(n) = pow(pow(n/2), 2)加速计算
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        elif n > 0:
            return self.pow_abs(x, n)
        else:
            denominator = self.pow_abs(x, abs(n))
            if math.isclose(denominator, 0):
                raise Exception("invalid input")
            else:
                return 1 / denominator

    def pow_abs(self, x: float, n: int) -> float:
        if n < 0:
            raise Exception("invalid input")
        elif n == 0:
            return 1
        elif n == 1:
            return x
        elif n == 2:
            return x * x
        else:
            if n % 2 == 0:
                half_pow = self.pow_abs(x, n/2)
                return half_pow * half_pow
            else:
                half_pow = self.pow_abs(x, (n-1)/2)
                return x * half_pow * half_pow


if __name__ == "__main__":
    print(Solution().myPow(0.00001, 2147483647))
