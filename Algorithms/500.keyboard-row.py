#
# @lc app=leetcode.cn id=500 lang=python3
#
# [500] 键盘行
#
# https://leetcode-cn.com/problems/keyboard-row/description/
#
# algorithms
# Easy (65.50%)
# Total Accepted:    6.4K
# Total Submissions: 9.7K
# Testcase Example:  '["Hello","Alaska","Dad","Peace"]'
#
# 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
#
#
#
#
#
#
#
# 示例：
#
# 输入: ["Hello", "Alaska", "Dad", "Peace"]
# 输出: ["Alaska", "Dad"]
#
#
#
#
# 注意：
#
#
# 你可以重复使用键盘上同一字符。
# 你可以假设输入的字符串将只包含字母。
#
#
from typing import List

class Solution:
    def __init__(self):
        self.key_row_dict = {}
        self.init_key_dict()

    # 给每个字母添加对应的行标识
    def init_key_dict(self):
        keys = ['qwertyuiop', 'asdfghjkl', 'zxcvbnm']
        for row_index in range(len(keys)):
            row = keys[row_index]
            for ch in row:
                upperCh = ch.upper()
                self.key_row_dict[ch] = row_index
                self.key_row_dict[upperCh] = row_index

    def findWords(self, words: List[str]) -> List[str]:
        if words is None or len(words) == 0:
            return []
        
        result = []
        for word in words:
            if self.detect(word):
                result.append(word)
        
        return result

    # 检测一个单词的所有字母是否在同一行
    def detect(self, word: str)->bool:
        length = len(word)
        if length == 0:
            return False
        elif length == 1:
            return True
        
        row_index = self.key_row_dict[word[0]]
        for ch in word:
            if self.key_row_dict[ch] != row_index:
                return False
        
        return True

