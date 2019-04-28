#
# @lc app=leetcode.cn id=860 lang=python3
#
# [860] 柠檬水找零
#
from typing import List


class Solution:
    # 把所有可能的找零情况枚举出来即可
    # 存在多种找零情况时：2张5元和1张10元，优先使用大面值10元
    def lemonadeChange(self, bills: List[int]) -> bool:
        # 记录手上的零钱
        # 最大面额20不用记录，因为不会找出去
        owned = {5: 0, 10: 0}

        for bill in bills:
            if bill == 5:
                owned[5] += 1
            elif bill == 10:
                if owned[5] >= 1:
                    owned[5] -= 1
                    owned[10] += 1
                else:
                    return False
            elif bill == 20:
                # 10+5或5+5+5
                if owned[10] >= 1 and owned[5] >= 1:
                    owned[10] -= 1
                    owned[5] -= 1
                elif owned[5] >= 3:
                    owned[5] -= 3
                else:
                    return False
        return True

