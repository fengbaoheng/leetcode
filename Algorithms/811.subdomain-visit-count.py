#
# @lc app=leetcode.cn id=811 lang=python3
#
# [811] 子域名访问计数
#
from typing import List


class Solution:
    def subdomainVisits(self, cpdomains: List[str]) -> List[str]:
        # 解析记录字符串
        def resolveCpdomain(cpdomain: str):
            count, domain = cpdomain.split(" ")
            count = int(count)
            return (count, domain)

        # 转换记录字符串
        def generateCpdamain(count: int, domain: str) -> str:
            return str(count) + " " + domain

        # 将一个长域名拆分为多个短域名
        def splitDomain(domain: str) -> List[str]:
            segments = domain.split(".")

            domainList = []
            length = len(segments)
            for i in range(length):
                domainList.append(".".join(segments[i:]))

            return domainList

        domainDict = {}

        # 统计次数
        for cpdomain in cpdomains:
            count, longDomain = resolveCpdomain(cpdomain)
            domainList = splitDomain(longDomain)

            for domain in domainList:
                if domain in domainDict:
                    domainDict[domain] += count
                else:
                    domainDict[domain] = count

        # 拼接结果
        result = []
        for domain, count in domainDict.items():
            result.append(generateCpdamain(count, domain))
        return result


if __name__ == "__main__":
    print(
        Solution().subdomainVisits(
            ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
        )
    )
