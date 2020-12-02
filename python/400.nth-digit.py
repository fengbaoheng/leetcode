#
# @lc app=leetcode.cn id=400 lang=python3
#
# [400] 第N个数字
#
import math


class Solution:
    def findNthDigit(self, n: int) -> int:
        if n <= 0:
            return -1

        d = 1
        digits = self.digit_count(d)
        count = 0
        while (count + digits) < n:
            count += digits
            d += 1
            digits = self.digit_count(d)

        return self.get_digit(d, n - count)

    # n位数字一共包含多少位
    # 1位包含 1-9, 2位包含10-99共90
    def digit_count(self, d: int) -> int:
        if d <= 0:
            return -1
        else:
            count = 9 * int(math.pow(10, d - 1))
            return d * count

    # 给定位数和索引数 返回该索引处的数字
    def get_digit(self, d: int, index: int) -> int:
        start_num = int(math.pow(10, d - 1))

        sub_index = index % d - 1
        num = start_num + (index-1) // d 


        return int(str(num)[sub_index])


if __name__ == "__main__":
    solution = Solution()

    assert solution.findNthDigit(1) == 1
    assert solution.findNthDigit(9) == 9
    assert solution.findNthDigit(10) == 1
    assert solution.findNthDigit(11) == 0
    assert solution.findNthDigit(12) == 1
    assert solution.findNthDigit(13) == 1
    assert solution.findNthDigit(12312) == 5
