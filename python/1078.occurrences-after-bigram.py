#
# @lc app=leetcode.cn id=1078 lang=python3
#
# [1078] Bigram 分词
#

from typing import List


class Solution:
    # 考虑first == second的情况
    # 逐个匹配
    def findOcurrences(self, text: str, first: str, second: str) -> List[str]:
        words = text.split(" ")
        length = len(words)

        if length <= 2:
            return []

        result = []
        for i in range(length - 2):
            first_word, second_word = words[i], words[i + 1]
            if first_word == first and second_word == second:
                result.append(words[i + 2])
        
        return result

