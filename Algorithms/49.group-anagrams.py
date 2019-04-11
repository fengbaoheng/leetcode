#
# @lc app=leetcode.cn id=49 lang=python3
#
# [49] 字母异位词分组
#
# https://leetcode-cn.com/problems/group-anagrams/description/
#
# algorithms
# Medium (54.87%)
# Total Accepted:    13.8K
# Total Submissions: 25.2K
# Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
#
# 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
#
# 示例:
#
# 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
# 输出:
# [
# ⁠ ["ate","eat","tea"],
# ⁠ ["nat","tan"],
# ⁠ ["bat"]
# ]
#
# 说明：
#
#
# 所有输入均为小写字母。
# 不考虑答案输出的顺序。
#
#
#
from typing import List


class Solution:
    # 每个单词做特征串存入字典
    # 特征串即由该单词组成的字母及个数按序排列的字符串
    # 字母异位词的特征串相同
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        if len(strs) == 0:
            return []

        feature_dict = {}
        for s in strs:
            # 一个单词的特征串
            feature_str = "".join(sorted(s))
            if feature_str in feature_dict:
                feature_dict[feature_str].append(s)
            else:
                feature_dict[feature_str] = [s]

        return list(feature_dict.values())


if __name__ == "__main__":
    print(Solution().groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))

