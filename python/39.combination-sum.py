#
# @lc app=leetcode.cn id=39 lang=python3
#
# [39] 组合总和
#
# https://leetcode-cn.com/problems/combination-sum/description/
#
# algorithms
# Medium (62.40%)
# Total Accepted:    12.8K
# Total Submissions: 20.3K
# Testcase Example:  '[2,3,6,7]\n7'
#
# 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
#
# candidates 中的数字可以无限制重复被选取。
#
# 说明：
#
#
# 所有数字（包括 target）都是正整数。
# 解集不能包含重复的组合。
#
#
# 示例 1:
#
# 输入: candidates = [2,3,6,7], target = 7,
# 所求解集为:
# [
# ⁠ [7],
# ⁠ [2,2,3]
# ]
#
#
# 示例 2:
#
# 输入: candidates = [2,3,5], target = 8,
# 所求解集为:
# [
# [2,2,2,2],
# [2,3,3],
# [3,5]
# ]
#
#


class Solution:
    def combinationSum(self, candidates, target: int) -> List[List[int]]:
        length = len(candidates)
        if length == 0:
            return []

        results = []
        for i in range(length):
            num = candidates[i]
            if num > target:
                continue
            if num == target:
                results.append([num])
            else:
                sub_target = target - num
                sub_results = self.combinationSum(candidates[i:], sub_target)

                for sub_result in sub_results:
                    sub_result.append(num)
                    results.append(sub_result)

        return results

