#
# @lc app=leetcode.cn id=409 lang=python3
#
# [409] 最长回文串
#

import unittest


class Solution:
    def longestPalindrome(self, s: str) -> int:
        length = len(s)

        if length <= 1:
            return length

        count = {}

        for c in s:
            if c not in count:
                count[c] = 0

            count[c] += 1

        max_count = ["", -1]
        for k, v in count.items():
            if v % 2 == 1 and v > max_count[1]:
                max_count = [k, v]

        if max_count[1] == -1:
            # 全是偶数
            return sum(count.values())
        else:
            # 去除最大奇数
            result = max_count[1]
            count.pop(max_count[0])

            # 合并剩余偶数, 以及奇数-1
            for v in count.values():
                if v % 2 == 0:
                    result += v
                else:
                    result += v - 1
            
            return result


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()
        self.data = []

    def tearDown(self):
        for s, result in self.data:
            self.assertEqual(result, self.solution.longestPalindrome(s))

    def test_default(self):
        self.data = [("abccccdd", 7)]

    def test_empty(self):
        self.data = [("", 0)]

    def test_single(self):
        self.data = [("a", 1), ("G", 1)]

    def test_simple(self):
        self.data = [("abcdef", 1), ("aabcde", 3)]

    def test_multi(self):
        self.data = [("aaabbbc", 5), ("aaaaabbbbbccccd", 13)]


if __name__ == "__main__":
    unittest.main()

