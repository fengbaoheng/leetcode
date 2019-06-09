#
# @lc app=leetcode.cn id=412 lang=python3
#
# [412] Fizz Buzz
#
from typing import List


class Solution:
    def fizzBuzz(self, n: int) -> List[str]:
        result = [str(i) for i in range(1, n + 1)]

        f = 3
        while f <= n:
            result[f - 1] = "Fizz"
            f += 3

        b = 5
        while b <= n:
            result[b - 1] = "Buzz" if result[b - 1] != "Fizz" else "FizzBuzz"
            b += 5

        return result

