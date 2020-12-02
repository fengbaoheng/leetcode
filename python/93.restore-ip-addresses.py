#
# @lc app=leetcode.cn id=93 lang=python3
#
# [93] 复原IP地址
#
# https://leetcode-cn.com/problems/restore-ip-addresses/description/
#
# algorithms
# Medium (43.25%)
# Total Accepted:    6.8K
# Total Submissions: 15.6K
# Testcase Example:  '"25525511135"'
#
# 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
#
# 示例:
#
# 输入: "25525511135"
# 输出: ["255.255.11.135", "255.255.111.35"]
#
#
from typing import List


class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        splited = self.split_ip(s, 4)
        results = []
        for sp in splited:
            results.append(".".join(sp))
        return results

    # 把指定字符串拆分为N段
    def split_ip(self, s: str, ip_count: int = 4) -> List[str]:
        if not self.is_length_valid(s, ip_count):
            return []

        # 递归终止条件
        if ip_count == 1:
            if self.is_ip_valid(s):
                return [[s]]
            else:
                return []

        # 递归拆分 1-3位 + 后续
        results = []
        for i in range(1, 4):
            sub_s = s[:i]
            if self.is_ip_valid(sub_s):
                sub_results = self.split_ip(s[i:], ip_count - 1)
                for result in sub_results:
                    result.insert(0, sub_s)
                results.extend(sub_results)

        return results

    # 每个ip段最少1位,最长3位
    def is_length_valid(self, s: str, ip_count: int) -> bool:
        return ip_count <= len(s) <= ip_count * 3

    # 单个ip段数字是否有效 0-255
    def is_ip_valid(self, s: str) -> bool:
        length = len(s)

        # 单个ip长度为1-3位
        if length == 0 or length > 3:
            return False

        # 开头不能为0
        if s[0] == "0" and length != 1:
            return False

        # 如果是3位数,还要判断是否超过255
        if length == 3 and int(s) > 255:
            return False

        return True


if __name__ == "__main__":
    print(Solution().restoreIpAddresses("25525511135"))
    print(Solution().restoreIpAddresses("0000"))

