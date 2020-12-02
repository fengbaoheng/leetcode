#
# @lc app=leetcode.cn id=709 lang=python3
#
# [709] 转换成小写字母
#


class Solution:
    def toLowerCase(self, str: str) -> str:
        try:
            length = len(str)
            if length == 0:
                return ""

            a = ord('a')
            s = []
            for c in str:
                if 'A' <= c <= 'Z':
                    s.append(chr(ord(c)-ord('A')+ord('a')))
                else:
                    s.append(c)

            return "".join(s)

        except:
            return ""
