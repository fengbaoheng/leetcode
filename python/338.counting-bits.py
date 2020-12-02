#
# @lc app=leetcode.cn id=338 lang=python3
#
# [338] 比特位计数
#
from typing import List


class Solution:
    def countBits(self, num: int) -> List[int]:
        try:
            if num < 0:
                return []
            elif num == 0:
                return [0]

            bits = [0 for i in range(num + 1)]
            for i in range(1, num + 1):
                if i % 2 == 0:
                    # 右移一位相当于原数*2, 1的个数不变
                    bits[i] = bits[i // 2]
                else:
                    # 偶数最后一位是0, 比偶数大1的奇数,仅仅最后一位的0变1
                    bits[i] = bits[i - 1] + 1
                    
            return bits

        except Exception as e:
            raise e

