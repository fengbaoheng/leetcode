#
# @lc app=leetcode.cn id=1108 lang=python3
#
# [1108] IP 地址无效化
#
class Solution:
    def defangIPaddr(self, address: str) -> str:
        return "[.]".join(address.split("."))

