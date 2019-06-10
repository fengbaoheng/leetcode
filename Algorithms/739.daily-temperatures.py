#
# @lc app=leetcode.cn id=739 lang=python3
#
# [739] 每日温度
#
from typing import List


class Solution:
    # 使用栈结构记录
    # 若下一天比当天值气温低则入栈, 否则出栈
    # 栈中气温一定是降序排列,若遇升温则发生出栈
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        length = len(T)

        if length == 0:
            return []
        elif length == 1:
            return [0]

        result = [0 for i in range(length)]

        stack = []
        for i in range(length):
            t = T[i]

            # 缓存为空
            if len(stack) == 0:
                stack.append(i)
            else:
                if t <= T[stack[-1]]:
                    # 气温未升高
                    stack.append(i)
                else:
                    # 比上次气温低,则连续出栈
                    while stack and t > T[stack[-1]]:
                        j = stack.pop()
                        result[j] = i - j

                    stack.append(i)

        return result
