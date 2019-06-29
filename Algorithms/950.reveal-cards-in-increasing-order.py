#
# @lc app=leetcode.cn id=950 lang=python3
#
# [950] 按递增顺序显示卡牌
#
import unittest
from typing import List


class Solution:
    # 递归处理
    # 拼接时注意奇数偶数的处理逻辑不一致
    def deckRevealedIncreasing(self, deck: List[int]) -> List[int]:
        length = len(deck)

        if length <= 2:
            return deck
        
        deck.sort()

        split = (length + 1) // 2

        front = deck[:split]
        back = self.deckRevealedIncreasing(deck[split:])
        result = []

        if length % 2 == 0:
            for i in range(split):
                result.append(front[i])
                result.append(back[i])
        else:
            end = back.pop()
            back.insert(0, end)

            for i in range(split-1):
                result.append(front[i])
                result.append(back[i])
            
            result.append(front[-1])

        return result

class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.testData = []
        self.solution = Solution()

    def tearDown(self):
        for deck, result in self.testData:
            self.assertListEqual(result, self.solution.deckRevealedIncreasing(deck))

    def test_default_case(self):
        self.testData = [([17, 13, 11, 2, 3, 5, 7], [2, 13, 3, 11, 5, 17, 7])]

    def test_even(self):
        self.testData = [
            (
                [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14],
                [1, 8, 2, 13, 3, 9, 4, 12, 5, 10, 6, 14, 7, 11],
            ),
            (
                [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18],
                [1, 10, 2, 18, 3, 11, 4, 15, 5, 12, 6, 17, 7, 13, 8, 16, 9, 14],
            ),
        ]

    def test_odd(self):
        self.testData = [
            (
                [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15],
                [1, 12, 2, 9, 3, 14, 4, 10, 5, 13, 6, 11, 7, 15, 8],
            ),
            (
                [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19],
                [1, 15, 2, 11, 3, 19, 4, 12, 5, 16, 6, 13, 7, 18, 8, 14, 9, 17, 10],
            ),
        ]


if __name__ == "__main__":
    unittest.main()

