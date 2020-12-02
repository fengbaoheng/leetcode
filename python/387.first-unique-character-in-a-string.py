#
# @lc app=leetcode.cn id=387 lang=python3
#
# [387] 字符串中的第一个唯一字符
#
# https://leetcode-cn.com/problems/first-unique-character-in-a-string/description/
#
# algorithms
# Easy (37.44%)
# Total Accepted:    27.1K
# Total Submissions: 72.4K
# Testcase Example:  '"leetcode"'
#
# 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
# 
# 案例:
# 
# 
# s = "leetcode"
# 返回 0.
# 
# s = "loveleetcode",
# 返回 2.
# 
# 
# 
# 
# 注意事项：您可以假定该字符串只包含小写字母。
# 
#
from collections import Counter


class Solution:
    # 第一遍记录出现的次数
    # 第二遍查找次数为1的字符
    def firstUniqChar(self, s: str) -> int:
        d = Counter(s)
        
        for i in range(len(s)):
            if d[s[i]] == 1:
                return i
                
        return -1



        

