/*
 * @lc app=leetcode.cn id=1248 lang=java
 *
 * [1248] 统计「优美子数组」
 */

// @lc code=start
import java.util.*;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // 统计每个奇数左右侧的偶数个数
        List<int[]> oddCounts = new ArrayList<>();
        int evenCount = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                if (!oddCounts.isEmpty()) {
                    oddCounts.get(oddCounts.size() - 1)[1] = evenCount;
                }
                oddCounts.add(new int[]{evenCount, 0});
                evenCount = 0;
            }
        }

        // 更新最后一个奇数数据
        if (!oddCounts.isEmpty()) {
            oddCounts.get(oddCounts.size() - 1)[1] = evenCount;
        }

        int sum = 0;
        for (int i = k - 1; i < oddCounts.size(); i++) {
            int[] firstOdd = oddCounts.get(i - k + 1);
            int[] lastOdd = oddCounts.get(i);

            int leftEven = firstOdd[0];
            int rightEven = lastOdd[1];

            sum += (1 + leftEven) * (1 + rightEven);
        }

        return sum;
    }
}
// @lc code=end

