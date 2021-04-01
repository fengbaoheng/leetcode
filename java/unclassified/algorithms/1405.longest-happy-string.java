import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1405 lang=java
 *
 * [1405] 最长快乐字符串
 */

// @lc code=start
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        Ch[] chList = { new Ch('a', a), new Ch('b', b), new Ch('c', c) };

        StringBuilder result = new StringBuilder();

        while (true) {
            // 按剩余次数排序，尽可能使用剩余最多的字符
            Arrays.sort(chList);
            Ch ch = null;
            int i = result.length();
            for (Ch item : chList) {
                if (item.canUse(i)) {
                    ch = item;
                    break;
                }
            }

            if (ch == null) {
                break;
            }
            result.append(ch.use(i));
        }

        return result.toString();
    }
}

class Ch implements Comparable<Ch> {
    int count;
    char c;

    // 记录最近两次使用的位置
    int[] used = { Integer.MIN_VALUE, Integer.MIN_VALUE };

    public Ch(char c, int count) {
        this.c = c;
        this.count = count;
    }

    public boolean canUse(int i) {
        if (count <= 0) {
            return false;
        }

        // 最近两次未被使用
        if (used[0] == i - 1 && used[1] == i - 2) {
            return false;
        }
        return true;
    }

    // 使用该字符一次，记录剩余次数与位置
    public char use(int i) {
        count--;
        used[1] = used[0];
        used[0] = i;
        return this.c;
    }

    @Override
    public int compareTo(Ch o) {
        return o.count - this.count;
    }
}
// @lc code=end
