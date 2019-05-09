#
# @lc app=leetcode.cn id=535 lang=python
#
# [535] TinyURL 的加密与解密
#


class Codec:

    # 题目只验证字符串被加密解密后是否一致
    # 加密成何种形式并不在意，此题目考察的知识点不明！
    def encode(self, longUrl):
        """Encodes a URL to a shortened URL.

        :type longUrl: str
        :rtype: str
        """
        return longUrl

    def decode(self, shortUrl):
        """Decodes a shortened URL to its original URL.

        :type shortUrl: str
        :rtype: str
        """
        return shortUrl


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(url))
