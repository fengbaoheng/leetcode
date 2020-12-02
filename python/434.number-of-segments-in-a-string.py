#
# @lc app=leetcode.cn id=434 lang=python3
#
# [434] 字符串中的单词数
#
# https://leetcode-cn.com/problems/number-of-segments-in-a-string/description/
#
# algorithms
# Easy (29.68%)
# Total Accepted:    4.5K
# Total Submissions: 15.3K
# Testcase Example:  '"Hello, my name is John"'
#
# 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
# 
# 请注意，你可以假定字符串里不包括任何不可打印的字符。
# 
# 示例:
# 
# 输入: "Hello, my name is John"
# 输出: 5
# 
# 
#
class Solution:
    def countSegments(self, s: str) -> int:
        s = s.strip()
        if len(s) == 0:
            return 0
        
        count = 0
        isWord = False
        for c in s:
            c = c.lower()
            if c  == ' ':
                isWord = False
            else:
                if not isWord:
                    isWord = True
                    count+=1
                
        return count
                
        

