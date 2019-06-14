#
# @lc app=leetcode.cn id=322 lang=python3
#
# [322] 零钱兑换
#
from typing import List


class Solution:
    # 动态规划
    def coinChange(self, coins: List[int], amount: int) -> int:
        if len(coins) == 0 or amount <= 0:
            return 0

        dp = [-1 for i in range(amount + 1)]

        for i in range(1, amount + 1):
            result = []
            for coin in coins:
                # 硬币超过余额 不可兑换
                if coin > i:
                    continue
                # 恰好相等 直接为1 不需要继续遍历
                if coin == i:
                    result.append(1)
                    break
                # 硬币小于余额
                else:
                    sub_amount = i - coin
                    sub_coins = dp[sub_amount]
                    if sub_coins != -1:
                        result.append(sub_coins + 1)

            # 选择最小的兑换方案
            if result:
                dp[i] = min(result)
            else:
                dp[i] = -1

        return dp[amount]


if __name__ == "__main__":
    print(Solution().coinChange([1, 2, 5], 100))

