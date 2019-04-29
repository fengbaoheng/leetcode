#
# @lc app=leetcode.cn id=216 lang=python3
#
# [216] 组合总和 III
#
from typing import List


class Solution:
    # 递归拆分成子问题
    # 最简单情况 k==1
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        return self.combine_sum(k, n, 1)

    # 限制数字的起点
    def combine_sum(self, k: int, n: int, min_num: int) -> List[List[int]]:
        # 无论如何都组合不出
        if k < 1 or n < min_num or min_num > 9:
            return []

        # 边界情况
        if k == 1 and min_num <= n <= 9:
            return [[n]]

        results = []

        for i in range(min_num, 10):
            cur_num = i
            next_n = n - i
            next_min = i+1
            next_combine = self.combine_sum(k-1, next_n, next_min)

            for combine in next_combine:
                results.append([cur_num] + combine)

        return results


if __name__ == "__main__":
    print(Solution().combinationSum3(3, 6))
