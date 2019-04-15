#
# @lc app=leetcode.cn id=151 lang=python3
#
# [151] 翻转字符串里的单词
#
# https://leetcode-cn.com/problems/reverse-words-in-a-string/description/
#
# algorithms
# Medium (22.67%)
# Total Accepted:    8.5K
# Total Submissions: 36.9K
# Testcase Example:  '"the sky is blue"'
#
# 给定一个字符串，逐个翻转字符串中的每个单词。
# 
# 
# 
# 示例 1：
# 
# 输入: "the sky is blue"
# 输出: "blue is sky the"
# 
# 
# 示例 2：
# 
# 输入: "  hello world!  "
# 输出: "world! hello"
# 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
# 
# 
# 示例 3：
# 
# 输入: "a good   example"
# 输出: "example good a"
# 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
# 
# 
# 
# 
# 说明：
# 
# 
# 无空格字符构成一个单词。
# 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
# 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
# 
# 
# 
# 
# 进阶：
# 
# 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
# 
#
class Solution:
    # 可以直接使用split()分隔单词
    def reverseWords(self, s: str) -> str:
        words = []
        s = s.strip()
        
        isWord = False
        start_i = 0
        for i in range(len(s)):
            c = s[i]
            # 空格分隔
            if c == " ":
                if isWord:
                    isWord = False
                    words.append(s[start_i:i])
            # 单词字母
            else:
                # 若单词开头
                if not isWord:
                    isWord = True
                    start_i = i
        
        # 处理结尾
        if isWord:
            words.append(s[start_i:])

        # 逆序
        words.reverse()
        
        return " ".join(words)


if __name__ == "__main__":
    r = Solution().reverseWords("the sky is blue")
    print(r)
