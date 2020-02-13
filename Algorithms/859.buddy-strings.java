/*
 * @lc app=leetcode.cn id=859 lang=java
 *
 * [859] 亲密字符串
 */

// @lc code=start
import java.util.stream.IntStream;

class Solution {
    public boolean buddyStrings(String A, String B) {
        // 判断长度
        // 不同长度, 或长度小于2都不符合要求
        int lenA = A.length();
        int lenB = B.length();
        if (lenA != lenB || lenA < 2) {
            return false;
        }


        // 记录不同之处
        int differentCount = 0;
        char[][] swap = new char[2][2];

        // 记录相同之处的数量及其对应的字母
        int[] sameCount = new int[26];

        for (int i = 0; i < lenA; i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);
            if (a != b) {
                // 已经有2处不同, 不能超过2
                if (differentCount == 2) {
                    return false;
                }
                swap[differentCount][0] = a;
                swap[differentCount][1] = b;
                differentCount++;
            } else {
                // 累加相同字母数量
                sameCount[a - 'a']++;
            }
        }

        switch (differentCount) {
            case 0:
                return IntStream.of(sameCount).anyMatch(c -> c >= 2);
            case 2:
                // 2处不同必须可通过交换互补
                return swap[0][0] == swap[1][1] && swap[0][1] == swap[1][0];
            default:
                return false;
        }
    }
}
// @lc code=end

