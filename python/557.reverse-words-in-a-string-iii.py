#
# @lc app=leetcode.cn id=557 lang=python3
#
# [557] 反转字符串中的单词 III
#
class Solution:
    def reverseWords(self, s: str) -> str:        
        return " ".join(map(lambda x:x[::-1], s.split(" ")))

