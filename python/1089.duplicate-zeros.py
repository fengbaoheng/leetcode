#
# @lc app=leetcode.cn id=1089 lang=python3
#
# [1089] 复写零
#
from typing import List


class Solution:
    # 关键: 从后向前写
    def duplicateZeros(self, arr: List[int]) -> None:
        length = len(arr)

        if length == 0:
            return

        # 扫描一遍判断有几个零
        count = 0
        for num in arr:
            if num == 0:
                count += 1

        if count == 0:
            return

        # 从后向前有count个零就后移count位
        # 遇见零时将count-1, 当count为0时结束
        for i in range(length-1, -1, -1):
            num = arr[i]
            j = i + count

            if j < length:
                arr[j] = num

            if num == 0:
                if j - 1 < length:
                    arr[j - 1] = 0

                count -= 1
                if count == 0:
                    return


if __name__ == "__main__":
    arr = [8, 4, 5, 0, 0, 0, 0, 7]
    Solution().duplicateZeros(arr)
    print(arr)
