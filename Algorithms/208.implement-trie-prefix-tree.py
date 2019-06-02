#
# @lc app=leetcode.cn id=208 lang=python3
#
# [208] 实现 Trie (前缀树)
#


class Trie:
    def __init__(self):
        self.root = {}

    # 使用树结构, 一层存储一个字母
    # 使用end作为单词的结束标记
    def insert(self, word: str) -> None:
        r = self.root
        for c in word:
            if c not in r:
                r[c] = {}
            r = r[c]

        r["end"] = True

    # 一层层迭代, 到最后一层时,判断是否存在单词结束标志
    def search(self, word: str) -> bool:
        r = self.root
        for c in word:
            if c in r:
                r = r[c]
            else:
                return False

        return "end" in r and r["end"] == True

    # 迭代层时,如果层均存在即可
    def startsWith(self, prefix: str) -> bool:
        r = self.root
        for c in prefix:
            if c in r:
                r = r[c]
            else:
                return False
        return True


if __name__ == "__main__":
    trie = Trie()

    trie.insert("apple")
    assert trie.search("apple") == True
    assert trie.search("app") == False
    assert trie.startsWith("app") == True

    trie.insert("app")
    assert trie.search("app") == True

    print("pass")
