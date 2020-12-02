#
# @lc app=leetcode.cn id=693 lang=python3
#
# [693] 交替位二进制数
#
class Solution:
    # 循环二进制
    def hasAlternatingBits(self, n: int) -> bool:
        if n <= 0:
            return False

        while n:
            last2 = n & 0x3
            if last2 == 1 or last2 == 2:
                n = n >> 1
            else:
                return False

        return True


if __name__ == "__main__":
    solution = Solution()

    assert solution.hasAlternatingBits(5) == True
    assert solution.hasAlternatingBits(10) == True
    assert solution.hasAlternatingBits(4) == False
    assert solution.hasAlternatingBits(7) == False
    assert solution.hasAlternatingBits(11) == False
