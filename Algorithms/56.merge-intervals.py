#
# @lc app=leetcode.cn id=56 lang=python3
#
# [56] 合并区间
#
# https://leetcode-cn.com/problems/merge-intervals/description/
#
# algorithms
# Medium (35.01%)
# Total Accepted:    11.7K
# Total Submissions: 33.2K
# Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
#
# 给出一个区间的集合，请合并所有重叠的区间。
# 
# 示例 1:
# 
# 输入: [[1,3],[2,6],[8,10],[15,18]]
# 输出: [[1,6],[8,10],[15,18]]
# 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
# 
# 
# 示例 2:
# 
# 输入: [[1,4],[4,5]]
# 输出: [[1,5]]
# 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
# 
#
# Definition for an interval.
class Interval:
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e
    def __str__(self):
        return "[{},{}]".format(self.start, self.end)
    def __repr__(self):
        return self.__str__()

from typing import List

class Solution:
    def merge(self, intervals: List[Interval]) -> List[Interval]:
        length = len(intervals)
        if length == 0 or length == 1:
            return intervals

        # 记录开区间和闭区间的所有点 
        interval_point = []
        for interval in intervals:
            interval_point.append((interval.start, 0))
            interval_point.append((interval.end, 0.1))
        
        # 对数字排序
        interval_point.sort(key=lambda p:p[0]+p[1])

        # 开区间入栈,闭区间出栈
        stack = []

        merged_intervals = []
        for p in interval_point:
            num:int = p[0]
            isOpen:bool = p[1] == 0

            if isOpen:
                stack.append(num)
            else:
                start = stack.pop()
                if len(stack) == 0:
                    merged_intervals.append(Interval(start, num))

        return merged_intervals




if __name__ == "__main__":
    cases = [
        [[1,3],[2,6],[8,10],[15,18]],
        [[1,4],[0,0]],
        [[1,4],[5,5]],
    ]
    

    solution = Solution()

    for case in cases:
        intervals = [Interval(i[0], i[1]) for i in case]
        res = solution.merge(intervals)
        print(res)

        

