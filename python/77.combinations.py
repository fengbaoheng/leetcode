#
# @lc app=leetcode.cn id=77 lang=python3
#
# [77] 组合
#
# https://leetcode-cn.com/problems/combinations/description/
#
# algorithms
# Medium (66.48%)
# Total Accepted:    9.3K
# Total Submissions: 14K
# Testcase Example:  '4\n2'
#
# 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
#
# 示例:
#
# 输入: n = 4, k = 2
# 输出:
# [
# ⁠ [2,4],
# ⁠ [3,4],
# ⁠ [2,3],
# ⁠ [1,2],
# ⁠ [1,3],
# ⁠ [1,4],
# ]
#
#
from typing import List


class Solution:
    # 拆分为子问题, 从n-1中找k-1的组合,最后在加上n
    def combine(self, n: int, k: int) -> List[List[int]]:
        # 处理边界条件
        if n == 0 or k == 0 or k > n:
            return []
        elif k == n:
            return [[i for i in range(1, n + 1)]]
        elif k == 1:
            return [[i] for i in range(1, n + 1)]

        # 从后往前遍历递归,不断拆分问题,合并结果
        results = []
        for i in range(1, n):
            result = self.combine(n - i, k - 1)
            for r in result:
                r.append(n - i + 1)
                results.append(r)

        return results

if __name__ == "__main__":
    print(Solution().combine(4, 2))

