#
# @lc app=leetcode.cn id=743 lang=python3
#
# [743] Network Delay Time
#
# https://leetcode-cn.com/problems/network-delay-time/description/
#
# algorithms
# Medium (42.52%)
# Total Accepted:    1.4K
# Total Submissions: 3.4K
# Testcase Example:  '[[2,1,1],[2,3,1],[3,4,1]]\n4\n2'
#
# 有 N 个网络节点，标记为 1 到 N。
#
# 给定一个列表 times，表示信号经过有向边的传递时间。 times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点， w
# 是一个信号从源节点传递到目标节点的时间。
#
# 现在，我们向当前的节点 K 发送了一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。
#
# 注意:
#
#
# N 的范围在 [1, 100] 之间。
# K 的范围在 [1, N] 之间。
# times 的长度在 [1, 6000] 之间。
# 所有的边 times[i] = (u, v, w) 都有 1 <= u, v <= N 且 0 <= w <= 100。
#
#
#
from typing import List


class Solution:
    def networkDelayTime(self, times: List[List[int]], N: int, K: int) -> int:
        inf = 2147483647

        # 初始化二维矩阵,权值为传播距离
        matrix = [[inf for j in range(N)] for i in range(N)]
        for i in range(N):
            matrix[i][i] = 0

        for time in times:
            o, d, t = time
            matrix[o-1][d-1] = t

        # 更新距离
        for k in range(N):
            for i in range(N):
                for j in range(N):
                    t = matrix[i][k] + matrix[k][j]
                    if t < matrix[i][j]:
                        matrix[i][j] = t

        end_time = max(matrix[K-1])
        return end_time if end_time != inf else -1


if __name__ == "__main__":
    Solution().networkDelayTime([[2, 1, 1], [2, 3, 1], [3, 4, 1]], 4, 2)
