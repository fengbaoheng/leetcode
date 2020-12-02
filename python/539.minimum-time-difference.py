#
# @lc app=leetcode.cn id=539 lang=python3
#
# [539] 最小时间差
#
# https://leetcode-cn.com/problems/minimum-time-difference/description/
#
# algorithms
# Medium (46.33%)
# Total Accepted:    998
# Total Submissions: 2.1K
# Testcase Example:  '["23:59","00:00"]'
#
# 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并已分钟数表示。
#
#
# 示例 1：
#
#
# 输入: ["23:59","00:00"]
# 输出: 1
#
#
#
# 备注:
#
#
# 列表中时间数在 2~20000 之间。
# 每个时间取值在 00:00~23:59 之间。
#
#
#
from typing import List


class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        # 转化为分钟数表示
        # 0点与24点相等

        if len(timePoints) == 0:
            return 0

        minutes = set()
        for timePoint in timePoints:
            minute = self.convert_minute(timePoint)
            if minute in minutes:
                return 0
            else:
                minutes.add(minute)

        # 排序计算差值
        minutes = sorted(list(minutes))
        min_diff = minutes[0] + 24*60 - minutes[-1] # 考虑跨天的情况
        for i in range(1, len(minutes)):
            diff = minutes[i] - minutes[i - 1]
            if diff == 0:
                return 0
            elif diff < min_diff:
                min_diff = diff

        return min_diff

    # 小时转分钟 数字
    def convert_minute(self, timePoint: str) -> int:
        timePoint = map(int, timePoint.split(":"))
        h, m = timePoint
        return h * 60 + m


if __name__ == "__main__":
    print(Solution().findMinDifference(["23:59","00:00"]))
