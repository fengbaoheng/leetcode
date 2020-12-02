#
# @lc app=leetcode.cn id=1054 lang=python3
#
# [1054] 距离相等的条形码
#

from typing import List
from collections import Counter


class Solution:
    # 统计数字出现的次数
    # 设出现最多的数字位num, 共出现了count次
    # 则拆分为count组数字, 初始时每组数字仅有一个数字num
    # 将剩余的其它数字numi依次插入到每组中
    # 即保证相同数字之间尽可能被隔开
    # 例如: [1,1,1,1,2,2,2,2,3,3,3,4,4,5]
    # [1,1,1,1]
    # [1,2,1,2,1,2,1,2]
    # [1,2,3,1,2,3,1,2,3,1,2]
    # [1,2,3,4,1,2,3,4,1,2,3,1,2,4]
    # [1,2,3,4,1,2,3,4,1,2,3,5,1,2,4]
    def rearrangeBarcodes(self, barcodes: List[int]) -> List[int]:
        try:
            if not barcodes:
                return []

            length = len(barcodes)
            if length <= 1:
                return barcodes

            counter = Counter(barcodes)
            num, count = counter.most_common(1)[0]

            # 分组
            group = [[num] for i in range(count)]

            # 剩余所有的数字,依次插入分组中
            counter.pop(num)
            i = 0
            for num_i, count_i in counter.items():
                for c in range(count_i):
                    group[i].append(num_i)
                    i += 1
                    i %= count

            # 每个组合并
            result = []
            for g in group:
                result.extend(g)

            return result
        except Exception as e:
            raise e


if __name__ == "__main__":
    print(Solution().rearrangeBarcodes([1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5]))

