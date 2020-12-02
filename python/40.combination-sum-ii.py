#
# @lc app=leetcode.cn id=40 lang=python3
#
# [40] 组合总和 II
#
# https://leetcode-cn.com/problems/combination-sum-ii/description/
#
# algorithms
# Medium (53.45%)
# Total Accepted:    9K
# Total Submissions: 16.8K
# Testcase Example:  '[10,1,2,7,6,1,5]\n8'
#
# 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
#
# candidates 中的每个数字在每个组合中只能使用一次。
#
# 说明：
#
#
# 所有数字（包括目标数）都是正整数。
# 解集不能包含重复的组合。
#
#
# 示例 1:
#
# 输入: candidates = [10,1,2,7,6,1,5], target = 8,
# 所求解集为:
# [
# ⁠ [1, 7],
# ⁠ [1, 2, 5],
# ⁠ [2, 6],
# ⁠ [1, 1, 6]
# ]
#
#
# 示例 2:
#
# 输入: candidates = [2,5,2,1,2], target = 5,
# 所求解集为:
# [
# [1,2,2],
# [5]
# ]
#
#
from typing import List


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        length = len(candidates)

        if target < 0 or length == 0:
            return []

        candidates = sorted(candidates)

        results = []
        for i in range(length):
            # 去重复
            if i >= 1 and candidates[i] == candidates[i - 1]:
                continue

            num = candidates[i]
            if num > target:
                pass
            elif num == target:
                results.append([num])
            else:
                sub_results = self.combinationSum2(candidates[i + 1 :], target - num)
                for r in sub_results:
                    r.insert(0, num)
                    results.append(r)
        return results


if __name__ == "__main__":
    s = Solution().combinationSum2([10, 1, 2, 7, 6, 1, 5], 8)
    print(s)
