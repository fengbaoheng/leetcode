#
# @lc app=leetcode.cn id=1103 lang=python3
#
# [1103] 分糖果 II
#
from typing import List
import math


class Solution:
    def distributeCandies(self, candies: int, num_people: int) -> List[int]:
        if num_people == 0:
            return []
        elif candies == 0:
            return [0 for i in range(num_people)]

        # 假设可以连续分给n个人
        # (1 + x)*x / 2 = candies
        #  x^2 + x -2candies
        a, b, c = 1, 1, -2 * candies
        x = (-b + math.sqrt(b * b - 4 * a * c)) / (2 * a)

        # 完整的分配几个轮次
        c = math.floor(x / num_people)

        # 累积和
        acc = (num_people + (c - 1) * num_people) * (c - 1) / 2 if c > 1 else 0
        acc = int(acc)

        # 分配C轮的结果可以直接计算
        result = []
        res = candies
        for i in range(num_people):
            num = c * (i+1) + acc
            result.append(num)
            res -= num

        # 模拟最后一轮
        num = 1 + c * num_people
        i = 0
        while res > 0:
            if res >= num:
                result[i] += num
                res -= num
            else:
                result[i] += res
                res = 0

            num += 1
            i += 1

        return result


if __name__ == "__main__":
    Solution().distributeCandies(10,3)

