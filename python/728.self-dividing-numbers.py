#
# @lc app=leetcode.cn id=728 lang=python3
#
# [728] 自除数
#
from typing import List


class Solution:
    def selfDividingNumbers(self, left: int, right: int) -> List[int]:
        # 判断某个数字是否自除数
        def isDividing(num: int) -> bool:
            digits = map(int, list(str(num)))
            for d in digits:
                if d == 0:
                    return False
                elif num % d != 0:
                    return False
            return True

        if right < left:
            return []

        result = []
        for num in range(left, right + 1):
            if isDividing(num):
                result.append(num)
        return result
