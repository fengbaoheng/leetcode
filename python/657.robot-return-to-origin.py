#
# @lc app=leetcode.cn id=657 lang=python3
#
# [657] 机器人能否返回原点
#


class Solution:
    # 统计每个方向移动的次数
    # U=D 且L=R时可以回到原点
    def judgeCircle(self, moves: str) -> bool:
        U, D, L, R = 0, 0, 0, 0
        for c in moves:
            if c == "U":
                U += 1
            elif c == "D":
                D += 1
            elif c == "L":
                L += 1
            elif c == "R":
                R += 1

        return U == D and L == R
