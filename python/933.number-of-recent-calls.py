#
# @lc app=leetcode.cn id=933 lang=python3
#
# [933] 最近的请求次数
#

from collections import deque


class RecentCounter:

    def __init__(self):
        self.record = deque()

    # 每ping一次 记录t
    # 由于t是递增的，因此可以删除t-3000之前的数字
    # 返回记录的长度即可
    def ping(self, t: int) -> int:
        self.record.append(t)

        T = t-3000
        while self.record[0] < T:
            self.record.popleft()

        return len(self.record)


# Your RecentCounter object will be instantiated and called as such:
# obj = RecentCounter()
# param_1 = obj.ping(t)
