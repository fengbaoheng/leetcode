#
# @lc app=leetcode.cn id=551 lang=python3
#
# [551] 学生出勤记录 I
#
class Solution:
    def checkRecord(self, s: str) -> bool:
        try:
            length = len(s)
            if length <= 2:
                return True

            count = 0
            for i in range(length):
                if s[i] == 'A':
                    count += 1
                    if count > 1:
                        return False
                elif s[i] == 'L':
                    if i <= length -3 and s[i+1] =="L" and s[i+2] == "L":
                        return False

            return True
        except Exception as e:
            raise e

        
        

