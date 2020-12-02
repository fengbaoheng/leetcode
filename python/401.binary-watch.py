#
# @lc app=leetcode.cn id=401 lang=python3
#
# [401] 二进制手表
#
# https://leetcode-cn.com/problems/binary-watch/description/
#
# algorithms
# Easy (45.62%)
# Total Accepted:    3.1K
# Total Submissions: 6.7K
# Testcase Example:  '0'
#
# 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
# 
# 每个 LED 代表一个 0 或 1，最低位在右侧。
# 
# 
# 
# 例如，上面的二进制手表读取 “3:25”。
# 
# 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
# 
# 案例:
# 
# 
# 输入: n = 1
# 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16",
# "0:32"]
# 
# 
# 
# 注意事项:
# 
# 
# 输出的顺序没有要求。
# 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
# 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
# 
# 
#
from typing import List

class Solution:
    def __init__(self):
        self.hour_light_dict = self.count_light(12)
        self.minute_light_dict = self.count_light(60)

        self.max_hour_light = max(self.hour_light_dict.keys())
        self.max_minute_light = max(self.minute_light_dict.keys())
    
    # 输入十进制数,输出二进制数中1的个数即亮灯的个数
    def count_light(self, max_range:int):
        d = {}
        for i in range(max_range):
            count = list(bin(i)[2:]).count('1')
            if count in d:
                d[count].append(i)
            else:
                d[count] = [i]
        return d

    # 将亮灯数按时钟和分钟拆分两部分
    def split_light_count(self, num:int):
        splited = []
        for i in range(num+1):
            h = i
            m = num - i
            if h > self.max_hour_light or m > self.max_minute_light:
                continue
            splited.append([h, m])
        return splited


    # 把所有可能的情况列出
    def readBinaryWatch(self, num: int) -> List[str]:
        splited_light_count = self.split_light_count(num)
       
        results = []
        for light_count in splited_light_count:
            hour_light_count, minute_light_count = light_count
            hours = self.hour_light_dict[hour_light_count]
            minutes = self.minute_light_dict[minute_light_count]

            # 组合所有的时分
            for h in hours:
                for m in minutes:
                    results.append("{0}:{1:0>2}".format(h,m))
        
        return results

if __name__ == "__main__":
    print(Solution().readBinaryWatch(1))


       

    
        

