#
# @lc app=leetcode.cn id=506 lang=python3
#
# [506] 相对名次
#
from typing import List


class Solution:
    # 使用(分数, 索引, 排名)记录数据
    # 先对分数排序,得到排名;再按索引排序回到原顺序输出结果
    # 注意: nums 可能为空数组, 排名是字符串
    def findRelativeRanks(self, nums: List[int]) -> List[str]:
        try:
            length = len(nums)
            if length == 0:
                return []
            elif length == 1:
                return ["Gold Medal"]

            # [分数, 索引, 排名]
            tmp = [[nums[i], i, -1] for i in range(length)]

            # 按分数排序, 降序
            tmp.sort(key=lambda t: t[0], reverse=True)

            # 排序赋予排名
            for i in range(length):
                tmp[i][2] = i+1

            # 修改前三名数据
            tmp[0][2] = "Gold Medal"
            tmp[1][2] = "Silver Medal"
            if length >= 3:
                tmp[2][2] = "Bronze Medal"

            # 恢复原顺序
            tmp.sort(key=lambda t: t[1])

            # 输出
            return list(map(lambda t: str(t[2]), tmp))
        except Exception as e:
            raise e

