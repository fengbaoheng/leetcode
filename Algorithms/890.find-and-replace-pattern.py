#
# @lc app=leetcode.cn id=890 lang=python3
#
# [890] 查找和替换模式
#
from typing import List


class Solution:
    # 注意需要双向映射
    # 例如“ccc” ！= “abb”  “cdcd” ！= “aaaa”
    # 注意空字符串（题目中条件规定了长度都大于1）
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        results = []
        for word in words:
            if self.can_match(word, pattern):
                results.append(word)
        return results

    def can_match(self, word: str, pattern: str):
        length = len(word)

        w_p = {}
        p_w = {}
        for i in range(length):
            w, p = word[i], pattern[i]
            # 字符 同在映射 或 同不在映射
            if w not in w_p and p not in p_w:
                w_p[w] = p
                p_w[p] = w
            elif w in w_p and p in p_w:
                # 检查映射是否正确
                if w_p[w] != p or p_w[p] != w:
                    return False
            else:
                return False
        return True
