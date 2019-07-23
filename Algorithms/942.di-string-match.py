#
# @lc app=leetcode.cn id=942 lang=python3
#
# [942] 增减字符串匹配
#
from typing import List


class Solution:
    # 看作一个折线图
    # 赋值时水平向上一层层依次赋值
    def diStringMatch(self, S: str) -> List[int]:
        length = len(S)
        if length == 0:
            return []

        # 从0开始 构造折线形
        cur = 0
        raw = []
        for c in S:
            raw.append(cur)
            cur = cur + 1 if c == "I" else cur - 1
        raw.append(cur)

        # 对折点的数值排序
        index = [i for i in range(length + 1)]
        index.sort(key=lambda i: raw[i])

        # 依次赋值
        result = [i for i in range(length + 1)]
        cur = 0
        for i in index:
            result[i] = cur
            cur += 1

        return result

