/*
 * @lc app=leetcode.cn id=1013 lang=java
 *
 * [1013] 将数组分成和相等的三个部分
 */

// @lc code=start
import java.util.*;

class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int len = A.length;
        if (len < 3) {
            return false;
        }

        // 计算前缀累计和
        int[] sum = Arrays.copyOf(A, len);
        for (int i = 1; i < len; i++) {
            sum[i] += sum[i - 1];
        }

        // 分为3份 
        int totalSum = sum[len - 1];
        if (totalSum % 3 != 0) {
            return false;
        }
        int singlePartSum = totalSum / 3;
        int doublePartSum = singlePartSum + singlePartSum;

        // 从后向前依次找到单倍分割点和双倍分割点
        // 通过累计和快速判断
        boolean findDoublePart = false;
        for (int i = sum.length - 2; i >= 0; i--) {
            if (findDoublePart && sum[i] == singlePartSum) {
                return true;
            } else if (sum[i] == doublePartSum) {
                findDoublePart = true;
            }
        }

        return false;
    }
}
// @lc code=end

