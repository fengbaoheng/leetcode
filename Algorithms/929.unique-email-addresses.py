#
# @lc app=leetcode.cn id=929 lang=python3
#
# [929] 独特的电子邮件地址
#
from typing import List


class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
        email_set = set([])

        for email in emails:
            email_set.add(self.convert_email(email))

        return len(email_set)

    # 转换为标准的email格式
    def convert_email(self, email: str) -> str:
        host, domain = email.split("@")

        host = host.split("+")[0]
        host = host.replace(".", "")

        return "{}@{}".format(host, domain)


if __name__ == "__main__":
    emails = [
        "tes+t.email+alex@leetcode.com",
        "test.e.mail+bob.cathy@leetcode.com",
        "testemail+david@lee.tcode.com",
    ]
    print(Solution().numUniqueEmails(emails))

