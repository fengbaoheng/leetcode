/*
 * @lc app=leetcode.cn id=985 lang=java
 *
 * [985] 查询后的偶数和
 */

// @lc code=start
import java.util.*;

class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sumEven = Arrays.stream(A).filter(n -> n % 2 == 0).sum();

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int val = query[0];
            int index = query[1];

            int cur = A[index];

            // 排出当前数，其余其他所有偶数的和
            int otherEven = cur % 2 == 0 ? sumEven - cur : sumEven;

            // 对值更新
            cur += val;
            A[index] = cur;

            // 计算新的所有偶数和
            // 如果更新后不是偶数，则为上一步计算的其余偶数和
            // 如果更新后是偶数，则添加额外的偶数
            sumEven = cur % 2 == 0 ? otherEven + cur : otherEven;

            result[i] = sumEven;
        }

        return result;
    }
}
// @lc code=end

