#
# @lc app=leetcode.cn id=781 lang=python3
#
# [781] 森林中的兔子
#
from typing import List


class Solution:
    def numRabbits(self, answers: List[int]) -> int:
        color_dict = {}
        num = 0

        for answer in answers:
            color_count = answer + 1
            color_name = color_count

            # 该种颜色只有一只
            if color_count == 1:
                num += 1
                continue

            # 该种颜色之前是否出现过
            if color_name in color_dict:
                # 使用该颜色一次
                color_dict[color_name] -= 1
                if color_dict[color_name] == 0:
                    color_dict.pop(color_name)
            else:
                num += color_count
                
                # 该颜色可用次数
                color_dict[color_name] = color_count - 1

        return num


if __name__ == "__main__":
    solution = Solution()
    assert 5 == solution.numRabbits([1, 1, 2])
    assert 11 == solution.numRabbits([10, 10, 10])
    assert 0 == solution.numRabbits([])
    assert 6 == solution.numRabbits([2, 2, 2, 2])
    assert 6 == solution.numRabbits([2, 2, 2, 2, 2])
    print("OK")
