#
# @lc app=leetcode.cn id=771 lang=python3
#
# [771] Jewels and Stones
#


class Solution:
    # J中字符作为集合，便于快速查找
    # 遍历S，如果在字符在J中则+1
    def numJewelsInStones(self, J: str, S: str) -> int:
        if len(J) == 0 or len(S) == 0:
            return 0

        j_set = set(J)
        count = 0
        for c in S:
            if c in j_set:
                count += 1
        return count
